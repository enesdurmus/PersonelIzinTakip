/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personel_izin_takip;

import java.util.ArrayList;

/**
 *
 * @author X550V
 */
public class Firma {

    String firmaAdı;

    static ArrayList<Firma> firmalar = new ArrayList();
    ArrayList<Personel> firmanınPersonelleri = new ArrayList();

    public Firma(String firmaAdı) {
        this.firmaAdı = firmaAdı;
        firmalar.add(this);

    }

    public void personelEkleme(Personel e) {
        int sayaç = 0;
        for (int i = 0; i < firmanınPersonelleri.size(); i++) {

            if (e.getID() == firmanınPersonelleri.get(i).getID()) {
                sayaç++;
            }
        }
        if (sayaç == 0) {
            firmanınPersonelleri.add(e);
        }
    }

    public Personel personeleUlaşma(int personelId) {
        Personel a = null;
        for (Personel personel : firmanınPersonelleri) {
            if (personel.getID() == personelId) {
                a = personel;

                break;
            }
        }
        return a;
    }

    public void personelleriGörme() {
        for (int i = 0; i < firmanınPersonelleri.size(); i++) {
            System.out.println("İsim " + firmanınPersonelleri.get(i).getIsim() + " Soyisim " + firmanınPersonelleri.get(i).getSoyisim());
        }

    }

    public void personelOluşturma(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {
        Personel yeniPersonel = new Personel(isim, soyisim, ID, calısmaSuresi, cinsiyet);
        personelEkleme(yeniPersonel);
    }

    public void sefOluşturma(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {
        Şef yeniPersonel = new Şef(isim, soyisim, ID, calısmaSuresi, cinsiyet);
        personelEkleme(yeniPersonel);
    }

    public void hizmetliOluşturma(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {
        Hizmetli yeniPersonel = new Hizmetli(isim, soyisim, ID, calısmaSuresi, cinsiyet);
        personelEkleme(yeniPersonel);
    }

    public void memurOluşturma(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {
        Memur yeniPersonel = new Memur(isim, soyisim, ID, calısmaSuresi, cinsiyet);
        personelEkleme(yeniPersonel);
    }

    public void personelCıkarma(int ID) {
        int sayaç = 0;
        if (ID >= 10000 && ID <= 99999) {
            for (int i = 0; i < firmanınPersonelleri.size(); i++) {

                if (firmanınPersonelleri.get(i).getID() == ID) {
                    firmanınPersonelleri.remove(i);
                    sayaç++;
                }
            }
            if (sayaç == 0) {
                System.out.println("Böyle bir personelimiz yoktur...");
            }
        } else {
            System.out.println("ID 5 haneli olmalıdır...");
        }
    }

    public int getCalısanSayısı() {
        int toplamCalısan = 0;
        for (Personel personel : firmanınPersonelleri) {
            toplamCalısan++;

        }

        return toplamCalısan;
    }

}
