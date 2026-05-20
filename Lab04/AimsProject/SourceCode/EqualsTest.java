package Lab04.AimsProject.SourceCode;

public class EqualsTest {

    public static void main(String[] args) {

        Book book1 = new Book(1, "Java", "Education", 20);
        Book book2 = new Book(2, "Java", "Programming", 30);

        System.out.println(book1.equals(book2));

        Track track1 = new Track("Song A", 100);
        Track track2 = new Track("Song A", 100);
        Track track3 = new Track("Song A", 200);

        System.out.println(track1.equals(track2));
        System.out.println(track1.equals(track3));

        CompactDisc cd = new CompactDisc(
                1,
                "CD Test",
                "Music",
                10,
                "Director",
                0,
                "Artist"
        );

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        System.out.println("CD Length: " + cd.getLength());
    }
}
