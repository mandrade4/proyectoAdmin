package pe.edu.ulasalle.dima.audata.tts.library;
import java.io.*;
import java.util.ArrayList;
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
	
	// Recorrrer un array de objetos en java
	public byte[] mp3(DivisionItem divisionItem) {
		ArrayList<DivisionItem> divisionItems = new ArrayList<DivisionItem>();
		ArrayList<String> itemsDivi = new ArrayList<String>();
		divisionItems.add(divisionItem);
		String text = "coño";
		for (int i = 0; i < divisionItems.size(); i++) {
			String titulo = divisionItems.get(i).getTitulo();
			String contenido = divisionItems.get(i).getContenido();
			itemsDivi.add(titulo);
			itemsDivi.add(contenido);
			System.out.println(divisionItems.get(i).getTitulo());
			System.out.println(divisionItems.get(i).getContenido());
			
			DivisionItem[] divisionItemTemp = divisionItems.get(i).getItem();
			//divisionItems.add(divisionItemTemp);
			
			System.out.println("Tamahno: "+divisionItemTemp.length);

			for (int j = 0; j < divisionItemTemp.length; j++) {
				System.out.println(divisionItemTemp[j].getTitulo());
				System.out.println(divisionItemTemp[j].getContenido());
			}
		}
		byte[] b = text.getBytes();
		return b;
	}
	

}
