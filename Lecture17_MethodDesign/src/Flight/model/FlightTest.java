package Flight.model;

import java.time.LocalDateTime;

public class FlightTest {

    public static void main(String[] args) {
        Flight flight = new Flight("AY025", "Seoul");
        flight.createPassenger("Arnold", 31);
        flight.createPassenger("Bruce", 59);
        flight.createPassenger("Dolph", 24);
        flight.createPassenger("Linda", 59);
        flight.createPassenger("Jennifer", 65);

        flight.setDepartDate(LocalDateTime.of(2022,10,10,21,30));
        flight.setArrivalDate(LocalDateTime.of(2022,10,10,23,30));

        System.out.println(flight.midnightFlight());
        System.out.println(flight.averagePassengerAge());
        System.out.println(flight.flightDurationInHours());




    }

}
