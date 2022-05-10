package Lambda_Practice_;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);

        tekYaz(intL);
        System.out.println();
        System.out.println(ciftleriYaz(intL));
        System.out.println();
        System.out.println(negatifKareTopYaz(intL));
        System.out.println();



    }




    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekYaz(List<Integer> l){
        l.stream().filter(Methods::tekMi).forEach(Methods::yazInteger);
    }






    // S2: ciftlerin carpimini bulalim
    public static Optional<Integer> ciftleriYaz(List<Integer> l){
        return l.stream().filter(Methods::ciftMi).reduce(Math::multiplyExact);
    }







    // S3: negatiflerin kare toplamlarini  bulalim
    public static Optional<Integer> negatifKareTopYaz(List<Integer> l){
     return l.stream().filter(Methods::negatifMi).map(Methods::kareBul).reduce(Methods::toplam);
    }



    // S4: poziflerin kuplerinden max yazdiralim
    public static Optional<Integer> kupMax(List<Integer> l){
        return l.stream().filter(Methods::pozitifMi).map(Methods::kupBul).reduce(Math::max);
    }

}
