import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    //BR 사용하겠음. 입력 스트림은 표준 스트림을 사용함.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 알려준 조건
    // 1. 입력은 5줄
    // 2. 글자는 최대 15개
    final int ROW = 5;
    final int MAX_COL = 15;

    // 최대 크기를 담을 수 있는 5 * 15 의 2차원 행렬을 사용하기로 함.
    // 비효율적일 수도 있지만, 일단 떠오른 발상임.
    // COL 방향으로 순회하되 채워진 값이 없을 경우를 조건문으로 판단할 것임.
    char[][] matrix = new char[ROW][MAX_COL];

    char[] line;
    // 우선 행렬을 세팅하자.
    for (int i = 0; i < ROW; i++) {
      //먼저 한 라인을 읽어온다.
      line = br.readLine().toCharArray();

      //처음에 여기를 MAX_COL번 반복하게 했는데 생각해보니 그럴 필요가 없었다.
      //읽어온 라인 길이만큼만 쓴다. 값 할당 안한 부분들은 \u0000 으로 자동 초기화 되어있을 것이니..
      for (int j = 0; j < line.length; j++) {
        matrix[i][j] = line[j];
      }
    }

    // 세로 읽기 하는 모습을 상상해보자. COL 길이만큼 읽고 내려가는 것을 ROW 개수 만큼 반복한다.
    // 먼저 하는 게 안쪽 반복문이다. 그래서 세로로 읽는 것은 행수만큼 반복된다.
    // 즉, 안쪽 = ROW 개수만큼 반복, 그것을 (바깥쪽) COL 개수 만큼 반복한다.
    for (int j = 0; j < MAX_COL; j++) {
      for (int i = 0; i < ROW; i++) {
        if (matrix[i][j] != '\u0000') {
          System.out.print(matrix[i][j]);
        }
      }
      //      System.out.println("");
    }
    br.close();
  }
}