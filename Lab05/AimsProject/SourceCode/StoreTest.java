package Lab05.AimsProject.SourceCode;

public class StoreTest {

    public static void main(String[] args) {

        Store store = new Store();

        Book book =
                new Book(
                        1,
                        "Java",
                        "Education",
                        20
                );

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        "Naruto",
                        "Anime",
                        "Minh",
                        120,
                        15
                );

        CompactDisc cd =
                new CompactDisc(
                        2,
                        "One Piece",
                        "Anime",
                        30,
                        "Oda",
                        0,
                        "Luffy"
                );

        store.addMedia(book);
        store.addMedia(dvd);
        store.addMedia(cd);

        System.out.println();

        store.printStore();

        System.out.println();

        store.removeMedia(book);

        System.out.println();

        store.printStore();
    }
}