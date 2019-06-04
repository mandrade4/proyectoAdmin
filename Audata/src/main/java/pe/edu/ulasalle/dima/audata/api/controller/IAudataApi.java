package pe.edu.ulasalle.dima.audata.api.controller;

import java.io.IOException;

public interface IAudataApi {
	
	public byte[] mp3(String text); 
	
	public byte[] aac(String text);
	
	public byte[] mp3HtmlSinTags(String text) throws IOException;
	
	public byte[] mp3Pdf( byte[] fstream, String pagina) throws IOException;
}
