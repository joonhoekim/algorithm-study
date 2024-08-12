package exhaustiveSearch.AdHoc.지극히최선인전략이확실히정해지는경우;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수열의순서바꾸기 {

    /*
     * 정수 수열이 겹치는 수 없이 주어지는데
     * 맨 앞에 있는 숫자를 뒤에 있는 숫자들의 중간에 집어넣는 액션만 허용될 때 (단 맨 끝에 넣는 것도 허용 된다)
     * incremental sort 하려면 해당 액션의 최소 횟수가 얼마일까?
     *
     * 맨 앞 숫자를 뒤로 밀어줘야 하니 LIS를 구해서 푸는 문제는 아니다.
     * 어떤 전략을 가지고 재귀적으로 풀면 될 것 같은데...
     *
     * 아래와 같은 입력 케이스를 생각해보자
     * 1 2 4 3
     * 1을 옮겨줄 때, 이 숫자가 들어갈 자리를 파악하기가 단순하지 않다.
     * - 인접한 수인 2의 왼쪽으로 옮겨줄 것인가? 이미 그 자리에 있으니 안된다.
     * - 그럼 다음 수인 3의 왼쪽으로 옮겨줄 것인가? 가능하다.
     *
     * 2 4 1 3
     * - 1의 다음으로 옮겨주거나, 3의 전으로 옮겨준다.
     *
     *  4 1 2 3
     * - 3의 다음으로 옮겨준다.
     *
     *
     * 1 2 3 4 (정렬완료)
     *
     * 정리하면 >> 다음 수의 이전으로 옮기거나, 이전 수의 오른쪽으로 옮길 수 있다. <<
     * 그런데 반례가 있다.
     * 2 1 3 5 4
     * - 2 를 1의 다음으로 옮겨주는 경우, 1 2 3 5 4 가 되고 이것은 최적이 아니다.
     * - 왜 그런가? 어차피 뒤에 정렬되지 않은 게 있어서, 5를 가져와서 정렬해야 한다는 걸 알기 때문이다. 5 이후로 옮겨줘야 한다.
     * - 1 3 5 2 4
     * - 3 5 1 2 4
     * - 5 1 2 3 4
     * - 1 2 3 4 5
     *
     * 2 1 3 4 5
     * 1 2 3 4 5
     *
     * 증가수열을 꺠는 가장 마지막 지점을 알아야 한다
     *
     * 1 2 4 3 6 5
     * 위를 보면 4 3 도 증가가 깨지고, 6 5 도 증가가 깨진다.
     * 6을 맨 앞으로 가져와서 처리하기 전까지는 해결이 불가능하다는 것을 알 수 있다.
     * 그럼 꺼내기 전의 것들은 6 뒤로 밀어줘야 한다!!
     * 그 뒤로 넣어주는데 순서대로 넣어주면 된다.
     *
     * 1 2 3 5 4
     *
     * 2 1 3 4
     * */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lastErrorIdx = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                lastErrorIdx = i;
            }
        }

        bw.write(String.valueOf(lastErrorIdx + 1));
        br.close();
        bw.flush();
        bw.close();
    }

}
