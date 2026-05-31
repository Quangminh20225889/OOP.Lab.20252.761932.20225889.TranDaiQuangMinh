package Lab04.AimsProject.SourceCode.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Lab04.AimsProject.SourceCode.Cart;
import Lab04.AimsProject.SourceCode.Media;
import Lab04.AimsProject.SourceCode.Store;

public class StoreScreen extends JFrame {

    private Store store;
    private Cart cart;

    public StoreScreen(Store store) {
        this(store, new Cart());
    }

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        JPanel container = new JPanel(new BorderLayout());
        container.add(createNorth(), BorderLayout.NORTH);
        container.add(createCenter(), BorderLayout.CENTER);
        setContentPane(container);

        setTitle("AIMS Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu updateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(event -> {
            new AddBookToStoreScreen(store, cart);
            dispose();
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(event -> {
            new AddCompactDiscToStoreScreen(store, cart);
            dispose();
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(event -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            dispose();
        });

        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View Store");
        viewStore.addActionListener(event -> {
            new StoreScreen(store, cart);
            dispose();
        });

        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(event -> {
            new CartScreen(cart, store);
            dispose();
        });

        menu.add(updateStore);
        menu.add(viewStore);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
        menuBar.add(menu);

        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(3, 3, 2, 2));

        for (Media media : store.getItemsInStore()) {
            center.add(new MediaStore(media, cart));
        }

        return center;
    }
}
