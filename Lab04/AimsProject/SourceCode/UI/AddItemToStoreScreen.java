package Lab04.AimsProject.SourceCode.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Lab04.AimsProject.SourceCode.Cart;
import Lab04.AimsProject.SourceCode.Store;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;
    protected Cart cart;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String screenTitle) {
        this.store = store;
        this.cart = cart;

        JPanel container = new JPanel(new BorderLayout());
        container.add(createNorth(screenTitle), BorderLayout.NORTH);
        container.add(createForm(), BorderLayout.CENTER);
        container.add(createButtonPanel(), BorderLayout.SOUTH);
        setContentPane(container);

        setTitle(screenTitle);
        setSize(520, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth(String screenTitle) {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader(screenTitle));
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(event -> switchScreen(
                new AddBookToStoreScreen(store, cart)
        ));

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(event -> switchScreen(
                new AddCompactDiscToStoreScreen(store, cart)
        ));

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(event -> switchScreen(
                new AddDigitalVideoDiscToStoreScreen(store, cart)
        ));

        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(event -> switchScreen(
                new StoreScreen(store, cart)
        ));

        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(event -> switchScreen(
                new CartScreen(cart, store)
        ));

        menu.add(updateStore);
        menu.add(viewStore);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader(String screenTitle) {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel(screenTitle);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 32));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    protected JPanel createForm() {
        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));

        tfTitle = addTextField(form, "Title");
        tfCategory = addTextField(form, "Category");
        tfCost = addTextField(form, "Cost");

        addSpecificFields(form);
        return form;
    }

    protected JTextField addTextField(JPanel form, String label) {
        JTextField textField = new JTextField();
        form.add(new JLabel(label));
        form.add(textField);
        return textField;
    }

    protected JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add to store");
        addButton.addActionListener(event -> addItemToStore());
        panel.add(addButton);
        return panel;
    }

    protected int nextMediaId() {
        int maxId = 0;

        for (Lab04.AimsProject.SourceCode.Media media : store.getItemsInStore()) {
            if (media.getId() > maxId) {
                maxId = media.getId();
            }
        }

        return maxId + 1;
    }

    protected float readCost() {
        return Float.parseFloat(tfCost.getText().trim());
    }

    protected int readInteger(JTextField textField) {
        return Integer.parseInt(textField.getText().trim());
    }

    protected void returnToStore() {
        new StoreScreen(store, cart);
        dispose();
    }

    protected void showInputError(Exception exception) {
        JOptionPane.showMessageDialog(
                this,
                "Invalid input: " + exception.getMessage(),
                "Input error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    private void switchScreen(JFrame nextScreen) {
        nextScreen.setVisible(true);
        dispose();
    }

    protected abstract void addSpecificFields(JPanel form);

    protected abstract void addItemToStore();
}
