package ui;

import domain.model.State;
import main.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class TaxesScreen {

    private JPanel taxesPanel;
    private JComboBox<String> statesList;
    private JLabel textArea;
    private JLabel textArea1;
    private JFormattedTextField taxValue;
    private JButton doneButton;
    private JButton viewButton;

    public TaxesScreen() {


        textArea.setFont(new Font("Arial", Font.BOLD, 13));
        textArea1.setFont(new Font("Arial", Font.BOLD, 13));

        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(4);
        NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
        numberFormatter.setAllowsInvalid(true);
        numberFormatter.setCommitsOnValidEdit(false);
        numberFormat.setParseIntegerOnly(false);

        taxValue.setFormatterFactory(new DefaultFormatterFactory(numberFormatter));
        taxValue.setValue(0.0);

        String[] states = Arrays.stream(State.values()).map(State::getName).toArray(String[]::new);
        statesList.setModel(new DefaultComboBoxModel<>(states));

        doneButton.addActionListener(e -> {
            System.out.println("clico");
            Number number = (Number) taxValue.getValue();
            double tax = (number != null) ? number.doubleValue() : 0.0;
            if (tax <= 0) {
                JOptionPane.showMessageDialog(null, "Adicione um valor válido para alíquota", "ERRO", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String selected = String.valueOf(statesList.getSelectedItem());
            State state = State.getStateByName(selected);
            System.out.println(selected);
            System.out.println(state);

            Main.taxCalculator.setTaxesPerState(state, tax);
            HomeScreen.notification(state.getName() + ": alíquota alterada para " + tax + "%");


        });

        viewButton.addActionListener(e -> {

            JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource()), "Lista de Alíquotas", true);
            dialog.setSize(500,200);
            dialog.setLocationRelativeTo(dialog.getParent());


            String[] colunas = {"Estado", "Alíquota"};

            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            JTable jTable = new JTable(model);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            jTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            jTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);


            JScrollPane jScrollPane = new JScrollPane(jTable);
            dialog.add(jScrollPane);

            Main.taxCalculator.getTaxesPerState().forEach((State estado, Double aliquota) -> {
                String aliquotaFormatada = String.format("%.1f %%", aliquota);

                Object[] linha = { estado.getName(), aliquotaFormatada };
                model.addRow(linha);
            });
            dialog.setVisible(true);
        });




    }

    public JPanel getTaxesPanel() {
        return taxesPanel;
    }




}
