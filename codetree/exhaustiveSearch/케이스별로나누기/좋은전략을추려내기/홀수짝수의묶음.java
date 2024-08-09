package exhaustiveSearch.케이스별로나누기.좋은전략을추려내기;

import java.io.*;
import java.util.*;

public class 홀수짝수의묶음 {

    // 주어지는 수열에서 임의 선택하여 합을 구해서 수열의 원소로 쓸 것이다.
    // 짝 / 홀 / 짝 / 홀 ... 이렇게 번갈아 나오는 형태로 수열을 최대한 길게 만들어봐라
    // 수열에는 아무런 제한이 없다. 임의 선택 합을 하는 것에는, 1개만 선택하는 것이 불가능하다는 제한이 있다.

    // 홀 = 홀수 OR 홀수 + 짝수
    // 짝 = 짝수 + 짝수 OR 홀수 + 홀수


    // 우선 홀수 만드는 게 어렵다. 홀수 + 짝수 여야 홀수가 만들어진다.
    // 홀수 개수 4개, 짝수 개수 4개라고 하면...
    // 최대 수열 길이는 (4 + 4) / 2 = 4개
    // 짝+짝 짝+홀 홀+홀 짝+홀
    // 홀수 n

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));




        br.close();
        bw.flush();
        bw.close();

    }
}
