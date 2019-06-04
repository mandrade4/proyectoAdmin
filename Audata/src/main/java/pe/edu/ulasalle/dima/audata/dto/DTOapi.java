package pe.edu.ulasalle.dima.audata.dto;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class DTOapi {

    private byte[] data;   
    private int pagina;

    private String paginaInicio;
    private String paginaFin;
    
    public DTOapi() {
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


}