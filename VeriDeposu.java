package BiLets;

import java.util.ArrayList;
import java.util.HashMap;

public class VeriDeposu {
    public static ArrayList<Event> etkinlikListesi = new ArrayList<>();
    public static ArrayList<Kullanici> kullaniciListesi = new ArrayList<>();
    public static ArrayList<Ticket> biletListesi = new ArrayList<>();
    public static Person aktifKullanici;

    // YENİ: Etkinlik Adı -> O etkinliğin satılan koltuklarının listesi
    public static HashMap<String, ArrayList<String>> doluKoltuklar = null; 

    // YENİ: Main'e dokunmadan arka planda koltukları dosyadan otomatik çeken zeka
    public static HashMap<String, ArrayList<String>> getDoluKoltuklar() {
        if (doluKoltuklar == null) {
            doluKoltuklar = new DosyaYonetimi().doluKoltuklariYukle();
        }
        return doluKoltuklar;
    }
    
    public static Person sistemeGirisYap(String email, String sifre) {
        for (Person p : kullaniciListesi) {
            if (p.getEmail().equals(email) && p.getPassword().equals(sifre)) {
                return p;
            }
        }
        return null;
    }
}
