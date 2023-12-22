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
      for (int j = i + 1; j < T; ++j) {
        stringBuilder.append(BLANK);
      }
      for (int k = T - i; k < T + 1; ++k) {
        stringBuilder.append(STAR);
      }
      stringBuilder.append(NEW_LINE);
    }

    System.out.println(stringBuilder);


  }
}