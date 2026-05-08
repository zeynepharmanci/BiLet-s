package BiLets;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class YoneticiPaneliGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablo; // Ekranda verileri liste halinde göstereceğimiz tablo bileşeni.
    private DefaultTableModel model; // Tablonun içindeki verileri (satırları ve sütunları) yönetmemizi sağlayan veri modeli.

    public YoneticiPaneliGUI() {
        setTitle("BiLet's - Yönetici Paneli");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Pencerenin sağ üstündeki çarpı (X) tuşuna basıldığında programın tamamen kapanmasını sağlar.
        setLocationRelativeTo(null); // Pencerenin bilgisayar ekranının tam ortasında açılmasını sağlar (null verdiğimiz için).
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(255, 240, 245));

        JLabel lblBaslik = new JLabel("Sistemdeki Etkinlikler", SwingConstants.CENTER);
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(lblBaslik, BorderLayout.NORTH);

        String[] kolonlar = {"Etkinlik Adı", "Tür", "Şehir", "Fiyat"}; // Tablonun en üstünde yazacak olan sütun isimlerini bir dizi (Array) olarak tanımlar.
        model = new DefaultTableModel(kolonlar, 0);
        tablo = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tablo); // Tabloya kaydırma çubuğu (Scroll) ekler ki çok etkinlik eklendiğinde aşağı kaydırabilelim.
        add(scrollPane, BorderLayout.CENTER);
        model.setRowCount(0); // Tabloda önceden kalma eski veriler varsa, üst üste binmesin diye satır sayısını sıfırlayıp temizler.

        for (Event e : VeriDeposu.etkinlikListesi) {
        	if (e == null) continue; // VeriDeposu'ndaki 'etkinlikListesi' içinde bulunan her bir 'Event' (e) için bir döngü başlatır.
            String tur = e.getClass().getSimpleName(); // O anki etkinliğin tam olarak hangi alt sınıftan (Sinema, Konser vb.) üretildiğinin ismini alır.
            String ad = e.getEventname(); 
            String sehir = e.getCity();
            double fiyat = e.getPrice();

            Object[] satir = {ad, tur, sehir, fiyat + " TL"};
            model.addRow(satir); // Hazırlanan bu satırı tablo modeline ekler. Döngü sürdükçe tablo dolar.
        }

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlButonlar.setOpaque(false); // Bu buton panelinin arka planını şeffaf yapar ki alttaki pembe renk görünebilsin.

        JButton btnEkle = new JButton("Yeni Etkinlik Ekle");
        JButton btnSil = new JButton("Seçileni Sil");
        JButton btnGuncelle = new JButton("Güncelle");
        JButton btnCikis = new JButton("Çıkış Yap");

        pnlButonlar.add(btnEkle);
        pnlButonlar.add(btnGuncelle);
        pnlButonlar.add(btnSil);
        pnlButonlar.add(btnCikis);
        add(pnlButonlar, BorderLayout.SOUTH); // Butonların olduğu bu paneli ekranın en altına (SOUTH) yerleştirir.

     // "Yeni Etkinlik Ekle" butonuna tıklandığında ne olacağını belirleyen kod bloğu (Aksiyon).
        btnEkle.addActionListener(e -> {       
            new EtkinlikEkleGUI().setVisible(true); 
            this.dispose(); 
        });
        
     // "Çıkış Yap" butonuna tıklandığında ne olacağını belirler.
        btnCikis.addActionListener(e -> {
            new YoneticiGirisGUI().setVisible(true);
            this.dispose();
        });

        
        btnGuncelle.addActionListener(e -> {
            // 1. Tablodan hangi satırın seçildiğini buluyoruz
            int seciliSatir = tablo.getSelectedRow();
            
            // 2. Eğer kimse seçilmediyse kullanıcıyı uyarıyoruz
            if (seciliSatir == -1) {
                JOptionPane.showMessageDialog(this, "Lütfen güncellemek istediğiniz etkinliği tablodan seçin!", "Uyarı", JOptionPane.WARNING_MESSAGE);
            } else {
                // 3. Seçili satırdaki gerçek nesneyi listeden çekiyoruz
                Event secilenEvent = VeriDeposu.etkinlikListesi.get(seciliSatir);
                
                // 4. Güncelleme ekranını, bu seçtiğimiz nesneyle beraber açıyoruz
                new EtkinlikGuncelleGUI(secilenEvent).setVisible(true);
                
                // 5. Mevcut paneli kapatıyoruz
                this.dispose(); 
            }
        });

        btnSil.addActionListener(e -> {
            new EtkinlikSilGUI().setVisible(true);
        });
    }
}