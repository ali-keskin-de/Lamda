package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
     */
    public static void main(String[] args) {
        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        notOrtBKSiralaIlkUc(unv);
        System.out.println("\n   ***   ");

        System.out.println(ögrenciSayiEIkinciOlan(unv));
        System.out.println("\n   ***   ");

        System.out.println("taks 7 calisitik "+notortalamasi63BüyükUniOgrenciSayiTopla(unv));
        System.out.println("\n   ***   ");
        System.out.println("taks 7 calisitik "+ notortalamasi63BüyükUniOgrenciSayiToplaInt(unv));
        System.out.println("\n   ***   ");
        System.out.println("Task 9 calistik "+ matBölümSayisi(unv));
        System.out.println("\n   ***   ");
        System.out.println("Task 10 calsitik "+notOrtalamasiEnBuyukOlan(unv));
        System.out.println("\n   ***   ");
        System.out.println("11. Task calisildi "+ogrSayi1071KücükEnKNotOrt(unv));
        System.out.println("\n   ***   ");


    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.



    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrcSayisi110AzMi(List<Universite> unv) {
        return unv.
                stream().
                allMatch(t -> t.getOgrSayisi() > 110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarmi(List<Universite> unv) {
        return unv.stream().
                anyMatch(t -> t.getBolum().contains("mat"));
    }


    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.


    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static void notOrtBKSiralaIlkUc(List<Universite> unv){
        System.out.println(unv.
                stream().// akisa alindi
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).// not B->K siralandi
                limit(3).// ilk 3 elemani alindi
                collect(Collectors.toList()));// akisin ilk 3 elemani liste assingedildi(atandi) sadece limitte sonrasi icin toList()); olur

    }


    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> ögrenciSayiEIkinciOlan(List<Universite> unv){
       return unv.
               stream().
               sorted(Comparator.comparing(Universite::getOgrSayisi)).
               limit(2).
               skip(1).
               collect(Collectors.toList());

    }


    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static int notortalamasi63BüyükUniOgrenciSayiTopla(List<Universite>unv){
       return unv.
                stream().
                filter(t->t.getNotOrt()>63).
               map(t->t.getOgrSayisi()).
               //reduce(Math::addExact);
               reduce(0,(t,u)->t+u);//Optional<Integer> yerine Integer ister cünkü default degeri sifir oldugunda
              // reduce(Integer::sum);


    }
    public static int notortalamasi63BüyükUniOgrenciSayiToplaInt(List<Universite>unv) {
        return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi()).
                sum();
          // mapToInt() --> bu method akısdaki elemanların data type'nı
         // parameterisindeki() degere göre Int data type update eder
         // mapToInt() --> bu method akısdaki elemanların data type'nı
         // parameterisindeki() degere göre Int data type update eder
    }



        //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
        public static OptionalDouble ogrcSayisi333BykNotOrtOrtlamaAl(List<Universite> unv) {

            return unv.
                    stream().
                    filter(t->t.getOgrSayisi()>333).
                    mapToDouble(t->t.getNotOrt()).
                    average();//akısdakş elamnalrın ortlaması alındı
            //mapToDouble(t->t.getNotOrt()).---> bu method akistaki elemanlari data type'in parametresindeki degere göre double type update eder




        }


    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static long matBölümSayisi(List<Universite> unv){
      return unv.stream().filter(t->t.getBolum().contains("mat")).count();

    }


    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt notOrtalamasiEnBuyukOlan(List<Universite> unv){
       return unv.
                stream().//akis
                filter(t->t.getOgrSayisi()>571).// uni obj akisi filitrelendi
                mapToInt(t->t.getNotOrt()).// akisdaki uni obj notOrt akisi olarak update edilir
                max();// akisin en byk degerini return eder
    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrSayi1071KücükEnKNotOrt (List<Universite> unv){
       return unv.
               stream().
               filter(t->t.getOgrSayisi()<1071).
               mapToInt(t->t.getNotOrt()).
               min();
    }




}
