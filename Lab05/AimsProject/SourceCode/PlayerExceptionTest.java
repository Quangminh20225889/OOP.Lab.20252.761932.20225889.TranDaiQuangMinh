package Lab05.AimsProject.SourceCode;

import Lab05.AimsProject.SourceCode.Exception.PlayerException;

public class PlayerExceptionTest {

    public static void main(String[] args) {
        DigitalVideoDisc invalidDvd = new DigitalVideoDisc(
                "Invalid DVD",
                "Test",
                "Nobody",
                0,
                10.0f
        );

        try {
            invalidDvd.play();
        } catch (PlayerException exception) {
            System.out.println(exception.getMessage());
        }

        Track invalidTrack = new Track("Invalid Track", 0);

        try {
            invalidTrack.play();
        } catch (PlayerException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
