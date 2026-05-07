package BiLets;

import javax.swing.SwingUtilities;

public class BiLets {
    public static void main(String[] args) {
        verileriYukle();

        // 2. Arayüzü başlat
        SwingUtilities.invokeLater(() -> {
            new GirisEkrani().setVisible(true);
        });
    }

    private static void verileriYukle() {
        DosyaYönetimi dosyaYonetimi = new DosyaYönetimi();
 
        VeriDeposu.kullaniciListesi.clear(); 
        VeriDeposu.kullaniciListesi.addAll(dosyaYonetimi.kullanicilariYukle());
        if(VeriDeposu.kullaniciListesi.isEmpty()) {
            VeriDeposu.kullaniciListesi.add(new Kullanici("Gazi", "Öğrencisi", 20, "gazi@edu.tr", "5550001122", "sifre123"));
        }

        VeriDeposu.etkinlikListesi = dosyaYonetimi.verileriYukle();
 
        if(VeriDeposu.etkinlikListesi.isEmpty()) {
            boolean[][] koltuk = new boolean[10][10];
            VeriDeposu.etkinlikListesi.add(new Sinema("Avatar: Suyun Yolu", "Ankara", 150.0, koltuk, "James Cameron", 190, "Sam Worthington", true, "Bilim Kurgu"));
            VeriDeposu.etkinlikListesi.add(new Konser("Sertab Erener", "İstanbul", 400.0, koltuk, "Sertab Erener", "Pop"));
            VeriDeposu.etkinlikListesi.add(new Tiyatro("Bir Delinin Hatıra Defteri", "İzmir", 200.0, koltuk, 1, "Erdal Beşikçioğlu", "Dram"));

            dosyaYonetimi.verileriKaydet(VeriDeposu.etkinlikListesi);
        }
    }
}
