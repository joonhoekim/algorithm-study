package intermediateLow.simulation.격자안에서완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금채굴하기 {

  /*
   * 문제이해
   * - ◆ 모양으로 채굴을 할 수 있다
   *   - 1*1 도 인정
   * - 채굴은 1칸당 비용이 1임
   * - 금 가격은 m 으로 주어짐
   * - 금은 존재하면 1개만 존재함
   * - 전체 영역은 이차원으로, n*n으로 주어짐
   * - 전체 영역을 벗어난 채굴도 가능함
   *   - 영역밖에선 금이 없다고 전제함
   *   - 영역밖으로 나가는 경우에도 채굴비용 발생함
   * - 손해를 보지 않는 조건에서 '최대한 많이 캘 수 있는 금 개수'를 출력
   *
   * 분석
   * - 채굴 범위를 늘려가면서 완전탐색해야 할 것으로 보임
   * - 금 위치 정보가 주어지니 더 효율적인 방벙을 적용할 수도 있겠지만
   * - 완전탐색이 우선 구현이 쉽고, 문제에서 요구하는 것이 '최대개수'이니까
   *
   * 구현
   * - 1, 3, 5, 7 ... 해당 마름모를 2차원 배열로 구현하도록 하고, n-1 보다 작을 떄만 쓰자.
   * - 금 가격과 필드 내 금 개수에 따라 어느 크기 이상의 마름모는 제외할 수 있을 것이다. 이런 부분은 리팩토링으로...
   *
   * */

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //fieldSize
    int n = Integer.parseInt(st.nextToken());
    //goldPrice
    int m = Integer.parseInt(st.nextToken());
    int[][] field = new int[n][n];

    int goldCount = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        field[i][j] = Integer.parseInt(st.nextToken());
        if (field[i][j] == 1) {
          goldCount++;
        }
      }
    }
    //digSize 는 마름모 긴 변의 칸 수
    int digSize = 1;
    int digN = digSize / 2;
    int digCost = (digN) * (digN) + (digN + 1) * (digN + 1);
    int globalMaxCount = 0;

    // 전체 금을 다 캔다고 해도 코스트 감당이 불가한 경우는 제외해버림 (약간의 최적화..)
    while (goldCount * m >= digCost) {

      // 채굴 사이즈에 맞게 마스크 생성
      int[][] mask = getMask(digSize);

      //centerRow, centerColumn (마름모 중앙점)에 마스크 중앙점을 맞춰가며 완전탐색
      for (int centerRow = 0; centerRow < n; centerRow++) {
        for (int centerColumn = 0; centerColumn < n; centerColumn++) {

          int collectedGoldCount = 0;
          for (int i = 0; i < digSize; i++) {
            for (int j = 0; j < digSize; j++) {
              int dx = centerRow - digSize / 2 + i;
              int dy = centerColumn - digSize / 2 + j;

              if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                if (field[dx][dy] == 1 && mask[i][j] == 1) {
                  collectedGoldCount++;
                }
              }
            }
          }

          int income = collectedGoldCount * m - digCost;
          if (income >= 0) {
            globalMaxCount = Math.max(globalMaxCount, collectedGoldCount);
          }

        }
      }

      digSize += 2; //1, 3, 5 ...
      digN = digSize / 2;
      digCost = (digN) * (digN) + (digN + 1) * (digN + 1);

    }

    System.out.println(globalMaxCount);

    br.close();
  }

  static int[][] getMask(int size) throws Exception {

    //짝수 마스크가 불가하다고 가정
    if (size % 2 == 0) {
      throw new Exception("size must be odd number");
    }

    int[][] mask = new int[size][size];
    int rowCenter = size / 2;
    int incrementTo = size / 2;

    for (int row = 0; row < size; row++) {
      //중앙-n ~ 중앙+n 까지 칠해주는 방식

      if (row <= incrementTo) {
        for (int i = rowCenter - row; i <= rowCenter + row; i++) {
          mask[row][i] = 1;
        }
      } else {
        // 0 1 0 .. row = 0
        // 1 1 1 .. row = 1
        // 0 1 0 .. row = 2
        for (int i = rowCenter - (size - row - 1); i <= rowCenter + (size - row - 1); i++) {
          mask[row][i] = 1;
        }
      }
    }

    return mask;
  }
}
