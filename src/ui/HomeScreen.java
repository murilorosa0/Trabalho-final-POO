package ui;

import domain.model.State;
import domain.service.TaxCalculator;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class HomeScreen {

    private JPanel mainPanel;
    private JButton processBatch;
    private JButton taxesButton;

    public HomeScreen() {

        customButton(processBatch, new Color(91, 160, 89), "start_icon.png");

        processBatch.addActionListener(e -> {
            System.out.println("chamou");
            // Começar o monitoramento

            boolean sucess = false;

            if (sucess) {
                customButton(processBatch, new Color(91, 160, 89), "monitoring_icon.png");
                processBatch.setText("MONITORANDO PASTA");
                processBatch.putClientProperty("FlatLaf.style", "disabledBackground: #5ba059; disabledText: #FFFFFF");
                processBatch.setEnabled(false);
            } else {
                customButton(processBatch, Color.RED, "monitoring_icon.png");
                processBatch.setText("ERRO");
                JOptionPane.showMessageDialog(null, "Falha ao monitorar pasta", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        });

        customButton(taxesButton, new Color(70, 73, 75), null);
        taxesButton.setForeground(new Color(220, 224, 230));

        taxesButton.addActionListener(e -> {

            TaxesScreen taxesScreen = new TaxesScreen();
            JFrame jFrame = new JFrame("Configuração de Impostos");
            jFrame.setContentPane(taxesScreen.getTaxesPanel());

            taxesScreen.getTaxesPanel().setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
            jFrame.setSize(400,300);
            jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
            jFrame.pack();

            JMenu optionsMenu = new JMenu("Opções");
            JMenuItem randomValues = new JMenuItem("Adicionar valores aleatorios para todos estados");
            randomValues.addActionListener(j -> {

                Random random = new Random();
                for (State state : State.values()) {
                    Main.taxCalculator.setTaxesPerState(state, random.nextDouble(10.0));
                }


            });

            optionsMenu.add(randomValues);

            JMenuBar jMenuBar = new JMenuBar();
            jMenuBar.add(optionsMenu);
            jFrame.setJMenuBar(jMenuBar);


        });


    }

    public static void customButton(JButton button, Color backgroundColor, String iconPath) {
        //button.setText(text);

        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true); // Garanta que está como 'true' para pintar o fundo!

        button.setForeground(Color.WHITE);
        button.setBackground(backgroundColor);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);

        if (iconPath != null && !iconPath.trim().isEmpty()) {
            try {
                ImageIcon imageIcon = new ImageIcon(iconPath);
                Image imageO = imageIcon.getImage();
                Image image = imageO.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(image);
                button.setIcon(icon);
                button.setDisabledIcon(icon);
            } catch (Exception e) {
                System.err.println("Erro ao carregar o ícone: " + iconPath);
            }
        } else {
            button.setIcon(null); // Remove o ícone caso seja passado vazio/nulo
        }
    }

    public static void notification(String message) {
        JWindow notification = new JWindow();

        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.BLACK);
        label.setOpaque(true);
        label.setBackground(new Color(47, 204, 65));
        label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        notification.add(label);
        notification.pack();
        notification.setLocationRelativeTo(null);
        notification.setLocation(notification.getX(), notification.getY() - 180);
        notification.setVisible(true);

        Timer timer = new Timer(2000, e ->{
            notification.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
