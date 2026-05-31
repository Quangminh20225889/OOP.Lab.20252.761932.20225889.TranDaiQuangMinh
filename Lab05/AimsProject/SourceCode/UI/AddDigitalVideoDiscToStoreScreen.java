package Lab05.AimsProject.SourceCode.UI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.DigitalVideoDisc;
import Lab05.AimsProject.SourceCode.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD");
    }

    @Override
    protected void addSpecificFields(JPanel form) {
        tfDirector = addTextField(form, "Director");
        tfLength = addTextField(form, "Length");
    }

    @Override
    protected void addItemToStore() {
        try {
            store.addMedia(new DigitalVideoDisc(
                    tfTitle.getText().trim(),
                    tfCategory.getText().trim(),
                    tfDirector.getText().trim(),
                    readInteger(tfLength),
                    readCost()
            ));
            returnToStore();
        } catch (IllegalArgumentException exception) {
            showInputError(exception);
        }
    }
}
