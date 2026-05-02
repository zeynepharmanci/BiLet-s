package BiLets;

import javax.swing.*;
import java.awt.*;

public class DetayEkrani extends JFrame {
    
    public DetayEkrani(Etkinlik e, JFrame eskiEkran) {
        setTitle(e.getIsim() + " - Detaylar");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        // 1. ÜST KISIM: Resim Alaný
        JLabel lblResim = new JLabel("RESÝM ALANI", SwingConstants.CENTER);
        lblResim.setPreferredSize(new Dimension(400, 250));
        lblResim.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblResim.setOpaque(true);
        lblResim.setBackground(new Color(240, 240, 240));
        // Ýleride resim eklemek istersen e.getResimYolu() ile burayý güncelleyebilirsin
        add(lblResim, BorderLayout.NORTH);

        // 2. ORTA KISIM: Bilgiler
        JPanel pnlBilgi = new JPanel();
        pnlBilgi.setLayout(new BoxLayout(pnlBilgi, BoxLayout.Y_AXIS));
        pnlBilgi.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblBaslik = new JLabel(e.getIsim());
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 24));
        
        JLabel lblDetay = new JLabel("<html><br><b>Mekan:</b> " + e.getMekan() + 
                                     "<br><b>Þehir:</b> " + e.getSehir() + 
                                     "<br><b>Fiyat:</b> " + e.getFiyat() + 
                                     "<br><b>Kategori:</b> " + e.getKategori() + "</html>");
        lblDetay.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        pnlBilgi.add(lblBaslik);
        pnlBilgi.add(lblDetay);
        add(pnlBilgi, BorderLayout.CENTER);

        // 3. ALT KISIM: Butonlar (Geri Dön ve Koltuk Seçimine Geç)
        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        // GERÝ DÖN BUTONU
        JButton btnGeri = new JButton("<- Geri Dön");
        btnGeri.addActionListener(event -> {
            eskiEkran.setVisible(true); // Liste ekranýný tekrar göster
            this.dispose(); // Bu ekraný kapat
        });

        // KOLTUK SEÇÝMÝNE GEÇÝÞ BUTONU (Burayý baðladýk)
        JButton btnOnayla = new JButton("Koltuk Seç ve Öde");
        btnOnayla.setBackground(new Color(255, 0, 127));
        btnOnayla.setForeground(Color.WHITE);
        btnOnayla.setFocusPainted(false);
        
        btnOnayla.addActionListener(event -> {
            // Koltuk seçim ekranýný aç, seçilen etkinliði ve bu ekraný gönder
            new KoltukSecimEkrani(e, this);
            this.setVisible(false); // Detay ekranýný gizle
        });

        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnOnayla);
        add(pnlButonlar, BorderLayout.SOUTH);

        setVisible(true);
    }
}