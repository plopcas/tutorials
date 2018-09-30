public class BracketValidator {

    // this doesn't work with interleaved openers and closers e.g. {[}] should return false
    public boolean isValidBuggy(String code) {
        int braces = 0;
        int brackets = 0;
        int parenthesis = 0;

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '{') {
                braces++;
            } else if (c == '[') {
                brackets++;
            } else if (c == '(') {
                parenthesis++;
            } else if (c == '}') {
                braces--;
            } else if (c == ']') {
                brackets--;
            } else if (c == ')') {
                parenthesis--;
            }
        }

        if (braces == 0 && brackets == 0 && parenthesis == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValid(String code) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                // we have a closer but no openers
                if (stack.isEmpty()) {
                    return false;
                }
                // we have a closer that doesn't match the last opener
                char lastOpener = stack.pop();
                if ((c == '}' && lastOpener != '{')
                        || (c == ']' && lastOpener != '[')
                        || (c == ')' && lastOpener != '(')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // this takes into account missing closers
    }
}