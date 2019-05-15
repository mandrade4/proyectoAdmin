package pe.edu.ulasalle.dima.audata.test;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

    private byte[] data;
    private int inicio;
    private int fin;
    private String[] stopList;
    private String palabraInicio;
    private String palabraFin;

    public String[] getStopList() {
		return stopList;
	}

    @FormParam("stoplist")
	public void setStopList(String[] stopList) {
		this.stopList = stopList;
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