package pronosticoDeportivoPersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	
	protected Connection conexion = null;
	protected ResultSet resultado = null;
	protected Statement sentencia = null;
	
	private final String USER = "root";
	private final String PASSWORD = "Exe230994";
	private final String DATABASE = "pronostico";
	private final String DRIVER = "com.mysql.jdbc.Driver";
	
	protected void conectarDB() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName(DRIVER);
			String urlDB = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
			conexion = DriverManager.getConnection(urlDB, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
            throw e;
		}
	}
	
	protected void desconectarDB() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {//ES LA CONSULA
        try {
            conectarDB();//esto es por si está desconectado, la conecta
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
            //Acá estamos diciendo que esta sentencia, va a usar la consulta SQL que tiene por parámetro
            //INSERT INTO ....... ETC
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            desconectarDB();
        }
    }

    protected void consultarDB(String sql) throws Exception {
        try {
            conectarDB();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            //Select nombre from producto

        } catch (Exception e) {
            throw e;
        }
    }
	

}
