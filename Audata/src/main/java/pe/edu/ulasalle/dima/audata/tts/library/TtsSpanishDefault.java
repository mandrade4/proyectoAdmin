package pe.edu.ulasalle.dima.audata.tts.library;
import java.io.*;
import java.util.UUID;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.controller.ITts;

public class TtsSpanishDefault extends TtsGenerico implements ITts {

	public TtsSpanishDefault() {
		super();
	}
	
	public byte[] mp3(String text) {
		
		File file = new File("audio");
		
		if (!file.exists()) {
			file.mkdir();
		}
		
		UUID uuid = UUID.randomUUID();
        String UUIDStringRandom = uuid.toString();
        
		String prg = "import pyttsx3\nengine = pyttsx3.init()\nengine.say("+"'"+text+"'"+")\nengine.runAndWait()";
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("audio/"+UUIDStringRandom+".py"));
			out.write(prg);
			out.close();
			Runtime.getRuntime().exec("python audio/"+UUIDStringRandom+".py ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] b = text.getBytes();
		return b;
		
	}
	
	public byte[] mp3(DivisionItem divisionItem) {
		String text = "co�o";
		System.out.println(divisionItem.getTitulo());
		byte[] b = text.getBytes();
		return b;
	}
	

}
