package algorithm.dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class doublyLinkedList {

  /*
  *
push_front A: 정수 A를 연결 리스트의 앞에 넣습니다.
push_back A: 정수 A를 연결 리스트의 뒤에 넣습니다.
pop_front: 연결 리스트의 가장 앞에 있는 수를 빼고, 그 수를 출력합니다.
pop_back: 연결 리스트의 가장 뒤에 있는 수를 빼고, 그 수를 출력합니다.
size: 연결 리스트에 들어있는 정수의 개수를 출력합니다.
empty: 연결 리스트가 비어있으면 1을, 아니면 0을 출력합니다.
front: 연결 리스트의 가장 앞에 있는 정수를 출력합니다.
back: 연결 리스트의 가장 뒤에 있는 정수를 출력합니다.
  * */

  public static void main(String[] args) throws Exception {
    LinkedList<Integer> dll = new LinkedList<>();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {

      String[] input = br.readLine().split(" ");
      String command = input[0];
      int value = 0;
      if (input.length == 2) {
        value = Integer.parseInt(input[1]);
      }
      String output = null;

      if(command.equals("push_front")) {
        dll.addFirst(value);
      } else if (command.equals("push_back")) {
        dll.addLast(value);
      } else if (command.equals("pop_front")) {
        output = String.valueOf(dll.pollFirst());
      }
      else if (command.equals("pop_back")) {
        output = String.valueOf(dll.pollLast());
      }
      else if (command.equals("size")) {
        output = String.valueOf(dll.size());
      }
      else if (command.equals("empty")) {
        if(dll.isEmpty()) {
          output = "true";
        } else {
          output = "false";
        }
      }
      else if (command.equals("front")) {
        output = String.valueOf(dll.peekFirst());
      }
      else if (command.equals("back")) {
        output = String.valueOf(dll.peekLast());
      }

      //check
      if(output != null) {
        bw.write(output + "\n");
      }
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
