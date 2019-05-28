package pe.edu.ulasalle.dima.audata.tts.library;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefaultEngine;
import pe.edu.ulasalle.dima.audata.tts.library.ITts;

public class TtsSpanishDefaultLibrary extends TtsGenericoLibrary implements ITts {
	
	public byte[] mp3(String text){
		TtsSpanishDefaultEngine tts = new TtsSpanishDefaultEngine();
		
		
		
		return tts.mp3(text);
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
