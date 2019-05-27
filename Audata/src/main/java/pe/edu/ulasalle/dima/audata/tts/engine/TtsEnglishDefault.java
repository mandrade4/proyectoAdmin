package pe.edu.ulasalle.dima.audata.tts.engine;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.tts.engine.TtsGenerico;
import pe.edu.ulasalle.dima.audata.tts.engine.ITts;

public class TtsEnglishDefault extends TtsGenerico implements ITts {
	
	public TtsEnglishDefault() {
		
		super();
		
	}
	
	public byte[] mp3(String text){
		
		File file = new File("audio");
		
		if (!file.exists()) {
			file.mkdir();
		}
		
		UUID uuid = UUID.randomUUID();
		String uuidStringRandom = uuid.toString();
		String prg = "from comtypes.client import CreateObject\nengine = CreateObject(\"SAPI.SpVoice\")"
				+ "\nstream = CreateObject(\"SAPI.SpFileStream\")\nfrom comtypes.gen import SpeechLib"
				+ "\nstream.Open('"  +uuidStringRandom + ".mp3', SpeechLib.SSFMCreateForWrite)"
				+ "\nengine.AudioOutputStream = stream\nengine.speak('" + text + "')\nstream.Close()";
		
		try {
			
			BufferedWriter out = new BufferedWriter(new FileWriter("audio/" + uuidStringRandom + ".py"));
			out.write(prg);
			out.close();
			Runtime.getRuntime().exec("python audio/"+uuidStringRandom+".py ");
			TimeUnit.SECONDS.sleep(20);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}

		InputStream inStream;
		
		ByteArrayOutputStream b = null;
		
		String flow = uuidStringRandom + ".mp3";
		
		try {
			
			inStream = new FileInputStream(flow);
			b = new ByteArrayOutputStream();			
			byte[] buffer = new byte[8192];			
		  	int bytesRead;
		  	
		  	while ((bytesRead = inStream.read(buffer)) > 0) {
		  		
		  		b.write(buffer, 0, bytesRead);
		  		
		  	}
		    
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println(b.toByteArray());
		return b.toByteArray();
		
	}
	
	
	public byte[] mp3(DivisionItem divisionItem) {
		
		ArrayList<String> itemsDivi = new ArrayList<String>();
		
		String titulo = divisionItem.getTitulo();
		String contenido = divisionItem.getContenido();
		
		itemsDivi.add(titulo);
		itemsDivi.add(contenido);
		
		if (divisionItem.getItem() != null) {
			
			DivisionItem[] divisionItemTemp = divisionItem.getItem();	
			
			for (int j = 0; j < divisionItemTemp.length; j++) {
				
				if (divisionItemTemp[j].getTitulo() != null) {
					
					titulo = divisionItemTemp[j].getTitulo();
					itemsDivi.add(titulo);
					
				}
				
				if (divisionItemTemp[j].getContenido() != null) {
					
					contenido = divisionItemTemp[j].getContenido();
					itemsDivi.add(contenido);
					
				}	
				
			}

			if(divisionItemTemp.length == 3) {
				
				while(divisionItemTemp[2].getItem() != null) {
					
					DivisionItem[] temp = divisionItemTemp[2].getItem();
					int j = 0;
					
					for (j = 0; j < temp.length; j++) {
						
						if (temp[j].getTitulo()!= null) {
							
							titulo = temp[j].getTitulo();
							itemsDivi.add(titulo);
							
						}
						if (temp[j].getContenido() != null) {
							
							contenido = temp[j].getContenido();
							itemsDivi.add(contenido);
							
						}
						if (j == 2) {
							
							divisionItemTemp[j] = temp[j];
							
						}
						
					}
					if (j == 2) {
						
						divisionItemTemp[2].setItem(null);
						
					}
					
				}	
				
			}
			
		}
		
		for (int k = 0; k < itemsDivi.size(); k++) {
			
			if (k % 2 == 0) {
				
				System.out.println("Titulo: "+itemsDivi.get(k));
				
			}
			
			else {
				
				System.out.println("Contenido: "+itemsDivi.get(k));
				
			}
			
		}
		
		String listString = "";
		
		for (String s: itemsDivi) {
			
			listString += s + "." + "\t";
			
		}
		
		return mp3(listString);
		
	}
	
	public byte[] mp3(DivisionItem[] divisionItem) {
		
		ArrayList<String> itemsDivi = new ArrayList<String>();
		
		String titulo;
		String contenido;
		
		for (int i = 0; i < divisionItem.length; i++) {
			
			if (divisionItem[i].getTitulo() != null) {
				
				titulo = divisionItem[i].getTitulo();
				itemsDivi.add(titulo);
				
			}
			
			if (divisionItem[i].getContenido() != null) {
				
				contenido = divisionItem[i].getContenido();
				itemsDivi.add(contenido);
				
			}
			
			if (divisionItem[i].getItem() != null) {
				
				DivisionItem[] divisionItemTemp = divisionItem[i].getItem();
				
				for (int j = 0; j < divisionItemTemp.length; j++) {
					
					if (divisionItemTemp[j].getTitulo() != null) {
						
						titulo = divisionItemTemp[j].getTitulo();
						itemsDivi.add(titulo);
						
					}
					
					if (divisionItemTemp[j].getContenido() != null) {
						
						contenido = divisionItemTemp[j].getContenido();
						itemsDivi.add(contenido);
						
					}	
					
				}

				if (divisionItemTemp.length == 3) {
					
					while (divisionItemTemp[2].getItem() != null) {
						
						DivisionItem[] temp = divisionItemTemp[2].getItem();
						int j = 0;
						
						for (j = 0; j < temp.length; j++) {
							
							if (temp[j].getTitulo() != null) {
								
								titulo = temp[j].getTitulo();
								itemsDivi.add(titulo);
								
							}
							
							if (temp[j].getContenido() != null) {
								
								contenido = temp[j].getContenido();
								itemsDivi.add(contenido);
								
							}
							
							if (j == 2) {
								
								divisionItemTemp[j] = temp[j];
								
							}
							
						}
						
						if (j == 2) {
							
							divisionItemTemp[2].setItem(null);
							
						}
						
					}
					
				}
				
			}	
			
		}
		
		for (int k = 0; k < itemsDivi.size(); k++) {
			
			if (k % 2 == 0) {
				
				System.out.println("Titulo: "+itemsDivi.get(k));
				
			}
			
			else {
				
				System.out.println("Contenido: "+itemsDivi.get(k));
				
			}
			
		}
		
		String listString = "";
		
		for (String s: itemsDivi) {
			
			listString += s + "." + "\t";
			
		}
		
		return mp3(listString);
		
	}
	
	public byte[] aac(String text) {
			
			File file = new File("audio");
			
			if (!file.exists()) {
				
				file.mkdir();
				
			}
			
			UUID uuid = UUID.randomUUID();
	        String uuidStringRandom = uuid.toString();
			String prg = "from comtypes.client import CreateObject\nengine = CreateObject(\"SAPI.SpVoice\")"
					+ "\nstream = CreateObject(\"SAPI.SpFileStream\")\nfrom comtypes.gen import SpeechLib"
					+ "\nstream.Open('" + uuidStringRandom + ".aac', SpeechLib.SSFMCreateForWrite)"
					+ "\nengine.AudioOutputStream = stream\nengine.speak('" + text + "')\nstream.Close()";
			
			try {
				
				BufferedWriter out = new BufferedWriter(new FileWriter("audio/" + uuidStringRandom + ".py"));
				out.write(prg);
				out.close();
				Runtime.getRuntime().exec("python audio/" + uuidStringRandom + ".py ");
				TimeUnit.SECONDS.sleep(20);

			} catch (IOException e) {
				
				e.printStackTrace();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
			InputStream inStream;
			ByteArrayOutputStream b = null;
			String flow = uuidStringRandom + ".aac";
			
			try {
				
				inStream = new FileInputStream(flow);
				b = new ByteArrayOutputStream();
			    byte[] buffer = new byte[8192];
			  	int bytesRead;
			  	
			  	while ((bytesRead = inStream.read(buffer)) > 0) {
			  		
			  	  b.write(buffer, 0, bytesRead);
			  	  
			    }
			    
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
			System.out.println(b.toByteArray());
			return b.toByteArray();
			
		}
	
	public byte[] aac(DivisionItem divisionItem) {
		
		ArrayList<String> itemsDivi = new ArrayList<String>();
		
		String titulo = divisionItem.getTitulo();
		String contenido = divisionItem.getContenido();
		
		itemsDivi.add(titulo);
		itemsDivi.add(contenido);
		
		if (divisionItem.getItem() != null) {
			 
			DivisionItem[] divisionItemTemp = divisionItem.getItem();
			
			for (int j = 0; j < divisionItemTemp.length; j++) {
				
				if (divisionItemTemp[j].getTitulo() != null) {
					
					titulo = divisionItemTemp[j].getTitulo();
					itemsDivi.add(titulo);
					
				}
				
				if (divisionItemTemp[j].getContenido() != null) {
					
					contenido = divisionItemTemp[j].getContenido();
					itemsDivi.add(contenido);
					
				}	
				
			}

			if (divisionItemTemp.length == 3) {
				
				while (divisionItemTemp[2].getItem() != null) {
					
					DivisionItem[] temp = divisionItemTemp[2].getItem();
					int j = 0;
					
					for (j = 0; j < temp.length; j++) {
						
						if (temp[j].getTitulo() != null) {
							
							titulo = temp[j].getTitulo();
							itemsDivi.add(titulo);
							
						}
						
						if (temp[j].getContenido() != null) {
							
							contenido = temp[j].getContenido();
							itemsDivi.add(contenido);
							
						}
						
						if (j == 2) {
							
							divisionItemTemp[j] = temp[j];
							
						}
						
					}
					
					if (j == 2) {
						
						divisionItemTemp[2].setItem(null);
						
					}
					
				}
				
			}
			
		}
		
		for (int k = 0; k < itemsDivi.size(); k++) {
			
			if (k % 2 == 0) {
				
				System.out.println("Titulo: "+itemsDivi.get(k));
				
			}
			
			else {
				
				System.out.println("Contenido: "+itemsDivi.get(k));
				
			}
			
		}

		String listString = "";
		
		for (String s: itemsDivi) {
			
			listString += s + "." + "\t";
			
		}
		
		return aac(listString);
	}
	
	public byte[] aac(DivisionItem[] divisionItem) {
		
		ArrayList<String> itemsDivi = new ArrayList<String>();
		String titulo;
		String contenido;
		
		for (int i = 0; i < divisionItem.length; i++){		
			
			if (divisionItem[i].getTitulo() != null){
				
				titulo = divisionItem[i].getTitulo();
				itemsDivi.add(titulo);
				
			}
			
			if (divisionItem[i].getContenido() != null){
				
				contenido = divisionItem[i].getContenido();
				itemsDivi.add(contenido);
				
			}
			
			if(divisionItem[i].getItem() != null) {
				
				DivisionItem[] divisionItemTemp = divisionItem[i].getItem();
				
				for (int j = 0; j < divisionItemTemp.length; j++) {
					
					if (divisionItemTemp[j].getTitulo() != null) {
						
						titulo = divisionItemTemp[j].getTitulo();
						itemsDivi.add(titulo);
						
					}
					
					if (divisionItemTemp[j].getContenido() != null) {
						
						contenido = divisionItemTemp[j].getContenido();
						itemsDivi.add(contenido);
						
					}
					
				}
			
				if (divisionItemTemp.length == 3) {
					
					while (divisionItemTemp[2].getItem() != null) {
						
						DivisionItem[] temp = divisionItemTemp[2].getItem();
						int j = 0;
						
						for (j = 0; j < temp.length; j++) {
							
							if (temp[j].getTitulo() != null) {
								
								titulo = temp[j].getTitulo();
								itemsDivi.add(titulo);
								
							}
							
							if (temp[j].getContenido() != null) {
								
								contenido = temp[j].getContenido();
								itemsDivi.add(contenido);
								
							}
							
							if (j == 2) {
								
								divisionItemTemp[j] = temp[j];
								
							}
							
						}
						
						if (j == 2) {
							
							divisionItemTemp[2].setItem(null);
							
						}
						
					}	
					
				}
				
			}	
			
		}
		
		for (int k = 0; k < itemsDivi.size(); k++) {
			
			if (k%2 == 0) {
				
				System.out.println("Titulo: "+itemsDivi.get(k));
				
			}
			
			else {
				
				System.out.println("Contenido: "+itemsDivi.get(k));
				
			}
			
		}
		
		String listString = "";
		
		for (String s: itemsDivi) {
			
			listString += s + "." + "\t";
			
		}
		
		return aac(listString);
		
	}
}
