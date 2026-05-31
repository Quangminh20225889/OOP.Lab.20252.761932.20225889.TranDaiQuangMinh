package Lab05.AimsProject.SourceCode;

import java.util.Scanner;

import Lab05.AimsProject.SourceCode.Exception.PlayerException;

public class Aims {

    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {

        initStore();

        int choice;

        do {
            showMenu();
            choice = readInt();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void initStore() {
        store.addMedia(new Book(1, "Java Programming", "Education", 20.5f));
        store.addMedia(new DigitalVideoDisc("Naruto Movie", "Anime", "Minh", 120, 15.5f));

        CompactDisc cd = new CompactDisc(2, "One Piece Music", "Anime", 30.0f, "Oda", 0, "Luffy");
        cd.addTrack(new Track("Track 1", 50));
        cd.addTrack(new Track("Track 2", 60));

        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void viewStore() {
        int choice;

        do {
            store.printStore();
            storeMenu();

            choice = readInt();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaInStore();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        System.out.println(media);

        mediaDetailsMenu();

        int choice = readInt();

        switch (choice) {
            case 1:
                cart.addMedia(media);
                break;
            case 2:
                playMedia(media);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        cart.addMedia(media);
    }

    public static void playMediaInStore() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        if (media == null) {
            System.out.println("Media not found.");
            return;
        }

        playMedia(media);
    }

    public static void playMedia(Media media) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException exception) {
                System.err.println("PlayerException message: " + exception.getMessage());
                System.err.println("PlayerException toString: " + exception.toString());
                exception.printStackTrace();
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    public static void updateStore() {
        System.out.println("1. Add DVD");
        System.out.println("2. Remove media");
        System.out.print("Choose: ");

        int choice = readInt();

        if (choice == 1) {
            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Category: ");
            String category = scanner.nextLine();

            System.out.print("Director: ");
            String director = scanner.nextLine();

            System.out.print("Length: ");
            int length = readInt();

            System.out.print("Cost: ");
            float cost = readFloat();

            try {
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
            } catch (IllegalArgumentException exception) {
                System.out.println("Cannot add media: " + exception.getMessage());
            }

        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();

            Media media = store.searchByTitle(title);

            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    public static void seeCurrentCart() {
        int choice;

        do {
            cart.print();
            cartMenu();

            choice = readInt();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void filterCart() {
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.print("Choose: ");

        int choice = readInt();

        if (choice == 1) {
            System.out.print("Enter id: ");
            int id = readInt();
            cart.searchById(id);
        } else if (choice == 2) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    public static void sortCart() {
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.print("Choose: ");

        int choice = readInt();

        if (choice == 1) {
            cart.sortByTitleCost();
            cart.print();
        } else if (choice == 2) {
            cart.sortByCostTitle();
            cart.print();
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = cart.searchMediaByTitle(title);

        if (media != null) {
            cart.removeMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void playMediaInCart() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();

        Media media = cart.searchMediaByTitle(title);

        if (media != null) {
            playMedia(media);
        } else {
            System.out.println("Media not found in cart.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order has been created.");
        cart.clearCart();
    }

    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.print("Invalid integer. Please enter again: ");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }
}
