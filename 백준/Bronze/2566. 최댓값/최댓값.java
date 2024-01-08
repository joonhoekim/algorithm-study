import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    final int ROW = 9;
    final int COL = 9;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] matrix = new int[ROW][COL];
    for (int i = 0; i < ROW; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < COL; j++) {
        matrix[i][j] = Integer.parseInt(row[j]);


        //확인용 코드
        //System.out.printf("%d ",matrix[i][j]);
      }
      //확인용 코드
      //System.out.println("");
    }

    int max = -1; // 예외처리
    int maxRow = -1;
    int maxCol = -1;
    for (int i = 0; i < ROW; i++) {
      for (int j = 0; j < COL; j++) {
        if(matrix[i][j] > max) {
          max = matrix[i][j];
          maxRow = i+1;
          maxCol = j+1;
        }
      }
    }

    System.out.println(max);
    System.out.println(maxRow + " " + maxCol);


  }
}