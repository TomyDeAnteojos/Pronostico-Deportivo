package org.grupo_g.pronostico_deportivo;

import Entidades.Equipo; //agregar
import Servicios.*;

import java.util.Arrays;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
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
    }

   

}
