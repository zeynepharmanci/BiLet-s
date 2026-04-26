package BiLets;

public class Kullanici extends Person {
    private String kartnumarasi;
    private String skt;
    private String cvv;

    public String getSkt() {
        return skt;
    }

    public void setSkt(String skt) {
        this.skt = skt;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
         ExceptionClass.kontrolEtGenelMetin(cvv,"CVV");
        this.cvv = cvv;
    }
    public Kullanici(String name, String surname, int age, String email, String phonenumber,String password){
         super(name,surname,age,email,phonenumber,password);
    }

    public String getKartnumarasi() {
        return kartnumarasi;
    }

    public void setKartnumarasi(String kartnumarasi) {
        ExceptionClass.kontrolEtGenelMetin(kartnumarasi,"Kart Numarası");
        this.kartnumarasi = kartnumarasi;
    }
    
}

