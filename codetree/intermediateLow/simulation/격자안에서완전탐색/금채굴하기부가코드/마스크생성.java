package intermediateLow.simulation.격자안에서완전탐색.금채굴하기부가코드;

public class 마스크생성 {

  public static void main(String[] args) {
    // 0 0 0 0 0 ? 5>> f(5/2)+1 = 3 !

    int digSize = 1;
    int digCost = digSize * digSize + (digSize + 1) * (digSize + 1);
    int globalMaxCount = 0;

    //마스크 초기화 - 행 중앙 구하고, 중앙-n ~ 중앙+n 까지 칠해주는 방식을 쓰자.
    int[][] mask = new int[digSize][digSize];
    int rowCenter = digSize / 2;
    int incrementTo = digSize / 2;

    for (int row = 0; row < digSize; row++) {
      //중앙-n ~ 중앙+n 까지 칠해주는 방식

      if (row <= incrementTo) {
        for (int i = rowCenter - row; i <= rowCenter + row; i++) {
          mask[row][i] = 1;
        }
      } else {
        // 0 1 0 .. row = 0
        // 1 1 1 .. row = 1
        // 0 1 0 .. row = 2
        for (int i = rowCenter - (digSize - row - 1); i <= rowCenter + (digSize - row - 1); i++) {
          mask[row][i] = 1;
        }
      }
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < digSize; i++) {
      for (int j = 0; j < digSize; j++) {
        builder.append(mask[i][j]).append(" ");
      }
      builder.append("\n");
    }

    System.out.println(builder);
  }
}
