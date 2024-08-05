package exhaustiveSearch.기준을새로설정하여완전탐색.minimumUniqueStringLength;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLength = sc.nextInt();
        String input = sc.next();

        for (int size = 1; size <= inputLength; size++) {
            boolean allUnique = true;

            for (int startIdx = 0; startIdx <= inputLength - size; startIdx++) {
                String subString = input.substring(startIdx,
                                                   startIdx + size);
                if (countOccurrences(input,
                                     subString) > 1) {
                    allUnique = false;
                    break;
                }
            }

            if (allUnique) {
                System.out.println(size);
                return;
            }
        }
    }

    private static int countOccurrences(String str, String subStr) {
        int count = 0;
        int lastIndex = 0;
        while ((lastIndex = str.indexOf(subStr,
                                        lastIndex)) != -1) {
            count++;
            lastIndex += 1; // 중복 계산을 피하기 위해 1만큼만 이동
        }
        return count;
    }
}