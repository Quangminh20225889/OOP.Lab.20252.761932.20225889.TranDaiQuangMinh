package Lab05.AimsProject.SourceCode;

public class Disc extends Media {

    private int length;
    private String director;

    // Constructor
    public Disc(
            int id,
            String title,
            String category,
            float cost,
            String director,
            int length
    ) {
        super(id, title, category, cost);

        setDirector(director);
        setLength(length);
    }

    // Getter
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Disc length must be non-negative.");
        }

        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director == null ? "" : director;
    }
}
