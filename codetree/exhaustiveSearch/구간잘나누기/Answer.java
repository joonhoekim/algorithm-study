package exhaustiveSearch.구간잘나누기;

import java.util.Scanner;

public class Answer {

  //수열 원소의 최댓값은 10000
  private static final int MAX_ANSWER = 10000;

  //수열 최대 길이는 100
  private static final int MAX_N = 100;

  //수열 길이n, 구간 개수 m
  private static int n, m;

  //수열 저장할 배열
  private static int[] arr;

  public static void main(String[] args) {
    //값을 입력받는다.
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    //구간의 최댓값을 결정한 다음 탐색한다!
    //구간의 최댓값을 1부터 MAX_ANSWER까지 가정해서,
    //그것이 가능한지를 확인해보고, 가능한 경우 그것이 최댓값의 최소가 됨을 이용한다.
    int ans = Integer.MAX_VALUE;
    for (int assumedAnswer = 1; assumedAnswer < MAX_ANSWER; assumedAnswer++) {
      boolean isSatisfied = true; // 1개의 원소가 assumedAnswer를 넘는 경우, m개를 넘는 세그먼트가 요구되는 경우에 쓰는 플래그다.
      int countSegments = 1; // 나누지 않아도, 세그먼트는 1개부터다.
      int localSum = 0;

      //각 자리수에 대해서 검사를 실시한다.
      for (int checkedIdx = 0; checkedIdx < n; checkedIdx++) {
        //원소 1개인 구간조차 예상최댓값을 넘어가는 경우는 fail이다.
        if (arr[checkedIdx] > assumedAnswer) {
          isSatisfied = false;
          break;
        }

        if (localSum + arr[checkedIdx] > assumedAnswer) {
          localSum = 0;
          countSegments++;
        }

        if (countSegments > m) {
          isSatisfied = false;
          break;
        }

        localSum += arr[checkedIdx];

      }

      //조건 플래그 검사한다.
      if (isSatisfied) {
        System.out.println(assumedAnswer);
        return;
      }

    }

  }
}
