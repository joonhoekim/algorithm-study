package intermediateLow.simulation.격자안에서밀고당기기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각형컨베이어벨트 {
    /*
     *
     * 시계방향으로 회전
     * 한 변에 n개의 칸이 존재
     * t 초후 상태 출력
     *
     * 입력은 왼쪽 위, 오른쪽 위, 아래 변을 순서로 알려주는데,
     * 해당 변을 바라봤을 대 왼쪽에서 오른쪽 순서로 준다.
     *
     * 출력을 입력과 같은 방식으로 할 것.
     * - 각 숫자는 공백으로 띄우기.
     * - 변은 줄바꿈으로 구분.
     * */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        final int ANGLE = 3;
        int size = ANGLE * n;

        int[] arr = new int[size];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ANGLE; i++) {
            sb.append(br.readLine()).append(" ");
        }

        st = new StringTokenizer(sb.toString());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int reduced = t % size;
        for (int i = 0; i < reduced; i++) {
            int temp = arr[size - 1];
            for (int cursor = size - 1; cursor > 0; cursor--) {
                arr[cursor] = arr[cursor - 1];
            }
            arr[0] = temp;
        }

        sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]).append(" ");
            if ((i + 1) % n == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }

}
