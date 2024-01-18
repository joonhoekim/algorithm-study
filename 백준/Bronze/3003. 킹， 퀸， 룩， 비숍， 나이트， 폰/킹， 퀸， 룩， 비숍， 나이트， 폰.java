import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개
    String[] input = br.readLine().split(" ");
    int[] answers = {1, 1, 2, 2, 2, 8};
    for (int i = 0; i < input.length; i++) {
      answers[i] = answers[i] - Integer.parseInt(input[i]);
    }

    for (int i : answers) {
      System.out.print(i + " ");
    }


  }
}