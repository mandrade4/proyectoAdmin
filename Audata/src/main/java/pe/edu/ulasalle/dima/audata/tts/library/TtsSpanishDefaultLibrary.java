package pe.edu.ulasalle.dima.audata.tts.library;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefaultEngine;
import pe.edu.ulasalle.dima.audata.tts.library.ITts;

public class TtsSpanishDefaultLibrary extends TtsGenericoLibrary implements ITts {
	
	public byte[] mp3(String text){
		
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		
		String resp = "";
        for (int i = 0; i < text.length(); i++){ 
        if((text.charAt(i)> 96  && text.charAt(i) < 123) || (text.charAt(i) > 64 && text.charAt(i) < 91) ||
          (text.charAt(i) > 191 && text.charAt(i) < 256) || (text.charAt(i) > -65 && text.charAt(i) < 0)|| (text.charAt(i) > 48 && text.charAt(i) < 57))
        resp += text.charAt(i);
        if (Character.isWhitespace(text.charAt(i))) {
        resp +=" ";
        }
        }				
		return tts.mp3(resp);
	}
	
	public byte[] mp3(DivisionItem divisionItem) {
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		return tts.mp3(divisionItem);
	}
	
	public byte[] mp3(DivisionItem[] divisionItem) {
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		return tts.mp3(divisionItem);
	}
	
	public byte[] aac(String text){
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		return tts.aac(text);
	}
	
	public byte[] aac(DivisionItem divisionItem) {
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		return tts.aac(divisionItem);
	}
	
	public byte[] aac(DivisionItem[] divisionItem) {
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		return tts.aac(divisionItem);
	}
	
}
