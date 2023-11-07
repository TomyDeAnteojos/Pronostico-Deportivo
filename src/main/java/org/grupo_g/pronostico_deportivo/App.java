package org.grupo_g.pronostico_deportivo;

import Entidades.*;
import Servicios.*;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class App {

	public static void main(String[] args)
	{
		/*
		 * while(true) { switch (Servicios.Menu.menuOpciones()) { case 1: //
		 * cargarEquipos(); break; case 2: // Empezar // Ingresar apuestas // ingresar
		 * goles // calcular puntaje break; case 0: System.exit(0); break; default:
		 * break; } }
		 */
		LectorArchivos lectorArchivos = new LectorArchivos();

		// Leo el archivo de RESULTADO y lo asigno a una variable
		List<ArchivoResultado> listaResultado =
				lectorArchivos.parsearResultados("src/main/resources/resultados.csv");

		// Leo el archivo de PRONOSTICO y lo asigno a una variable
		List<Pronostico> listaPronosticos =
				lectorArchivos.parsearPronosticos("src/main/resources/pronostico.csv");

		// Creo un tipo de dato hash set, así voy sumando puntos de los participantes.
		Map<String, Integer> puntosParticipantes = new HashMap<String, Integer>();

		// Recorro todos los pronosticos
		
		// HASHMAP -> STRING
		System.out.println(listaPronosticos.toString());

		for (Pronostico pronostico : listaPronosticos)
		{
			//ver si se muentran los equipos 🆗
			System.out.println(pronostico.getEquipo1() + " VS. " + pronostico.getEquipo2());
			System.out.println("PARTICIPANTE - PUNTUACION");
			System.out.println("----------------------------------------");
			
			// COMPRUEBO QUE EL PARTICIPANTE NO ESTE EN LA LISTA
			if (!puntosParticipantes.containsKey(pronostico.getParticipante()))
			{
				// LO AGREGO A LA LISTA CON PUNTAJE 0
				puntosParticipantes.put(pronostico.getParticipante(), 0);
			}
			
			//ver si se crean los participantes 🆗
			// System.out.println(pronostico.getParticipante());

			// SUMA PUNTO A LOS PARTICIPANTES QUE HAYAN ACERTADO EN EL PRONOSTICO
			for (ArchivoResultado resultado : listaResultado)
			{
				// OBTENGO EQUI_PRONS = EQUI_RESU
				if (resultado.getEquipo1().equalsIgnoreCase(pronostico.getEquipo1()) // COMPARO EQUIPO 1
				&& resultado.getEquipo2().equalsIgnoreCase(pronostico.getEquipo2())) // COMPARO EQUIPO 2
				{
					// COMPRUEBO EL RESULTADO Y PRONOSTICO TENGAN EL MISMO RESULTADO
					if (resultado.ganoEmpatoOPerdioElEquipo1() == pronostico.ganoEmpatoOPerdioElEquipo1())
					{
						// EL PARTICIPANTE RECIBE UN PUNTO
						puntosParticipantes.put(pronostico.getParticipante(),
								puntosParticipantes.get(pronostico.getParticipante()) + 1);
					}
				}
			}

			//MOSTRAR PUNTOS DE PARTICIPANTES
			for(Map.Entry<String, Integer> participante : puntosParticipantes.entrySet())
			{
				//SEPARO NOMBRE DE PUNTUACION
				String nombre = participante.getKey();
				int puntuacion = participante.getValue();
				//MUESTRO NOMBRE Y PUNTUACION
				System.out.println(nombre + " - " + puntuacion);
			}
			System.out.println(); //SALTO DE LINEA -- ES SOLO DECORATIVO


		} 
	}

}

