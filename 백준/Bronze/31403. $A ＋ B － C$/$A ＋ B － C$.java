import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        int asNum = arr[0] + arr[1] - arr[2];
        int asStr = Integer.parseInt(String.valueOf(arr[0])+String.valueOf(arr[1])) - arr[2];

        System.out.println(asNum);
        System.out.println(asStr);
    }
}