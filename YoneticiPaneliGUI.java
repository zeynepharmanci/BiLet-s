package BiLets;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class YoneticiPaneliGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tablo; 
    private DefaultTableModel model; 

    public YoneticiPaneliGUI() {
        setTitle("BiLet's - Yönetici Paneli");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(255, 240, 245));
		setExtendedState(JFrame.MAXIMIZED_BOTH);

        JLabel lblBaslik = new JLabel("Sistemdeki Etkinlikler", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(lblBaslik, BorderLayout.NORTH);

        String[] kolonlar = {"Etkinlik Adı", "Tür", "Şehir", "Fiyat"}; 
        model = new DefaultTableModel(kolonlar, 0);
        tablo = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablo); 
        add(scrollPane, BorderLayout.CENTER);
        model.setRowCount(0); 

        for (Event e : VeriDeposu.etkinlikListesi) {
        	if (e == null) continue; 
            String tur = e.getClass().getSimpleName(); 
            String ad = e.getEventname(); 
            String sehir = e.getCity();
            double fiyat = e.getPrice();

            Object[] satir = {ad, tur, sehir, fiyat + " TL"};
            model.addRow(satir); 
        }

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlButonlar.setOpaque(false);

        JButton btnEkle = new JButton("Yeni Etkinlik Ekle");
        JButton btnSil = new JButton("Seçileni Sil");
        JButton btnGuncelle = new JButton("Güncelle");
        JButton btnCikis = new JButton("Çıkış Yap");

        pnlButonlar.add(btnEkle);
        pnlButonlar.add(btnGuncelle);
        pnlButonlar.add(btnSil);
        pnlButonlar.add(btnCikis);
        add(pnlButonlar, BorderLayout.SOUTH);

        btnEkle.addActionListener(e -> {       
            new EtkinlikEkleGUI().setVisible(true); 
            this.dispose(); 
        });

        btnCikis.addActionListener(e -> {
            new YoneticiGirisGUI().setVisible(true);
            this.dispose();
        });

        
        btnGuncelle.addActionListener(e -> {
            int seciliSatir = tablo.getSelectedRow();

            if (seciliSatir == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen güncellemek istediğiniz etkinliği tablodan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            } else {

                Event secilenEvent = VeriDeposu.etkinlikListesi.get(seciliSatir);

                new EtkinlikGuncelleGUI(secilenEvent).setVisible(true);

                this.dispose(); 
            }
        });

        btnSil.addActionListener(e -> {
            new EtkinlikSilGUI().setVisible(true);
        });
    }
}
