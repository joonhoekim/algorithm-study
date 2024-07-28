package exhaustiveSearch.ABCD찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] arr = new int[st.countTokens()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    // A와 B는 가장 작은 것이 확실함.
    // arr[2]는 A+B[1,1,1,1]일수도 있고, C[1,1,9,9]일수도 있음.
    // arr[3]또한 D라고 확신할 수 없음. A+B <= D 일 수도 있음.

    //뒤에서 첫번째가 A+B+C+D인 것은 증명가능함
    //뒤에서 두번째가 B+C+D인 것 또한 증명가능함
    //뒤에서 세번째는 C+D[1,1,9,9] 이거나 A+B+C[9,9,9,9] 일 수도 있음.

    //C 또는 D만 구하면 이 문제는 해결됨...
    //A+B+C+D - [A+B] = C+D
    //C+D를 구할 수 있음이 증명됨
    // ... C와 D 각각을 한 번의 계산으로 구하는 방법은 없는 것 같음.
    // 그래서 비효율적이어도 a,b,c,d를 임의로 정한 다음에, 정렬한 결과가 arr[]과 같은지 확인할 것임...

    final int MAX_VALUE = 40;
    loop:
    for (int a = 1; a <= MAX_VALUE; a++) {
      for (int b = 1; b <= MAX_VALUE; b++) {
        for (int c = 1; c <= MAX_VALUE; c++) {
          for (int d = 1; d <= MAX_VALUE; d++) {

            boolean isSame = true;
            int[] test = new int[]{
                    a, b, c, d, a + b, b + c, c + d, d + a, a + c, b + d, a + b + c, a + c + d, a + b + d, b + c + d, a + b + c + d
            };

            Arrays.sort(test);
            for (int i = 0; i < test.length; i++) {
              if (test[i] != arr[i]) {
                isSame = false;
                break;
              }
            }
            if (isSame) {
              bw.write(String.format("%d %d %d %d", a, b, c, d));
              break loop;
            }

          }
        }
      }
    }
    bw.flush();
    br.close();
    bw.close();
  }
}
