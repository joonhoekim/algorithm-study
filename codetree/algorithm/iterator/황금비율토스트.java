package algorithm.iterator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class 황금비율토스트 {

  public static void main(String[] args) throws Exception {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

      //command[0] = 식빵의 개수, command[1] = 레시피 암호문의 개수
      int[] firstlineArgs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      String secondlineInput = br.readLine();
      List<Character> list = new LinkedList<>();
      for (int i = 0; i < secondlineInput.length(); i++) {
        list.add(secondlineInput.charAt(i));
      }
      ListIterator<Character> iterator = list.listIterator(list.size());

      //명령 받기
      for (int i = 0; i < firstlineArgs[1]; i++) {
        String[] command = br.readLine().split(" ");
        try{
          switch (command[0]) {
            case "L" -> iterator.previous();
            case "R" -> iterator.next();
            case "D" -> {if(iterator.hasNext()) {iterator.next();} iterator.remove();}
            case "P" -> iterator.add(command[1].charAt(0));
//            case "L" -> System.out.println("R: " + iterator.previous());
//            case "R" -> System.out.println("R: " + iterator.next());
//            case "D" -> {iterator.next(); iterator.remove();}
//            case "P" -> {iterator.add(command[1].charAt(0));
//              System.out.println("added " + command[1]);}
          }
        } catch (Exception e){
          System.out.println(e.getMessage());
        }
      }

      // 최종 리스트 출력
      StringBuilder sb = new StringBuilder();
      list.iterator().forEachRemaining(sb::append);
      System.out.println(sb.toString());
    }
  }
}
