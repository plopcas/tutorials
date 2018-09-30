public class NthFibonacci {

    public int fib(int n) {

        if (n < 0) {
            throw new RuntimeException();
        }

        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {

        if (n < 0) {
            throw new RuntimeException();
        }

        if (n == 0 || n == 1) {
            return n;
        }

        Map<Integer, Integer> memo = new HashMap<>();

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }

    public int fib3(int n) {
        if (n < 0) {
            throw new RuntimeException();
        }

        int a = 0;
        int b = 1;
        int result = n;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}