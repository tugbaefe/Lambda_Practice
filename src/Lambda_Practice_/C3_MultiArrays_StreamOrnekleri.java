package Lambda_Practice_;

import java.util.Arrays;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };
        liste(arr);
        eIleBaslayanElemn(arr);
        eIleBaslayanElemnYazdir(arr);
        kIleBitenElemnekle(arr);



    }
    // S1 : tum elemanlari list yapalim
    public static void liste(String[][]arr){
        System.out.println();
        System.out.println(Arrays.stream(arr).flatMap(Arrays::stream).collect(Collectors.toList()));
    }



    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void eIleBaslayanElemn(String[][]arr){
        System.out.println();
        Arrays.stream(arr).flatMap(Arrays::stream).
                filter(t -> t.toLowerCase().startsWith("e")).
                forEach(t-> System.out.println(t+t));
    }



    // S3: E ile baslayan elemanlari liste olarak yazdiralim

    public static void eIleBaslayanElemnYazdir(String[][]arr){
        System.out.println();
        System.out.println(Arrays.stream(arr).flatMap(Arrays::stream).
                filter(t -> t.toUpperCase().startsWith("E")).collect(Collectors.toList()));

    }


    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void kIleBitenElemnekle(String[][]arr){
        System.out.println();
        Arrays.stream(arr).flatMap(Arrays::stream).
                filter(t -> t.toLowerCase().endsWith("k")).forEach(t-> System.out.println(t+"*"));

    }



}
