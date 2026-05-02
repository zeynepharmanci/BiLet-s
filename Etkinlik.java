package BiLets;

public class Etkinlik {
    private String isim;
    private String mekan;
    private String sehir;
    private String fiyat;
    private String kategori; // "Konser", "Sinema", "Tiyatro" vb.

    public Etkinlik(String isim, String mekan, String sehir, String fiyat, String kategori) {
        this.isim = isim;
        this.mekan = mekan;
        this.sehir = sehir;
        this.fiyat = fiyat;
        this.kategori = kategori;
    }

    // Bilgileri geri almak için (Getter)
    public String getIsim() { return isim; }
    public String getMekan() { return mekan; }
    public String getSehir() { return sehir; }
    public String getFiyat() { return fiyat; }
    public String getKategori() { return kategori; }
}
