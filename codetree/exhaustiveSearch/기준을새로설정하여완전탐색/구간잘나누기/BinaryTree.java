package exhaustiveSearch.기준을새로설정하여완전탐색.구간잘나누기;

import java.util.Scanner;

public class BinaryTree {

    // 주어진 최대합으로 배열을 m개 이하의 그룹으로 나눌수 있는지 확인
    // 코드트리 해설도 같은 아이디어로 풀고 있음. (이진트리를 도입하지 않아도 됨)

    static int n, m;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            right += arr[i];
            left = Math.max(left,
                            arr[i]);
        }

        System.out.println(binarySearch(left,
                                        right));
    }

    static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDivide(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static boolean canDivide(int maxSum) {
        int count = 1;
        int currentSum = 0;
        for (int num : arr) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;
                if (count > m) {
                    return false;
                }
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}