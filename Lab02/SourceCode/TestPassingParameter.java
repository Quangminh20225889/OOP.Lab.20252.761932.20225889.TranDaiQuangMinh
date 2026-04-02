package Lab02.SourceCode;

public class TestPassingParameter {
    public static void main(String[] args) {
        
        // Test các constructor khác nhau của DigitalVideoDisc
        
        // Constructor 1: chỉ title
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        System.out.println("DVD 1: " + dvd1.getTitle());
        
        // Constructor 2: title, category, cost
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f);
        System.out.println("DVD 2: " + dvd2.getTitle() + " - " + dvd2.getCategory());
        
        // Constructor 3: title, category, director, cost
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "John Musker", 18.99f);
        System.out.println("DVD 3: " + dvd3.getTitle() + " - " + dvd3.getDirector());
        
        // Constructor 4: tất cả thuộc tính
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 29.99f);
        System.out.println("DVD 4: " + dvd4.getTitle() + " - " + dvd4.getLength() + " mins");
    }
}
