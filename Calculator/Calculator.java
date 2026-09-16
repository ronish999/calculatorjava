import javax.swing.*;
import java.awt.*;

public class Calculator {
    //----------Variable used for calculator-----------//

    //Stores the first number

    static double num1 = 0;

    //Stores the second number

    static double num2 = 0;

    //Stores the selected operator : +,-,* or /

    static String operator = "";

    public static void main(String[] args){

        //------Step :1  Create the main window

        JFrame frame = new JFrame("Calculator");

        frame.setSize(400,500);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Step 2: Create the display

        JTextField display = new JTextField();

        display.setHorizontalAlignment(JTextField.RIGHT);

        //Step 3:  Create a panel for the button

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(4,4));


        //Step 4:  Create the buttons

        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton buttonPlus = new JButton("+");

        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton buttonMinus = new JButton("-");

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton buttonMultiply = new JButton("*");

        JButton button0 = new JButton("0");
        JButton buttonClear = new JButton("C");
        JButton buttonEqual = new JButton("=");
        JButton buttonDivide = new JButton("/");


        //Step 5: add button to the panel

        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonPlus);

        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonMinus);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonMultiply);

        panel.add(button0);
        panel.add(buttonClear);
        panel.add(buttonEqual);
        panel.add(buttonDivide);

        //Step 6: add components to the frame

        frame.add(display,BorderLayout.NORTH);

        frame.add(panel,BorderLayout.CENTER);

        //Step 7: Number button events

        button7.addActionListener(e->{
            display.setText(display.getText() + "7");
        });

        button8.addActionListener(e->{
            display.setText(display.getText() + "8");
        });

        button9.addActionListener(e->{
            display.setText(display.getText() + "9");
        });

        button4.addActionListener(e->{
            display.setText(display.getText() + "4");
        });

        button5.addActionListener(e->{
            display.setText(display.getText() + "5");
        });

        button6.addActionListener(e->{
            display.setText(display.getText() + "6");
        });

        button1.addActionListener(e->{
            display.setText(display.getText() + "1");
        });

        button0.addActionListener(e->{
            display.setText(display.getText() + "0");
        });

        //Step 8: Operator events

        buttonPlus.addActionListener(e->{

            num1 = Double.parseDouble(display.getText());

            operator = "+";

            display.setText(" ");
        });

        buttonMinus.addActionListener(e->{

            num1 = Double.parseDouble(display.getText());

            operator = "-";

            display.setText(" ");
        });

        buttonMultiply.addActionListener(e->{

            num1 = Double.parseDouble(display.getText());

            operator = "*";

            display.setText(" ");
        });

        buttonDivide.addActionListener(e->{

            num1 = Double.parseDouble(display.getText());

            operator = "/";

            display.setText(" ");
        });

         buttonEqual.addActionListener(e->{
            num2 = Double.parseDouble(display.getText());
            double result = 0;
        
        if (operator.equals("+")){
            result= num1+num2;
        }

        if (operator.equals("-")){
            result= num1-num2;
        }

        if (operator.equals("*")){
            result= num1*num2;
        }

        if (operator.equals("/")){
            result= num1/num2;
        }

        display.setText(String.valueOf(result));
    });

    //Step 10: Clear buttons

      buttonDivide.addActionListener(e->{

        display.setText("");

        num1 = 0;
        num2 = 0;

        operator = " ";

      });

      //Step 11: show the window

      frame.setVisible(true);

    }

}