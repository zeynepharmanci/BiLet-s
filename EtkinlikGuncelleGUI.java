package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikGuncelleGUI extends JFrame {

    private JTextField txtAd, txtSehir, txtFiyat;
    private Event guncellenecekEvent; // Üzerinde değişiklik yapacağımız nesneyi burada tutuyoruz

    public EtkinlikGuncelleGUI(Event event) {
        this.guncellenecekEvent = event;

        setTitle("Etkinlik Güncelle - " + event.getEventname());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        getContentPane().setBackground(new Color(255, 240, 245));

        add(new JLabel(" Etkinlik Adı:"));
        txtAd = new JTextField(event.getEventname()); 
        add(txtAd);

        add(new JLabel(" Şehir:"));
        txtSehir = new JTextField(event.getCity());
        add(txtSehir);

        add(new JLabel(" Fiyat (TL):"));
        txtFiyat = new JTextField(String.valueOf(event.getPrice()));
        add(txtFiyat);

        JButton btnIptal = new JButton("İptal");
        JButton btnKaydet = new JButton("Değişiklikleri Kaydet");
        btnKaydet.setBackground(new Color(255, 0, 127));
        btnKaydet.setForeground(Color.WHITE);

        add(btnIptal);
        add(btnKaydet);

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
                JOptionPane.showMessageDialog(this, "Hata: Lütfen fiyatı sayı olarak (örn: 250.0) giriniz!", "Giriş Hatası", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
