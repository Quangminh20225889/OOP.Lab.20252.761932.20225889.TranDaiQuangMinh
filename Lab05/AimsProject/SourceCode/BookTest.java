package Lab05.AimsProject.SourceCode;

public class BookTest {
    public static void main(String[] args) {

        Book book1 = new Book(1, "Java OOP", "Programming", 19.99f);

        book1.addAuthor("Minh");
        book1.addAuthor("An");
        book1.addAuthor("Minh");

        book1.showAuthors();

        book1.removeAuthor("An");
        book1.removeAuthor("Dat");

        book1.showAuthors();
    }
}
