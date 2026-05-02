package BiLets;

import javax.swing.*;
import java.awt.*;

public class AnaEkran extends JFrame {
    JPanel pnlUst, pnlOrta;
    JScrollPane scroll;

    public AnaEkran() {
        setTitle("BiLets - Etkinlik Seçimi");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Ana düzen

        // 1. ÜST PANEL (Butonlar için)
        pnlUst = new JPanel();
        pnlUst.setBackground(new Color(255, 230, 240)); // Senin pembe teman
        String[] kategoriler = {"Sinema", "Konser", "StandUp", "Tiyatro", "Tümü"};
        for (String kat : kategoriler) {
            JButton btn = new JButton(kat);
            btn.addActionListener(e -> filtrele(kat)); // Butona basýnca filtreleme yapacak
            pnlUst.add(btn);
        }
        add(pnlUst, BorderLayout.NORTH);

        // 2. ORTA PANEL (Etkinlik Satýrlarý için)
        pnlOrta = new JPanel();
        pnlOrta.setLayout(new BoxLayout(pnlOrta, BoxLayout.Y_AXIS)); // Alt alta dizilim
        
        scroll = new JScrollPane(pnlOrta); // Kaydýrma çubuðu
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}
