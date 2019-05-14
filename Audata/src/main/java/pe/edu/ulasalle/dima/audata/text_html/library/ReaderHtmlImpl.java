package pe.edu.ulasalle.dima.audata.text_html.library;

import pe.edu.ulasalle.dima.audata.dto.DivisionItem;
import pe.edu.ulasalle.dima.audata.text_html.library.IReaderHtml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import java.awt.List;
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
        //Document doc = Jsoup.parse(new File(htmlI), "utf-8"); --RESOLVER
    	Document doc = Jsoup.parse(htmlI);	
    	return doc.text();
    	//return doc.body().text();
    }

    public String[] leerTags(String htmlI) throws IOException{
    	//tagList = new String[9];
    	List<String> tagList = new ArrayList<String>();
        //Document doc = Jsoup.parse(new File(htmlI), "utf-8"); --RESOLVER
    	Document doc = Jsoup.parse(htmlI);
        int i=0;
        for(Element elem : doc.select("*")){
            //System.out.println("Tag Name : " + elem.tagName());
            String a = elem.tagName();
            tagList.add(a);
            //tagList[i] = a;
            //System.out.println(tagList[i]); //comentar
            tagList.get(i);
            i++;
            //System.out.println("Value : " + elem.text());
            //System.out.println();
        }

        String[] arr = new String[tagList.size()]; 
        for (int j =0; j < tagList.size(); j++) 
            arr[j] = tagList.get(j);
        /*
        for(String x : arr)
        	System.out.println(x + " ");
        */
        for (int k =0; k < tagList.size(); k++) 
        	System.out.println(arr[k]);
        	
    	return arr;
    }

    public String leerTagContents(String htmlI, String tagI) throws IOException
    {	
    	String TagContent2 = null;
    	try {
    	Document document = Jsoup.parse(htmlI);
        //System.out.println(document);
    	Elements link = document.select(tagI); 
        System.out.println("Texto obtenido de la etiqueta: " + link.text());
        TagContent2 = link.text();
        //String TagContent2 = link.text();
        //tagContent = TagContent2;
    	}catch (Exception e) {
    		System.out.println("Error: El tag ingresado no existe dentro del documento");
    	}
    	//return tagContent
		return TagContent2;
    }
    
    public String leerTagContentsbyRestrictions(String htmlI, String tagI) throws IOException{
    	String TagContent2 = null;
    	try {
    	Document document = Jsoup.parse(htmlI);
        //System.out.println(document);
    	Elements link = document.select(tagI); 
        System.out.println("Texto obtenido de la etiqueta: " + link.text());
        System.out.println("Texto obtenido de la etiqueta: " + link.tagName(null));
        TagContent2 = link.text();
        //String TagContent2 = link.text();
        //tagContent = TagContent2;
    	}catch (Exception e) {
    		System.out.println("Error: El tag ingresado no existe dentro del documento");
    	}
    	//return tagContent
		return TagContent2;
    }
  
    public String leerTagContents(String htmlI,String tagI,String[] stopTagListI,String[] stopTagContentList)
    {
    	//String[] a = leerTags(htmlI);
    	stopTagList=tagList;
    	String nom[];
    	int n,i;
	    boolean encontrado = false;
	    nom = stopTagListI;
    	
    	try {
    	Document document = Jsoup.parse(htmlI);
        //System.out.println(document);
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
    
	public void stopTagList(String [] nombres,String htmlI) throws IOException{
	    
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
        /*
        for (int k =0; k < tagList.size(); k++) 
        	System.out.println(arr[k]);
		*/	
		//stopTagList= arr;
        List<String> stopTagLista = tagList;
	    System.out.println(tagList);
	    System.out.println(stopTagLista.size());
        String nom[];
	    int n,o;
	    boolean encontrado = false;
	    nom = nombres;
        System.out.println(nom[0]);
        System.out.println(nom.length);
	    for(o = 0; o < nom.length; o++) 
	    {
	    	//for(n = 0; n < stopTagLista.length; n++)
		    for(n = 0; n < stopTagLista.size(); n++)	
	    	{ 
	    		if (nom[o].equals(stopTagLista.get(n)))
	    		//if (nom[o].equals(stopTagLista.[n]))	
	    		{
	    			System.out.println("dato encontrado");
					encontrado = true;
					stopTagLista.remove(nom[o]);
					leerTagContents(htmlI,nom[o]); //e
	    		}
	    	}
	    }	
	    if (!encontrado)
	    	System.out.println("etiqueta no encontrado");
	    
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
	    //System.out.println("THIS"+stopTagList.length);
	    ReaderHtmlImpl reader = new ReaderHtmlImpl();
	    String[] divisorItems = reader.leerTags(htmlI);	
	    //System.out.println(divisorItems);
	    List<String> tagList = new ArrayList<String>();
	    /*
	    for (int k =0; k < divisorItems.length; k++) 
        	System.out.println(divisorItems[k]);
        
	    //tagListDiv = new String[9];
	    //int i;
        */
	    for(int x = 1; x < divisorItems.length; x++){ 
	    	String b = leerTagContents(htmlI,divisorItems[x]);
	    	tagList.add(b);
	    }
	    //Element link = document.select(tag).first(); //para obtener la primera etiqueta repetida
    	//Element link = document.select(tag).last(); //para obtener la ultima etiqueta repetida
    	//Elements link = document.select(tag).next(); //para obtener el siguiente etiqueta
    	//Element link = document.select(tag).get(0);
	    
        String[] arr = new String[tagList.size()]; 
        for(int j = 0; j < tagList.size(); j++) 
            arr[j] = tagList.get(j);
        
        
	    
	    return arr;
	}

	 public String stopTagContentList(String[] listStop) throws IOException {

		 //InputStream instream = fstream;
		 //String[] stopLista = listStop;
		 //PDDocument document = PDDocument.load(instream);
		 //StringBuilder str = new StringBuilder();

		 //document.getClass();
/*
	     html = str.toString();
	     html = html.toLowerCase();
	     System.out.println(html);
	     
	     for (int i=0; i<stopLista.length ;i++ ){
	    	 html = html.replace(" " + stopLista[i].toLowerCase()+ " "," ");
	     }
*/
	     return "pepehands";
	 }
		
    public static void main(String[] args) throws IOException
    {
    	ReaderHtmlImpl IJava2 = new ReaderHtmlImpl();
    	String archivo = ("C:/Users/USUARIO/Desktop/Yasiel Final/Archivos/ArchivoBueno.html");
    	String htmlString = "<html><head><title>My title</title></head>"
                + "<body>Body content<p>Parrafo1<p>Parrafo2</p></p></body></html>";
    	String html2 = IJava2.procesarHTML(archivo);
    	//FUNCIONES
    	//System.out.println(IJava2.leerTags(htmlString)); //pitito
    	//System.out.println(IJava2.leerTags(archivo));  //pitito
    	//IJava2.leerTags(archivo); //pitito
    	//System.out.println(IJava2.leerSinTags(html2)); //pitito
    	//System.out.println(IJava2.leerSinTags(htmlString)); //pitito
    	//IJava2.leerTagContents(html2,"p");//pitito
    	//System.out.println(IJava2.leerTagContents(html2,"p"));//pitito
    	//IJava2.leerTagContents(htmlString,"title");//pitito
    	//System.out.println(IJava2.leerTagContents(htmlString,"title"));//pitito
    	//IJava2.leerTagContents(htmlString,"p");//pitito
    	//IJava2.leerTagContentsbyRestrictions(htmlString, "p");
    	String stopTagList[] = {"p"};
    	//String stopTagContentList[] = {""};
    	//System.out.println(stopTagList[0]);
    	//IJava2.leerTagContents(html2,"p",stopTagList, stopTagContentList);
    	IJava2.stopTagList(stopTagList,htmlString);
    	//IJava2.stopTagContentList(stopTagContentList);
    	//Java2.leerTagContents(html2, "p", stopTagList, stopTagContentList);
    	//IJava2.DivisorHtmlPorTag(html2);
    	DivisionItem java;
    }
}
