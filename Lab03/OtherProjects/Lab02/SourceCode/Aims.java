
package Lab03.OtherProjects.Lab02.SourceCode;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        );

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        );

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin",
                "Animation",
                18.99f
        );

        DigitalVideoDisc dvd4 = new DigitalVideoDisc(
                "Frozen",
                "Animation",
                "Chris Buck",
                102,
                21.50f
        );

        DigitalVideoDisc dvd5 = new DigitalVideoDisc(
                "Inception",
                "Sci-Fi",
                "Christopher Nolan",
                148,
                30.00f
        );

        // Test add 1 DVD
        anOrder.addDigitalVideoDisc(dvd1);

        // Test add 2 DVDs
        anOrder.addDigitalVideoDisc(dvd2, dvd3);

        // Test add array of DVDs
        DigitalVideoDisc[] dvdList = {dvd4, dvd5};
        anOrder.addDigitalVideoDisc(dvdList);

        System.out.println("Total cost is: " + anOrder.totalCost());
        
    }
}