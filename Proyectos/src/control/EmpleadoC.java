package control;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.EnlaceJDBC;
import modelo.Departamento;
import modelo.Empleado;

public class EmpleadoC {

	static EnlaceJDBC enlace;
	
	public static void abrirEnlace() throws SQLException {
		
		enlace=new EnlaceJDBC();
	}
	
	public static void insertarEmpleado() throws ClassNotFoundException, SQLException {
		
//		Insertar un Empleado nuevo en la empresa, incorporando los datos del tipo de empleado  
//		y el departamento asociado. 
//		Si es un técnico, deberá incorporarse el nivel del mismo e insertarlo en la tabla correspondiente
		
		EnlaceJDBC enlace=new EnlaceJDBC();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Escriba el nombre de empleado: ");
		String nombre=sc.nextLine();
		System.out.println("Escriba la dirección de "+nombre);
		String direccion=sc.nextLine();
		System.out.println("Escriba el tipo empleo de "+nombre);
		String tipo=sc.nextLine();
		System.out.println("Elija el departamento en el que trabajará "+nombre);
		
		ArrayList<Departamento> departamentos = DepartamentoC.verDepartamentos();
		
		
//		HAY QUE ORDENAR POR ID. SACA DEPARTAMENTOS ALFABETICAMENTE
		//Collections.sort(departamentos);
		
		
		for(int i = 0; i < departamentos.size(); i++) {
			
			System.out.println((i+1)+" - "+(departamentos.get(i)).getNombre_departamento());
			
		} 
		
		
		
		int departamento=sc.nextInt();
		
		Empleado empleado = new Empleado(0, nombre, direccion, tipo, departamento);
		
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
		PreparedStatement ps = cn.prepareStatement("INSERT INTO EMPLEADO VALUES (?,?,?,?,?)");
		ps.setInt(1, empleado.getNum_empleado());
		ps.setString(2, empleado.getNombre());
		ps.setString(3, empleado.getDireccion());
		ps.setString(4, empleado.getTipo());
		ps.setInt(5, empleado.getCod_departamento());
		
		int tf = ps.executeUpdate();
		
		if(tf > 0) {
			System.out.println(empleado.getNombre() + " insertado correctamente.");
		} else System.out.println("Ha ocurrido un error.");
		
		ps.close();
		cn.close();

	}
	
	public static void modificarEmpleado () {
		
		
//		Modificar los datos de un empleado existente
//		
//		EnlaceJDBC enlace = new EnlaceJDBC();		
//		boolean rowInserted = false;
//		
//		//////
		
		
		
	}
	
	public static void eliminarEmpleado() {
		
//		Eliminar un empleado de la empresa (si el empleado es técnico, eliminar el nivel asociado)
		
		
	}
	
	public static void realizarFichero() {
		
		
//		Realizar un fichero con los empleados asociados
	}

}
