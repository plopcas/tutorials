public class CakeThief {
    // this greedy approach doesn't always return the maximum value
    public static long maxDuffelBagValueGreedy(CakeType[] cakeTypes, int capacity) {
        Arrays.sort(cakeTypes, new Comparator<CakeType>() {
            public int compare(CakeType o1, CakeType o2) {
                return Integer.valueOf(o2.value).compareTo(Integer.valueOf(o1.value));
            }
        });
        long bagValue = 0;
        int bagWeight = 0;
        for (CakeType cakeType : cakeTypes) {
            while (cakeType.weight <= capacity - bagWeight) {
                System.out.println(cakeType.weight + " " + (capacity - bagWeight));
                bagValue += cakeType.value;
                bagWeight += cakeType.weight;
            }
        }
        return bagValue;
    }

    public static long maxDuffelBagValueRatio(CakeType[] cakeTypes, int capacity) {
        Arrays.sort(cakeTypes, new Comparator<CakeType>() {
            public int compare(CakeType o1, CakeType o2) {
                Float o1ValuePerWeightUnit = ((float) o1.value / o1.weight);
                Float o2ValuePerWeightUnit = ((float) o2.value / o2.weight);
                return o2ValuePerWeightUnit.compareTo(o1ValuePerWeightUnit);
            }
        });
        long bagValue = 0;
        int bagWeight = 0;
        for (CakeType cakeType : cakeTypes) {
            while (cakeType.weight <= capacity - bagWeight) {
                System.out.println(cakeType.weight + " " + (capacity - bagWeight));
                bagValue += cakeType.value;
                bagWeight += cakeType.weight;
            }
        }
        return bagValue;
    }

    public static long maxDuffelBagValueRatio(CakeType[] cakeTypes, int capacity) {
        long[] maxValuesAtCapacities = new long[capacity + 1];

        for (int currentCapacity = 0; currentCapacity <= capacity; currentCapacity++) {
            long currentMaxValue = 0;
            for (CakeType cake : cakeTypes) {
                if (cake.weight == 0 && cake.value != 0) {
                    throw new RuntimeException("Infinity");
                }
                if (cake.weight > currentCapacity) {
                    continue;
                }
                long maxValueUsingCake = cake.value + maxValuesAtCapacities[currentCapacity - cake.weight];
                currentMaxValue = Math.max(maxValueUsingCake, currentMaxValue);
            }
            maxValuesAtCapacities[currentCapacity] = currentMaxValue;
        }

        return maxValuesAtCapacities[capacity];
    }
}

public class CakeType {

    final int weight;
    final int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}