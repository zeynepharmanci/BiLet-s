package BiLets;

import javax.swing.*;
import java.awt.*;

public class KullaniciPaneli extends JFrame {

    public KullaniciPaneli() {
        if (VeriDeposu.aktifKullanici == null) {
            JOptionPane.showMessageDialog(null, "Lütfen önce giriş yapın!");
            new GirisEkrani();
            return;
        }

        setTitle("BiLets - Kullanıcı Paneli");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(255, 240, 245));

        // Ana Panel 
        JPanel pnlMerkez = new JPanel(new GridLayout(5, 1, 10, 20));
        pnlMerkez.setOpaque(false);

        // Selamlama
        JLabel lblSelam = new JLabel("Hoş geldin, " + VeriDeposu.aktifKullanici.getName(), SwingConstants.CENTER);
        lblSelam.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblSelam.setForeground(new Color(255, 0, 127));

        // Butonlar
        JButton btnProfil = new JButton("Profil Bilgilerim");
        JButton btnBiletAl = new JButton("Bilet Satın Al");
        JButton btnBiletlerim = new JButton("Satın Aldığım Biletler");
        JButton btnCikis = new JButton("Güvenli Çıkış");

        // Buton Tasarımları
        styleButton(btnProfil);
        styleButton(btnBiletAl);
        styleButton(btnBiletlerim);
        styleButton(btnCikis);

        // Aksiyonlar
        btnBiletAl.addActionListener(e -> {
            new BiletEkrani();
            this.dispose();
        });

        btnProfil.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, VeriDeposu.aktifKullanici.profilGoruntule(), "Profil Bilgileri", JOptionPane.INFORMATION_MESSAGE);
        });

        btnBiletlerim.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Henüz satın alınmış biletiniz bulunmamaktadır.", "Biletlerim", JOptionPane.PLAIN_MESSAGE);
        });

        btnCikis.addActionListener(e -> {
            VeriDeposu.aktifKullanici = null; 
            new GirisEkrani();
            this.dispose();
        });

        pnlMerkez.add(lblSelam);
        pnlMerkez.add(btnProfil);
        pnlMerkez.add(btnBiletAl);
        pnlMerkez.add(btnBiletlerim);
        pnlMerkez.add(btnCikis);

        add(pnlMerkez);
        setVisible(true);
    }

    private void styleButton(JButton btn) {
        btn.setPreferredSize(new Dimension(250, 40));
        btn.setBackground(Color.WHITE);
        btn.setForeground(new Color(255, 0, 127));
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
}
