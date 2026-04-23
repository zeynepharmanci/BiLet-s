
package BiLets;

    public class ExceptionClass {
    // 1. İsim ve Soyisim Kontrolü
    // (İkisi de aynı kurala tabi olduğu için tek metotla hallediyoruz)
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
    // 2. Yaş Kontrolü
    public static void kontrolEtYas(int yas) {
        if (yas < 13 || yas > 120) {
            throw new IllegalArgumentException("Sisteme kayıt olmak için 13 yaşından büyük olmalısınız.");
        }
    }

    // 3. E-mail Kontrolü
    public static void kontrolEtEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("E-mail alanı boş bırakılamaz.");
        }
        
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Lütfen geçerli bir e-mail adresi giriniz.");
        }
    }

    // 4. Telefon Numarası Kontrolü
    public static void kontrolEtTelefon(String telefon) {
        if (telefon == null || telefon.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefon numarası boş bırakılamaz.");
        }
        
        // Sadece rakamlardan oluşan 10 haneli numara kontrolü (Örn: 5551234567)
        if (!telefon.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Telefon numarası 10 haneli olmalı ve sadece rakam içermelidir (Başında 0 olmadan).");
        }
    }

    // 5. Şifre Kontrolü
    public static void kontrolEtSifre(String sifre) {
        if (sifre == null || sifre.trim().isEmpty()) {
            throw new IllegalArgumentException("Şifre alanı boş bırakılamaz.");
        }
        
        // En az 8 karakter, 1 harf ve 1 rakam içerip içermediğini kontrol eder
        if (sifre.length() < 8 || !sifre.matches(".*\\d.*") || !sifre.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("Şifre en az 8 karakter olmalı, harf ve rakam içermelidir.");
        }
    }
    // --- EVENT (ETKİNLİK) SINIFI KONTROLLERİ ---

    // 6. Etkinlik Adı Kontrolü
    public static void kontrolEtEtkinlikAdi(String etkinlikAdi) {
        if (etkinlikAdi == null || etkinlikAdi.trim().isEmpty()) {
            throw new IllegalArgumentException("Etkinlik adı boş bırakılamaz.");
        }
        // Not: Etkinlik adında sayı veya sembol olabilir (Örn: "Rock Fest 2024!"). 
        // Bu yüzden sadece boş mu diye kontrol etmek yeterlidir.
    }

    // 7. Şehir Kontrolü
    public static void kontrolEtSehir(String sehir) {
        if (sehir == null || sehir.trim().isEmpty()) {
            throw new IllegalArgumentException("Şehir alanı boş bırakılamaz.");
        }
        
        // Şehir isimleri sadece harflerden (ve boşluklardan) oluşmalıdır.
        String regex = "^[a-zA-ZçÇğĞıİöÖşŞüÜ\\s]+$";
        if (!sehir.matches(regex)) {
            throw new IllegalArgumentException("Şehir adı sadece harflerden oluşmalıdır.");
        }
    }

    // 8. Fiyat Kontrolü
    public static void kontrolEtFiyat(double fiyat) {
        if (fiyat < 0) {
            throw new IllegalArgumentException("Etkinlik fiyatı 0'dan küçük (negatif) olamaz. Girilen: " + fiyat);
        }
    }

    // 9. Koltuk Matrisi Kontrolü
    public static void kontrolEtKoltuklar(boolean[][] seats) {
        // Matrisin hiç oluşturulmaması (null) veya 0 satır/0 sütun ile oluşturulması hatadır.
        if (seats == null || seats.length == 0 || seats[0].length == 0) {
            throw new IllegalArgumentException("Koltuk düzeni geçersiz veya oluşturulmamış.");
        }
    }
    // ==========================================
    // --- TICKET (BİLET) SINIFI KONTROLLERİ ---
    // ==========================================

    // 10. Nesne (Object) Kontrolü (Müşteri ve Etkinlik null olamaz)
    public static void kontrolEtNesne(Object nesne, String nesneAdi) {
        if (nesne == null) {
            throw new IllegalArgumentException(nesneAdi + " bilgisi boş (null) olamaz. Geçerli bir kayıt seçilmelidir.");
        }
    }

    // 11. Genel Metin Kontrolü (Bilet kodu, Koltuk No vb. için)
    // (Bilet kodunda ve koltukta sayı/harf karışık olabileceği için sadece boşluk kontrolü yapıyoruz)
    public static void kontrolEtGenelMetin(String metin, String alanAdi) {
        if (metin == null || metin.trim().isEmpty()) {
            throw new IllegalArgumentException(alanAdi + " alanı boş bırakılamaz.");
        }
    }
}