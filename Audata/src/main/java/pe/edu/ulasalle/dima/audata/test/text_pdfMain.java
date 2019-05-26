package pe.edu.ulasalle.dima.audata.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import pe.edu.ulasalle.dima.audata.dto.FileUploadForm;
import pe.edu.ulasalle.dima.audata.text_pdf.controller.IReaderPdf;
import pe.edu.ulasalle.dima.audata.text_pdf.controller.ReaderPdfImpl;

@Path("/pdf")
public class text_pdfMain {

    @GET
    @Path("/prueba2/{nombre}")
    public String hola(@PathParam("nombre") String nombre) {
        String hello = "hello " + nombre;
        System.out.println(hello);
        return hello;
    }

    @POST
    @Path("/up01")
    @Consumes("multipart/form-data")
    public Response uploadFile(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData());
        
        return Response.status(200)
                .entity(retorno).build();

    }

    @POST
    @Path("/up02")
    @Consumes("multipart/form-data")
    public Response uploadFile02(@MultipartForm FileUploadForm form) throws IOException {

        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getPaginaInicio(),form.getPaginaFin());
        
        return Response.status(200)
                .entity(retorno).build();

    }

    @POST
    @Path("/up03")
    @Consumes("multipart/form-data")
    public Response uploadFile03(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getPaginaInicio(),form.getPaginaFin(),form.getPalabraInicio(),form.getPalabraFin());
        
        return Response.status(200)
                .entity(retorno).build();
    }
    
    @POST
    @Path("/up04")
    @Consumes("multipart/form-data")
    public Response uploadFile04(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getPaginaInicio(),form.getPaginaFin(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }

    @POST
    @Path("/up05")
    @Consumes("multipart/form-data")
    public Response uploadFile05(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getPaginaInicio(),form.getPaginaFin(),form.getPalabraInicio(),form.getPalabraFin(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up06")
    @Consumes("multipart/form-data")
    public Response uploadFile06(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up07")
    @Consumes("multipart/form-data")
    public Response uploadFile07(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        int retorno = obj.numeroPaginas(form.getData());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up08")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public Response uploadFile08(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        ArrayList<String> retorno = obj.listaBookmark(form.getData());
  
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up09")
    @Consumes("multipart/form-data")
    public Response uploadFile09(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.leerBookmark(form.getData(),form.getBookmark());
        
        return Response.status(200)
                .entity(retorno).build();
    }
    
    @POST
    @Path("/up010")
    @Consumes("multipart/form-data")
    public Response uploadFile010(@MultipartForm FileUploadForm form) throws IOException {

        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.leerBookmark(form.getData(),form.getBookmark(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();
    }
    
    @POST
    @Path("/up011")
    @Consumes("multipart/form-data")
    public Response uploadFile011(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        int retorno = obj.bookmarkPagIni(form.getData(),form.getBookmark());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up012")
    @Consumes("multipart/form-data")
    public Response uploadFile012(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        int retorno = obj.bookmarkPagFin(form.getData(),form.getBookmark());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up013")
    @Consumes("multipart/form-data")
    public Response uploadFile013(@MultipartForm FileUploadForm form) throws IOException {

        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getPaginaInicio());
        
        return Response.status(200)
                .entity(retorno).build();

    }

}
