package Lab04.AimsProject.SourceCode;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {

    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {

        setId(id);
        setTitle(title);
        setCategory(category);
        setCost(cost);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    // Setter
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Media id must be non-negative.");
        }

        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Media title must not be empty.");
        }

        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category == null ? "" : category;
    }

    public void setCost(float cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Media cost must be non-negative.");
        }

        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Media)) {
            return false;
        }

        Media other = (Media) obj;

        return title != null
                && other.title != null
                && title.equalsIgnoreCase(other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title == null ? null : title.toLowerCase());
    }
}
