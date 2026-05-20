package Lab04.AimsProject.SourceCode;

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

        this.director = director;
        this.length = length;
    }

    // Getter
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}