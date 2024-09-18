package algorithm.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class radixSortImpl2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine(); // 첫 번째 줄은 배열의 크기이므로 무시
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int k = getDigitLength(getMax(arr));

    radixSort(arr, k);

    String answer = String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new));

    System.out.println(answer);
  }

  private static int getDigitLength(int num) {
    if (num == 0) return 1;  // 0의 자릿수는 1로 처리
    return (int) Math.log10(Math.abs((double) num)) + 1;
  }

  private static int getMax(int[] arr) {
    return Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
  }

  private static void radixSort(int[] arr, int k) {
    final int BASE = 10;
    int[] output = new int[arr.length];

    for (int exp = 1; k > 0; exp *= 10, k--) {
      int[] count = new int[BASE];

      // Count occurrences
      for (int value : arr) {
        count[(value / exp) % 10]++;
      }

      // Calculate cumulative count
      for (int i = 1; i < BASE; i++) {
        count[i] += count[i - 1];
      }

      // Build output array
      for (int i = arr.length - 1; i >= 0; i--) {
        int index = (arr[i] / exp) % 10;
        output[count[index] - 1] = arr[i];
        count[index]--;
      }

      // Copy output to arr
      System.arraycopy(output, 0, arr, 0, arr.length);
    }
  }
}