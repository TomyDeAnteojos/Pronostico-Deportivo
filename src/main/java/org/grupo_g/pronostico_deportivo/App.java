package org.grupo_g.pronostico_deportivo;

import Entidades.*;
import Servicios.*;
import pronosticoDeportivoPersistencia.EquipoDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) throws Exception {
		String rutaPronostico = "src/main/resources/pronostico.csv";
		
		EquipoDAO equipoDAO = new EquipoDAO();
		ArrayList<Partido> listaPartidos = equipoDAO.traerResultados();

		Map<String, Integer> puntosParticipantes = obtenerPuntaje(rutaPronostico, listaPartidos);

		mostrarPuntajeTotal(puntosParticipantes);
		System.out.println("");

		// Leo el archivo de PRONOSTICO y lo asigno a una variable
		LectorArchivos lectorArchivos = new LectorArchivos();
		List<Pronostico> listaPronosticos = lectorArchivos.parsearPronosticos(rutaPronostico);
		
		 //para ver si los resultados de la db estan bien
		
		for (Partido partido : listaPartidos) {
			
			System.out.println("Resultado de los partidos del Mundial");
			System.out.println(partido.getEquipo1().getNombre() + " " + partido.getGolesEquipo1() + " "
					+partido.getEquipo2().getNombre() + " " + partido.getGolesEquipo2() );
			System.out.println("");
			
		} 
	}
	
	public static void mostrarPuntajeTotal(Map<String, Integer> aux) {
		System.out.println("PUNTAJE TOTAL");
		System.out.println("-------------------------");
		for (Map.Entry<String, Integer> participante : aux.entrySet()) {
			String nombre = participante.getKey();
			int puntuacion = participante.getValue();
			System.out.println(nombre + " - " + puntuacion);
		}
	}
	
	public static Map<String, Integer> obtenerPuntaje(String rutaPronosticos, List<Partido> listaPartidos) throws Exception  {
		
		LectorArchivos lectorArchivos = new LectorArchivos();
		
		List<Pronostico> listaPronosticos = lectorArchivos.parsearPronosticos(rutaPronosticos);
		
		Map<String, Integer> puntosParticipantes = new HashMap<String, Integer>();
		
		EquipoDAO equipoDAO = new EquipoDAO();
		listaPartidos = equipoDAO.traerResultados();
		
		List<Partido> resultados = new ArrayList<>(listaPartidos);
		
		for (Pronostico pronostico : listaPronosticos) {
			
			if (!puntosParticipantes.containsKey(pronostico.getParticipante())) {
				puntosParticipantes.put(pronostico.getParticipante(), 0);
			}
			for (Partido partido : resultados) {

				if (partido.getEquipo1().getNombre().equalsIgnoreCase(pronostico.getEquipo1()) 
						&& partido.getEquipo2().getNombre().equalsIgnoreCase(pronostico.getEquipo2())) 
				{
					
					if (partido.ganoEmpatoOPerdioElEquipo1(listaPartidos) == pronostico.ganoEmpatoOPerdioElEquipo1()) {

						puntosParticipantes.put(pronostico.getParticipante(),
								puntosParticipantes.get(pronostico.getParticipante()) + 1);
					}
				}
			}
		}
		return puntosParticipantes;
	}
}
