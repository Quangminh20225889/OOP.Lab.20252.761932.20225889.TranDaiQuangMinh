package Lab05.AimsProject.SourceCode;

import java.util.ArrayList;

public class PolymorphismTest {

    public static void main(String[] args) {

        ArrayList<Media> mediaList = new ArrayList<Media>();

        Book book = new Book(
                1,
                "Java Programming",
                "Education",
                20.5f
        );

        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Naruto Movie",
                "Anime",
                "Minh",
                120,
                15.5f
        );

        CompactDisc cd = new CompactDisc(
                2,
                "One Piece Music",
                "Anime",
                30.0f,
                "Oda",
                0,
                "Luffy"
        );

        mediaList.add(book);
        mediaList.add(dvd);
        mediaList.add(cd);

        for (Media media : mediaList) {
            System.out.println(media.toString());
        }
    }
}