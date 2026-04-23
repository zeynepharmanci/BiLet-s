package BiLets;

public class Sinema extends Event {
    private String yonetmen;
    private int filmSuresi;
    private String basrolOyuncu;
    private boolean is3D;
    private String filmTuru;
    
    public Sinema(String eventname, String city,double price,boolean[][] seats, String yonetmen
                  ,int filmSuresi, String basrolOyuncu, boolean is3D, String filmTuru){
        super(eventname, city, price, seats);
        this.yonetmen = yonetmen.trim();
        this.filmSuresi = filmSuresi;
        this.basrolOyuncu = basrolOyuncu.trim();
        this.is3D = is3D;
        this.filmTuru = filmTuru.trim();
    }
    @Override
    public double fiyatHesapla() {
        double tabanFiyat = getPrice();
        // Eğer film 3D ise fiyata 50 TL fark ekliyoruz
        if (this.is3D) {
            return (tabanFiyat*1.1); 
        } else {
            return  tabanFiyat; // 3D değilse normal fiyat
        }
    }
    public String getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(String yonetmen) {
        ExceptionClass.kontrolEtGenelMetin(yonetmen, "Yönetmen");
        this.yonetmen = yonetmen.trim();
    }

    public int getFilmSuresi() {
        return filmSuresi;
    }

    public void setFilmSuresi(int filmSuresi) {
        if (filmSuresi <= 0) {
            throw new IllegalArgumentException("Film süresi 0'dan büyük olmalıdır!");
        }
        this.filmSuresi = filmSuresi;
    }

    public String getBasrolOyuncu() {
        return basrolOyuncu;
    }

    public void setBasrolOyuncu(String basrolOyuncu) {
        ExceptionClass.kontrolEtGenelMetin(basrolOyuncu, "Başrol Oyuncusu");
        this.basrolOyuncu = basrolOyuncu.trim();
    }

    public boolean isIs3D() { // boolean değişkenlerin getter'ı "is" ile başlar
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public String getFilmTuru() {
        return filmTuru;
    }

    public void setFilmTuru(String filmTuru) {
        ExceptionClass.kontrolEtGenelMetin(filmTuru, "Film Türü");
        this.filmTuru = filmTuru.trim();
    }
 
}
