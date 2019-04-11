package modelo;

public class Empleado {
	
	private int num_empleado;
	private String nombre;
	private String direccion;
	private String tipo;
	private int cod_departamento;

	public Empleado() {
		super();
	}

	public Empleado(int num_empleado, String nombre, String direccion, String tipo, int cod_departamento) {
		super();
		this.num_empleado = num_empleado;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipo = tipo;
		this.cod_departamento = cod_departamento;
	}

	public int getNum_empleado() {
		return num_empleado;
	}

	public void setNum_empleado(int num_empleado) {
		this.num_empleado = num_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCod_departamento() {
		return cod_departamento;
	}

	public void setCod_departamento(int cod_departamento) {
		this.cod_departamento = cod_departamento;
	}
	
}
