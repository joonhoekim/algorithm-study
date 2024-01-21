import java.util.Scanner;

public class Main{ 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long factorial = 1;
        for(long i = n; i>=1; i--) {
            factorial *= i;
        }
        System.out.print(factorial);
    }
} 