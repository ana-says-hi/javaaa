import java.util.NoSuchElementException;

class Problem1 {

    //TODO nr pt care apelam

//    private static boolean ausreichend(int note) {
//        if (note < 40) return false;
//        return true;
//    }


    private static int aufrunden(int note) {
        if (note < 38) return note;
        int i;
        boolean rounded = false;
        for (i = 1; i <= 3; i++)
            if ((note + i) % 5 == 0) {
                return note + i;
            }
        return note;
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode ein Array mit nicht ausreichende Note liefern.
     */
    private static int[] nichtAusrNoten(int[] noten) {
        int[] rez = new int[noten.length];
        int j = 0;
        for (int i = 0; i < noten.length; i++)
            if (noten[i] < 40)
                rez[j++] = noten[i];
        return rez;
    }

    private static void testAusr() throws Exception {
        int input[] = {45, 20, 56, 78, 91, 34};
        int output[] = {20, 34};
        int out[] = nichtAusrNoten(input);
        for (int i = 0; i < output.length; i++)
            if (out[i] != output[i])
                throw new Exception("smth is wrong!");
        //System.out.println("test 1 passed!");
    }

    private static void failedTestAusr() throws Exception {
        int input[] = {45, 20, 56, 78, 91, 34};
        int output[] = {45, 20, 34};
        int out[] = nichtAusrNoten(input);
        for (int i = 0; i < out.length; i++)
            if (out[i] != output[i])
                throw new Exception("Test1: smth is wrong!");
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode den Durchschnittswert liefern.
     */
    private static int durchschnitt(int[] noten) {
        int sum = 0;  //double sum=0.
        for (int i = 0; i < noten.length; i++)
            sum += noten[i];
        return sum / noten.length;
    }

    private static void testDurchsch() throws Exception {
        int input[] = {45, 20, 56, 78, 91, 34};
        int output = 54;
        if (output != durchschnitt(input))
            throw new Exception("smth is wrong!");
        //System.out.println("test 2 passed!");
    }

    private static void failedTestDurchsch() throws Exception {
        int input[] = {45, 20, 56, 78, 91, 34};
        int output = 20;
        if (output != durchschnitt(input))
            throw new Exception("Test2: smth is wrong!");
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode eine Array mit die abgerundete Note liefern.
     */
    private static int[] abgerundeteNoten(int[] noten) {
        int[] rez = new int[noten.length];
        for (int i = 0; i < noten.length; i++)
            rez[i] = aufrunden(noten[i]);
        return rez;
    }

    private static void testAbrund() throws Exception {
        int input[] = {44, 23, 57, 78, 91, 34};
        int output[] = {45, 23, 60, 80, 91, 34};
        int outp[] = abgerundeteNoten(input);

        for (int i = 0; i < outp.length; i++) {
            //System.out.println(outp[i]);
//            System.out.println(i + '-' + outp[i] + ' ' + output[i]);
            if (outp[i] != output[i]) {
                throw new Exception("smth is wrong!");
            }
        }
        //System.out.println("test 3 passed!");
    }

    private static void failedTestAbrund() throws Exception {
        int input[] = {44, 23, 56, 78, 91, 34};
        int output[] = {44, 23, 60, 80, 91, 34};
        int out[] = abgerundeteNoten(input);
        for (int i = 0; i < out.length; i++)
            if (out[i] != output[i])
                throw new Exception("Test3: smth is wrong at index " + i);
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode die maximale abgerundete Note liefern.
     */

    private static int maxAbgNote(int[] noten) {
        int newNoten[] = abgerundeteNoten(noten);
        int maxNote = newNoten[0];
        for (int i = 1; i < newNoten.length; i++)
            if (newNoten[i] > maxNote)
                maxNote = newNoten[i];
        return maxNote;
    }

    private static void testMaxAbgN() throws Exception {
        int input[] = {45, 20, 56, 78, 94, 34};
        int output = 95;
        if (output != maxAbgNote(input))
            throw new Exception("smth is wrong!");
        //System.out.println("test 4 passed!");
    }

    private static void failedTestMaxAbgN() throws Exception {
        int input[] = {45, 20, 56, 78, 94, 34};
        int output = 94;
        if (output != maxAbgNote(input))
            throw new Exception("Test4: smth is wrong!");
    }

    public static void mainPb1() throws Exception {
        testAusr();
        //failedTestAusr();
        testDurchsch();
        //failedTestDurchsch();
        testAbrund();
        //failedTestAbrund();
        testMaxAbgN();
        //failedTestMaxAbgN();
        System.out.println("All tests passed!\n");

        int[] exemplu = {12, 46, 89, 32, 54, 65, 78};
        for (int i = 1; i < exemplu.length; i++)
            System.out.print(exemplu[i] + ' ');
        System.out.println("\nDie nicht ausreichende Noten sind:");
        int[] klNoten = nichtAusrNoten(exemplu);
        for (int i = 1; i < klNoten.length; i++)
            System.out.print(klNoten[i] + ' ');
        System.out.println("\nDer Durchschnitt aller Noten ist: "+
                durchschnitt(exemplu));
        System.out.println("Die abgerundete Noten sind:");
        int[] rundNoten = abgerundeteNoten(exemplu);
        for (int i = 1; i < rundNoten.length; i++)
            System.out.print(rundNoten[i] + ' ');
        System.out.println("\nDie groesste gerundete Note ist: "+
                maxAbgNote(exemplu)+"\n\n");
    }
}