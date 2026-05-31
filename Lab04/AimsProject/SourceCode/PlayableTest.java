package Lab04.AimsProject.SourceCode;

import Lab04.AimsProject.SourceCode.Exception.PlayerException;

public class PlayableTest {

    public static void main(String[] args) throws PlayerException {

        Track track1 = new Track("Track 1", 50);
        Track track2 = new Track("Track 2", 60);

        CompactDisc cd = new CompactDisc(
                1,
                "One Piece Music",
                "Anime",
                20.5f,
                "Oda",
                0,
                "Luffy"
        );

        cd.addTrack(track1);
        cd.addTrack(track2);

        cd.play();

        System.out.println();

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Naruto Movie",
                "Anime",
                "Minh",
                120,
                15.5f
        );

        dvd.play();
    }
}
