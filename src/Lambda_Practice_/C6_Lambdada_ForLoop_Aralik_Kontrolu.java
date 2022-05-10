package Lambda_Practice_;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {
    public static void main(String[] args) {
        ilk30(30);
        System.out.println();
        ilk30Dahil(30);
        System.out.println();
        System.out.print("toplam : "+ top(10, 20));
        System.out.println();
        System.out.println("ort(10,20) = " + ort(10, 20));
        System.out.println();
        System.out.println("sekizeBolunen(325,468) = " + sekizeBolunen(325, 468));
        System.out.println();
        sekizeBolunenYaz(325,468);
        System.out.println();
        System.out.println("sekizeBolunenSayiTop(325,468) = " + sekizeBolunenSayiTop(325, 468));
        System.out.println();
        System.out.println("tekSayiCarpimi(7,15) = " + tekSayiCarpimi(7, 15));
        System.out.println();
        tekSayiIlk10ElemanYaz(30);
        System.out.println();
        tekSayiIlk10ElemanYaz2(30);
        System.out.println();
        yedininKatlari10ElemanYaz(1000);
        System.out.println();
        yedininKatlari20ElemanTop(1000);

    }
    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
    public static void ilk30(int a) {
        IntStream.range(1, a).forEach(t -> System.out.print(t + " "));
    }
    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void ilk30Dahil(int a) {
        IntStream.rangeClosed(1, a).forEach(t -> System.out.print(t + " "));
    }


    //S3 Istenen iki deger(dahi) arasindaki sayilari toplayalim
    public static int top(int baslangic,int bitis) {
      return   IntStream.rangeClosed(baslangic,bitis).sum();
      //return   IntStream.range(baslangic,bitis).sum();
    }


    //S4: 30 ile 40 arasindaki sayilarin (dahi) ortalamasini bulalim
    public static OptionalDouble ort(int baslangic, int bitis) {
        return   IntStream.rangeClosed(baslangic,bitis).average();
    }



    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static long sekizeBolunen(int baslangic,int bitis){
        return IntStream.rangeClosed(baslangic, bitis).filter(t->t%8==0).count();
    }


    //S6: 325 ile 468 arasinda 8 e bolunen sayilari yazdiralim
    public static void sekizeBolunenYaz(int baslangic,int bitis){
         IntStream.rangeClosed(baslangic, bitis).filter(t->t%8==0).forEach(t-> System.out.print(t+" "));
    }



    // S7:325 ile 468 arasinda 8 e bolunen sayilarin toplamini bulalim
    public static int sekizeBolunenSayiTop(int baslangic,int bitis){
       return IntStream.rangeClosed(baslangic, bitis).filter(t->t%8==0).sum();
    }


    // S8: 7ile 15 arasindaki tek sayilarin carpimini bulalim
    public static double tekSayiCarpimi(int a, int b){
        return IntStream.rangeClosed(a,b).filter(Methods::tekMi).
        reduce(1,(x,y)->x*y);//reduce(Math::multiplyExact);
    }


    //S9: pozitif tek sayilarin ilk 10 elemanin yazdiralim
    public static void tekSayiIlk10ElemanYaz(int a){
        IntStream.rangeClosed(1,a).filter(Methods::tekMi).limit(10).forEach(Methods::yazInteger);
    }
    public static void tekSayiIlk10ElemanYaz2(int a){
        IntStream.iterate(1,t->t+2).limit(10).forEach(Methods::yazInteger);
    }



    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 teriminin yaziralim
    public static void yedininKatlari10ElemanYaz(int a){
        IntStream.rangeClosed(21,a).filter(t->t%7==0).filter(Methods::tekMi).limit(10).forEach(Methods::yazInteger);
    }




    //S11: 21 den baslayan 7 nin katlarinin ilk 20 teriminin toplayalim
    public static void yedininKatlari20ElemanTop(int a){
        System.out.println(IntStream.rangeClosed(21, a).filter(t -> t % 7 == 0).limit(20).sum());
    }

}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belirliyoruz

