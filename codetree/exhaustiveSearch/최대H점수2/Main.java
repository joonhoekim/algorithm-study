package exhaustiveSearch.최대H점수2;

import java.util.Scanner;

public class Main {

  static final int MAX_H = 100;

  public static void main(String[] args) {

    //문제이해, 풀이설계
    // 이해 :
    // - 수열이 입력으로 들어오고
    // - 임의개의 원소 값을 변경할 수 있을 때
    // - 특정 값(H)을 넘는 숫자가 특정 개수(H) 이상일 수 있는 최댓값을 구하라
    // 설계 :
    // - 가장 작은 수부터 더해주는 것이 고득점을 향한 길이 아니다. (그리디로 풀 수 없다)
    // - 입력되는 수열은 100개까지이고, 올릴 수 있는 원소 또한 100개까지 이므로...
    //   - 100 C 50 => 조합으로 시간 내에 풀 수 없다!!
    // - 이전에 푼 '구간 잘 나누기' 문제와 동일하다.
    //   - 값을 높일 수 있는데, 그 개수에 제한이 있고, 각 원소당 1만 올릴 수 있기 때문이다.
    // - H를 가정하고 높은 H부터 내려올 것이고
    // - 1을 더해도 조건을 만족하지 못하는 경우 그 H는 생략한다.

    Scanner sc = new Scanner(System.in);
    //수열 길이
    int n = sc.nextInt();

    //올릴 수 있는 원소 개수 (중복해서 같은 원소를 올릴 수 없음)
    int l = sc.nextInt();

    //수열
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    //이것은 완전탐색인데 N중 반복문이 아닌 경우이다!!
    int globalMaxH = 0;
    for (int assumedH = MAX_H; assumedH >= 1; assumedH--) {

      boolean isSatisfied = false;
      int remainedPlus = l;
      int count = 0;

      for (int checkedIdx = 0; checkedIdx < n; checkedIdx++) {

        if (arr[checkedIdx] >= assumedH) {
          count++;
        } else if (arr[checkedIdx] + 1 == assumedH && remainedPlus > 0) {
          count++;
          remainedPlus--;
        }

        if (count >= assumedH) {
          isSatisfied = true;
          break;
        }

      }

      if (isSatisfied) {
        globalMaxH = Math.max(assumedH, globalMaxH);
        break;
      }
    }

    System.out.println(globalMaxH);
  }
}
