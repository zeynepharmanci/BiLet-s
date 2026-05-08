package BiLets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GirisEkrani extends JFrame {

    public GirisEkrani() {
        showAnaGiris();
    }

    public void showAnaGiris() {
        getContentPane().removeAll();
        setTitle("BiLets - Hoşgeldiniz");
        setSize(400, 500);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(255, 240, 245));

        JPanel pnlMerkez = new JPanel(new GridLayout(3, 1, 10, 20));
        pnlMerkez.setOpaque(false);

        JLabel lblBaslik = new JLabel("HOŞGELDİNİZ", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 26));

        JButton btnYonetici = new JButton("Yönetici Girişi");
        JButton btnKullanici = new JButton("Kullanıcı Girişi");

        btnKullanici.addActionListener(e -> showKullaniciGiris());
        btnYonetici.addActionListener(e -> showYoneticiGiris());

        pnlMerkez.add(lblBaslik);
        pnlMerkez.add(btnYonetici);
        pnlMerkez.add(btnKullanici);

        add(pnlMerkez);
        updateUI();
    }

    private void showKullaniciGiris() {
        getContentPane().removeAll();
        setTitle("Kullanıcı Girişi");
        setLayout(new GridLayout(7, 1, 10, 10));
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JTextField txtMail = new JTextField();
        JPasswordField txtSifre = new JPasswordField();
        JButton btnGiris = new JButton("Giriş Yap");
        JButton btnUyeOlGit = new JButton("Üye Ol");
        JButton btnGeri = new JButton("<- Geri");

        btnGiris.addActionListener(e -> {
            String email = txtMail.getText();
            String sifre = new String(txtSifre.getPassword());
            Person k = VeriDeposu.sistemeGirisYap(email, sifre);
            
            if (k != null) {
                VeriDeposu.aktifKullanici = k; 
                new KullaniciPaneli(); 
                this.dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Hatalı e-mail veya şifre!");
            }
        });

        btnUyeOlGit.addActionListener(e -> showUyeOl());
        btnGeri.addActionListener(e -> showAnaGiris());

        add(new JLabel("E-Mail:")); add(txtMail);
        add(new JLabel("Şifre: ")); add(txtSifre);
        add(btnGiris); add(btnUyeOlGit); add(btnGeri);

        updateUI();
    }

    private void showUyeOl() {
        getContentPane().removeAll();
        setTitle("Yeni Üyelik");
        setLayout(new GridLayout(8, 2, 5, 10));
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JTextField tIsim = new JTextField(); JTextField tSoy = new JTextField();
        JTextField tYas = new JTextField(); JTextField tMail = new JTextField();
        JTextField tTel = new JTextField(); JPasswordField tSifre = new JPasswordField();
        
        JButton btnKaydet = new JButton("Kayıt Ol");
        JButton btnIptal = new JButton("İptal");

        btnKaydet.addActionListener(e -> {
            try {
                // Hata kontrolleri
                ExceptionClass.kontrolEtIsimSoyisim(tIsim.getText(), "İsim");
                ExceptionClass.kontrolEtIsimSoyisim(tSoy.getText(), "Soyisim");
                int yas = Integer.parseInt(tYas.getText());
                ExceptionClass.kontrolEtYas(yas);
                
                // Sağdan soldan yanlışlıkla bırakılan boşlukları temizleyerek (trim) alıyoruz
                String email = tMail.getText().trim(); 
                
                ExceptionClass.kontrolEtEmail(email);
                ExceptionClass.kontrolEtTelefon(tTel.getText());
                ExceptionClass.kontrolEtSifre(new String(tSifre.getPassword()));

                // Yeni kullanıcıyı oluştur (Email boşluksuz gidiyor)
                Kullanici yeni = new Kullanici(tIsim.getText(), tSoy.getText(), yas, 
                                               email, tTel.getText(), new String(tSifre.getPassword()));
                
                // 1. CANLI HAFIZAYA EKLE (Person.uyeOl yerine bunu kullanıyoruz!)
                VeriDeposu.kullaniciListesi.add(yeni);
                
                // 2. DOSYAYA KALICI OLARAK KAYDET
                new DosyaYönetimi().kullaniciKaydet(yeni);
                
                JOptionPane.showMessageDialog(this, "Üyelik oluşturuldu! Giriş yapabilirsiniz.");
                showKullaniciGiris(); // Giriş ekranına dön
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnIptal.addActionListener(e -> showKullaniciGiris());

        add(new JLabel("İsim: ")); add(tIsim); add(new JLabel("Soyisim:")); add(tSoy);
        add(new JLabel("Yaş:")); add(tYas); add(new JLabel("E-Mail:")); add(tMail);
        add(new JLabel("Telefon:")); add(tTel); add(new JLabel("Şifre")); add(tSifre);
        add(btnIptal); add(btnKaydet);

        updateUI();
    }
    private void showYoneticiGiris() {
        new YoneticiGirisGUI().setVisible(true);
        this.dispose();
    }


    private void updateUI() {
        revalidate();
        repaint();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
