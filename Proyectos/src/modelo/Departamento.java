package modelo;

public class Departamento {
	
	private int cod_departamento;
	private String nombre_departamento;
	
	public Departamento() {
		super();
	}

	public Departamento(int cod_departamento, String nombre_departamento) {
		super();
		this.cod_departamento = cod_departamento;
		this.nombre_departamento = nombre_departamento;
	}

	public int getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}

	public String getNombre_departamento() {
		return nombre_departamento;
	}

	public void setNombre_departamento(String nombre_departamento) {
		this.nombre_departamento = nombre_departamento;
	}
	
	
	
	

}
