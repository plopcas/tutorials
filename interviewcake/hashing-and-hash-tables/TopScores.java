public class TopScores {
    public int[] sortScores(int[] unsortedScores, int maxPossibleScore) {
        // Put all the values in a map as keys and count
        Map<Integer, Integer> scoreCount = new HashMap<>();
        for (int i = 0; i < unsortedScores.length; i++) {
            int key = unsortedScores[i];
            if (!scoreCount.containsKey(key)) {
                scoreCount.put(key, 1);
            } else {
                scoreCount.put(key, scoreCount.get(key) + 1);
            }
        }

        // Get all the values from the map in order
        int[] result = new int[unsortedScores.length];
        int resultIndex = 0;
        for (int i = maxPossibleScore; i >= 0; i--) {
            if (scoreCount.containsKey(i)) {
                int count = scoreCount.get(i);
                for (int j = resultIndex; j < resultIndex + count; j++) {
                    result[j] = i;
                }
                resultIndex = resultIndex + count;
            }
        }

        return result;
    }
}