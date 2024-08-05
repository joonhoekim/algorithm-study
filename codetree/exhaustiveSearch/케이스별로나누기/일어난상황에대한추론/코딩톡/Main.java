package exhaustiveSearch.케이스별로나누기.일어난상황에대한추론.코딩톡;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * 분석
         * - 입력
         *   - n = 코딩톡에 들어온 사람 수
         *   - m = 코딩톡에 올라간 메시지 수
         *   - p = 확인이 필요한 메세지 번호
         *   - 메세지 올린 사람, 해당 메세지의 읽지 않은 사람 수가 라인별로 들어옴(m개 라인)
         *
         * - 출력
         *   - p번째 메세지를 읽지 않았을 가능성이 있는 모든 사람의 이름을 사전순으로 정렬하여 공백을 사이에 두고 출력
         *
         * - 조건
         *   - 참여자 이름은 A to Z (단 26명 미만일 수 있음)
         *   - 참여자들은 모두 동일시점에 초대됨
         *   - 참여자들은 임의로 나가고, 들어올 수 있으며, 이에 대한 정보는 주어지지 않음.
         *   - 메신저 방에 들어오면, 그 시점에 있는 모든 메세지는 읽었다고 가정
         *   - '메세지를 보냈다는 것'은 '방에 들어왔다는 것(그 시점 전부 읽음)'에 대한 충분조건임
         *
         * - 이해
         *   - '메세지 정보'라는 용어를 정의해서 내는 문제라 이해가 느려짐
         *   - '메세지 정보'는 시간 순서를 따르며, 각 라인이 발송된 메세지임
         *   - '메세지 정보'는 마지막 하나의 시점에서 주어진 정보임
         *     - 따라서 읽지 않은 사람 수는 뒤로 갈수록 같거나 커지기만 한다.
         *     - 이전 문제에서 풀었던 '밀어내기' 최적화와 유사한 것 같다.
         *
         * 설계
         * - N번째 메세지 이후, 메세지를 발송한 사람은 '코딩톡 들어온 사람'이므로 확실히 읽은 사람
         * - N번째 메세지 발송자는 확실히 읽은 사람
         * - '읽지 않은 사람의 수'
         *   - 0인 경우, 해당 시점에서 톡방에서 안읽은 사람은 없는 것
         *   -
         * */

    /*
    이 테스트케이스를 보면, 1번째 메세지 안읽은 사람이 0이다. 이런 경우 전부 읽었다는 것이 성립한다.
    6 6 1
    D 0
    C 1
    B 2
    B 2
    A 2
    F 4
    * */

    /*
    이 테스트케이스도 B C D E 가 답일 것 같은데 C D E 가 답이다.

    6 6 5
    D 0
    C 1
    B 2
    B 2
    A 2
    F 4

    왜? 왜 B는 읽었다는 것이 확실히 성립하지?
    4번째인 B가 보낸 메세지의 안읽은 사람의 수와
    5번째인 A가 보낸 메세지의 안읽은 사람의 수가 같음에 주목해야 함
    정확히 누가 읽지 않았는지는 알 수 없지만,
    B 2 를 만든 읽은 이들과 A 2 를 만든 읽은 이들은 동일해야 함
    그렇지 않으면 A의 메세지를 읽지 않은 사람 수가 줄어들어야 하기 때문임
    이말은 즉슨, A 2 메세지는 A, F, B가 확실히 읽었을 것이라는 이야기임

    B 2 메세지를 읽은 사람들 = A 2 메세지를 읽은 사람들이므로
    A 2 메세지를 읽은 사람에 B 2 발신자인 B가 추가되어야 하는 것임

    그럼 이것을 어떻게 코드로 처리할까?
    맨 마지막메세지에서부터 위로 추리하면서 올라가면 된다.
    위 메세지의 읽지 않은 사람 수가 동일하다면, 위 메세지의 발신자를 '읽지 않았을 가능성이 있는 사람' 에서 제외하면 된다.
    그 메세지도 읽지 않은 사람 수가 그 위 메세지와 동일하면, 그 위 메세지의 발신자를 제외한다.

    정리하면
    - 만약, p번째 메세지에 도착했을 때, 안읽은 사람 수가 0이면 모두 다 읽은 것이 자명하므로 넘긴다.
    - 아니라면, 맨 마지막 메세지부터 처리를 시작한다.
    - p번째 이후의 메세지 발신자들은 제외한다. 들어와서 반드시 읽었을테니까.
    - p = 1 이면 안읽은 메세지 수로 추리할 수 있는 것이 없다.
    - p >= 2 이면, [이전 메세지의 안읽은사람 수가 동일한 경우] 이전 메세지 발신자를 의심목록에서 제거하고, 그 전의 메세지도 동일하게 확인한다. 안읽은 사람의 수가 동일하지 않을 때까지 반복한다.

    * */

        Scanner sc = new Scanner(System.in);
        // 1 부터 n 을 그대로 idx로 쓸 것임
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        final int SENDER = 0;
        final int UNREAD_COUNT = 1;

        int[][] msgInfo = new int[m + 1][2];
        for (int i = 1; i <= m; i++) {
            //센더 ID를 int로 저장 (A = 0, ... , Z = 26)
            msgInfo[i][SENDER] = (sc.next().charAt(0) - 'A');
            msgInfo[i][UNREAD_COUNT] = sc.nextInt();
        }

        //예외적인 경우 (p번째 메세지 정보에 안읽은 사람수가 0으로 자명함)
        if (msgInfo[p][UNREAD_COUNT] == 0) {
            return;
        }

        //그 외인 경우, 조건에 따라 처리함
        boolean[] possibleUnreadUserIds = new boolean[n];
        Arrays.fill(possibleUnreadUserIds,
                    true);

        for (int msgOrder = m; msgOrder > 0; msgOrder--) {

            //p번째까지 발송자들은 무조건 읽었으므로 제외
            int readedUser = msgInfo[msgOrder][SENDER];
            possibleUnreadUserIds[readedUser] = false;

            if (msgOrder <= p) {
                //이전 메세지와 UNREAD_COUNT가 동일한 경우 이전 메세지 발송자도 제외해야 하므로 반복 진행,
                if (msgInfo[msgOrder][UNREAD_COUNT] == msgInfo[msgOrder - 1][UNREAD_COUNT]) {
                    continue;
                } else {
                    //아닌 경우는 관계없으므로 종료
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (possibleUnreadUserIds[i]) {
                sb.append((char) (i + 'A')).append(" ");
            }
        }

        System.out.println(sb);

    }
}