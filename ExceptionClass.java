/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BiLets;

    public class ExceptionClass {
    public static void kontrolEtIsimSoyisim(String metin, String alanAdi) {
        if (metin == null || metin.trim().isEmpty()) {
            throw new IllegalArgumentException(alanAdi + " alanı boş bırakılamaz.");
        }

        String regex = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$";
        if (!metin.matches(regex)) {
            throw new IllegalArgumentException(alanAdi + " sadece harflerden oluşmalıdır.");
        }
    }

    public static int kontrolEtYas(String yasMetni) {
        if (yasMetni == null || yasMetni.trim().isEmpty()) {
            throw new IllegalArgumentException("Yaş alanı boş bırakılamaz.");
        }
        
        int yas;
        try {
            yas = Integer.parseInt(yasMetni.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Lütfen yaşınızı sadece tam sayı olarak giriniz (Örn: 20).");
        }

        return kontrolEtYas(yas); 
    }

        public static int kontrolEtYas(int yas) {
         if (yas < 13 || yas > 120) {
            throw new IllegalArgumentException("Lütfen geçerli bir yaş giriniz.");
        }
        return yas;
    }
    public static void kontrolEtEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("E-mail alanı boş bırakılamaz.");
        }
        
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Lütfen geçerli bir e-mail adresi giriniz.");
        }
    }
    public static void kontrolEtTelefon(String telefon) {
        if (telefon == null || telefon.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefon numarası boş bırakılamaz.");
        }

        if (!telefon.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Telefon numarası 10 haneli olmalı ve sadece rakam içermelidir (Başında 0 olmadan).");
        }
    }

    public static void kontrolEtSifre(String sifre) {
        if (sifre == null || sifre.trim().isEmpty()) {
            throw new IllegalArgumentException("Şifre alanı boş bırakılamaz.");
        }
        if (sifre.length() < 8 || !sifre.matches(".*\\d.*") || !sifre.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("Şifre en az 8 karakter olmalı, harf ve rakam içermelidir.");
        }
    }
    public static void kontrolEtEtkinlikAdi(String etkinlikAdi) {
        if (etkinlikAdi == null || etkinlikAdi.trim().isEmpty()) {
            throw new IllegalArgumentException("Etkinlik adı boş bırakılamaz.");
        }
    }

    public static void kontrolEtSehir(String sehir) {
        if (sehir == null || sehir.trim().isEmpty()) {
            throw new IllegalArgumentException("Şehir alanı boş bırakılamaz.");
        }

        String regex = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$";
        if (!sehir.matches(regex)) {
            throw new IllegalArgumentException("Şehir adı sadece harflerden oluşmalıdır.");
        }
    }

    public static void kontrolEtFiyat(double fiyat) {
        if (fiyat < 0) {
            throw new IllegalArgumentException("Etkinlik fiyatı 0'dan küçük (negatif) olamaz. Girilen: " + fiyat);
        }
    }

    public static void kontrolEtKoltuklar(boolean[][] seats) {
        if (seats == null || seats.length == 0 || seats[0].length == 0) {
            throw new IllegalArgumentException("Koltuk düzeni geçersiz veya oluşturulmamış.");
        }
    }

    public static void kontrolEtNesne(Object nesne, String nesneAdi) {
        if (nesne == null) {
            throw new IllegalArgumentException(nesneAdi + " bilgisi boş olamaz. Geçerli bir kayıt seçilmelidir.");
        }
    }

    public static void kontrolEtGenelMetin(String metin, String alanAdi) {
        if (metin == null || metin.trim().isEmpty()) {
            throw new IllegalArgumentException(alanAdi + " alanı boş bırakılamaz.");
        }
    }
}
