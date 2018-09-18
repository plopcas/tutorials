public class PermutationPalindrome {
    public boolean isAnyPermutationPalidrome(String word) {
        // We use the set to keep track of the presence of the letters
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (letters.contains(c)) {
                letters.remove(c);
            } else {
                letters.add(c);
            }
        }
        if ((word.length() % 2 == 0 && letters.size() == 0) || (word.length() % 2 != 0 && letters.size() == 1)) {
            return true;
        } else {
            return false;
        }
    }
}