package pe.edu.ulasalle.dima.audata.text_html.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IReaderHtml {

	public String leerSinTags( String html ) throws IOException;
	
	public String leer(String html) throws IOException;
	
	public String[] leerTags (String htmlI) throws IOException;
	
	public String leerTagContents ( String htmlI, String tagI) throws IOException;

    public String leerTagContents ( String htmlI, String tagI, String[] stopTagListI,String[] stopTagContentList) throws IOException;
    
    public String stopTagList (String [] nombres, String htmlI) throws IOException;
    
    public String[] DivisorHtmlPorTag(String htmlI) throws IOException;
    
    public String leerSinTagParametros( String html,String a ,String b ) throws FileNotFoundException, IOException;

    public List<String> leerSinTagPorFraseTitulo( String html) throws FileNotFoundException, IOException;

}
