package Lab03.AimsProject.SourceCode;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;

    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("The disc is null. Cannot add.");
            return;
        }

        if (qtyInStore >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full. Cannot add more DVDs.");
            return;
        }

        itemsInStore[qtyInStore] = dvd;
        qtyInStore++;
        System.out.println("The disc has been added to the store: " + dvd.getTitle());
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("The disc is null. Cannot remove.");
            return;
        }

        int removeIndex = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex == -1) {
            System.out.println("The disc was not found in store.");
            return;
        }

        for (int i = removeIndex; i < qtyInStore - 1; i++) {
            itemsInStore[i] = itemsInStore[i + 1];
        }

        itemsInStore[qtyInStore - 1] = null;
        qtyInStore--;
        System.out.println("The disc has been removed from the store: " + dvd.getTitle());
    }
}