package BiLets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class KoltukSecimEkrani extends JFrame {
 
 private ArrayList<String> seciliKoltuklar = new ArrayList<>();
 private double biletFiyati; 
 private JLabel lblOzet;
 private double toplamTutar = 0;
 private JComboBox<String> cmbBiletTuru;

 public KoltukSecimEkrani(String etkinlikAdi, double fiyat) {
     this.biletFiyati = fiyat; 
     
     setTitle(etkinlikAdi + " - Koltuk Seçimi");
     setSize(800, 700);
     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     setLocationRelativeTo(null);
     setLayout(new BorderLayout(10, 10));

     JLabel lblSahne = new JLabel("SAHNE", SwingConstants.CENTER);
     lblSahne.setOpaque(true);
     lblSahne.setBackground(Color.DARK_GRAY);
     lblSahne.setForeground(Color.WHITE);
     lblSahne.setFont(new Font("Segoe UI", Font.BOLD, 20));
     lblSahne.setPreferredSize(new Dimension(800, 50));

     JPanel pnlUst = new JPanel(new BorderLayout());
     pnlUst.add(lblSahne, BorderLayout.NORTH);
     
     JPanel pnlTur = new JPanel(new FlowLayout(FlowLayout.CENTER));
     pnlTur.setBackground(new Color(255, 240, 245));
     pnlTur.add(new JLabel("Bilet Türü Seçiniz: "));
     
     cmbBiletTuru = new JComboBox<>(new String[]{"Yetişkin (Tam Fiyat)", "Genç (%10 İndirim)"});
     cmbBiletTuru.addActionListener(e -> ozetiGuncelle()); 
     pnlTur.add(cmbBiletTuru);
     
     pnlUst.add(pnlTur, BorderLayout.SOUTH);
     add(pnlUst, BorderLayout.NORTH);

     JPanel pnlSalon = new JPanel(new GridLayout(10, 10, 5, 5));
     pnlSalon.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

     ArrayList<String> dahaOnceSatilanlar = VeriDeposu.getDoluKoltuklar().getOrDefault(etkinlikAdi, new ArrayList<>());

     for (int i = 1; i <= 10; i++) {
         for (int j = 1; j <= 10; j++) {
             String koltukNo = (char)(64 + i) + "" + j;
             JButton btnKoltuk = new JButton(koltukNo);
             btnKoltuk.setFocusPainted(false);
             btnKoltuk.setFont(new Font("Segoe UI", Font.PLAIN, 10));

             if (dahaOnceSatilanlar.contains(koltukNo)) {
                 btnKoltuk.setBackground(Color.LIGHT_GRAY);
                 btnKoltuk.setForeground(Color.RED);
                 btnKoltuk.setText("X"); 
                 btnKoltuk.setEnabled(false); 
             } 
             else {
                 btnKoltuk.setBackground(Color.WHITE);
                 btnKoltuk.addActionListener(event -> {
                     if (btnKoltuk.getBackground() == Color.WHITE) {
                         btnKoltuk.setBackground(new Color(255, 0, 127)); 
                         btnKoltuk.setForeground(Color.WHITE);
                         seciliKoltuklar.add(koltukNo);
                     } else {
                         btnKoltuk.setBackground(Color.WHITE);
                         btnKoltuk.setForeground(Color.BLACK);
                         seciliKoltuklar.remove(koltukNo);
                     }
                     ozetiGuncelle();
                 });
             }
             
             pnlSalon.add(btnKoltuk);
         }
     }
     add(pnlSalon, BorderLayout.CENTER);

     JPanel pnlAlt = new JPanel(new BorderLayout());
     pnlAlt.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

     lblOzet = new JLabel("Seçili Koltuklar: - | Toplam: 0 TL");
     lblOzet.setFont(new Font("Segoe UI", Font.BOLD, 16));

     JPanel pnlAksiyon = new JPanel(new FlowLayout(FlowLayout.RIGHT));
     
     JButton btnGeri = new JButton("<- Geri");
     btnGeri.addActionListener(ev -> this.dispose());

     JButton btnOdeme = new JButton("Ödemeye Geç");
     btnOdeme.setBackground(new Color(34, 139, 34)); 
     btnOdeme.setForeground(Color.WHITE);
     btnOdeme.setFocusPainted(false);

     btnOdeme.addActionListener(ev -> {
         if(seciliKoltuklar.isEmpty()) {
             JOptionPane.showMessageDialog(this, "Lütfen en az bir koltuk seçiniz!", "Uyarı", JOptionPane.WARNING_MESSAGE);
         } else {
             
             java.util.HashMap<String, ArrayList<String>> tumDolular = VeriDeposu.getDoluKoltuklar();
             ArrayList<String> buEtkinliginDolulari = tumDolular.getOrDefault(etkinlikAdi, new ArrayList<>());
             
             buEtkinliginDolulari.addAll(seciliKoltuklar); 
             tumDolular.put(etkinlikAdi, buEtkinliginDolulari); 
             
             new DosyaYonetimi().doluKoltuklariKaydet(tumDolular);

             String secilenTur = cmbBiletTuru.getSelectedIndex() == 0 ? "Yetişkin" : "Genç";
             new OdemeEkrani(toplamTutar, seciliKoltuklar, this, secilenTur).setVisible(true);
             this.setVisible(false);
         }
     });

     pnlAksiyon.add(btnGeri);
     pnlAksiyon.add(btnOdeme);

     pnlAlt.add(lblOzet, BorderLayout.WEST);
     pnlAlt.add(pnlAksiyon, BorderLayout.EAST);
     add(pnlAlt, BorderLayout.SOUTH);

     setVisible(true);
 }

 private void ozetiGuncelle() {
     double anlikFiyat = biletFiyati;

     if (cmbBiletTuru.getSelectedIndex() == 1) {
         anlikFiyat = biletFiyati * 0.9;
     }
     
     toplamTutar = seciliKoltuklar.size() * anlikFiyat;
     String koltuklarStr = seciliKoltuklar.isEmpty() ? "-" : String.join(", ", seciliKoltuklar);
     lblOzet.setText("Seçili Koltuklar: " + koltuklarStr + " | Toplam: " + toplamTutar + " TL");
 }
}
