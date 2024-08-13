import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ButtonClickListener implements ActionListener {
    private DecimalFormat decimalFormat;
    private JTextField jTextField;
    private double num1, num2, result;
    private String operador;

    public ButtonClickListener(JTextField jTextField) {
        this.jTextField = jTextField;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');

        decimalFormat = new DecimalFormat("#,##0.00", symbols);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = ((JButton) e.getSource()).getText();
        switch (command) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                addDigit(command);
                break;
            case ".":
                addDecimalSeparator();
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (!jTextField.getText().isEmpty()) {
                    num1 = parseTextField(jTextField.getText());
                }
                operador = command;
                jTextField.setText("");
                break;
            case "=":
                if (!jTextField.getText().isEmpty()) {
                    num2 = parseTextField(jTextField.getText());
                    switch (operador) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0)
                                result = num1 / num2;
                            else
                                result = Double.NaN;
                            break;
                    }
                    jTextField.setText(formatResult(result));
                }
                break;
            case "C":
                jTextField.setText("");
                break;
        }
    }

    private void addDigit(String digit) {
        String currentText = jTextField.getText();
        jTextField.setText(currentText + digit);
    }

    private void addDecimalSeparator() {
        String currentText = jTextField.getText();
        if (!currentText.contains(".")) {
            jTextField.setText(currentText + ".");
        }
    }

    private double parseTextField(String text) {
        try {
            text = text.replace(",", ".");
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String formatResult(double result) {
        return decimalFormat.format(result);
    }
}
