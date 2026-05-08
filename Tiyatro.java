/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

import java.io.Serializable;

public class Tiyatro extends Event implements Serializable{
    private int perdeSayisi;
    private String oyuncuKadrosu;
    private String type;
    public Tiyatro(String eventname, String city,double price,boolean[][] seats,
            int string,String oyuncuKadrosu ,String type){
        super(eventname, city,price, seats);
        this.perdeSayisi = string;
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