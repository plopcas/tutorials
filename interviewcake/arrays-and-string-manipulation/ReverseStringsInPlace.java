public class ReverseStringsInPlace {

    public char[] reverseNotInPlace(char[] characters) {
        char[] reversed = new char[characters.length];
        int j = 0;
        for (int i = characters.length - 1 ; i >= 0; i--) {
            reversed[j] = characters[i];
            j++;
        }
        return reversed;
    }

    public void reverseInPlace(char[] characters) {
        int length = characters.length;
        int i = 0;
        int j = length - 1;
        for ( ; i < length / 2 ; ) {
            char temp = characters[j];
            characters[j] = characters[i];
            characters[i] = temp;
            j--;
            i++;
        }
    }

}