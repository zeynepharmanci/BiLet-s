package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikSatiri extends JPanel {
    
    public EtkinlikSatiri(Etkinlik e) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        setMaximumSize(new Dimension(1200, 100));

        JLabel lblBilgi = new JLabel(e.getIsim() + " - " + e.getSehir() + " - " + e.getFiyat());
        lblBilgi.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton btnBilet = new JButton("Bilet Al");
        btnBilet.setBackground(new Color(255, 0, 127));
        btnBilet.setForeground(Color.WHITE);
        btnBilet.setFocusPainted(false);
        btnBilet.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBilet.addActionListener(event -> {
            JFrame anaPencere = (JFrame) SwingUtilities.getWindowAncestor(this);

            new DetayEkrani(e, anaPencere);

            if (anaPencere != null) {
                anaPencere.setVisible(false);
            }
        });

        add(lblBilgi, BorderLayout.CENTER);
        add(btnBilet, BorderLayout.EAST);
    }
}
