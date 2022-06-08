package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
        /*
   1) Lambda "Functional Programming"-->mathod(action) kullanma pr dili.
      Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
      Lambda  kendi başına tanımlanabilen parametre alıp gönderebilen fonksiyonlardır.
      Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.
      Java 8 ile gelen bu özellik, Java 8’in en önemli özelliğidir.

      "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
   2) "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur
   3) "Functional Programming" hiz, code kisaligi, code okunabilirligi
       ve hatasiz code yazma acilarindan cok faydalidir.
   4) Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.
      Lambda kullanmak hatasız code kullanmaktır.

          Collections Nedir?
          Çoğu yazılım tek tek öğeler yerine öğelerden oluşan toplulukları depolar ve onlar üzerinde işlem
          yapar. Array'ler onlardan birisidir. Java Collections Framework, arraylerle yapılan işleri daha kolay
          yaptığı gibi, daha fazlasını da yapar.
          Java'da bir koleksiyon (collection - bazen container, ambar diye adlandırılır) nesnelerden oluşan bir
          topluluğu bir arada tutan bir yapıdır. 'Collections Framework' ise arayüzler ve onların kurgularından
          (implementations) oluşur.
*/
        List<Integer> sayi= new ArrayList<>(Arrays.asList(34,22,16,11,35,20,63,21,65,44,66,64,81,38,15));
        // Task : "Structured Programming" kullanarak list elemanlarini aralarinda bosluk olacak sekilde print ediniz

        System.out.println(sayi);
        printElStuructured(sayi);

        System.out.println("\n  ***  ");
        printElFunctional(sayi);

        System.out.println("\n  ***  ");
        printElFunctional1(sayi);

        System.out.println("\n  ***  ");
        printElFunctional2(sayi);

        System.out.println("\n  ***  ");
        printCiftElSturctured(sayi);
        System.out.println("\n  ***  ");
        printCiftElFunctional(sayi);

        System.out.println("\n  ***  ");
        printCiftElFunctional1(sayi);

        System.out.println("\n  ***  ");
        printCiftOtuzKücükElFunctional(sayi);

        System.out.println("\n  ***  ");
        printCiftOtuzBüyükVeyaCiftElFunctional(sayi);










    }
    public static void printElStuructured(List<Integer> sayi){
        for (Integer w:sayi) {
            System.out.print(w+" ");
        }
    }
    // Task : "Structured Programming" kullanarak list elemanlarini aralarinda bosluk olacak sekilde print ediniz
    public static void printElFunctional(List<Integer> sayi){
        sayi.stream().forEach(t->System.out.print(t+" "));
    }


    /*
 stream() : datalari yukaridan asagiya akis sekline getirir. Stream bir interface olduğundan dolayı doğrudan nesne almaz.
 forEach() :datanin parametresine gore her bir elemanı isler
 t-> : Lambda operatoru
  Lambda Expression-->(parameter list) -> {action body}
      Parameter list: Fonksiyonun parametreleri tanımlanır. Hiç parametre geçirmeden boşta olabilir.
      -> Arrow-token: Argüman listesi ile expression gövdesini birbirine bağlamak için kullanılır.
      Body: Expressionları ve statementları içerir.

     Bir kod bloğundan oluşan bir body...
     Bu tip lambda body, block body olarak bilinir. Blok gövdesi, lambda gövdesinin birden çok ifade içermesine izin verir.
     Bu ifadeler parantez içine alınır ve parantezlerden sonra noktalı virgül eklemeniz gerekir.

         () -> {
          double pi = 3.1415;
             return pi;
         };
  Trick : Lambda Expression  yapisi cok tavsiye edilmez daha cok METHOD REFERENCE kullanilir
  Cünkü lambda'nin felsefesinde nasil yapacagini söylemek yok, ne yapacagi söylenir.***


 */
    public static void printElFunctional1(List<Integer> sayi){
        sayi.stream().forEach(System.out::print);// method reference --> System.out yapisinda prin methodu refere et
                                                // Bu action task'deki satira ve boslukla yazmayi karsilamaz bunun icin
        // seed (tohum) method create edili prefere edilmeli
    }
    public static void yazdir(int a){// yazdirma aksiyonu verilen degeri yazdirma action yapan seed (tohum) method creat edildi
        System.out.print(a+ " ");


    }
    public static void printElFunctional2(List<Integer> sayi){
        sayi.
                stream().
                forEach(Lambda01::yazdir);// method reference --> System.out yapisinda prin methodu refere et
    }
    //structured Programming ile list elemanlarinin  cift olanalrini ayni satirda aralarina bosluk birakarak print ediniz

    public static void printCiftElSturctured(List<Integer> sayi){
        for (Integer each: sayi )
        { if (each%2==0)
             {System.out.print(each+" ");}

        }
    }
    public static void printCiftElFunctional(List<Integer> sayi){
        sayi.stream().
                filter(t->t%2==0).
                forEach(Lambda01::yazdir);

    }

    public static  boolean ciftbul(int a){// seed (tohum) method kendisine verilen int degerrin cift olmasini kontrol eder
        return a%2==0;
    }
    public static void printCiftElFunctional1(List<Integer> sayi){
        sayi.
                stream().// list elemanlari akisa alindi
                filter(Lambda01::ciftbul).// cift bul method refere edilerek akisdaki elemanlar filitrelendi(ciftsayiya)
                forEach(Lambda01::yazdir);// filtre den gelen elemnalar yazdir() method refer edilerek print edildi


    }
    // Task : "Structured Programming" kullanarak list elemanlarini 34 kücük cift olanlarini  aralarinda bosluk olacak sekilde print ediniz
    public static void printCiftOtuzKücükElFunctional(List<Integer> sayi){
        sayi.
                stream().
                //filter(t->t%2==0 && t<34).
                filter(Lambda01::ciftbul).// method ref
                filter(t-> t<34).// lambda exp.
                forEach(Lambda01::yazdir);

    }
    // Task : "Structured Programming" kullanarak list elemanlarini 34 den büyük veya cift olanlarini  aralarinda bosluk olacak sekilde print ediniz
    public static void printCiftOtuzBüyükVeyaCiftElFunctional(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2==0 || t>34).
                //filter(Lambda01::ciftbul).// method ref
                //filter(t-> t<34).// lambda exp.
                forEach(Lambda01::yazdir);

    }



}
