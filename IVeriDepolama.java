package BiLets;

import java.util.ArrayList;

public interface IVeriDepolama {
    void verileriKaydet(ArrayList<Event> liste); 
    ArrayList<Event> verileriYukle();

    void kullaniciKaydet(Kullanici k);
    ArrayList<Kullanici> kullanicilariYukle();
    
    void doluKoltuklariKaydet(java.util.HashMap<String, java.util.ArrayList<String>> map);
    java.util.HashMap<String, java.util.ArrayList<String>> doluKoltuklariYukle();
}

