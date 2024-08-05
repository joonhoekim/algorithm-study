package exhaustiveSearch.케이스별로나누기.겹침문제.구역청소;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * 분석
         * - 수직선상에 겹칠 수 있는 여러 구역들을 설정함
         * - 구역으로 설정된 전체 길이가 궁금함
         * 설계
         * - 겹치는 부분을 빼 주는 방법
         * - 구역으로 설정된 경우를 구역을 표현한 자료구조에 기록하는 방법 (배열 등)
         *   - 이 방법은 구역의 크기가 커지는 경우 불리해진다.
         * */

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int arr[] = new int[101];

        for (int i = a; i <= b; i++) {
            arr[i]++;
        }

        for (int i = c; i <= d; i++) {
            arr[i]++;
        }

        int ans = 0;
        for (int i = 0; i <= 100; i++) {
            if (arr[i] != 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
