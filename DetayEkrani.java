package BiLets;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DetayEkrani extends JFrame {

    public DetayEkrani(Event e, JFrame eskiEkran) {
        setTitle(e.getEventname() + " - Detaylar");
        setSize(800, 750); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        getContentPane().setBackground(new Color(255, 240, 245));

        JPanel pnlIcerik = new JPanel();
        pnlIcerik.setLayout(new BoxLayout(pnlIcerik, BoxLayout.Y_AXIS));
        pnlIcerik.setBackground(new Color(255, 240, 245));
        pnlIcerik.setBorder(BorderFactory.createEmptyBorder(20, 50, 30, 50));

        JLabel lblBaslik = new JLabel(e.getEventname());
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 36)); 
        lblBaslik.setForeground(new Color(255, 0, 127)); 
        lblBaslik.setAlignmentX(Component.CENTER_ALIGNMENT); 
        
        pnlIcerik.add(lblBaslik);
        pnlIcerik.add(Box.createVerticalStrut(15)); 

        JLabel lblResim = new JLabel("", SwingConstants.CENTER); 
        lblResim.setPreferredSize(new Dimension(600, 400));
        lblResim.setMaximumSize(new Dimension(600, 400)); 
        lblResim.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 127), 3));
        lblResim.setOpaque(true);
        lblResim.setBackground(Color.WHITE);

        String kategoriAdi = e.getClass().getSimpleName().toLowerCase();
        try {
            URL resimURL = getClass().getResource("resimler/" + kategoriAdi + ".jpg");
            if (resimURL != null) {
                ImageIcon orijinalIkon = new ImageIcon(resimURL);
                Image boyutlandirilmisResim = orijinalIkon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
                lblResim.setIcon(new ImageIcon(boyutlandirilmisResim));
            } else {
                lblResim.setText(e.getClass().getSimpleName() + " resmi bulunamadı");
            }
        } catch (Exception ex) {
            lblResim.setText("Resim yükleme hatası!");
        }

        JPanel pnlResimUst = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlResimUst.setOpaque(false); 
        pnlResimUst.add(lblResim);

        pnlIcerik.add(pnlResimUst);
        pnlIcerik.add(Box.createVerticalStrut(25)); 

        JPanel pnlBilgi = new JPanel();
        pnlBilgi.setLayout(new BoxLayout(pnlBilgi, BoxLayout.Y_AXIS));
        pnlBilgi.setOpaque(false);
        pnlBilgi.setAlignmentX(Component.CENTER_ALIGNMENT);
        pnlBilgi.setBorder(BorderFactory.createEmptyBorder(20, 250, 20, 250));

        String detayMetni = "<html><center><b>Şehir:</b> " + e.getCity() + 
                "<br><b>Tarih & Saat:</b> " + e.getTarih() + // YENİ EKLENEN SATIR
                "<br><b>Taban Fiyat:</b> " + e.getPrice() + " TL<br><br>";

        if (e instanceof Sinema) {
            Sinema s = (Sinema) e;
            detayMetni += "<b>Tür:</b> Sinema (" + s.getFilmTuru() + ")<br>" +
                          "<b>Yönetmen:</b> " + s.getYonetmen() + "<br>" +
                          "<b>Başrol:</b> " + s.getBasrolOyuncu() + "<br>" +
                          "<b>Süre:</b> " + s.getFilmSuresi() + " dk<br>" +
                          "<b>3D Seçeneği:</b> " + (s.isIs3D() ? "Var" : "Yok");
                          
        } else if (e instanceof Konser) {
            Konser k = (Konser) e;
            detayMetni += "<b>Tür:</b> Konser<br>" +
                          "<b>Sanatçı / Grup:</b> " + k.getSanatci() + "<br>" +
                          "<b>Müzik Tarzı:</b> " + k.getMuzikTuru();
                          
        } else if (e instanceof Tiyatro) {
            Tiyatro t = (Tiyatro) e;
            detayMetni += "<b>Tür:</b> Tiyatro (" + t.getType() + ")<br>" +
                          "<b>Yazar / Yönetmen:</b> " + t.getOyuncuKadrosu() + "<br>" +
                          "<b>Perde Sayısı:</b> " + t.getPerdeSayisi();
                          
        } else if (e instanceof StandUp) {
            StandUp st = (StandUp) e;
            detayMetni += "<b>Tür:</b> Stand-Up<br>" +
                          "<b>Komedyen:</b> " + st.getKomedyen() + "<br>" +
                          "<b>Konu:</b> " + st.getGosteriKonusu() + "<br>" +
                          "<b>Yaş Sınırı:</b> +" + st.getYasSiniri();
        }
        detayMetni += "</center></html>";

        JLabel lblDetay = new JLabel(detayMetni);
        lblDetay.setFont(new Font("Segoe UI", Font.PLAIN, 22)); 
        lblDetay.setHorizontalAlignment(SwingConstants.CENTER);
        lblDetay.setAlignmentX(Component.CENTER_ALIGNMENT); 

        pnlBilgi.add(lblDetay);
        pnlIcerik.add(pnlBilgi);

        JScrollPane scrollPane = new JScrollPane(pnlIcerik);
        scrollPane.setBorder(null); 
        scrollPane.getViewport().setBackground(new Color(255, 240, 245));
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); 

        add(scrollPane, BorderLayout.CENTER); 

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 20));
        pnlButonlar.setOpaque(false); 
        pnlButonlar.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JButton btnGeri = new JButton("<- Geri Dön");
        btnGeri.setPreferredSize(new Dimension(160, 50));
        btnGeri.setBackground(Color.LIGHT_GRAY);
        btnGeri.setForeground(Color.BLACK);
        btnGeri.setFocusPainted(false);
        btnGeri.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        btnGeri.addActionListener(event -> {
            eskiEkran.setVisible(true); 
            this.dispose(); 
        });

        JButton btnOnayla = new JButton("Koltuk Seç ve Öde");
        btnOnayla.setPreferredSize(new Dimension(220, 50));
        btnOnayla.setBackground(new Color(255, 0, 127));
        btnOnayla.setForeground(Color.WHITE);
        btnOnayla.setFocusPainted(false);
        btnOnayla.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        btnOnayla.addActionListener(event -> {
            new KoltukSecimEkrani(e.getEventname(), e.getPrice()).setVisible(true);
            this.dispose();
        });

        pnlButonlar.add(btnGeri);
        pnlButonlar.add(btnOnayla);
        
        add(pnlButonlar, BorderLayout.SOUTH); 

        setVisible(true);
    }
}
