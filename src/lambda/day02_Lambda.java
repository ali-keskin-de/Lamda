package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class day02_Lambda {
    public static void main(String[] args) {
        // Task : Functional Programming ile listin cift elemanlarinin  karelerini ayni satirda aralarina bosluk bırakarak print ediniz

        List<Integer> sayi = new ArrayList<>(Arrays.asList(4, 2, 6, 1, 5, 2, 3, 2, 8, 15));

        ciftKarePrint(sayi);
        System.out.println("\n  ***  ");
        tekKüpBirFazlaPrint(sayi);
        System.out.println("\n  ***  ");
        ciftKarekökPrint(sayi);
        System.out.println("\n  ***  ");
        maxElemanBul(sayi);
        System.out.println("\n  ***  ");
        ciftElemanKaresininEnBüyük(sayi);
        System.out.println("\n  ***  ");
        elemanTopla(sayi);
        System.out.println("\n  ***  ");
        ciflerinCarpimi(sayi);
        System.out.println("\n  ***  ");

    }

    public static void ciftKarePrint(List<Integer> sayi) {
        sayi.stream().
                filter(Lambda01::ciftbul).
                map(t -> t * t).  //map()--> Stream içerisindeki elemanları başka tiplere dönüştürmek veya üzerlerinde işlem yapmak (update) için Map kullanılmaktadır.
                forEach(Lambda01::yazdir);

    }
    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edi

    public static void tekKüpBirFazlaPrint(List<Integer> sayi) {
        sayi.
                stream().// sayilar akisa alindi
                filter(t -> t % 2 == 1).//tek elemanlar fitrelendi
                map(t -> (t * t * t) + 1).// tek elemanlarin küplerinin 1 fazlasina udate edildi
                forEach(Lambda01::yazdir);// print edildi
    }

    // Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
// Task : Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz
    public static void ciftKarekökPrint(List<Integer> sayi) {

        sayi.
                stream().
                filter(Lambda01::ciftbul).
                map(Math::sqrt).
                forEach(t -> System.out.print(t + " "));

    }
    // Task : list'in en buyuk elemanini yazdiriniz
    public static void maxElemanBul(List<Integer> sayi){
       Optional<Integer> maxSayi= sayi.
               stream().
               reduce(Math::max);// akisa giren elemanlarin action sonrasi tek eleman haline getirir

        System.out.println(maxSayi);
        System.out.println("halukca :"+ sayi.stream().reduce(Math::max));


    }
    /*
 reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
 kullanımı yaygındır pratiktir.
 Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
 bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
 reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
 reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
 İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

 */

    // Task : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftElemanKaresininEnBüyük(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftbul).
                map(t -> t * t).
                reduce(Math::max));// reduce bir terminal method'udur bundan sonra method calismaz foreach gibi.



        System.out.println("Daha hizli specific Integer calass calisacak"+sayi.
                stream().
                filter(Lambda01::ciftbul).
                map(t -> t * t).
                reduce(Integer::max));// buda ayni sonucu verir Integer Class'i daha dar bir Class bu bize hizda avantaj saglar



    }
    // Task : List'teki tum elemanlarin toplamini yazdiriniz.
//Lambda Expression...
    public static void elemanTopla(List<Integer> sayi){
       int toplam= sayi.stream().reduce(0,(x,y)->x+y);// Lambda experssion...
        //sayi.stream().reduce(Integer::sum);// method referetions ancak bizden bu istenmemekte
        /*
        a ilk degerini her zaman atanan degerden (identity) alir
        b degerini her zaman stream() 'dan akistan alir
        a ilk degerinden sonraki her degeri action(islem)'den alir
         */
        System.out.println("Lambda exp. : "+toplam);
       // int total=sayi.stream().reduce(Integer::sum);// bunun sebebi baslangic degeri yok null gelme ihtimali oldugundan altini ciziyor bir variable atayinca
                                                     // ancak ilkinda biz 0 baslangic degeri oldugundan calisir optional almaz.
        System.out.println("meth ref : "+ sayi.stream().reduce(Integer::sum));


    }
    // Task : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciflerinCarpimi(List<Integer> sayi){
        // method ref.
        System.out.println("method ref. : "+sayi.
                stream().
                filter(Lambda01::ciftbul).
                reduce(Math::multiplyExact));

        // Lambda Expression...

        System.out.println("Lambda Exp. : "+sayi.
                stream().
                filter(Lambda01::ciftbul).
                reduce(1, (x, y) -> (x * y)));


    }
    // Task : List'teki elemanlardan en kucugunu 4 farklı yontem ile print ediniz.



//3. yontem Lambda Expression
//4. yontem Method Reference --> Haluk class

// Task : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
// Task : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
// Task : list'in tek  elemanlarinin kareleri ni buykten kucuge  print ediniz.
    public static void enKücükTekSayiyiPrint(List<Integer> sayi){
        //1. yontem Method Reference --> Integer class
       Optional<Integer> minSayi= sayi.stream().reduce(Integer::min);

        System.out.println(minSayi);
       Optional<Integer> minSayiMath= sayi.stream().reduce(Math::min);
        int minSayiExp= (sayi.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y));


    }



}



