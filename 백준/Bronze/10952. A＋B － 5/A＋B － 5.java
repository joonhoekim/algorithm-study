import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final String NEW_LINE = "\n";
  //static final String STAR = "*";

  //static final String BLANK = " ";

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;

    //int T = Integer.parseInt(bufferedReader.readLine());

    int a, b;
    while (true) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
      a = Integer.parseInt(stringTokenizer.nextToken());
      b = Integer.parseInt(stringTokenizer.nextToken());
      if (a == 0 && b == 0) {
        break;
      }
      stringBuilder.append(a + b).append(NEW_LINE);
    }

    System.out.println(stringBuilder);


  }
}