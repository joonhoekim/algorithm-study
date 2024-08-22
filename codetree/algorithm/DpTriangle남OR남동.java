package algorithm;

import java.util.Scanner;

public class DpTriangle남OR남동 {
  /*
   * DP를 동적계획법이라고 하는데
   * '기억하며 풀기'라고 생각하는게 더 좋은 것 같다.
   *
   * 점화식 (점화가 ignite 아니다. 漸化 인데 점점 점 + 될 화 이다.) 은 재귀식과 동의어인데,
   * 수학적 정의는 일반항(a(n))을 다른 항과의 관계(예: a(n-1) + a(n-1))로 표현한 식을 말한다.
   * (점화식을 푼다는 것은 a(n)을 n의 명시적인 식으로 (예: n^2 + 2n + 1)로 바꾸는 것을 말하며, 피보나치 수열은 비네 공식이라는 게 있다.
   *
   * DP는 탑다운, 바텀업으로 나눌 수 있고
   * 탑다운은 Memoization, 바텀업은 Tabulation 기법을 쓴다.
   * Memoization 은 재귀함수의 반복되는 호출을 최소화하기 위해 연산 결과를 저장해 쓰는 것이고,
   * Tabulation 은 재귀가 아니라 반복문으로 풀 때인데, 사람이 푸는 것처럼 작은 것부터 큰 것으로 표를 그리며 확장하는 방식과 유사하다.
   * Table + lation 으로 말 그대로 '표만들기' 라는 단어다.
   *
   * */

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int size = 8;
    int[][] board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = sc.nextInt();
      }
    }

    int[][] dp = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j <= i; j++) {
        //시작점은 동일
        if (i == 0 && j == 0) {
          dp[i][j] = board[i][j];
        }
        //수직으로 내려올 때, 대각선으로만 갈 때 누적합 세팅
        else if (i == j) {
          dp[i][j] += dp[i - 1][j - 1] + board[i][j];
        } else if (j == 0) {
          dp[i][j] += dp[i - 1][j] + board[i][j];
        }
        //그 외의 경우 가능한 2개 경우를 비교
        else if (i > 0 && j > 0) {
          dp[i][j] += board[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
        }

      }
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }


  }
}
