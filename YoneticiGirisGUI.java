package BiLets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YoneticiGirisGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtEmail;
    private JPasswordField txtSifre;
    private JButton btnGiris;
    private JButton btnGeri;

    public YoneticiGirisGUI() {
        setTitle("BiLets - Yönetici Girişi");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(255, 240, 245));

        JPanel pnlMerkez = new JPanel(new GridLayout(4, 1, 10, 15));
        pnlMerkez.setBackground(Color.WHITE); 
        pnlMerkez.setPreferredSize(new Dimension(350, 350));

        pnlMerkez.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2, true),
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));

        JLabel lblBaslik = new JLabel("YÖNETİCİ GİRİŞİ", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblBaslik.setForeground(new Color(255, 0, 127));

        JPanel pnlEmail = new JPanel(new BorderLayout(0, 5));
        pnlEmail.setOpaque(false);
        pnlEmail.add(new JLabel("E-Mail:"), BorderLayout.NORTH);
        txtEmail = new JTextField();
        pnlEmail.add(txtEmail, BorderLayout.CENTER);

        JPanel pnlSifre = new JPanel(new BorderLayout(0, 5));
        pnlSifre.setOpaque(false);
        pnlSifre.add(new JLabel("Şifre:"), BorderLayout.NORTH);
        txtSifre = new JPasswordField();
        pnlSifre.add(txtSifre, BorderLayout.CENTER);

        JPanel pnlButonlar = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlButonlar.setOpaque(false);
        
        btnGeri = new JButton("<- Geri");
        btnGiris = new JButton("Giriş Yap");

        butonStiliUygula(btnGiris, new Color(255, 0, 127), Color.WHITE);
        butonStiliUygula(btnGeri, Color.LIGHT_GRAY, Color.BLACK);

        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnGiris);

        pnlMerkez.add(lblBaslik);
        pnlMerkez.add(pnlEmail);
        pnlMerkez.add(pnlSifre);
        pnlMerkez.add(pnlButonlar);

        add(pnlMerkez);

        btnGeri.addActionListener(e -> {
            new GirisEkrani().setVisible(true);
            this.dispose();
        });

        btnGiris.addActionListener(e -> {
            String email = txtEmail.getText(); 
            String sifre = new String(txtSifre.getPassword());  
          
            if (email.equals("admin@gazi.com") && sifre.equals("1234")) {
                JOptionPane.showMessageDialog(null, "Giriş Başarılı! Yönetici Paneline Yönlendiriliyorsunuz.");
                new YoneticiPaneliGUI().setVisible(true); 
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Hata: Geçersiz yönetici e-mail veya şifresi!", "Giriş Başarısız", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void butonStiliUygula(JButton btn, Color arkaPlan, Color yaziRengi) {
        btn.setBackground(arkaPlan);
        btn.setForeground(yaziRengi);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setPreferredSize(new Dimension(100, 35));
    }
}
