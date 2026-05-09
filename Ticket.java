/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

import java.time.LocalDateTime;

public abstract class Ticket {
    private String biletKodu;
    private Event etkinlik;
    private Person musteri;
    private String koltukNo;
    protected double odenenFiyat; 
    private boolean isRefunded;
    private LocalDateTime satinAlmaTarihi;

    public Ticket(String biletKodu, Event etkinlik, Person musteri, String koltukNo) {
        ExceptionClass.kontrolEtGenelMetin(biletKodu, "Bilet Kodu");
        ExceptionClass.kontrolEtNesne(etkinlik, "Etkinlik");
        ExceptionClass.kontrolEtNesne(musteri, "Müşteri");
        ExceptionClass.kontrolEtGenelMetin(koltukNo, "Koltuk No");

        this.biletKodu = biletKodu.trim();
        this.etkinlik = etkinlik;
        this.musteri = musteri;
        this.koltukNo = koltukNo.trim();

        this.isRefunded = false;
        this.satinAlmaTarihi = LocalDateTime.now();
    }

    public abstract void biletFiyatiHesapla();

    public void biletBilgisiGoster() {
        System.out.println("--- Bilet Detayı ---");
        System.out.println("Kod: " + biletKodu);
        System.out.println("Etkinlik: " + etkinlik.getEventname());
        System.out.println("Müşteri: " + musteri.getName() + " " + musteri.getSurname());
        System.out.println("Koltuk: " + koltukNo);
        System.out.println("Ödenen Tutar: " + odenenFiyat + " TL");
        System.out.println("Tarih: " + satinAlmaTarihi);
        System.out.println("--------------------");
    }

    public double getOdenenFiyat() { return odenenFiyat; }
    public void setRefunded(boolean refunded) { isRefunded = refunded; }

    
    public String getBiletKodu(){
      return biletKodu;
    }
    public Event getEtkinlik() {
        return etkinlik;
    }
    public Person getMusteri(){
      return musteri;
    }
    public String getKoltukNo(){
      return koltukNo;
    }
    public double getOdenenFiyat1() {
      return odenenFiyat;
    }
    public boolean isRefunded(){
      return isRefunded;
    }
    public void setRefunded1(boolean refunded) { 
      isRefunded = refunded;
    }
    public LocalDateTime getSatinAlmaTarihi(){
      return satinAlmaTarihi;
    }

    
   
}
