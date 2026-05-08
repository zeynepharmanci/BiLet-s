
package BiLets;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        verileriYukle();

        // 2. Arayüzü başlat
        SwingUtilities.invokeLater(() -> {
            new GirisEkrani().setVisible(true);
        });
    }

    private static void verileriYukle() {
        DosyaYonetimi dosyaYonetimi = new DosyaYonetimi();
 
        // --- KULLANICI YÜKLEME ---
        VeriDeposu.kullaniciListesi.clear(); 
        
        ArrayList<Kullanici> gelenKullanicilar = dosyaYonetimi.kullanicilariYukle();
        if (gelenKullanicilar != null) {
            VeriDeposu.kullaniciListesi.addAll(gelenKullanicilar);
        }
        
        if(VeriDeposu.kullaniciListesi.isEmpty()) {
            VeriDeposu.kullaniciListesi.add(new Kullanici("Gazi", "Öğrencisi", 20, "gazi@edu.tr", "5550001122", "sifre123"));
        }

        // --- ETKİNLİK YÜKLEME ---
        VeriDeposu.etkinlikListesi = dosyaYonetimi.verileriYukle();
 
        // 1. GÜVENLİK: Eğer dosya hiç yoksa veya bozuksa, null hatası vermemesi için yeni boş liste oluştur.
        if (VeriDeposu.etkinlikListesi == null) {
            VeriDeposu.etkinlikListesi = new ArrayList<>();
        }

        // 2. HAYALET AVCISI: Listenin içindeki bozuk 'null' kayıtları tamamen temizle.
        VeriDeposu.etkinlikListesi.removeIf(e -> e == null);
if(VeriDeposu.etkinlikListesi.size() < 15) {
            
            VeriDeposu.etkinlikListesi.clear(); // İŞTE SİHİRLİ SATIR BU! Eski dosyayı tamamen yok eder.
            
            boolean[][] koltuk = new boolean[10][10];
            VeriDeposu.etkinlikListesi.add(new Sinema("Avatar: Suyun Yolu", "Ankara", 150.0, koltuk, "James Cameron", 190, "Sam Worthington", true, "Bilim Kurgu"));
            VeriDeposu.etkinlikListesi.add(new Konser("Sertab Erener", "İstanbul", 400.0, koltuk, "Sertab Erener", "Pop"));
            VeriDeposu.etkinlikListesi.add(new Tiyatro("Bir Delinin Hatıra Defteri", "İzmir", 200.0, koltuk, 1, "Erdal Beşikçioğlu", "Dram"));
            VeriDeposu.etkinlikListesi.add(new Tiyatro("Cimri", "İzmir", 180.0, koltuk, 2, "Molière", "Komedi"));
            VeriDeposu.etkinlikListesi.add(new Tiyatro("Profesyonel", "Ankara", 150.0, koltuk, 1, "Dušan Kovačević", "Dram"));
            VeriDeposu.etkinlikListesi.add(new Sinema("The Matrix", "İstanbul", 120.0, koltuk, "Wachowski Kardeşler", 136, "Keanu Reeves", false, "Bilim Kurgu"));
            VeriDeposu.etkinlikListesi.add(new Sinema("Sherlock Holmes", "Ankara", 140.0, koltuk, "Guy Ritchie", 128, "Robert Downey Jr.", false, "Gizem/Aksiyon"));
            VeriDeposu.etkinlikListesi.add(new Konser("Madrigal Konseri", "Ankara", 250.0, koltuk, "Madrigal", "Alternatif Rock"));
            VeriDeposu.etkinlikListesi.add(new Konser("Mor ve Ötesi", "İstanbul", 350.0, koltuk, "Mor ve Ötesi", "Rock"));
            VeriDeposu.etkinlikListesi.add(new StandUp("CMXXIV", "İzmir", 600.0, koltuk, "Cem Yılmaz", 18, "Komedi"));
            VeriDeposu.etkinlikListesi.add(new StandUp("Doğu Demirkol", "Ankara", 250.0, koltuk, "Doğu Demirkol", 15, "Komedi"));
            VeriDeposu.etkinlikListesi.add(new Tiyatro("Zengin Mutfağı", "İstanbul", 220.0, koltuk, 2, "Vasıf Öngören", "Dram/Komedi"));
            VeriDeposu.etkinlikListesi.add(new Tiyatro("Amadeus", "Ankara", 300.0, koltuk, 2, "Peter Shaffer", "Biyografi"));
            VeriDeposu.etkinlikListesi.add(new Sinema("Dune: Çöl Gezegeni 2", "İzmir", 200.0, koltuk, "Denis Villeneuve", 166, "Timothée Chalamet", true, "Bilim Kurgu"));
            VeriDeposu.etkinlikListesi.add(new Sinema("Oppenheimer", "İstanbul", 180.0, koltuk, "Christopher Nolan", 180, "Cillian Murphy", false, "Biyografi/Dram"));
            VeriDeposu.etkinlikListesi.add(new Konser("Duman", "İzmir", 300.0, koltuk, "Duman", "Rock"));
            VeriDeposu.etkinlikListesi.add(new Konser("Melike Şahin", "Ankara", 280.0, koltuk, "Melike Şahin", "Pop"));
            VeriDeposu.etkinlikListesi.add(new StandUp("Hasan Can Kaya", "İzmir", 400.0, koltuk, "Hasan Can Kaya", 18, "Kara Mizah"));
            VeriDeposu.etkinlikListesi.add(new StandUp("Baturay Özdemir", "İstanbul", 200.0, koltuk, "Baturay Özdemir", 18, "Komedi"));

            dosyaYonetimi.verileriKaydet(VeriDeposu.etkinlikListesi);
        }
    }
}