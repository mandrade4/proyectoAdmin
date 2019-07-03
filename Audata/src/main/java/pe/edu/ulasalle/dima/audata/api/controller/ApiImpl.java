package pe.edu.ulasalle.dima.audata.api.controller;

import pe.edu.ulasalle.dima.audata.tts.controller.*;
import pe.edu.ulasalle.dima.audata.text_html.controller.*;
import pe.edu.ulasalle.dima.audata.text_pdf.controller.*;
import java.io.IOException;

import pe.edu.ulasalle.dima.audata.dto.DTOapi;


public class ApiImpl implements IAudataApi {

	public byte[] mp3(String text) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		return obj.mp3(text);
		
	}

	@Override
	public byte[] aac(String text) {

		TtsSpanishDefault obj = new TtsSpanishDefault();
		return obj.aac(text);
		
	}

	@Override
	public byte[] mp3HtmlSinTags(String text) throws IOException {
		
		IReaderHtml obj = new ReaderHtmlImpl();
		String html = obj.leer(text);
		return mp3(html);
	
	}

	@Override
	public byte[] mp3Pdf(byte[] fstream, String pagina) throws IOException {
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagina);
		return mp3(pdf);
		
	}
	
	//25-06
	
	public byte[] mp3Pdf( byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList ) throws IOException{
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni, pagFin, strIni, strFin, stopList);
		
		return mp3(pdf);
	}

	public byte[] mp3PdfBookmark( byte[] fstream, String bookmark, String[] stopList) throws IOException{
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.leerBookmark(fstream, bookmark, stopList);
		
		return mp3(pdf);
	}
	
	//
	@Override
	public byte[] mp3Pdf(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin) throws IOException {

		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni, pagFin, strIni, strFin);
		return mp3(pdf);
		
	}

	@Override
	public byte[] mp3Pdf(byte[] fstream) throws IOException {

		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream);
		return mp3(pdf);
	}
	
	public byte[] aacPdf ( byte[] fstream, String pagIni, String pagFin, String[] stopList ) throws IOException {

		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni, pagFin, stopList);				
		return aac(pdf);
	}
	
	//chino
	@Override
	public byte[] mp3Pdf(byte[] fstream, String pagIni, String pagFin) throws IOException {
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni,pagFin);
		return mp3(pdf);

	}

	@Override
	public byte[] mp3PdfBoomark(byte[] fstream, String bookmark) throws IOException {
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.leerBookmark(fstream, bookmark);
		return mp3(pdf);
		
	}

	@Override
	public byte[] mp3Pdf(byte[] fstream, String pagIni, String pagFin, String[] stopList) throws IOException {
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni, pagFin, stopList);
		
		return mp3(pdf);
	}

	@Override
	public byte[] mp3Pdf(byte[] fstream, String[] stopList) throws IOException {
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, stopList);
		
		return mp3(pdf);
	}

	@Override
	public byte[] aacPdf(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin) throws IOException {
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni, pagFin, strIni, strFin);
		return aac(pdf);
		
	}
	
	
	//jeanpol
	@Override
	public byte[] aacPdf(byte[] fstream, String pagina) throws IOException {
		
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagina);
		return aac(pdf);
		
	}

	@Override
	public byte[] aacPdf(byte[] fstream, String[] stopList) throws IOException {
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, stopList);
		
		return aac(pdf);
	}

	@Override
	public byte[] aacPdf(byte[] fstream, String pagIni, String pagFin, String strIni, String strFin, String[] stopList) throws IOException {
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni, pagFin, strIni, strFin, stopList);
		if (pdf == "error intervalos de pagina no valido") {
			String b = "Holasalskdalksdasda";
			return b.getBytes();
		}else {
			return aac(pdf);
		}
		
	}

	@Override
	public byte[] aacPdf(byte[] fstream, String pagIni, String pagFin) throws IOException {
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.readPDF(fstream, pagIni,pagFin);
		return aac(pdf);
		
	}

	@Override
	public byte[] aacPdfBoomark(byte[] fstream, String bookmark) throws IOException {
		IReaderPdf obj = new ReaderPdfImpl();
		String pdf = obj.leerBookmark(fstream, bookmark);
		return aac(pdf);
		
	}
	
	public String gaaa() {
		return "gaaaaaaaa";
	}
	
}
