import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int numberOfCase = Integer.parseInt(bufferedReader.readLine());

    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;

    for (int i = 0; i < numberOfCase; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
      stringBuilder.append("Case #").append(i + 1).append(": ")
          .append(Integer.parseInt(stringTokenizer.nextToken()) + Integer.parseInt(
              stringTokenizer.nextToken())).append("\n");
    }

    System.out.print(stringBuilder);

  }
}