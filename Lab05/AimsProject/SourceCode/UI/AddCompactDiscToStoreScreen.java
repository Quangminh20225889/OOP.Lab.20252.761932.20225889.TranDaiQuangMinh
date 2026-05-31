package Lab05.AimsProject.SourceCode.UI;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.CompactDisc;
import Lab05.AimsProject.SourceCode.Store;
import Lab05.AimsProject.SourceCode.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextField tfTrackTitle;
    private JTextField tfTrackLength;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD");
    }

    @Override
    protected void addSpecificFields(JPanel form) {
        tfArtist = addTextField(form, "Artist");
        tfDirector = addTextField(form, "Director");
        tfTrackTitle = addTextField(form, "Track title");
        tfTrackLength = addTextField(form, "Track length");
    }

    @Override
    protected void addItemToStore() {
        try {
            CompactDisc cd = new CompactDisc(
                    nextMediaId(),
                    tfTitle.getText().trim(),
                    tfCategory.getText().trim(),
                    readCost(),
                    tfDirector.getText().trim(),
                    0,
                    tfArtist.getText().trim()
            );
            cd.addTrack(new Track(
                    tfTrackTitle.getText().trim(),
                    readInteger(tfTrackLength)
            ));
            store.addMedia(cd);
            returnToStore();
        } catch (IllegalArgumentException exception) {
            showInputError(exception);
        }
    }
}
