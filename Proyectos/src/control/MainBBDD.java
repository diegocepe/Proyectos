package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.Departamento;
import modelo.Empleado;

public class MainBBDD {

	public static void main(String[] args) throws SQLException, IOException {
		
		Scanner scan=new Scanner(System.in);
		
		boolean salir= false;
		int opcion=0;
		
		while (!salir) {
			
			System.out.println("1. Insertar un empleado nuevo.");
			System.out.println("2. Modificar los datos de un empleado existente.");
			System.out.println("3. Eliminar un empleado de la empresa.");
			System.out.println("4. Realizar un fichero con los empleados asociados.");
			System.out.println("5. Insertar un proyecto.");
			System.out.println("6. Asociar un empleado a un proyecto existente.");
			System.out.println("7. Listado de proyectos.");
			System.out.println("9. Salir");
			System.out.println("Introduce un número: ");
			opcion=scan.nextInt();
		
		try {
		
			switch (opcion) {
			
				case 1: try {
					EmpleadoC.insertarEmpleado();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} break;
				
				case 2: try { //No modifica y ERROR Exception in thread "main"
					EmpleadoC.modificarEmpleado();
				} catch (Exception e) {
					e.printStackTrace();
				} break;
				
				case 3: try { //ERROR Exception in thread "main"
					EmpleadoC.eliminarEmpleado();
				} catch (Exception e) {
					e.printStackTrace();
				} break;
				
				case 4: try { //Falta insertar los datos extraidos al txt
					EmpleadoC.realizarFicheroEmpleados(); break;
				} catch (Exception e) {
					e.printStackTrace();
				} break;
				
				case 5: System.out.println("5"); break;
				case 6: System.out.println("6"); break;
				case 7: System.out.println("7"); break;
				
				case 9: salir=true; break;
				default: System.out.println("\nElija un número entre entre 1 y 7. Pulse 9 para salir.\n");
			}
		
		} catch (InputMismatchException e) {
			System.out.println("Debe introducir un numero correcto.");
			scan.next();
	}
		
		System.out.println("\nFin del menu\n");
		}
		
		
		
		
		
	}

}
