package BiLets;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        verileriYukle();

        SwingUtilities.invokeLater(() -> {
            new GirisEkrani().setVisible(true);
        });
    }

    private static void verileriYukle() {

        VeriDeposu.kayitliKullanicilar.add(new Kullanici("Gazi", "Öğrencisi", 20, "gazi@edu.tr", "5550001122", "sifre123"));

        // Örnek Etkinlikler (10x10 koltuk düzeni ile)
        boolean[][] koltuklar1 = new boolean[10][10];
        boolean[][] koltuklar2 = new boolean[10][10];
        boolean[][] koltuklar3 = new boolean[10][10];
        boolean[][] koltuklar4 = new boolean[10][10];

        VeriDeposu.etkinlikListesi.add(new Sinema("Avatar: Suyun Yolu", "Ankara", 150.0, koltuklar1, "James Cameron", 190, "Sam Worthington", true, "Bilim Kurgu"));
        VeriDeposu.etkinlikListesi.add(new Konser("Sertab Erener", "İstanbul", 400.0, koltuklar2, "Sertab Erener", "Pop"));
        VeriDeposu.etkinlikListesi.add(new Tiyatro("Bir Delinin Hatıra Defteri", "İzmir", 200.0, koltuklar3, "1", "Erdal Beşikçioğlu", "Dram"));
        VeriDeposu.etkinlikListesi.add(new StandUp("Doğu Demirkol", "Ankara", 300.0, koltuklar4, "Doğu Demirkol", 18, "Günlük Hayat"));
    }
}
