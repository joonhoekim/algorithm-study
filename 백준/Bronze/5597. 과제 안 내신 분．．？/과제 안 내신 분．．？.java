import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    final int NUM_SUBMITTED = 28;
    final int NUM_STUDENTS = 30;
    int numberRead;

    int[] receivedStnNum = new int[NUM_STUDENTS];

    for (int i = 0; i < NUM_SUBMITTED; i++) {
      numberRead = scanner.nextInt()-1;
      receivedStnNum[numberRead] = 1;
    }

    for (int i = 0; i < NUM_STUDENTS; i++) {
      if (receivedStnNum[i] == 0) {
        System.out.println(i+1);
      }
    }
      
      // 배열 인덱스를 이렇게 활용하겠다고 발상하는데 성공하면 쉬운데,
      // 검색, 정렬하는 걸로 생각하게 되면 브론드5 라는 생각이 안드는걸...
  }
}