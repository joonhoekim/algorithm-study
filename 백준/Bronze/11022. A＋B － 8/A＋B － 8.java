import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    final String NEW_LINE = "\n";
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int numberOfCase = Integer.parseInt(bufferedReader.readLine()) + 1;

    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;

    for (int i = 1; i < numberOfCase; ++i) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());
      stringBuilder.append("Case #").append(i).append(": ").append(a).append(" + ").append(b)
          .append(" = ").append(a + b).append(NEW_LINE);


    }

    System.out.print(stringBuilder);

  }
}



