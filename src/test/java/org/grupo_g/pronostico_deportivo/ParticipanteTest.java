package org.grupo_g.pronostico_deportivo;

//import org.junit.jupiter.api.Test;

import java.util.Map;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipanteTest
{
    //1- test donde el participante no haya ganando nada y su puntuación sea 0
    @Test
    public void participante_con_puntuacion_0()
    {
        String rutaPronostico = "src/main/resources/pronostico.csv";
        String rutaResultados = "src/main/resources/resultados.csv";

        // SUMARA LOS PUNTOS Y LOS GUARDARA CON SU RESPECTIVO PARTICIPANTE
        Map<String, Integer> puntosParticipantes =
                App.obtenerPuntaje( rutaPronostico,rutaResultados);

        int puntuacion = -1; //lo inicializo en un valor incorrecto
        for (Map.Entry<String, Integer> participante : puntosParticipantes.entrySet())
        {
            //String nombre = participante.getKey().toString(); // No importa el nombre, y asi no hardcodeamos :)
            
           	puntuacion = participante.getValue();
            
           	// Si encuentra un participante con puntaje 0, sale del for.
            if (puntuacion == 0)
            	break;
           
            // Esto no debería estar, deberíamos calcular que haya algún participante con puntuación 0, sin poner nombre..
//            if(nombre.equalsIgnoreCase("Juan"))
//            {
//                puntuacion = participante.getValue();
//            }
        }
        assertEquals(0, puntuacion);

    }

    //2- no hay ningún partido registrado
    @Test
    public void ningun_partido_registrado()
    {
        String rutaPronostico = "src/main/resources/test_pronostico.csv";
        String rutaResultados = "src/main/resources/test_resultados.csv";

        // SUMARA LOS PUNTOS Y LOS GUARDARA CON SU RESPECTIVO PARTICIPANTE
        Map<String, Integer> puntosParticipantes =
                App.obtenerPuntaje( rutaPronostico,rutaResultados);
        
        //assertEquals(puntosParticipantes, null); // Primero va lo esperado y luego lo real
        assertNull(puntosParticipantes); // Ver cual se puede usar porque no devuelve null, devuelve {} (no encuentro cual puede ser)
    }

    //3- uno o los dos equipos que el participante eligió no existe
    @Test
    public void partidoInexistente()
    {
    	// Tengo que pensar como podemos armar este jaja
        assertEquals(null, null);
    }
}
