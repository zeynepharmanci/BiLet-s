package BiLets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OdemeEkrani extends JFrame {
    
    public OdemeEkrani(double tutar, ArrayList<String> koltuklar, JFrame koltukEkrani) {
        setTitle("BiLets - Güvenli Ödeme");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        JPanel pnlOzet = new JPanel(new GridLayout(2, 1));
        pnlOzet.setBackground(new Color(255, 240, 245));
        pnlOzet.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel lblTutar = new JLabel("Toplam Tutar: " + tutar + " TL");
        lblTutar.setFont(new Font("Segoe UI", Font.BOLD, 18));
        JLabel lblKoltuk = new JLabel("Koltuklar: " + String.join(", ", koltuklar));
        
        pnlOzet.add(lblTutar);
        pnlOzet.add(lblKoltuk);
        add(pnlOzet, BorderLayout.NORTH);

        JPanel pnlForm = new JPanel(new GridLayout(8, 1, 5, 5));
        pnlForm.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JTextField txtSahibi = new JTextField();
        JTextField txtKartNo = new JTextField(); 
        JTextField txtSKT = new JTextField();
        JTextField txtCVV = new JTextField();

        pnlForm.add(new JLabel("Kart Sahibi Adý Soyadý:"));
        pnlForm.add(txtSahibi);
        pnlForm.add(new JLabel("Kart Numarasý (16 Hane):"));
        pnlForm.add(txtKartNo);
        pnlForm.add(new JLabel("Son Kullanma Tarihi (AA/YY):"));
        pnlForm.add(txtSKT);
        pnlForm.add(new JLabel("CVV:"));
        pnlForm.add(txtCVV);

        add(pnlForm, BorderLayout.CENTER);

        JPanel pnlAlt = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        
        JButton btnIptal = new JButton("Geri Dön");
        btnIptal.addActionListener(e -> {
            koltukEkrani.setVisible(true);
            this.dispose();
        });

        JButton btnOde = new JButton("Ödemeyi Onayla");
        btnOde.setBackground(new Color(34, 139, 34));
        btnOde.setForeground(Color.WHITE);
        btnOde.setPreferredSize(new Dimension(150, 40));

        btnOde.addActionListener(e -> {
            // Basit bir doðrulama
            if (txtKartNo.getText().length() < 16 || txtCVV.getText().length() < 3) {
                JOptionPane.showMessageDialog(this, "Lütfen kart bilgilerini eksiksiz giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ödemeniz baþarýyla alýndý!\nÝyi eðlenceler dileriz.", "Baþarýlý", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0); 
            }
        });

        pnlAlt.add(btnIptal);
        pnlAlt.add(btnOde);
        add(pnlAlt, BorderLayout.SOUTH);

        setVisible(true);
    }
}
