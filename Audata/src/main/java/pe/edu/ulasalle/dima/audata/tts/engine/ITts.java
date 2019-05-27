package pe.edu.ulasalle.dima.audata.tts.engine;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;

public interface ITts {
	
	public byte[] mp3(String text);
	public byte[] mp3(DivisionItem divisionItem);
	public byte[] mp3(DivisionItem[] divisionItem);
	public byte[] aac(DivisionItem[] divisionItem);
	public byte[] aac(DivisionItem divisionItem);
	public byte[] aac(String text);
	
}
