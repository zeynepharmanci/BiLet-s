package BiLets;

import javax.swing.SwingUtilities;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        verileriYukle();

        SwingUtilities.invokeLater(() -> {
            new GirisEkrani().setVisible(true);
        });
    }

    private static void verileriYukle() {
        DosyaYonetimi dosyaYonetimi = new DosyaYonetimi();

        VeriDeposu.kullaniciListesi.clear(); 
        
        ArrayList<Kullanici> gelenKullanicilar = dosyaYonetimi.kullanicilariYukle();
        if (gelenKullanicilar != null) {
            VeriDeposu.kullaniciListesi.addAll(gelenKullanicilar);
        }
        
        if(VeriDeposu.kullaniciListesi.isEmpty()) {
            VeriDeposu.kullaniciListesi.add(new Kullanici("Gazi", "Öğrencisi", 20, "gazi@edu.tr", "5550001122", "sifre123"));
        }

        VeriDeposu.etkinlikListesi = dosyaYonetimi.verileriYukle();

        if (VeriDeposu.etkinlikListesi == null) {
            VeriDeposu.etkinlikListesi = new ArrayList<>();
        }

        VeriDeposu.etkinlikListesi.removeIf(e -> e == null);

        if(VeriDeposu.etkinlikListesi.size() < 15) {
            
            VeriDeposu.etkinlikListesi.clear();
            
            boolean[][] koltuk = new boolean[10][10];
            
            etkinlikEkle(new Sinema("Avatar: Suyun Yolu", "Ankara", 150.0, koltuk, "James Cameron", 190, "Sam Worthington", true, "Bilim Kurgu"), "15 Mayıs Cuma 20:00");
            etkinlikEkle(new Konser("Sertab Erener", "Konya", 400.0, koltuk, "Sertab Erener", "Pop"), "16 Mayıs Cumartesi 21:00");
            etkinlikEkle(new Tiyatro("Bir Delinin Hatıra Defteri", "Kütahya", 200.0, koltuk, 1, "Erdal Beşikçioğlu", "Dram"), "18 Mayıs Pazartesi 19:30");
            etkinlikEkle(new Tiyatro("Cimri", "Kütahya", 180.0, koltuk, 2, "Molière", "Komedi"), "19 Mayıs Salı 20:00");
            etkinlikEkle(new Tiyatro("Profesyonel", "Ankara", 150.0, koltuk, 1, "Dušan Kovačević", "Dram"), "20 Mayıs Çarşamba 20:00");
            etkinlikEkle(new Sinema("The Matrix", "Konya", 120.0, koltuk, "Wachowski Kardeşler", 136, "Keanu Reeves", false, "Bilim Kurgu"), "21 Mayıs Perşembe 18:00");
            etkinlikEkle(new Sinema("Sherlock Holmes", "Ankara", 140.0, koltuk, "Guy Ritchie", 128, "Robert Downey Jr.", false, "Gizem/Aksiyon"), "22 Mayıs Cuma 19:00");
            etkinlikEkle(new Konser("Madrigal Konseri", "Ankara", 250.0, koltuk, "Madrigal", "Alternatif Rock"), "23 Mayıs Cumartesi 21:30");
            etkinlikEkle(new Konser("Mor ve Ötesi", "Konya", 350.0, koltuk, "Mor ve Ötesi", "Rock"), "24 Mayıs Pazar 22:00");
            etkinlikEkle(new StandUp("CMXXIV", "Kütahya", 600.0, koltuk, "Cem Yılmaz", 18, "Komedi"), "25 Mayıs Pazartesi 21:00");
            etkinlikEkle(new StandUp("Doğu Demirkol", "Ankara", 250.0, koltuk, "Doğu Demirkol", 15, "Komedi"), "26 Mayıs Salı 20:30");
            etkinlikEkle(new Tiyatro("Zengin Mutfağı", "Konya", 220.0, koltuk, 2, "Vasıf Öngören", "Dram/Komedi"), "27 Mayıs Çarşamba 19:00");
            etkinlikEkle(new Tiyatro("Amadeus", "Ankara", 300.0, koltuk, 2, "Peter Shaffer", "Biyografi"), "28 Mayıs Perşembe 20:00");
            etkinlikEkle(new Sinema("Dune: Çöl Gezegeni 2", "Kütahya", 200.0, koltuk, "Denis Villeneuve", 166, "Timothée Chalamet", true, "Bilim Kurgu"), "29 Mayıs Cuma 19:30");
            etkinlikEkle(new Sinema("Oppenheimer", "Konya", 180.0, koltuk, "Christopher Nolan", 180, "Cillian Murphy", false, "Biyografi/Dram"), "30 Mayıs Cumartesi 20:00");
            etkinlikEkle(new Konser("Duman", "Kütahya", 300.0, koltuk, "Duman", "Rock"), "1 Haziran Pazartesi 21:00");
            etkinlikEkle(new Konser("Melike Şahin", "Ankara", 280.0, koltuk, "Melike Şahin", "Pop"), "2 Haziran Salı 21:30");
            etkinlikEkle(new StandUp("Hasan Can Kaya", "Kütahya", 400.0, koltuk, "Hasan Can Kaya", 18, "Kara Mizah"), "3 Haziran Çarşamba 20:00");
            etkinlikEkle(new StandUp("Baturay Özdemir", "Konya", 200.0, koltuk, "Baturay Özdemir", 18, "Komedi"), "4 Haziran Perşembe 20:30");

            dosyaYonetimi.verileriKaydet(VeriDeposu.etkinlikListesi);
        }
    }

    private static void etkinlikEkle(Event etkinlik, String tarih) {
        etkinlik.setTarih(tarih);
        VeriDeposu.etkinlikListesi.add(etkinlik);
    }
}
