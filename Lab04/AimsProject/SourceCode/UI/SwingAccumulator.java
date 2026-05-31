package Lab04.AimsProject.SourceCode.UI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {

    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 2));

        container.add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        container.add(tfInput);
        tfInput.addActionListener(new InputListener());

        container.add(new JLabel("The Accumulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        container.add(tfOutput);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class InputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
