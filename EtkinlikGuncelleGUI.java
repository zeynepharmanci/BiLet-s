package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikGuncelleGUI extends JFrame {

    private JTextField txtAd, txtSehir, txtFiyat;
    private Event guncellenecekEvent; // Üzerinde değişiklik yapacağımız nesneyi burada tutacağız

    // Yapıcı metot artık boş değil, bir 'Event' nesnesi bekliyor
    public EtkinlikGuncelleGUI(Event event) {
        this.guncellenecekEvent = event;

        setTitle("Etkinlik Güncelle - " + event.getEventname());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));
        getContentPane().setBackground(new Color(255, 240, 245));

        // METİN KUTULARINI OLUŞTURURKEN İÇLERİNİ NESNEDEN GELEN VERİYLE DOLDURUYORUZ
        add(new JLabel(" Etkinlik Adı:"));
        txtAd = new JTextField(event.getEventname()); // Mevcut adı otomatik yazar
        add(txtAd);

        add(new JLabel(" Şehir:"));
        txtSehir = new JTextField(event.getCity()); // Mevcut şehri otomatik yazar
        add(txtSehir);

        add(new JLabel(" Fiyat (TL):"));
        txtFiyat = new JTextField(String.valueOf(event.getPrice())); // Mevcut fiyatı yazar
        add(txtFiyat);

        JButton btnIptal = new JButton("İptal");
        JButton btnKaydet = new JButton("Değişiklikleri Kaydet");
        btnKaydet.setBackground(new Color(255, 0, 127));
        btnKaydet.setForeground(Color.WHITE);

        add(btnIptal);
        add(btnKaydet);

        // İPTAL BUTONU: Hiçbir şeyi değiştirmeden yönetici paneline geri döner
        btnIptal.addActionListener(e -> {
            new YoneticiPaneliGUI().setVisible(true);
            this.dispose();
        });

        // KAYDET BUTONU: Kutulardaki yeni yazıları alır ve nesneye işler
        btnKaydet.addActionListener(e -> {
            try {
                // 1. Nesnenin içindeki bilgileri yeni yazılanlarla güncelliyoruz (Setter kullanımı)
                guncellenecekEvent.setEventname(txtAd.getText());
                guncellenecekEvent.setCity(txtSehir.getText());
                guncellenecekEvent.setPrice(Double.parseDouble(txtFiyat.getText()));

                // 2. TÜM LİSTEYİ DOSYAYA TEKRAR MÜHÜRLÜYORUZ (Kalıcı olması için en kritik adım)
                new DosyaYönetimi().verileriKaydet(VeriDeposu.etkinlikListesi);

                JOptionPane.showMessageDialog(this, "Etkinlik başarıyla güncellendi!");
                
                // 3. Yönetici paneline geri dönüyoruz (Tablo otomatik olarak yeni haliyle yüklenecek)
                new YoneticiPaneliGUI().setVisible(true);
                this.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hata: Lütfen fiyatı sayı olarak (örn: 250.0) giriniz!", "Giriş Hatası", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}