public class WordCloud {

    public Map buildCloud(String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            String cleanedWord = cleanWord(word);
            if (words.containsKey(cleanedWord)) {
                words.put(cleanedWord, words.get(cleanedWord) + 1);
            } else {
                words.put(cleanedWord, 1);
            }
        }
        return counts;
    }

    private String cleanWord(String word) {
        return word.replace(".", "").replace(",", "").replace("!", "").replace("?", "").toLowerCase();
    }

    // Better alternative with custom split
    public Map buildCloudCustomSplit(String sentence) {
        List<String> words = splitWords(sentence);
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }
        return counts;
    }

    private List<String> splitWords(String sentence) {
        List<String> words = new ArrayList<>();
        int currentWordStart = 0;
        int currentWordEnd = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (i == sentence.length() - 1) {
                if (Character.isLetter(c)) {
                    currentWordEnd++;
                }
                if (currentWordEnd > currentWordStart) {
                    words.add(sentence.substring(currentWordStart, currentWordEnd));
                }
            } else if (Character.isLetter(c) || c == '\'') {
                if (currentWordStart == currentWordEnd) {
                    currentWordStart = i;
                }
            } else {
                if (currentWordStart != currentWordEnd) {
                    words.add(sentence.substring(currentWordStart, currentWordEnd));
                    currentWordStart = currentWordEnd + 1;
                }
            }
            currentWordEnd++;
        }
        return words;
    }
}