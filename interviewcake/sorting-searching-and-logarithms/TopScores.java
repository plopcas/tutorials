public class TopScores {

    private final static int MAX_SCORE = 100;

    public int[] sortScores(int[] scores) {
        int[] countScores = new int[MAX_SCORE + 1];
        for (int i = 0; i < scores.length; i++) {
            countScores[scores[i]]++;
        }
        int[] sortedScores = new int[scores.length];
        int sortedScoresIndex = 0;
        for (int i = maxScore; i >= 0; i--) {
            int currentCount = countScores[i];
            for (int j = 0; j < currentCount; j++) {
                sortedScores[sortedScoresIndex] = i;
                sortedScoresIndex++;
            }
        }
        return sortedScores;
    }
}