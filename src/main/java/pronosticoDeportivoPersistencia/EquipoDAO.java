package pronosticoDeportivoPersistencia;

import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvBindByPosition;

import Entidades.Equipo;
import Entidades.Partido;
import Entidades.ResultadoEnum;

public final class EquipoDAO extends DAO {

	public ArrayList<Partido> traerResultados() throws Exception {
		ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
		try {
			String sql = "SELECT * FROM partidos";
			consultarDB(sql);
			
			while (resultado.next()) {
				Equipo equipo1 = new Equipo();
				equipo1.setNombre(resultado.getString(3));
				Equipo equipo2 = new Equipo();
				equipo2.setNombre(resultado.getString(6));
				Partido partido = new Partido();
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

	public ResultadoEnum ganoEmpatoOPerdioElEquipo1(List<Partido> goles) {

		for (Partido partido : goles) {

			if (partido.getGolesEquipo1() > partido.getGolesEquipo2())
				return ResultadoEnum.Ganador;

			if (partido.getGolesEquipo1() < partido.getGolesEquipo2())
				return ResultadoEnum.Perdedor;
		}
		return ResultadoEnum.Empate;
	}
}
