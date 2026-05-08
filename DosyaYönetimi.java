package BiLets;

import java.io.*;
import java.util.ArrayList;

public class DosyaYonetimi implements IVeriDepolama {
    private final String KULLANICI_DOSYASI = "kullanicilar.csv";
    private final String ETKINLIK_DOSYASI = "etkinlikler.dat";
    private final String KOLTUK_DOSYASI = "dolu_koltuklar.dat"; // YENİ: Koltuk dosyası

    @Override
    public void kullaniciKaydet(Kullanici k) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(KULLANICI_DOSYASI, true))) {
            String veri = k.getName() + "," + k.getSurname() + "," + k.getAge() + "," + 
                          k.getEmail() + "," + k.getPhonenumber() + "," + k.getPassword();
            writer.write(veri);
            writer.newLine();
            System.out.println("Kullanıcı başarıyla kaydedildi.");
        } catch (IOException e) {
            System.err.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Kullanici> kullanicilariYukle() {
        ArrayList<Kullanici> liste = new ArrayList<>();
        File dosya = new File(KULLANICI_DOSYASI);
        if (!dosya.exists()) return liste;

        try (BufferedReader reader = new BufferedReader(new FileReader(dosya))) {
            String satir;
            while ((satir = reader.readLine()) != null) {
                String[] parcalar = satir.split(",");
                if (parcalar.length == 6) {
                    Kullanici k = new Kullanici(parcalar[0], parcalar[1], Integer.parseInt(parcalar[2]), 
                                                parcalar[3], parcalar[4], parcalar[5]);
                    liste.add(k);
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        }
        return liste;
    }

    @Override
    public void verileriKaydet(ArrayList<Event> liste) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ETKINLIK_DOSYASI))) {
            oos.writeObject(liste);
            System.out.println("Etkinlikler başarıyla dosyaya kaydedildi.");
        } catch (IOException e) {
            System.err.println("Etkinlik yazma hatası: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Event> verileriYukle() {
        ArrayList<Event> liste = new ArrayList<>();
        File dosya = new File(ETKINLIK_DOSYASI);
        if (!dosya.exists()) return liste; 

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dosya))) {
            liste = (ArrayList<Event>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Etkinlik okuma hatası: " + e.getMessage());
        }
        return liste;
    }

    @Override
    public void doluKoltuklariKaydet(java.util.HashMap<String, java.util.ArrayList<String>> map) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(KOLTUK_DOSYASI))) {
            oos.writeObject(map);
        } catch (IOException e) {
            System.err.println("Koltuk yazma hatası: " + e.getMessage());
        }
    }

    @Override
    public java.util.HashMap<String, java.util.ArrayList<String>> doluKoltuklariYukle() {
        File dosya = new File(KOLTUK_DOSYASI);
        if (!dosya.exists()) return new java.util.HashMap<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dosya))) {
            return (java.util.HashMap<String, java.util.ArrayList<String>>) ois.readObject();
        } catch (Exception e) {
            return new java.util.HashMap<>();
        }
    }
}
