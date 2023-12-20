import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int hour = scanner.nextInt();
    int minute = scanner.nextInt();

    fortyFiveAlarm(hour, minute);

  }

  private static void fortyFiveAlarm(final int hour, final int minute) {
    int rightHour;
    int rightMinute;
    if (hour == 0 && minute < 45) {
      rightHour = 23;
      rightMinute = 60 + minute - 45; //윗 자릿수에서 하나 빼 온다.
    } else if (minute < 45) {
      rightHour = hour - 1;
      rightMinute = 60 + minute - 45;
    } else {
      rightHour = hour;
      rightMinute = minute - 45;
    }

    System.out.printf("%d %d", rightHour, rightMinute);
  }

}
