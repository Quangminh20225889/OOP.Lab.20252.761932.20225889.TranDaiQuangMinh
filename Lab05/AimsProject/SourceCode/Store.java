package Lab05.AimsProject.SourceCode;

import java.util.ArrayList;

public class Store {

    public static final int MAX_ITEMS_IN_STORE = 100;

    private ArrayList<Media> itemsInStore =
            new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Add media
    public void addMedia(Media media) {

        if (media == null) {

            System.out.println("The media is null. Cannot add.");
            return;
        }

        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {

            System.out.println("The store is full. Cannot add more media.");
            return;
        }

        itemsInStore.add(media);

        System.out.println(
                "The media has been added to the store: "
                        + media.getTitle()
        );
    }

    // Remove media
    public void removeMedia(Media media) {

        if (media == null) {

            System.out.println("The media is null. Cannot remove.");
            return;
        }

        if (itemsInStore.remove(media)) {

            System.out.println(
                    "The media has been removed from the store: "
                            + media.getTitle()
            );

        } else {

            System.out.println(
                    "The media was not found in store."
            );
        }
    }

    // Print store
    public void printStore() {

        System.out.println(
                "****************STORE****************"
        );

        int i = 1;

        for (Media media : itemsInStore) {

            System.out.println(
                    i + ". " + media
            );

            i++;
        }

        System.out.println(
                "*************************************"
        );
    }

    // Search media
    public Media searchByTitle(String title) {

        if (title == null) {
            return null;
        }

        for (Media media : itemsInStore) {

            if (media.getTitle()
                    .equalsIgnoreCase(title.trim())) {

                return media;
            }
        }

        return null;
    }
}
