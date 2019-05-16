package pe.edu.ulasalle.dima.audata.tts.library;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;



import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.controller.ITts;

public class TtsSpanishDefault extends TtsGenerico implements ITts {

	public TtsSpanishDefault() {
		super();
	}
	
	public byte[] mp3(String text){
		
		File file = new File("audio");
		
		if (!file.exists()) {
			file.mkdir();
		}
		
		UUID uuid = UUID.randomUUID();
        String UUIDStringRandom = uuid.toString();
		String prg = "from comtypes.client import CreateObject\nengine = CreateObject(\"SAPI.SpVoice\")\nstream = CreateObject(\"SAPI.SpFileStream\")\nfrom comtypes.gen import SpeechLib\nstream.Open('"+UUIDStringRandom+".mp3', SpeechLib.SSFMCreateForWrite)\nengine.AudioOutputStream = stream\nengine.speak('"+text+"')\nstream.Close()";
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("audio/"+UUIDStringRandom+".py"));
			out.write(prg);
			out.close();
			Runtime.getRuntime().exec("python audio/"+UUIDStringRandom+".py ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] bytes =null;
		return bytes;
	}
	
	
	// Recorrrer un array de objetos en java
	public byte[] mp3(DivisionItem divisionItem) {
		ArrayList<String> itemsDivi = new ArrayList<String>();
		String text = "coño";
		
		String titulo = divisionItem.getTitulo();
		String contenido = divisionItem.getContenido();
		itemsDivi.add(titulo);
		itemsDivi.add(contenido);
		
		if(divisionItem.getItem()!= null) {
			DivisionItem[] divisionItemTemp = divisionItem.getItem();		
			for (int j = 0; j < divisionItemTemp.length; j++) {
				if(divisionItemTemp[j].getTitulo()!= null){
					titulo = divisionItemTemp[j].getTitulo();
					itemsDivi.add(titulo);
				}
				if(divisionItemTemp[j].getContenido()!= null){
					contenido = divisionItemTemp[j].getContenido();
					itemsDivi.add(contenido);
				}		
			}

			if(divisionItemTemp.length == 3) {
				while(divisionItemTemp[2].getItem()!= null) {
					DivisionItem[] temp = divisionItemTemp[2].getItem();
					int j = 0;
					for (j = 0; j < temp.length; j++) {
						if(temp[j].getTitulo()!= null){
							titulo = temp[j].getTitulo();
							itemsDivi.add(titulo);
							//System.out.println(temp[j].getTitulo());
						}
						if(temp[j].getContenido()!= null){
							contenido = temp[j].getContenido();
							itemsDivi.add(contenido);
							//System.out.println(temp[j].getContenido());
						}
						if(j==2){
							//System.out.println("divisionItemTemp[2]: "+divisionItemTemp[2].getItem());
							//System.out.println("temp[2]:  "+temp[2].getItem());
							divisionItemTemp[j] = temp[j];							
						}
					}
					if(j == 2) {
						divisionItemTemp[2].setItem(null);
					}
				}		
			}
		}
		
		for(int k=0; k < itemsDivi.size();k++) {
			if(k % 2 == 0){
				System.out.println("Titulo: "+itemsDivi.get(k));
			}
			else {
				System.out.println("Contenido: "+itemsDivi.get(k));
			}
		}

		byte[] b = text.getBytes();
		return b;
	}
	
	public byte[] mp3(DivisionItem[] divisionItem) {
		ArrayList<String> itemsDivi = new ArrayList<String>();
		String titulo;
		String contenido;
		for (int i=0; i< divisionItem.length; i++){			
			if(divisionItem[i].getTitulo()!= null){
				titulo = divisionItem[i].getTitulo();
				itemsDivi.add(titulo);
			}
			
			if(divisionItem[i].getContenido()!= null){
				contenido = divisionItem[i].getContenido();
				itemsDivi.add(contenido);
			}
			
			
			if(divisionItem[i].getItem()!= null) {
				DivisionItem[] divisionItemTemp = divisionItem[i].getItem();		
				for (int j = 0; j < divisionItemTemp.length; j++) {
					if(divisionItemTemp[j].getTitulo()!= null){
						titulo = divisionItemTemp[j].getTitulo();
						itemsDivi.add(titulo);
					}
					if(divisionItemTemp[j].getContenido()!= null){
						contenido = divisionItemTemp[j].getContenido();
						itemsDivi.add(contenido);
					}		
				}

				if(divisionItemTemp.length == 3) {
					while(divisionItemTemp[2].getItem()!= null) {
						DivisionItem[] temp = divisionItemTemp[2].getItem();
						int j = 0;
						for (j = 0; j < temp.length; j++) {
							if(temp[j].getTitulo()!= null){
								titulo = temp[j].getTitulo();
								itemsDivi.add(titulo);
								//System.out.println(temp[j].getTitulo());
							}
							if(temp[j].getContenido()!= null){
								contenido = temp[j].getContenido();
								itemsDivi.add(contenido);
								//System.out.println(temp[j].getContenido());
							}
							if(j==2){
								//System.out.println("divisionItemTemp[2]: "+divisionItemTemp[2].getItem());
								//System.out.println("temp[2]:  "+temp[2].getItem());
								divisionItemTemp[j] = temp[j];							
							}
						}
						if(j == 2) {
							divisionItemTemp[2].setItem(null);
						}
					}		
				}
			}			
		}
		
		
		for(int k=0; k < itemsDivi.size();k++) {
			if(k % 2 == 0){
				System.out.println("Titulo: "+itemsDivi.get(k));
			}
			else {
				System.out.println("Contenido: "+itemsDivi.get(k));
			}
		}
		
		String text = "coño";
		byte[] b = text.getBytes();
		return b;	
	}

	
	public byte[] aac(String text) {
			
			File file = new File("audio");
			
			if (!file.exists()) {
				file.mkdir();
			}
			
			UUID uuid = UUID.randomUUID();
	        String UUIDStringRandom = uuid.toString();
	        
			String prg = "from comtypes.client import CreateObject\nengine = CreateObject(\"SAPI.SpVoice\")\nstream = CreateObject(\"SAPI.SpFileStream\")\nfrom comtypes.gen import SpeechLib\nstream.Open('"+UUIDStringRandom+".aac', SpeechLib.SSFMCreateForWrite)\nengine.AudioOutputStream = stream\nengine.speak('"+text+"')\nstream.Close()";
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
		
}
