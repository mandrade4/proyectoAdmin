package pe.edu.ulasalle.dima.audata.test;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import pe.edu.ulasalle.dima.audata.dto.FileUploadFormHtml;

import pe.edu.ulasalle.dima.audata.text_html.controller.IReaderHtml;
import pe.edu.ulasalle.dima.audata.text_html.controller.ReaderHtmlImpl;


@Path("/html")
public class text_htmlMain {
	
	@POST
    @Path("/pruebahtml2")
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
        String html = obj.leerSinTags(form.getData());
        
        return Response.status(200)
                .entity(html).build();

    }
	
	@POST
    @Path("/pruebahtml3")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml2(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
		//String retorno1 = obj.procesarHTML(form.getData());
        String[] html = obj.leerTags(form.getData());
        
        return Response.status(200)
                .entity(html).build();

    }
	
	@POST
    @Path("/pruebahtml4")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml3(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
		//String retorno1 = obj.procesarHTML(form.getData());
        String html = obj.leerTagContents(form.getData(),form.getTag());
        
        return Response.status(200)
                .entity(html).build();

    }
	
	@POST
    @Path("/pruebahtml5")
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml4(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
		//String retorno1 = obj.procesarHTML(form.getData());
        String[] html = obj.DivisorHtmlPorTag(form.getData());
        
        return Response.status(200)
                .entity(html).build();

    }
	
	@POST
    @Path("/pruebahtml6")
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml5(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
        List<String> retorno = obj.leerSinTagPorFraseTitulo(form.getData());
        
        return Response.status(200)
                .entity(retorno).build();

    }
	
	
	@POST
    @Path("/pruebahtml7")
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml6(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
        String retorno = obj.leerSinTagParametros(form.getData(),form.getInicio(),form.getFin());
        
        return Response.status(200)
                .entity(retorno).build();

    }
	
	@POST
    @Path("/pruebahtml8")
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml7(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
        String retorno = obj.stopTagList(form.getStopTagList(), form.getData());
        
        return Response.status(200)
                .entity(retorno).build();

    }
	
	@POST
    @Path("/pruebahtml9")
    @Consumes("multipart/form-data")
    public Response uploadedFileHtml8(@MultipartForm FileUploadFormHtml form) throws IOException {
        
		IReaderHtml obj = new ReaderHtmlImpl();
        String retorno = obj.leerTagContents(form.getData(),form.getTag(),form.getStopTagList(),form.getStopTagContentList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
	
}
