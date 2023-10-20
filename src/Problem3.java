import static java.lang.Math.abs;

public class Problem3 {
    //todo teste si diviziunea

    /**
     * Es gibt 2 große Zahlen. Die Zahlen sind als Array dargestellt.
     * <p>
     * Berechnen Sie die Summe. Die Zahlen haben die gleiche Anzahl an Ziffern.
     * z.B. [1 3 0 0 0 0 0 0 0] + [8 7 0 0 0 0 0 0 0] = [1 0 0 0 0 0 0 0 0 0]
     */



    private static int[] sum(int[] zahl1, int[] zahl2) {

        int[] rez = new int[zahl1.length];
        int offset=0;

        for(int i= zahl1.length-1;i>=0;i--)
        {
            rez[i]=(zahl1[i]+zahl2[i]+offset)%10;

            if(zahl1[i]+zahl2[i]+offset>9)
                offset=(zahl1[i]+zahl2[i]+offset)/10;
            else offset=0;
        }
        if(offset!=0) {
            for (int i = rez.length-1; i > 0; i--)
                rez[i]=rez[i-1];
            rez[0]=1;
        }

        return rez;
    }


    private static void testSum() {
        int[] z1 = {1, 3, 0, 0};
        int[] z2 = {8, 7, 0, 0};
        int[] output = {1, 0, 0, 0, 0};
        int[] out = sum(z1, z2);
        for (int i = 0; i < out.length; i++) {
            //System.out.println(i + " - " + out[i] + " , " + output[i]);
            assert (out[i] == output[i]);
        }
    }

    private static void failedTestSum() {
        int[] z1 = {1, 3, 0, 0};
        int[] z2 = {8, 7, 0, 0};
        int[] output = {0,10, 0, 0, 0};
        int[] out = sum(z1, z2);
        for (int i = 1; i < out.length; i++)
            assert (out[i] == output[i]);
    }

    /**
     * Berechnen Sie die Differenz. Die Zahlen haben die gleiche Anzahl an Ziffern.
     * z.B. [8 3 0 0 0 0 0 0 0] - [5 4 0 0 0 0 0 0 0] = [2 9 0 0 0 0 0 0 0]
     */
    private static int[] diff(int[] zahl1, int[] zahl2) {
        int[] rez = new int[zahl1.length];
        int offset=0;
        for (int i = zahl1.length - 1; i >= 0; i--) {
            if (zahl1[i] - zahl2[i]-offset < 0) {
                rez[i] =10- Math.abs(zahl1[i]-zahl2[i]);
                offset=1;
            }
            else {
                rez[i] =(zahl1[i] - zahl2[i]-offset);
                offset = 0;
            }
        }
        return rez;
    }

    private static void testDiff() {
        int[] z1 = {8, 3, 0, 0};
        int[] z2 = {5, 4, 0, 0};
        int[] output = {2, 9, 0, 0};
        int[] out = diff(z1, z2);
        for (int i = 0; i < out.length; i++) {
            //System.out.println(i + " - " + out[i] + " , " + output[i]);
            assert (out[i] == output[i]);
        }
    }
  private static void failedTestDiff() {
        int[] z1 = {8, 3, 0, 0};
        int[] z2 = {5, 4, 0, 0};
        int[] output = {2, 9, 0, 0};
        int[] out = diff(z1, z2);
        for (int i = 0; i < out.length; i++) {
            assert (out[i] != output[i]);
        }
    }

    /**
     * Berechnen Sie die Multiplikation. Erste Zahl ist ein große Zahl,
     * der Zweite Zahl ist nur ein Ziffer.
     * z.B. [2 3 6 0 0 0 0 0 0] * 2 = [4 7 2 0 0 0 0 0 0]
     */
    private static int[] multi(int[] zahl1, int ziff) {
        //if(zahl1.length==zahl2.length)
        int[] rez = new int[zahl1.length];
        int offset=0;
        for(int i=0;i<ziff;i++){
            rez=sum(zahl1,rez);
        }

//        for (int i = zahl1.length - 1; i >= 0; i--) {
//            if (zahl1[i] * ziff > 9)
//                rez[i] = (zahl1[i] * ziff) / 10;
//            rez[i + 1] += (zahl1[i] * ziff) % 10;
//        }
        return rez;
    }

    private static void testMulti() {
        int[] z1 = {2, 3, 6, 0};
        int z2 = 2;
        int[] output = {4, 7, 2, 0};
        int[] out = multi(z1, z2);
        for (int i = 0; i < out.length; i++) {
            assert (out[i] == output[i]);
            //System.out.println(i + " - " + out[i] + " , " + output[i]);
        }
    }
    private static void failedTestMulti() {
        int[] z1 = {2, 3, 6, 0};
        int z2 = 2;
        int[] output = {4, 7, 2, 0};
        int[] out = multi(z1, z2);
        for (int i = 0; i < out.length; i++) {
            assert (out[i] != output[i]);
        }
    }

    /**
     * Berechnen Sie die ganzzahlige Division. Erste Zahl ist ein große Zahl,
     * der Zweite Zahl ist nur ein Ziffer.
     * z.B. [2 3 6 0 0 0 0 0 0] / 2 = [1 1 8 0 0 0 0 0 0]
     */
    private static int[] diviz(int[] zahl1, int ziff) {
        int[] rez = new int[zahl1.length];
        int offset=0, aux_rez;
        for (int i = 0; i < zahl1.length; i++) {
            aux_rez=zahl1[i]+offset*10;
            rez[i]=aux_rez/ziff;
            offset=aux_rez%ziff;
        }
        return rez;
    }


    private static void testDiviz() {
        int[] z1 = {2, 3, 6, 0};
        int z2 = 2;
        int[] output = {1, 1, 8, 0};
        int[] out = diviz(z1, z2);
        for (int i = 0; i < out.length; i++) {
            assert (out[i] == output[i]);
        }
    }
    private static void failedTestDiviz() {
        int[] z1 = {2, 3, 6, 0};
        int z2 = 2;
        int[] output = {1, 1, 8, 0};
        int[] out = diviz(z1, z2);
        for (int i = 0; i < out.length; i++) {
            assert (out[i] != output[i]);
        }
    }

    public static void mainPb3() {
        testSum();
        //failedTestSum();
        testDiff();
        //failedTestDiff();
        testMulti();
        //failedTestMulti();
        testDiviz();
        //failedTestDiviz();
    }
}
