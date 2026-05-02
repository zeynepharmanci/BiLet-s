package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikSatiri extends JPanel {
    
    public EtkinlikSatiri(Etkinlik e) { // Parametre olarak Etkinlik objesini alýyor
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Pembe Çerçeve ve Ýç Boþluk (Tasarýmýn güzel durmasý için)
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        // Boyut Sýnýrý (BoxLayout içinde düzgün dizilmeleri için kritik)
        setMaximumSize(new Dimension(1200, 100));

        // Sol taraf: Etkinlik Bilgileri
        JLabel lblBilgi = new JLabel(e.getIsim() + " - " + e.getSehir() + " - " + e.getFiyat());
        lblBilgi.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Sað taraf: Bilet Al Butonu
        JButton btnBilet = new JButton("Bilet Al");
        btnBilet.setBackground(new Color(255, 0, 127));
        btnBilet.setForeground(Color.WHITE);
        btnBilet.setFocusPainted(false);
        btnBilet.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // BUTONA TIKLAMA OLAYI (Sayfalar Arasý Geçiþ)
        btnBilet.addActionListener(event -> {
            // 1. Bu satýrýn içinde bulunduðu ana pencereyi (BiletEkrani) buluyoruz
            JFrame anaPencere = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            // 2. Yeni Detay Ekranýný oluþturuyoruz
            // Parametre olarak seçilen etkinliði (e) ve geri dönebilmek için ana pencereyi gönderiyoruz
            new DetayEkrani(e, anaPencere);
            
            // 3. Ana listeyi gizliyoruz (Kapatmýyoruz, sadece gizliyoruz)
            if (anaPencere != null) {
                anaPencere.setVisible(false);
            }
        });

        // Bileþenleri yerleþtirme
        add(lblBilgi, BorderLayout.CENTER);
        add(btnBilet, BorderLayout.EAST);
    }
}