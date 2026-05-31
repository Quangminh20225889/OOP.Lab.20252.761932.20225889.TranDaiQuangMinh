package Lab05.AimsProject.SourceCode;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;

    private ObservableList<Media> itemsOrdered =
            FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {

        if (media == null) {

            System.out.println(
                    "The media is null. Cannot add."
            );

            return;
        }

        if (itemsOrdered.size()
                >= MAX_NUMBERS_ORDERED) {

            System.out.println(
                    "The cart is full. Cannot add more media."
            );

            return;
        }

        itemsOrdered.add(media);

        System.out.println(
                "The media has been added: "
                        + media.getTitle()
        );
    }

    public void addMedia(
            Media media1,
            Media media2
    ) {

        addMedia(media1);
        addMedia(media2);
    }

    public void addMedia(Media[] mediaList) {

        if (mediaList == null) {

            System.out.println(
                    "The media list is null."
            );

            return;
        }

        for (Media media : mediaList) {

            addMedia(media);
        }
    }

    public void removeMedia(Media media) {

        if (media == null) {

            System.out.println(
                    "The media is null."
            );

            return;
        }

        if (itemsOrdered.remove(media)) {

            System.out.println(
                    "The media has been removed: "
                            + media.getTitle()
            );

        } else {

            System.out.println(
                    "The media was not found."
            );
        }
    }

    public float totalCost() {

        float sum = 0;

        for (Media media : itemsOrdered) {

            sum += media.getCost();
        }

        return sum;
    }

    public void print() {

        System.out.println(
                "***********************CART***********************"
        );

        System.out.println(
                "Ordered Items:"
        );

        int i = 1;

        for (Media media : itemsOrdered) {

            System.out.println(
                    i + ". " + media
            );

            i++;
        }

        System.out.println(
                "Total cost: "
                        + totalCost()
                        + " $"
        );

        System.out.println(
                "***************************************************"
        );
    }

    public void searchById(int id) {

        for (Media media : itemsOrdered) {

            if (media.getId() == id) {

                System.out.println("Result:");
                System.out.println(media);

                return;
            }
        }

        System.out.println(
                "No media found with id: "
                        + id
        );
    }

    public void searchByTitle(String title) {

        boolean found = false;

        for (Media media : itemsOrdered) {

            if (media.getTitle()
                    .equalsIgnoreCase(
                            title.trim()
                    )) {

                if (!found) {

                    System.out.println(
                            "Result:"
                    );
                }

                System.out.println(media);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No media found with title: "
                            + title
            );
        }
    }

    public void sortByTitleCost() {

        Collections.sort(
                itemsOrdered,
                Media.COMPARE_BY_TITLE_COST
        );
    }

    public void sortByCostTitle() {

        Collections.sort(
                itemsOrdered,
                Media.COMPARE_BY_COST_TITLE
        );
    }

    public Media searchMediaByTitle(
            String title
    ) {

        for (Media media : itemsOrdered) {

            if (media.getTitle()
                    .equalsIgnoreCase(
                            title.trim()
                    )) {

                return media;
            }
        }

        return null;
    }

    public void clearCart() {

        itemsOrdered.clear();
    }
}
