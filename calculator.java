import java.util.Scanner;
import java.util.ArrayList;


class calculator {
    public static void main(String[] args) {
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