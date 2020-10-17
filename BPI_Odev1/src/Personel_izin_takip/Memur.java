/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personel_izin_takip;

/**
 *
 * @author X550V
 */
public class Memur extends Personel {
    
    public Memur() {
    }
    
    public Memur(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {
        super(isim, soyisim, ID, calısmaSuresi, cinsiyet);
        
    }
    
    @Override
    public void setMaas(int maaas, int yevmiye) {
        if (maaas <= 2500 || yevmiye <= 90) {
            super.setMaas(2500, 90); //To change body of generated methods, choose Tools | Templates.
        } else {
            super.setMaas(maaas, yevmiye);
        }
    }
    
}
