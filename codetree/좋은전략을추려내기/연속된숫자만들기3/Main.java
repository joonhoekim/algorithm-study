package 좋은전략을추려내기.연속된숫자만들기3;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    /*
     * 문제
     * 일직선 위 3사람이 있음
     * 양 끝쪽 중 한 사람을 선택해 남은 두 사람 사이로 이동시킴
     * 연속된 수가 되기 위한 '최대' 이동 횟수를 구할 것
     *
     * 분석
     * 이전 '연속된숫자만들기2'에서는 '최소' 이동횟수를 구했는데
     * 이번에는 최대 이동횟수를 구해야 함
     *
     * 예시
     * 1 5 6
     * 1 4 5
     * 1 3 4
     * 1 2 3
     *
     * -___--
     * -__--_
     * -_--__
     * ---___
     *
     * 최대를 만드는 원리는?
     * 1. 가장 거리가 먼 간격을 찾아야 함
     * 2. 그럼 나머지 두개를 붙인 다음에...
     * 3. 두 개를 한 칸씩 전진시키면 됨
     *
     * 예외
     * - 처음부터 정렬이 되어 있는 경우
     * - 두 간격이 같은 크기일 경우
     *
     * 설계
     * 가장 먼 간격은 쌍 만들기 완전탐색으로 O(n^2)로 찾거나
     * 기억하며 풀기를 통해 O(n)으로 풀 수 있음
     * ! 그냥 숫자니까 별 고민 안해도 되네..!
     * 입력도 10억까지 들어올 수 있음. 대수적으로 풀으라는 의도인가보다.
     *
     * 나머지 두 개를 붙이기 위해서는, 가장 먼 것이 누구인지 기억해야 할 것 같고
     * 한칸씩 전진시키는 부분은 굳이 시뮬레이션 안해도 바로 구할 수 있음
     * */

    Scanner sc = new Scanner(System.in);
    final int INPUT_COUNT = 3;
    int[] arr = new int[INPUT_COUNT];
    for (int i = 0; i < INPUT_COUNT; i++) {
      arr[i] = sc.nextInt();
    }

    //세 사람의 위치는 오름차순으로 주어진다는 전제가 있음. 따로 정렬 안해도 됨.
    int distLeft = arr[1] - arr[0];
    int distRight = arr[2] - arr[1];

    if (distLeft == 1 && distRight == 1) {
      System.out.println(0);
    } else if (distLeft >= distRight) {
      System.out.println(arr[1] - arr[0] - 1);
    } else {
      System.out.println(arr[2] - arr[1] - 1);
    }
  }
}
