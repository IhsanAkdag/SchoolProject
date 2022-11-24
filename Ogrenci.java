package okulProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogrenci {
    static Map<String,String> ogrenciMap= new HashMap<>();
    static Scanner scan= new Scanner(System.in);
    public static void feykOgrenciekle(){
        ogrenciMap.put("123456987411","Ali, Can, 2008, 3569, 12, A");
        ogrenciMap.put("123456987412","Veli, Yan, 2008, 3559, 12, B");
        ogrenciMap.put("123456987413","Ayse, Can, 2007, 4569, 12, A");
        ogrenciMap.put("123456987414","Ali, San, 2009, 1569, 12, A");
        ogrenciMap.put("123456987415","Alp, Yan, 2009, 3769, 12, A");
    }

    public static void ogrenciMenu() throws InterruptedException {
        String tercih="";
    do {
        System.out.println("================YILDIZ KOLEJI===================\n" +
                "================  OGRENCI MENU  ================\n" +
                "\n" +
                "\t    1- Ogrenci Listesi Yazdir \n" +
                "\t    2- Soyisimden Ogrenci Bulma \n" +
                "\t    3- Sinif Sube ile Ogrenci Bulma \n" +
                "\t    4- Bilgilerini Girerek Ogrenci Ekleme \n" +
                "\t    5- Kimlik No Ile Kayit Silme \n" +
                "\t    A- ANA MENU \n" +
                "\t    Q- CIKIS \n");

        tercih=scan.nextLine();

        switch (tercih) {

            case "1":
                ogrenciListesiYazdir();
                break;
            case "2":
                soyisimdenOgrenciBulma();
                break;
            case "3":
                sinifSubeIleOgrenciBulma();
                break;
            case "4":
                ogrenciEklemeMetodu();
                break;
            case "5":
                kimlikNoIleOgrenciSilme();
                break;
            case "a":
            case "A":
                Depo.anaMenu();
                break;
            case "q":
            case "Q":
                Depo.projeDurdur();
                break;
            default:
                System.out.println("lutfen gecerli tercih yaziniz");
        }

    }while (!tercih.equalsIgnoreCase("q"));
       Depo.projeDurdur();
    }

    private static void kimlikNoIleOgrenciSilme() {
        System.out.println("silinecek ogrenci tcNo giriniz");
        String silinecekOgrenci=scan.nextLine();

        String silinicekValue=ogrenciMap.get(silinecekOgrenci);
        String sonucValue = ogrenciMap.remove(silinecekOgrenci);

        try {
            boolean sonuc= sonucValue.equalsIgnoreCase(silinicekValue);
        } catch (Exception e) {
            System.out.println("verilen tc ile ogrenci bulunamadi");
        }

    }

    private static void ogrenciEklemeMetodu() {
        System.out.println("TcNo");
        String tcNo= scan.nextLine();

        System.out.println("Isim");
        String isim= scan.nextLine();

        System.out.println("Soyisim");
        String soyIsim= scan.nextLine();

        System.out.println("Dogum yili");
        String dogumYili= scan.nextLine();

        System.out.println("Okul No");
        String okulNo= scan.nextLine();

        System.out.println("Sinif");
        String sinif= scan.nextLine();

        System.out.println("Sube");
        String sube= scan.nextLine();

        String key=tcNo;
        String value= isim+", "+soyIsim+ ", "+dogumYili+ ", "+okulNo+ ", "+sinif+ ", "+sube;

        ogrenciMap.put(key,value);

    }

    private static void sinifSubeIleOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("ogrenci sinifini giriniz");
        String istenilenSinif=scan.nextLine();

        System.out.println("ogrenci subesini giriniz");
        String istenilenSube=scan.nextLine();

        System.out.println("================YILDIZ KOLEJI===================\n" +
                "  ================ OGRENCI LISTESI  ================\n"+
                "TcNo         Isim  Soyisim  D.Yili   Num   Sinifi/Sube");

        for(Map.Entry<String,String> each : myEntrySet){

            String eachKey=each.getKey();
            String eachValue=each.getValue();

            String eachValueArr[]=eachValue.split(", ");

            if(istenilenSinif.equalsIgnoreCase(eachValueArr[4]) && istenilenSube.equalsIgnoreCase(eachValueArr[5])) {
                System.out.printf("%-12s %-6s %-9s %-4s   %-4s     %-2s %-2s \n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
            }
        }

        Thread.sleep(3000);

    }

    private static void soyisimdenOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("ogrenci soy ismini giriniz");
        String istenilenSoyIsim=scan.nextLine();

        System.out.println("================YILDIZ KOLEJI===================\n" +
                "  ================ OGRENCI LISTESI  ================\n"+
                "TcNo         Isim  Soyisim  D.Yili   Num   Sinifi/Sube");

        for(Map.Entry<String,String> each : myEntrySet){

            String eachKey=each.getKey();
            String eachValue=each.getValue();

            String eachValueArr[]=eachValue.split(", ");

            if(istenilenSoyIsim.equalsIgnoreCase(eachValueArr[1])) {
                System.out.printf("%-12s %-6s %-9s %-4s   %-4s     %-2s %-2s \n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
            }
        }
        Thread.sleep(3000);

    }

    private static void ogrenciListesiYazdir() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();

        System.out.println("================YILDIZ KOLEJI===================\n" +
                "  ================ OGRENCI LISTESI  ================\n"+
                "TcNo         Isim  Soyisim  D.Yili   Num   Sinifi/Sube");

        for(Map.Entry<String,String> each : myEntrySet){

            String eachKey=each.getKey();
            String eachValue=each.getValue();

            String eachValueArr[]=eachValue.split(", ");
            System.out.printf("%-12s %-6s %-9s %-4s   %-4s     %-2s %-2s \n",eachKey,eachValueArr[0],eachValueArr[1],eachValueArr[2],eachValueArr[3],eachValueArr[4],eachValueArr[5]);
        }
        Thread.sleep(3000);

    }
}
