package pe.edu.ulasalle.dima.audata.tts.library;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.library.ITts; 

public class TtsEnglishDefault extends TtsGenerico implements ITts {

	public byte[] mp3(String text){
		pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault tts = new pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault();
		return tts.mp3(text);
	}
	
	public byte[] mp3(DivisionItem divisionItem) {
		pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault tts = new pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault();
		return tts.mp3(divisionItem);
	}
	
	public byte[] mp3(DivisionItem[] divisionItem) {
		pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault tts = new pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault();
		return tts.mp3(divisionItem);
	}
	
	public byte[] aac(String text){
		pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault tts = new pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault();
		return tts.aac(text);
	}
	
	public byte[] aac(DivisionItem divisionItem) {
		pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault tts = new pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault();
		return tts.aac(divisionItem);
	}
	
	public byte[] aac(DivisionItem[] divisionItem) {
		pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault tts = new pe.edu.ulasalle.dima.audata.tts.engine.TtsSpanishDefault();
		return tts.aac(divisionItem);
	}
}
