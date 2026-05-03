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
        setLayout(new BorderLayout()); 

        pnlUst = new JPanel();
        pnlUst.setBackground(new Color(255, 230, 240)); 
        String[] kategoriler = {"Sinema", "Konser", "StandUp", "Tiyatro", "Tümü"};
        for (String kat : kategoriler) {
            JButton btn = new JButton(kat);
            btn.addActionListener(e -> filtrele(kat)); // filtreleme
            pnlUst.add(btn);
        }
        add(pnlUst, BorderLayout.NORTH);
        
        pnlOrta = new JPanel();
        pnlOrta.setLayout(new BoxLayout(pnlOrta, BoxLayout.Y_AXIS));
        
        scroll = new JScrollPane(pnlOrta); 
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}
