package pe.edu.ulasalle.dima.audata.api.controller;

import pe.edu.ulasalle.dima.audata.tts.controller.*; 

public class ApiImpl implements IAudataApi {

	public byte[] mp3(String text) {
		
		TtsSpanishDefault obj = new TtsSpanishDefault();
		return obj.mp3(text);
		
	}

}
