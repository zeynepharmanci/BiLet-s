package BiLets;

import java.util.ArrayList;

public class VeriDeposu {
    public static ArrayList<Event> etkinlikListesi = new ArrayList<>();
    public static ArrayList<Kullanici> kullaniciListesi = new ArrayList<>();

    public static ArrayList<Ticket> biletListesi = new ArrayList<>();
	public static Object aktifKullanici;

    
    public static Person sistemeGirisYap(String email, String sifre) {
        for (Person p : kullaniciListesi) {
            if (p.getEmail().equals(email) && p.getPassword().equals(sifre)) {
                return p;
            }
        }
        return null;
    }
}
