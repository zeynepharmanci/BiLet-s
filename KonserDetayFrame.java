package BiLets;

import javax.swing.*;
import java.awt.*;

public class KonserDetayFrame extends JFrame {

    public KonserDetayFrame(String ad, String sehir, double fiyat, String sanatci, String tur) {
        setTitle("Konser Detayı - " + ad);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(250, 240, 245));

        JPanel pnlBaslik = new JPanel(new GridLayout(2, 1));
        pnlBaslik.setBackground(new Color(75, 0, 130)); 
        
        JLabel lblKonserAdi = new JLabel("🎵 " + ad, SwingConstants.CENTER);
        lblKonserAdi.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblKonserAdi.setForeground(Color.WHITE);
        
        JLabel lblAltBaslik = new JLabel("Canlı Müzik Performansı", SwingConstants.CENTER);
        lblAltBaslik.setForeground(Color.LIGHT_GRAY);
        
        pnlBaslik.add(lblKonserAdi);
        pnlBaslik.add(lblAltBaslik);
        add(pnlBaslik, BorderLayout.NORTH);

        JPanel pnlDetay = new JPanel(new GridLayout(4, 1, 5, 15));
        pnlDetay.setOpaque(false);
        pnlDetay.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        pnlDetay.add(bilgiOlustur("📍 Şehir:", sehir));
        pnlDetay.add(bilgiOlustur("💵 Fiyat:", fiyat + " TL"));
 
        pnlDetay.add(bilgiOlustur("🎸 Sanatçı/Grup:", sanatci));
        pnlDetay.add(bilgiOlustur("🎧 Müzik Türü:", tur));

        add(pnlDetay, BorderLayout.CENTER);

        JPanel pnlButon = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlButon.setOpaque(false);
        
        JButton btnGeri = new JButton("Geri Dön");

        JButton btnKoltukSec = new JButton("Koltuk Seç & Bilet Al"); 
        btnKoltukSec.setBackground(new Color(255, 0, 127));
        btnKoltukSec.setForeground(Color.WHITE);

        pnlButon.add(btnGeri);
        pnlButon.add(btnKoltukSec);
        add(pnlButon, BorderLayout.SOUTH);

        btnGeri.addActionListener(e -> this.dispose());

        btnKoltukSec.addActionListener(e -> {
            new KoltukSecimEkrani(ad, fiyat).setVisible(true);
            this.dispose(); 
        });

    } 

    private JPanel bilgiOlustur(String baslik, String deger) {
        JPanel pnl = new JPanel(new BorderLayout());
        pnl.setOpaque(false);
        JLabel lblBaslik = new JLabel(baslik);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 14));
        JLabel lblDeger = new JLabel(deger);
        lblDeger.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        pnl.add(lblBaslik, BorderLayout.WEST);
        pnl.add(lblDeger, BorderLayout.EAST);
        pnl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        return pnl;
    }
    
}