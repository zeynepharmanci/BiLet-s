package BiLets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BiletEkrani extends JFrame {
    private JPanel pnlListe;
    private JPanel pnlSehirler; // Þehir butonlarýnýn olduðu panel
    private ArrayList<Etkinlik> tumEtkinlikler;
    
    // Filtreleme için durum deðiþkenleri
    private String seciliKategori = "Tümü";
    private String seciliSehir = "Tüm Þehirler";

    public BiletEkrani() {
        setTitle("BiLets - Etkinlik Seçimi");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. VERÝLERÝ HAZIRLA
        verileriOlustur();

        // 2. ÜST PANEL (Kategori ve Þehir Butonlarý)
        JPanel pnlUstAna = new JPanel(new GridLayout(2, 1)); // Ýki satýr: Üstte Kategori, Altta Þehir
        
        // KATEGORÝ SATIRI
        JPanel pnlKategoriler = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        pnlKategoriler.setBackground(new Color(255, 240, 245));
        
        String[] kategoriler = {"Tümü", "Sinema", "Konser", "StandUp", "Tiyatro"};
        for (String kat : kategoriler) {
            JButton btn = new JButton(kat);
            btn.setPreferredSize(new Dimension(110, 35));
            btn.setBackground(Color.WHITE);
            btn.setFocusPainted(false);
            
            btn.addActionListener(e -> {
                seciliKategori = kat;
                // Kategori butonlarýnda renk deðiþimi
                for(Component c : pnlKategoriler.getComponents()) c.setBackground(Color.WHITE);
                btn.setBackground(new Color(255, 180, 210));
                listeyiGuncelle();
            });
            pnlKategoriler.add(btn);
        }
        
     // BiletEkrani.java içindeki pnlKategoriler döngüsünden sonra ekleyebilirsin
        JButton btnGeri = new JButton("<- Ana Menü");
        btnGeri.setPreferredSize(new Dimension(130, 35));
        btnGeri.setBackground(new Color(200, 200, 200)); // Gri tonu
        btnGeri.setFocusPainted(false);

        btnGeri.addActionListener(e -> {
            new KullaniciPaneli(); // Kullanýcý paneline geri döner
            this.dispose();        // Bilet ekranýný kapatýr
        });

        // Butonu kategori paneline ekle
        pnlKategoriler.add(btnGeri);

        // ÞEHÝR SATIRI
        pnlSehirler = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        pnlSehirler.setBackground(new Color(245, 245, 245));
        
        String[] sehirler = {"Tüm Þehirler", "Ankara", "Ýstanbul", "Ýzmir"};
        for (String sehir : sehirler) {
            JButton btnSehir = new JButton(sehir);
            btnSehir.setPreferredSize(new Dimension(110, 30));
            btnSehir.setBackground(Color.WHITE);
            btnSehir.setFocusPainted(false);
            
            btnSehir.addActionListener(e -> {
                seciliSehir = sehir;
                // Þehir butonlarýnda renk deðiþimi
                for(Component c : pnlSehirler.getComponents()) c.setBackground(Color.WHITE);
                btnSehir.setBackground(new Color(180, 210, 255)); // Þehre özel mavi tonu
                listeyiGuncelle();
            });
            pnlSehirler.add(btnSehir);
        }

        pnlUstAna.add(pnlKategoriler);
        pnlUstAna.add(pnlSehirler);
        add(pnlUstAna, BorderLayout.NORTH);

        // 3. ORTA PANEL (Liste)
        pnlListe = new JPanel();
        pnlListe.setLayout(new BoxLayout(pnlListe, BoxLayout.Y_AXIS));
        pnlListe.setBackground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(pnlListe);
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);

        listeyiGuncelle(); // Ýlk açýlýþ
        setVisible(true);
    }

    private void verileriOlustur() {
        tumEtkinlikler = new ArrayList<>();
        tumEtkinlikler.add(new Etkinlik("Avatar: Suyun Yolu", "Ankara", "Ankara", "150 TL", "Sinema"));
        tumEtkinlikler.add(new Etkinlik("Sertab Erener", "Harbiye", "Ýstanbul", "400 TL", "Konser"));
        tumEtkinlikler.add(new Etkinlik("Bir Delinin Hatýra Defteri", "Ýzmir", "Ýzmir", "200 TL", "Tiyatro"));
        tumEtkinlikler.add(new Etkinlik("Doðu Demirkol", "Ankara", "Ankara", "300 TL", "StandUp"));
        tumEtkinlikler.add(new Etkinlik("Madrigal", "Jolly Joker", "Ankara", "250 TL", "Konser"));
    }

    // ARTIK ÝKÝ FÝLTREYE BÝRDEN BAKIYOR
    private void listeyiGuncelle() {
        pnlListe.removeAll();

        for (Etkinlik e : tumEtkinlikler) {
            boolean katUygun = seciliKategori.equals("Tümü") || e.getKategori().equals(seciliKategori);
            boolean sehirUygun = seciliSehir.equals("Tüm Þehirler") || e.getSehir().equals(seciliSehir);

            if (katUygun && sehirUygun) {
                pnlListe.add(Box.createVerticalStrut(15));
                pnlListe.add(new EtkinlikSatiri(e));
            }
        }

        pnlListe.add(Box.createVerticalGlue());
        pnlListe.revalidate();
        pnlListe.repaint();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        new BiletEkrani();
    }
}