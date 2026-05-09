package BiLets;

import javax.swing.*;
import java.awt.*;

public class EtkinlikSilGUI extends JFrame {

    private JComboBox<String> cmbEtkinlikler;

    public EtkinlikSilGUI() {
        setTitle("BiLet's - Etkinlik Sil");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(255, 240, 245));

        JLabel lblBaslik = new JLabel("Sistemden Etkinlik Sil", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblBaslik.setForeground(new Color(153, 0, 0));
        add(lblBaslik, BorderLayout.NORTH);

        JPanel pnlSecim = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        pnlSecim.setOpaque(false);
        pnlSecim.add(new JLabel("Silinecek Etkinliği Seçin:"));

        cmbEtkinlikler = new JComboBox<>();
        cmbEtkinlikler.addItem("Seçiniz...");
        for (Event e : VeriDeposu.etkinlikListesi) {
            cmbEtkinlikler.addItem(e.getEventname() + " (" + e.getClass().getSimpleName() + ")");
        }
        
        cmbEtkinlikler.setPreferredSize(new Dimension(200, 30));
        pnlSecim.add(cmbEtkinlikler);
        add(pnlSecim, BorderLayout.CENTER);

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlButonlar.setOpaque(false);
        
        JButton btnIptal = new JButton("Vazgeç");
        JButton btnSil = new JButton("Kalıcı Olarak Sil");
        btnSil.setBackground(new Color(204, 0, 0));
        btnSil.setForeground(Color.WHITE);

        pnlButonlar.add(btnIptal);
        pnlButonlar.add(btnSil);
        add(pnlButonlar, BorderLayout.SOUTH);

        btnIptal.addActionListener(e -> this.dispose());

        btnSil.addActionListener(e -> {
            int secilenIndex = cmbEtkinlikler.getSelectedIndex();
            if (secilenIndex == 0) {
                JOptionPane.showMessageDialog(this, "Lütfen silmek için bir etkinlik seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String secilenAd = (String) cmbEtkinlikler.getSelectedItem();
            int onay = JOptionPane.showConfirmDialog(this, 
                "'" + secilenAd + "' etkinliğini silmek istediğinize emin misiniz?\nBu işlem geri alınamaz!", 
                "Silme Onayı", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (onay == JOptionPane.YES_OPTION) {
 
                Event silinecekEvent = VeriDeposu.etkinlikListesi.get(secilenIndex - 1); 
                VeriDeposu.etkinlikListesi.remove(silinecekEvent);
                new DosyaYonetimi().verileriKaydet(VeriDeposu.etkinlikListesi);
                
                JOptionPane.showMessageDialog(this, "Etkinlik başarıyla silindi.");
 
                new YoneticiPaneliGUI().setVisible(true);
                this.dispose();
            }
        });
    }
}
