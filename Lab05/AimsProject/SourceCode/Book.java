package Lab05.AimsProject.SourceCode;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name must not be empty.");
        }

        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " has been added.");
        } else {
            System.out.println(authorName + " already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.trim().isEmpty()) {
            throw new IllegalArgumentException("Author name must not be empty.");
        }

        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " has been removed.");
        } else {
            System.out.println(authorName + " does not exist.");
        }
    }

    public void showAuthors() {
        System.out.println("Authors:");
        for (String author : authors) {
            System.out.println("- " + author);
        }
    }

    @Override
    public String toString() {
        return "Book - " +
                getTitle() + " - " +
                getCategory() + " - " +
                authors + " - " +
                getCost() + " $";
    }
}
