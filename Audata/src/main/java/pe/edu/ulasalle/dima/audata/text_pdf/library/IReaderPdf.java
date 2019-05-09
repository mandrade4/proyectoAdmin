package pe.edu.ulasalle.dima.audata.text_pdf.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;


public interface IReaderPdf {

	public String readPDF( byte[] fstream ) throws FileNotFoundException, IOException;
	
	public String readPDF( byte[] fstream, int pagIni, int pagFin) throws IOException;

	public String readPDF( byte[] fstream, int page) throws IOException;

	public int numeroPaginas( byte[] fstream) throws IOException;
	
	public int bookmarkPagIni ( byte[] fstream, String bookmark) throws IOException;
	
	public int bookmarkPagFin ( byte[] fstream, String bookmark) throws IOException;
	
	public String readPDF(byte[] fstream, String[] listStop) throws IOException;
	
	public String readPDF(byte[] fstream, int pagIni, int pagFin, String[] listStop) throws IOException;
	
	public String readPDF(byte[] fstream, int pagIni, int pagFin, String strIni, String strFin) throws IOException;
	
	public String readPDF(byte[] fstream, int pagIni, int pagFin, String strIni, String strFin, String[] stopList) throws IOException;

	//Funciones adicionales
	public LinkedHashMap<String, Integer> listBookmark (PDOutlineNode bookmark, 
			LinkedHashMap<String,Integer> listBookmarks) throws IOException;
	
	public String reverseCadena(String cadena);

}
