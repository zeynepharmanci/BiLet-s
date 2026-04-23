package BiLets;

public class Konser extends Event {
    private String sanatci;
    private String muzikturu;
    
    public Konser(String eventname, String city,double price,boolean[][] seats,String sanatci,String muzikturu){
        super(eventname, city,price, seats);
        this.sanatci=sanatci;
        this.muzikturu= muzikturu;
    }
    
    public String getSanatci() {
        return sanatci;
    }

    public void setSanatci(String sanatci) {
        ExceptionClass.kontrolEtGenelMetin(sanatci, "Sanatçı");
        this.sanatci = sanatci.trim();
    }

    public String getMuzikTuru() {
        return muzikturu;
    }

    public void setMuzikTuru(String muzikTuru) {
        ExceptionClass.kontrolEtGenelMetin(muzikTuru, "Müzik Türü");
        this.muzikturu = muzikTuru.trim();
    }
}
   
