/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

/**
 *
 * @author nidan
 */
public class Yetiskin extends Ticket {
    public Yetiskin(String biletKodu, Event etkinlik, Person musteri, String koltukNo) {
        super(biletKodu, etkinlik, musteri, koltukNo);
    }

    @Override
    public void biletFiyatiHesapla() {
        // Yetişkinler için indirim yok, taban fiyat geçerli
        this.odenenFiyat = super.getEtkinlik().getPrice();
    }
}
