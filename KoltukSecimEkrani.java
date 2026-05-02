package BiLets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KoltukSecimEkrani extends JFrame {
    private ArrayList<String> seciliKoltuklar = new ArrayList<>();
    private int biletFiyati;
    private JLabel lblOzet;
    private double toplamTutar = 0;

    public KoltukSecimEkrani(Etkinlik e, JFrame detayEkrani) {
        // Fiyatý String'den sayýya çevirelim (Örn: "150 TL" -> 150)
        try {
            this.biletFiyati = Integer.parseInt(e.getFiyat().replaceAll("[^0-9]", ""));
        } catch (Exception ex) {
            this.biletFiyati = 0; // Hata durumunda 0 al
        }
        
        setTitle(e.getIsim() + " - Koltuk Seçimi");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 1. ÜST KISIM: SAHNE
        JLabel lblSahne = new JLabel("SAHNE", SwingConstants.CENTER);
        lblSahne.setOpaque(true);
        lblSahne.setBackground(Color.DARK_GRAY);
        lblSahne.setForeground(Color.WHITE);
        lblSahne.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblSahne.setPreferredSize(new Dimension(800, 50));
        add(lblSahne, BorderLayout.NORTH);

        // 2. ORTA KISIM: 10x10 KOLTUKLAR
        JPanel pnlSalon = new JPanel(new GridLayout(10, 10, 5, 5));
        pnlSalon.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                String koltukNo = (char)(64 + i) + "" + j; // A1, B2 vb.
                JButton btnKoltuk = new JButton(koltukNo);
                btnKoltuk.setBackground(Color.WHITE);
                btnKoltuk.setFocusPainted(false);
                btnKoltuk.setFont(new Font("Segoe UI", Font.PLAIN, 10));

                btnKoltuk.addActionListener(event -> {
                    if (btnKoltuk.getBackground() == Color.WHITE) {
                        btnKoltuk.setBackground(new Color(255, 0, 127)); // Seçilince pembe
                        btnKoltuk.setForeground(Color.WHITE);
                        seciliKoltuklar.add(koltukNo);
                    } else {
                        btnKoltuk.setBackground(Color.WHITE); // Ýptal edilince beyaz
                        btnKoltuk.setForeground(Color.BLACK);
                        seciliKoltuklar.remove(koltukNo);
                    }
                    ozetiGuncelle();
                });
                pnlSalon.add(btnKoltuk);
            }
        }
        add(pnlSalon, BorderLayout.CENTER);

        // 3. ALT KISIM: ÖZET VE AKSÝYON BUTONLARI
        JPanel pnlAlt = new JPanel(new BorderLayout());
        pnlAlt.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        lblOzet = new JLabel("Seçili Koltuklar: - | Toplam: 0 TL");
        lblOzet.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JPanel pnlAksiyon = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton btnGeri = new JButton("<- Geri");
        btnGeri.addActionListener(ev -> {
            detayEkrani.setVisible(true);
            this.dispose();
        });

        JButton btnOdeme = new JButton("Ödemeye Geç");
        btnOdeme.setBackground(new Color(34, 139, 34)); // Yeþil renk
        btnOdeme.setForeground(Color.WHITE);
        btnOdeme.setFocusPainted(false);
        
        // ÖDEME EKRANINA GEÇÝÞ (Yeni Baðlantý)
        btnOdeme.addActionListener(ev -> {
            if(seciliKoltuklar.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Lütfen en az bir koltuk seçiniz!", "Uyarý", JOptionPane.WARNING_MESSAGE);
            } else {
                // Ödeme ekranýný açýyoruz ve gerekli bilgileri gönderiyoruz
                new OdemeEkrani(toplamTutar, seciliKoltuklar, this);
                this.setVisible(false); // Koltuk seçimini gizle
            }
        });

        pnlAksiyon.add(btnGeri);
        pnlAksiyon.add(btnOdeme);

        pnlAlt.add(lblOzet, BorderLayout.WEST);
        pnlAlt.add(pnlAksiyon, BorderLayout.EAST);
        add(pnlAlt, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void ozetiGuncelle() {
        toplamTutar = seciliKoltuklar.size() * biletFiyati;
        String koltuklarStr = seciliKoltuklar.isEmpty() ? "-" : String.join(", ", seciliKoltuklar);
        lblOzet.setText("Seçili Koltuklar: " + koltuklarStr + " | Toplam: " + toplamTutar + " TL");
    }
}