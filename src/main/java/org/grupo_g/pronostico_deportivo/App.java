package org.grupo_g.pronostico_deportivo;

import Entidades.*;
import Servicios.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class App {
	public static void main(String[] args) {
		/*
		 * while(true) { switch (Servicios.Menu.menuOpciones()) { case 1: //
		 * cargarEquipos(); break; case 2: // Empezar // Ingresar apuestas // ingresar
		 * goles // calcular puntaje break; case 0: System.exit(0); break; default:
		 * break; } }
		 */
		LectorArchivos lectorArchivos = new LectorArchivos();

		// Leo el archivo de resultado y lo asigno a una variable
		List<ArchivoResultado> listaResultado = lectorArchivos.parsearResultados("src/main/resources/resultados.csv");

		// Leo el archivo de pronostico y lo asigno a una variable
		List<Pronostico> listaPronosticos = lectorArchivos.parsearPronosticos("src/main/resources/pronostico.csv");

		// Creo un tipo de dato hash set, así voy sumando puntos de los participantes.
		Map<String, Integer> puntosParticipantes = new HashMap<String, Integer>();

		// Recorro todos los pronosticos
		
		
		System.out.println(listaPronosticos.toString());
		
		
		for (Pronostico pronostico : listaPronosticos) {

			//ver si se muentran los equipos 🆗
			System.out.println(pronostico.getEquipo1());
			System.out.println(pronostico.getEquipo2());
			
			// Primero me fijo si ya tengo agregado al participante
			if (!puntosParticipantes.containsKey(pronostico.getParticipante())) {
				// si no existe crear uno con puntaje 0
				puntosParticipantes.put(pronostico.getParticipante(), 0);
			}
			
			//ver si se crean los participantes 🆗
			System.out.println(pronostico.getParticipante());

			// Busco el partido dentro de resultados
			for (ArchivoResultado resultado : listaResultado) {
				// Busco hasta que los equipos del pronostico sean el mismo del resultado
				// Osea, busco el partido
				System.out.println("VERIRFICAR QUE TIENE RESULTADO(goles)");
				System.out.println(resultado.getCantGoles1());
				if (resultado.getEquipo1().equalsIgnoreCase(pronostico.getEquipo1())
						&& resultado.getEquipo2().equalsIgnoreCase(pronostico.getEquipo2())) {

					// Una vez que encuentro el partido, me fijo si pusieron el mismo resultado
					if (resultado.ganoEmpatoOPerdioElEquipo1() == pronostico.ganoEmpatoOPerdioElEquipo1()) {
						// si el pronostico es el mismo, sumo puntos
						puntosParticipantes.put(pronostico.getParticipante(),
								// busco los puntos del participante y le sumo 1
								puntosParticipantes.get(pronostico.getParticipante()) + 1);
					}
				}
			}
		} 
	}
}
