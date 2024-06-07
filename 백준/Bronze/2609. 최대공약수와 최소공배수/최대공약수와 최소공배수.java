import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int gcd = getGcd(a, b);
        int lcm = getLcm(a, b);

        System.out.println(gcd);
        System.out.println(lcm);

    }

    private static int getGcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        for (int divisor = min; divisor > 1; divisor--) {
            if (max % divisor == 0 && min % divisor == 0)
                return divisor;
        }

        return 1;
    }

    private static int getLcm(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        for (int multiple = max; multiple < max * min; multiple++) {
            if (multiple % min == 0 && multiple % max == 0) {
                return multiple;
            }
        }
        return max * min;
    }


}