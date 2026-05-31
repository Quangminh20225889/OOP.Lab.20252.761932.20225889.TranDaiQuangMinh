package Lab05.AimsProject.SourceCode;

import Lab05.AimsProject.SourceCode.Exception.PlayerException;

public class Track implements Playable {

    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {

        setTitle(title);
        setLength(length);
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Track title must not be empty.");
        }

        this.title = title;
    }

    public void setLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Track length must be non-negative.");
        }

        this.length = length;
    }

    @Override
    public void play() throws PlayerException {

        if (this.length > 0) {

            System.out.println("Playing track: " + this.title);
            System.out.println("Track length: " + this.length);

        } else {

            System.err.println("ERROR: Track length is non-positive");
            throw new PlayerException("ERROR: Track length is non-positive!");
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
                && this.title != null
                && this.title.equalsIgnoreCase(other.title);
    }
}
