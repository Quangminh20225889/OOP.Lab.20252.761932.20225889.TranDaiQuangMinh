package Lab05.AimsProject.SourceCode;

public class CartTest {

    public static void main(String[] args) {

        Cart cart = new Cart();

        // Create book
        Book book = new Book(
                1,
                "Java Programming",
                "Education",
                20.5f
        );

        // Create DVD
        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Naruto Movie",
                "Anime",
                "Minh",
                120,
                15.5f
        );

        // Create CD
        CompactDisc cd = new CompactDisc(
                2,
                "One Piece Music",
                "Anime",
                30.0f,
                "Oda",
                0,
                "Luffy"
        );

        // Add media to cart
        cart.addMedia(book);
        cart.addMedia(dvd);
        cart.addMedia(cd);

        System.out.println();

        // Print cart
        cart.print();

        System.out.println();

        // Search by title
        cart.searchByTitle("Naruto Movie");

        System.out.println();

        // Search by id
        cart.searchById(1);

        System.out.println();

        // Remove media
        cart.removeMedia(dvd);

        System.out.println();

        // Print again
        cart.print();
    }
}