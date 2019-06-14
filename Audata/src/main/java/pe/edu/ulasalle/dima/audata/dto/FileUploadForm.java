package pe.edu.ulasalle.dima.audata.dto;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

    private byte[] data;
    private String[] stopList;
    private String sL;
	private String palabraInicio;
    private String palabraFin;
    private String bookmark;
   
    private int pagina;

    private String paginaInicio;
    private String paginaFin;
    
    public FileUploadForm() {
    }


    public String getsL() {
		return sL;
	}

    @FormParam("sL")
	public void setsL(String sL) {
    	stopList = sL.split("::");  	
//		this.sL = sL;
	}
    
    public String getPaginaInicio() {
		return paginaInicio;
	}
    
    @FormParam("paginaInicio")
	public void setPaginaInicio(String paginaInicio) {
		this.paginaInicio = paginaInicio;
	}

	public String getPaginaFin() {
		return paginaFin;
	}
	
	@FormParam("paginaFin")
	public void setPaginaFin(String paginaFin) {
		this.paginaFin = paginaFin;
	}

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
//    
//    @FormParam("stop")
//    public void setStopList(String[] stopList) {
//		this.stopList = stopList;
//	}

	public byte[] getData() {
        return data;
    }

    @FormParam("uploadedFile")
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
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