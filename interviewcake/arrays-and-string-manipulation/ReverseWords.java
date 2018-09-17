public class ReverseWords {

    public static void main(String[] args) {
        char[] message = {
                'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l'};

        reverseWords(message); // "steal pound cake"
    }

    public static void reverseWords(char[] message) {
        // Not in place
        char[] reversed = reverseWordsNotInPlace(message);
        for (int i = 0; i < message.length; i++) {
            message[i] = reversed[i];
        }
        System.out.println(message);

        // In place
        reverseInPlace(message);
        System.out.println(message);
    }

    public static void reverseInPlace(char[] message) {
        reverseCharacters(message, 0, message.length - 1);
        int startIndex = 0;
        for (int currentIndex = 0; currentIndex < message.length; currentIndex++) {
            // Check for the length first to avoid index out of bound exception
            if (currentIndex == message.length || message[currentIndex] == ' ') {
                reverseCharacters(message, startIndex, currentIndex - 1);
                startIndex = currentIndex + 1;
            }
        }
    }

    public static char[] reverseNotInPlace(char[] message) {
        char[] reversedWords = new char[message.length];
        int wordEnd = message.length - 1;
        int wordStart;
        int x = 0;
        for (int i = message.length - 1; i >= 0; i--) {
            if (message[i] == ' ') {
                wordStart = (i == 0 ? 0 : i + 1);
                for (int j = wordStart; j <= wordEnd; j++) {
                    reversedWords[x] = message[j];
                    x++;
                }
                wordEnd = i - 1;
                reversedWords[x] = ' ';
                x++;
            } else if (i == 0) {
                for (int j = 0; j <= wordEnd; j++) {
                    reversedWords[x] = message[j];
                    x++;
                }
            }
        }
        return reversedWords;
    }

    private static void reverseCharacters(char[] characters, int leftIndex, int rightIndex) {
        int length = rightIndex - leftIndex + 1;
        int i = leftIndex;
        int j = rightIndex;
        for (; i < leftIndex + (length / 2); ) {
            char temp = characters[j];
            characters[j] = characters[i];
            characters[i] = temp;
            j--;
            i++;
        }
    }

}