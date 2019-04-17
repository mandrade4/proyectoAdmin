package pe.edu.ulasalle.dima.audata.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/tts")
public class ttsMain {
	
	@GET
	@Path("/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String decirHola(@PathParam("nombre") String nombre) {
		String hello = "hello " + nombre;
		return hello;
	}
	
}
