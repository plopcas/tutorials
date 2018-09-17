public class SingleRiffleCheck {

    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {

        // check if the shuffled deck is a single riffle of the halves

        // edge cases (not necessary, because the main algorithm also works with these)
        /*if (half1.length == 0 && half2.length == 0 && shuffledDeck.length > 0) {
            return false;
        } else if (half1.length + half2.length != shuffledDeck.length) {
            return false;
        } else if (half1.length == 0 && half2.length != 0) {
            for (int i = 0; i < shuffledDeck.length; i++) {
                if (shuffledDeck[i] != half2[i]) {
                    return false;
                }
            }
            return true;
        } else if (half1.length != 0 && half2.length == 0) {
            for (int i = 0; i < shuffledDeck.length; i++) {
                if (shuffledDeck[i] != half1[i]) {
                    return false;
                }
            }
            return true;
        }*/

        int half1Index = 0;
        int half2Index = 0;

        for (int i = 0; i < shuffledDeck.length; i++) {
            if (shuffledDeck[i] == half1[half1Index]) {
                half1Index++;
            } else if (shuffledDeck[i] == half2[half2Index]) {
                half2Index++;
            } else {
                return false;
            }
        }

        return true;
    }
}