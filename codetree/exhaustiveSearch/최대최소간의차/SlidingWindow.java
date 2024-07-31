package exhaustiveSearch.최대최소간의차;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SlidingWindow {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int left = 0, right = 0;
    int maxLength = 0;
    int bestLeft = 0, bestRight = 0;

    while (right < n) {
      if (arr[right] - arr[left] <= k) {
        if (right - left + 1 > maxLength) {
          maxLength = right - left + 1;
          bestLeft = left;
          bestRight = right;
        }
        right++;
      } else {
        left++;
      }
    }

    long cost = 0;
    for (int i = 0; i < bestLeft; i++) {
      cost += arr[bestLeft] - arr[i];
    }
    for (int i = bestRight + 1; i < n; i++) {
      cost += arr[i] - arr[bestRight];
    }

    bw.write(String.valueOf(cost));
    bw.newLine();

    bw.flush();
    bw.close();
    br.close();
  }
}
