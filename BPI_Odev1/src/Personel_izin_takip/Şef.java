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
public class Şef extends Personel {

    public Şef(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {
        super(isim, soyisim, ID, calısmaSuresi, cinsiyet);

    }

    public Şef() {
    }

    @Override
    public void yıllıkIzınTalebi(int talepEdilenGun) {
        int sayaç = 0;
        for (Personel personel : Personeller) {
            if (personel instanceof Şef) {//personel şef ise,

                if (personel.kullanılanIzinler[0] != 0) {//ve yıllık izin kullandıysa
                    sayaç++;//sayaç artıyor böylece ikince bir şefe izin verilmiyor.
                }

            }
        }
        if (sayaç == 0) {
            super.yıllıkIzınTalebi(talepEdilenGun);

        } else {
            System.out.println("Şefler aynı anda yıllık izne çıkamazlar...");
        }

    }

    @Override
    public void ucretsizİzinTalebi(int kacGun) {
        int sayaç = 0;
        for (Personel personel : Personeller) {
            if (personel instanceof Şef) {//personel şef ise
                if (personel.kullanılanIzinler[1] != 0) {//ve ücretsiz izin kullandıysa

                    sayaç++;//sayaç artıyor 
                }

            }
        }
        if (sayaç == 0) {//sayaç 0 sa izin veriyoruz değilse vermiyoruz.
            super.ucretsizİzinTalebi(kacGun);

        } else {
            System.out.println("Şefler aynı anda ücretsiz izne çıkamazlar...");
        }

    }

    @Override
    public void setMaas(int maaas, int yevmiye) {
        if (maaas <= 4500 || yevmiye <= 120) {
            super.setMaas(4500, 150);
        } else {
            super.setMaas(maaas, yevmiye); //To change body of generated methods, choose Tools | Templates.

        }
    }

}
