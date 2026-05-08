/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

/**
 *
 * @author nidan
 */
public class Genc extends Ticket {
     public Genc(String biletKodu, Event etkinlik, Person musteri, String koltukNo) {
        super(biletKodu, etkinlik, musteri, koltukNo);
    }
    
    @Override
    public void biletFiyatiHesapla() {
        // Etkinliğin taban fiyatı üzerinden indirim uygular
        this.odenenFiyat = super.getEtkinlik().getPrice() * 0.9;
    }
}
