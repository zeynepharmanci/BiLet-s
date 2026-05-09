package BiLets;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DetayEkrani extends JFrame {

    public DetayEkrani(Etkinlik e, JFrame eskiEkran) {
        setTitle(e.getIsim() + " - Detaylar");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        JLabel lblResim = new JLabel("", SwingConstants.CENTER); 
        lblResim.setPreferredSize(new Dimension(400, 250));
        lblResim.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblResim.setOpaque(true);
        lblResim.setBackground(new Color(240, 240, 240));

        String kategoriAdi = e.getKategori().toLowerCase();
        try {
           
            URL resimURL = getClass().getResource("resimler/" + kategoriAdi + ".jpg");
            
            if (resimURL != null) {
                ImageIcon orijinalIkon = new ImageIcon(resimURL);
                Image boyutlandirilmisResim = orijinalIkon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
                lblResim.setIcon(new ImageIcon(boyutlandirilmisResim));
                lblResim.setText(""); 
            } else {
                lblResim.setText(e.getKategori() + " resmi bulunamadı");
            }
        } catch (Exception ex) {
            lblResim.setText("Resim yükleme hatası!");
        }

        add(lblResim, BorderLayout.NORTH);

        JPanel pnlBilgi = new JPanel();
        pnlBilgi.setLayout(new BoxLayout(pnlBilgi, BoxLayout.Y_AXIS));
        pnlBilgi.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblBaslik = new JLabel(e.getIsim());
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 24));
        
        JLabel lblDetay = new JLabel("<html><br><b>Mekan:</b> " + e.getMekan() + 
                                     "<br><b>Şehir:</b> " + e.getSehir() + 
                                     "<br><b>Fiyat:</b> " + e.getFiyat() + 
                                     "<br><b>Kategori:</b> " + e.getKategori() + "</html>");
        lblDetay.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        pnlBilgi.add(lblBaslik);
        pnlBilgi.add(lblDetay);
        add(pnlBilgi, BorderLayout.CENTER);

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
 
        JButton btnGeri = new JButton("<- Geri Dön");
        btnGeri.addActionListener(event -> {
            eskiEkran.setVisible(true); 
            this.dispose(); 
        });

        JButton btnOnayla = new JButton("Koltuk Seç ve Öde");
        btnOnayla.setBackground(new Color(255, 0, 127));
        btnOnayla.setForeground(Color.WHITE);
        btnOnayla.setFocusPainted(false);
        
        btnOnayla.addActionListener(event -> {
            double gecerliFiyat = 0;
            try {
                String fiyatMetni = String.valueOf(e.getFiyat()).replaceAll("[^0-9.]", "");
                if (!fiyatMetni.isEmpty()) {
                    gecerliFiyat = Double.parseDouble(fiyatMetni);
                }
            } catch (Exception ex) {
                System.out.println("Fiyat hatası.");
            }
            new KoltukSecimEkrani(e.getIsim(), gecerliFiyat).setVisible(true);
            this.dispose();
        });

        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnOnayla);
        add(pnlButonlar, BorderLayout.SOUTH);

        setVisible(true);
    }
}
