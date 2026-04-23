package BiLets;
import java.util.ArrayList;
public class VeriDeposu {
    // Sistemdeki tüm etkinlikler burada tutulur
    public static ArrayList<Event> etkinlikListesi = new ArrayList<>();
    // İstersen sistemdeki tüm kullanıcıları da burada tutabilirsin
    public static ArrayList<Person> kullaniciListesi = new ArrayList<>();
    // Sistemde kesilmiş tüm biletler
    // Not: Ticket abstract olsa bile ArrayList<Ticket> yazabilirsin.
    public static ArrayList<Ticket> biletListesi = new ArrayList<>();
    
    public static Person sistemeGirisYap(String email, String sifre) {
        for (Person p : kullaniciListesi) {
            if (p.getEmail().equals(email) && p.getPassword().equals(sifre)) {
                return p;
            }
        }
        return null;
    }
}
