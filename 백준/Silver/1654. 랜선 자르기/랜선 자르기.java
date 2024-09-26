import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 입력될 선의 개수
        int n = sc.nextInt(); // 만들어야 할 선의 개수

        int[] arr = new int[k];
        long max = 0; // 가장 긴 선의 길이를 저장
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countSatisfied(arr, mid) >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static long countSatisfied(int[] arr, long target) {
        long count = 0;
        for (int length : arr) {
            count += length / target;
        }
        return count;
    }
}