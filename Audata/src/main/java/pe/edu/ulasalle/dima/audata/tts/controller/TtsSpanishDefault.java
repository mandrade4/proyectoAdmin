package pe.edu.ulasalle.dima.audata.tts.controller;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.library.TtsSpanishDefaultLibrary;

public class TtsSpanishDefault extends TtsGenerico implements ITts {
	
	public byte[] mp3(String text){
		TtsSpanishDefaultLibrary tts = new TtsSpanishDefaultLibrary();
		return tts.mp3(text);
	}
	
	public byte[] mp3(DivisionItem divisionItem) {
		TtsSpanishDefaultLibrary tts = new TtsSpanishDefaultLibrary();
		return tts.mp3(divisionItem);
	}
	
	public byte[] mp3(DivisionItem[] divisionItem) {
		TtsSpanishDefaultLibrary tts = new TtsSpanishDefaultLibrary();
		return tts.mp3(divisionItem);
	}
	
	public byte[] aac(String text){
		TtsSpanishDefaultLibrary tts = new TtsSpanishDefaultLibrary();
		return tts.aac(text);
	}
	
	public byte[] aac(DivisionItem divisionItem) {
		TtsSpanishDefaultLibrary tts = new TtsSpanishDefaultLibrary();
		return tts.aac(divisionItem);
	}
	
	public byte[] aac(DivisionItem[] divisionItem) {
		TtsSpanishDefaultLibrary tts = new TtsSpanishDefaultLibrary();
		return tts.aac(divisionItem);
	}
	
}
