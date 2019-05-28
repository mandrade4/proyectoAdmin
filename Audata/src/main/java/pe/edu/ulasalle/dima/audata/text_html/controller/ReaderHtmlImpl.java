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
	public String[] leerTags(String htmlI) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leerTagContents(String htmlI, String tagI) throws IOException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leerSinTagParametros(String html, String a, String b) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> leerSinTagPorFraseTitulo(String html) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
