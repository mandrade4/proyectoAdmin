package pe.edu.ulasalle.dima.audata.test;

import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pe.edu.ulasalle.dima.audata.text_pdf.library.ReaderPdfImpl;

@Path("/pdf")
public class text_pdfMain {

	
	@Produces(MediaType.APPLICATION_JSON)
	public void readPDF(FileInputStream fstream) throws IOException {
		ReaderPdfImpl obj = new ReaderPdfImpl();
//		obj.readPDF(fstream);
	}
	
}
