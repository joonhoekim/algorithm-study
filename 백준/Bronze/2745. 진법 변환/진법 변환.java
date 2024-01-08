import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //입력을 공백 기준으로 분할하여 받기
    String[] input = br.readLine().split(" ");
    String B_digitNumber = input[0];
    int B = Integer.parseInt(input[1]);

    // 진법에서 A~Z가 나온다면 파싱하기 => 정수 배열로 바꾸기
    // 숫자와 문자가 아스키값에서 연속하지 않아서 정수값을 활용할 수 없음 (9와 A가 연속하지 않음)

    //새로운 정수 배열 선언
    int[] parsedNumber = new int[B_digitNumber.length()];

    //10진법 이상부터만 문자를 사용함
    if (B > 10) {
      for (int i = 0; i < parsedNumber.length; i++) {
        if (B_digitNumber.charAt(i) >= 'A') {
          parsedNumber[i] = B_digitNumber.charAt(i) - 'A' + 10;
        } else {
          parsedNumber[i] = B_digitNumber.charAt(i) - '0';
        }
      }
    } else {
      for (int i = 0; i < parsedNumber.length; i++) {
        parsedNumber[i] = B_digitNumber.charAt(i) - '0';
      }
    }

    //계산부
    //여기서 실수가 있었다. 어려운게 아닌데 키보드에서 바로 손끝으로 구현하는게 어려웠다.
    int decimalSum = 0;
    for (int i = 0; i < parsedNumber.length; i++) {
      decimalSum = decimalSum + parsedNumber[i] * (int) Math.pow(B, parsedNumber.length - 1 - i);
    }

    System.out.println(decimalSum);

    br.close();
  }
}