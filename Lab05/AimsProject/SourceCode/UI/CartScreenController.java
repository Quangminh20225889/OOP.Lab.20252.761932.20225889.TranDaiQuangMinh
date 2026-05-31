package Lab05.AimsProject.SourceCode.UI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.Media;
import Lab05.AimsProject.SourceCode.Playable;
import Lab05.AimsProject.SourceCode.Store;
import Lab05.AimsProject.SourceCode.Exception.PlayerException;
import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;
    private Store store;
    private JFrame frame;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblTotalCost;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    private FilteredList<Media> filteredItems;

    public CartScreenController(Cart cart) {
        this(cart, null, null);
    }

    public CartScreenController(Cart cart, Store store, JFrame frame) {
        this.cart = cart;
        this.store = store;
        this.frame = frame;
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        cart.clearCart();
        updateTotalCost();
        JOptionPane.showMessageDialog(frame, "Order has been created.");
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
                JOptionPane.showMessageDialog(
                        frame,
                        "Playing: " + selectedMedia.getTitle()
                );
            } catch (PlayerException exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(
                        frame,
                        exception.toString(),
                        "Play error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();

        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            updateTotalCost();
        }
    }

    @FXML
    private void menuItemAddBookPressed(ActionEvent event) {
        openAddScreen(() -> new AddBookToStoreScreen(store, cart));
    }

    @FXML
    private void menuItemAddCDPressed(ActionEvent event) {
        openAddScreen(() -> new AddCompactDiscToStoreScreen(store, cart));
    }

    @FXML
    private void menuItemAddDVDPressed(ActionEvent event) {
        openAddScreen(() -> new AddDigitalVideoDiscToStoreScreen(store, cart));
    }

    @FXML
    private void menuItemViewStorePressed(ActionEvent event) {
        if (store != null) {
            Platform.runLater(() -> SwingUtilities.invokeLater(() -> {
                new StoreScreen(store, cart);

                if (frame != null) {
                    frame.dispose();
                }
            }));
        }
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );

        filteredItems = new FilteredList<Media>(cart.getItemsOrdered());
        tblMedia.setItems(filteredItems);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> updateButtonBar(newValue)
        );

        tfFilter.textProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia()
        );
        radioBtnFilterId.selectedProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia()
        );
        radioBtnFilterTitle.selectedProperty().addListener(
                (observable, oldValue, newValue) -> showFilteredMedia()
        );

        showFilteredMedia();
        updateTotalCost();

        cart.getItemsOrdered().addListener(
                (javafx.collections.ListChangeListener<Media>) change -> updateTotalCost()
        );
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(media != null);
        btnPlay.setVisible(media instanceof Playable);
    }

    private void showFilteredMedia() {
        String filter = tfFilter.getText();

        if (filter == null || filter.trim().isEmpty()) {
            filteredItems.setPredicate(media -> true);
            return;
        }

        String normalizedFilter = filter.trim().toLowerCase();

        filteredItems.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(normalizedFilter);
            }

            return media.getTitle() != null
                    && media.getTitle().toLowerCase().contains(normalizedFilter);
        });
    }

    private void updateTotalCost() {
        lblTotalCost.setText(cart.totalCost() + " $");
    }

    private void openAddScreen(Runnable openScreen) {
        if (store != null) {
            Platform.runLater(() -> SwingUtilities.invokeLater(() -> {
                openScreen.run();

                if (frame != null) {
                    frame.dispose();
                }
            }));
        }
    }
}
