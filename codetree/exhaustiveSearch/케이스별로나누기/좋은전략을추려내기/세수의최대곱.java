package exhaustiveSearch.케이스별로나누기.좋은전략을추려내기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세수의최대곱 {

    /*
     * 문제
     * - 10만개 정도의 수가 주어질 때,
     * - 3개 곱해서 나올 수 있는 최댓값 구하기
     * 분석
     * - 수가 1000개 주어진다.
     * - 완전탐색하는 경우 1000^3 = 10^9 = 10억 정도로, 1초안에 해결 불가
     * 설계
     * - 일단 완전탐색으로 풀어보자(아마 시간초과?)
     * - 음수 * 음수 * 양수 혹은 양수 * 양수 * 양수
     * - 즉 짝수개의 음수를 곱하는 게 전략일 것이다.
     * 구현
     * - 일단 무식하게 구해보자
     * >> 역시 시간 초과다.
     *
     * 전략
     * - 1000개를 정렬하는데 얼마 걸리지 않을 것임 (nlogn)
     * - 정렬하고 두가지 케이스 비교하면 된다.
     *   - ++-, --+
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                hasZero = true;
            }
        }

        Arrays.sort(arr);
        int mmp = arr[0] * arr[1] * arr[arr.length - 1];
        int ppp = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];

        int globalMax = Math.max(mmp,
                                 ppp);

        if (hasZero) {
            globalMax = Math.max(globalMax,
                                 0);
        }

        System.out.println(globalMax);

    }
}
