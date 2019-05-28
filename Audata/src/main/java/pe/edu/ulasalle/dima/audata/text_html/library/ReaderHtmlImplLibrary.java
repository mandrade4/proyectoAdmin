package pe.edu.ulasalle.dima.audata.text_html.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pe.edu.ulasalle.dima.audata.text_html.engine.IReaderHtmlEngine;
import pe.edu.ulasalle.dima.audata.text_html.engine.ReaderHtmlImplEngine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class ReaderHtmlImplLibrary implements IReaderHtmlLibrary{

	String[] tagList;
	String[] stopTagList;
	String[] stopTagContentList;
	String tagContent;
	
    //Constructor con el mismo nombre de la clase
    public ReaderHtmlImplLibrary(){}

    //Métodos de la clase
    
    public String leerSinTags(String htmlI) throws IOException {
    	IReaderHtmlEngine obj = new ReaderHtmlImplEngine();
		String text = obj.leerSinTags(htmlI); 
		if (!text.isBlank()) {
			return text;
		}else{
			return "El Html no contiene texto";
		}
    }

    public String[] leerTags(String htmlI) throws IOException{
    	ReaderHtmlImplEngine obj = new ReaderHtmlImplEngine();
		String text[] = obj.leerTags(htmlI);
		String[] a = {"El Html no contiene etiquetas"};
		if (text.length>0) {
			return text;
		}else{
			return a;
		}
    }

    public String leerTagContents(String htmlI, String tagI) throws IOException
    {	
    	ReaderHtmlImplEngine obj = new ReaderHtmlImplEngine();
		String text = obj.leerTagContents(htmlI,tagI);
		if (text.isBlank()) {
			return text;
		}else{
			return "La etiqueta no contiene texto";
		}
    }
  
    public String leerTagContents(String htmlI,String tagI,String[] stopTagListI,String[] stopTagContentList) throws IOException
    {
    	ReaderHtmlImplEngine obj = new ReaderHtmlImplEngine();
		String text = obj.leerTagContents(htmlI,tagI,stopTagListI,stopTagContentList);
		if (text.isBlank()) {
			return text;
		}else{
			return "La etiqueta no contiene texto";
		}
    }
    
	public String stopTagList(String [] nombres,String htmlI) throws IOException{ 
    	ReaderHtmlImplEngine obj = new ReaderHtmlImplEngine();
		String text = obj.stopTagList(nombres,htmlI);
		if (text.isBlank()) {
			return text;
		}else{
			return "La(s) palabra(s) no esta(n) en el texto";
		}
 }
    
    public String procesarHTML(String archivo) {
        ReaderHtmlImplEngine obj = new ReaderHtmlImplEngine();
		String text = obj.procesarHTML(archivo);
		if (text.isBlank()) {
			return text;
		}else{
			return "Ingrese un archivo HTML";
		}
	}
	
	public String[] DivisorHtmlPorTag(String htmlI) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String leerSinTagParametros(String html, String a, String b) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> leerSinTagPorFraseTitulo(String html) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
