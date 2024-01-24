import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int count = 0;
    loop:
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();

      sb.append(br.readLine());
      // 연속성 판단 기준: 모든 단어에 대해 검사함
      // 1. 앞단어가 다른 경우, 그 단어가 이전까지의 서브스트링에 포함되면 안됨
      // 2. 앞단어가 같은 경우, 그룹단어의 조건이 '아직' 깨지지 않음.
      // 3. 끝까지 검사할때까지 그룹단어의 조건이 깨지지 않은 경우 그룹단어이다.

      for (int j = 0; j < sb.length() - 1; j++) {
        //조건 1
        if (sb.charAt(j + 1) == sb.charAt(j)) {
          continue;
        } else if ((sb.charAt(j + 1) != sb.charAt(j)) &&
            sb.substring(0, j + 1).contains(String.valueOf(sb.charAt(j + 1)))) {
          continue loop;
        }
      }
      //확인해보니 1글자인 경우는 별도로 고려를 안했는데, for문을 돌지 않으면서 정상적으로 동작하게 됐다...
      count++;
    }
    System.out.println(count);
  }
}