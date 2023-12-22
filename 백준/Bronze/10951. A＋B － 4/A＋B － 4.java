import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    //이 문제는 End of FIle 을 다룰 줄 아는지 물어보는 문제
    //java에서 EOF 를 다뤄본 적이 없어서 배워왔다!!

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //BufferedReader 클래스로 입력을 처리하는 경우라면 .readLine() 메서드가 null을 반환하면 EOF 이다.

    StringTokenizer stringTokenizer;
    StringBuilder stringBuilder = new StringBuilder();
    String str;
    int a, b;
    while (true) {
      if ((str = bufferedReader.readLine()) == null) {
        break;
      }
      stringTokenizer = new StringTokenizer(str, " ");
      a = Integer.parseInt(stringTokenizer.nextToken());
      b = Integer.parseInt(stringTokenizer.nextToken());
      stringBuilder.append(a + b + "\n");
    }

    System.out.print(stringBuilder);

    
  }
}