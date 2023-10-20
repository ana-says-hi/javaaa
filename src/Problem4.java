import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.min;

public class Problem4 {
    //todo tests
    /**
     * Markus will ein USB Laufwerk und eine Tastatur kaufen.
     * Der Elektronik-Shop hat verschiedene USB Laufwerke und
     * Tastaturen mit verschiedene Preise, als Array von Zahlen dargestellt.
     */

    static ArrayList<Integer> tastaturen = new ArrayList<>();
    static ArrayList<Integer> usb = new ArrayList<>();

    /**
     * Schreiben Sie eine Methode, die die billigste Tastatur zurückgibt.
     * z.B. [40 35 70 15 45] => 15
     */
    private static int billigsteT() {
        return min(tastaturen);
        //int billig = 0;
//        for (int i = 1; i < tastaturen.size(); i++)
//            if (tastaturen.indexOf(billig) > tastaturen.indexOf(i)) {
//                billig = i;
//            }
//        return tastaturen.indexOf(billig);
    }

    private static void testBillig(){
        tastaturen.addAll(List.of(40, 35, 70, 15, 45));
        //System.out.println(billigsteT());
        assert(billigsteT()==15);
        tastaturen.removeAll(List.of(40, 35, 70, 15, 45));
    }
    private static void failedTestBillig(){
        tastaturen.addAll(List.of(40, 35, 70, 15, 45));
        //System.out.println(billigsteT());
        assert(billigsteT()!=15);
        tastaturen.removeAll(List.of(40, 35, 70, 15, 45));
    }

    /**
     * Schreiben Sie eine Methode, die die teuerste Gegenstand zurückgibt.
     * z.B. Tastatur = [15 20 10 35], USB = [20, 15, 40, 15] => 40
     */
    private static int teuersteG() {
        int teuer1 = 0;
        int teuer2 = 0;
        for (int i = 1; i < tastaturen.size(); i++)
            if (tastaturen.get(i) > tastaturen.get(teuer1)) {
                teuer1 = i;
            }
        for (int i = 1; i < usb.size(); i++)
            if (usb.get(i) > tastaturen.get(teuer2)) {
                teuer2 = i;
            }

        if (tastaturen.get(teuer1) > usb.get(teuer2))
            return tastaturen.get(teuer1);
        return usb.get(teuer2);
    }

    private static void testTeuerG(){
        tastaturen.addAll(List.of(15,20,10,40));
        usb.addAll(List.of(20, 15, 35, 15));
        assert(teuersteG()==40);
        tastaturen.removeAll(List.of(15,20,10,40));
        usb.removeAll(List.of(20, 15, 35, 15));
    }
    private static void failedTestTeuerG(){
        tastaturen.addAll(List.of(15,20,10,40));
        usb.addAll(List.of(20, 15, 35, 15));
        assert(teuersteG()==35);
        tastaturen.removeAll(List.of(15,20,10,40));
        usb.removeAll(List.of(20, 15, 35, 15));
    }


    /**
     * Schreiben Sie eine Methode, die die teuerste USB Laufwerk, die Markus kaufen kann, zurückgibt.
     * z.B. Preise = [15 45 20], Budget = 30 => 20
     */
    private static int teuersteUSB(int buget) {
        int teuer = 0;
        for (int i = 0; i < usb.size(); i++)
            if (usb.get(teuer) < buget) {
                {
                    teuer = i;
                    break;
                }
            }
        for (int i = teuer; i < usb.size(); i++)
            if (usb.get(i) < buget && usb.get(teuer) < usb.get(i)) {
                {
                    teuer = i;
                }
            }

        return usb.get(teuer);
    }

    public static void testUSB(){
        usb.addAll(List.of(15,45,20));
        assert teuersteUSB(30)==20;
        usb.removeAll(List.of(15,45,20));
    }
    public static void failedTestUSB(){
        usb.addAll(List.of(15,45,20));
        assert teuersteUSB(30)==45;
        usb.removeAll(List.of(15,45,20));
    }

    /**
     * Finden Sie, anhand des Markus Budget und der Preislisten für die Tastaturen und USB-Laufwerke,
     * den Geldbetrag Markus ausgeben wird. Wenn er nicht genug für beide hat, geben Sie stattdessen -1 zurück.
     * Er kauft nur die zwei benötigten Gegenstände.
     * z.B. b=60, tastaturen = [40 50 60] und usb Laufwerke = [8 12] => 50 + 8 = 58
     */
    private static int[] bestCombo(int buget) {
        tastaturen.sort(Comparator.reverseOrder());
        usb.sort(Comparator.reverseOrder());
//        //int i=usb.size()-1,j=tastaturen.size()-1;
//        int i=0,j=0;
//        int aux=0;
//        //while(usb.get(i)+tastaturen.get(j)<=buget && i>=0 && j>=0)
//        while(usb.get(i)+tastaturen.get(j)<buget && i<usb.get(j) && j<tastaturen.get(j))
//        {
//            if(aux%2==0)  i--;
//            else j--;
//            aux++;
//        }
        int i,j,sum;
        int[] maxC={0,0};
        for ( i = usb.size() - 1; i >= 0; i--)
            for ( j = tastaturen.size() - 1; j >= 0; j--) {
                sum=tastaturen.get(j)+usb.get(i);
                if(sum<=buget && usb.get(j) > maxC[0] && tastaturen.get(j) > maxC[0]) {
                    maxC[0]=usb.get(i);
                    maxC[1]=tastaturen.get(j);
                }
            }
        //int[] rez={usb.get(i), tastaturen.get(j)};
        return  maxC;
    }

    private static void testBestC(){
        tastaturen.addAll(List.of(15,20,10,40));
        usb.addAll(List.of(20, 15, 35, 15));
        assert(bestCombo(60)[0]== 20);
        assert(bestCombo(60)[1]== 40);
        tastaturen.removeAll(List.of(15,20,10,40));
        usb.removeAll(List.of(20, 15, 35, 15));
    }
    private static void failedTestBestC(){
        tastaturen.addAll(List.of(15,20,10,40));
        usb.addAll(List.of(20, 15, 35, 15));
        assert(bestCombo(60)[0]== 20);
        assert(bestCombo(60)[1]== 20);
        tastaturen.removeAll(List.of(15,20,10,40));
        usb.removeAll(List.of(20, 15, 35, 15));
    }

    public static void  mainPb4(){
        testBillig();
        //failedTestBillig();
        testTeuerG();
        //failedTestTeuerG();
        testUSB();
        //failedTestUSB();
        testBestC();
        //failedTestBestC();
    }

}
