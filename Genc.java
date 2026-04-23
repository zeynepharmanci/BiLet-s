package BiLets;

// Genç Bilet Alt Sınıfı
class Genc extends Ticket {
   

    public Genc(String biletKodu, Event etkinlik, Person musteri, String koltukNo) {
        super(biletKodu, etkinlik, musteri, koltukNo);
    }
    
    @Override
    public void biletFiyatiHesapla() {
        // Etkinliğin taban fiyatı üzerinden indirim uygular
        this.odenenFiyat = super.getEtkinlik().getPrice() * 0.9;
    }
}