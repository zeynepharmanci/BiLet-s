package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikGuncelleGUI extends JFrame {

    private JTextField txtAd, txtSehir, txtFiyat;
    private Event guncellenecekEvent; 

    public EtkinlikGuncelleGUI(Event event) {
        this.guncellenecekEvent = event;

        setTitle("Etkinlik Güncelle - " + event.getEventname());
        setSize(500, 500); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(255, 240, 245));

        JPanel pnlMerkez = new JPanel(new GridLayout(4, 2, 10, 15));
        pnlMerkez.setBackground(Color.WHITE); 
        pnlMerkez.setPreferredSize(new Dimension(400, 250)); 
        
        pnlMerkez.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2, true),
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));

        pnlMerkez.add(new JLabel("Etkinlik Adı:"));
        txtAd = new JTextField(event.getEventname()); 
        pnlMerkez.add(txtAd);

        pnlMerkez.add(new JLabel("Şehir:"));
        txtSehir = new JTextField(event.getCity());
        pnlMerkez.add(txtSehir);

        pnlMerkez.add(new JLabel("Fiyat (TL):"));
        txtFiyat = new JTextField(String.valueOf(event.getPrice())); 
        pnlMerkez.add(txtFiyat);

        JButton btnIptal = new JButton("<- İptal");
        btnIptal.setBackground(Color.LIGHT_GRAY);
        btnIptal.setForeground(Color.BLACK);
        btnIptal.setFocusPainted(false);
        
        JButton btnKaydet = new JButton("Güncelle");
        btnKaydet.setBackground(new Color(255, 0, 127));
        btnKaydet.setForeground(Color.WHITE);
        btnKaydet.setFocusPainted(false);

        pnlMerkez.add(btnIptal);
        pnlMerkez.add(btnKaydet);

        add(pnlMerkez);

        btnIptal.addActionListener(e -> {
            new YoneticiPaneliGUI().setVisible(true);
            this.dispose();
        });

        btnKaydet.addActionListener(e -> {
            try {
                guncellenecekEvent.setEventname(txtAd.getText());
                guncellenecekEvent.setCity(txtSehir.getText());
                guncellenecekEvent.setPrice(Double.parseDouble(txtFiyat.getText()));

                new DosyaYonetimi().verileriKaydet(VeriDeposu.etkinlikListesi);

                JOptionPane.showMessageDialog(this, "Etkinlik başarıyla güncellendi!");

                new YoneticiPaneliGUI().setVisible(true);
                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hata: Lütfen fiyatı sayı olarak giriniz!", "Giriş Hatası", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
