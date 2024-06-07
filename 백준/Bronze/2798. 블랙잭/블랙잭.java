import java.util.Arrays;
import java.util.Scanner;
//DP를 아직 잘 몰라 완전탐색을 적용함.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int global = 0;
        loop: for (int first = 0; first < n-2; first++) {
            for (int second = first+1; second < n-1; second++) {
                for (int third = second+1; third < n; third++) {
                    int local = arr[first] +arr[second] + arr[third];

                    if(local==m) {
                        global = m;
                        break loop;
                    }

                    if(local < m) {
                        global = Math.max(global, local);
                    }

                }

            }
        }

        System.out.println(global);
    }
}