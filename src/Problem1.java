class Problem1 {

    //TODO teste

    private static boolean ausreichend(int note) {
        if (note < 40) return false;
        return true;
    }

    //TODO refacut pt 82 se duce in jos
    private static int aufrunden(int note) {
        if (!ausreichend(note)) return note;
        int i;
        for (i = 0; i <= 4; i++)
            if (note + i % 5 == 0) {
                break;
            }
        return note + i;
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode ein Array mit nicht ausreichende Note liefern.
     */
    public static int[] nichtAusrNoten(int[] noten) {
        int[] rez = new int[10];
        int j = 0;
        for (int i = 0; i < noten.length; i++)
            if (ausreichend(noten[i]))
                rez[j++] = noten[i];
        return rez;
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode den Durchschnittswert liefern.
     */
    public static int durchschnitt(int[] noten) {
        int sum = 0;  //double sum=0.
        for (int i = 0; i < noten.length; i++)
            sum += noten[i];
        return sum / noten.length;
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode eine Array mit die abgerundete Note liefern.
     */
    public static int[] abgerundeteNoten(int[] noten) {
        int[] rez = new int[noten.length];
        for (int i = 0; i < noten.length; i++)
            rez[i] = aufrunden(noten[i]);
        return rez;
    }

    /**
     * Schreiben Sie eine Methode, die ein Array von Noten bekommen soll.
     * Als die Rückgabewert soll die Methode die maximale abgerundete Note liefern.
     */

    public static int maxAbgNote(int[] noten) {
        int newNoten[] = abgerundeteNoten(noten);
        int maxNote = newNoten[0];
        for (int i = 1; i < newNoten.length; i++)
            if (newNoten[i] > maxNote)
                maxNote = newNoten[i];
        return maxNote;
    }
}