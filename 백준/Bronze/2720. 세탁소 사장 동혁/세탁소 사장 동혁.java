import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int QUARTER = 25;
    static final int DIME = 10;
    static final int NICKEL = 5;
    static final int PENNY = 1;


    //changesSum => quotient[i] / F{changes{j} (answer)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] changesSum = new int[T];
        int[] changes = {QUARTER, DIME, NICKEL, PENNY};
        for (int i = 0; i < T; i++) {
            changesSum[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < T; i++) {
            int[] quotients = new int[changes.length];

            for (int j = 0; j < changes.length; j++) {
                if (changesSum[i] / changes[j] != 0) {
                    quotients[j] = changesSum[i] / changes[j];
                    changesSum[i] %= changes[j];
                }
            }

            for (int quotient : quotients) {
                sb.append(quotient + " ");
            }
            sb.append("\n");


        }
        System.out.println(sb);

    }

}