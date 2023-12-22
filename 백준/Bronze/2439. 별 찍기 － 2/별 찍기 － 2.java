import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final String NEW_LINE = "\n";
  static final String STAR = "*";

  static final String BLANK = " ";

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();

    int T = Integer.parseInt(bufferedReader.readLine());

    for (int i = 0; i < T; ++i) {
      stringBuilder.append(BLANK.repeat(Math.max(0, T - (i + 1))));
      stringBuilder.append(STAR.repeat(Math.max(0, T + 1 - (T - i))));
      stringBuilder.append(NEW_LINE);
    }

    System.out.println(stringBuilder);


  }
}