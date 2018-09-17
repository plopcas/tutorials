public class MergeSortedArrays {

    /*
        Arrays already sorted, and ids are unique between the two arrays.
        This is valid:
            array1 = [1,3,4]
            array2 = [2,5]
        This is not valid:
            array1 = [1,3,4]
            array2 = [3,5]
     */

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {

        // merge both arrays and the sort, O(nlogn)

        int[] mergedArray = Arrays.copyOf(array1, array1.length + array2.length);
        System.arraycopy(array2, 0, mergedArray, array1.length, array2.length);
        Arrays.sort(mergedArray);
        return mergedArray;
    }

    // array1 = [1,3,4]
    // array2 = [2,5]
    public int[] mergeArrays(int[] array1, int[] array2) {

        // input arrays are already sorted, so we can do O(n)

        // edge cases (not necessary really, this is an optimisation)
        if (array1.length == 0) {
            return array2;
        } else if (array2.length == 0) {
            return array1;
        }

        int[] mergedArray = new int[array1.length + array2.length];

        int array1Index = 0;
        int array2Index = 0;

        for (int i = 0; i < mergedArray.length; i++) {

            if (array1Index != array1.length && array2Index != array2.length) {
                if (array1[array1Index] < array2[array2Index]) {
                    mergedArray[i] = array1[array1Index];
                    array1Index++;
                } else {
                    mergedArray[i] = array2[array2Index];
                    array2Index++;
                }
            } else if (array1Index == array1.length && array2Index != array2.length) {
                // we already used all values in array1
                mergedArray[i] = array2[array2Index];
                array2Index++;
            } else if (array1Index != array1.length && array2Index == array2.length) {
                // we already used all values in array2
                mergedArray[i] = array1[array1Index];
                array1Index++;
            }

            // A better and more concise check that does exactly the same
            //if ((array1Index != array1.length
            //        && array2Index != array2.length
            //        && array1[array1Index] < array2[array2Index])
            //  ||(array1Index != array1.length && array2Index == array2.length)) {
            //    mergedArray[i] = array1[array1Index];
            //    array1Index++;
            //} else {
            //    mergedArray[i] = array2[array2Index];
            //    array2Index++;
            //}

            System.out.println(Arrays.toString(mergedArray));

        }

        return mergedArray;
    }
}