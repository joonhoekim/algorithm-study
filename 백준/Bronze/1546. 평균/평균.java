import java.util.Scanner;

public class Main {

  //문제를 잘 봐야겠다. 범위를 받아서 뒤집는 게 아니라 두 개만 바꾸는 건 줄 알았네..

  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    double[] scores = new double[N];
    for (int i = 0; i < N; i++) {
      scores[i] = sc.nextInt();
    }
    double highestScore=0;
    for (int i = 0; i < N; i++) {
      if(highestScore<scores[i]){
        highestScore=scores[i];
      }
    }

    double sum=0;
    for (int i = 0; i < N; i++) {
      scores[i]=scores[i]/highestScore*100;
      sum+=scores[i];
    }
    double avg = sum/N;
    System.out.printf("%.5f",avg);


    sc.close();

  }
}