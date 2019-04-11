package pe.edu.ulasalle.dima.audata.tts.library;

import pe.edu.ulasalle.dima.audata.tts.controller.ITts;

public class TtsSpanishDefault extends TtsGenerico implements ITts {

	public TtsSpanishDefault() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public byte[] mp3(String text) {
		byte[] b = text.getBytes();
		return b;
		
	}
	
	

}
