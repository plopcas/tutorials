public class FindDuplicateOptimizeForSpace {

    public int findDuplicateNotOptimized(int[] intArray) {
        int[] countInt = new int[intArray.length + 1];
        for (int i = 0; i < intArray.length; i++) {
            countInt[intArray[i]]++;
            if (countInt[intArray[i]] > 1) {
                return intArray[i];
            }
        }
        return -1;
    }

    public int findDuplicateABitOptimized(int[] intArray) {
        Set<Integer> seenNumbers = new HashSet<>();
        for (int i = 0; i < intArray.length; i++) {
            if (seenNumbers.contains(intArray[i])) {
                return intArray[i];
            } else {
                seenNumbers.add(intArray[i]);
            }
        }
        return -1;
    }

    // O(1) space but O(n^2) time
    public int findDuplicateOptimizedForSpaceButNotForTime(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray.length; j++) {
                if (i != j && intArray[i] == intArray[j]) {
                    return intArray[i];
                }
            }
        }
        return -1;
    }

    // O(1) space and O(nlogn) time
    public int findDuplicateOptimized(int[] intArray) {
        // sort in place
        Arrays.sort(intArray);
        // check two adjancet values are the same
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] == intArray[i - 1]) {
                return intArray[i];
            }
        }
        return -1;
    }

    public int findDuplicateOptimizedWithoutInPlaceSorting(int[] intArray) {
        int countUpper = 0;
        int countLower = 0;
        int floorIndex = 1;
        int ceilingIndex = intArray.length - 1;
        while (floorIndex < ceilingIndex) {
            int midIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);
            for (int i = 0; i < intArray.length; i++) {
                if (i != midIndex) {
                    if (intArray[i] < intArray[midIndex]) {
                        countLower++;
                    } else if (intArray[i] > intArray[midIndex]) {
                        countUpper++;
                    } else {
                        return intArray[i];
                    }
                }
            }
            System.out.println("----");
            System.out.println("Indexes:" + floorIndex + " " + midIndex + " " + ceilingIndex);
            System.out.println("Values: " + intArray[floorIndex] + " " + intArray[midIndex] + " " + intArray[ceilingIndex]);
            System.out.println("Counts: " + countLower + " " + countUpper);
            if (countLower > countUpper) {
                ceilingIndex = midIndex;
            } else {
                floorIndex = midIndex;
            }
        }
        return intArray[floorIndex];
    }
}