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
import pe.edu.ulasalle.dima.audata.text_pdf.library.IReaderPdf;
import pe.edu.ulasalle.dima.audata.text_pdf.library.ReaderPdfImpl;

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
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(@MultipartForm FileUploadForm form) throws IOException {
        
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData());
        
        return Response.status(200)
                .entity(retorno).build();

    }

    @POST
    @Path("/up2")
    @Consumes("multipart/form-data")
    public Response uploadFile2(@MultipartForm FileUploadForm form) throws IOException {

        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getInicio(),form.getFin());
        
        return Response.status(200)
                .entity(retorno).build();

    }

    
    @POST
    @Path("/up3")
    @Consumes("multipart/form-data")
    public Response uploadFile3(@MultipartForm FileUploadForm form) throws IOException {

        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up4")
    @Consumes("multipart/form-data")
    public Response uploadFile5(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        int retorno = obj.numeroPaginas(form.getData());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up5")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("multipart/form-data")
    public Response uploadFile6(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        ArrayList<String> retorno = obj.listaBookmark(form.getData());
  
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up7")
    @Consumes("multipart/form-data")
    public Response uploadFile7(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        int retorno = obj.bookmarkPagIni(form.getData(),form.getBookmark());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up8")
    @Consumes("multipart/form-data")
    public Response uploadFile8(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        int retorno = obj.bookmarkPagFin(form.getData(),form.getBookmark());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up9")
    @Consumes("multipart/form-data")
    public Response uploadFile9(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up10")
    @Consumes("multipart/form-data")
    public Response uploadFile10(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getInicio(),form.getFin(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up11")
    @Consumes("multipart/form-data")
    public Response uploadFile11(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getInicio(),form.getFin(),form.getPalabraInicio(),form.getPalabraFin(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up12")
    @Consumes("multipart/form-data")
    public Response uploadFile12(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.readPDF(form.getData(),form.getInicio(),form.getFin(),form.getPalabraInicio(),form.getPalabraFin());
        
        return Response.status(200)
                .entity(retorno).build();

    }

    @POST
    @Path("/up13")
    @Consumes("multipart/form-data")
    public Response uploadFile13(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.leerBookmark(form.getData(),form.getBookmark());
        
        return Response.status(200)
                .entity(retorno).build();

    }
    
    @POST
    @Path("/up14")
    @Consumes("multipart/form-data")
    public Response uploadFile14(@MultipartForm FileUploadForm form) throws IOException {

    	
        IReaderPdf obj = new ReaderPdfImpl();
        String retorno = obj.leerBookmark(form.getData(),form.getBookmark(),form.getStopList());
        
        return Response.status(200)
                .entity(retorno).build();

    }
}
