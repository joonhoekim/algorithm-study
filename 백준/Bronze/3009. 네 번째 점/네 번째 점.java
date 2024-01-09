import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int[] x = new int[4];
    int[] y = new int[4];

    for (int i = 0; i < 4 - 1; i++) {
      String[] s = br.readLine().split(" ");
      x[i] = Integer.parseInt(s[0]);
      y[i] = Integer.parseInt(s[1]);
    }

    if (x[0] != x[1]) {
      if (x[0] != x[2]) {
        x[3] = x[0];
      }
    }
    if (x[1] != x[2]) {
      if (x[0] == x[2]) {
        x[3] = x[1];
      } else {
        x[3] = x[2];
      }
    }

    if (y[0] != y[1]) {
      if (y[0] != y[2]) {
        y[3] = y[0];
      }
    }
    if (y[1] != y[2]) {
      if (y[0] == y[2]) {
        y[3] = y[1];
      } else {
        y[3] = y[2];
      }
    }
    
    System.out.printf("%d %d", x[3], y[3]);


  }
}