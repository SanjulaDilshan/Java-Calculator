import java.util.Scanner;
class calculator {
    public static void main(String[] args) {
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
                    System.out.println("Result: " + result);
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case '%':
                    System.out.println("Result = " + (num1 % num2));
                    break;

                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                case 's':
                    System.out.println("Square Root = " + Math.sqrt(num1));
                    break;
                case '^':
                    System.out.println("Result = " + Math.pow(num1, num2));
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