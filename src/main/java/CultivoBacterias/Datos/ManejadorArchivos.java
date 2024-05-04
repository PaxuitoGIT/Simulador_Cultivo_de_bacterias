package CultivoBacterias.Datos;

import CultivoBacterias.Lógica.Experimento;
import com.google.gson.Gson;

import java.io.*;

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

    public static Experimento cargarExperimento(String nombreArchivo) {
        String rutaCompleta = DIRECTORIO_PROYECTO + File.separator + nombreArchivo;
        Experimento experimento = null;
        try (Reader reader = new FileReader(rutaCompleta)) {
            Gson gson = new Gson();
            experimento = gson.fromJson(reader, Experimento.class);
            System.out.println("El experimento se ha cargado correctamente desde " + rutaCompleta);
        } catch (IOException e) {
            System.err.println("Error al cargar el experimento: " + e.getMessage());
        }
        return experimento;
    }

}
