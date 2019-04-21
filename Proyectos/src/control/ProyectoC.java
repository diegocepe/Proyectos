package control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCreation;

import dao.EnlaceJDBC;
import modelo.Departamento;
import modelo.Proyecto;

public class ProyectoC {
	
	public static void insertarProyecto () throws SQLException {
		
		EnlaceJDBC enlace=new EnlaceJDBC();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Escriba el nombre de proyecto: ");
		String nombre=sc.nextLine();
		System.out.println("Escriba la fecha de inicio: ");
		String inicio=sc.nextLine();
		System.out.println("Escriba la fecha final: ");
		String fin=sc.nextLine();
		System.out.println("Escriba el nombre de cliente: ");
		String cliente=sc.nextLine();
		

//

		
		Proyecto proyecto = new Proyecto(0, nombre, inicio, fin, cliente);
		
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
		PreparedStatement ps = cn.prepareStatement("INSERT INTO PROYECTO VALUES (?,?,?,?,?)");
		ps.setInt(1, proyecto.getCod_proyecto());
		ps.setString(2, proyecto.getNombre_proyecto());
		ps.setDate(3, (Date) proyecto.getFecha_inicio());
		ps.setDate(4, (Date) proyecto.getFecha_fin());
		ps.setString(5, proyecto.getCliente());
		
		int tf = ps.executeUpdate();
		
		if(tf > 0) {
			System.out.println(proyecto.getNombre_proyecto() + " insertado correctamente.");
		} else System.out.println("Ha ocurrido un error.");
		
		ps.close();
		cn.close();

	}
	
	public static void asociarEmpleado() {
		
//		Asociar un empleado a un proyecto existente
		
		
		
	}
	
	public static void listarProyectosPDF() {
		
//		Listado de proyectos con los empleados que tienen con las fechas de inicio
//		y finalización en un pdf
		
		
	}

}
