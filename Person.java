package BiLets;

public abstract class Person {
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phonenumber;
    private String password;
    
    public Person(String name, String surname, int age, String email, String phonenumber,String password){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.email=email;
        this.phonenumber=phonenumber;
        this.password=password;
    }
    
 public String girisYap(String girilenEmail, String girilenSifre){
        if (this.email.equals(girilenEmail) && this.password.equals(girilenSifre)) {
            return "Giriş Başarılı! Hoş geldin, " + this.name;
        } else {
            return "Hata: E-mail veya şifre yanlış. Lütfen tekrar deneyin.";
        }
    }
    public String profilGoruntule(){
        String profilBilgisi = "---KULLANICI PROFİLİ---\n" +
                "Ad Soyad: " + this.name + " " + this.surname + "\n" +
                               "Yaş: " + this.age + "\n" +
                               "E-Mail: " + this.email + "\n" +
                               "Telefon: " + this.phonenumber;
        
        return profilBilgisi;
    }
    public String profilGuncelle(String yeniEmail, String yeniTelefon, String yeniSifre){
        this.email=yeniEmail;
        this.phonenumber=yeniTelefon;
        this.password=yeniSifre;
        return "Tebrikler! Profil bilgileriniz başarıyla güncellendi";
    }
    public String cikisYap(){
        return "Sistemden güvenli bir şekilde çıkış yapıldı. Görüşmek üzere, " + this.name + "!";
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
         // ExceptionClass'a soruyoruz. Hata varsa o fırlatacak, yoksa alt satıra geçecek.
    ExceptionClass.kontrolEtIsimSoyisim(name, "İsim");
    this.name = name.trim();
    }

    public void setSurname(String surname) {
        ExceptionClass.kontrolEtIsimSoyisim(surname, "Soyisim");
        this.surname = surname.trim(); 
    }

    public void setAge(int age) {
        ExceptionClass.kontrolEtYas(age);
        this.age = age;
    }

    public void setEmail(String email) {
       ExceptionClass.kontrolEtEmail(email);
       this.email = email.trim();
    }

    public void setPhonenumber(String phonenumber) {
      ExceptionClass.kontrolEtTelefon(phonenumber);
      this.phonenumber = phonenumber.trim();
    }

    public void setPassword(String password) {
      ExceptionClass.kontrolEtSifre(password);
      this.password = password;
    }
}
    
