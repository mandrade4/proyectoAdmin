package pe.edu.ulasalle.dima.audata.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.edu.ulasalle.dima.audata.tts.library.TtsSpanishDefault;


@Path("/tts")
public class ttsMain {
	
	@GET
	@Path("/prueba/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public String decirHola(@PathParam("nombre") String nombre) {
		String hello = "hello " + nombre;
		return hello;
	}
	
	@GET
	@Path("/{text}")
	@Produces(MediaType.APPLICATION_JSON)
	public void talk(@PathParam("text") String text) {
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.mp3(text);
	}
	
}
