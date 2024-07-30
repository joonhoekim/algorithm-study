package exhaustiveSearch.구간잘나누기;

import java.util.Scanner;

public class Combination {

  // 이 조합 풀이의 문제점은 시간 내에 풀 수 없다는 것
  // 99 C 50 = 5*10^28 인데, 1초에 사이클 대략 1억(10^8) 돌 수 있으니 시간초과 발생함
  // 조합을 만드는 건 시간복잡도 O(2^n) 으로 비효율적임

  static int n, m;
  static int[] arr;
  static int minMaxSum = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    boolean[] dividers = new boolean[n - 1];
    generateCombinations(dividers, 0, m - 1);

    System.out.println(minMaxSum);
  }

  static void generateCombinations(boolean[] dividers, int start, int remainingDividers) {
    if (remainingDividers == 0) {
      int maxSum = calculateMaxSum(dividers);
      minMaxSum = Math.min(minMaxSum, maxSum);
      return;
    }

    for (int i = start; i < dividers.length - remainingDividers + 1; i++) {
      dividers[i] = true;
      generateCombinations(dividers, i + 1, remainingDividers - 1);
      dividers[i] = false;
    }
  }

  static int calculateMaxSum(boolean[] dividers) {
    int maxSum = 0;
    int currentSum = 0;
    int groupCount = 0;

    for (int i = 0; i < n; i++) {
      currentSum += arr[i];

      if (i == n - 1 || dividers[i]) {
        maxSum = Math.max(maxSum, currentSum);
        currentSum = 0;
        groupCount++;
      }
    }

    // m개의 그룹으로 정확히 나누어지지 않으면 무효한 경우
    if (groupCount != m) {
      return Integer.MAX_VALUE;
    }

    return maxSum;
  }
}