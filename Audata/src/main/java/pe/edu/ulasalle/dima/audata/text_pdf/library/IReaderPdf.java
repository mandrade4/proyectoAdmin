package pe.edu.ulasalle.dima.audata.text_pdf.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;


public interface IReaderPdf {
	
	public String readPDF( byte[] fstream )throws IOException;
	
	public String readPDF(byte[] fstream, String pagIni, String pagFin)throws FileNotFoundException,IOException;

	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin) throws IOException;
	
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String[] listStop) throws IOException;
	
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList) throws IOException;	

	public String readPDF(byte[] fstream, String[] stopList) throws IOException;
	
	public int numeroPaginas( byte[] fstream) throws IOException;
	
	public ArrayList<String> listaBookmark(byte[] fstream) throws IOException;

	public String leerBookmark(byte[] inputStream, String bookmark) throws IOException;
	
	public String leerBookmark(byte[] inputStream, String bookmark, String[] stopList) throws IOException;
	
	public int bookmarkPagIni ( byte[] fstream, String bookmark) throws IOException;
	
	public int bookmarkPagFin ( byte[] fstream, String bookmark) throws IOException;
	
	public String readPDF( byte[] fstream, String page) throws IOException;

	/*
	 * FUNCIONES EXTRA
	 */
	
	public LinkedHashMap<String, Integer> listBookmark (PDOutlineNode bookmark, 
			LinkedHashMap<String,Integer> listBookmarks) throws IOException;
	
	public String reverseCadena(String cadena);

	public String stoplist(String cadena, String[] stopList);
	
	public LinkedHashMap<PDOutlineItem, Integer> bookmarksInfo(LinkedHashMap<PDOutlineItem, Integer> map,
			PDOutlineNode bookmark, Integer level) throws IOException;
	
	public int getLevel(LinkedHashMap<PDOutlineItem, Integer> map, String bookmark);
	
}
