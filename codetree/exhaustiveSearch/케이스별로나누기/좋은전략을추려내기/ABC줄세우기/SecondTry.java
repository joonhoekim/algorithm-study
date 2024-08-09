package exhaustiveSearch.케이스별로나누기.좋은전략을추려내기.ABC줄세우기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SecondTry {
    public static void main(String[] args) throws Exception {
        /*
        * 분석
        * '인접한' 두 사람의 자리만 바꿀 수 있는 경우
        * 순서대로 줄을 세우기 위해
        * 이동해야 하는 '최소' 횟수를 구하기
        *
        * 이해
        * 가까이 붙어있는 경우에만 서로 자리 바꾸기가 가능
        *
        * 접근
        * A부터 위치를 맞춰준다고 가정하고 바꿔주자
        * 그 다음에는 B, 그 다음에는 C....
        * DBCA >> DBAC >> DABC >> ADBC >> ABDC >> ABCD
        *
        * */

        //입력 상용구
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0)-'A';
        }

        int count = 0;

        //각 인덱스(알파벳)에 대해, 정렬 완료되면 해당 인덱스가 최솟값인 시뮬레이션을 진행한다.
        for (int minValue = 0; minValue < n; minValue++) {
            //전체 탐색을 통해 최솟값이 위치한 인덱스를 찾아낸다
            for (int checkIdx = minValue; checkIdx < n; checkIdx++) {
                if(minValue == arr[checkIdx]) {
                    int currentMinValueIdx = checkIdx;
                    
                    //정렬될 때까지 왼쪽과 스왑
                    while(currentMinValueIdx != minValue) {
                        int temp = arr[currentMinValueIdx-1];
                        arr[currentMinValueIdx-1] = arr[currentMinValueIdx];
                        arr[currentMinValueIdx] = temp;
                        currentMinValueIdx--;
                        count++;
                    }
                }

            }
        }

        System.out.println(count);




    }
}
