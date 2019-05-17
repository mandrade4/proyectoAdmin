package pe.edu.ulasalle.dima.audata.dto;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadFormHtml {
	private String data;
    private String[] stopTagList = {"a","p"};
    private String[] stopTagContentList;
    private String inicio;
    private String fin;
    private String tag;

    public String getTag() {
		return tag;
	}

    @FormParam("tag")
	public void setTag(String tag) {
		this.tag = tag;
	}

	public String[] getStopTagList() {
		return stopTagList;
	}

    @FormParam("stopTaglist")
	public void setStopTagList(String[] stopTagList) {
		this.stopTagList = stopTagList;
	}
    
    public String[] getStopTagContentList() {
		return stopTagContentList;
	}

    @FormParam("stopTaglist")
	public void getStopTagContentList(String[] stopTagContentList) {
		this.stopTagContentList = stopTagContentList;
	}

	public FileUploadFormHtml() {
    }

    public String getData() {
        return data;
    }

    @FormParam("uploadedFileHtml")
    @PartType("application/octet-stream")
    public void setData(String data) {
        this.data = data;
    }

	public String getInicio() {
		return inicio;
	}

	@FormParam("inicio")
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	@FormParam("fin")
	public void setFin(String fin) {
		this.fin = fin;
	}
    
}
