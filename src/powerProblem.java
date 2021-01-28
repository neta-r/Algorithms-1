public class powerProblem {
    public static long powerLoop(int x, int n) {
        long result = 1;
        while (n != 0) {
            if (n % 2 == 1) result = result * x;
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    public static long powerRecursive(int x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 1) {
            return x * powerRecursive(x * x, (n-1) / 2);
        }
        return powerRecursive(x *  x, n /2);
    }

    public static void main(String[] args) {
        System.out.println(powerLoop(3, 3));
        System.out.println(powerRecursive(3, 3));
    }
}
