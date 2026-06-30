import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Calculator extends JFrame implements ActionListener {
    // UI Elements
    private JTextField display;
    private ArrayList<String> history = new ArrayList<>();
    
    // Core Logic States
    private double num1 = 0;
    private String operator = "";
    private boolean isNewInput = true;

    public Calculator() {
        // Frame Configurations
        setTitle("Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Step 1: Base Frame uses BorderLayout
        setLayout(new BorderLayout());

        // Step 2: Configure the Display Screen (Top)
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(display, BorderLayout.NORTH); // Pins screen to the top

        // Step 3: Create a separate Panel for Buttons (Center)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5 rows, 4 columns
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Unified button layout grid matching your specifications
        String[] buttons = {"7", "8", "9", "/","4", "5", "6", "*","1", "2", "3", "-","0", "%", "pow", "+","sqrt", "History", "C", "="};

        for (String label : buttons) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.addActionListener(this);
            btn.setFocusable(false);
            buttonPanel.add(btn);
        }

        // Add the button matrix panel to the center of the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Render Frame after layout assemblies are complete
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Clear State
        if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            operator = "";
            isNewInput = true;
        }
        // Native History Display Popup
        else if (command.equals("History")) {
            if (history.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No calculations recorded yet.", "History", JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder historyLog = new StringBuilder();
                for (String entry : history) {
                    historyLog.append(entry).append("\n");
                }
                JOptionPane.showMessageDialog(this, historyLog.toString(), "Calculation History", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // Appends digits
        else if (command.matches("[0-9]")) {
            if (isNewInput) {
                display.setText(command);
                isNewInput = false;
            } else {
                display.setText(display.getText() + command);
            }
        }
        // Single operand evaluation (Evaluates immediately)
        else if (command.equals("sqrt")) {
            if (!display.getText().isEmpty()) {
                double val = Double.parseDouble(display.getText());
                if (val >= 0) {
                    double result = Math.sqrt(val);
                    display.setText(String.valueOf(result));
                    history.add("sqrt(" + val + ") = " + result);
                } else {
                    display.setText("Error");
                }
                isNewInput = true;
            }
        }
        // Binary Evaluation Trigger
        else if (command.equals("=")) {
            if (!operator.isEmpty() && !display.getText().isEmpty()) {
                double num2 = Double.parseDouble(display.getText());
                double result = 0;
                boolean validOperation = true;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "pow": result = Math.pow(num1, num2); break;
                    case "/": 
                        if (num2 != 0) result = num1 / num2; 
                        else validOperation = false;
                        break;
                    case "%": 
                        if (num2 != 0) result = num1 % num2; 
                        else validOperation = false;
                        break;
                }

                if (validOperation) {
                    String cleanSymbol = operator.equals("pow") ? "^" : operator;
                    history.add(num1 + " " + cleanSymbol + " " + num2 + " = " + result);
                    display.setText(String.valueOf(result));
                    num1 = result; // Preserves result for chain operations
                } 
                else {
                    display.setText("Error");
                }
                operator = "";
                isNewInput = true;
            }
        }
        // Dual operand operator assignment (+, -, *, /, %, pow)
        else {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command;
                isNewInput = true;
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}