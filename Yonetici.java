package BiLets;
import java.util.ArrayList;

public class Yonetici extends Person {
    private ArrayList<Event> etkinlikListesi;
    
   public Yonetici(String name, String surname, String email,String password){
    super(name, surname,email, password);
    this.etkinlikListesi = new ArrayList<>();
    }
    public String etkinlikEkle(Event yeniEtkinlik){
        etkinlikListesi.add(yeniEtkinlik);
        return "Etkinlik sisteme başarıyla eklendi!";
    }
     public String etkinlikGuncelle(String Ad, double yeniFiyat){
        for(Event etkinlik : etkinlikListesi){
            if(etkinlik.getEventname().equalsIgnoreCase(Ad)){
                etkinlik.setPrice(yeniFiyat);
                return Ad + " etkinliğinin yeni fiyatı " + yeniFiyat + " TL olarak güncellendi!";
            }
        }
        return "Hata! Güncellenecek etkinlik bulunamadı";
    }
      public String etkinlikSil(String silinecekEtkinlikAdi){
        for (int i = 0; i < etkinlikListesi.size(); i++) {
            Event siradakiEtkinlik = etkinlikListesi.get(i); 
            
            if (siradakiEtkinlik.getEventname().equalsIgnoreCase(silinecekEtkinlikAdi)) { 
                etkinlikListesi.remove(i); 
                return silinecekEtkinlikAdi + " sistemden silindi.";
            }
        }
        
        return "Hata: Silinmek istenen '" + silinecekEtkinlikAdi + "' bulunamadı!";
    }
      public String etkinlikleriListele() {
        if (etkinlikListesi.isEmpty()) {
            return "Sistemde kayıtlı hiçbir etkinlik bulunmamaktadır.";
        }
        String tumEtkinliklerMetni = "--- SİSTEMDEKİ TÜM ETKİNLİKLER ---\n\n";
        for (Event siradakiEtkinlik : etkinlikListesi) {
            tumEtkinliklerMetni += siradakiEtkinlik.etkinlikDetayGoster() + "\n------------------------\n";
        }
        return tumEtkinliklerMetni;
    }
}
