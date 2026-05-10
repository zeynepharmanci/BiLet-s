BiLets - Etkinlik ve Bilet Otomasyon Sistemi

Bu proje, kullanıcıların sinema, konser, tiyatro ve stand-up gösterileri için bilet alabildiği; yöneticilerin ise sistemdeki etkinlikleri yönetebildiği nesne yönelimli (OOP) bir Java Swing masaüstü uygulamasıdır.

## Kullanılan Teknolojiler
* **Dil:** Java
* **Arayüz (GUI):** Java Swing (AWT)
* **Veri Saklama:** Dosya İşlemleri (Serialization `.dat` ve `.csv`)
* **Geliştirme Ortamı:** Eclipse IDE

## Kodu Çalıştırma Talimatları (Nasıl Kurulur?)

Projeyi bilgisayarınızda sorunsuz bir şekilde çalıştırmak için aşağıdaki adımları izleyin:

1. **Projeyi İndirin:** Bu GitHub deposunu bilgisayarınıza klonlayın veya sağ üstteki `Code` butonuna basarak `Download ZIP` seçeneğiyle indirin.
2. **IDE'de Açın:** Eclipse (veya IntelliJ IDEA) programını açın. 
   * Eclipse için: `File` -> `Open Projects from File System...` yolunu izleyerek indirdiğiniz klasörü seçin.
3. **Programı Başlatın:** Projenin içindeki `src/BiLets` paketini genişletin.
4. Sistemin başlangıç noktası olan **`Main.java`** dosyasına sağ tıklayın ve `Run As` -> `Java Application` seçeneğine tıklayarak projeyi çalıştırın.

*Not: Uygulama ilk kez çalıştığında, sistem klasöründe otomatik olarak `kullanicilar.csv` ve `etkinlikler.dat` isimli veritabanı dosyalarını oluşturacak ve varsayılan etkinlikleri yükleyecektir.*

##  Varsayılan Giriş Bilgileri

Sistemi test etmek için aşağıdaki hazır hesapları kullanabilirsiniz:

**Yönetici (Admin) Girişi:**
* **E-Mail:** admin@gazi.com
* **Şifre:** 1234

**Kullanıcı Girişi (Örnek):**
* **E-Mail:** gazi@edu.tr
* **Şifre:** sifre123
*(Veya giriş ekranından "Üye Ol" butonuna basarak yeni bir kayıt oluşturabilirsiniz).*

##  Projenin Temel Özellikleri
* **Yönetici Paneli:** Yeni etkinlik (Sinema, Konser vs.) ekleme, silme, fiyat güncelleme ve tüm etkinlikleri listeleme.
* **Kullanıcı Paneli:** Profil görüntüleme, etkinlikleri şehre ve kategoriye göre filtreleme, interaktif koltuk seçimi ve sanal ödeme sistemi.
* **Görsel Tasarım:** Etkinlik türüne göre (src/BiLets/resimler) dinamik olarak yüklenen afiş ve görseller.
