package 좋은전략을추려내기.독서실의거리두기3;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //최대거리두기 자리배치
    //1. 현재 가장 긴 거리 찾아서
    //2. 그 중앙에 배치해준 다음에
    //3. 최대간격 다시 갱신해서 출력한다.

    Scanner sc = new Scanner(System.in);
    //좌석 개수
    sc.nextLine();
    StringBuilder sb = new StringBuilder(sc.next());

    //    System.out.println(sb);

    int insertIdx = getInsertIdx(sb);
    sb.replace(insertIdx, insertIdx + 1, "1");
    //    System.out.println(sb);

    System.out.println(getLeastInterval(sb) + 1);

  }

  private static int getLeastInterval(StringBuilder sb) {
    int leastInterval = Integer.MAX_VALUE;
    int localInterval = 0;

    for (int i = 1; i < sb.length(); i++) {
      if (sb.charAt(i) == '0') {
        localInterval++;
      } else {
        leastInterval = Math.min(leastInterval, localInterval);
        localInterval = 0;
      }
    }

    return leastInterval;
  }

  private static int getInsertIdx(StringBuilder sb) {

    //가장 큰 간격을 가진 곳을 찾자.
    int maxInterval = 0;
    int localInterval = 0;
    int maxStartIdx = 0;
    int maxEndIdx = 0;
    int localStartIdx = 0;
    int localEndIdx = 0;

    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '0') {
        localInterval++;
      } else {
        maxInterval = Math.max(maxInterval, localInterval);
        localStartIdx = localEndIdx;
        localEndIdx = i;
        if (localInterval == maxInterval) {
          maxStartIdx = localStartIdx;
          maxEndIdx = localEndIdx;
        }
        localInterval = 0;
      }
    }

    return (maxEndIdx + maxStartIdx) / 2;
  }
}
