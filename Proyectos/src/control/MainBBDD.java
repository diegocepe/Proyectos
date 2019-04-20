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
	
	private static String fich1="/Ficheros/Departamentos.csv";

	public static void main(String[] args) throws SQLException, IOException {
		
//		List <String> ficheroDepartamentos= new ArrayList<String>();
//		
//			ficheroDepartamentos=DepartamentoC.fichero1ArrayList(fich1);
//
//		
//	
//MENU DE ELECCION	
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
			System.out.println("8. Listar departamentos");
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
				
				case 2: try {
					EmpleadoC.modificarEmpleado();
				} catch (Exception e) {
					e.printStackTrace();
				} break;
				
				case 3: try {
					EmpleadoC.eliminarEmpleado();
				} catch (Exception e) {
					e.printStackTrace();
				} break;
				
				case 4: System.out.println("4"); break;
				case 5: System.out.println("5"); break;
				case 6: System.out.println("6"); break;
				case 7: System.out.println("7"); break;
				case 8: System.out.println(DepartamentoC.fichero1ArrayList(fich1).toString()); break;
				case 9: salir=true; break;
				default: System.out.println("\nElija un número entre entre 1 y 7. Pulse 9 para salir.\n");
			}
		
		} catch (InputMismatchException e) {
			System.out.println("Debe introducir un numero correcto.");
			scan.next();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		System.out.println("\nFin del menu\n");
		}
		
		
		

		//hacer select para sacar la id que corresponda al empleado
		
		
//		Departamento depart=new Departamento (3, "prueba3");
		
		// Empleado emple=new Empleado (0,"Pepe", "Calle Falsa", "asistente", 1);
//		
////Insercion de nuevo departamento
//		
//		try { 
//			
//			DepartamentoC.abrirEnlace();
//			
//			if (DepartamentoC.insertarDepartamento(depart)) {
//				
//				System.out.println("Registro insertado correctamente");
//			}
//				
//		}
//		catch(SQLException e1) {
//		
//			e1.printStackTrace();
//		}
//		
//Insercion de nuevo empleado
		
//		try { 
//			
//			EmpleadoC.abrirEnlace();
//			
//			if (EmpleadoC.insertarEmpleado(emple)) {
//				
//			}
//			
//		}
//		catch(SQLException e1) {
//			
//			e1.printStackTrace();
//		}
		
		
		
		
		
		
		
		
		
		
	}

}
