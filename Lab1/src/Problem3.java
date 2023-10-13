public class Problem3 {
    //todo teste si diviziunea
    
    /**
     * Es gibt 2 große Zahlen. Die Zahlen sind als Array dargestellt.
     *
     * Berechnen Sie die Summe. Die Zahlen haben die gleiche Anzahl an Ziffern.
     * z.B. [1 3 0 0 0 0 0 0 0] + [8 7 0 0 0 0 0 0 0] = [1 0 0 0 0 0 0 0 0 0]
     */
    private static int[] sum(int[] zahl1, int[] zahl2) {
        //if(zahl1.length==zahl2.length)
        int[] rez = new int[zahl1.length + 1];
        rez[zahl1.length] = 0;
        for (int i = zahl1.length - 1; i > 0; i--) {
            if (zahl1[i] + zahl2[i] > 9)
                rez[i] = 1;
            else rez[i] = 0;
            rez[i + 1] += (zahl1[i] + zahl2[i]) % 10;
        }
        return rez;
    }

    /**
     * Berechnen Sie die Differenz. Die Zahlen haben die gleiche Anzahl an Ziffern.
     * z.B. [8 3 0 0 0 0 0 0 0] - [5 4 0 0 0 0 0 0 0] = [2 9 0 0 0 0 0 0 0]
     */
    private static int[] diff(int[] zahl1, int[] zahl2) {
        //if(zahl1.length==zahl2.length)
        int[] rez = new int[zahl1.length + 1];
        rez[zahl1.length] = 0;
        for (int i = zahl1.length - 1; i > 0; i--) {
            if (zahl1[i] - zahl2[i] < 0)
                rez[i] = -1;
            else rez[i] = 0;
            rez[i + 1] += (zahl1[i] - zahl2[i]) % 10;
        }
        return rez;
    }

    /**
     Berechnen Sie die Multiplikation. Erste Zahl ist ein große Zahl, der Zweite Zahl ist nur ein Ziffer.
     z.B. [2 3 6 0 0 0 0 0 0] * 2 = [4 7 2 0 0 0 0 0 0]
     */
    private static int[] multi(int[] zahl1, int ziff) {
        //if(zahl1.length==zahl2.length)
        int[] rez = new int[zahl1.length + 1];
        rez[zahl1.length] = 0;
        for (int i = zahl1.length - 1; i > 0; i--) {
            if (zahl1[i] * ziff > 9)
                rez[i] = (zahl1[i] * ziff) / 10;
            else rez[i] = 0;
            rez[i + 1] += (zahl1[i] * ziff) % 10;
        }
        return rez;
    }

    /**
     * Berechnen Sie die ganzzahlige Division. Erste Zahl ist ein große Zahl, der Zweite Zahl ist nur ein Ziffer.
     *     z.B. [2 3 6 0 0 0 0 0 0] / 2 = [1 1 8 0 0 0 0 0 0]
     */
    private static int[] diviz(int[] zahl1, int ziff) {
        //if(zahl1.length==zahl2.length)
        int[] rez = new int[zahl1.length + 1];
        rez[zahl1.length] = 0;
        for (int i = zahl1.length - 1; i > 0; i--) {
            if (zahl1[i] * ziff > 9)
                rez[i] = (zahl1[i] * ziff) / 10;
            else rez[i] = 0;
            rez[i + 1] += (zahl1[i] * ziff) % 10;
        }
        return rez;
    }
}
