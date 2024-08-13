import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {

    private JTextField jTextField;
    private double num1, num2, result;
    private String operador;

    public Screen() {
        setTitle("Calc2");
        setSize(650, 575);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        Font buttonFont = new Font("Arial", Font.BOLD, 40);
        Font jTextFieldFont = new Font("Arial", Font.BOLD, 34);

        jTextField = new JTextField();
        jTextField.setBounds(0, 0, 486, 120);
        jTextField.setFont(jTextFieldFont);
        add(jTextField);

        ButtonClickListener buttonClickListener = new ButtonClickListener(jTextField);

        addButton("0", 0, 420, 162, 100, buttonFont, buttonClickListener);
        addButton(".", 162, 420, 162, 100, buttonFont, buttonClickListener);
        addButton("/", 324, 420, 162, 100, buttonFont, buttonClickListener);
        addButton("=", 486, 420, 162, 100, buttonFont, buttonClickListener);

        addButton("1", 0, 318, 162, 100, buttonFont, buttonClickListener);
        addButton("2", 162, 318, 162, 100, buttonFont, buttonClickListener);
        addButton("3", 324, 318, 162, 100, buttonFont, buttonClickListener);
        addButton("*", 486, 318, 162, 100, buttonFont, buttonClickListener);

        addButton("4", 0, 216, 162, 100, buttonFont, buttonClickListener);
        addButton("5", 162, 216, 162, 100, buttonFont, buttonClickListener);
        addButton("6", 324, 216, 162, 100, buttonFont, buttonClickListener);
        addButton("-", 486, 216, 162, 100, buttonFont, buttonClickListener);

        addButton("7", 0, 114, 162, 100, buttonFont, buttonClickListener);
        addButton("8", 162, 114, 162, 100, buttonFont, buttonClickListener);
        addButton("9", 324, 114, 162, 100, buttonFont, buttonClickListener);
        addButton("+", 486, 114, 162, 100, buttonFont, buttonClickListener);

        addButton("C", 486, 0, 162, 120, buttonFont, buttonClickListener);

        setVisible(true);
    }

    private void addButton(String label, int x, int y, int width, int height, Font font, ActionListener listener) {
        JButton button = new JButton(label);
        button.setBounds(x, y, width, height);
        button.setFont(font);
        button.addActionListener(listener);
        add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Screen();
        });
    }
}
