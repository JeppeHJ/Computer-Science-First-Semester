package model.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight1 = new Flight("AY025", "Seoul");
        flight1.createPassenger("Arnold", 31);
        flight1.createPassenger("Bruce", 59);
        flight1.createPassenger("Dolph", 24);
        flight1.createPassenger("Linda", 59);
        flight1.createPassenger("Jennifer", 65);
        flight1.setDepartDate(LocalDateTime.of(2022,10,25,11,30));
        flight1.setArrivalDate(LocalDateTime.of(2022, 10, 24, 12, 40));
        System.out.println(flight1.flightDurationInHours());
        flight1.flightDurationInHours();




    }

}
