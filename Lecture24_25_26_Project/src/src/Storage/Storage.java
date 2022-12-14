package src.Storage;

import src.Model.*;
import src.Model.Hotel;
import src.Model.Ledsager;
import src.Model.Tilmelding;
import src.Model.Udflugt;

import java.util.*;

public class Storage {

    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    private static ArrayList<Ledsager> ledsagere = new ArrayList<>();

    private static ArrayList<Udflugt> udflugter = new ArrayList<>();

    private static ArrayList<Hotel> hoteller = new ArrayList<>();

    private static ArrayList<Konference> konferencer = new ArrayList<>();

    //-------------------------------------------------------------------------------------------------------------------


    public static ArrayList<Konference> getKonferencer() {
        return konferencer;
    }

    public static void addKonferencer(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonferencer(Konference konference) {
        konferencer.remove(konference);
    }

    public static ArrayList<Tilmelding> getKonferenceTilmeldinger(Konference konference) {
        return konference.getTilmeldinger();
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public static void addTilmedlinger(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public static void removeTilmedlinger(Tilmelding tilmelding) {
        tilmeldinger.remove(tilmelding);
    }
    //-------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public static void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    public static void removeLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }
    //-------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public static void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    public static ArrayList<Ledsager> getUdflugtTilmeldinger(Udflugt udflugt) {
        return udflugt.getLedsagere();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }

    public static ArrayList<Tilmelding> getHotelTilmeldinger(Hotel hotel) {
        return hotel.getTilmeldinger();
    }

    public static ArrayList<Hotel> getKonferenceHoteller(Konference konference) {
        return konference.getHoteller();
    }

    public static ArrayList<Udflugt> getKonferenceUdflugter(Konference konference) {
        return konference.getUdflugter();
    }
}
