import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;


class calculator {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JTextField display = new JTextField();
        frame.add(display);

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4"); 
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button0 = new JButton("0");
        JButton buttonAdd = new JButton("+");
        JButton buttonSubtract = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonModulo = new JButton("%");
        JButton buttonSqrt = new JButton("sqrt");
        JButton buttonPower = new JButton("pow");
        JButton buttonHistory = new JButton("History");

        frame.setLayout(new java.awt.GridLayout(5,4));
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button0);
        frame.add(buttonAdd);
        frame.add(buttonSubtract);
        frame.add(buttonMultiply);
        frame.add(buttonDivide);
        frame.add(buttonModulo);
        frame.add(buttonSqrt);
        frame.add(buttonPower);
        frame.add(buttonHistory);

        button1.addActionListener(e -> display.setText(display.getText() + "1"));
        button2.addActionListener(e -> display.setText(display.getText() + "2"));
        button3.addActionListener(e -> display.setText(display.getText() + "3"));
        button4.addActionListener(e -> display.setText(display.getText() + "4"));
        button5.addActionListener(e -> display.setText(display.getText() + "5"));
        button6.addActionListener(e -> display.setText(display.getText() + "6"));
        button7.addActionListener(e -> display.setText(display.getText() + "7"));
        button8.addActionListener(e -> display.setText(display.getText() + "8"));
        button9.addActionListener(e -> display.setText(display.getText() + "9"));
        button0.addActionListener(e -> display.setText(display.getText() + "0"));
        buttonAdd.addActionListener(e -> display.setText(display.getText() + "+"));
        buttonSubtract.addActionListener(e -> display.setText(display.getText() + "-"));
        buttonMultiply.addActionListener(e -> display.setText(display.getText() + "*"));
        buttonDivide.addActionListener(e -> display.setText(display.getText() + "/"));
        buttonModulo.addActionListener(e -> display.setText(display.getText() + "%"));
        buttonSqrt.addActionListener(e -> display.setText(display.getText() + "sqrt("));
        buttonPower.addActionListener(e -> display.setText(display.getText() + "^"));
        buttonHistory.addActionListener(e -> display.setText(display.getText() + "History"));

        ArrayList<String> history = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char choice = 'n';

        System.out.println("Welcome to the Calculator!");

        do {
            System.out.print("Enter operator (+, -, *, /, %, s [sqrt], ^ [power], h [history] ): ");
            char operator = scanner.next().toLowerCase().charAt(0);

            if(operator == 'h') {
                System.out.println("Calculation History:");
                if(history.isEmpty()) {
                    System.out.println("No calculations have been performed yet.");
                } else {
                    for (String record : history) {
                        System.out.println(record);
                    }
                }
                continue; // Skip the rest of the loop and ask for operator again
            } else if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%' || operator == 's' || operator == '^') {
                // Valid operator, continue to ask for numbers
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();
                double num2 = 0; // Initialize num2 to avoid compilation error

                if (operator != 's') { // If the operator is not square root, we need a second number
                    System.out.print("Enter the second number: ");
                    num2 = scanner.nextDouble();
                }

                double result;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        history.add(num1 + " + " + num2 + " = " + result);
                        System.out.println("Result: " + result);
                        break;

                    case '-':
                        result = num1 - num2;
                        history.add(num1 + " - " + num2 + " = " + result);
                        System.out.println("Result: " + result);
                        break;

                    case '*':
                        result = num1 * num2;
                        history.add(num1 + " * " + num2 + " = " + result);
                        System.out.println("Result: " + result);
                        break;
                    case '%':
                        result = num1 % num2;
                        history.add(num1 + " % " + num2 + " = " + result);
                        System.out.println("Result: " + result);
                        break;

                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                            history.add(num1 + " / " + num2 + " = " + result);
                            System.out.println("Result: " + result);
                        } else {
                            System.out.println("Error: Division by zero is not allowed.");
                        }
                        break;
                    case 's':
                        result = Math.sqrt(num1);
                        history.add("sqrt(" + num1 + ") = " + result);
                        System.out.println("Square Root = " + result);
                        break;
                    case '^':
                        result = Math.pow(num1, num2);
                        history.add(num1 + " ^ " + num2 + " = " + result);
                        System.out.println("Result = " + result);
                        break;
                }

            } else {
                System.out.println("Error: Invalid operator.");
                continue; // Skip the rest of the loop and ask for operator again
            }

            System.out.print("Do you want to perform another calculation? (y/n): ");
            choice = scanner.next().charAt(0);

        }
        while (choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }
}