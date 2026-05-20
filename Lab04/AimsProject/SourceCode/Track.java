package Lab04.AimsProject.SourceCode;

public class Track implements Playable {

    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {

        this.title = title;
        this.length = length;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {

        if (this.length > 0) {

            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);

        } else {

            System.out.println("ERROR: Track length is non-positive");
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Track)) {
            return false;
        }

        Track other = (Track) obj;

        return this.length == other.length
                && this.title.equalsIgnoreCase(other.title);
    }
}