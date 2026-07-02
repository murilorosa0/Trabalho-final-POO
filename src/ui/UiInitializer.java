package ui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class UiInitializer {

    private String monitoringFolder;

    public UiInitializer() {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.err.println("Falha ao iniciar o FlatLaf");
        }

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Gerenciamento de Pedidos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800,600);

            JMenuBar jMenuBar = new JMenuBar();
            JMenu optionsMenu = getJMenu(frame);
            jMenuBar.add(optionsMenu);
            frame.setJMenuBar(jMenuBar);

            CardLayout cardLayout = new CardLayout();
            JPanel jPanel = new JPanel(cardLayout);
            jPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            HomeScreen hs = new HomeScreen();
            jPanel.add(hs.getMainPanel(), "mainPanel");
            cardLayout.show(jPanel, "mainPanel");

            frame.setContentPane(jPanel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });

    }

    private JMenu getJMenu(JFrame frame) {
        JMenu optionsMenu = new JMenu("Opções");
        JMenuItem folderChooser = new JMenuItem("Selecionar pasta de monitoramento");
        folderChooser.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Selecione a pasta com os arquivos CSV");
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int answer = jFileChooser.showOpenDialog(frame);
            if (answer == JFileChooser.APPROVE_OPTION) {
                File selectedFolder = jFileChooser.getSelectedFile();
                String path = selectedFolder.getAbsolutePath();

                this.monitoringFolder = path;
                JOptionPane.showMessageDialog(frame, "O sistema irá monitorar:\n" + path, "Pasta selecionada",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        optionsMenu.add(folderChooser);
        return optionsMenu;
    }

    public String getMonitoringFolder() {
        return monitoringFolder;
    }
}
