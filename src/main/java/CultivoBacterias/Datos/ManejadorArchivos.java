package CultivoBacterias.Datos;

import CultivoBacterias.Lógica.Experimento;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ManejadorArchivos {
    public static final String DIRECTORIO_PROYECTO = System.getProperty("user.dir");

    public static void guardarExperimento(Experimento experimento, String nombreArchivo) {
        String rutaCompleta = DIRECTORIO_PROYECTO + File.separator + nombreArchivo;
        try (Writer writer = new FileWriter(rutaCompleta)) {
            Gson gson = new Gson();
            gson.toJson(experimento, writer);
            System.out.println("El experimento se ha guardado correctamente en " + rutaCompleta);
        } catch (IOException e) {
            System.err.println("Error al guardar el experimento: " + e.getMessage());
        }
    }
}
