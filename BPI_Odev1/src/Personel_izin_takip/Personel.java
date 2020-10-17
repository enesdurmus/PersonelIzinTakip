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
public class Personel {

    private String isim, soyisim;
    private int ID;
    private int calısmaSuresi;
    private İzin izinHakkı;
    private Maas maas;
    private String cinsiyet;
    private String ünvan;

    static ArrayList<Personel> Personeller = new ArrayList();
    int kullanılanIzinler[] = new int[4];

    public Personel() {
        Personeller.add(this);
        İzin izin = new İzin();
        izinHakkı = izin;
        if (calısmaSuresi >= 1) {
            izinHakkı.yıllıkIzın = 14;

        } else if (calısmaSuresi >= 5) {
            izinHakkı.yıllıkIzın = 20;

        } else if (calısmaSuresi >= 15) {
            izinHakkı.yıllıkIzın = 26;

        }
    }

    public Personel(String isim, String soyisim, int calısmaSuresi, String Cinsiyet) {
        this.isim = isim;
        this.cinsiyet = Cinsiyet;
        this.soyisim = soyisim;
        this.calısmaSuresi = calısmaSuresi;
        Personeller.add(this);
        İzin izin = new İzin();
        izinHakkı = izin;
        if (calısmaSuresi >= 1) {
            izinHakkı.yıllıkIzın = 14;

        } else if (calısmaSuresi >= 5) {
            izinHakkı.yıllıkIzın = 20;

        } else if (calısmaSuresi >= 15) {
            izinHakkı.yıllıkIzın = 26;

        }

    }

    public Personel(String isim, String soyisim, int ID, int calısmaSuresi, String cinsiyet) {

        this.isim = isim;
        this.soyisim = soyisim;
        this.calısmaSuresi = calısmaSuresi;
        this.cinsiyet = cinsiyet;
        İzin izin = new İzin();
        izinHakkı = izin;
        Personeller.add(this);

        this.setID(ID);//Id kontrol ederek atıyor.

        /*----------------Personel Oluşurken yıllık izin hakkını atıyor--------*/
        if (calısmaSuresi >= 1) {
            izinHakkı.yıllıkIzın = 14;

        } else if (calısmaSuresi >= 5) {
            izinHakkı.yıllıkIzın = 20;

        } else if (calısmaSuresi >= 15) {
            izinHakkı.yıllıkIzın = 26;

        }

    }

    /*------------------------------Yıllık İzin-------------------------------------------*/
    public void yıllıkIzınTalebi(int talepEdilenGun) {

        if (talepEdilenGun <= izinHakkı.yıllıkIzın) {
            izinHakkı.yıllıkIzın = izinHakkı.yıllıkIzın - talepEdilenGun;
            kullanılanIzinler[0] += talepEdilenGun;
            System.out.println(talepEdilenGun + " günlüğüne personele izin verilmiştir... ");

        } else {
            System.out.println("Personelin bu kadar yıllık izini bulunmamaktadır...");
        }
    }

    public void yıllıkİzinHakkıSilme(int silinmekIstenenGunSayısı) {
        if (izinHakkı.yıllıkIzın >= silinmekIstenenGunSayısı) {
            izinHakkı.yıllıkIzın -= silinmekIstenenGunSayısı;
        } else {
            System.out.println("Personelin bu kadar yıllık izini bulunmamaktadır...");
        }

    }

    /*------------------------------Ücretsiz İzin-------------------------------------------*/
    public void ucretsizİzinTalebi(int kacGun) {

        kullanılanIzinler[1] += kacGun;
        maas.Maas = maas.Maas - (kacGun * maas.yevmiye);
        System.out.println(kacGun + " günlüğüne personele izin verilmiştir...");
    }

    /*------------------------------Doğum İzni-------------------------------------------*/
    public void dogumİzniAtama() {
        if (cinsiyet.equals("Erkek")) {
            izinHakkı.doğumIznı = 7;
            kullanılanIzinler[2] += 7;

        } else {
            izinHakkı.doğumIznı = 180;
            kullanılanIzinler[2] += 180;
        }

    }

    /*------------------------------Vefat İzni-------------------------------------------*/
    public void vefatİzniTalebi(int vefatEdenKişininYakınlıkDerecesi) {
        if (vefatEdenKişininYakınlıkDerecesi == 1) {

            kullanılanIzinler[3] += 3;

        } else {
            izinHakkı.yıllıkIzın = izinHakkı.yıllıkIzın - 3;

        }

    }

    /*------------------------------Kontroller-------------------------------------------*/
    public void yıllıkİzinKontrolü(int calısmaSuresi) {
        //Personelin yıllık izinini kontrol ederken calısma süresinide alıyoruz ve buna göre hakkı olan izni atıyoruz.

        if (calısmaSuresi > this.calısmaSuresi) { //eğer girilen çalışma süresi kendi çalışma süresinden azsa işleme girmiyor çünkü imkansız.
            int artıracağımızİzinSayısı = 0;
            if (this.calısmaSuresi != calısmaSuresi) {
                if (calısmaSuresi >= 1) {
                    artıracağımızİzinSayısı = (calısmaSuresi - this.calısmaSuresi) * 14;

                    izinHakkı.yıllıkIzın += artıracağımızİzinSayısı;

                } else if (calısmaSuresi >= 5) {
                    artıracağımızİzinSayısı = (calısmaSuresi - this.calısmaSuresi) * 20;
                    izinHakkı.yıllıkIzın += artıracağımızİzinSayısı;

                } else {
                    artıracağımızİzinSayısı = (calısmaSuresi - this.calısmaSuresi) * 26;
                    izinHakkı.yıllıkIzın += artıracağımızİzinSayısı;
                }
            }
        } else {
            System.out.println("Çalışma süreniz azalamaz girdiğiniz parametreyi kontrol ediniz...");
        }
        System.out.println(izinHakkı.yıllıkIzın);

    }

    public void yıllıkİzinKontrolü() {

        System.out.println(izinHakkı.yıllıkIzın);

    }

    public void KullanılanİzinleriGörme() {

        System.out.println("Kullanılan ücretsiz izin sayısı: " + kullanılanIzinler[1]);
        System.out.println("Kullanılan doğum izni sayısı: " + kullanılanIzinler[2]);
        System.out.println("Kullanılan vefat izni sayısı: " + kullanılanIzinler[3]);
        System.out.println("Kullanılan yıllık izin sayısı: " + kullanılanIzinler[0]);

    }


    /*------------------------------Set Get'ler-------------------------------------------*/
    public Maas getMaas() {
        return maas;
    }

    public void setMaas(int maaas, int yevmiye) {
        if (maaas < 1600 || yevmiye < 65) {
            System.out.println("Maas asgari ücretin altında olamaz.");
        } else {
            Maas maas = new Maas(maaas, yevmiye);
            this.maas = maas;

        }

    }

    public void setID(int ID) {
        int sayaç = 0;

        if (ID >= 10000 && ID <= 99999) {
            for (int i = 0; i < Personeller.size(); i++) {
                if (Personeller.get(i).getID() == ID) {
                    System.out.println("Bu Id'ye sahip personelimiz zaten mevcut...");
                    sayaç++;
                    break;
                }
            }
            if (sayaç == 0) {
                this.ID = ID;
            }

        } else {
            System.out.println("ID 5 haneli olmalıdır...");
        }

    }

    public int getCalısmaSuresi() {
        return calısmaSuresi;
    }

    public int getID() {
        return ID;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public void setÜnvan(String ünvan) {
        this.ünvan = ünvan;
    }

    public String getÜnvan() {
        return ünvan;
    }

}
