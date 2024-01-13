import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String answer = br.readLine();
      int score = 0;
      int streak = 0;
      for (int j = 0; j < answer.length(); j++) {
        if (answer.charAt(j) == 'O') {
          score = score + ++streak;
        } else {
          streak = 0;
        }
      }
      System.out.println(score);
    }
  }

}