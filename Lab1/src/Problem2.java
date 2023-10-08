public class Problem2 {

    //TODO tests

    /**
     * Es gibt eine Array mit n positive Zahlen.
     * 1. Finden Sie die maximale Zahl.
     * 2. Finden Sie die minimale Zahl.
     * 3. Finden Sie die maximale Summe von n-1 Zahlen. z.B. [4, 8, 3, 10, 17] => 4 + 8 + 10 + 17 = 39
     * 4. Finden Sie die minimale Summe von n-1 Zahlen. z.B. [4, 8, 3, 10, 17] => 4 + 8 + 3 + 10 = 25
     */

    private static int maxZ(int[] zahlen) {
        int maxim = zahlen[0];
        for (int i = 1; i < zahlen.length; i++)
            if (maxim < zahlen[i])
                maxim = zahlen[i];
        return maxim;
    }

    private static int minZ(int[] zahlen) {
        int minim = zahlen[0];
        for (int i = 1; i < zahlen.length; i++)
            if (minim > zahlen[i])
                minim = zahlen[i];
        return minim;
    }

    private static int maxSum(int[] zahlen) {
        int sum = 0;
        for (int i = 0; i < zahlen.length; i++)
            sum += zahlen[i];
        return sum - minZ(zahlen);
    }

    private static int minSum(int[] zahlen) {
        int sum = 0;
        for (int i = 0; i < zahlen.length; i++)
            sum += zahlen[i];
        return sum - maxZ(zahlen);
    }

}
