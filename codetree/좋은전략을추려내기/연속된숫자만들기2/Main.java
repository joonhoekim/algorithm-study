package 좋은전략을추려내기.연속된숫자만들기2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // 세 사람의 위치를 숫자로 표현함
    // 이 세사람이 연달아서 (공차1) 서있게 하고 싶음
    // 가운데 사람은 움직일 수 없음, 양 끝만 이동할 수 있음.
    // 양 끝 사람은, '남은 두 사람 사이'로만 이동할 수 있음.
    // 이동 비용은 고려하지 않음. 이동 횟수만 고려함. 최대 이동거리같은 제약은 없음.
    // 위치는 1~10억까지이므로 int 사용해도 됨

    // 설계
    // 두 사람 사이로 이동할 때 한 칸을 비워놔야 완성됨

    // 케이스
    // 1 2 3
    // 1 2 4 -> 2 3 4
    // 1 2 5 -> 2 4 5 -> 2 3 4
    // 1 3 4 -> 1 2 3
    // 1 3 5 -> 1 2 3
    // 1 2 10 -> 2 4 10 -> 2 3 4
    // 1 8 10 ->
    // 1 9 10 -> 1 3 9 -> 1 2 3
    // 2 4 6 -> 2 3 4

    // 가까운 숫자간 차이를 구하는데,
    // 1. 공차 1 = 1개, 공차 2 = 0개 -> 이동횟수 2
    // 2. 공차 1 = 2개 -> 이동횟수 0 (이미 정렬됨)
    // 3. 공차 1 = 1개, 공차 2 = 1개 -> 이동횟수 1 (사이로 들어가면 됨)
    // 4. 공차 1 = 0개, 공차 2 = 1개 -> 이동횟수 1 (마찬가지로 사이로 들어가면 됨)
    // 5. 공차 1 = 0 개, 공차 2 = 2개 -> 이동횟수 1 (양쪽 아무거나 사이로 들어가면 됨)

    Scanner sc = new Scanner(System.in);
    int n = 3;
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);
    // 공차 1인 경우 개수찾기
    int countDistOne = 0;
    int countDistTwo = 0;
    for (int i = 0; i < n - 1; i++) {
      if (arr[i + 1] - arr[i] == 1) {
        countDistOne++;
      } else if (arr[i + 1] - arr[i] == 2) {
        countDistTwo++;
      }
    }

    if (countDistOne == 1 && countDistTwo == 0) {
      System.out.println("2");
    }

    if (countDistOne == 2) {
      System.out.println("0");
    }

    if (countDistTwo == 1) {
      System.out.println("1");
    }

    if (countDistOne == 0 && countDistTwo == 0) {
      System.out.println("2");
    }


  }
}
