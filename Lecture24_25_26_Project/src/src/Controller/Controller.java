package src.Controller;

import src.Model.*;
import src.Storage.Storage;

import java.util.ArrayList;

public class Controller {

    public static Konference createKonference(String navn, String beskrivelse, String dato, String adresse, double pris) {
        Konference konference = new Konference(navn, beskrivelse, dato, adresse, pris);
        Storage.addKonferencer(konference);
        return konference;
    }

    public static void deleteKonference(Konference konference) {
        Storage.removeKonferencer(konference);
    }

    public static ArrayList<Konference> getKonference() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Tilmelding> getKonferenceTilmeldinger(Konference konference) {
        return Storage.getKonferenceTilmeldinger(konference);
    }


    public static Hotel createHotel(String navn, String adress, double prisNetflix, double prisBad, double prisMad, double prisPrDagEnkelt, double prisPrDagDobbelt) {

        Hotel hotel = new Hotel(navn, adress, prisNetflix, prisBad, prisMad, prisPrDagEnkelt, prisPrDagDobbelt);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }

    public static ArrayList<Hotel> getHotels() {
        return Storage.getHoteller();
    }

    public static ArrayList<Tilmelding> getHotelTilmeldinger(Hotel hotel) {
        return Storage.getHotelTilmeldinger(hotel);
    }

    public static ArrayList<Hotel> getKonferenceHoteller(Konference konference) {
        return Storage.getKonferenceHoteller(konference);
    }
    //------------------------------------------------------------------------------------------------------------------

    public static Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        Storage.addLedsager(ledsager);

        return ledsager;
    }

    public static void deleteLedsager(Ledsager ledsager) {
        Storage.removeLedsager(ledsager);
    }

    public static ArrayList<Ledsager> getLedsagers() {
        return Storage.getLedsagere();
    }


    //-----------------------------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------------------------

    public static Service createService(boolean netflix, boolean bad, boolean mad, Hotel hotel, boolean enkeltVærelse) {
        Service service = new Service(netflix, bad, mad, hotel, enkeltVærelse);

        return service;
    }

//--------------------------------------------------------------------------------------------------------------------

    public static Udflugt createUdflugt(String navn, String beskrivelse, String dato, double pris) {
        Udflugt udflugt = new Udflugt(navn, beskrivelse, dato, pris);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static void deleteUdflugt(Udflugt udflugt) {
        Storage.removeUdflugt(udflugt);
    }

    public static ArrayList<Udflugt> getUdflugter() {
        return Storage.getUdflugter();
    }

    public static ArrayList<Ledsager> getUdflugtTilmeldinger(Udflugt udflugt) {
        return Storage.getUdflugtTilmeldinger(udflugt);
    }

    public static ArrayList<Udflugt> getKonferenceUdflugter(Konference konference) {
        return Storage.getKonferenceUdflugter(konference);
    }

    //--------------------------------------------------------------------------------------------------------------------
    public static ArrayList<Tilmelding> getTilmeldings() {
        return Storage.getTilmeldinger();
    }

    public static Tilmelding createTilmelding(String navn, String addresse, String telefonnummer, String email, boolean firma, boolean foredragsholder, Hotel hotel, Ledsager ledsager, Service service, Konference konference) {

        Tilmelding tilmelding = new Tilmelding(navn, addresse, telefonnummer, email, firma, foredragsholder, hotel, ledsager, service, konference);
        Storage.addTilmedlinger(tilmelding);
        return tilmelding;
    }

    public static void deleteTilmeldinger(Tilmelding tilmelding) {
        Storage.removeTilmedlinger(tilmelding);
    }

    public static String getUdflugtBeskrivelse(Udflugt udflugt) {
        return udflugt.getBeskrivelse();
    }


//---------------------------------------------------------------------------------------------------------------------

    public static void initStorage() {
        Konference k1 = Controller.createKonference("Hav Og Himmel", "Hej", "10-10-2023", "123434534", 1500);
        Konference k2 = Controller.createKonference("konference tester1", "Hej", "10-10-2023", "123434534", 1500);
        Konference k3 = Controller.createKonference("konference tester2", "Hej", "10-10-2023", "123434534", 1500);
        Hotel h1 = Controller.createHotel("Den Hvide Svane", "123", 50, 0, 0, 1050, 1250);
        h1.addKonference(k1);
        Hotel h2 = Controller.createHotel("HotelTester1", "adresse test1", 100, 0, 100, 1150, 1250);
        h2.addKonference(k1);
        Ledsager l1 = Controller.createLedsager("Ledsager tester1");
        Ledsager l2 = Controller.createLedsager("Ledsager tester2");
        Ledsager l3 = Controller.createLedsager("Ledsager tester3");
        Ledsager l4 = Controller.createLedsager("Ledsager tester4");
        Ledsager l5 = Controller.createLedsager("Ledsager tester5");
        Ledsager l6 = Controller.createLedsager("Ledsager tester6");
        Ledsager l7 = Controller.createLedsager("Ledsager tester7");
        Ledsager l8 = Controller.createLedsager("Ledsager tester8");
        Service s1 = Controller.createService(false, false, false, h1, true);
        Udflugt u1 = Controller.createUdflugt("Egeskov", "aeunifs", "12-12-12", 75);
        Udflugt u2 = Controller.createUdflugt("udflugt tester1", "adress test", "12-12-12", 75);
        Udflugt u3 = Controller.createUdflugt("udflugt tester2", "aeunifs", "12-12-12", 75);
        u1.addLedsager(l1);
        u1.addLedsager(l2);
        u1.addLedsager(l3);
        u1.addLedsager(l4);
        u2.addLedsager(l5);
        u2.addLedsager(l6);
        u3.addLedsager(l7);
        u3.addLedsager(l8);
        k1.addUdflugt(u1);
        k1.addUdflugt(u2);
        k1.addUdflugt(u3);
        Tilmelding t1 = Controller.createTilmelding("Niels Petersen", "Hassel haven 27", "234234", "x@test.dk", false, false, h1, null, s1, k1);
        Tilmelding t2 = Controller.createTilmelding("Anders And", "esfes", "234234", "x@test.dk", false, true, h1, null, s1, k2);
        Tilmelding t3 = Controller.createTilmelding("Andersine", "13", "234234", "x@test.dk", false, false, h1, null, s1, k2);
        Tilmelding t4 = Controller.createTilmelding("DeltagerTester 3", "adresse tester3", "Tlf test3", "x@test.dk", false, false, h1, null, s1, k1);
        Tilmelding t5 = Controller.createTilmelding("DeltagerTester 4", "adresse tester4", "Tlf test3", "x@test.dk", false, false, h1, null, s1, k3);
        Tilmelding t6 = Controller.createTilmelding("DeltagerTester 5", "adresse tester5", "Tlf test3", "x@test.dk", false, false, h1, null, s1, k3);
        t1.addHotel(h1);
        t2.addHotel(h2);
        t3.addHotel(h2);
        t2.addHotel(h1);


    }


}

