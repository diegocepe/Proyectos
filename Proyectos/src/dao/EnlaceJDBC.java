package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Departamento;



public class EnlaceJDBC {
	//private static final String DRIVER = "com.mysql.jdbc.Driver";  // está en la clase conexion
	private static final String URL = "jdbc:mysql://localhost/empresa";
	private static final String USUARIO = "root";
	private static final String CLAVE = "";
	
	private Conexion unaConexion;
	private Connection connection;
	
	public EnlaceJDBC () throws SQLException {
		
		unaConexion = new Conexion(URL, USUARIO, CLAVE);
	}
	
	public ResultSet seleccionRegistros(String consultaSQL) {
		Statement sentencia = null;
		ResultSet filas = null;
		
		try {
			unaConexion.conectar();
			connection = unaConexion.getJdbcConnection();
			sentencia = connection.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
		
	}
	
	
	
	

	@SuppressWarnings("finally")
	
	public boolean insertar(String sqlInsert) throws SQLException {
		
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();
		Statement statement = connection.createStatement();
		
		
		//Ejecutamos la sentencia
		boolean rowInserted = statement.executeUpdate(sqlInsert) > 0;
		statement.close();
		unaConexion.desconectar();
		return rowInserted;
	}
	
	public ArrayList<Departamento> verDepartamentos() throws SQLException {
		ArrayList<Departamento> ar = new ArrayList<Departamento>();
		
		//-----------conectamos
		unaConexion.conectar();
		connection = unaConexion.getJdbcConnection();
		
		//-----------generamos la sentencia
		String sql = "SELECT * FROM departamento order by cod_departamento";
		PreparedStatement statement = connection.prepareStatement(sql);

		//-----------ejecutamos la consulta
		ResultSet rs = statement.executeQuery();
		
		
		while (rs.next()) {
			Departamento d = new Departamento(rs.getInt("cod_departamento"), rs.getString("nombre_departamento"));
			ar.add(d);
		}
		
		//----------cerramos y desconectamos
		rs.close();
		unaConexion.desconectar();
		
		return ar;
	}
	
	
}