package BiLets;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class OdemeEkrani extends JFrame {

    public OdemeEkrani(double tutar, ArrayList<String> koltuklar, JFrame koltukEkrani, String biletTuru) {
        setTitle("BiLets - Güvenli Ödeme");
        setSize(500, 650); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout()); 

        getContentPane().setBackground(new Color(255, 240, 245)); 

        JPanel pnlKart = new JPanel(new BorderLayout(10, 15));
        pnlKart.setBackground(Color.WHITE);
        pnlKart.setPreferredSize(new Dimension(380, 520)); 

        pnlKart.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2, true),
            BorderFactory.createEmptyBorder(20, 25, 20, 25)
        ));

        JPanel pnlOzet = new JPanel(new GridLayout(2, 1));
        pnlOzet.setOpaque(false);
        pnlOzet.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        
        JLabel lblTutar = new JLabel("Toplam: " + tutar + " TL (" + biletTuru + ")", SwingConstants.CENTER);
        lblTutar.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTutar.setForeground(new Color(255, 0, 127)); 
        
        JLabel lblKoltuk = new JLabel("Koltuklar: " + String.join(", ", koltuklar), SwingConstants.CENTER);
        lblKoltuk.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        pnlOzet.add(lblTutar);
        pnlOzet.add(lblKoltuk);
        pnlKart.add(pnlOzet, BorderLayout.NORTH);

        JPanel pnlForm = new JPanel(new GridLayout(8, 1, 5, 5));
        pnlForm.setOpaque(false);

        JTextField txtSahibi = new JTextField();
        JTextField txtKartNo = new JTextField();
        JTextField txtSKT = new JTextField();
        JTextField txtCVV = new JTextField();

        pnlForm.add(new JLabel("Kart Sahibi Adı Soyadı:"));
        pnlForm.add(txtSahibi);
        pnlForm.add(new JLabel("Kart Numarası (16 Hane):"));
        pnlForm.add(txtKartNo);
        pnlForm.add(new JLabel("Son Kullanma Tarihi (AA/YY):"));
        pnlForm.add(txtSKT);
        pnlForm.add(new JLabel("CVV:"));
        pnlForm.add(txtCVV);

        pnlKart.add(pnlForm, BorderLayout.CENTER);

        JPanel pnlAlt = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        pnlAlt.setOpaque(false);
        
        JButton btnIptal = new JButton("<- İptal");
        btnIptal.setBackground(Color.LIGHT_GRAY);
        btnIptal.setForeground(Color.BLACK);
        btnIptal.setFocusPainted(false);
        btnIptal.setPreferredSize(new Dimension(100, 40));

        btnIptal.addActionListener(e -> {
            koltukEkrani.setVisible(true);
            this.dispose();
        });

        JButton btnOde = new JButton("Ödemeyi Onayla");
        btnOde.setBackground(new Color(255, 0, 127)); 
        btnOde.setForeground(Color.WHITE);
        btnOde.setFocusPainted(false);
        btnOde.setPreferredSize(new Dimension(180, 40));
        btnOde.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnOde.addActionListener(e -> {
            if (txtKartNo.getText().length() < 16 || txtCVV.getText().length() < 3) {
                JOptionPane.showMessageDialog(this, "Lütfen kart bilgilerini eksiksiz giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    String etkinlikAdi = koltukEkrani.getTitle().replace(" - Koltuk Seçimi", "");

                    Event asilEtkinlik = null;
                    for(Event ev : VeriDeposu.etkinlikListesi) {
                        if(ev != null && ev.getEventname().equals(etkinlikAdi)) {
                            asilEtkinlik = ev; break;
                        }
                    }

                    if(asilEtkinlik != null) {
                        for(String koltuk : koltuklar) {
                            String rastgeleKod = "BLT-" + System.currentTimeMillis() % 1000 + "-" + koltuk;
                            Ticket yeniBilet;

                            if(biletTuru.equals("Genç")) {
                                yeniBilet = new Genc(rastgeleKod, asilEtkinlik, VeriDeposu.aktifKullanici, koltuk);
                            } else {
                                yeniBilet = new Yetiskin(rastgeleKod, asilEtkinlik, VeriDeposu.aktifKullanici, koltuk);
                            }
                            
                            yeniBilet.biletFiyatiHesapla(); 
                            VeriDeposu.biletListesi.add(yeniBilet); 
                        }
                    }

                    String email = ((Person)VeriDeposu.aktifKullanici).getEmail();
                    String koltuklarStr = String.join(",", koltuklar);

                    String kayit = email + "|" + etkinlikAdi + " (" + biletTuru + " Bilet)|" + koltuklarStr + "|" + tutar;        
                    BufferedWriter bw = new BufferedWriter(new FileWriter("bilet_gecmisi.txt", true));
                    bw.write(kayit);
                    bw.newLine();
                    bw.close();
                } catch(Exception ex) {
                    System.out.println("Bilet kaydedilemedi.");
                }

                JOptionPane.showMessageDialog(this, "Ödemeniz başarıyla alındı!\nİyi eğlenceler dileriz.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);

                new KullaniciPaneli().setVisible(true);
                koltukEkrani.dispose(); 
                this.dispose(); 
            }
        });

        pnlAlt.add(btnIptal);
        pnlAlt.add(btnOde);
        pnlKart.add(pnlAlt, BorderLayout.SOUTH);

        add(pnlKart); 

        setVisible(true);
    }
}
