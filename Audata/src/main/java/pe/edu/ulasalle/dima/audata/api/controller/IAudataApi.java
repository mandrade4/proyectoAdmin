package pe.edu.ulasalle.dima.audata.api.controller;

import java.io.IOException;

public interface IAudataApi {
	
	//Marco
	public byte[] mp3(String text); 
	
	public byte[] aac(String text);
	
	public byte[] mp3Pdf( byte[] fstream, String pagina) throws IOException;
	
	//25-06
	public byte[] mp3Pdf( byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList ) throws IOException;
	
	public byte[] mp3PdfBookmark( byte[] fstream, String bookmark, String[] stopList) throws IOException;
	
	public byte[] mp3Pdf( byte[] fstream, String pagIni, String pagFin, String strIni, String strFin ) throws IOException; 

	public byte[] mp3Pdf ( byte[] fstream ) throws IOException;
	
	//Chino
	
	public byte[] mp3Pdf( byte[] fstream, String pagIni, String pagFin)throws IOException;
	
	public byte[] mp3PdfBoomark( byte[] fstream, String bookmark)throws IOException;
	
	public byte[] mp3Pdf( byte[] fstream, String pagIni, String pagFin, String[] stopList)throws IOException;
	
	public byte[] mp3Pdf( byte[] fstream, String[] stopList)throws IOException;
	
	public byte[] aacPdf( byte[] fstream, String pagIni, String pagFin, String strIni, String strFin)throws IOException;
	
	//jeanpol
	public byte[] aacPdf( byte[] fstream, String pag)throws IOException;
	
	public byte[] aacPdf( byte[] fstream, String[] stopList)throws IOException;
	
	public byte[] aacPdf( byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList)throws IOException;
	
	public byte[] aacPdf( byte[] fstream, String pagIni, String pagFin)throws IOException;
	
	public byte[] aacPdfBoomark( byte[] fstream, String bookmark)throws IOException;
		
	//edu
	
	public byte[] aacPdfTitle(byte[] fstream, String title) throws IOException;
	
	public byte[] mp3HtmlSinTags(String text) throws IOException;
	
	public byte[] mp3HtmlTagContents(String text, String tag) throws IOException;
	
	public byte[] mp3HtmlTagContents(String text, String tag, String[] stopTagList, String[] stopTagContentList) throws IOException;
	
	public byte[] mp3Html(String text, String divisor) throws IOException;

	public byte[] aacHtmlSinTags(String text, String tag) throws IOException;
	
	public byte[] aacHtmlTagContents(String text, String tag) throws IOException;
	
	public byte[] aacHtmlTagContents(String text, String tag, String[] stopTagList, String[] stopTagContentList) throws IOException;
	
	public byte[] aacPdf(byte[] fstream) throws IOException;

}
