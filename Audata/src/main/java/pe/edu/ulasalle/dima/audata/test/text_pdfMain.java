package pe.edu.ulasalle.dima.audata.test;

import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.edu.ulasalle.dima.audata.text_pdf.library.ReaderPdfImpl;

@Path("/pdf")
public class text_pdfMain {

	@POST
	@Path("/prueba/{pdf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readPDF(@PathParam("pdf") byte[] fstream) throws IOException {
		ReaderPdfImpl obj = new ReaderPdfImpl();
		obj.readPDF(fstream);
		return Response.ok(obj).build();
	}
//	@GET
//	@Path("/prueba/{nombre}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String decirHola(@PathParam("nombre") String nombre) {
//		String hello = "hello " + nombre;
//		return hello;
//	}
	
}
