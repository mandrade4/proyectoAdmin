package pe.edu.ulasalle.dima.audata.text_pdf.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import pe.edu.ulasalle.dima.audata.text_pdf.library.IReaderPdfLibrary;
import pe.edu.ulasalle.dima.audata.text_pdf.library.ReaderPdfImplLibrary;

public class ReaderPdfImpl implements IReaderPdf {
	
	@Override
	public String readPDF(byte[] fstream) throws IOException {
		
		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream);
		
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin) throws FileNotFoundException, IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream, pagIni, pagFin);
		
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin)
			throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream, pagIni, pagFin, strIni, strFin);
		
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String[] listStop) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream, pagIni, pagFin, listStop);
		
	}

	@Override
	public String readPDF(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList)
			throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream, pagIni, pagFin, strIni, strFin, stopList);
		
	}

	@Override
	public String readPDF(byte[] fstream, String[] stopList) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream, stopList);
		
	}

	@Override
	public int numeroPaginas(byte[] fstream) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.numeroPaginas(fstream);
		
	}

	@Override
	public ArrayList<String> listaBookmark(byte[] fstream) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.listaBookmark(fstream);
		
	}

	@Override
	public String leerBookmark(byte[] inputStream, String bookmark) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.leerBookmark(inputStream, bookmark);
		
	}

	@Override
	public String leerBookmark(byte[] inputStream, String bookmark, String[] stopList) throws IOException {
		
		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.leerBookmark(inputStream, bookmark, stopList);
		
	}

	@Override
	public int bookmarkPagIni(byte[] fstream, String bookmark) throws IOException {
		
		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.bookmarkPagIni(fstream, bookmark);
		
	}

	@Override
	public int bookmarkPagFin(byte[] fstream, String bookmark) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();	
		
		return obj.bookmarkPagFin(fstream, bookmark);
	}

	@Override
	public String readPDF(byte[] fstream, String page) throws IOException {

		IReaderPdfLibrary obj = new ReaderPdfImplLibrary();
		
		return obj.readPDF(fstream, page);

	}

}

