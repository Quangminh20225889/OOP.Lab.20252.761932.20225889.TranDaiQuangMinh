package Lab05.AimsProject.SourceCode.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

    private Cart cart;
    private Store store;

    public CartScreen(Cart cart) {
        this(cart, null);
    }

    public CartScreen(Cart cart, Store store) {
        super("AIMS Cart");
        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        add(fxPanel, BorderLayout.CENTER);

        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        Platform.runLater(() -> loadCartScreen(fxPanel));
    }

    private void loadCartScreen(JFXPanel fxPanel) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
            loader.setController(new CartScreenController(cart, store, this));
            Parent root = loader.load();
            fxPanel.setScene(new Scene(root));
        } catch (Exception exception) {
            exception.printStackTrace();
            SwingUtilities.invokeLater(() -> {
                getContentPane().remove(fxPanel);

                JLabel errorLabel = new JLabel(
                        "Cannot load cart.fxml. Check terminal for details.",
                        JLabel.CENTER
                );
                errorLabel.setForeground(Color.RED);
                add(errorLabel, BorderLayout.CENTER);
                revalidate();
                repaint();

                JOptionPane.showMessageDialog(
                        this,
                        exception.toString(),
                        "Cart screen error",
                        JOptionPane.ERROR_MESSAGE
                );
            });
        }
    }

    public Cart getCart() {
        return cart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CartScreen(new Cart(), new Store()));
    }
}
