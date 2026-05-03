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

        JLabel lblResim = new JLabel("RESİM ALANI", SwingConstants.CENTER);
        lblResim.setPreferredSize(new Dimension(400, 250));
        lblResim.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        lblResim.setOpaque(true);
        lblResim.setBackground(new Color(240, 240, 240));
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
            eskiEkran.setVisible(true); // Liste ekranını tekrar göster
            this.dispose(); 
        });

        JButton btnOnayla = new JButton("Koltuk Seç ve Öde");
        btnOnayla.setBackground(new Color(255, 0, 127));
        btnOnayla.setForeground(Color.WHITE);
        btnOnayla.setFocusPainted(false);
        
        btnOnayla.addActionListener(event -> {
            new KoltukSecimEkrani(e, this);
            this.setVisible(false);
        });

        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnOnayla);
        add(pnlButonlar, BorderLayout.SOUTH);

        setVisible(true);
    }
}
