public class SingleRiffleCheck {
    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

        // check if the shuffled deck is a single riffle of the halves
        int half1Index = 0;
        int half2Index = 0;
        for (int currentCard : shuffledDeck) {
            if (half1Index < half1.length && currentCard == half1[half1Index]) {
                half1Index++;
            } else if (half2Index < half2.length && currentCard == half2[half2Index]) {
                half2Index++;
            } else {
                return false;
            }
        }
        return true;
    }
}