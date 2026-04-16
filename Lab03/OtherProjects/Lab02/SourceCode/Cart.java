package Lab03.OtherProjects.Lab02.SourceCode;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            System.out.println("The disc is null. Cannot add.");
            return;
        }

        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more DVDs.");
            return;
        }

        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added: " + disc.getTitle());
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (dvdList == null) {
            System.out.println("The DVD list is null. Cannot add.");
            return;
        }

        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (disc == null) {
            System.out.println("The disc is null. Cannot remove.");
            return;
        }

        int removeIndex = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                removeIndex = i;
                break;
            }
        }

        if (removeIndex == -1) {
            System.out.println("The disc was not found.");
            return;
        }

        for (int i = removeIndex; i < qtyOrdered - 1; i++) {
            itemsOrdered[i] = itemsOrdered[i + 1];
        }

        itemsOrdered[qtyOrdered - 1] = null;
        qtyOrdered--;
        System.out.println("The disc has been removed: " + disc.getTitle());
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}