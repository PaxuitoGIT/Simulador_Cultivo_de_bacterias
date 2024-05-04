package CultivoBacterias.GUI;

import javax.swing.*;

public class UI {
    private JFrame frame;
    private JTextArea textArea;
    private JButton verDetallesButton;
    private JMenuBar menuBar;

    public UI() {
        frame = new JFrame("Laboratorio de Biólogos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();
        JMenu experimentoMenu = new JMenu("Experimento");
        JMenuItem crearExperimentoItem = new JMenuItem("Crear Nuevo Experimento");
        JMenuItem abrirExperimentoItem = new JMenuItem("Abrir Experimento");
        JMenuItem guardarItem = new JMenuItem("Guardar");
        JMenuItem guardarComoItem = new JMenuItem("Guardar Como");
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
}
