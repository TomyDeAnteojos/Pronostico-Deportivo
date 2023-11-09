package org.grupo_g.pronostico_deportivo;

import Entidades.ArchivoResultado;
import Entidades.Pronostico;
import Servicios.LectorArchivos;
import org.grupo_g.pronostico_deportivo.App;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipanteTest
{
    //1- test donde el participante no haya ganando nada y su puntuación sea 0
    //2- no hay ningún partido registrado
    //3- uno o los dos equipos que el participante eligió no existe

    @Test
    public void participante_con_puntuacion_0()
    {
        LectorArchivos lectorArchivos = new LectorArchivos();

        List<ArchivoResultado> listaResultado =
                lectorArchivos.parsearResultados("src/main/resources/resultados.csv");

        List<Pronostico> listaPronosticos =
                lectorArchivos.parsearPronosticos("src/main/resources/pronostico.csv");

        Map<String, Integer> puntosParticipantes = new HashMap<String, Integer>();

        App.obtenerPuntaje(listaPronosticos,listaResultado,puntosParticipantes);

        int puntuacion = -1; //lo inicializo en un valor incorrecto
        for (Map.Entry<String, Integer> participante : puntosParticipantes.entrySet())
        {
            String nombre = participante.getKey();
            if(nombre == "Juan")
            {
                puntuacion = participante.getValue();
            }
        }
        assertEquals(puntuacion, 0);

    }
}
