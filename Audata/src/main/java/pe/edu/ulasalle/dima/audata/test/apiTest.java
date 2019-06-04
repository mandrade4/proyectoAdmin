package pe.edu.ulasalle.dima.audata.test;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import pe.edu.ulasalle.dima.audata.api.controller.ApiImpl;
import pe.edu.ulasalle.dima.audata.api.controller.IAudataApi;
import pe.edu.ulasalle.dima.audata.dto.DTOapi;
import pe.edu.ulasalle.dima.audata.dto.FileUploadForm;
import pe.edu.ulasalle.dima.audata.text_pdf.controller.IReaderPdf;
import pe.edu.ulasalle.dima.audata.text_pdf.controller.ReaderPdfImpl;
import pe.edu.ulasalle.dima.audata.tts.controller.TtsSpanishDefault;

@Path("/api")
public class apiTest {

	@GET
    @Path("/funcion1/{text}")	
    public byte[] funcion1(@PathParam("text") String nombre) {
    	IAudataApi a = new ApiImpl();
		return a.mp3(nombre);	
    }
    
	@GET
    @Path("/funcion2/{text}")	
    public byte[] funcion2(@PathParam("text") String nombre) {
    	IAudataApi a = new ApiImpl();
		return a.aac(nombre);	
    }
	
	/*
	 * Desde aqui comienzan los metodos con PDF en formato mp3
	 */
    @POST
    @Path("/funcion3")
    @Consumes("multipart/form-data")
    public Response funcion3(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
	
}