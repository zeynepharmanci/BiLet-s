package BiLets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YoneticiGirisGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
    private JPasswordField txtSifre;
    private JButton btnGiris;

    public YoneticiGirisGUI() {
        setTitle("Yönetici Giriş Ekranı");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridLayout(3, 2, 10, 10));
        getContentPane().setBackground(new Color(255, 240, 245));

        JLabel lblEmail = new JLabel(" E-Mail:");
        txtEmail = new JTextField(); 
        
        JLabel lblSifre = new JLabel(" Şifre:");
        txtSifre = new JPasswordField();
        
        btnGiris = new JButton("Giriş Yap");

        add(lblEmail);
        add(txtEmail);
        add(lblSifre);
        add(txtSifre);
        add(new JLabel(""));
        add(btnGiris);

        btnGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = txtEmail.getText();
                String sifre = new String(txtSifre.getPassword()); 
                // Bunu alıp normal bir String (yazı) formatına çeviririz.

                if (email.equals("admin@gazi.com") && sifre.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "Giriş Başarılı! Yönetici Paneline Yönlendiriliyorsunuz.");

                    new YoneticiPaneliGUI().setVisible(true); 
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Hata: Geçersiz yönetici e-mail veya şifresi!", "Giriş Başarısız", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
