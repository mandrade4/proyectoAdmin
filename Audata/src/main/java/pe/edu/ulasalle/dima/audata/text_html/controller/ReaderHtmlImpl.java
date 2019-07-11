package pe.edu.ulasalle.dima.audata.text_html.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.edu.ulasalle.dima.audata.text_html.library.IReaderHtmlLibrary;
import pe.edu.ulasalle.dima.audata.text_html.library.ReaderHtmlImplLibrary;

public class ReaderHtmlImpl implements IReaderHtml {

	@Override
	public String leerSinTags(String html) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.cleanText(obj.leerSinTags(html));
	}
	
	@Override
	public String leer(String html) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		String x = obj.cleanText(obj.leer(html));
		return x;
	}

	@Override
	public String[] leerTags(String htmlI) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerTags(htmlI);
	}
	
	@Override
	public String[] leerTagsURL(String htmlI) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerTagsURL(htmlI);
	}

	@Override
	public String leerTagContents(String htmlI, String tagI) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.cleanText(obj.leerTagContents(htmlI, tagI));
	}
	
	@Override
	public String leerTagContentsURL(String htmlI, String tagI) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.cleanText(obj.leerTagContentsURL(htmlI, tagI));
	}

	@Override
	public String leerTagContents(String htmlI, String tagI, String[] stopTagListI, String[] stopTagContentList)
			throws IOException {
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		return obj.cleanText(obj.leerTagContents(htmlI, tagI, stopTagListI, stopTagContentList));
	}
	
	@Override
	public List<String> DivisorHtmlPorTagURL(String htmlI) throws IOException {

		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		String listString = String.join(", ", obj.DivisorHtmlPorTagURL(htmlI));
		
		String listFinal = obj.cleanText(listString);
		
		List<String> myList = new ArrayList<String>(Arrays.asList(listFinal.split(",")));
		
		return  myList;
		
	}

	@Override
	public String leerSinTagParametros(String html, String a, String b) throws FileNotFoundException, IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.cleanText(obj.leerSinTagParametros(html, a, b));
	}

	@Override
	public List<String> leerSinTagPorFraseTitulo(String html) throws FileNotFoundException, IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		String listString = String.join(", ", obj.leerSinTagPorFraseTitulo(html));
		
		String listFinal = obj.cleanText(listString);
		
		List<String> myList = new ArrayList<String>(Arrays.asList(listFinal.split(",")));
		
		return  myList;
	}
	
	@Override
	public String leerSinTagURL(String html1) throws IOException{
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.cleanText(obj.leerSinTagURL(html1));
	}
	
	@Override
	public String leerSinTagParametrosURL( String html,String a ,String b ) throws FileNotFoundException, IOException{
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.cleanText(obj.leerSinTagParametrosURL(html, a, b));
	}
	
	@Override
	public List<String> leerSinTagPorFraseTituloURL( String html) throws FileNotFoundException, IOException{
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		String listString = String.join(", ", obj.leerSinTagPorFraseTituloURL(html));
		
		String listFinal = obj.cleanText(listString);
		
		List<String> myList = new ArrayList<String>(Arrays.asList(listFinal.split(",")));
		
		return  myList;
	}
	
}
