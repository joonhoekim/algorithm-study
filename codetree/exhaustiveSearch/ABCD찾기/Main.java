package exhaustiveSearch.ABCD찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int[] arr = new int[st.countTokens()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    // A+B+C+D - B+C+D = A
    int a = arr[arr.length - 1] - arr[arr.length - 2];

    // A+B+C+D - A+C+D = B
    int b = arr[arr.length - 1] - arr[arr.length - 3];

    // A+B+C+D - A+B+D = C
    int c = arr[arr.length - 1] - arr[arr.length - 4];

    // A+B+C+D - A+B+C = D
    int d = arr[arr.length - 1] - arr[arr.length - 5];

    System.out.printf("%d %d %d %d", a, b, c, d);
  }
}
