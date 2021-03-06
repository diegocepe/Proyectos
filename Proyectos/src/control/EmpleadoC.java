package control;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		
		System.out.println("Introduzca los datos a modificar: \n");

		System.out.println("Nombre. ");
		String nombreEmpleado=sc.nextLine();
		System.out.println("Direccion. ");
		String direccionEmpleado=sc.nextLine();
		System.out.println("Tipo. ");
		String tipoEmpleado=sc.nextLine();
		System.out.println("Elija el departamento: ");
			
		ArrayList<Departamento> departamentos = DepartamentoC.verDepartamentos();
			
			
		for(int i = 0; i < departamentos.size(); i++) {
				
			System.out.println((i+1)+" - "+(departamentos.get(i)).getNombre_departamento());
				
		} 
			
		int departamentoEmpleado=sc.nextInt();
			
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
		PreparedStatement ps = cn.prepareStatement("UPDATE empleado SET nombre=?, direccion=?, cod_departamento=?,tipo=? WHERE num_empleado=?");
		ps.setInt(1, numEmple);
		ps.setString(2, nombreEmpleado);
		ps.setString(3, direccionEmpleado);
		ps.setString(4, tipoEmpleado);
		ps.setInt(5, departamentoEmpleado);
			
		int tf = ps.executeUpdate();
		
		if(tf > 0) {
			System.out.println("Modificado correctamente.");
		} else System.out.println("Ha ocurrido un error.");
			
		ps.close();
		cn.close();
		sc.close();
			
		}

		
		
		
		
	
	public static void eliminarEmpleado() throws SQLException {
				
		Scanner sc=new Scanner (System.in);
		System.out.println("Elija el id de empleado que desea eliminar: ");
		EmpleadoC.verEmpleados();
		ArrayList<Empleado> empleado = EmpleadoC.verEmpleados();
		
		for (int i = 0; i < empleado.size(); i++) {
			
			System.out.println(((empleado.get(i)).getNum_empleado())+" - "+(empleado.get(i)).getNombre());
			
		}
		
		int num_empleado=sc.nextInt();		
				
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
		String query= "DELETE FROM empleado WHERE num_empleado=? ";
		PreparedStatement ps = cn.prepareStatement(query);

		ps.setInt(1, num_empleado);
		ps.executeUpdate();
		System.out.println("Un usuario fue eliminado.");
			
		ps.close();
		cn.close();
		sc.close();

		
		
		////ELIMINA PERO DA FALLO AL VOLVER AL MENU

	}
	
	public static void realizarFicheroEmpleados() throws SQLException {
		EnlaceJDBC enlace = new EnlaceJDBC();	
		Path file= Paths.get("Ficheros/listadoEmpleados.txt");
		Charset charset = Charset.forName("UTF-8");
			
		ArrayList<Empleado> empleados=enlace.verEmpleados();
			
		System.out.println(empleados.size());
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			for (int i = 0; i < empleados.size(); i++) {
				writer.write(empleados.get(i).toString(), 0, empleados.get(i).toString().length());
					
				if (i<empleados.size()-1) writer.newLine();
			}
			   writer.close();
		} catch (IOException x) {
			    System.err.format("IOException: %s%n", x);
		}
	}
	
	
	public static void realizarFichero() throws SQLException, IOException {

		
//		Realizar un fichero con los empleados asociados

		
		ArrayList<Empleado> empleado = EmpleadoC.verEmpleados();
		
		for (int i = 0; i < empleado.size(); i++) {
			
			System.out.println(("ID: "+(empleado.get(i)).getNum_empleado())+
					" NOMBRE: "+(empleado.get(i)).getNombre()+
					" DIRECCION: "+empleado.get(i).getDireccion()+
					" TIPO: "+empleado.get(i).getTipo()+
					" DEPARTAMENTO: "+empleado.get(i).getCod_departamento());
			
		}
	
		
		

	}
}
