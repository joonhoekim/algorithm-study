package intermediateLow.simulation.격자안에서완전탐색;

import java.util.Scanner;

public class 트로미노마스크 {

  public static final int MAX_NUM = 200;

  public static int n, m;
  public static int[][] grid = new int[MAX_NUM][MAX_NUM];

  // 가능한 모든 모양을 전부 적어줍니다.
  public static int[][][] shapes = new int[][][]{{{1, 1, 0}, {1, 0, 0}, {0, 0, 0}},

      {{1, 1, 0}, {0, 1, 0}, {0, 0, 0}},

      {{1, 0, 0}, {1, 1, 0}, {0, 0, 0}},

      {{0, 1, 0}, {1, 1, 0}, {0, 0, 0}},

      {{1, 1, 1}, {0, 0, 0}, {0, 0, 0}},

      {{1, 0, 0}, {1, 0, 0}, {1, 0, 0}},};

  // 주어진 위치에 대하여 가능한 모든 모양을 탐색하며 최대 합을 반환합니다.
  public static int getMaxSum(int x, int y) {
    int maxSum = 0;

    //모양을 선택(6가지)
    for (int i = 0; i < 6; i++) {
      //넣을 수 있는지 확인한다.
      boolean isPossible = true;
      int sum = 0;
      //결정론적으로 풀지 않고 3*3 마스크의 모든 원소에 대해 검사한다.
      //여기서는 왼쪽 위부터, 컬럼을 증가시키면서 검사한다.
      for (int dx = 0; dx < 3; dx++) {
        for (int dy = 0; dy < 3; dy++) {

          //해당 마스크에서 빈 곳이면 넘긴다.
          if (shapes[i][dx][dy] == 0) {
            continue;
          }
          //빈 곳이 아닐 때, 해당 원소가 그리드 밖으로 넘어가는지 검사한다. (x는 검사 지점으로, 마스크의 왼쪽위다.)
          //여기서 isPossible flag가 false이면 최댓값 후보가 아니게 된다. (이 때 break치고 나가는게 맞음.)
          if (x + dx >= n || y + dy >= m) {
            isPossible = false;
            break;
          }
          //현재 검사 지점이 그리드 안에 들어갈 수 있을 때, 그 값을 sum에 합한다.
          else {
            sum += grid[x + dx][y + dy];
          }
        }
      }

      if (isPossible) {
        maxSum = Math.max(maxSum, sum);
      }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        grid[i][j] = sc.nextInt();
      }
    }

    int ans = 0;

    // 격자의 각 위치에 대하여 탐색하여줍니다.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        ans = Math.max(ans, getMaxSum(i, j));
      }
    }

    System.out.print(ans);
  }
}