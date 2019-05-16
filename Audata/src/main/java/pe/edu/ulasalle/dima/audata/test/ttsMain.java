package pe.edu.ulasalle.dima.audata.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
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
	@Path("/talk2/{text}")
	public Response talk2(@PathParam("text") String text) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.aac(text);
		return Response.ok(text).build();
		
	}
	
	@GET
	@Path("/talk/{text}")
	public Response talk(@PathParam("text") String text) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.mp3(text);
		return Response.ok(text).build();
		
	}
	@POST
	@Path("/talkOneDivisionItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response talkOneDivisionItem(DivisionItem divisionItem) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.mp3(divisionItem);
		return Response.status(Response.Status.CREATED).entity(divisionItem).build();
		
	}
	
	@POST
	@Path("/talkMultiDivisionItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response talkMultiDivisionItem(DivisionItem[] divisionItem) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.mp3(divisionItem);
		return Response.status(Response.Status.CREATED).entity(obj).build();
		
	}
	
	@POST
	@Path("/talkOneDivisionItem2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response talkOneDivisionItem2(DivisionItem divisionItem) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.mp3(divisionItem);
		return Response.status(Response.Status.CREATED).entity(divisionItem).build();
		
	}
	
	@POST
	@Path("/talkMultiDivisionItem2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response talkMultiDivisionItem2(DivisionItem[] divisionItem) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		obj.mp3(divisionItem);
		return Response.status(Response.Status.CREATED).entity(obj).build();
		
	}
	
}