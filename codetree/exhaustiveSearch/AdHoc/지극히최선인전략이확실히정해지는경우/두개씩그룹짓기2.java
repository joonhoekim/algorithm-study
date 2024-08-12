package exhaustiveSearch.AdHoc.지극히최선인전략이확실히정해지는경우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두개씩그룹짓기2 {

    /*
     * 10만개 수열이 들어오는데 2개씩 짝지을 것이다.
     * 그룹 원소간의 차이들 중에서 최솟값을 구하는데, 그 최솟값이 최대인 경우 얼마인가?
     *
     * - 수열은
     *
     * 짝은 임의로 지을 수 있다.
     * 1 2 3 4 가 있다고 하면
     * 1,2  /  3,4 차이는 1, 1 으로 최솟값은 1
     * 1,3  / 2,4 차이는 2, 2 으로 최솟값은 2
     * 1,4 / 2,3 차이는 3,1 으로 최솟값은 1
     * >> 최솟값을 줄이려면 1+3, 2+4 처럼 차이가 유사한 것들끼리 모아줘야 한다.
     *
     * 1 10 100 1000
     *
     * 1-1000 >> 999, 10-100 >>> 90 = 90
     *
     *
     *
     * >> 10만개 정렬은 1억 사이클 안에서는 충분히 해결 가능
     * >> 정렬하고, 첫번째+중간, 두번쨰+중간다음 ... 이런식으로 붙여볼까?
     *
     * */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) * 2;
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        //        for (int i = 0; i < n; i++) {
        //            bw.write(arr[i] + " ");
        //        }
        //
        //        bw.write("\n");

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n / 2; i++) {
            int diff = arr[n / 2 + i] - arr[i];
            //차이 최솟값 갱신
            ans = Math.min(ans,
                           diff);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }
}
