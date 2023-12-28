import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();
    int[] baskets = new int[N];

    for(int i=0; i<N; i++){
      baskets[i]=i+1;
    }

    for (int count = 1; count <=M; count++) {
      int i = scanner.nextInt()-1;
      int j = scanner.nextInt()-1;

      int temp = baskets[i];

      baskets[i] = baskets[j];
      baskets[j] = temp;

    }

    for (int i = 0; i < baskets.length; i++) {
      System.out.print(baskets[i] + " ");
    }

  }
}