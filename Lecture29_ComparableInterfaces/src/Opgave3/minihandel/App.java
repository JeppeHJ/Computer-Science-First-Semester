package Opgave3.minihandel;

import java.time.LocalDate;

public class App {
    public static void main(String[] args){
        Product p1 = new Product(1,"Banan",3);
        Product p2 = new Product(2,"Æble",1.5);
        Product p3 = new Product(3,"Pære",2);
        Product p4 = new Product(4,"Ananas",0.5);
        Product p5 = new Product(5,"\"Rygmassageapparat\"",599.95);

        Customer c1 = new Customer("Jens Laugaard Pedersen", LocalDate.of(1999,7,22));
        Customer c2 = new Customer("John \"Mr. International\" Laugaard Pedersen", LocalDate.of(1999,7,22));

        //Order 1
        Order o1 = new Order(1);
        o1.createOrderLine(2,p1);
        o1.createOrderLine(1,p5);

        //Order 2
        Order o2 = new Order(2);
        o2.createOrderLine(4,p2);
        o2.createOrderLine(3,p3);

        //Order 3
        Order o3 = new Order(3);
        o3.createOrderLine(20,p4);
        o3.createOrderLine(15,p5);
        o3.createOrderLine(1,p1);

        //Order 4
        Order o4 = new Order(4);
        o4.createOrderLine(1,p1);
        o4.createOrderLine(2,p2);

        c1.addOrder(o1);
        c1.addOrder(o4);
        c2.addOrder(o1);
        c2.addOrder(o2);
        c2.addOrder(o3);
        c2.addOrder(o4);
        //Uden rabat
        System.out.println(c1.totalBuy());
        System.out.println(c2.totalBuy());

        PercentDiscount pd1 = new PercentDiscount(15);
        FixedDiscount fd1 = new FixedDiscount(250,1000);


        c1.setDiscount(pd1);
        c2.setDiscount(fd1);

        System.out.println(c1.totalBuyWithDiscount());
        System.out.println(c2.totalBuyWithDiscount());
    }
}
