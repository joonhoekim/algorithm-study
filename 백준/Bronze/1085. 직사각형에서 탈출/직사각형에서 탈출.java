import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int x = Integer.parseInt(input[0]);
    int y = Integer.parseInt(input[1]);
    int w = Integer.parseInt(input[2]);
    int h = Integer.parseInt(input[3]);
    int wDist, hDist;
    // 본 조건의 직사각형으로 최단 거리는 경계선에 수직하는 방향으로 가야하네

    if (x < w - x) {
      wDist = x;
    } else {
      wDist = w - x;
    }

    if (y < h - y) {
      hDist = y;
    } else {
      hDist = h - y;
    }

    if (wDist < hDist) {
      System.out.println(wDist);
    } else {
      System.out.println(hDist);
    }

  }
}