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
	
	public static ArrayList<Empleado> verEmpleados() throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();
		ArrayList<Empleado> resultado = enlace.verEmpleados();
		return resultado;
	}
	
	public static void modificarEmpleado () throws SQLException {
		
		EnlaceJDBC enlace=new EnlaceJDBC();
		Scanner sc=new Scanner (System.in);
		System.out.println("Elija el empleado que desea modificar: ");
		
		EmpleadoC.verEmpleados();
		
		ArrayList<Empleado> empleado = EmpleadoC.verEmpleados();
		
		for (int i = 0; i < empleado.size(); i++) {
			
			System.out.println((i+1)+" - "+(empleado.get(i)).getNombre());
			
		}
		
		int numEmple = sc.nextInt();
		int opcion=0;
		
		System.out.println("¿Qué desea modificar?");
		System.out.println("1. Numero empleado que quiere introducir. ");
		System.out.println("2. Nombre. ");
		System.out.println("3. Direccion. ");
		System.out.println("4. Tipo. ");
		System.out.println("5. Departamento. ");
		
		switch (opcion) {
		case 1:	
			int num=sc.nextInt();
			break;
		case 2:
			String nombre=sc.nextLine();
			break;
		case 3:
			String direccion=sc.nextLine();
			break;
		case 4:
			String tipo=sc.nextLine();
			break;
		case 5:
			System.out.println("Elija el departamento: ");
			
			ArrayList<Departamento> departamentos = DepartamentoC.verDepartamentos();
			
			
			for(int i = 0; i < departamentos.size(); i++) {
				
				System.out.println((i+1)+" - "+(departamentos.get(i)).getNombre_departamento());
				
			} 
			
			int departamento=sc.nextInt();
			break;

		default:
			
			

			
			Empleado modEmpleado = new Empleado(num, nombre, direccion, tipo, departamento);
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
			PreparedStatement ps = cn.prepareStatement("INSERT INTO EMPLEADO VALUES (?,?,?,?,?)");
			ps.setInt(1, modEmpleado.getNum_empleado());
			ps.setString(2, modEmpleado.getNombre());
			ps.setString(3, modEmpleado.getDireccion());
			ps.setString(4, modEmpleado.getTipo());
			ps.setInt(5, modEmpleado.getCod_departamento());
			
			int tf = ps.executeUpdate();
			
			if(tf > 0) {
				System.out.println(modEmpleado.getNombre() + " modificado correctamente.");
			} else System.out.println("Ha ocurrido un error.");
			
			ps.close();
			cn.close();
			sc.close();
			
			break;
		}
		

		

		
	}
		
		
		
		
	
	public static void eliminarEmpleado() throws SQLException {
		
//		Eliminar un empleado de la empresa (si el empleado es técnico, eliminar el nivel asociado)
		
		
		
		Scanner sc=new Scanner (System.in);
		System.out.println("Elija el empleado que desea eliminar: ");
		
		EmpleadoC.verEmpleados();
		
		ArrayList<Empleado> empleado = EmpleadoC.verEmpleados();
		
		for (int i = 0; i < empleado.size(); i++) {
			
			System.out.println((i+1)+" - "+(empleado.get(i)).getNombre());
			
		}
		int num=sc.nextInt();
		
		EnlaceJDBC enlace=new EnlaceJDBC();
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
		PreparedStatement ps = cn.prepareStatement("DELETE FROM empleado WHERE num_empleado=? ");
		Empleado eliminarEmpleado = new Empleado(num);
		String query= "DELETE FROM empleado WHERE num_empleado=? ";
		ps.setInt(1, eliminarEmpleado.getNum_empleado());
		ps.executeUpdate(query);
		
		System.out.println("Un usuario fue eliminado.");
		
		
		ps.close();
		cn.close();
		

		
		
		
		
	}
	
	public static void realizarFichero() {
		
		
//		Realizar un fichero con los empleados asociados
	}

}
