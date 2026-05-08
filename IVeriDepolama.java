/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BiLets;

import java.util.ArrayList;

public interface IVeriDepolama {
    void verileriKaydet(ArrayList<Event> liste); 
    ArrayList<Event> verileriYukle();

    void kullaniciKaydet(Kullanici k);
    ArrayList<Kullanici> kullanicilariYukle();
}
