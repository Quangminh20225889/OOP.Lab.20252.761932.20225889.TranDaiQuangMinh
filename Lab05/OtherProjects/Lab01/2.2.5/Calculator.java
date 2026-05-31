import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog("Enter number 1:");
        String s2 = JOptionPane.showInputDialog("Enter number 2:");

        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);

        String result = "Sum:        " + (num1 + num2)
                      + "\nDifference: " + (num1 - num2)
                      + "\nProduct:    " + (num1 * num2);

        if (num2 == 0) {
            result += "\nQuotient:   Cannot divide by zero!";
        } else {
            result += "\nQuotient:   " + (num1 / num2);
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}
