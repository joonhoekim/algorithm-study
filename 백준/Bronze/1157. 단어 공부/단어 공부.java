import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] alphabetCount = new int[26];
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String S = br.readLine();

    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) >= 'a') { //A=0x41, a=0x61
        alphabetCount[S.charAt(i) - 'a'] += 1;
      } else {
        alphabetCount[S.charAt(i) - 'A'] += 1;
      }
    }

//    테스트용 코드
//      for (int i = 0; i < alphabetCount.length; i++) {
//        System.out.print(alphabetCount[i] + " ");
//      }
//      System.out.println("");

    int max = -1;
    int maxIndex = -1;
    boolean duplicate = false;
    int count = 0;
    for (int i = 0; i < alphabetCount.length; i++) {
      if (max < alphabetCount[i]) {
        max = alphabetCount[i];
        maxIndex = i;
      }
    }
    for (int i = 0; i < alphabetCount.length; i++) {
      if (alphabetCount[i] == max) {
        count++;
      }
    }

    if (count > 1) {
      duplicate = true;
    }

    if (duplicate) {
      System.out.println("?");
    } else {
      System.out.print((char) (maxIndex + 'A'));

    }

  }
}