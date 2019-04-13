package pe.edu.ulasalle.dima.audata.tts.library;
import java.io.*;

import pe.edu.ulasalle.dima.audata.tts.controller.ITts;

public class TtsSpanishDefault extends TtsGenerico implements ITts {

	public TtsSpanishDefault() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public byte[] mp3(String text) {
		
		String prg = "import pyttsx3\nengine = pyttsx3.init()\nengine.say("+text+")\nengine.runAndWait()";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("test1.py"));
			out.write(prg);
			out.close();
			Runtime.getRuntime().exec("python test1.py ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] b = text.getBytes();
		return b;
		
	}
	
	

}
