package Lab05.AimsProject.SourceCode;

public class SortTest {

    public static void main(String[] args) {

        Cart cart = new Cart();

        Book book1 =
                new Book(
                        1,
                        "Java",
                        "Education",
                        20.5f
                );

        Book book2 =
                new Book(
                        2,
                        "AI",
                        "Education",
                        50.0f
                );

        Book book3 =
                new Book(
                        3,
                        "Java",
                        "Education",
                        30.0f
                );

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        "Naruto",
                        "Anime",
                        "Minh",
                        120,
                        15.5f
                );

        cart.addMedia(book1);
        cart.addMedia(book2);
        cart.addMedia(book3);
        cart.addMedia(dvd);

        System.out.println("\nBefore Sort:");
        cart.print();

        System.out.println("\nSort By Title Cost:");
        cart.sortByTitleCost();
        cart.print();

        System.out.println("\nSort By Cost Title:");
        cart.sortByCostTitle();
        cart.print();
    }
}