import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    //    int n = 14;
    int row = 1;
    int col = 1;
    int nrow = row;
    int ncol = col;
    //왼쪽 아래로 대각선, 아래로 이동, 오른쪽 위로 대각선, 오른쪽 이동
    int[] drow = new int[]{+1, +1, -1, +0};
    int[] dcol = new int[]{-1, +0, +1, +1};
    int dirNum = 3;
    int count = 1;

    while (count < n) {
      nrow = row + drow[dirNum];
      ncol = col + dcol[dirNum];
      while (!isIn(nrow, ncol)) {
        dirNum = (dirNum + 1) % 4;
        nrow = row + drow[dirNum];
        ncol = col + dcol[dirNum];
      }
      if (dirNum == 1 || dirNum == 3) {
        dirNum = (dirNum + 1) % 4;
      }
      row = nrow;
      col = ncol;
      count++;
    }

    System.out.printf("%d/%d", row, col);

  }

  private static boolean isIn(int nrow, int ncol) {
    if (nrow < 1 || ncol < 1) {
      return false;
    }
    return true;
  }
}