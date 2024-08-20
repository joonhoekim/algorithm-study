package intermediateLow.simulation.격자안에서터지고떨어지는경우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일차원젠가 {

  /*
   * 문제
   * n개 층의 젠가가 있다고 가정, 블럭마다 숫자가 주어짐. 숫자는 [1, 100] 자연수임.
   * 단, 정육면체 토막을 수직으로 쌓아올린 젠가라서 1차원이라고 부름
   * 구간 단위로 젠가를 뺄 것임. 두 번 뺄건데 이건 마지막 두 줄로 구간을 줌.
   * 구간은 위에서부터 세는 숫자로 주어진다. 1,3 이라고 하면 위에서부터 1, 2, 3 번 블럭을 말한다.
   * 주어지는 숫자는 위층의 젠가부터 주어짐.
   * 출력해야 하는 건 두가지임
   * 1. 남은 블록 개수
   * 2. 남은 블록의 숫자들 (위에서부터 라인별로 출력)
   *
   * 접근
   * 처음에는, 구간만큼 반복문으로 땡겨주고, 땡긴만큼 뒤를 0으로 바꿔주는 걸로 접근했는데
   * 이게 작성 복잡도가 높아져서 방향을 바꿨다. 상황을 시뮬레이션 하는 단계를 둘로 나눴다.
   * 하나는 삭제고, 하나는 중력 적용이다.
   *
   * 어려웠던 점
   * 빼는 블럭의 위치는 변한다..
   * 위에서부터 s번째~e번째 뺀다고 하는데,
   * 빼고 나면 높이가 바뀐다.
   * 상대적인 값이기에 젠가의 현재 높이값을 기준으로 idx를 잡아줘야 한다.
   *
   *
   * */
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] zenga = new int[n];
    for (int i = 0; i < n; i++) {
      zenga[i] = Integer.parseInt(br.readLine());
    }

    int itr = 2;
    int[][] drop = new int[itr][2];
    for (int i = 0; i < itr; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      //to idx, -1
      drop[i][0] = Integer.parseInt(st.nextToken()) - 1; // 위에서 drop[i][0] 번째부터
      drop[i][1] = Integer.parseInt(st.nextToken()) - 1; // 위에서 drop[i][1] 번째까지
    }

    //여러번 구간에 대해 반복
    int height = n;
    int offset = n - height;
    for (int i = 0; i < itr; i++) {
      //페이즈1. 삭제 (위에서부터 삭제하나 아래에서부터 삭제하나 동일함)
      for (int j = offset + drop[i][0]; j <= offset + drop[i][1]; j++) {
        if (j >= 0 && j < n) {
          if (zenga[j] != 0) {
            zenga[j] = 0;
            height--;
          }
        }
      }
      offset = n - height;

      int[] temp = new int[n];

      //페이즈2. 중력 적용
      int stackpoint = n - 1;
      for (int cursor = n - 1; cursor >= 0; cursor--) {
        if (zenga[cursor] != 0) {
          temp[stackpoint--] = zenga[cursor];
        }
      }

      zenga = temp;
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (zenga[i] != 0) {
        count++;
      }
    }
    System.out.println(count);
    for (int j = 0; j < n; j++) {
      if (zenga[j] != 0) {
        System.out.println(zenga[j]);
      }
    }
  }
}
