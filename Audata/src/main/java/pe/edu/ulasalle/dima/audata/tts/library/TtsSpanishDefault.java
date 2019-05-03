package pe.edu.ulasalle.dima.audata.tts.library;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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
		//Array de objetos
		ArrayList<DivisionItem> divisionItems = new ArrayList<DivisionItem>();
		//Array de strings
		ArrayList<String> itemsDivi = new ArrayList<String>();
		//le agrego el divisionItem al array de objetos
		divisionItems.add(divisionItem);
		String text = "coño";
		//recorremos el array de objetos
		//ArrayObjeto = [1]
		for (int i = 0; i < divisionItems.size(); i++) {
			//Obtenemos el titulo del arrayObjeto
			String titulo = divisionItems.get(i).getTitulo();
			//Obtenemos el contenido del arrayObjeto
			String contenido = divisionItems.get(i).getContenido();
			//el titulo se guarda en el array de strings
			itemsDivi.add(titulo);
			//el contenido se guarda en el array de strings
			itemsDivi.add(contenido);
			//Se obtiene el primer titulo 
			System.out.println(divisionItems.get(i).getTitulo());
			//Se obtiene el primer contenido
			System.out.println(divisionItems.get(i).getContenido());
			//Crear un array de objetos para el primer item
			DivisionItem[] divisionItemTemp = divisionItems.get(i).getItem();
			//Imprime el tamaño del array divisionItemTemp
			System.out.println("Tamahno: "+divisionItemTemp.length);
			//3
			for (int j = 0; j < divisionItemTemp.length; j++) {
				if(divisionItemTemp[j].getTitulo()!= null){
					System.out.println(divisionItemTemp[j].getTitulo());
				}
				if(divisionItemTemp[j].getContenido()!= null){
					System.out.println(divisionItemTemp[j].getContenido());
				}		
			}
			// DivisionItemTemp = [Titulo, Contenido, Item] = [0,1,2]
			//[Item[0,1,2]]=null?
			
			while(divisionItemTemp[2].getItem()!= null) {
				//DivisionItem[] divisionItemTemp = divisionItems.get(i).getItem();
				DivisionItem[] temp = divisionItemTemp[2].getItem();
				//temp = [Titulo, Contenido, Item] = [0,1,2]
				//System.out.println("Tamahno de TEMPORAL: "+temp.length);
				int j = 0;
				for (j = 0; j < temp.length; j++) {
					//divisionItemTemp[j] = temp[j];
					if(temp[j].getTitulo()!= null){
						System.out.println(temp[j].getTitulo());
					}
					if(temp[j].getContenido()!= null){
						System.out.println(temp[j].getContenido());
					}
					if(j==2){
						System.out.println("divisionItemTemp[2]: "+divisionItemTemp[2].getItem());
						System.out.println("temp[2]:  "+temp[2].getItem());
						divisionItemTemp[j] = temp[j];
					}
				}
				if(j == 2) {
					divisionItemTemp[2].setItem(null);
				}
				//System.out.println("DEBE SER NULLO"+temp[2].getItem());
				//if(temp[2].getItem() == null){
				//	System.out.println("divisionItemTemp[2]: "+divisionItemTemp[2].getItem());
				//	System.out.println("temp[2]:  "+temp[2].getItem());
				//	divisionItemTemp[2].getItem() = null;
				//}
				//System.out.println("DEBE SER NULL: "+divisionItemTemp[2].getItem());
			}
		}
		
		byte[] b = text.getBytes();
		return b;
	}
	

}
