package Servicios;

import Entidades.Pronostico;
import Entidades.ResultadoEnum;
import com.opencsv.bean.CsvToBeanBuilder;
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
}
