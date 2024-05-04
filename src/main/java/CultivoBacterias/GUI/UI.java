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
     JLabel nombreLabel, fechaInicioLabel, fechaFinLabel, numBacteriasLabel, temperaturaLabel, luminosidadLabel, dosisInicialLabel, diaConsumirLabel, comidaInicialLabel, comidaFinalLabel;
     JXTextField nombreField, numBacteriasField, temperaturaField, luminosidadField, dosisInicialField, diaConsumirField, comidaInicialField, comidaFinalField;
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
        verDetallesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDetallesPoblacion();
            }
        });
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

            diaConsumirLabel = new JLabel("Día a partir del cual se consume la comida:");
            diaConsumirField = new JXTextField();

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
                    int diaConsumir = Integer.parseInt(diaConsumirField.getText());
                    int comidaFinal = Integer.parseInt(comidaFinalField.getText());

                    if (dosisInicial <= 0 || dosisInicial >= 300 || comidaFinal <= 0 || comidaFinal >= 300) {
                        JOptionPane.showMessageDialog(crearExperimentoFrame, "Las cantidades de comida deben ser valores enteros entre 0 y 300", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    DosisAlimento dosisAlimento = new DosisAlimento(dosisInicial, diaConsumir, comidaFinal);
                    PoblacionBacterias poblacion = new PoblacionBacterias(nombre, fechaInicio, fechaFin, numBacterias, temperatura, luminosidad, dosisAlimento);

                    if(experimentoActual == null) {
                        experimentoActual = new Experimento();
                    }
                    experimentoActual.agregarPoblacion(poblacion);

                    JOptionPane.showMessageDialog(crearExperimentoFrame, "Población de bacterias agregada correctamente");

                    limpiarCampos(crearExperimentoPanel);
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
            crearExperimentoPanel.add(diaConsumirLabel);
            crearExperimentoPanel.add(diaConsumirField);
            crearExperimentoPanel.add(comidaFinalLabel);
            crearExperimentoPanel.add(comidaFinalField);
            crearExperimentoPanel.add(agregarPoblacionButton);

            crearExperimentoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            crearExperimentoFrame.add(crearExperimentoPanel);
            crearExperimentoFrame.pack();
            crearExperimentoFrame.setLocationRelativeTo(null);
            crearExperimentoFrame.setVisible(true);
    }

    private void mostrarDetallesPoblacion() {
        if (experimentoActual != null && experimentoActual.getPoblaciones().size() > 0) {
            String[] nombresPoblaciones = new String[experimentoActual.getPoblaciones().size()];
            for (int i = 0; i < experimentoActual.getPoblaciones().size(); i++) {
                nombresPoblaciones[i] = experimentoActual.getPoblaciones().get(i).getNombre();
            }

            String seleccion = (String) JOptionPane.showInputDialog(frame,"Selección de una población", "Seleccione una población", JOptionPane.QUESTION_MESSAGE, null, nombresPoblaciones, nombresPoblaciones[0]);

            if (seleccion != null) {
                for (PoblacionBacterias poblacion : experimentoActual.getPoblaciones()) {
                    if (poblacion.getNombre().equals(seleccion)) {
                        mostrarInformacionDetalladaPoblacion(poblacion);
                        break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No hay poblaciones de bacterias en el experimento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarInformacionDetalladaPoblacion(PoblacionBacterias poblacion) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Detalles de la población de bacterias:\n\n");
        mensaje.append("Nombre: ").append(poblacion.getNombre()).append("\n");
        mensaje.append("Fecha de Inicio: ").append(poblacion.getFechaInicio()).append("\n");
        mensaje.append("Fecha de Fin: ").append(poblacion.getFechaFin()).append("\n");
        mensaje.append("Número de bacterias: ").append(poblacion.getNumBacterias()).append("\n");
        mensaje.append("Temperatura: ").append(poblacion.getTemperatura()).append("\n");
        mensaje.append("Luminosidad: ").append(poblacion.getLuminosidad()).append("\n");

        DosisAlimento dosisAlimento = poblacion.getDosisAlimento();
        mensaje.append("Dosis de alimento por día:\n");
        for (int dia = 1; dia <= 30; dia++) {
            mensaje.append("  Día ").append(dia).append(": ").append(dosisAlimento.calcularCantidadComida(dia, experimentoActual)).append("g\n");
        }
        textArea.setText(mensaje.toString());
    }

    private void limpiarCampos(JPanel crearExperimentoPanel) {
        for (Component c : crearExperimentoPanel.getComponents()) {
            if (c instanceof JXTextField) {
                ((JXTextField) c).setText("");
            }
        }
    }
}
