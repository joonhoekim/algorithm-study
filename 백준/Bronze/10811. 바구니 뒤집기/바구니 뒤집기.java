import java.util.Scanner;

public class Main {

  //문제를 잘 봐야겠다. 범위를 받아서 뒤집는 게 아니라 두 개만 바꾸는 건 줄 알았네..

  static void swapRange(int[] arr, int left, int right){
    while(left<right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] baskets = new int[N];
    for (int i = 0; i < baskets.length; i++) {
      baskets[i]=i+1;
    }

    for (int i = 0; i < M; i++) {
      int left = sc.nextInt()-1;
      int right = sc.nextInt()-1;

      swapRange(baskets,left,right);
    }

    for (int i = 0; i < baskets.length; i++) {
      System.out.print(baskets[i]+" ");
    }

    sc.close();

  }
}