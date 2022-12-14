package Opgave5;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Vare> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Vare vare) {
        if (!(vare == null)) {
            this.items.add(vare);
        }
    }

    public double getTotalSalesPrice() {
        double sum = 0;
        for (Vare vare: items) {
            sum += vare.calcSalesPrice();
        }
        return sum;
    }

    public StringBuilder printReceipt() {
        StringBuilder receipt = new StringBuilder();
        for (Vare vare: items) {
            receipt.append(vare.toString());

        }

        receipt.append("Total price: ").append(this.getTotalSalesPrice());
        return receipt;
    }

}
