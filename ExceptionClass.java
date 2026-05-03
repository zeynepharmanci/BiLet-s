
package BiLets;

    public class ExceptionClass {
    //İsim ve Soyisim kontrolü
    public static void kontrolEtIsimSoyisim(String metin, String alanAdi) {
        if (metin == null || metin.trim().isEmpty()) {
            throw new IllegalArgumentException(alanAdi + " alanı boş bırakılamaz.");
        }
        
        // Türkçe karakterler ve boşluk dahil sadece harf kontrolü
        String regex = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$";
        if (!metin.matches(regex)) {
            throw new IllegalArgumentException(alanAdi + " sadece harflerden oluşmalıdır.");
        }
    }
    //Yaş kontrolü
    public static void kontrolEtYas(int yas) {
        if (yas < 13 || yas > 120) {
            throw new IllegalArgumentException("Sisteme kayıt olmak için 13 yaşından büyük olmalısınız.");
        }
    }

    //E-mail kontrolü
    public static void kontrolEtEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("E-mail alanı boş bırakılamaz.");
        }
        
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Lütfen geçerli bir e-mail adresi giriniz.");
        }
    }

    //Telefon numarası kontrolü
    public static void kontrolEtTelefon(String telefon) {
        if (telefon == null || telefon.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefon numarası boş bırakılamaz.");
        }
        
        // Sadece rakamlardan oluşan 10 haneli numara kontrolü 
        if (!telefon.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Telefon numarası 10 haneli olmalı ve sadece rakam içermelidir (Başında 0 olmadan).");
        }
    }

    //Şifre kontrolü
    public static void kontrolEtSifre(String sifre) {
        if (sifre == null || sifre.trim().isEmpty()) {
            throw new IllegalArgumentException("Şifre alanı boş bırakılamaz.");
        }
        
        // En az 8 karakter, 1 harf ve 1 rakam içerip içermediğini kontrol eder
        if (sifre.length() < 8 || !sifre.matches(".*\\d.*") || !sifre.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("Şifre en az 8 karakter olmalı, harf ve rakam içermelidir.");
        }
    }

    //Etkinlik Adı kontrolü
    public static void kontrolEtEtkinlikAdi(String etkinlikAdi) {
        if (etkinlikAdi == null || etkinlikAdi.trim().isEmpty()) {
            throw new IllegalArgumentException("Etkinlik adı boş bırakılamaz.");
        }
       
    }

    //Şehir kontrolü
    public static void kontrolEtSehir(String sehir) {
        if (sehir == null || sehir.trim().isEmpty()) {
            throw new IllegalArgumentException("Şehir alanı boş bırakılamaz.");
        }
        
        // Şehir isimleri sadece harflerden ve boşluklardan oluşmalıdır.
        String regex = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$";
        if (!sehir.matches(regex)) {
            throw new IllegalArgumentException("Şehir adı sadece harflerden oluşmalıdır.");
        }
    }

    //Fiyat kontrolü
    public static void kontrolEtFiyat(double fiyat) {
        if (fiyat < 0) {
            throw new IllegalArgumentException("Etkinlik fiyatı 0'dan küçük (negatif) olamaz. Girilen: " + fiyat);
        }
    }

    // Koltuk Matrisi kontrolü
    public static void kontrolEtKoltuklar(boolean[][] seats) {
        // Matrisin hiç oluşturulmaması (null) veya 0 satır/0 sütun ile oluşturulması hatadır.
        if (seats == null || seats.length == 0 || seats[0].length == 0) {
            throw new IllegalArgumentException("Koltuk düzeni geçersiz veya oluşturulmamış.");
        }
    }

    //Nesne kontrolü 
    public static void kontrolEtNesne(Object nesne, String nesneAdi) {
        if (nesne == null) {
            throw new IllegalArgumentException(nesneAdi + " bilgisi boş (null) olamaz. Geçerli bir kayıt seçilmelidir.");
        }
    }

    //Genel Metin kontrolü 
    
    public static void kontrolEtGenelMetin(String metin, String alanAdi) {
        if (metin == null || metin.trim().isEmpty()) {
            throw new IllegalArgumentException(alanAdi + " alanı boş bırakılamaz.");
        }
    }
}
