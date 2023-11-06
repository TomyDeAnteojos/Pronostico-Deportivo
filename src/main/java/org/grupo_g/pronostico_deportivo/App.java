package org.grupo_g.pronostico_deportivo;

import Entidades.*;
import Servicios.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
       /*
    	while(true)
        {
            switch (Servicios.Menu.menuOpciones())
            {
                case 1:
//                    cargarEquipos();
                    break;
                case 2:
                    // Empezar
                    // Ingresar apuestas
                    // ingresar goles
                    // calcular puntaje
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
        */
    	
    	LectorArchivos lectorArchivos = new LectorArchivos();

    	//Leo el archivo de resultado y lo asigno a una variable
        List<ArchivoResultado> listaResultado = 
        		lectorArchivos.parsearResultados("src/main/resources/resultados.csv");

    	//Leo el archivo de pronostico y lo asigno a una variable
        List<Pronostico> listaPronosticos = 
        		lectorArchivos.parsearPronosticos("src/main/resources/pronostico.csv");
        
        //Creo un tipo de dato hash set, así voy sumando puntos de los participantes.
        Map<String,Integer> puntosParticipantes = new HashMap<String, Integer>();
        

        //Recorro todos los pronosticos
        for(Pronostico unPronostico : listaPronosticos) {
        	
        	System.out.println(unPronostico.getEquipo1());
        	System.out.println(unPronostico.getEquipo2());
        	System.out.println(unPronostico.getGana1());
        	System.out.println(unPronostico.getGana2());
        	
        }
    }

   

}
