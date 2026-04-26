/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bilets;

import java.io.*;
import java.util.ArrayList;

public class DosyaYönetimi implements IVeriDepolama {
    private final String KULLANICI_DOSYASI = "kullanicilar.csv";

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

    @Override public void verileriKaydet(ArrayList<Event> liste) { /* ... */ }
    @Override public ArrayList<Event> verileriYukle() { return new ArrayList<>(); }
}
