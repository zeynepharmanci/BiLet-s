package BiLets;

public class Tiyatro extends Event {
    private int perdeSayisi;
    private String oyuncuKadrosu;
    private String type;
    public Tiyatro(String eventname, String city,double price,boolean[][] seats,
            int perdeSayisi,String oyuncuKadrosu ,String type){
        super(eventname, city,price, seats);
        this.perdeSayisi = perdeSayisi;
        this.oyuncuKadrosu = oyuncuKadrosu.trim();
        this.type = type.trim();
    }
   
    public int getPerdeSayisi() {
        return perdeSayisi;
    }
    
    public void setPerdeSayisi(int perdeSayisi) {
        if (perdeSayisi <= 0) {
            throw new IllegalArgumentException("Perde sayısı 0'dan büyük olmalıdır!");
        }
        this.perdeSayisi = perdeSayisi;
    }
    public String getOyuncuKadrosu() {
        return oyuncuKadrosu;
    }

    public void setOyuncuKadrosu(String oyuncuKadrosu) {
        ExceptionClass.kontrolEtGenelMetin(oyuncuKadrosu, "Oyuncu Kadrosu");
        this.oyuncuKadrosu = oyuncuKadrosu.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        ExceptionClass.kontrolEtGenelMetin(type, "Oyun Türü");
        this.type = type.trim();
    }
}
