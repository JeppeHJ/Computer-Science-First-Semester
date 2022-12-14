package src.Model;

import src.Controller.Controller;
import src.Storage.Storage;
import src.Controller.*;

import java.time.LocalDateTime;

public class TestApp {
    public static void main(String[] args) {

        Konference k1 = new Konference("HavOgHimmel", "Hej", "12-12-12", "123434534", 1500);

        Hotel h1 = new Hotel("Den Hvide Svane", "123", 50, 0, 0, 1050, 1250);
        Hotel h2 = new Hotel("Hotel Føniks", "1234", 75, 200, 0, 700, 800);
        Hotel h3 = new Hotel("Pension Tusindfryd", "12345", 0, 0, 100, 500, 600);

        Udflugt u1 = new Udflugt("By rund tur Odense", "HejHej", "12-12-12", 125);
        Udflugt u2 = new Udflugt("Egeskov", "aeunifs", "12-12-12", 75);
        Udflugt u3 = new Udflugt("Trapholt Museum", "iunergnuisdg", "12-12-12", 200);

        Service s1 = new Service(false, false, false, h1, false);
        Service s2 = new Service(false, false, false, h1, true);
        Service s3 = new Service(true, false, false, h1, false);
        Service s4 = new Service(true, false, false, h1, false);

        Ledsager l3 = new Ledsager("Mie Sommer");
        l3.addUdflugter(u2);
        l3.addUdflugter(u3);

        Ledsager l4 = new Ledsager("Bitch Dinmor");
        l4.addUdflugter(u1);
        l4.addUdflugter(u2);

        Tilmelding t1 = new Tilmelding("Finn Madsen", "HejHus", "2424242424", "sdsdd", false, false, null,null, null,k1);
        Tilmelding t2 = new Tilmelding("Niels Petersen","esfes","234234","@hej",false,false, h1, null, s2, k1);
        Tilmelding t3 = new Tilmelding("Peter Sommer", "fesf", "43523453", "@grdg", false, false, h1, l3, s3, k1);
        Tilmelding t4 = new Tilmelding("Lone Jensen", "fesf", "efsfsdfse", "23423", false, true, h1, l4, s4, k1);

        System.out.println(t1.getSamletPris());
        System.out.println(t2.getSamletPris());
        System.out.println(t3.getSamletPris());
        System.out.println(t4.getSamletPris());
        Controller.initStorage();

        System.out.println(Storage.getTilmeldinger().get(0).getSamletPris());

    }

}
