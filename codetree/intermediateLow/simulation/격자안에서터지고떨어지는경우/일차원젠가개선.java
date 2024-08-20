package intermediateLow.simulation.격자안에서터지고떨어지는경우;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일차원젠가개선 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 0; i < 2; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int startIdx = Integer.parseInt(st.nextToken()) - 1;
      int endIdx = Integer.parseInt(st.nextToken()) - 1;

      arr = cutArray(arr, startIdx, endIdx, n);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0) {
        count++;
      }
    }
    System.out.println(count);
    for (int i = 0; i < n; i++) {
      if (arr[i] == 0) {
        break;
      }
      System.out.println(arr[i]);
    }
  }


  private static int[] cutArray(int[] arr, int startIdx, int endIdx, int maxLength) {
    // 3 2 1 0 0 0 0  형태인데, 왼쪽이 top이고 오른쪽 마지막이 bottom이다.
    // 이렇게 한 이유는 커팅 시작과 끝 인덱스를 위에서부터 주기 때문이다.

    int[] tempArr = new int[maxLength];
    int cursor = 0;
    for (int i = 0; i < maxLength; i++) {
      if (i < startIdx || i > endIdx) {
        tempArr[cursor++] = arr[i];
      }
    }

    return tempArr;
  }
}
