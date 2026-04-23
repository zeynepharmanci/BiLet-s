package BiLets;

public abstract class Event {
    private String eventname;
    private String city;
    private double price;
    private boolean[][] seats;
    
    public Event(String eventname, String city,double price,boolean[][] seats){
        this.eventname=eventname;
        this.city=city;
        this.price=price;
        this.seats=seats;
    }
    
        public String etkinlikDetayGoster(){
        String detay = "Etkinlik Adı: " +this.eventname + "\n" +
                "Şehir: " +this.city + "\n" +
                "Taban Fiyat: " + this.price + "TL";
        return detay;
    }
    public String koltukDuzeniGoruntule(){
        String harita = "---Koltuk Düzeni---\n";
        for(int i=0; i<seats.length; i++){
            for(int j=0; j<seats[i].length; j++){
                if(seats[i][j] == true){
                    harita += "[Dolu]";
                } else {
                    harita += "[Boş]";
                }
            }
            harita += "\n";
        }
        return harita;
    }
   
    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        ExceptionClass.kontrolEtEtkinlikAdi(eventname);
        this.eventname = eventname.trim();
        
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        ExceptionClass.kontrolEtSehir(city);
        this.city = city.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
       ExceptionClass.kontrolEtFiyat(price);
        this.price = price;
    }

    public boolean[][] getSeats() {
        return seats;
    }

    public void setSeats(boolean[][] seats) {
       ExceptionClass.kontrolEtKoltuklar(seats);
        this.seats = seats;
    }
    public double fiyatHesapla(){
        return getPrice();
    }
}
