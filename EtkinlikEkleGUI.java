package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikEkleGUI extends JFrame {

    private JComboBox<String> cmbTur;
    private JPanel pnlDinamikForm;
    private JTextField txtAd, txtSehir, txtFiyat;

    public EtkinlikEkleGUI() {
        setTitle("BiLet's - Etkinlik Ekle");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(255, 240, 245)); 

        JPanel pnlOrtak = new JPanel(new GridLayout(4, 2, 10, 10));
        pnlOrtak.setOpaque(false); 
        pnlOrtak.setBorder(BorderFactory.createTitledBorder("Genel Bilgiler"));

        pnlOrtak.add(new JLabel("Etkinlik Türü:"));
        cmbTur = new JComboBox<>(new String[]{"Seçiniz", "Sinema", "Tiyatro", "Konser", "StandUp"});
        pnlOrtak.add(cmbTur);

        pnlOrtak.add(new JLabel("Etkinlik Adı:"));
        txtAd = new JTextField();
        pnlOrtak.add(txtAd);

        pnlOrtak.add(new JLabel("Şehir:"));
        txtSehir = new JTextField();
        pnlOrtak.add(txtSehir);

        pnlOrtak.add(new JLabel("Fiyat (TL):"));
        txtFiyat = new JTextField();
        pnlOrtak.add(txtFiyat);

        add(pnlOrtak, BorderLayout.NORTH);

        pnlDinamikForm = new JPanel();
        pnlDinamikForm.setLayout(new BorderLayout());
        pnlDinamikForm.setOpaque(false);
        add(pnlDinamikForm, BorderLayout.CENTER);

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlButonlar.setOpaque(false);

        JButton btnGeri = new JButton("<- Geri Dön");
        btnGeri.setPreferredSize(new Dimension(120, 40));
        btnGeri.setBackground(Color.LIGHT_GRAY);
        btnGeri.setForeground(Color.BLACK);
        btnGeri.setFocusPainted(false);
        
        btnGeri.addActionListener(e -> {
            new YoneticiPaneliGUI().setVisible(true);
            this.dispose();
        });

        JButton btnKaydet = new JButton("Etkinliği Kaydet");
        btnKaydet.setPreferredSize(new Dimension(140, 40));
        btnKaydet.setBackground(new Color(255, 0, 127)); 
        btnKaydet.setForeground(Color.WHITE);
        btnKaydet.setFocusPainted(false);

        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnKaydet);
        
        add(pnlButonlar, BorderLayout.SOUTH);

        cmbTur.addActionListener(e -> {
            String secilenTur = (String) cmbTur.getSelectedItem();
            
            pnlDinamikForm.removeAll();
            
            JPanel yeniForm = EtkinlikFormFabrikasi.formUret(secilenTur);
            if (yeniForm != null) {
                pnlDinamikForm.add(yeniForm, BorderLayout.CENTER);
            }
            
            pnlDinamikForm.revalidate();
            pnlDinamikForm.repaint();
        });

        btnKaydet.addActionListener(e -> {
            try {
                String ad = txtAd.getText();
                String sehir = txtSehir.getText();
                double fiyat = Double.parseDouble(txtFiyat.getText());
                String tur = (String) cmbTur.getSelectedItem();
                boolean[][] bosKoltuklar = new boolean[10][10];
                Event yeniEtkinlik = null;

                if (tur.equals("Sinema")) {
                    yeniEtkinlik = new Sinema(ad, sehir, fiyat, bosKoltuklar, "Belirtilmedi", 120, "Belirtilmedi", false, "Genel");
                } else if (tur.equals("Konser")) {
                    yeniEtkinlik = new Konser(ad, sehir, fiyat, bosKoltuklar, "Belirtilmedi", "Genel");
                } else if (tur.equals("Tiyatro")) {
                    yeniEtkinlik = new Tiyatro(ad, sehir, fiyat, bosKoltuklar, 1, "Belirtilmedi", "Genel");
                } else if (tur.equals("StandUp")) {
                    yeniEtkinlik = new StandUp(ad, sehir, fiyat, bosKoltuklar, "Belirtilmedi", 18, "Genel");
                } else {
                    JOptionPane.showMessageDialog(this, "Lütfen geçerli bir etkinlik türü seçin!");
                    return; 
                }

                VeriDeposu.etkinlikListesi.add(yeniEtkinlik);
                new DosyaYonetimi().verileriKaydet(VeriDeposu.etkinlikListesi);

                JOptionPane.showMessageDialog(this, "Etkinlik başarıyla sisteme eklendi ve kaydedildi!");
                this.dispose(); 
                new YoneticiPaneliGUI().setVisible(true); 

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lütfen fiyatı sayı olarak giriniz ve tüm alanları doldurunuz!", "Giriş Hatası", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    
    static class EtkinlikFormFabrikasi {
        public static JPanel formUret(String tur) {
            JPanel pnl = new JPanel(new GridLayout(3, 2, 10, 10));
            pnl.setOpaque(false);
            pnl.setBorder(BorderFactory.createTitledBorder("Özel Bilgiler (" + tur + ")"));

            switch (tur) {
                case "Sinema":
                    pnl.add(new JLabel("Yönetmen:"));
                    pnl.add(new JTextField());
                    pnl.add(new JLabel("3D Seçeneği:"));
                    pnl.add(new JCheckBox("Evet, 3D uyumlu"));
                    return pnl;
                case "Tiyatro":
                    pnl.add(new JLabel("Perde Sayısı:"));
                    pnl.add(new JTextField());
                    pnl.add(new JLabel("Yazar:"));
                    pnl.add(new JTextField());
                    return pnl;
                case "Konser":
                    pnl.add(new JLabel("Sanatçı/Grup:"));
                    pnl.add(new JTextField());
                    pnl.add(new JLabel("Müzik Türü (Pop, Rock vb.):"));
                    pnl.add(new JTextField());
                    return pnl;
                case "StandUp":
                    pnl.add(new JLabel("Komedyen:"));
                    pnl.add(new JTextField());
                    pnl.add(new JLabel("Yaş Sınırı (+18 vb):"));
                    pnl.add(new JTextField());
                    return pnl;
                default:
                    return null;
            }
        }
    }
}
