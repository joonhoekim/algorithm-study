package algorithm.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class radixSortImpl {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    int k = getDigitLength(getMax(arr));

    radixSort(arr, k);

    String answer = String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new));
    
    System.out.println(answer);
  }

  private static int getDigitLength(int num) {
    int digit = 0;
    while (num > 0) {
      num = num / 10;
      digit++;
    }
    return digit;
  }



  private static int getMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }
    return max;
  }


  /*
  *
function radix_sort(arr, k)
  for pos = k - 1 ... pos >= 0:
    set arr_new = [10][]
    for i = 0 ... i < arr.size
      set digit = posth digit of arr[i]
      arr_new[digit].append(arr[i])

    set store_arr = []
    for i = 0 ... i < 10
      for j = 0 ... j < arr_new[i].size
        store_arr.append(arr_new[i][j])

    arr = store_arr

  return arr

  * */
  private static void radixSort(int[] arr, int k) {
    for(int position = k-1; position >=0; position--) {
      int base = 10;
      List<LinkedList<Integer>> arr_new = new ArrayList<>(base);
      for (int i = 0; i < base; i++) {
        arr_new.add(new LinkedList<Integer>());
      }



      for(int i=0; i<arr.length; i++) {
        int digit = getDigitNth(arr[i], position);
        arr_new.get(digit).add(arr[i]);
      }


      List<Integer> store_arr = new ArrayList<>(base);
      for (int i = 0; i < base; i++) {
        for(int j = 0; j < arr_new.get(i).size(); j++) {
          store_arr.add(arr_new.get(i).get(j));
        }
      }
      arr = store_arr.stream().mapToInt(Integer::valueOf).toArray();
    }

  }

  private static int getDigitNth(int num, int position) {
    int digit = 0;
    int answer = 0;
    while(digit < position) {
      //일의 자리 수 구하고
      answer = num % 10;
      //자리수 하나 날린다.
      num /= 10;
      //digit 갱신한다. (digit = n번째 자리)
      digit++;
    }
    return answer;
  }

}
