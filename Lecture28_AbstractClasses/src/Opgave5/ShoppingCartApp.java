package Opgave5;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Alcohol a1 = new Alcohol(150,"Morgans","Shitty alcohol",25);
        Alcohol a2 = new Alcohol(30,"Breezer","Shitty alcohol",12);

        Food f1 = new Food(50,"Brød","Tørt",7);
        Food f2 = new Food(25,"Smør","Varmt",7);

        ElArticle e1 = new ElArticle(100,"Lampe","Lys",100);
        ElArticle e2 = new ElArticle(1,"Lille lampe","Lys",100);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(a1);
        shoppingCart.addItem(a2);
        shoppingCart.addItem(f1);
        shoppingCart.addItem(f2);
        shoppingCart.addItem(e1);
        shoppingCart.addItem(e2);

        System.out.println(shoppingCart.printReceipt());
    }
}
