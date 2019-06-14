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
	 * mp3Pdf de determinada pagina
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
    
    /*
     * mp3 con intervalo de paginas y palabras
     */
    @POST
    @Path("/funcion4")
    @Consumes("multipart/form-data")
    public Response funcion4(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(), form.getPalabraInicio(), form.getPalabraFin());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    /*
     * mp3 del texto de un PDF
     */
    @POST
    @Path("/funcion5")
    @Consumes("multipart/form-data")
    public Response funcion5(@MultipartForm FileUploadForm form) throws IOException {
        
    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData());
        return Response.status(200)
                .entity(retorno).build();

    }
    
  //chino
    @POST
    @Path("/funcion001")
    @Consumes("multipart/form-data")
    public Response funcion001(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion002")
    @Consumes("multipart/form-data")
    public Response funcion002(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3PdfBoomark(form.getData(), form.getBookmark());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion003")
    @Consumes("multipart/form-data")
    public Response funcion003(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(), form.getPalabraInicio(), form.getPalabraFin());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    //jeanpol
    
    @POST
    @Path("/funcion004")
    @Consumes("multipart/form-data")
    public Response funcion004(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion005")
    @Consumes("multipart/form-data")
    public Response funcion005(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion006")
    @Consumes("multipart/form-data")
    public Response funcion006(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdfBoomark(form.getData(), form.getBookmark());
        return Response.status(200)
                .entity(retorno).build();

    }
}