package Servicios;

import Entidades.Pronostico;
import Entidades.ArchivoPronostico;
import Entidades.ArchivoResultado;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {

	public List<ArchivoResultado> parsearResultados(String rutaDelArchivoResultados) {
        List<ArchivoResultado> listaDeResultados = null;
        try {
            listaDeResultados =
                    // Config del Archivo
                    new CsvToBeanBuilder(new FileReader(rutaDelArchivoResultados))
                            .withSkipLines(1)
                            .withSeparator(',')
                            .withType(ArchivoResultado.class)
                            .build()
                            .parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDeResultados;
    }
    public List<ArchivoPronostico> parsearPronosticos(String rutaDelArchivoPronosticos) {
        List<ArchivoPronostico> listaDePronosticos = null;
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

    
}
