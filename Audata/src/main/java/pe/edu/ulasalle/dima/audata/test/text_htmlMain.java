package pe.edu.ulasalle.dima.audata.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;

import pe.edu.ulasalle.dima.audata.text_html.library.IReaderHtml;
import pe.edu.ulasalle.dima.audata.text_html.library.ReaderHtmlImpl;

@Path("/html")
public class text_htmlMain {

	@GET
	@Path("/prueba3/{html}")
	@Produces(MediaType.TEXT_HTML)
	
	public void leerSinTag(@PathParam("html") String html) throws IOException {
		
 		FileReader html1 = new FileReader(html);
 		IReaderHtml pr = new ReaderHtmlImpl();
		 StringBuilder sb = new StringBuilder();
		    BufferedReader br = new BufferedReader(html1);
		    
		     String line;
		    while ( (line=br.readLine()) != null) {
		      sb.append(line);
		      
		    }
		    br.close();
		    System.out.println(pr.leerSinTag(sb.toString()));
	}
	
	@GET
	@Path("/prueba/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String decirHola(@PathParam("nombre") String nombre) {
		String hello = "hello " + nombre;
		return hello;
	}
}
