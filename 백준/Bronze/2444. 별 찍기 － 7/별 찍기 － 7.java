import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    Stack<String> stringStack = new Stack<>();
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      for (int j = N - i - 1; j > 0; j--) {
        sb1.append(" ");
      }
      for (int j = 2 * i + 1; j > 0; j--) {
        sb1.append("*");
      }
      sb1.append("\n");
      sb2.append(sb1);
      stringStack.push(sb1.toString());
      sb1.setLength(0);
    }

    System.out.print(sb2);
    sb2.setLength(0);
    //1개 버리기
    stringStack.pop();
    for (int i = 0; i < N - 1; i++) {
      sb2.append(stringStack.pop());
    }
    System.out.print(sb2);
  }
}
