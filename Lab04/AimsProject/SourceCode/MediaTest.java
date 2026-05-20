package Lab04.AimsProject.SourceCode;

public class MediaTest {

    public static void main(String[] args) {

        Book book = new Book(
                1,
                "Java OOP",
                "Programming",
                20.5f
        );

        System.out.println(book.getTitle());

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Naruto",
                "Anime",
                "Minh",
                120,
                15.5f
        );

        System.out.println(dvd);

    }
}