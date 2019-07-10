package pe.edu.ulasalle.dima.audata.text_pdf.library;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;
import pe.edu.ulasalle.dima.audata.text_pdf.engine.IReaderPdfEngine;
import pe.edu.ulasalle.dima.audata.text_pdf.engine.ReaderPdfImplEngine;


public class ReaderPdfImplLibrary implements IReaderPdfLibrary {

	//FALTA SABER SI ESTA ENCRIPTADO O NO
	@Override
	public String readPDF(byte[] fstream) throws IOException {
		
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.readPDF(fstream); 
		if (!text.isBlank()) {
			return text;
		}else{
			return "El PDF no tiene texto!";
		}
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin) throws FileNotFoundException, IOException {
		
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.readPDF(fstream,pagIni,pagFin); 
		if (!text.isBlank()) {
			return text;
		}else{
			return "El PDF no tiene texto!";
		}
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin)
			throws IOException {
		
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.readPDF(fstream,pagIni,pagFin,strIni,strFin);
		
		if (!text.isBlank()) {
			return text;
		}else{
			return "El PDF no tiene texto!";
		}
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String[] listStop) throws IOException {
		
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.readPDF(fstream,pagIni,pagFin,listStop);
		
		if (!text.isBlank()) {
			return text;
		}else{
			return "El PDF no tiene texto!";
		}
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList)
			throws IOException {
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.readPDF(fstream,pagIni,pagFin,strIni,strFin,stopList);
		
		if (!text.isBlank()) {
			return text;
		}else{
			return "El PDF no tiene texto!";
		}
	}

	@Override
	public String readPDF(byte[] fstream, String[] stopList) throws IOException {

		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.readPDF(fstream,stopList);
		
		if (!text.isBlank()) {
			return text;
		}else{
			return "El PDF no tiene texto!";
		}
		
	}

	@Override
	public int numeroPaginas(byte[] fstream) throws IOException {

		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		int nPaginas = obj.numeroPaginas(fstream);
		return nPaginas;
		
		
	}

	@Override
	public ArrayList<String> listaBookmark(byte[] fstream) throws IOException {
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		ArrayList<String> bookmarks = obj.listaBookmark(fstream);
		ArrayList<String> noBook = new ArrayList<String>();
		noBook.add("No existen marcadores!");
		
		if (bookmarks.size()!=0) {
			return bookmarks;
		}else{
			return noBook;
		}
	}

	@Override
	public String leerBookmark(byte[] inputStream, String bookmark) throws IOException {
		
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(inputStream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.leerBookmark(inputStream,bookmark);
		
		if (!text.isBlank()) {
			return text;
		}else{
			return "El bookmark no tiene texto!";
		}
	}

	@Override
	public String leerBookmark(byte[] inputStream, String bookmark, String[] stopList) throws IOException {

		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(inputStream);
		PDDocument document = PDDocument.load(instream);

		String text = obj.leerBookmark(inputStream,bookmark,stopList);
		
		if (!text.isBlank()) {
			return text;
		}else{
			return "El bookmark no tiene texto!";
		}
	}

	@Override
	public int bookmarkPagIni(byte[] fstream, String bookmark) throws IOException {
		
		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		int pagIni = obj.bookmarkPagIni(fstream, bookmark);
		
		return pagIni; 
		
	}

	@Override
	public int bookmarkPagFin(byte[] fstream, String bookmark) throws IOException {

		IReaderPdfEngine obj = new ReaderPdfImplEngine();
		InputStream instream = new ByteArrayInputStream(fstream);
		PDDocument document = PDDocument.load(instream);

		int pagIni = obj.bookmarkPagFin(fstream, bookmark);
		
		return pagIni; 
		
	}

	@Override
	public String readPDF(byte[] fstream, String page) throws IOException {

		String result = readPDF(fstream, page, page);
		return result;
		
	}

	@Override
	public LinkedHashMap<String, Integer> listBookmark(PDOutlineNode bookmark,
			LinkedHashMap<String, Integer> listBookmarks) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reverseCadena(String cadena) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stoplist(String cadena, String[] stopList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<PDOutlineItem, Integer> bookmarksInfo(LinkedHashMap<PDOutlineItem, Integer> map,
			PDOutlineNode bookmark, Integer level) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLevel(LinkedHashMap<PDOutlineItem, Integer> map, String bookmark) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String cleanText(String cadena) {

		String limpio =null;
        if (cadena !=null) {
            String valor = cadena;
            valor = valor.toLowerCase();
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            limpio = limpio.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
            limpio = limpio.replace("º", " ");
            limpio = limpio.replace("°", " ");
            limpio = limpio.replace("”", " ");
            limpio = limpio.replace("“", " ");
            limpio = limpio.replace("ø", " ");
            limpio = limpio.replace("„", " ");
            limpio = limpio.replace("‟", " ");
            limpio = limpio.replace("'", " ");
        }
        
        limpio = limpio.replaceAll("[^\\x20-\\x7e]", "");
        
        return limpio;
		
	}



}
