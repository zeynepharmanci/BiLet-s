package BiLets;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DetayEkrani extends JFrame {

    public DetayEkrani(Event e, JFrame eskiEkran) {
        setTitle(e.getEventname() + " - Detaylar");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(20, 20));

        getContentPane().setBackground(new Color(255, 240, 245));

        JLabel lblResim = new JLabel("", SwingConstants.CENTER); 
        lblResim.setPreferredSize(new Dimension(400, 250));
        lblResim.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 127), 2));
        lblResim.setOpaque(true);
        lblResim.setBackground(Color.WHITE);

        String kategoriAdi = e.getClass().getSimpleName().toLowerCase();
        try {
            URL resimURL = getClass().getResource("resimler/" + kategoriAdi + ".jpg");
            if (resimURL != null) {
                ImageIcon orijinalIkon = new ImageIcon(resimURL);
                Image boyutlandirilmisResim = orijinalIkon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
                lblResim.setIcon(new ImageIcon(boyutlandirilmisResim));
            } else {
                lblResim.setText(e.getClass().getSimpleName() + " resmi bulunamadı");
            }
        } catch (Exception ex) {
            lblResim.setText("Resim yükleme hatası!");
        }

        JPanel pnlResimUst = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlResimUst.setOpaque(false); 
        pnlResimUst.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        pnlResimUst.add(lblResim);

        add(pnlResimUst, BorderLayout.NORTH);

        JPanel pnlBilgi = new JPanel();
        pnlBilgi.setLayout(new BoxLayout(pnlBilgi, BoxLayout.Y_AXIS));
        pnlBilgi.setOpaque(false);
        pnlBilgi.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));

        JLabel lblBaslik = new JLabel(e.getEventname());
        lblBaslik.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblBaslik.setForeground(new Color(255, 0, 127)); 

        String detayMetni = "<html><br><b>Şehir:</b> " + e.getCity() + 
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
        detayMetni += "</html>";

        JLabel lblDetay = new JLabel(detayMetni);
        lblDetay.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        pnlBilgi.add(lblBaslik);
        pnlBilgi.add(lblDetay);
        add(pnlBilgi, BorderLayout.CENTER);

        JPanel pnlButonlar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        pnlButonlar.setOpaque(false); 
        pnlButonlar.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JButton btnGeri = new JButton("<- Geri Dön");
        btnGeri.setPreferredSize(new Dimension(130, 40));
        btnGeri.setBackground(Color.LIGHT_GRAY);
        btnGeri.setForeground(Color.BLACK);
        btnGeri.setFocusPainted(false);
        btnGeri.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        btnGeri.addActionListener(event -> {
            eskiEkran.setVisible(true); 
            this.dispose(); 
        });

        JButton btnOnayla = new JButton("Koltuk Seç ve Öde");
        btnOnayla.setPreferredSize(new Dimension(180, 40));
        btnOnayla.setBackground(new Color(255, 0, 127));
        btnOnayla.setForeground(Color.WHITE);
        btnOnayla.setFocusPainted(false);
        btnOnayla.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
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
