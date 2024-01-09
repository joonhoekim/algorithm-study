import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    // 1*1 의 단위 면적으로, 이산적으로 생각하면 쉬운 문제인데,
    // 연속적인 실수의 가로*세로=면적 으로 생각하면 어려운 문제네
    // 경험과 암기와 직관 모두 다 중요하네.
    // 올림피아드도 준비한 애들이 풀겠네.

    // decorator pattern
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //setVar
    final int BOARD_SIZE = 100;
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    final int PAPER_LENGTH = 10;

    //setCoordinate
    int N = Integer.parseInt(br.readLine());
    int[] x = new int[N];
    int[] y = new int[N];

    for (int i = 0; i < N; i++) {
      String[] coordinate = br.readLine().split(" ");
      x[i] = Integer.parseInt(coordinate[0]);
      y[i] = Integer.parseInt(coordinate[1]);
    }

    //test
//    System.out.println(N);
//    for (int i = 0; i < N; i++) {
//      System.out.printf("%d, %d\n", x[i], y[i]);
//    }
//
//    //종이를 붙이자. 길이는 10*10
//    //시각화 연상 -> 시작점부터 가로-세로로 세팅
//
    for (int i = 0; i < N; i++) {
      for (int j = x[i]; j < x[i] + PAPER_LENGTH; j++) {
        for (int k = y[i]; k < y[i] + PAPER_LENGTH; k++) {
          board[j][k] += 1;
        }
      }
    }

    //테스트코드
//    for (int i = 0; i < BOARD_SIZE; i++) {
//      for (int j = 0; j < BOARD_SIZE; j++) {
//        System.out.print(board[i][j]);
//      }
//      System.out.println("");
//    }

    int count = 0;
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (board[i][j] != 0) {
          count += 1;
        }
      }
    }

    System.out.println(count);
  }
}
