import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int hour = scanner.nextInt();
    int minute = scanner.nextInt();
    int duration = scanner.nextInt();

    ovenAlarm(hour, minute, duration);

  }

  private static void ovenAlarm(final int hour, final int minute, final int duration) {
    int rightHour;
    int rightMinute;
    // 이번 문제는 다루는 시간 범위가 아주 커질 수 있으므로 전체를 분 단위로 다뤄보자.
    int totalMinute = 0;
    totalMinute = hour * 60 + minute + duration;

    if (totalMinute >= 24 * 60) {
      totalMinute = totalMinute - 24 * 60; //하루 지나면 자르자.
    }

    rightHour = totalMinute / 60;
    rightMinute = totalMinute % 60;

    System.out.printf("%d %d", rightHour, rightMinute);
  }

}
