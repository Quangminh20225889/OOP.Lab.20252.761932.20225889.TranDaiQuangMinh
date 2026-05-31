package Lab04.AimsProject.SourceCode;

import Lab04.AimsProject.SourceCode.Exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    private static int nbDigitalVideoDiscs = 0;

    // Constructor
    public DigitalVideoDisc(String title) {
        super(
                ++nbDigitalVideoDiscs,
                title,
                "",
                0,
                "",
                0
        );
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                cost,
                "",
                0
        );
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                cost,
                director,
                0
        );
    }

    public DigitalVideoDisc(
            String title,
            String category,
            String director,
            int length,
            float cost
    ) {
        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                cost,
                director,
                length
        );
    }

    // Getter
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public boolean isMatch(String title) {

        if (title == null) {
            return false;
        }

        return this.getTitle() != null &&
                this.getTitle().equalsIgnoreCase(title.trim());
    }

    @Override
    public void play() throws PlayerException {

        if (this.getLength() > 0) {

            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());

        } else {

            System.err.println("ERROR: DVD length is non-positive");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public String toString() {

        return "DVD - " +
                getTitle() + " - " +
                getCategory() + " - " +
                getDirector() + " - " +
                getLength() + ": " +
                getCost() + " $";
    }
}
