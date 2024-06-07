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
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    private static int getLcm(int a, int b) {
        return (a * b) / getGcd(a, b);
    }


}