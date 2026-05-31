package Lab04.AimsProject.SourceCode.UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {

    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete;
    private JButton btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setEditable(false);
        add(tfDisplay, BorderLayout.NORTH);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);
        add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(250, 300);
        setVisible(true);
    }

    private void addButtons(JPanel panelButtons) {
        ButtonListener listener = new ButtonListener();

        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton(String.valueOf(i));
            btnNumbers[i].addActionListener(listener);
            panelButtons.add(btnNumbers[i]);
        }

        btnDelete = new JButton("DEL");
        btnDelete.addActionListener(listener);
        panelButtons.add(btnDelete);

        btnNumbers[0] = new JButton("0");
        btnNumbers[0].addActionListener(listener);
        panelButtons.add(btnNumbers[0]);

        btnReset = new JButton("C");
        btnReset.addActionListener(listener);
        panelButtons.add(btnReset);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String button = event.getActionCommand();

            if ("DEL".equals(button)) {
                String currentText = tfDisplay.getText();

                if (!currentText.isEmpty()) {
                    tfDisplay.setText(
                            currentText.substring(0, currentText.length() - 1)
                    );
                }
            } else if ("C".equals(button)) {
                tfDisplay.setText("");
            } else {
                tfDisplay.setText(tfDisplay.getText() + button);
            }
        }
    }
}
