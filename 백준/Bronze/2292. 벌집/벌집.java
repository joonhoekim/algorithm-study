import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int given = sc.nextInt();

    //21억 이하이므로 int OK
    int endLayer = 1;

    if(given==1) {
      System.out.print(1);
      return;
    }

    while(true) {
      int endLayerMax=3*endLayer*endLayer - 3*endLayer +1;
      if(endLayerMax >= given) {
        break;
      }
      endLayer++;
    }

    System.out.print(endLayer);

  }
}