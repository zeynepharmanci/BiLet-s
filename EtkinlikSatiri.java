package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikSatiri extends JPanel {
    
    public EtkinlikSatiri(Event e) { 
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        setMaximumSize(new Dimension(1200, 100));
        JLabel lblBilgi = new JLabel(e.getEventname() + " - " + e.getCity() + " - " + e.getPrice());
        lblBilgi.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton btnBilet = new JButton("Bilet Al");
        btnBilet.setBackground(new Color(255, 0, 127));
        btnBilet.setForeground(Color.WHITE);
        btnBilet.setFocusPainted(false);
        btnBilet.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBilet.addActionListener(aksiyon -> {
            JFrame anaPencere = (JFrame) SwingUtilities.getWindowAncestor(this);

            // İŞTE ÇEVİRİCİ KÖPRÜ BURASI: 
            // Elimizdeki Event nesnesinin verilerini çekiyoruz
            String isim = e.getEventname();
            String mekan = "Belirtilmedi"; // Event sınıfında mekan değişkeni olmadığı için boş geçiyoruz
            String sehir = e.getCity();
            String fiyat = String.valueOf(e.getPrice());
            String kategori = e.getClass().getSimpleName(); // "Sinema", "Konser" kelimesini otomatik alır

            // DetayEkrani'nin tam da beklediği o eski "Etkinlik" nesnesini bu verilerle üretiyoruz
            Etkinlik eskiFormataUygunEtkinlik = new Etkinlik(isim, mekan, sehir, fiyat, kategori);

            // Ve DetayEkrani'ne hatasız bir şekilde fırlatıyoruz!
            new DetayEkrani(eskiFormataUygunEtkinlik, anaPencere); 
            
            if (anaPencere != null) {
                anaPencere.setVisible(false);
            }
        });
        add(lblBilgi, BorderLayout.CENTER);
        add(btnBilet, BorderLayout.EAST);
    }
}