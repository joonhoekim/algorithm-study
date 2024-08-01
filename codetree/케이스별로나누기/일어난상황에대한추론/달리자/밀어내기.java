package 케이스별로나누기.일어난상황에대한추론.달리자;

import java.util.Scanner;

public class 밀어내기 {

  public static void main(String[] args) {

    /*
     * 분석
     * - 최선의 상황을 가정하고 추론하기
     * - n개의 집이 있는데, 각 집에 있는 사람의 수가 라인으로 주어진다.
     * - 다음 라인은 사람들이 이동한 후에, 각 집의 사람 수이다.
     * - 이동의 규칙은 다음과 같다.
     *   - 이동하지 않을수도 있다.
     *   - 이동한다면 오른쪽 집으로만 이동할 수 있다.
     *   - 집은 1차원 직선상에 놓여있다. (원형이 아니다, 끝 집은 이동하지 않고 머무를 것이다.)
     * - 모든 사람의 이동거리 합으로 가능한 최솟값은?
     *
     * 설계
     * - 최솟값을 구해야 하니, 1칸만 움직인 사람들의 수를 최대로 만들어야 한다.
     * - 밀어내는 방법은 다른 다양한 유형에도 적용 가능하다.
     * */

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] beforePeopleNum = new int[n];
    int[] afterPeopleNum = new int[n];

    for (int i = 0; i < n; i++) {
      beforePeopleNum[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      afterPeopleNum[i] = sc.nextInt();
    }

    int sum = 0;
    for (int i = 0; i < n - 1; i++) {
      int diff = beforePeopleNum[i] - afterPeopleNum[i];

      //맨 왼쪽 집부터 1칸씩 사람들을 밀어낸다.
      beforePeopleNum[i] -= diff;
      beforePeopleNum[i + 1] += diff;
      sum += diff;
    }

    System.out.println(sum);


  }
}
