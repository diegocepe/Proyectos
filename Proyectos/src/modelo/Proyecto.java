package modelo;

import java.util.Date;

public class Proyecto {
	
	private int cod_proyecto;
	private String nombre_proyecto;
	private Date fecha_inicio;
	private Date fecha_fin;
	private String cliente;
	
	public Proyecto(int cod_proyecto, String nombre_proyecto, Date fecha_inicio, Date fecha_fin, String cliente) {
		super();
		this.cod_proyecto = cod_proyecto;
		this.nombre_proyecto = nombre_proyecto;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.cliente = cliente;
	}

	public int getCod_proyecto() {
		return cod_proyecto;
	}

	public void setCod_proyecto(int cod_proyecto) {
		this.cod_proyecto = cod_proyecto;
	}

	public String getNombre_proyecto() {
		return nombre_proyecto;
	}

	public void setNombre_proyecto(String nombre_proyecto) {
		this.nombre_proyecto = nombre_proyecto;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}	

}
