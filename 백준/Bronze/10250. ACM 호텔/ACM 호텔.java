import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    //ACM 호텔
    //1호부터 아래층->위층 순으로 채워지는 특징
    //H W N 순으로 입력받음
    //HHWW H,W < 100 형태로 방 위치를 출력해야 함.
    //그러면 HH층 호텔일 경우 N번쨰 손님이 묵게 될 층(H)부터 구해보자.
    // 10층 -> N=1 -> 1, N=11->1 .. 이거 자리수같네?
    // 22층 -> N=1 -> 1, N=23 -> 1, N=44 N % H 층에 가게 된다.
    // W는 어디로 가나? 몫+1에 해당한다.
    // 근데 내보니까 틀렸다고 하네. %, / 연산이니 0 관련해서 문제가 생겼나 싶다.
    // H=10, N=10 이면, Y=10, H=10, N=11이면 Y=1
    // H=10일 때 N이 증가하면 1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10 아하! 0 -> 10이 됐네
    // H=10, W=4라면, 1,1,1,1,1 , 1,1,1,1,1 , 2,2,2,2,2 , 2,2,2,2,2 ... H%N=0 일 떄는 그냥 그 X(N/H)에 머무름.

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      String[] inputs = br.readLine().split(" ");
      int H = Integer.parseInt(inputs[0]);
      int W = Integer.parseInt(inputs[1]);
      int N = Integer.parseInt(inputs[2]);

      int X;
      int Y;
      if (N % H == 0) {
        X = N / H;
        Y = H;
      } else {
        Y = N % H;
        X = N / H + 1;

      }

      sb.append(String.format("%d%02d\n", Y, X));
    }

    System.out.println(sb);

  }
}