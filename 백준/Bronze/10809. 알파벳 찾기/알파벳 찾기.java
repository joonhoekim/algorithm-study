import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int ALPHABETS = 26; //알파벳은 총 26개다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] alphabet = new int[ALPHABETS];
        //Heap 에 인스턴스 생성되면서 각각의 int 메모리는 0으로 자동 초기화되니 초기화 과정 생략.

        //처음에는 S의 char 하나마다 26회의 반복문을 돌리는 걸 생각했다.
        //근데 비효율적인것도 있고, 그보다도 구현이 어려울 거 같아서 생각을 바꿨다.
        //받은 문자열 수만큼만 알파벳 배열에 위치값을 넣어주고 (처음 위치니까 역으로 돌리고)
        //마지막에 0인 알파벳 배열들을 검사해서 -1로 값을 바꿔주기로 했다.
        // ㄴ 라고 생각했는데, 알파벳이 a인 경우는 위치가 0이기 때문에... 문제가 된다.
        // 그래서 초기값을 -1 로 세팅하고 돌리기로 했다.

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) {
                alphabet[i] = -1;
            }
        }
        //여기서 i는 검사하는 단어의 인덱스(위치)다.
        for (int i = S.length() - 1; i >= 0; --i) {
            //S.charAt(i)-'a' 가 그 위치를 건네줄 alphabet 배열의 인덱스가 된다.
            alphabet[Integer.valueOf(S.charAt(i)) - 'a'] = i;
        }


        for (int i = 0; i < ALPHABETS; i++) {
            System.out.print(alphabet[i] + " ");
        }


    }

}