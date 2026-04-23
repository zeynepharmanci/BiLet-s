package BiLets;

public class StandUp extends Event {
    private String komedyen;
    private int yasSiniri;
    private String gosteriKonusu;
    
    public StandUp(String eventname, String city,double price,boolean[][] seats, 
            String komedyen, int yasSiniri, String gosteriKonusu){
        super(eventname, city, price, seats);
        this.komedyen = komedyen.trim();
        this.yasSiniri = yasSiniri;
        this.gosteriKonusu = gosteriKonusu.trim();
    }
   
   public String getKomedyen() {
        return komedyen;
    }

    public void setKomedyen(String komedyen) {
        ExceptionClass.kontrolEtGenelMetin(komedyen, "Komedyen");
        this.komedyen = komedyen.trim();
    }

    public int getYasSiniri() {
        return yasSiniri;
    }

    public void setYasSiniri(int yasSiniri) {
        if (yasSiniri < 13 || yasSiniri > 21) {
            throw new IllegalArgumentException("Stand-up yaş sınırı geçersiz.");
        }
        this.yasSiniri = yasSiniri;
    }

    public String getGosteriKonusu() {
        return gosteriKonusu;
    }

    public void setGosteriKonusu(String gosteriKonusu) {
        ExceptionClass.kontrolEtGenelMetin(gosteriKonusu, "Gösteri Konusu");
        this.gosteriKonusu = gosteriKonusu.trim();
    }
}
