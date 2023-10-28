package org.grupo_g.pronostico_deportivo;

import Servicios.*;

public class App 
{
    public static void main( String[] args )
    {

        while(true)
        {
            switch (Servicios.Menu.menuOpciones())
            {
                case 1:
                    // Cargar equipos
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
