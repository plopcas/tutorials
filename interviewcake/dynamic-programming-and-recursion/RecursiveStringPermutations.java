public class RecursiveStringPermutations {
    public Set<String> getPermutations(String word) {
        // cats
        // cat
        // ca
        // c -> ac ca

        if (word.length() <= 1) {
            return new HashSet<>(Arrays.asList(word));
        }

        Set<String> result = new HashSet<>();

        char lastChar = word.charAt(word.length() - 1);
        String wordMinusLastChar = word.substring(0, word.length() - 1);
        Set<String> permutations = getPermutations(wordMinusLastChar);
        for (String p : permutations) {
            for (int i = 0; i <= p.length(); i++){
                result.add(p.substring(0, i) + lastChar + p.substring(i));
            }
        }

        return result;
    }
}