package pe.edu.ulasalle.dima.audata.text_pdf.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineNode;


public interface IReaderPdf {

	public String readPDF( FileInputStream fstream ) throws FileNotFoundException, IOException;
	
	public String readPDF( FileInputStream fstream, int pagIni, int pagFin) throws IOException;

	public String readPDF( FileInputStream fstream, int page) throws IOException;

	public int numeroPaginas( FileInputStream fstream) throws IOException;
	
	public int bookmarkPagIni ( FileInputStream fstream, String bookmark) throws IOException;
	
	public int bookmarkPagFin ( FileInputStream fstream, String bookmark) throws IOException;
	
	public LinkedHashMap<String, Integer> listBookmark (PDOutlineNode bookmark, 
			LinkedHashMap<String,Integer> listBookmarks) throws IOException;
}
