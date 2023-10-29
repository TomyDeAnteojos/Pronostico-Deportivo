package Servicios;

import java.util.Scanner;

public class Menu
{
    public static int menuOpciones()
    {
        Scanner sc = new Scanner(System.in);
        int op= 0;
        System.out.print(
                "\tMENU INICIAL\n" +
                "-----------------------\n" +
                "1. Ingresar Equipos\n" +
                "2. Empezar\n" +
                "0. Cerrar Programa\n" +
                "Opcion: ");
        try {
            op = sc.nextInt();
        } catch (Exception e)
        {
            e.printStackTrace(); //verificar que es un numero o letra
        }
        return op;
    }
}
