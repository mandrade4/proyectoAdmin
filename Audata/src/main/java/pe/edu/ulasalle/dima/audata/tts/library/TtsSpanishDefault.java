package pe.edu.ulasalle.dima.audata.tts.library;
import java.io.*;

import pe.edu.ulasalle.dima.audata.tts.controller.ITts;

public class TtsSpanishDefault extends TtsGenerico implements ITts {

	public TtsSpanishDefault() {
		super();
	}
	
	public byte[] mp3(String text) {
		
		String prg = "import pyttsx3\nengine = pyttsx3.init()\nengine.say("+"'"+text+"'"+")\nengine.runAndWait()";
		try {
			new File("src/main/java/pe/edu/ulasalle/dima/audata/test/audio").mkdirs();
			BufferedWriter out = new BufferedWriter(new FileWriter("src/main/java/pe/edu/ulasalle/dima/audata/test/audio/test1.py"));
			out.write(prg);
			out.close();
			Runtime.getRuntime().exec("python src/main/java/pe/edu/ulasalle/dima/audata/test/audio/test1.py ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] b = text.getBytes();
		return b;
		
	}
	
	

}
