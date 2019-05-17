package pe.edu.ulasalle.dima.audata.dto;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

    private byte[] data;
    private int inicio;
    private int fin;
    private String[] stopList = {"pdf", "advanced"};
    private String palabraInicio;
    private String palabraFin;
    private String bookmark;
    private int pagina;
    
    
    public String getBookmark() {
		return bookmark;
	}

    @FormParam("sbook")
	public void setBookmark(String bookmark) {
		this.bookmark = bookmark;
	}

    public int getPagina() {
		return pagina;
	}

    @FormParam("page")
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}

	public String[] getStopList() {
		return stopList;
	}

	public FileUploadForm() {
    }

    public byte[] getData() {
        return data;
    }

    @FormParam("uploadedFile")
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
    }

    public int getInicio() {
        return inicio;
    }

    @FormParam("init")
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    @FormParam("end")
    public void setFin(int fin) {
        this.fin = fin;
    }

	public String getPalabraInicio() {
		return palabraInicio;
	}

	@FormParam("pini")
	public void setPalabraInicio(String palabraInicio) {
		this.palabraInicio = palabraInicio;
	}

	public String getPalabraFin() {
		return palabraFin;
	}

	@FormParam("pfin")
	public void setPalabraFin(String palabraFin) {
		this.palabraFin = palabraFin;
	}
    
    

}