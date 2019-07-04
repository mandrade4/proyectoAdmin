package pe.edu.ulasalle.dima.audata.text_pdf.engine;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ReaderPdfImplEngine implements IReaderPdfEngine {

	//PDF ENGINE
	public String readPDF(byte[] fstream) throws IOException {
		
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();
		
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition(true);

        PDFTextStripper tStripper = new PDFTextStripper();

        String pdfFileInText = tStripper.getText(document);

        String lines[] = pdfFileInText.split("\\r?\\n");
        for (String line : lines) {
        	str.append(line);            
        }
        
		return str.toString();
		
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin) throws FileNotFoundException, IOException {
		try {
			
			int pInit = Integer.parseInt(pagIni);
			int pFin  = Integer.parseInt(pagFin);
			System.out.println(pInit+" "+pFin);
			
			if((0<pInit && pInit<=numeroPaginas(fstream)) && (0<pFin && pFin<=numeroPaginas(fstream)) && (pInit<=pFin)) {
				InputStream instream = new ByteArrayInputStream(fstream);
				PDDocument document = PDDocument.load(instream);
				StringBuilder str = new StringBuilder();
				
				document.getClass();
		
				if (!document.isEncrypted()) {
					
			          PDFTextStripper tStripper = new PDFTextStripper();
			
			          tStripper.setStartPage(pInit);
			          tStripper.setEndPage(pFin);
			          
			          String pdfFileInText = tStripper.getText(document);
			
			          String lines[] = pdfFileInText.split("\\r?\\n");
			          for (String line : lines) {
			          	str.append(line);
			          }
				}
				return str.toString();
			}
			else {
				return "error intervalos de pagina no valido";
			}
		}catch (NumberFormatException nfe){
			return "error ingresar solo numeros";
		}
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin) throws IOException {
		
		try {
			int pInit = Integer.parseInt(pagIni);
			int pFin  = Integer.parseInt(pagFin);
			
			if((0<pInit && pInit<=numeroPaginas(fstream)) && (0<pFin && pFin<=numeroPaginas(fstream)) && (pInit<=pFin)){
				String cadena = readPDF(fstream,pagIni,pagFin);
				cadena = cadena.toLowerCase();
				strIni = strIni.toLowerCase();
				strFin = strFin.toLowerCase();
				if(cadena.contains(strIni)== true && cadena.contains(strFin)==true) {

					int posicionInicio = cadena.indexOf(strIni);
					cadena = cadena.substring(posicionInicio);
					  
					cadena = reverseCadena(cadena);
					strFin = reverseCadena(strFin);
					  
					int posicionfin = cadena.indexOf(strFin);
					cadena = cadena.substring(posicionfin);
					cadena = reverseCadena(cadena);
					  
					return cadena.toLowerCase();
					
				}
				else {
					return "palabra no encontrada";
				}
			}
			else {
				return "error intervalos de pagina no valido";
			}
			
		}catch (NumberFormatException nfe){
			return "error ingresar solo numeros";
		}

	}
	
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String[] listStop) throws IOException {
		
		String cadena = readPDF(fstream,pagIni,pagFin);
		String cadena2 = stoplist(cadena, listStop);
		return cadena2;

	}
	
	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList)
			throws IOException {
		
		String cadena = readPDF(fstream,pagIni,pagFin,strIni,strFin);
		String cadena2 = stoplist(cadena, stopList);
	    
	    return cadena2;
	}
	
	public String readPDF(byte[] fstream, String[] stopList) throws IOException {
		
		String cadena = readPDF(fstream);
		String cadena2 = stoplist(cadena, stopList);
		return cadena2;
		
	}
	
	@Override
	public int numeroPaginas(byte[] fstream) throws IOException {
		
		InputStream instream = new ByteArrayInputStream(fstream);
		int count = 0;
		
		try (PDDocument document = PDDocument.load(instream)){
			if (!document.isEncrypted()) {
				count = document.getNumberOfPages();	
				return count;
			}
		} catch (Exception e) {
			System.err.println("Documento encriptado!");
		}
		
		return count;
	}
	
	public ArrayList<String> listaBookmark(byte[] fstream) throws IOException{
		
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);
		PDDocumentOutline outline =  document.getDocumentCatalog().getDocumentOutline();
		
		LinkedHashMap<String,Integer> listBookmark = new LinkedHashMap<String,Integer>();
		listBookmark(outline,listBookmark);
		
		ArrayList<String> listaBookmark = new ArrayList<String>();
		for(Map.Entry<String,Integer> iter : listBookmark.entrySet()) {
			listaBookmark.add(iter.getKey());
		}
		
		return listaBookmark;
		
	}
	
	public String leerBookmark(byte[] inputStream, String bookmark) throws IOException{
		
		InputStream instream = new ByteArrayInputStream(inputStream);
		PDDocument doc = PDDocument.load(instream);
		PDDocumentOutline outlines = doc.getDocumentCatalog().getDocumentOutline();
		
		if (outlines == null) {
			return "Este documento no contiene marcadores";
		}
		
        LinkedHashMap<PDOutlineItem,Integer> listBookMarks = new LinkedHashMap<PDOutlineItem,Integer>();
        bookmarksInfo(listBookMarks, outlines, 0);		
        Integer lvlIni = 0; 
        Integer lvlEnd = 0;
        PDOutlineItem ini = null; 
        PDOutlineItem end = null;
        
        for (Map.Entry<PDOutlineItem, Integer> iter : listBookMarks.entrySet()) {
        	
        	lvlEnd = iter.getValue();
        	if(lvlIni - lvlEnd > 0) {
        		end = iter.getKey();
        		break;
        	} 
        	
        	if (lvlIni != 0 && lvlIni == iter.getValue()) {
        		end = iter.getKey();
        		break;
        	} else if (iter.getKey().getTitle().equals(bookmark)) {
        		lvlIni = iter.getValue();
        		ini = iter.getKey();
        	} 
        }
        
        if(ini == null) {
    		return "Marcador no encontrado";
        }
        
        PDFTextStripper stripper = new PDFTextStripper();
		
		stripper.setStartBookmark(ini);
		
		if (end != null) {
			stripper.setEndBookmark(end);
			
			String pdfFileInText = stripper.getText(doc);
			int posicionInicio = pdfFileInText.indexOf(ini.getTitle());
			pdfFileInText = pdfFileInText.substring(posicionInicio);
			
			pdfFileInText = reverseCadena(pdfFileInText);
			String strFin = reverseCadena(end.getTitle());

			int posicionFin = pdfFileInText.indexOf(strFin);
			pdfFileInText = pdfFileInText.substring(posicionFin);
			pdfFileInText = reverseCadena(pdfFileInText);
			
			return pdfFileInText.replace(end.getTitle(), "");
		}
		
		String pdfFileInText = stripper.getText(doc);
		
		return pdfFileInText;
		
	}
		
	public String leerBookmark(byte[] inputStream, String bookmark, String[] stopList) throws IOException{
		
		String temp = leerBookmark (inputStream, bookmark);
	    temp = temp.toLowerCase();
	    
	    String cadena = stoplist(temp,stopList);
	    
	    return cadena;
	}
	
	@Override
	public int bookmarkPagIni(byte[] fstream, String bookmark) throws IOException {
		
		InputStream instream = new ByteArrayInputStream(fstream);
    	PDDocument doc = PDDocument.load(instream);
        PDDocumentOutline outline =  doc.getDocumentCatalog().getDocumentOutline();
        
        LinkedHashMap<String,Integer> listBookmarks = new LinkedHashMap<String,Integer>();
		listBookmark(outline,listBookmarks);
		
		return listBookmarks.get(bookmark);
		
	}
	
	public int bookmarkPagFin(byte[] fstream, String bookmark) throws IOException {
		
		InputStream instream = new ByteArrayInputStream(fstream);
    	PDDocument doc = PDDocument.load(instream);
        PDDocumentOutline outline =  doc.getDocumentCatalog().getDocumentOutline();
        outline.openNode();
        
        LinkedHashMap<PDOutlineItem,Integer> map = new LinkedHashMap<PDOutlineItem,Integer>();
        LinkedHashMap<String,Integer> listB = new LinkedHashMap<String,Integer>();
        listBookmark(outline,listB);
        map = bookmarksInfo(map,outline,0);

        int nivel = getLevel(map,bookmark);
        
        List<String> titlesLevel = new ArrayList<String>();
        List<String> keys = new ArrayList<String>(listB.keySet());
        List<Integer> values = new ArrayList<Integer>(listB.values());
                      
    	for(Map.Entry<PDOutlineItem, Integer> iter : map.entrySet()) {
    		if (iter.getValue() == nivel) {
    			titlesLevel.add(iter.getKey().getTitle());
    		}
    	}
    	
    	if(bookmark.equals(titlesLevel.get(titlesLevel.size()-1))) {
    		return values.get(keys.indexOf(bookmark));
    	} else {
    		return values.get(keys.indexOf(titlesLevel.get(titlesLevel.indexOf(bookmark)+1)));
    	}

	}
	
	@Override
	public String readPDF(byte[] fstream, String page) throws IOException {
	
		String result = readPDF(fstream, page, page);
		return result;
	
	}


	/*
	 *FUNCIONES  EXTRA 
	 */
	
	@Override
	public String reverseCadena(String cadena) {
		
		byte [] strAsByteArray = cadena.getBytes();
		byte [] result =  new byte [strAsByteArray.length];
		
		for (int i = 0; i<strAsByteArray.length; i++) {
			result[i] =  strAsByteArray[strAsByteArray.length-i-1];
		}
		
		return new String(result);

	}
	
	public LinkedHashMap<String,Integer> listBookmark(PDOutlineNode bookmark,
			LinkedHashMap<String, Integer> listBookmarks) throws IOException {
        
		PDOutlineItem current = bookmark.getFirstChild();
        while (current != null) {
            if (current.getDestination() instanceof PDPageDestination) {
                PDPageDestination pd = (PDPageDestination) current.getDestination();
                int rpn = pd.retrievePageNumber()+1;
                listBookmarks.put(current.getTitle(), rpn);
            }
            if (current.getAction() instanceof PDActionGoTo) {
                PDActionGoTo gta = (PDActionGoTo) current.getAction();
                if (gta.getDestination() instanceof PDPageDestination) {
                    PDPageDestination pd = (PDPageDestination) gta.getDestination();
                    int rpn = pd.retrievePageNumber()+1;
                    listBookmarks.put(current.getTitle(), rpn);
                }
                
            }
            listBookmark(current,listBookmarks);
            current = current.getNextSibling();
        }
		return listBookmarks;
	}
	
	public LinkedHashMap<PDOutlineItem, Integer> bookmarksInfo(LinkedHashMap<PDOutlineItem, Integer> map,
			PDOutlineNode bookmark, Integer level) throws IOException {

		PDOutlineItem current = bookmark.getFirstChild();
		while (current != null) {
			level++;
			map.put(current, level);
			bookmarksInfo(map, current, level);
			current = current.getNextSibling();
			level--;
		}

		return map;
	}
	
	public int getLevel(LinkedHashMap<PDOutlineItem, Integer> map, String bookmark) {
        
		List<String> keys = new ArrayList<String>();
    	for(Map.Entry<PDOutlineItem, Integer> iter : map.entrySet()) {
    		keys.add(iter.getKey().getTitle());
    	}
        List<Integer> values = new ArrayList<Integer>(map.values());
    
        return values.get(keys.indexOf(bookmark));
	}

	@Override
	public String stoplist(String cadena, String[] stopList) {
		cadena = cadena.toLowerCase();
		
		for (int i=0; i<stopList.length ;i++) {
			stopList[i] = stopList[i].replaceAll("\r\n", " ");
			stopList[i] = stopList[i].replace("  "," ");
		}
		
		for (int i=0; i<stopList.length ;i++ ){
			
			cadena = cadena.replace(stopList[i].toLowerCase()+ " "," ");
			cadena = cadena.replace(" " + stopList[i].toLowerCase()," ");
			
			cadena = cadena.replace(" " + stopList[i].toLowerCase()+ " "," ");
			cadena = cadena.replace("" + stopList[i].toLowerCase()+ " "," ");
			cadena = cadena.replace(" " + stopList[i].toLowerCase()+ "."," ");
			cadena = cadena.replace(" " + stopList[i].toLowerCase()+ ", "," ");
			cadena = cadena.replace(" " + stopList[i].toLowerCase()+ "; "," ");
			cadena = cadena.replace(" " + stopList[i].toLowerCase()+ ": "," ");
			cadena = cadena.replace(" (" + stopList[i].toLowerCase()+ ") "," ");
			cadena = cadena.replace(" (" + stopList[i].toLowerCase()+ "), "," ");
			cadena = cadena.replace(" (" + stopList[i].toLowerCase()+ "). "," ");
			cadena = cadena.replace(" ¿" + stopList[i].toLowerCase()+ "? "," ");
			cadena = cadena.replace(" <" + stopList[i].toLowerCase()+ "> "," ");
			cadena = cadena.replace("[" + stopList[i].toLowerCase()+ "]"," ");
			cadena = cadena.replace("[" + stopList[i].toLowerCase()+ " ","[");
			cadena = cadena.replace(" " + stopList[i].toLowerCase()+ "] ","]");
			cadena = cadena.replace(" \"" + stopList[i].toLowerCase()+ "\" "," ");
			cadena = cadena.replace(" {" + stopList[i].toLowerCase()+ "} "," ");
			
			System.out.println(stopList[i]);
	    }
	    return cadena;
	}



	
}
