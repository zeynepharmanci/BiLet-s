/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

import java.io.Serializable;

public abstract class Event implements Serializable{
    private String eventname;
    private String city;
    private double price;
    private boolean[][] seats;
    private String tarih = "Belirtilmedi";
    
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
   
    public String getEventname() {
        return eventname;
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

    public void setEventname(String text) {

        this.eventname = text; 
    }
    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }


}
