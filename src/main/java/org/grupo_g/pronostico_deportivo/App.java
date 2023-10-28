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
                    cargarEquipos();
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

    public static void cargarEquipos()
    {
        // prepara primeras variables
        Scanner sc = new Scanner(System.in);
        System.out.print("Cantidad de equipos");
        int cantidad_equipos = 0;

        try
        {
            cantidad_equipos = sc.nextInt();
        } catch (Exception e)
        {
            e.printStackTrace(); //comprobar que sea un numero y que sean
            // los equipos suficientes para un partido( 2 - 4 - 8 - 16 - 32 - ...)
            // que no sea negativo
        }
        sc.nextLine(); //vaciar scope
        Equipo[] equipos = new Equipo[cantidad_equipos];

        // carga los equipos
        for(int i = 0; i < cantidad_equipos ; i++ )
        {
            System.out.print("nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Descripcion: ");
            String descripcion = sc.nextLine();

            //TEST
            {
                System.out.println("Test");
                System.out.println(Arrays.stream(equipos).count());
                System.out.println(nombre);
                System.out.println(descripcion);
                System.out.println("fin test");
            }

            equipos[i].setNombre(nombre);
            equipos[i].setDescripcion(descripcion);
        }
        //prepara los equipos
        LectorArchivos lecCSV = new LectorArchivos();
        lecCSV.vaciarEquipos("src\\main\\java\\resources\\equipo.csv");
        lecCSV.AgregarEquipo(
                "src\\main\\java\\resources\\equipo.csv",
                "nombre","descripcion");

        // agrega los equipos al archivo
        for(int i = 0 ; i < cantidad_equipos ; i++ )
        {
            lecCSV.AgregarEquipo(
                    "src\\main\\java\\resources\\equipo.csv",
                    equipos[i].getNombre(),
                    equipos[i].getDescripcion());
        }
    }

}
