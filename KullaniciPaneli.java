package BiLets;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class KullaniciPaneli extends JFrame {

    private static final long serialVersionUID = 1L;

    public KullaniciPaneli() {

        if (VeriDeposu.aktifKullanici == null) {
            JOptionPane.showMessageDialog(null, "Lütfen önce giriş yapın!");
            new GirisEkrani().setVisible(true);
            return;
        }

        setTitle("BiLets - Kullanıcı Paneli");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(255, 240, 245));

        JPanel pnlMerkez = new JPanel(new GridLayout(5, 1, 10, 20));
        pnlMerkez.setOpaque(false);

        JLabel lblSelam = new JLabel("Hoş geldin, " + ((Person) VeriDeposu.aktifKullanici).getName(), SwingConstants.CENTER);
        lblSelam.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblSelam.setForeground(new Color(255, 0, 127));

        JButton btnProfil = new JButton("Profil Bilgilerim");
        JButton btnBiletAl = new JButton("Bilet Satın Al");
        JButton btnBiletlerim = new JButton("Satın Aldığım Biletler");
        JButton btnCikis = new JButton("Güvenli çıkış");

        styleButton(btnProfil);
        styleButton(btnBiletAl);
        styleButton(btnBiletlerim);
        styleButton(btnCikis);

        btnBiletAl.addActionListener(e -> {
            new BiletEkrani();
            this.dispose();
        });

        btnProfil.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, ((Person) VeriDeposu.aktifKullanici).profilGoruntule(), "Profil Bilgileri", JOptionPane.INFORMATION_MESSAGE, null);   
         });

        btnBiletlerim.addActionListener(e -> {
            StringBuilder biletlerStr = new StringBuilder();
            try {
                File file = new File("bilet_gecmisi.txt");
                if(file.exists()) {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;
                    String aktifEmail = ((Person)VeriDeposu.aktifKullanici).getEmail();
                    
                    while((line = br.readLine()) != null) {
                        String[] data = line.split("\\|");
                        if(data[0].equals(aktifEmail)) { 
                            biletlerStr.append("🎭 Etkinlik: ").append(data[1]).append("\n");
                            biletlerStr.append("🪑 Koltuk(lar): ").append(data[2]).append("\n");
                            biletlerStr.append("💳 Tutar: ").append(data[3]).append(" TL\n");
                            biletlerStr.append("---------------------------------\n");
                        }
                    }
                    br.close();
                }
            } catch(Exception ex) {}

            if(biletlerStr.length() == 0) {
                JOptionPane.showMessageDialog(this, "Henüz satın alınmış biletiniz bulunmamaktadır.", "Biletlerim", JOptionPane.PLAIN_MESSAGE);
            } else {
                JTextArea txtArea = new JTextArea(biletlerStr.toString());
                txtArea.setEditable(false);
                txtArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
                txtArea.setBackground(new Color(255, 240, 245));
                
                JScrollPane scrollPane = new JScrollPane(txtArea);
                scrollPane.setPreferredSize(new Dimension(300, 250));
                
                JOptionPane.showMessageDialog(this, scrollPane, "🎟️ Satın Aldığım Biletler", JOptionPane.PLAIN_MESSAGE);
            }
        });

        btnCikis.addActionListener(e -> {
            VeriDeposu.aktifKullanici = null; 
            new GirisEkrani().setVisible(true);
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
