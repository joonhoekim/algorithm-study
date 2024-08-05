package exhaustiveSearch.기준을새로설정하여완전탐색.초기수열복원하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //라인 2개 sb로 읽어들이고
        String sb = br.readLine() + " " + br.readLine();
        //st로 넘겨서 쓸 것임
        StringTokenizer st = new StringTokenizer(sb,
                                                 " ");

        int n = Integer.parseInt(st.nextToken());
        int[] adjacentSumArr = new int[n - 1];
        for (int i = 0; i < adjacentSumArr.length; i++) {
            adjacentSumArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = new int[n];

        //수가 겹치거나, n을 초과하는 문제가 생기면 첫번째 자리수를 1 증가시킨다.
        loop:
        for (int initSeed = 1; initSeed <= n; initSeed++) {
            //배열을 초기화한다.
            Arrays.fill(arr,
                        1);
            //(실패하여 다시 계산하는 경우) 첫번째 자리수를 변경한다.
            arr[0] = initSeed;

            //인접합 배열을 기준으로 복원해본다.
            for (int idx = 0; idx < n - 1; idx++) {
                arr[idx + 1] = adjacentSumArr[idx] - arr[idx];
            }

            //복원한 배열이 조건(중복X, N이하)을 만족하는지 검사한다.
            //중복을 검사하는 방법은 여러가지가 있다.
            // - Set을 이용하는 방법 O(n)
            // - StreamAPI를 이용하는 방법
            // - 정렬한 다음 하나하나 비교해보는 방법 O(n log n)
            // 여기서는 중복검사와 크기 검사가 동시에 필요하므로 Set을 사용하는게 적절하다.

            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                if (num > n || !set.add(num)) {
                    continue loop;
                }
            }

            //검사를 통과했다면...
            for (int num : arr) {
                bw.write(num + " ");
            }
            break;
        }

        bw.flush();
        bw.close();
        br.close();
        //풀이 주석: 모든 수열에 대해서 완전탐색을 걸어서 만족하는 경우를 찾아보자
        //수열의 길이가 고정되어 있지 않으므로, N중 반복문으로 풀 수 없다.
    /*
    - 각 숫자는 한번씩만 나올 수 있다.
    - 그리고 각 숫자는 N 이하여야 한다.
    - 사전순으로 빠른 것을 정답으로 인정하니까, 앞에서부터 맞춰나가야 한다.

      4  6  7  6
    1  3  3  4  2
    ㄴ 3이 2번 등장하므로 앞자리 1은 실패

      4  6  7  6
    2  2  4  3  3
    ㄴ 2가 2번 등장하므로 앞자리 2는 실패

      4  6  7  6
    3  1  5  2  4
    ㄴ 성공함.
    */

    }
}
