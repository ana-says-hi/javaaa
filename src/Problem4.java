import java.util.ArrayList;
import java.util.Comparator;

public class Problem4 {
    //todo tests
    /**
     * Markus will ein USB Laufwerk und eine Tastatur kaufen. Der Elektronik-Shop hat verschiedene USB Laufwerke
     * und Tastaturen mit verschiedene Preise, als Array von Zahlen dargestellt.
     */

    ArrayList<Integer> tastaturen = new ArrayList<>();
    ArrayList<Integer> usb = new ArrayList<>();

    /**
     * Schreiben Sie eine Methode, die die billigste Tastatur zurückgibt.
     * z.B. [40 35 70 15 45] => 15
     */
    public int billigsteT() {
        int billig = 0;
        for (int i = 1; i < tastaturen.size(); i++)
            if (tastaturen.indexOf(billig) > tastaturen.indexOf(i)) {
                billig = i;
            }
        return tastaturen.indexOf(billig);
    }

    /**
     * Schreiben Sie eine Methode, die die teuerste Gegenstand zurückgibt.
     * z.B. Tastatur = [15 20 10 35], USB = [20, 15, 40 15] => 40
     */
    public int teuersteG() {
        int teuer1 = 0;
        int teuer2 = 0;
        for (int i = 1; i < tastaturen.size(); i++)
            if (tastaturen.indexOf(teuer1) > tastaturen.indexOf(teuer1)) {
                teuer1 = i;
            }
        for (int i = 1; i < usb.size(); i++)
            if (usb.indexOf(teuer2) > tastaturen.indexOf(teuer2)) {
                teuer2 = i;
            }
        if (tastaturen.indexOf(teuer1) > usb.indexOf(teuer2))
            return tastaturen.indexOf(teuer1);
        else return usb.indexOf(teuer2);
    }

    /**
     * Schreiben Sie eine Methode, die die teuerste USB Laufwerk, die Markus kaufen kann, zurückgibt.
     * z.B. Preise = [15 45 20], Budget = 30 => 20
     */
    public int teuersteUSB(int buget) {
        int teuer = 0;
        for (int i = 0; i < usb.size(); i++)
            if (usb.indexOf(teuer) < buget) {
                {
                    teuer = i;
                    break;
                }
            }
        for (int i = teuer; i < usb.size(); i++)
            if (usb.indexOf(i) < buget && usb.indexOf(teuer) < usb.indexOf(i)) {
                {
                    teuer = i;
                }
            }

        return usb.indexOf(teuer);
    }


    /**
     * Finden Sie, anhand des Markus Budget und der Preislisten für die Tastaturen und USB-Laufwerke,
     * den Geldbetrag Markus ausgeben wird. Wenn er nicht genug für beide hat, geben Sie stattdessen -1 zurück.
     * Er kauft nur die zwei benötigten Gegenstände.
     * z.B. b=60, tastaturen = [40 50 60] und usb Laufwerke = [8 12] => 50 + 8 = 58
     */
    public int bestCombo(int buget) {
        tastaturen.sort(Comparator.reverseOrder());
        usb.sort(Comparator.reverseOrder());
        int i=usb.size(),j=tastaturen.size();
        while(usb.indexOf(i)+tastaturen.indexOf(j)<buget && i>=0 && j>=0)
        {
            //se ingtampla cv
        }
//        for (int i = usb.size() - 1; i >= 0; i--)
//            for (int j = tastaturen.size() - 1; j > 0; j--) {
//                //todo cu while, daca suma e in buget
//            } max absolut, mai mmic decat bugetul
        //mic e din bistrtza lol sau nu idk
        return 0;
    }


}
