package exhaustiveSearch.AdHoc.지극히최선인전략이확실히정해지는경우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 홀수짝수의묶음인데2개이상선택해야하는경우 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int oddCount = 0;
        int evenCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        bw.write(String.valueOf(solve(oddCount,
                                      evenCount)));

        bw.flush();
        bw.close();
        br.close();

        //문제
        //짝 홀 짝 홀 짝 홀 이렇게 나오도록
        //arr[]에서 임의의 원소합을 구성해나갈 것이다.
        //짝홀짝홀... 수열이 가장 길어지게 만들 때
        //최대 길이를 프린트해라

        //전략
        //우선 만들 수열의 원소는 input 배열을 최소 2개를 임의로 잡아서 합해야 한다.
        // ㄴ 다시 말하면 하나만 쓰는 건 불가능하다.
        //수열을 가장 길게 만드려면, 인풋값 개수를 아껴써야 한다.
        //가장 적은 개수는 2개이고, 2개로 짝 또는 홀을 만드려면...
        // - 짝수를 만드려면 짝+짝 또는 홀+홀을 쓰면 되고,
        // - 홀수를 만드려면 짝+홀을 써야 한다.

        //짝수, 홀수 개수를 구해서 결정하는 방식으로 풀 수 있을 것 같다.
        //예시: 짝수 2개 홀수 2개 있다면?
        //ㄴ 못만든다. 홀수 2개 혹은 짝수 2개만 만들어진다.
        //예시: 짝수 3개, 홀수 3개 있다면?
        //ㄴ 짝+짝, 짝+홀, 홀+홀 = 3개 만들 수 있다.
        //예시: 짝수 4개, 홀수 4개 있다면?
        //ㄴ 짝+짝, 짝+홀, 홀+홀, 홀+짝

        //짝수, 홀수 개수가 비슷하면 짝짝, 홀홀 번갈아 쓰면서 짝수를 만들어내서 쓸 수 있다.
        //비슷하지 않다면...?
        //짝 4 홀 10 개 있다면?
        //짝4+홀4 => 홀4, 홀3+홀3=짝3
        //짝홀 3세트+ 홀 1개 남음

        //어떤 전략을 세우는게 좋을까?
        //많이 남는 걸 먼저 쓰는 방식은 어떨까? 홀수는 홀+짝으로 홀과 짝 둘 다를 요구하니까, 밸런스를 맞추도록 짝수를 만들어내자.
        //[짝]홀2, [홀]홀짝, [짝]홀2, [홀]홀짝, [짝]홀2, [홀]홀+짝 ... 이 시점에서 짝수 1개, 홀수 1개가 남는다.
        //이것으로는 다음원소 요구사항인 짝수를 만들 수가 없고, 짝수는 아무 원소에나 주어도 되지만 홀수는 더하면 짝/홀이 바뀌어버린다.

        //길이 N이 가능한지, N=1부터 확인해보자.
        //N=1, 짝4+홀10 = 짝. 가능하다.
        //N=2, 불가능하다. 짝수를 만드려면 홀수가 '짝수 개' 있어야 한다. 홀수를 만드려면 홀수가 '홀수 개' 있어야 한다.
        //ㄴ N=2를 만드려면 홀수가 '짝+홀 = 홀수'개로 있어야 한다. 그런데 홀수가 10개 즉 짝수개 있으므로 N=2가 불가능하다.
        //N=3, 홀수가 '홀수개' 필요하므로 불가능하다.
        // - 짝(다 가능) 홀(짝수개)
        // - 짝(다 가능) 홀(홀수개)
        // - 짝(다 가능) 홀(짝수개)
        //N=4, 홀수가 '짝수개 필요하므로 가능하다.
        // - 짝(다 가능) 홀(짝수개)
        // - 짝(다 가능) 홀(홀수개)
        // - 짝(다 가능) 홀(짝수개)
        // - 짝(다 가능) 홀(짝수개)

        //N=홀수인 경우, 홀수가 홀수개 필요하며, N=짝수인 경우 홀수가 짝수개 필요하다는 것을 알았다.
        //그럼 몇개까지 만들 수 있나?
        //우선 짝수가 충분히 많다고 가정해보자. 짝수는 짝/홀을 변경시키지 못하니까.
        //홀수 개수가 k개 있다고 하면, [k*2] 개 이하로만 만들 수 있다. 부분합으로 홀수를 만드려면 홀수 1개는 필수이기 때문이다.

        //그러나 Even = 4, Odd = 10 이었던 위 예시처럼 짝수가 부족할 수도 있다.
        //이런 경우는 홀+홀로 짝수를 적절하게 채워줘야 할 것이다.
        //짝수를 몇 개나 채워줘야 할까? (이것만 해결하면 완성될듯!)
        //처음에 작은 테스트케이스를 손으로 풀어보면서, 짝수 개수 = 홀수 개수 일 때, 대략적으로 그 개수만큼 수열이 생긴다는 걸 보았다.
        //그럼, 만약 홀수가 더 많은 경우 홀+홀 > 짝으로 바꿔서 숫자를 갖게 해보자.
        //이 경우는 even+x = odd-2x 를 만드는 x를 구하면 될 것이다. 3x = odd-even = 6, x=2이다.
        //Even=6, Odd=6인 경우에, N=6이라고 가정하면,
        // Even [홀짝] Even [홀짝] Even [홀짝]  >> 홀홀, 짝짝으로 Even 자릴 채워줄 수가 없다.
        // Even 3, Odd 3 이다. 홀수개씩 남았기 때문이다...

        //Even = 4, Odd = 10 인 경우를 다시 생각해보자.
        //짝수개가 부족한 건 자명하다.
        //1차로, 짝수와 홀수 개수가 비슷하도록 맞춰보자. (홀+홀 = 짝 으로 변환)
        //Even = 6, Odd = 6
        //이것은 N=6을 만족하지 못한다.
        //왜? N/2 = 3 으로 이것은 홀수이기 때문이다.
        //그럼 N=5를 만족할 수 있나?
        //이 경우 홀수 부분합 2개, 짝수 부분합 3개가 필요하므로, 홀+짝 2세트를 미리 빼둔다.
        //그럼 Even 4, Odd 4 가 남는데,  홀홀 홀홀 짝짝 으로, 짝2개는 어디 보내도 상관 없으므로 만족 가능하다.

        /*
         * n=2
         * odd 1, even 1 불가
         * odd 2 가능 ans=1
         * even 2 가능 ans=1
         *
         * n=3 >> odd 짝수개만 가능, 최대 길이 1
         * even 3, odd 0 >> ans=1
         * even 1, odd 2 >> ans=1
         *
         * n=4 >> 이론상 최대길이 2 (n/2)
         * odd가 홀수개인 경우 최대길이로 가능
         * odd가 짝수개인 경우 n=1로 가능
         * even2, even+odd
         *
         * n=5 >> 이론상 최대길이 2
         * odd가 홀수개인 경우 최대길이로 가능
         * odd가 짝수개인 경우 n=1로 가능
         *
         * n = k인 경우 >> 이론상 최대길이 floor(k/2) 이다.
         * - 부분합 수열이 짝수개로 먼저 시작하므로, 최대길이르 2로 나누고 올린 값만큼 짝수원소가 있고
         * - 반대로 홀수 원소는 그 개수가 최대길이를 2로 나누고 th수점을 버린 값만큼 있어야 한다.
         *
         * 이 상황을 oddCount, evenCount 만족시키는지 확인해보면...
         * - 홀수가 홀수합을 만들 floor(n/2) 개보다 적다면, 홀수+홀수로 짝수로 만들어서 넘겨준다.
         * */

        /*
         * 잘못 접근한 것 같다.
         * 0101010
         * 홀+홀 로 만든 짝은 이미 부분합인데,
         * 짝2 홀4 라고 생각하면, 짝수가 2개이므로
         * 홀수를 가장 적게 만들 때 (홀+짝) 2개를 쓸 수 있다.
         * 그럼 홀2개만 남고, 이건 짝으로 변한다.
         *
         * 근데 처음부터 이걸 짝수로 넘겨준다고 생각하면
         * 남은 짝이 이미 부분합인지, 인풋 원소인지 알 수가 없다.
         *
         * */

        /*
         * 이렇게 접근하자
         * 우선 목표로 하는 최대 길이를 잡고,
         * 그에 맞게 홀+짝으로 홀수들을 처리해주고,
         * 남은 것들로 짝수들을 맞춰보자.
         * */

    }

    public static int solve(int oddCount, int evenCount) {

        int n = oddCount + evenCount;
        int goalEvenCount = (n + 1) / 2;
        int goalOddCount = n / 2;
        int goalLength = goalEvenCount + goalOddCount;

        int remainingOddCount = oddCount;
        int remainingEvenCount = evenCount;
        int currentOddCount = 0;
        int currentEvenCount = 0;

        //홀수 부분합은 홀수 1개가 필수이므로, 이것을 먼저 맞춰줘야 한다.
        while (remainingOddCount > 0 && remainingEvenCount > 0 && currentOddCount <= goalOddCount) {
            remainingOddCount--;
            remainingEvenCount--;
            currentOddCount++;
        }

        //만약 요구되는 홀수 부분합을 다 못만들었으면 해당 길이는 달성 불가하다. 길이를 1 줄이고, 해당하는 Even 혹은 Odd 목표도 줄여야 한다.
        //달성 가능할 때까지 목표를 수정한다.
        while (currentOddCount != goalOddCount) {
            if (goalLength % 2 == 0) {
                goalOddCount--;
            } else {
                goalEvenCount--;
            }
            goalLength--;
        }

        //현재 홀수의 개수에 따라 goalLength를 조정했다.
        return goalLength;

    }

}
