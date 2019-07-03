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

	String hola ="s";
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
    @Path("/funcion17")
    @Consumes("multipart/form-data")
    public Response funcion17(@MultipartForm FileUploadForm form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    /*
     * mp3 con intervalo de paginas,  palabras y stoplist
     * anadida 25-06
     */
    
    @POST
    @Path("/funcion18")
    @Consumes("multipart/form-data")
    public Response funcion18(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(), 
    							  form.getPalabraInicio(), form.getPalabraFin(), form.getStopList());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    /*
     * mp3 de un bookmark con stoplist
     * anadida 25-06
     */
    @POST
    @Path("/funcion19")
    @Consumes("multipart/form-data")
    public Response funcion19(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3PdfBookmark(form.getData(), form.getBookmark(), form.getStopList());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    /*
     * mp3 con intervalo de paginas y palabras
     */
    @POST
    @Path("/funcion20")
    @Consumes("multipart/form-data")
    public Response funcion20(@MultipartForm DTOapi form) throws IOException {

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
    @Path("/funcion21")
    @Consumes("multipart/form-data")
    public Response funcion21(@MultipartForm FileUploadForm form) throws IOException {
        
    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    /*
     * AAC de un rango determinado de paginas con stoplist
     */
    
    @POST
    @Path("/funcion34")
    @Consumes("multipart/form-data")
    public Response funcion34(@MultipartForm FileUploadForm form) throws IOException {
        
    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(), form.getStopList());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    
  //chino
    @POST
    @Path("/funcion22")
    @Consumes("multipart/form-data")
    public Response funcion22(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion23")
    @Consumes("multipart/form-data")
    public Response funcion23(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3PdfBoomark(form.getData(), form.getBookmark());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion24")
    @Consumes("multipart/form-data")
    public Response funcion24(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(),form.getStopList());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion25")
    @Consumes("multipart/form-data")
    public Response funcion25(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Pdf(form.getData(), form.getStopList());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion26")
    @Consumes("multipart/form-data")
    public Response funcion26(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(), form.getPalabraInicio(), form.getPalabraFin());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    //jeanpol
    
    @POST
    @Path("/funcion27")
    @Consumes("multipart/form-data")
    public Response funcion27(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion28")
    @Consumes("multipart/form-data")
    public Response funcion28(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getStopList());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    
    @POST
    @Path("/funcion29")
    @Consumes("multipart/form-data")
    public Response funcion29(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin(), form.getPalabraInicio(), form.getPalabraFin(), form.getStopList());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion30")
    @Consumes("multipart/form-data")
    public Response funcion30(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData(), form.getPaginaInicio(), form.getPaginaFin());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcion31")
    @Consumes("multipart/form-data")
    public Response funcion31(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdfBoomark(form.getData(), form.getBookmark());
        return Response.status(200)
                .entity(retorno).build();

    }
    
    //edu
    
    @POST
    @Path("/funcionhtml1")
    @Consumes("multipart/form-data")
    public Response funcionhtml1(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3HtmlSinTags(form.getDataHtml());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionhtml2")
    @Consumes("multipart/form-data")
    public Response funcionhtml2(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3HtmlTagContents(form.getDataHtml(),form.getTag());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionhtml3")
    @Consumes("multipart/form-data")
    public Response funcionhtml3(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3HtmlTagContents(form.getDataHtml(), form.getTag(), form.getStopList(), form.getStopTagContentList());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionhtml4")
    @Consumes("multipart/form-data")
    public Response funcionhtml4(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3Html(form.getDataHtml(), form.getDivisor());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionhtml5")
    @Consumes("multipart/form-data")
    public Response funcionhtml5(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacHtmlSinTags(form.getDataHtml());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionhtml6")
    @Consumes("multipart/form-data")
    public Response funcionhtml6(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacHtmlTagContents(form.getDataHtml(), form.getTag());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionhtml7")
    @Consumes("multipart/form-data")
    public Response funcionhtml7(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacHtmlTagContents(form.getDataHtml(), form.getTag(), form.getStopList(), form.getStopTagContentList());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/funcionpdf002")
    @Consumes("multipart/form-data")
    public Response funcionpdf002(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacPdf(form.getData());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
    //rosa
    @POST
    @Path("/funcion011")
    @Consumes("multipart/form-data")
    public Response funcion011(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.mp3HtmlSinTagParametros(form.getDataHtml(),form.getPalabraInicio(),form.getPalabraFin());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();

    }
    
	@POST
    @Path("/funcion012")
    @Consumes("multipart/form-data")
    public Response funcion012(@MultipartForm DTOapi form) throws IOException {

    	IAudataApi a = new ApiImpl();
    	byte[] retorno = a.aacHtmlSinTagParametros(form.getDataHtml(),form.getPalabraInicio(),form.getPalabraFin());
    	System.out.println("Entro!");
        return Response.status(200)
                .entity(retorno).build();
	}
    
	@POST
	@Path("/funcion033")
	@Consumes("multipart/form-data")

	public Response funcion033(@MultipartForm DTOapi form) throws IOException {

		IAudataApi a = new ApiImpl();
		byte[] retorno = a.aacPdfBookmark(form.getData(), form.getBookmark(), form.getStopList());
		System.out.println("Entro!");
		return Response.status(200)
				.entity(retorno).build();

}
    
}