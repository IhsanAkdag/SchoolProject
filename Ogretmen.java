package okulProject;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);

    static Map<String, String> ogretmenlerMap = new HashMap<>();

    public static void feykOgretmenEkle() {
        ogretmenlerMap.put("123456987411", "Ali, Can, 1980, Matematik");
        ogretmenlerMap.put("123456987412", "Veli, Yan, 1981, Fizik");
        ogretmenlerMap.put("123456987413", "Ayse, Can, 1982, Kimya");
        ogretmenlerMap.put("123456987414", "Ali, San, 1983, Kimya");
        ogretmenlerMap.put("123456987415", "Alp, Yan, 1984, Matematik");

    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih = "";

        do {

            System.out.println("================YILDIZ KOLEJI===================\n" +
                    "  ================  OGRETMEN MENU  ================\n" +
                    "\n" +
                    "\t    1- Ogretmen Listesi Yazdir \n" +
                    "\t    2- Soyisimden Ogretmen Bulma \n" +
                    "\t    3- Branstan Ogretmen Bulma \n" +
                    "\t    4- Bilgilerini Girerek Ogretmen Ekleme \n" +
                    "\t    5- Kimlik No Ile Kayit Silme \n" +
                    "\t    A- ANA MENU \n" +
                    "\t    Q- CIKIS \n");
            tercih = scan.nextLine();

            switch (tercih) {

                case "1":
                    ogretmenListesiYazdir();
                    break;
                case "2":
                    soyisimdenOgretmenBulma();
                    break;
                case "3":
                    branstanOgretenBulma();
                    break;
                case "4":
                    ogretmenEklemeMetodu();
                    break;
                case "5":
                    kimlikNoIleOgretmenSilme();
                    break;
                case "a":
                case "A":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("lutfen gecerli tercih yaziniz");
            }

        } while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    private static void kimlikNoIleOgretmenSilme() throws InterruptedException {
        System.out.println("silinecek ogretmenin tcNo giriniz");
        String silinecekOgretmen=scan.nextLine();

           String silinicekValue=ogretmenlerMap.get(silinecekOgretmen);
           String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);

        try {
            boolean sonuc= sonucValue.equalsIgnoreCase(silinicekValue);
        } catch (Exception e) {
             System.out.println("verilen tc ile ogretmen bulunamadi");
        }

        Thread.sleep(2000);
    }


    private static void ogretmenEklemeMetodu() {
        System.out.println("Tc No");
        String tcNo=scan.nextLine();

        System.out.println("isim");
        String isim=scan.nextLine();

        System.out.println("soyisim");
        String soyIsim=scan.nextLine();

        System.out.println("dogum yili");
        String dogumYili=scan.nextLine();

        System.out.println("brans");
        String brans=scan.nextLine();

        String eklenecekValue= isim+", "+soyIsim+", "+dogumYili+", "+brans;
        ogretmenlerMap.put(tcNo,eklenecekValue);
    }

    private static void branstanOgretenBulma() throws InterruptedException {

        System.out.println("aradiginiz ogretmenin bransini giriniz");
        String istenenBrans = scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenlerEntrySet= ogretmenlerMap.entrySet();

        System.out.println("================YILDIZ KOLEJI===================\n" +
                "  ================  SOYISIMDEN OGRETMEN ARAMA  ================\n"+
                "TcNo         Isim  Soyisim  D.Yili   Brans");
        for(Map.Entry<String,String> w: ogretmenlerEntrySet){
            String wKey=w.getKey();
            String wValue=w.getValue();

            String wValueArr[]=wValue.split(", ");

            if(istenenBrans.equalsIgnoreCase(wValueArr[3])){
                System.out.printf("%11s %-6s %-8s %4s    %s \n" , wKey,wValueArr[0],wValueArr[1],wValueArr[2],wValueArr[3]);
            }
        }
        Thread.sleep(5000);

    }

    private static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.println("aradiginiz ogretmenin soyismini giriniz");
        String istenenSoyIsim = scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenlerEntrySet= ogretmenlerMap.entrySet();

        System.out.println("================YILDIZ KOLEJI===================\n" +
                "  ================  SOYISIMDEN OGRETMEN ARAMA  ================\n"+
                "TcNo         Isim  Soyisim  D.Yili   Brans");
        for(Map.Entry<String,String> w: ogretmenlerEntrySet){
            String wKey=w.getKey();
            String wValue=w.getValue();

            String wValueArr[]=wValue.split(", ");

            if(istenenSoyIsim.equalsIgnoreCase(wValueArr[1])){
                System.out.printf("%11s %-6s %-8s %4s    %s \n" , wKey,wValueArr[0],wValueArr[1],wValueArr[2],wValueArr[3]);
            }
        }
        Thread.sleep(5000);


    }

    private static void ogretmenListesiYazdir() throws InterruptedException {
       Set<Map.Entry<String,String>> ogretmenlerEntrySet= ogretmenlerMap.entrySet();

        System.out.println("================YILDIZ KOLEJI===================\n" +
                "  ================  OGRETMEN LISTESI  ================\n"+
        "TcNo         Isim  Soyisim  D.Yili   Brans");

       for(Map.Entry<String,String> w: ogretmenlerEntrySet){
           String wKey=w.getKey();
           String wValue=w.getValue();

           String wValueArr[]=wValue.split(", ");
           System.out.printf("%11s %-6s %-8s %4s    %s \n" , wKey,wValueArr[0],wValueArr[1],wValueArr[2],wValueArr[3]);
       }
        Thread.sleep(5000);
    }


}
