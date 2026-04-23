package BiLets;

class Yetiskin extends Ticket {

    public Yetiskin(String biletKodu, Event etkinlik, Person musteri, String koltukNo) {
        super(biletKodu, etkinlik, musteri, koltukNo);
    }

    @Override
    public void biletFiyatiHesapla() {
        // Yetişkinler için indirim yok, taban fiyat geçerli
        this.odenenFiyat = super.getEtkinlik().getPrice();
    }
}
