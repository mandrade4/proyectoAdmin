package pe.edu.ulasalle.dima.audata.text_html.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import pe.edu.ulasalle.dima.audata.text_html.library.IReaderHtmlLibrary;
import pe.edu.ulasalle.dima.audata.text_html.library.ReaderHtmlImplLibrary;

public class ReaderHtmlImpl implements IReaderHtml {

	@Override
	public String leerSinTags(String html) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerSinTags(html);
	}
	
	@Override
	public String leer(String html) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leer(html);
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
		
		return obj.leerTagContents(htmlI, tagI);
	}
	
	@Override
	public String leerTagContentsURL(String htmlI, String tagI) throws IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerTagContentsURL(htmlI, tagI);
	}

	@Override
	public String leerTagContents(String htmlI, String tagI, String[] stopTagListI, String[] stopTagContentList)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String stopTagList(String[] nombres, String htmlI) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] DivisorHtmlPorTag(String htmlI) throws IOException {

		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.DivisorHtmlPorTag(htmlI);
	}
	
	@Override
	public String[] DivisorHtmlPorTagURL(String htmlI) throws IOException {

		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.DivisorHtmlPorTagURL(htmlI);
	}

	@Override
	public String leerSinTagParametros(String html, String a, String b) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> leerSinTagPorFraseTitulo(String html) throws FileNotFoundException, IOException {
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerSinTagPorFraseTitulo(html);
		
	}
	
	@Override
	public String leerSinTagURL(String html1) throws IOException{
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerSinTagURL(html1);
	}
	
	@Override
	public String leerSinTagParametrosURL( String html,String a ,String b ) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<String> leerSinTagPorFraseTituloURL( String html) throws FileNotFoundException, IOException{
		
		IReaderHtmlLibrary obj = new ReaderHtmlImplLibrary();
		
		return obj.leerSinTagPorFraseTituloURL(html);
	}
	
}
