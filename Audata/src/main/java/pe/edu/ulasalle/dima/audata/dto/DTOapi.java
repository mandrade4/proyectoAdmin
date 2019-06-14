package pe.edu.ulasalle.dima.audata.dto;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class DTOapi {

    private byte[] data;   
    private int pagina;
    private String bookmark;
    private String paginaInicio;
    private String paginaFin;
	private String palabraInicio;
	private String palabraFin;
    
    public DTOapi() {
    }
    
	public String getBookmark() {
		return bookmark;
	}
	
	@FormParam("bookmark")
	public void setBookmark(String bookmark) {
		this.bookmark = bookmark;
	}
    public String getPaginaInicio() {
		return paginaInicio;
	}
    
    @FormParam("paginaInicio")
	public void setPaginaInicio(String paginaInicio) {
		this.paginaInicio = paginaInicio;
	}

    public int getPagina() {
        return pagina;
    }

	public String getPaginaFin() {
		return paginaFin;
	}
	
	@FormParam("paginaFin")
	public void setPaginaFin(String paginaFin) {
		this.paginaFin = paginaFin;
	}
    
    @FormParam("page")
    public void setPagina(int pagina) {
        this.pagina = pagina;
    }


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