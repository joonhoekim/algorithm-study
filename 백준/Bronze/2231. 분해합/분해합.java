import java.util.Scanner;
//input: digit-sum, answer: find smallest generator.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strDigitSum = sc.next();
        int intDigitSum = Integer.parseInt(strDigitSum);

        //최소의 generator를 추정하자
        for (int generator = 0; generator < intDigitSum; generator++) {
            if(getDigitSum(String.valueOf(generator)) == intDigitSum) {
                System.out.println(generator);
                return;
            }
        }

        System.out.println(0);

    }

    static int getDigitSum (String strInput) {
        int digitSum = Integer.parseInt(strInput);
        int[] digits = new int[strInput.length()];

        for (int i = 0; i < strInput.length(); i++) {
            digits[i] = strInput.charAt(i)-'0';
            digitSum += digits[i];
        }

        return digitSum;
    }
}