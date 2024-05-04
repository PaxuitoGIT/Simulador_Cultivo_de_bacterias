package CultivoBacterias.Datos;

import CultivoBacterias.Lógica.Experimento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ManejadorArchivos {
    public static final String DIRECTORIO_PROYECTO = System.getProperty("user.dir");

    public static void guardarExperimento(Experimento experimento, String nombreArchivo) {
        String rutaCompleta = DIRECTORIO_PROYECTO + File.separator + nombreArchivo;
        try (Writer writer = new FileWriter(rutaCompleta)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
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

    public static String seleccionarArchivo(JFrame frame, String titulo, int modo) {
        FileDialog dialogoArchivo = new FileDialog(frame, titulo, modo);
        dialogoArchivo.setDirectory(DIRECTORIO_PROYECTO);
        dialogoArchivo.setVisible(true);
        String nombreArchivo = dialogoArchivo.getFile();
        if (nombreArchivo != null) {
            return nombreArchivo;
        } else {
            return null;
        }
    }

    public static String agregarExtensionJSON(String nombreArchivo) {
        if (nombreArchivo != null && !nombreArchivo.endsWith(".json")) {
            return nombreArchivo + ".json";
        } else {
            return nombreArchivo;
        }
    }
}
