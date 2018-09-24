public class ProductOfOtherNumbers {

    public static int[] getProductsOfAllIntsExceptAtIndexBruteForce(int[] intArray) {
        if (intArray.length < 2) {
            throw new RuntimeException();
        }
        int[] result = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            result[i] = 1;
            for (int j = 0; j < intArray.length; j++) {
                if (i != j) {
                    result[i] = result[i] * intArray[j];
                }
            }
        }
        return result;
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {
        if (intArray.length < 2) {
            throw new RuntimeException();
        }
        int[] productsOfAllIntsExceptAtIndex = new int[intArray.length];
        int productSoFar = 1;
        for (int i = 0; i < intArray.length; i++) {
            productsOfAllIntsExceptAtIndex[i] = productSoFar;
            productSoFar = productSoFar * intArray[i];
        }
        productSoFar = 1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            productsOfAllIntsExceptAtIndex[i] = productsOfAllIntsExceptAtIndex[i] * productSoFar;
            productSoFar = productSoFar * intArray[i];
        }
        return productsOfAllIntsExceptAtIndex;
    }

}