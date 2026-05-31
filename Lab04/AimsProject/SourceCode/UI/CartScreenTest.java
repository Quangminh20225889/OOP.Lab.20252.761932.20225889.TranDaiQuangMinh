package Lab04.AimsProject.SourceCode.UI;

import javax.swing.SwingUtilities;

import Lab04.AimsProject.SourceCode.Book;
import Lab04.AimsProject.SourceCode.Cart;
import Lab04.AimsProject.SourceCode.CompactDisc;
import Lab04.AimsProject.SourceCode.DigitalVideoDisc;
import Lab04.AimsProject.SourceCode.Track;

public class CartScreenTest {

    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addMedia(new Book(1, "Java Programming", "Education", 20.5f));
        cart.addMedia(new DigitalVideoDisc(
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
        cart.addMedia(cd);

        SwingUtilities.invokeLater(() -> new CartScreen(cart));
    }
}
