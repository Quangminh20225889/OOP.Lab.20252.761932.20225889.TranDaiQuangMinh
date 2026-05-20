import javax.swing.JOptionPane;

public class Equations {
    public static void main(String[] args) {
        String[] options = {"Linear (ax+b=0)", "Linear System 2 vars", "Quadratic (ax²+bx+c=0)"};
        int choice = JOptionPane.showOptionDialog(null, "Choose equation type:",
                "Equations Solver", 0, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            // --- Phương trình bậc 1: ax + b = 0 ---
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

            if (a == 0) {
                JOptionPane.showMessageDialog(null,
                    b == 0 ? "Infinite solutions" : "No solution");
            } else {
                JOptionPane.showMessageDialog(null, "x = " + (-b / a));
            }

        } else if (choice == 1) {
            // --- Hệ phương trình bậc 1 ---
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("a11:"));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("a12:"));
            double b1  = Double.parseDouble(JOptionPane.showInputDialog("b1:"));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("a21:"));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("a22:"));
            double b2  = Double.parseDouble(JOptionPane.showInputDialog("b2:"));

            double D  = a11*a22 - a21*a12;
            double D1 = b1*a22  - b2*a12;
            double D2 = a11*b2  - a21*b1;

            if (D == 0) {
                JOptionPane.showMessageDialog(null,
                    (D1 == 0 && D2 == 0) ? "Infinite solutions" : "No solution");
            } else {
                JOptionPane.showMessageDialog(null,
                    "x1 = " + (D1/D) + "\nx2 = " + (D2/D));
            }

        } else {
            // --- Phương trình bậc 2: ax² + bx + c = 0 ---
            double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
            if (a == 0) {
                JOptionPane.showMessageDialog(null, "a must not be 0!");
                System.exit(0);
            }
            double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

            double delta = b*b - 4*a*c;

            if (delta < 0) {
                JOptionPane.showMessageDialog(null, "No real roots (Δ < 0)");
            } else if (delta == 0) {
                JOptionPane.showMessageDialog(null, "Double root: x = " + (-b / (2*a)));
            } else {
                JOptionPane.showMessageDialog(null,
                    "x1 = " + ((-b + Math.sqrt(delta)) / (2*a)) +
                    "\nx2 = " + ((-b - Math.sqrt(delta)) / (2*a)));
            }
        }
        System.exit(0);
    }
}