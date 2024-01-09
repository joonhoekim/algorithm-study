import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    //if ((input = br.readLine()) != null && input.isEmpty()) { } //이렇게 처리해서 콘솔/파일 EOF 찾는 게 맞는데 이 문제는 0 0 이라고 알려줬다.

    while (true) {
      String[] inputString = br.readLine().split(" ");
      int a = Integer.parseInt(inputString[0]);
      int b = Integer.parseInt(inputString[1]);
      if (a == 0 && b == 0) {
        break;
      }

      if (b % a == 0) {
        System.out.println("factor");
      } else if (a % b == 0) {
        System.out.println("multiple");
      } else {
        System.out.println("neither");
      }
    }


  }
}