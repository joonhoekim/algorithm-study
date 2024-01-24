import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    Double gradeSum = 0D;
    Double creditSum = 0D;

    for (int i = 0; i < 20; i++) {
      String gradeStr;
      sb.append(br.readLine());
      if (sb.charAt(sb.length() - 1) == 'P') {
        sb.setLength(0);
        continue;
      } else if (sb.charAt(sb.length() - 1) == 'F') {
        creditSum += Double.parseDouble(sb.substring(sb.length() - 5, sb.length() - 2));
        sb.setLength(0);
        continue;
      }

      gradeStr = sb.substring(sb.length() - 2, sb.length());
      Double credit = Double.parseDouble(sb.substring(sb.length() - 6, sb.length() - 3));
      //IDE 없이 풀 수 있게 여러번 풀어봐야겠다.
      //System.out.println("credit: " + gradeStr);
      Double creditXgrade = gradeCalc(gradeStr) * credit;
      //System.out.println("creditXgrade: " + creditXgrade);
      gradeSum += creditXgrade;
      creditSum += credit;
    }

    System.out.println(gradeSum / creditSum);


  }

  static double gradeCalc(String gradeStr) {
    if (gradeStr.equals("A+")) {
      return 4.5D;
    } else if (gradeStr.equals("A0")) {
      return 4.0D;
    } else if (gradeStr.equals("B+")) {
      return 3.5D;
    } else if (gradeStr.equals("B0")) {
      return 3.0D;
    } else if (gradeStr.equals("C+")) {
      return 2.5D;
    } else if (gradeStr.equals("C0")) {
      return 2.0D;
    } else if (gradeStr.equals("D+")) {
      return 1.5D;
    } else {
      return 1.0D;
    }
  }
}