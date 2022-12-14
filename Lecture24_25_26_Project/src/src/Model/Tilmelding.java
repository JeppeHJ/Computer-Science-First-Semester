package src.Model;


public class Tilmelding {
    private String navn;
    private String addresse;
    private String telefonnummer;
    private String email;
    private boolean firma;
    private boolean foredragsholder;
    private Hotel hotel;
    private Ledsager ledsager;

    private Konference konference;

    private Service service;

    public Tilmelding(String navn, String addresse, String telefonnummer, String email, boolean firma, boolean foredragsholder, Hotel hotel, Ledsager ledsager, Service service, Konference konference) {
        this.navn = navn;
        this.addresse = addresse;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.firma = firma;
        this.foredragsholder = foredragsholder;
        this.hotel = hotel;
        this.ledsager = ledsager;
        this.service = service;
        this.konference = konference;
        this.addKonference();
        //this.addHotel();
    }

    public String getNavn() {
        return navn;
    }

    public String getAddresse() {
        return addresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public Konference getKonference() {
        return this.konference;
    }

    public void addService(Service service) {
        this.service = service;
    }

    public String getEmail() {
        return email;
    }

    public boolean isFirma() {
        return firma;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public void addKonference() {
        this.konference.addTilmelding(this);
    }

    public void addHotel() {
        this.hotel.addHotelTilmelding(this);
    }
    public void addHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public double getSamletPris() {
        double hotelPris = 0;
        double servicePris = 0;
        double ledsagerPris = 0;

        if (!(this.ledsager == null)) {
            ledsagerPris = this.ledsager.getPris();

        }

        if (!(this.service == null)) {
            servicePris = this.service.getPris();
        }

        if (!(foredragsholder)) {
            return hotelPris + this.konference.getPris() + ledsagerPris + servicePris;
        } else {
            return hotelPris + ledsagerPris + servicePris;
        }
    }

    @Override
    public String toString() {
        return this.navn;
    }
    
  

  
}

