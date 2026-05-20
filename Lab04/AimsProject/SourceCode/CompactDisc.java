package Lab04.AimsProject.SourceCode;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(
            int id,
            String title,
            String category,
            float cost,
            String director,
            int length,
            String artist
    ) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added.");
        } else {
            System.out.println("Track already exists.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed.");
        } else {
            System.out.println("Track does not exist.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;

        for (Track track : tracks) {
            totalLength += track.getLength();
        }

        return totalLength;
    }

    @Override
    public void play() {
        if (this.getLength() > 0) {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());

            for (Track track : tracks) {
                track.play();
            }
        } else {
            System.out.println("ERROR: CD length is non-positive");
        }
    }

    @Override
    public String toString() {
        return "CD - " +
                getTitle() + " - " +
                getCategory() + " - " +
                getDirector() + " - " +
                artist + " - " +
                getLength() + ": " +
                getCost() + " $";
    }
}