import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static final String NEW_LINE = "\n";
  public static final String STAR = "*";

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();

    int T = Integer.parseInt(bufferedReader.readLine());

    for (int i = 0; i < T; ++i) {
      for (int j = -1; j < i; ++j) {
        stringBuilder.append(STAR);

      }
      stringBuilder.append(NEW_LINE);
    }

    System.out.println(stringBuilder);


  }
}