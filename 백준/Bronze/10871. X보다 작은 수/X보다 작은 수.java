import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    //BufferedReader 하고 StringTokenizer가 빨라서 좋다고 하는데,
    //초보라서 어떻게 돌아갈지 흐름 생각하기 어렵게 만드네...

    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int X = scanner.nextInt();

    int[] arr = new int[N];
    int Y;
    int count = 0;

    for (int i = 0; i < N; i++) {
      if ((Y = scanner.nextInt()) < X) {
        arr[count++] = Y;
      }
    }
    for (int i = 0; i < count; i++) {
      System.out.print(arr[i] + " ");
    }

  }
}