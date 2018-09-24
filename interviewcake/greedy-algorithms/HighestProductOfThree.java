public class HighestProductOfThree {
    public static int highestProductOf3(int[] intArray) {

        // calculate the highest product of three numbers
        if (intArray.length < 3) {
            throw new RuntimeException();
        }

        // only works with positive numbers
        int max1 = intArray[0];
        int max2 = intArray[1];
        int max3 = intArray[2];
        for (int i = 3; i < intArray.length; i++) {
            int currValue = intArray[i];
            int temp;
            if (currValue > max1) {
                temp = max1;
                max1 = currValue;
                currValue = temp;
            }
            if (currValue > max2) {
                temp = max2;
                max2 = currValue;
                currValue = temp;
            }
            max3 = Math.max(currValue, max3);
        }
        return max1 * max2 * max3;
    }
}