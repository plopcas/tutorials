public class ParenthesisMatching {
    // not the actual question
    public int findLastParenthesis(String sentence) {

        for (int i = sentence.length() - 1; i >= 0; i--) {
            if (sentence.charAt(i) == ')') {
                return i;
            }
        }

        throw new RuntimeException("No closing parenthesis found");
    }

    // O(n) time and O(n) space
    public int getClosingParenthesis(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = openingParenIndex; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '(') {
                stack.push(i);
            } else if (sentence.charAt(i) == ')') {
                stack.pop(i);
            }
            if (stack.isEmpty()) {
                return i;
            }
        }
        throw new RuntimeException("No closing parenthesis found");
    }

    // O(n) time and O(1) space
    public int getClosingParenthesisOptimised(String sentence, int openingParenIndex) {
        int p = 0;
        for (int i = openingParenIndex; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '(') {
                p++;
            } else if (sentence.charAt(i) == ')') {
                p--;
                if (p == 0) {
                    return i;
                }
            }
        }
        throw new RuntimeException("No closing parenthesis found");
    }

    // we can save a couple of operations if we start in openingParenIndex + 1
    public int getClosingParenthesisMoreOptimised(String sentence, int openingParenIndex) {
        int p = 0;
        for (int i = openingParenIndex + 1; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '(') {
                p++;
            } else if (sentence.charAt(i) == ')') {
                if (p == 0) {
                    return i;
                }
                else {
                    p--;
                }
            }
        }
        throw new RuntimeException("No closing parenthesis found");
    }
}