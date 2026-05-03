package BiLets;
  import java.time.LocalDateTime;

// Ana Bilet Sınıfı (Abstract)
public abstract class Ticket {
    private String biletKodu;
    private Event etkinlik;
    private Person musteri;
    private String koltukNo;
    protected double odenenFiyat; // Alt sınıflardan erişilebilmesi için protected
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
    public double getOdenenFiyat() {
      return odenenFiyat;
    }
    public boolean isRefunded(){
      return isRefunded;
    }
    public void setRefunded(boolean refunded) { 
      isRefunded = refunded;
    }
    public LocalDateTime getSatinAlmaTarihi(){
      return satinAlmaTarihi;
    }

    
   
}

    
    

