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

		// SUMARA LOS PUNTOS Y LOS GUARDARA CON SU RESPECTIVO PARTICIPANTE
		Map<String, Integer> puntosParticipantes = new HashMap<String, Integer>();

		obtenerPuntaje(listaPronosticos, listaResultado,puntosParticipantes);

		mostrarPuntajeTotal(puntosParticipantes);
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

	public static void obtenerPuntaje(
			List<Pronostico> listaPronosticos,			// ARCHIVO PONOSTICO
			List<ArchivoResultado> listaResultado,		// ARCHIVO RESULTADO
			Map<String, Integer> puntosParticipantes)	// PUNTOS PARTICIPANTES
	{
		for (Pronostico pronostico : listaPronosticos)
		{
			// COMPRUEBO QUE EL PARTICIPANTE NO ESTE EN LA LISTA
			if (!puntosParticipantes.containsKey(pronostico.getParticipante()))
			{
				// LO AGREGO A LA LISTA CON PUNTAJE 0
				puntosParticipantes.put(pronostico.getParticipante(), 0);
			}

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
		}
	}



}

