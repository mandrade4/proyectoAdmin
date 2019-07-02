package pe.edu.ulasalle.dima.audata.text_html.engine;

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
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderHtmlImplEngine implements IReaderHtmlEngine {
	String[] tagList;
	String[] stopTagList;
	String[] stopTagContentList;
	String tagContent;
	
    public ReaderHtmlImplEngine(){}

    public String leerSinTags(String htmlI) throws IOException {
    	Document doc = Jsoup.parse(htmlI);	
    	return doc.text();
    }
    
    public String leer(String htmlI) throws IOException {
        String webPage = htmlI;
        String html = Jsoup.connect(webPage).get().html();
        Document doc = Jsoup.parse(html);
        return doc.text();
    }

    public String[] leerTags(String htmlI) throws IOException {
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
    
    public String[] leerTagsURL(String htmlI) throws IOException {
    	List<String> tagList = new ArrayList<String>();
    	String webPage = htmlI;
        String html = Jsoup.connect(webPage).get().html();
        Document doc = Jsoup.parse(html);
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

    public String leerTagContents(String htmlI, String tagI) {	
    	Document document = Jsoup.parse(htmlI);
    	Elements link = document.select(tagI); 
        System.out.println(link.text());
		return link.text();
    }
    
    public String leerTagContentsURL(String htmlI, String tagI) throws IOException {	
    	String webPage = htmlI;
    	String html = Jsoup.connect(webPage).get().html();
    	Document doc = Jsoup.parse(html);
    	Elements link = doc.select(tagI); 
        return link.text();
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
		return "ok";
 }
	
	public String stopTagListURL(String htmlI,String [] nombres) throws IOException{
		List<String> tagList = new ArrayList<String>();
		String webPage = htmlI;
		String html = Jsoup.connect(webPage).get().html();
		Document doc = Jsoup.parse(html);
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
		return "ok";
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
	 
	public String leerSinTagParametros(String html, String a, String b) throws FileNotFoundException, IOException {

		FileInputStream f = new FileInputStream(html);
		StringBuilder sb = new StringBuilder();
		Reader r = new InputStreamReader(f, "UTF-8");
		BufferedReader br = new BufferedReader(r);
		String line;

		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		int positiona = sb.indexOf(a);
		int positionb = sb.indexOf(b);
		String result = "";
		if (positiona != -1) {
			if (positionb != -1) {
				result = sb.substring(positiona, positionb);
				result += b;
			} else {
				System.out.println("la palabra " + b + " no ha sido encontrada");
			}
		}

		else {
			System.out.println("la palabra " + a + "  no ha sido encontrada");
		}

		String textOnly = Jsoup.parse(result).text();
		return textOnly;
	}

	public List<String> leerSinTagPorFraseTitulo(String html) throws FileNotFoundException, IOException {
		List<String> mylist = new ArrayList<String>();
		String aux = "";
		String item;
		String patternStr = "<H[1-6]>";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = null;
		while (true) {
			matcher = pattern.matcher(html);
			int positiona = -1;
			if (matcher.find()) {
				positiona = matcher.start();
			}

			aux = html.substring(positiona + 1);
			matcher = pattern.matcher(aux);

			int positionb = -1;
			if (matcher.find()) {
				positionb = matcher.start();
			}
			if (positiona != -1)
				if (positionb != -1) {
					item = html.substring(positiona, (positiona + positionb));
					html = html.substring(positiona + positionb);
					item = Jsoup.parse(item.toString()).text();
					mylist.add(item);
				} else {
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

	public String leerSinTagURL(String html1) throws IOException {

		String webPage = html1;
		String html = Jsoup.connect(webPage).get().html();
		Document doc = Jsoup.parse(html);
		String textOnly = doc.text();
		return textOnly;

	}

	public String leerSinTagParametrosURL(String html, String a, String b) throws FileNotFoundException, IOException {

		String webPage = html;
		String htmlc = Jsoup.connect(webPage).get().html();

		int positiona = htmlc.indexOf(a);
		int positionb = htmlc.indexOf(b);
		String result = "";
		if (positiona != -1) {

			if (positionb != -1) {
				result = htmlc.substring(positiona, positionb);
				result += b;
			} else {
				System.out.println("la palabra " + b + " no ha sido encontrada");
			}
		} else {
			System.out.println("la palabra " + a + "  no ha sido encontrada");
		}

		String textOnly = Jsoup.parse(result).text();
		return textOnly;

	}

	public List<String> leerSinTagPorFraseTituloURL(String html) throws FileNotFoundException, IOException {

		String webPage = html;
		String htmlc = Jsoup.connect(webPage).get().html();

		List<String> mylist = new ArrayList<String>();

		String aux = "";
		String item;
		String patternStr = "<h[1-6]>";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = null;
		while (true) {
			matcher = pattern.matcher(htmlc);
			int positiona = -1;
			if (matcher.find()) {
				positiona = matcher.start();
			}

			aux = htmlc.substring(positiona + 1);
			matcher = pattern.matcher(aux);

			int positionb = -1;
			if (matcher.find()) {
				positionb = matcher.start();
			}
			if (positiona != -1)
				if (positionb != -1) {
					item = htmlc.substring(positiona, (positiona + positionb));
					htmlc = htmlc.substring(positiona + positionb);
					item = Jsoup.parse(item.toString()).text();

					mylist.add(item);
				} else {
					htmlc = htmlc.substring(positiona);

					htmlc = Jsoup.parse(htmlc.toString()).text();

					mylist.add(htmlc);

					break;
				}
			else {
				break;
			}

		}
		return mylist;
	}
	
	public String leerTagsDeUnTag(String htmlI,String nombres,String[] stopTagContentList) throws IOException{
		List<String> tagList = new ArrayList<String>();
    	Document doc = Jsoup.parse(htmlI);
        int i=0;
        for(Element elem : doc.select("*")){
            String a = elem.tagName();
            tagList.add(a);
            tagList.get(i);
            i++;
        }

        String nom;
	    int n,o;
	    boolean encontrado = false;
	    nom = nombres;
	    for(o = 0; o < 1; o++) 
	    {
		    for(n = 0; n < tagList.size(); n++)	
	    	{ 
	    		if (!nom.equals(tagList.get(n)))	
	    		{
	    			//System.out.println("dato encontrado");
					encontrado = true;
					tagList.clear();
					tagList.add(nom);
					System.out.println();
	    		}
	    	}
	    }	
	    if (!encontrado)
	    	System.out.println("etiqueta no encontrado");
	    String tag = String.join("", tagList);
		String content = leerTagContentsURL(htmlI,tag);
		return eliminandoContentList(content,stopTagContentList);
	}
	
	public void stopTagLista(String [] nombres,String htmlI) throws IOException{

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
					leerTagContents(htmlI,nom[o]); //e
				}
			}
		}	
		if (!encontrado)
			System.out.println("etiqueta no encontrado");
	}
	
	public String eliminandoContentList(String url,String purge[]) {
		System.out.println(url);
		String result = url;
		for (int i = 0; i < purge.length; ++i)
		{
		    result = result.replace(purge[i], "");
		}
		return result;
	}
	 	 
	public String leerTagContents(String htmlI,String tagI,String[] stopTagListI,String[] stopTagContentList) throws IOException {

		String webPage = htmlI;
		String html = Jsoup.connect(webPage).get().html();
		Document document = Jsoup.parse(html);
		Element div = document.select(tagI).first();
		Elements divChildren = div.children();

		Elements detachedDivChildren = new Elements();
		for (Element elem : divChildren) {
			Element detachedChild = new Element(Tag.valueOf(elem.tagName()),
					elem.baseUri(), elem.attributes().clone());
			detachedDivChildren.add(detachedChild);
		}
		List<String> tagList = new ArrayList<String>();
		System.out.println(divChildren.size());
		int i=0;
		for (Element elem : divChildren) {
			System.out.println(elem.tagName());
			String a = elem.tagName();
			tagList.add(a);
			tagList.get(i);
			i++;
		}

		int o,n;
		for(o = 0; o < stopTagListI.length; o++) 
		{
			for(n = 0; n < tagList.size(); n++)	
			{ 
				if (stopTagListI[o].equals(tagList.get(n)))	
				{
					tagList.remove(stopTagListI[o]);
				}
			}
		}	
		System.out.println(tagList);
		String tag2 = String.join(",", tagList);
		System.out.println("tag2"+tag2);
		String[] arr3 = new String[tagList.size()];
		String[] arr2 = new String[tagList.size()]; 
		for (int j =0; j < tagList.size(); j++) {
			arr2[j] = tagList.get(j);
			arr3[j] = leerTagContentsURL(htmlI,arr2[j]);
		}

		for (int a =0; a < tagList.size();a++) {
			System.out.println("arr3"+arr3[a]);
		}

		List<String> myStringList = new ArrayList<String>(arr3.length);
		for (String s:arr3) {
			myStringList.add( s );
		}
		//System.out.println("omg"+myStringList);
		String tag3 = String.join(" ", myStringList);
		return (eliminandoContentList(tag3,stopTagContentList));
	 }

	 public List<String> DivisorHtmlPorTagURL(String htmlI) throws IOException {

		 String webPage = htmlI;
		 String html = Jsoup.connect(webPage).get().html();
		 Document document = Jsoup.parse(html);
		 Element div = document.select("body").first();
		 Elements divChildren = div.children();

		 Elements detachedDivChildren = new Elements();
		 for (Element elem : divChildren) {
			 Element detachedChild = new Element(Tag.valueOf(elem.tagName()),
					 elem.baseUri(), elem.attributes().clone());
			 detachedDivChildren.add(detachedChild);
		 }
		 
		 List<String> tagList = new ArrayList<String>();
		 for (Element elem : divChildren) {
			 String b = elem.text();
			 tagList.add(b);
		 }

		 return tagList;
	 }
	 
	 
    public static void main(String[] args) throws IOException
    {
    	ReaderHtmlImplEngine IJava2 = new ReaderHtmlImplEngine();
    	//String htmlString = "<html><head><title>My title</title></head><body>Body content<p1>Parrafo1<p2>Parrafo2</p2></p1><p3>Parrafo3</p3><p4>Parrafo4</p4></body></html>";
    	//String stopTagList[] = {"p1"};//funciona
    	//System.out.println(IJava2.leer("https://www.hazunaweb.com/curso-de-html/estructura-basica-una-pagina-web/")); //funciona
    	//System.out.println(IJava2.leer("https://www.ulasalle.edu.pe/")); //funciona	
    	//String stopTagContentList[] = {"Estructura","web","HTML"};//funciona
    	//System.out.println(IJava2.leerTagsDeUnTag("https://www.hazunaweb.com/curso-de-html/estructura-basica-una-pagina-web/","body",stopTagContentList)); //PITITO
    	//IJava2.stopTagLista(stopTagList,htmlString);
    	//String stopTagContentList2[] = {"Sponsored","Listings"};
    	//System.out.println(IJava2.leerTagsDeUnTag("http://sssyoutu.be/w2wzVg0owxU","body",stopTagContentList2));
    	//System.out.println("IMPORTANTE");
    	//System.out.println(IJava2.leerTagContentsURL2("http://www.mit.edu/", "body"));
    	String stopTagList[] = {"p1"};
    	String stopTagContentList3[] = {"Comprar"};
    	System.out.println(IJava2.leerTagContents("http://sssyoutu.be/w2wzVg0owxU","body",stopTagList,stopTagContentList3));
    	//System.out.println(IJava2.DivisorHtmlPorTagURL("http://sssyoutu.be/w2wzVg0owxU"));
    	//System.out.println(IJava2.leerSinTagPorFraseTituloURL("https://es.wikipedia.org/wiki/Wikipedia:Portada"));
    }
}
