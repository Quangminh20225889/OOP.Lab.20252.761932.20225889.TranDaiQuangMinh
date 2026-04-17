package Lab03.OtherProjects.Lab02.SourceCode;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public String getTitle() {
    return title;
     }

    public String getCategory() {
    return category;
     }   

    public String getDirector() {
    return director;
     }

    public int getLength() {
    return length;
     }

    public float getCost() {
    return cost;
     }

    // 1. Tạo DVD chỉ bằng title
    public DigitalVideoDisc(String title) {
    this.title = title;
     }

// 2. Tạo DVD bằng title, category, cost
    public DigitalVideoDisc(String title, String category, float cost) {
    this.title = title;
    this.category = category;
    this.cost = cost;
     }

// 3. Tạo DVD bằng title, category, director, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
    this.title = title;
    this.category = category;
    this.director = director;
    this.cost = cost;
     }

// 4. Tạo DVD bằng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    this.title = title;
    this.category = category;
    this.director = director;
    this.length = length;
    this.cost = cost;
     } 
}
