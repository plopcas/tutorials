public class InflightEntertainment {
    public boolean checkMoviesQuadratic(int f, int[] ms) {
        for (int i = 0; i < ms.length; i++) {
            for (int j = 0; j < ms.length; j++) {
                if (i != j && ms[i] + ms[j] == f) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkMoviedLogarithmic(int f, int[] ms) {
        Arrays.sort(ms);
        for (int i = 0; i < ms.length; i++) {
            int neededValue = f - ms[i];
            int positionOfNeededValue = Arrays.binarySearch(ms, neededValue);
            // To avoid a test case like ms = {3, 8}, f = 6 where only 1 movie is half of the flight,
            // because otherwise we would pick the same movie twice
            if (positionOfNeededValue >= 0 && i != positionOfNeededValue) {
                return true;
            }
        }
        return false;
        ;
    }

    public boolean checkMovieLinear(int f, int[] ms) {
        Set<Integer> lengthsSeen = new HashSet<>();
        for (int i = 0; i < ms.length; i++) {
            int neededValue = f - ms[i];
            if (lengthsSeen.contains(neededValue)) {
                return true;
            } else {
                lengthsSeen.add(ms[i]);
            }
        }
        return false;
    }
}