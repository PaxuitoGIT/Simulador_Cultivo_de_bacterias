package CultivoBacterias.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTextField;

public class UI {
     JFrame frame, crearExperimentoFrame;
     JTextArea textArea;
     JButton verDetallesButton;
     JMenuBar menuBar;
     JMenu experimentoMenu;
     JMenuItem crearExperimentoItem, abrirExperimentoItem, guardarItem, guardarComoItem;
     JPanel crearExperimentoPanel;
     JLabel nombreLabel, fechaInicioLabel, fechaFinLabel, numBacteriasLabel, temperaturaLabel, luminosidadLabel, dosisInicialLabel, diaIncrementoLabel, comidaInicialLabel, comidaFinalLabel;
     JXTextField nombreField, numBacteriasField, temperaturaField, luminosidadField, dosisInicialField, diaIncrementoField, comidaInicialField, comidaFinalField;
     JXDatePicker fechaInicioPicker, fechaFinPicker;

    public UI() {
        frame = new JFrame("Laboratorio de Biólogos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        experimentoMenu = new JMenu("Experimento");

        crearExperimentoItem = new JMenuItem("Crear Nuevo Experimento");
        crearExperimentoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearNuevoExperimento();
            }
        });
        abrirExperimentoItem = new JMenuItem("Abrir Experimento");
        guardarItem = new JMenuItem("Guardar");
        guardarComoItem = new JMenuItem("Guardar Como");

        experimentoMenu.add(crearExperimentoItem);
        experimentoMenu.add(abrirExperimentoItem);
        experimentoMenu.add(guardarItem);
        experimentoMenu.add(guardarComoItem);
        menuBar.add(experimentoMenu);

        frame.setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        mainPanel.add(new JScrollPane(textArea));

        verDetallesButton = new JButton("Ver Detalles Población");
        mainPanel.add(verDetallesButton);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);

    }
        private void crearNuevoExperimento() {
            crearExperimentoFrame = new JFrame("Crear Nuevo Experimento");
            crearExperimentoPanel = new JPanel();
            crearExperimentoPanel.setLayout(new GridLayout(0,2,10,10));

            nombreLabel = new JLabel("Nombre:");
            nombreField = new JXTextField();

            fechaInicioLabel = new JLabel("Fecha de Inicio:");
            fechaInicioPicker = new JXDatePicker();

            fechaFinLabel = new JLabel("Fecha de Fin:");
            fechaFinPicker = new JXDatePicker();

            numBacteriasLabel = new JLabel("Número de Bacterias:");
            numBacteriasField = new JXTextField();

            temperaturaLabel = new JLabel("Temperatura:");
            temperaturaField = new JXTextField();

            luminosidadLabel = new JLabel("Luminosidad:");
            String[] luminosidades = {"Baja", "Media", "Alta"};
            JComboBox<String> luminosidadComboBox = new JComboBox<>(luminosidades);

            dosisInicialLabel = new JLabel("Dosis Inicial de Alimento:");
            dosisInicialField = new JXTextField();

            diaIncrementoLabel = new JLabel("Día de Incremento:");
            diaIncrementoField = new JXTextField();

            comidaInicialLabel = new JLabel("Comida Inicial:");
            comidaInicialField = new JXTextField();

            comidaFinalLabel = new JLabel("Comida Final:");
            comidaFinalField = new JXTextField();

    }
}
