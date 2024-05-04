package CultivoBacterias.GUI;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import CultivoBacterias.Lógica.DosisAlimento;
import CultivoBacterias.Lógica.Experimento;
import CultivoBacterias.Lógica.PoblacionBacterias;
import org.jdesktop.swingx.JXDatePicker;
import org.jdesktop.swingx.JXTextField;

public class UI {
     JFrame frame, crearExperimentoFrame;
     JTextArea textArea;
     JButton verDetallesButton, agregarPoblacionButton;
     JMenuBar menuBar;
     JMenu experimentoMenu;
     JMenuItem crearExperimentoItem, abrirExperimentoItem, guardarItem, guardarComoItem;
     JPanel crearExperimentoPanel;
     JLabel nombreLabel, fechaInicioLabel, fechaFinLabel, numBacteriasLabel, temperaturaLabel, luminosidadLabel, dosisInicialLabel, diaIncrementoLabel, comidaInicialLabel, comidaFinalLabel;
     JXTextField nombreField, numBacteriasField, temperaturaField, luminosidadField, dosisInicialField, diaIncrementoField, comidaInicialField, comidaFinalField;
     JXDatePicker fechaInicioPicker, fechaFinPicker;

     private Experimento experimentoActual;

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

            comidaFinalLabel = new JLabel("Comida Final (dia 30):");
            comidaFinalField = new JXTextField();

            agregarPoblacionButton = new JButton("Agregar Población");
            agregarPoblacionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombre = nombreField.getText();
                    Date fechaInicio = fechaInicioPicker.getDate();
                    Date fechaFin = fechaFinPicker.getDate();
                    int numBacterias = Integer.parseInt(numBacteriasField.getText());
                    int temperatura = Integer.parseInt(temperaturaField.getText());
                    String luminosidad = (String) luminosidadComboBox.getSelectedItem();
                    int dosisInicial = Integer.parseInt(dosisInicialField.getText());
                    int diaIncremento = Integer.parseInt(diaIncrementoField.getText());
                    int comidaFinal = Integer.parseInt(comidaFinalField.getText());

                    if (dosisInicial <= 0 || dosisInicial >= 300 || comidaFinal <= 0 || comidaFinal >= 300) {
                        JOptionPane.showMessageDialog(crearExperimentoFrame, "Las cantidades de comida deben ser valores enteros entre 0 y 300", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    DosisAlimento dosisAlimento = new DosisAlimento(dosisInicial, diaIncremento, dosisInicial, comidaFinal);
                    PoblacionBacterias poblacion = new PoblacionBacterias(nombre, fechaInicio, fechaFin, numBacterias, temperatura, luminosidad, dosisAlimento);

                    if(experimentoActual == null) {
                        experimentoActual = new Experimento();
                    }
                    experimentoActual.agregarPoblacion(poblacion);

                    JOptionPane.showMessageDialog(crearExperimentoFrame, "Población de bacterias agregada correctamente");
                }
            });

            crearExperimentoPanel.add(nombreLabel);
            crearExperimentoPanel.add(nombreField);
            crearExperimentoPanel.add(fechaInicioLabel);
            crearExperimentoPanel.add(fechaInicioPicker);
            crearExperimentoPanel.add(fechaFinLabel);
            crearExperimentoPanel.add(fechaFinPicker);
            crearExperimentoPanel.add(numBacteriasLabel);
            crearExperimentoPanel.add(numBacteriasField);
            crearExperimentoPanel.add(temperaturaLabel);
            crearExperimentoPanel.add(temperaturaField);
            crearExperimentoPanel.add(luminosidadLabel);
            crearExperimentoPanel.add(luminosidadComboBox);
            crearExperimentoPanel.add(dosisInicialLabel);
            crearExperimentoPanel.add(dosisInicialField);
            crearExperimentoPanel.add(diaIncrementoLabel);
            crearExperimentoPanel.add(diaIncrementoField);
            crearExperimentoPanel.add(comidaFinalLabel);
            crearExperimentoPanel.add(comidaFinalField);
            crearExperimentoPanel.add(agregarPoblacionButton);

            crearExperimentoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            crearExperimentoFrame.add(crearExperimentoPanel);
            crearExperimentoFrame.pack();
            crearExperimentoFrame.setLocationRelativeTo(null);
            crearExperimentoFrame.setVisible(true);
    }
}
