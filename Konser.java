/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

import java.io.Serializable;

public class Konser extends Event implements Serializable{
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
