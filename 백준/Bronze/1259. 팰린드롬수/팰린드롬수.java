import java.util.Scanner;
//팰린드롬수 = 좌에서 우로 읽거나, 우에서 좌로 읽거나 모두 같은 경우
public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        line: while (sc.hasNext()) {
            int tested = sc.nextInt();
            if(tested == 0) break;

            //Number of Digits
            int NoD = (int) Math.log10(tested) + 1;
            String testedStr = String.valueOf(tested);
            for (int i = 0; i < NoD; i++) {
                if (testedStr.charAt(i) != testedStr.charAt(testedStr.length()-i-1)) {
                    System.out.println("no");
                    continue line;
                }
            }
            System.out.println("yes");


        }
    }
}