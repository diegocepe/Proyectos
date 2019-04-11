package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.EnlaceJDBC;
import modelo.Departamento;
import modelo.Empleado;

public class DepartamentoC {
	
	static EnlaceJDBC enlace;
	
	public static void abrirEnlace() throws SQLException {
		enlace=new EnlaceJDBC();
	}
	
	public static ArrayList<Departamento> verDepartamentos() throws SQLException {

		EnlaceJDBC enlace = new EnlaceJDBC();
		ArrayList<Departamento> resultado = enlace.verDepartamentos();
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static ArrayList<Departamento> consultaDepartamentos() throws ClassNotFoundException, SQLException {
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		
//		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
//
//		Statement st = cn.createStatement();
//		
//		ResultSet rs = st.executeQuery("SELECT * FROM DEPARTAMENTO;");
//		
//		ArrayList<Departamento> arrayDepartamentosCSV = new ArrayList<Departamento>();
//		
//		while(rs.next()) {
//			
//			Departamento dep =  new Departamento(rs.getInt("cod_departamento"),rs.getString("nombre_departamento"));
//			
//			arrayDepartamentosCSV.add(dep);
//		}
//		
//		rs.close();
//		st.close();
//		cn.close();
//		
//		return arrayDepartamentosCSV;
//
//	}
	
	//Averiguar el numero de departamento
//	public static int numeroDepartamento (int i) throws SQLException {
//		enlace=new EnlaceJDBC();
//		ResultSet rs=null;
//		String sql=("SELECT * from departamento;"); 
//	//nos devuelve cod_departamento y nombre_departamento
//		int idDepart=0;
//		rs=enlace.seleccionRegistros(sql);
//		while (rs.next()) {
//			idDepart=rs.getInt(1);
//		}
//		return idDepart;
//		
//	}
	
	public static List<String>fichero1ArrayList (String fichero1) throws IOException {
		
		List <String> datosFichero1= new ArrayList <String>();
		Path fich1=Paths.get(fichero1);
		
		try {
			datosFichero1=Files.readAllLines(fich1, StandardCharsets.ISO_8859_1);
			
		}catch(IOException io) {
			
			System.out.println(io.getMessage());
			
		}
		
//		datosFichero1.get(0);
//		datosFichero1.get(1);
//		datosFichero1.get(2);
//		datosFichero1.get(3);
//		datosFichero1.get(4);
//		datosFichero1.get(5);
//		datosFichero1.get(6);
//		datosFichero1.get(7);
//
//
//		
		
		return datosFichero1;
	}
	
	
	
//	public static List<Departamento> listadoDepartamento() throws SQLException {
//		
//		List<Departamento> listaD=new ArrayList<Departamento>();
//		EnlaceJDBC enlace = new EnlaceJDBC();
//		ResultSet rs=null;
//		String sqlQuery = ("SELECT * from departamento");
//		
///*		rs=enlace.seleccionRegistros(sql);
//		while (rs.next()) {
//			listaD=rs.getInt(1);
//		}
//		*/
//		
//		
//		return listaD;
//	
//		
//	}
	
	//Seleccionar el numero de departamento
//	public static int SelectIdDepart(String nameDepart) throws SQLException{
//		enlace=new EnlaceJDBC();
//		ResultSet rs=null;
//		String sql=("SELECT cod_departamento from departamento where nombre_departamento='"+nameDepart+"';");
//		int id=0;
//		rs=enlace.seleccionRegistros(sql);
//		while (rs.next()) {
//			id=rs.getInt(1);
//		}
//		return id;
//		
//	}
	
	
	
	

}
