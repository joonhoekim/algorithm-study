package 겹침문제.구역청소;

import java.util.Scanner;

public class 대수적풀이 {

  public static void main(String[] args) {
    /*
     * 분석
     * - 수직선상에 겹칠 수 있는 여러 구역들을 설정함
     * - 구역으로 설정된 전체 길이가 궁금함
     * 설계
     * - 겹치는 부분을 빼 주는 방법
     * - 구역으로 설정된 경우를 구역을 표현한 자료구조에 기록하는 방법 (배열 등)
     *   - 이 방법은 구역의 크기가 커지는 경우 불리해진다.
     * */

    Scanner sc = new Scanner(System.in);
    int aMin = sc.nextInt();
    int aMax = sc.nextInt();
    int bMin = sc.nextInt();
    int bMax = sc.nextInt();

    if (aMax < bMin || aMin > bMax) {
      System.out.println(aMax - aMin + bMax - bMin);
    } else {
      System.out.println(Math.max(aMax, bMax) - Math.min(aMin, bMin));
    }
  }
}
