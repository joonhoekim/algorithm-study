import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    int sum = 0;
    for (int i = 0; i < input.length(); i++) {
      sum += getRequiredTime(input.charAt(i));
    }

    System.out.print(sum);

  }

  static int getRequiredTime(char check) {

    //굳이 루프 활용하려다가 오히려 더 복잡해져서 하드코딩했다.
    //특히 PQRS, WXYZ...
    if ('A' <= check && check <= 'C') {
      return 3;
    } else if ('D' <= check && check <= 'F') {
      return 4;
    } else if ('G' <= check && check <= 'I') {
      return 5;
    } else if ('J' <= check && check <= 'L') {
      return 6;
    } else if ('M' <= check && check <= 'O') {
      return 7;
    } else if ('P' <= check && check <= 'S') {
      return 8;
    } else if ('T' <= check && check <= 'V') {
      return 9;
    } else {
      return 10;
    }


  }
}