package pronosticoDeportivoPersistencia;

import java.util.ArrayList;

import Entidades.Equipo;
import Entidades.Partido;

public final class EquipoDAO extends DAO {

	public ArrayList<Partido> traerResultados() throws Exception {

	    ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
	    
	    try {

	        String sql = "SELECT * FROM partidos";
	        
	        consultarDB(sql);
	        
	        Equipo equipo1 = null;
	        Equipo equipo2 = null;
	        Partido partido = null;
	        
	        while(resultado.next()) {
	        	
	            equipo1 = new Equipo();
	            equipo1.setNombre(resultado.getString(3));
	            equipo2 = new Equipo();
	            equipo2.setNombre(resultado.getString(6));
	            partido = new Partido();
	            partido.setEquipo1(equipo1);
	            partido.setEquipo2(equipo2);
	            partido.setGolesEquipo1(resultado.getInt(4));
	            partido.setGolesEquipo2(resultado.getInt(5));
	            listaPartidos.add(partido);
	            
	        }
	        
	        desconectarDB();
	        
	    } catch (Exception e) {
	        desconectarDB();
	        throw e;
	    }

	    return listaPartidos;
	}
}
