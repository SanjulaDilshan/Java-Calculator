import java.util.Scanner;
import java.util.ArrayList;


class calculator {
    public static void main(String[] args) {
        ArrayList<String> history = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter operator (+, -, *, /, %, s, ^): ");
            char operator = scanner.next().charAt(0);
            
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
                case 'h':
                    System.out.println("Calculation History:");
                    for (String record : history) {
                        System.out.println(record);
                    }
                    break;

                default:
                    System.out.println("Error: Invalid operator.");
            
            }
            System.out.print("Do you want to perform another calculation? (y/n): ");
            choice = scanner.next().charAt(0);

        }
        while (choice == 'y' || choice == 'Y');

        System.out.println("Thank you for using the calculator!");
        scanner.close();
    }
}