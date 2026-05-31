package Lab05.AimsProject.SourceCode.UI;

import javax.swing.SwingUtilities;

import Lab05.AimsProject.SourceCode.Book;
import Lab05.AimsProject.SourceCode.Cart;
import Lab05.AimsProject.SourceCode.CompactDisc;
import Lab05.AimsProject.SourceCode.DigitalVideoDisc;
import Lab05.AimsProject.SourceCode.Store;
import Lab05.AimsProject.SourceCode.Track;

public class AimsGUI {

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new Book(1, "Java Programming", "Education", 20.5f));
        store.addMedia(new DigitalVideoDisc(
                "Naruto Movie",
                "Anime",
                "Minh",
                120,
                15.5f
        ));

        CompactDisc cd = new CompactDisc(
                2,
                "One Piece Music",
                "Anime",
                30.0f,
                "Oda",
                0,
                "Luffy"
        );
        cd.addTrack(new Track("Track 1", 50));
        cd.addTrack(new Track("Track 2", 60));
        store.addMedia(cd);

        SwingUtilities.invokeLater(() -> new StoreScreen(store, cart));
    }
}
