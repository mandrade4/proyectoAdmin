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
    private String[] stopList;
    private String sL;
    
    //edu
    private String title;
    private String dataHtml;
	private String tag;
    private String divisor;
    private String[] stopTagList;
    private String[] stopTagContentList;
    
    public DTOapi() {
    }
    
    public String getsL() {
		return sL;
	}

    @FormParam("sL")
	public void setsL(String sL) {
    	stopList = sL.split("::");  	
	}
    
    public String[] getStopList() {
        return stopList;
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

    //HTML
    
    public String getTag() {
		return tag;
	}
    
    @FormParam("tag")
	public void setTag(String tag) {
		this.tag = tag;
	}
    
	public String getDivisor() {
		return divisor;
	}
	
    @FormParam("divisor")
	public void setDivisor(String divisor) {
		this.divisor = divisor;
	}
    
    public String getDataHtml() {
		return dataHtml;
	}

    @FormParam("uploadedFile2")
    @PartType("application/octet-stream")
	public void setDataHtml(String dataHtml) {
		this.dataHtml = dataHtml;
	}

	public String[] getStopTagList() {
		return stopTagList;
	}

    @FormParam("stopTagList")
	public void setStopTagList(String[] stopTagList) {
		this.stopTagList = stopTagList;
	}

	public String[] getStopTagContentList() {
		return stopTagContentList;
	}

    @FormParam("stopTagContentList")
	public void setStopTagContentList(String[] stopTagContentList) {
		this.stopTagContentList = stopTagContentList;
	}

	public String getTitle() {
		return title;
	}
	
	@FormParam("title")
	public void setTitle(String title) {
		this.title = title;
	}

}