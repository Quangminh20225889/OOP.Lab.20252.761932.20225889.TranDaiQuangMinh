package Lab05.AimsProject.SourceCode.UI;

import javax.swing.JPanel;

import Lab05.AimsProject.SourceCode.Book;
import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book");
    }

    @Override
    protected void addSpecificFields(JPanel form) {
    }

    @Override
    protected void addItemToStore() {
        try {
            store.addMedia(new Book(
                    nextMediaId(),
                    tfTitle.getText().trim(),
                    tfCategory.getText().trim(),
                    readCost()
            ));
            returnToStore();
        } catch (IllegalArgumentException exception) {
            showInputError(exception);
        }
    }
}
