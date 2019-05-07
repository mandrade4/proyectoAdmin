package pe.edu.ulasalle.dima.audata.text_pdf.library;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class ReaderPdfImpl implements IReaderPdf {
/*	Requerimientos hechos
 * 	1, 2, 13, 7, 8, 11, 12, 6, 4
 * 	Requerimientos
 * 	3, 5, 9, 10  	
 * */

	/*
	   byte[] d = Files.readAllBytes(Paths.get("D:\\book.pdf"));
       System.out.println(readPDF(d));
	 */
	
	public String readPDF(byte[] fstream) throws IOException {
		
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();

        if (!document.isEncrypted()) {
		
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);

            PDFTextStripper tStripper = new PDFTextStripper();

            String pdfFileInText = tStripper.getText(document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (String line : lines) {
            	str.append(line);
            }
        }
        
		return str.toString();
		
	}

	
	@Override
	public String readPDF(byte[] fstream, int pagIni, int pagFin) throws IOException{
		
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();

        if (!document.isEncrypted()) {
		
            PDFTextStripper tStripper = new PDFTextStripper();

            tStripper.setStartPage(pagIni);
            tStripper.setEndPage(pagFin);
            
            String pdfFileInText = tStripper.getText(document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (String line : lines) {
            	str.append(line);
            }
        }
        
		return str.toString();
	}


	@Override
	public String readPDF(byte[] fstream, int page) throws IOException {
		
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);
    	StringBuilder str = new StringBuilder();
		
		document.getClass();

        if (!document.isEncrypted()) {
		
            PDFTextStripper tStripper = new PDFTextStripper();

            tStripper.setStartPage(page);
            tStripper.setEndPage(page);
            
            
            String pdfFileInText = tStripper.getText(document);

            String lines[] = pdfFileInText.split("\\r?\\n");
            for (String line : lines) {
            	str.append(line);
            }
        }
        
		return str.toString();
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


	@Override
	public int bookmarkPagIni(byte[] fstream, String bookmark) throws IOException {
		InputStream instream = new ByteArrayInputStream(fstream);
    	PDDocument doc = PDDocument.load(instream);
        PDDocumentOutline outline =  doc.getDocumentCatalog().getDocumentOutline();
        
        LinkedHashMap<String,Integer> listBookmarks = new LinkedHashMap<String,Integer>();
		listBookmark(outline,listBookmarks);
		
		return listBookmarks.get(bookmark);
	}


	public LinkedHashMap<String, Integer> listBookmark(PDOutlineNode bookmark,
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

	
	public int bookmarkPagFin(byte[] fstream, String bookmark) throws IOException {
		InputStream instream = new ByteArrayInputStream(fstream);
    	PDDocument doc = PDDocument.load(instream);
        PDDocumentOutline outline =  doc.getDocumentCatalog().getDocumentOutline();
        outline.openNode();
        
        LinkedHashMap<String,Integer> listBookmarks = new LinkedHashMap<String,Integer>();
        listBookmark(outline,listBookmarks);
        List<String> keys = new ArrayList<String>(listBookmarks.keySet());
        List<Integer> values = new ArrayList<Integer>(listBookmarks.values());
		
        if (values.get(keys.indexOf(bookmark))>values.size()) {
        	return values.get(keys.indexOf(bookmark));
        }else {
        	return values.get(keys.indexOf(bookmark)+1);
        }
	
    }
	
	
	public String readPDF(byte[] fstream, String[] listStop) throws IOException {
			
		return readPDF(fstream, -1,  -1, listStop); 
		
	}
		  
		  
	public String readPDF(byte[] fstream, int pagIni, int pagFin, String[] listStop) throws IOException {
		  
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);
		StringBuilder str = new StringBuilder();
		String[] stopLista = listStop;
					
		document.getClass();

		if (!document.isEncrypted()) {
			
			PDFTextStripper tStripper = new PDFTextStripper();
			if (pagIni != -1)
		    tStripper.setStartPage(pagIni);
			if (pagFin != -1)
			tStripper.setEndPage(pagFin);
		    
		    String pdfFileInText = tStripper.getText(document);
		
		    String lines[] = pdfFileInText.split("\\r?\\n");
		    for (String line : lines) {
		    	str.append(line);
		    }
		}
  
		String temp = str.toString();
		temp = temp.toLowerCase();
		  
		for (int i=0; i<stopLista.length ;i++ ){
			temp = temp.replace(" " + stopLista[i].toLowerCase()+ " "," ");
		}
		
		return temp;
	  }

	
}
