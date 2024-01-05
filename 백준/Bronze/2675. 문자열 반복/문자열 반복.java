import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String S = br.readLine();
            String[] parsed = S.split(" ");

            int R = Integer.valueOf(parsed[0]);
            for (int j = 0; j < parsed[1].length(); j++) {
                for (int k = 0; k < R; k++) {
                    sb.append(parsed[1].charAt(j));
                }
            }
            sb.append("\n");

        }


        System.out.print(sb);
        br.close();
    }

}