package pe.edu.ulasalle.dima.audata.dto;

public class DivisionItem {
	
	private String titulo;
	private String contenido;
	private DivisionItem item;
	
	DivisionItem() {
		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public DivisionItem getItem() {
		return item;
	}

	public void setItem(DivisionItem item) {
		this.item = item;
	}
	
	
}
