package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikGuncelleGUI extends JFrame {

    private JComboBox<String> cmbMevcutEtkinlikler;
    private JPanel pnlDinamikGuncelleme;
    private JTextField txtAd, txtSehir, txtFiyat;

    public EtkinlikGuncelleGUI() {
        setTitle("BiLet's - Etkinlik Güncelle (Factory Pattern)");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(255, 240, 245));

        JPanel pnlSecim = new JPanel(new FlowLayout());
        pnlSecim.setBorder(BorderFactory.createTitledBorder("Düzenlenecek Etkinlik"));
        pnlSecim.add(new JLabel("Etkinlik Seç:"));

        cmbMevcutEtkinlikler = new JComboBox<>(new String[]{"Seçiniz...", "[Sinema] Inception", "[Tiyatro] Romeo ve Juliet"});
        pnlSecim.add(cmbMevcutEtkinlikler);
        add(pnlSecim, BorderLayout.NORTH);

        JPanel pnlMerkez = new JPanel(new BorderLayout());

        JPanel pnlOrtak = new JPanel(new GridLayout(3, 2, 10, 10));
        pnlOrtak.setBorder(BorderFactory.createTitledBorder("Genel Bilgiler"));
        pnlOrtak.add(new JLabel("Etkinlik Adı:"));
        txtAd = new JTextField();
        pnlOrtak.add(txtAd);
        pnlOrtak.add(new JLabel("Şehir:"));
        txtSehir = new JTextField();
        pnlOrtak.add(txtSehir);
        pnlOrtak.add(new JLabel("Fiyat (TL):"));
        txtFiyat = new JTextField();
        pnlOrtak.add(txtFiyat);
        
        pnlMerkez.add(pnlOrtak, BorderLayout.NORTH);

        pnlDinamikGuncelleme = new JPanel(new BorderLayout());
        pnlMerkez.add(pnlDinamikGuncelleme, BorderLayout.CENTER);
        
        add(pnlMerkez, BorderLayout.CENTER);

        JButton btnGuncelle = new JButton("Değişiklikleri Kaydet");
        btnGuncelle.setPreferredSize(new Dimension(200, 40));
        btnGuncelle.setBackground(new Color(0, 102, 204));
        btnGuncelle.setForeground(Color.WHITE);
        add(btnGuncelle, BorderLayout.SOUTH);

        cmbMevcutEtkinlikler.addActionListener(e -> {
            String secim = (String) cmbMevcutEtkinlikler.getSelectedItem();
            pnlDinamikGuncelleme.removeAll();

            if (secim.startsWith("[Sinema]")) {
                txtAd.setText("Inception");
                txtSehir.setText("Ankara");
                txtFiyat.setText("150.0");
                pnlDinamikGuncelleme.add(GuncellemeFormFabrikasi.formUret("Sinema", "C. Nolan", "Evet"), BorderLayout.CENTER);
            } 
            else if (secim.startsWith("[Tiyatro]")) {
                txtAd.setText("Romeo ve Juliet");
                txtSehir.setText("İstanbul");
                txtFiyat.setText("200.0");
                pnlDinamikGuncelleme.add(GuncellemeFormFabrikasi.formUret("Tiyatro", "W. Shakespeare", "2"), BorderLayout.CENTER);
            }

            pnlDinamikGuncelleme.revalidate();
            pnlDinamikGuncelleme.repaint();
        });

        btnGuncelle.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Güncelleme başarılı!");
            this.dispose();
        });
    }
    static class GuncellemeFormFabrikasi {
        public static JPanel formUret(String tur, String veri1, String veri2) {
            JPanel pnl = new JPanel(new GridLayout(2, 2, 10, 10));
            pnl.setBorder(BorderFactory.createTitledBorder("Özel Bilgiler (" + tur + ")"));

            switch (tur) {
                case "Sinema":
                    pnl.add(new JLabel("Yönetmen:"));
                    pnl.add(new JTextField(veri1));
                    pnl.add(new JLabel("3D Seçeneği:"));
                    JCheckBox chk3D = new JCheckBox("Evet, 3D uyumlu");
                    chk3D.setSelected(veri2.equals("Evet"));
                    pnl.add(chk3D);
                    return pnl;

                case "Tiyatro":
                    pnl.add(new JLabel("Yazar:"));
                    pnl.add(new JTextField(veri1));
                    pnl.add(new JLabel("Perde Sayısı:"));
                    pnl.add(new JTextField(veri2));
                    return pnl;

                default:
                    return null;
            }
        }
    }
}