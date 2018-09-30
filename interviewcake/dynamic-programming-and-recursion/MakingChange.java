public class MakingChange {

    private static Map<String, Integer> memo = new HashMap<>();

    public static int computeDenominations(int amount, int[] denominations) {
        // return computeTopDown(amount, denominations, 0);
        return computBottomUp(amount, denominations);
    }

    private static int computeTopDown(int amountLeft, int[] denominations, int index) {

        // memo check
        String key = amountLeft + "," + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // base cases

        if (amountLeft == 0) {
            return 1;
        }

        if (amountLeft < 0) {
            return 0;
        }

        if (index == denominations.length) {
            return 0;
        }

        int currentCoin = denominations[index];
        int numberOfPosibilites = 0;
        while (amountLeft >= 0) {
            numberOfPosibilites += computeTopDown(amountLeft, denominations, index + 1);
            amountLeft -= currentCoin;
        }

        memo.put(key, numberOfPosibilites);
        return numberOfPosibilites;
    }

    private static int computBottomUp(int amount, int[] denominations) {
        int[] ways = new int[amount + 1];
        ways[0] = 1;
        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                ways[higherAmount] += ways[higherAmount - coin];
            }
        }
        return ways[amount];
    }
}