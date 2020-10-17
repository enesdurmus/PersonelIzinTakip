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
public class İzinTakipTest {

    public static void main(String[] args) {

        Firma firma = new Firma("İgdaş");
        firma.personelOluşturma("Enes", "Durmus", 100001, 1, "Erkek");
        firma.personelOluşturma("Enes", "Durmus", 10001, 1, "Erkek");
        firma.sefOluşturma("Enes", "Durmus", 10001, 1, "Erkek");
        firma.sefOluşturma("Ahmet", "AK", 10002, 1, "Erkek");
        firma.sefOluşturma("Enes", "Durmus", 10003, 1, "Erkek");
        firma.memurOluşturma("Enes", "Durmus", 10004, 1, "Erkek");
        System.out.println("-----------------------------------");
        System.out.println(firma.getCalısanSayısı());
        firma.personelCıkarma(10004);
        System.out.println(firma.getCalısanSayısı());
        System.out.println("------------------------------------");
        firma.personeleUlaşma(10001).yıllıkIzınTalebi(15);
        firma.personeleUlaşma(10001).yıllıkIzınTalebi(10);
        firma.personeleUlaşma(10001).setMaas(10000, 100);
        firma.personeleUlaşma(10001).ucretsizİzinTalebi(10);
        System.out.println(firma.personeleUlaşma(10001).getMaas().Maas);
        firma.personeleUlaşma(10001).vefatİzniTalebi(1);
        firma.personeleUlaşma(10001).dogumİzniAtama();
        firma.personeleUlaşma(10001).KullanılanİzinleriGörme();
        System.out.println("------------------------------------");
        firma.personeleUlaşma(10002).yıllıkIzınTalebi(7);
        firma.personeleUlaşma(10003).yıllıkIzınTalebi(2);
        firma.personeleUlaşma(10003).KullanılanİzinleriGörme();
        System.out.println("--------------------------------------");
        firma.personeleUlaşma(10002).KullanılanİzinleriGörme();
        System.out.println("-------------------------------------");
        firma.personeleUlaşma(10003).setMaas(7000, 120);
        firma.personeleUlaşma(10003).ucretsizİzinTalebi(10);
        firma.personeleUlaşma(10003).KullanılanİzinleriGörme();

    }

}
