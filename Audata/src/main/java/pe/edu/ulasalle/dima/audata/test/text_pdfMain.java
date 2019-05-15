package pe.edu.ulasalle.dima.audata.test;

import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
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
}
