public class FindRotationPoint {
    public int findRotationPoint(String[] words) {
        int floor = 0;
        int ceiling = words.length;
        //v w x y z a b c
        //y z a b c d e f
        while (ceiling - floor > 1) {
            int currentIndex = floor + ((ceiling - floor) / 2);
            String currentWord = words[currentIndex];
            if (currentWord.compareTo(words[0]) >= 0) {
                floor = currentIndex;
            } else {
                ceiling = currentIndex;
            }
        }
        return ceiling;
    }
}