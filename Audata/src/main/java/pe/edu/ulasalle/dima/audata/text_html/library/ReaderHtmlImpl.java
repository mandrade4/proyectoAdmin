package pe.edu.ulasalle.dima.audata.text_html.library;

import pe.edu.ulasalle.dima.audata.text_html.library.IReaderHtml;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderHtmlImpl implements IReaderHtml {
	String[] tagList;
	String[] stopTagList;
	String[] stopTagContentList;
	String tagContent;
	
    //Constructor con el mismo nombre de la clase
    public ReaderHtmlImpl(){}

    //Métodos de la clase
    
    public String leerSinTags(String htmlI) throws IOException {
    	Document doc = Jsoup.parse(htmlI);	
    	return doc.text();
    }

    public String[] leerTags(String htmlI) throws IOException{
    	List<String> tagList = new ArrayList<String>();
    	Document doc = Jsoup.parse(htmlI);
        int i=0;
        for(Element elem : doc.select("*")){
            String a = elem.tagName();
            tagList.add(a);
            tagList.get(i);
            i++;
        }

        String[] arr = new String[tagList.size()]; 
        for (int j =0; j < tagList.size(); j++) 
            arr[j] = tagList.get(j);
        
        for (int k =0; k < tagList.size(); k++) 
        	System.out.println(arr[k]);
        	
    	return arr;
    }

    public String leerTagContents(String htmlI, String tagI) throws IOException
    {	
    	String TagContent2 = null;
    	try {
    	Document document = Jsoup.parse(htmlI);
    	Elements link = document.select(tagI); 
        System.out.println("Texto obtenido de la etiqueta: " + link.text());
        TagContent2 = link.text();
    	}catch (Exception e) {
    		System.out.println("Error: El tag ingresado no existe dentro del documento");
    	}
		return TagContent2;
    }
  
    public String leerTagContents(String htmlI,String tagI,String[] stopTagListI,String[] stopTagContentList) throws IOException
    {
    	stopTagList=tagList;
    	String nom[];
    	int n,i;
	    boolean encontrado = false;
	    nom = stopTagListI;
    	
    	try {
    	Document document = Jsoup.parse(htmlI);
    	Elements link = document.select("p"); 
        System.out.println("Text: " + link.text());
        String TagContent2 = link.text();
        tagContent = TagContent2;
        
	    for(i = 0; i < nom.length; i++) 
	    {
	    	for(n = 0; n < stopTagList.length; n++)
	    	{ 
	    		if (nom[i].equals(stopTagList[n]))
	    		{
	    			System.out.println("dato encontrado");
					encontrado = true;
					leerTagContents(htmlI,nom[i]);
	    		}
	    	}
	    }	
	    if (!encontrado)
	    	System.out.println("etiqueta no encontrado");
        
    	}catch (Exception e) {
    		System.out.println("Error: El tag ingresado no existe dentro del documento");
    	}
    	
		return tagContent;
    }
    
	public String stopTagList(String [] nombres,String htmlI) throws IOException{
	    
		List<String> tagList = new ArrayList<String>();
    	Document doc = Jsoup.parse(htmlI);
        int i=0;
        for(Element elem : doc.select("*")){
            String a = elem.tagName();
            tagList.add(a);
            tagList.get(i);
            i++;
        }

        String[] arr = new String[tagList.size()]; 
        for (int j =0; j < tagList.size(); j++) 
            arr[j] = tagList.get(j);

        List<String> stopTagLista = tagList;
	    System.out.println(tagList);
        String nom[];
	    int n,o;
	    boolean encontrado = false;
	    nom = nombres;
	    for(o = 0; o < nom.length; o++) 
	    {
		    for(n = 0; n < stopTagLista.size(); n++)	
	    	{ 
	    		if (nom[o].equals(stopTagLista.get(n)))	
	    		{
	    			System.out.println("dato encontrado");
					encontrado = true;
					stopTagLista.remove(nom[o]);
					System.out.println();
	    		}
	    	}
	    }	
	    if (!encontrado)
	    	System.out.println("etiqueta no encontrado");
	    System.out.println(tagList);
		return leerTagContents(htmlI,nom[o]);
 }
    
    public String procesarHTML(String archivo) {
        StringBuilder sb = new StringBuilder();
        String linea;
        File f = new File(archivo);
        FileReader fr;
        BufferedReader br = null;

        try {
            try {
                fr = new FileReader(f);
                br = new BufferedReader(fr);

                while ((linea = br.readLine()) != null) {
                    sb.append(linea);
                    sb.append('\n');
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error entrada/salida");
        }
        String sbt = sb.toString();
        return sbt;
    }
	
	public String[] DivisorHtmlPorTag(String htmlI) throws IOException{
	    stopTagList= tagList;
	    ReaderHtmlImpl reader = new ReaderHtmlImpl();
	    String[] divisorItems = reader.leerTags(htmlI);	
	    List<String> tagList = new ArrayList<String>();
	    for(int x = 1; x < divisorItems.length; x++){ 
	    	String b = leerTagContents(htmlI,divisorItems[x]);
	    	tagList.add(b);
	    }
	    
        String[] arr = new String[tagList.size()]; 
        for(int j = 0; j < tagList.size(); j++) 
            arr[j] = tagList.get(j);
        
	    return arr;
	}
	 
	 public String leerSinTagParametros( String html,String a ,String b ) throws FileNotFoundException, IOException{
			
		 FileInputStream f = new FileInputStream(html);
		 StringBuilder sb = new StringBuilder();
		 Reader r = new InputStreamReader(f, "UTF-8"); 
		 BufferedReader br = new BufferedReader(r);
		 String line;
		    
		 while ( (line=br.readLine()) != null ) {
			 sb.append(line);
		 }
		 br.close();
		 int positiona = sb.indexOf(a);
		 int positionb = sb.indexOf(b);
		 String result = "";
		 if(positiona != -1 ){
			 if(positionb != -1) {
				 result = sb.substring(positiona, positionb);
				 result += b;
			 }else {
				 System.out.println("la palabra " + b +" no ha sido encontrada");
			 }
		 }
		 
		 else {
			 System.out.println("la palabra "+ a +  "  no ha sido encontrada");
		 }

		    String textOnly = Jsoup.parse(result).text();
		    return textOnly;
		}
		
	 
	public List<String> leerSinTagPorFraseTitulo( String html) throws FileNotFoundException, IOException{
		List<String> mylist = new ArrayList<String>();
		String aux = "";
		String item;
		String patternStr = "<H[1-6]>";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = null;
		while (true) {
			matcher = pattern.matcher(html);
			int positiona=-1;
			if(matcher.find()){
				positiona = matcher.start();
			}
		    	
			aux = html.substring(positiona+1);
			matcher = pattern.matcher(aux);
		    	
			int positionb = -1;
			if(matcher.find()){
				positionb = matcher.start();
			}
			if( positiona != -1)
				if( positionb != -1 ) {
					item = html.substring(positiona, (positiona+positionb) );
					html = html.substring(positiona+positionb );
					item = Jsoup.parse(item.toString()).text();    
					mylist.add(item);
				}
				else {
					html = html.substring(positiona);    		    
					html = Jsoup.parse(html.toString()).text();   
					mylist.add(html);
					break;
				}
			else {
		    		break;
		    	}
		    }
		    return mylist;
		  }
	
    public static void main(String[] args) throws IOException
    {
    	//ARCHIVOS DE EJEMPLO
    	//ReaderHtmlImpl IJava2 = new ReaderHtmlImpl();
    	//String archivo = ("C:/Users/USUARIO/Desktop/Yasiel Final/Archivos/ArchivoBueno.html");
    	//String htmlString = "<html><head><title>My title</title></head>" + "<body>Body content<p>Parrafo1<p>Parrafo2</p></p></body></html>";
    	//String html2 = IJava2.procesarHTML(archivo);
    	//FUNCIONES
    	//System.out.println(IJava2.leerSinTags(html2)); //funciona
    	//System.out.println(IJava2.leerSinTagParametros(archivo,"Parrafo2","comunidad")); //funciona
    	//System.out.println(IJava2.leerTags(html2));  //funciona
    	//IJava2.leerTags(archivo); //funciona
    	//System.out.println(IJava2.leerSinTags(html2)); //funciona
    	//System.out.println(IJava2.leerSinTags(htmlString)); //funciona
    	//IJava2.leerTagContents(html2,"body");//funciona
    	//System.out.println(IJava2.leerTagContents(html2,"p"));//funciona
    	//IJava2.leerTagContents(htmlString,"title");//funciona
    	//System.out.println(IJava2.leerTagContents(htmlString,"title"));//funciona
    	//IJava2.leerTagContents(htmlString,"p");//funciona
    	//IJava2.DivisorHtmlPorTag(html2);//funciona
    	//String stopTagList[] = {"body"};//funciona
    	//IJava2.stopTagList(stopTagList,htmlString);//funciona
    	//System.out.println(IJava2.leerSinTagPorFraseTitulo(html2));//funciona

    }
}
