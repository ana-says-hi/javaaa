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

    private static void testMax(){
        int[] input={4,8,4,10,17};
        assert(maxZ(input)==17);
    }
    private static void failedTestMax(){
        int[] input={4,8,4,10,17};
        assert(maxZ(input)==10);
    }

    private static int minZ(int[] zahlen) {
        int minim = zahlen[0];
        for (int i = 1; i < zahlen.length; i++)
            if (minim > zahlen[i])
                minim = zahlen[i];
        return minim;
    }

    private static void testMin(){
        int[] input={4,8,4,10,17};
        assert(minZ(input)==4);
    }
    private static void failedTestMin(){
        int[] input={4,8,4,10,17};
        assert(minZ(input)==10);
    }

    private static int maxSum(int[] zahlen) {
        int sum = 0;
        for (int i = 0; i < zahlen.length; i++)
            sum += zahlen[i];
        return sum - minZ(zahlen);
    }

    private static void testMaxSum(){
        int[] input={4,8,4,10,17};
        assert(maxSum(input)==39);
    }

    private static void failedTestMaxSum(){
        int[] input={4,8,4,10,17};
        assert(maxSum(input)==25);
    }

    private static int minSum(int[] zahlen) {
        int sum = 0;
        for (int i = 0; i < zahlen.length; i++)
            sum += zahlen[i];
        return sum - maxZ(zahlen);
    }

    private static void testMinSum(){
        int[] input={4,8,4,10,17};
        assert(minSum(input)==26);
    }

    private static void failedTestMinSum(){
        int[] input={4,8,4,10,17};
        assert(maxSum(input)==39);
    }

    public static void mainPb2(){
        testMin();
        testMax();
        testMinSum();
        testMaxSum();
        System.out.println("All tests passed!");
    }
}
