package BiLets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GirisEkrani extends JFrame {

    public GirisEkrani() {
        setTitle("BiLets - Hoşgeldiniz");
        setSize(500, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showAnaGiris();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private JPanel cerceveliPanelUret(int satir, int sutun) {
        JPanel pnlFrame = new JPanel(new GridLayout(satir, sutun, 10, 15));
        pnlFrame.setBackground(Color.WHITE); 
        pnlFrame.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 0, 127), 2, true),
            BorderFactory.createEmptyBorder(30, 40, 30, 40)
        ));
        return pnlFrame;
    }

    private void ekraniHazirla() {
        getContentPane().removeAll();
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(255, 240, 245));
    }

    public void showAnaGiris() {
        ekraniHazirla();
        setTitle("BiLets - Hoşgeldiniz");

        JPanel pnlMerkez = cerceveliPanelUret(3, 1);
        pnlMerkez.setPreferredSize(new Dimension(350, 250));

        JLabel lblBaslik = new JLabel("HOŞGELDİNİZ", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblBaslik.setForeground(new Color(255, 0, 127));

        JButton btnYonetici = new JButton("Yönetici Girişi");
        JButton btnKullanici = new JButton("Kullanıcı Girişi");
        
        butonStiliUygula(btnYonetici);
        butonStiliUygula(btnKullanici);

        btnKullanici.addActionListener(e -> showKullaniciGiris());
        btnYonetici.addActionListener(e -> showYoneticiGiris());

        pnlMerkez.add(lblBaslik);
        pnlMerkez.add(btnYonetici);
        pnlMerkez.add(btnKullanici);

        add(pnlMerkez);
        updateUI();
    }

    private void showKullaniciGiris() {
        ekraniHazirla();
        setTitle("Kullanıcı Girişi");

        JPanel pnlMerkez = cerceveliPanelUret(7, 1);
        pnlMerkez.setPreferredSize(new Dimension(350, 420)); 

        JLabel lblBaslik = new JLabel("KULLANICI GİRİŞİ", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblBaslik.setForeground(new Color(255, 0, 127));

        JTextField txtMail = new JTextField();
        JPasswordField txtSifre = new JPasswordField();
        JButton btnGiris = new JButton("Giriş Yap");
        JButton btnUyeOlGit = new JButton("Yeni Üyelik Oluştur");
        JButton btnGeri = new JButton("<- Ana Menü");

        butonStiliUygula(btnGiris);
        butonStiliUygula(btnUyeOlGit);
        butonStiliUygula(btnGeri);
        btnGeri.setBackground(Color.LIGHT_GRAY);
        btnGeri.setForeground(Color.BLACK);

        btnGiris.addActionListener(e -> {
            String email = txtMail.getText().trim();
            String sifre = new String(txtSifre.getPassword());
            Person k = VeriDeposu.sistemeGirisYap(email, sifre);
            
            if (k != null) {
                VeriDeposu.aktifKullanici = k; 
                new KullaniciPaneli().setVisible(true); 
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Hatalı e-mail veya şifre!");
            }
        });

        btnUyeOlGit.addActionListener(e -> showUyeOl());
        btnGeri.addActionListener(e -> showAnaGiris());

        pnlMerkez.add(lblBaslik);
        pnlMerkez.add(new JLabel("E-Mail:")); 
        pnlMerkez.add(txtMail);
        pnlMerkez.add(new JLabel("Şifre: ")); 
        pnlMerkez.add(txtSifre);
        
        JPanel pnlButonlar = new JPanel(new GridLayout(1, 2, 10, 0));
        pnlButonlar.setOpaque(false);
        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnGiris);
        
        pnlMerkez.add(pnlButonlar); 
        pnlMerkez.add(btnUyeOlGit); 

        add(pnlMerkez);
        updateUI();
    }

    private void showUyeOl() {
        ekraniHazirla();
        setTitle("Yeni Üyelik");

        JPanel pnlMerkez = cerceveliPanelUret(8, 2);
        pnlMerkez.setPreferredSize(new Dimension(450, 480)); 

        JTextField tIsim = new JTextField(); JTextField tSoy = new JTextField();
        JTextField tYas = new JTextField(); JTextField tMail = new JTextField();
        JTextField tTel = new JTextField(); JPasswordField tSifre = new JPasswordField();
        
        JButton btnKaydet = new JButton("Kayıt Ol");
        JButton btnIptal = new JButton("<- İptal");

        butonStiliUygula(btnKaydet);
        butonStiliUygula(btnIptal);
        btnIptal.setBackground(Color.LIGHT_GRAY);
        btnIptal.setForeground(Color.BLACK);

        btnKaydet.addActionListener(e -> {
            try {
                ExceptionClass.kontrolEtIsimSoyisim(tIsim.getText(), "İsim");
                ExceptionClass.kontrolEtIsimSoyisim(tSoy.getText(), "Soyisim");
                int yas = ExceptionClass.kontrolEtYas(tYas.getText());
                String email = tMail.getText().trim(); 
                ExceptionClass.kontrolEtEmail(email);
                ExceptionClass.kontrolEtTelefon(tTel.getText());
                ExceptionClass.kontrolEtSifre(new String(tSifre.getPassword()));

                Kullanici yeni = new Kullanici(tIsim.getText(), tSoy.getText(), yas, 
                                               email, tTel.getText(), new String(tSifre.getPassword()));

                VeriDeposu.kullaniciListesi.add(yeni);
                new DosyaYonetimi().kullaniciKaydet(yeni);
                
                JOptionPane.showMessageDialog(this, "Üyelik oluşturuldu! Giriş yapabilirsiniz.");
                showKullaniciGiris(); 
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnIptal.addActionListener(e -> showKullaniciGiris());

        pnlMerkez.add(new JLabel("İsim: ")); pnlMerkez.add(tIsim); 
        pnlMerkez.add(new JLabel("Soyisim:")); pnlMerkez.add(tSoy);
        pnlMerkez.add(new JLabel("Yaş:")); pnlMerkez.add(tYas); 
        pnlMerkez.add(new JLabel("E-Mail:")); pnlMerkez.add(tMail);
        pnlMerkez.add(new JLabel("Telefon:")); pnlMerkez.add(tTel); 
        pnlMerkez.add(new JLabel("Şifre:")); pnlMerkez.add(tSifre);
        pnlMerkez.add(new JLabel("")); pnlMerkez.add(new JLabel("")); 
        pnlMerkez.add(btnIptal); pnlMerkez.add(btnKaydet);

        add(pnlMerkez);
        updateUI();
    }

    private void showYoneticiGiris() {
        new YoneticiGirisGUI().setVisible(true);
        this.dispose();
    }

    private void butonStiliUygula(JButton btn) {
        btn.setBackground(new Color(255, 0, 127)); 
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    private void updateUI() {
        revalidate();
        repaint();
        setVisible(true);
    }
}
