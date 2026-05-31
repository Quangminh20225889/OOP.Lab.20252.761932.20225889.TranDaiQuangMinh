package Lab05.AimsProject.SourceCode;

public class CompactDiscTest {

    public static void main(String[] args) {

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

        System.out.println("CD Length: " + cd.getLength());
    }
}
