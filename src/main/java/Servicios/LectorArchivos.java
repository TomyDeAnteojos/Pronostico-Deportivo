package Servicios;

import Entidades.Equipo;
import Entidades.Pronostico;
import Entidades.ResultadoEnum;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class LectorArchivos {
    public List parsearResultados(String rutaDelArchivoResultados) {
        List listaDeResultados = new ArrayList<>();
        try {
            listaDeResultados =
                    // Config del Archivo
                    new CsvToBeanBuilder(new FileReader(rutaDelArchivoResultados))
                            .withSkipLines(1)
                            .withSeparator(',')
                            .withType(ResultadoEnum.class)
                            .build()
                            .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDeResultados;
    }
    public List parsearPronosticos(String rutaDelArchivoPronosticos) {
        List listaDePronosticos = new ArrayList<>();
        try {
            listaDePronosticos =
                    // Config. del Archivo
                    new CsvToBeanBuilder(new FileReader(rutaDelArchivoPronosticos))
                            .withSkipLines(1)
                            .withSeparator(',')
                            .withType(Pronostico.class)
                            .build()
                            .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDePronosticos;
    }

    public List parsearEquipos(String rutaDelArchivoEquipos) {
        List listaDeEquipos = new ArrayList<>();
        try {
            listaDeEquipos =
                    // Config. del Archivo
                    new CsvToBeanBuilder(new FileReader(rutaDelArchivoEquipos))
                            .withSkipLines(1)
                            .withSeparator(',')
                            .withType(Equipo.class)
                            .build()
                            .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDeEquipos;
    }

    public void vaciarEquipos(String rutaDeEquipos)
    {
        try
        {
            FileWriter writer = new FileWriter(rutaDeEquipos, false);
            writer.close();
            System.out.println("El contenido del archivo CSV se ha vaciado con éxito.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void AgregarEquipo(String rutaDeEquipos,String nombre, String descripcion)
    {
        try {
            File file = new File(rutaDeEquipos);
            FileWriter escritor = new FileWriter(file, true);
            // Agrego al archivo
            escritor.write(nombre + ";" + descripcion + "\n");
            // Cierro el archivo
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}
