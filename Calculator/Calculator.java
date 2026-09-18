import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Calculator {

    static double num1 = 0;
    static double num2 = 0;
    static String operator = "";
    static boolean isOperatorSet = false;
    static boolean hasCalculatedResult = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setSize(380, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Display area
        JTextField display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setPreferredSize(new Dimension(380, 70));

        // Panel for buttons (5 rows, 4 columns)
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // Create buttons
        JButton buttonClearAll = new JButton("C");
        JButton buttonBackspace = new JButton("←"); // Single clear button
        JButton buttonDivide = new JButton("/");
        JButton buttonMultiply = new JButton("*");

        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonMinus = new JButton("-");

        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonPlus = new JButton("+");

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonEqual = new JButton("=");

        JButton button0 = new JButton("0");
        JButton buttonDot = new JButton(".");

        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        JButton[] buttons = {
            buttonClearAll, buttonBackspace, buttonDivide, buttonMultiply,
            button7, button8, button9, buttonMinus,
            button4, button5, button6, buttonPlus,
            button1, button2, button3, buttonEqual,
            button0, buttonDot
        };

        for (JButton b : buttons) {
            b.setFont(buttonFont);
        }

        // Add buttons to grid layout
        panel.add(buttonClearAll);
        panel.add(buttonBackspace);
        panel.add(buttonDivide);
        panel.add(buttonMultiply);

        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonMinus);

        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonPlus);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonEqual);

        panel.add(button0);
        panel.add(buttonDot);

        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        // Number listener setup
        button7.addActionListener(e -> appendNumber(display, "7"));
        button8.addActionListener(e -> appendNumber(display, "8"));
        button9.addActionListener(e -> appendNumber(display, "9"));
        button4.addActionListener(e -> appendNumber(display, "4"));
        button5.addActionListener(e -> appendNumber(display, "5"));
        button6.addActionListener(e -> appendNumber(display, "6"));
        button1.addActionListener(e -> appendNumber(display, "1"));
        button2.addActionListener(e -> appendNumber(display, "2"));
        button3.addActionListener(e -> appendNumber(display, "3"));
        button0.addActionListener(e -> appendNumber(display, "0"));
        buttonDot.addActionListener(e -> appendNumber(display, "."));

        // Operator listeners
        buttonPlus.addActionListener(e -> setOperator(display, "+"));
        buttonMinus.addActionListener(e -> setOperator(display, "-"));
        buttonMultiply.addActionListener(e -> setOperator(display, "*"));
        buttonDivide.addActionListener(e -> setOperator(display, "/"));

        // Equal button logic
        buttonEqual.addActionListener(e -> {
            if (!operator.isEmpty() && isOperatorSet) {
                String fullText = display.getText();
                String[] parts = fullText.split(" \\" + operator + " ");

                if (parts.length == 2) {
                    try {
                        num2 = Double.parseDouble(parts[1]);
                        double result = 0;

                        switch (operator) {
                            case "+" -> result = num1 + num2;
                            case "-" -> result = num1 - num2;
                            case "*" -> result = num1 * num2;
                            case "/" -> result = num2 != 0 ? num1 / num2 : 0;
                        }

                        DecimalFormat df = new DecimalFormat("#.##");
                        display.setText(df.format(result));

                        operator = "";
                        isOperatorSet = false;
                        hasCalculatedResult = true;

                    } catch (NumberFormatException ex) {
                        display.setText("Error");
                    }
                }
            }
        });

        // Clear single character (Backspace)
        buttonBackspace.addActionListener(e -> {
            String text = display.getText();
            if (!text.isEmpty()) {
                // If ending with a formatted operator space like " + "
                if (text.endsWith(" ")) {
                    display.setText(text.substring(0, text.length() - 3));
                    isOperatorSet = false;
                    operator = "";
                } else {
                    display.setText(text.substring(0, text.length() - 1));
                }
            }
        });

        // Clear All button
        buttonClearAll.addActionListener(e -> {
            display.setText("");
            num1 = 0;
            num2 = 0;
            operator = "";
            isOperatorSet = false;
            hasCalculatedResult = false;
        });

        frame.setVisible(true);
    }

    private static void appendNumber(JTextField display, String num) {
        if (hasCalculatedResult) {
            display.setText(num);
            hasCalculatedResult = false;
        } else {
            display.setText(display.getText() + num);
        }
    }

    private static void setOperator(JTextField display, String op) {
        if (!display.getText().isEmpty() && !isOperatorSet) {
            try {
                num1 = Double.parseDouble(display.getText());
                operator = op;
                isOperatorSet = true;
                hasCalculatedResult = false;
                display.setText(display.getText() + " " + op + " ");
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        }
    }
}