package intermediateLow.simulation.격자안에서단일객체를이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 숫자가더큰인접한곳으로이동 {

  /*
   *
   * 문제
   * n*n 격자판, 각 칸에 숫자[1, 100],
   * 특정위치 시작(r, c), 상하좌우 4군데 중 현재 위치보다 큰 곳으로 이동
   * 더 큰 곳이 여러 곳일 경우는 상하좌우 순으로 우선수위 잡음 (크기비교X)
   * 더 이상 움직일 수 없을 때까지 반복
   *
   * 입력
   * n r c
   * n*n 격자 숫자 정보
   *
   * 출력
   * 시작위치부터 방문하게 되는 모든 격자의 '값'을 공백 두고 출력
   *
   * 접근
   * dxdy 접근법을 쓸 것
   *
   * */

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int n = Integer.parseInt(inputs[0]);
    //to idx, -1
    int r = Integer.parseInt(inputs[1]) - 1;
    int c = Integer.parseInt(inputs[2]) - 1;

    int[][] board = new int[n][n];
    for (int i = 0; i < n; i++) {
      inputs = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(inputs[j]);
      }
    }

    StringBuilder sb = new StringBuilder();

    // U D L R
    int[] dx = {0, 0, -1, +1};
    int[] dy = {-1, +1, 0, 0};
    boolean stop = false;
    while (!stop) {

      //움직였는지 체크
      boolean moved = false;

      //현재 위치 넣고
      sb.append(board[r][c]).append(" ");
      for (int i = 0; i < dx.length; i++) {

        //격자 안에 있으면서
        if (0 <= r + dy[i] && r + dy[i] < n && 0 <= c + dx[i] && c + dx[i] < n) {
          // 더 큰 위치를 상하좌우로 탐색에서
          if (board[r][c] < board[r + dy[i]][c + dx[i]]) {
            // 이동가능하면 해당 위치 넣어주고
            r += dy[i];
            c += dx[i];
            moved = true;
            break;
          }
        }
      }
      //움직인게 없었으면 멈춤
      if (!moved) {
        stop = true;
      }


    }

    System.out.println(sb);
  }
}
