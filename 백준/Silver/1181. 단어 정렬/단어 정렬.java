import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = Integer.parseInt(scanner.nextLine());
    String[] words = new String[N];
    for (int i = 0; i < N; i++) {
      words[i] = scanner.nextLine().trim();
    }

    Arrays.sort(words, (a, b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b); // 길이가 같으면 사전 순으로
      } else {
        return Integer.compare(a.length(), b.length()); // 길이가 짧은 것부터
      }
    });

    // 중복 제거
    ArrayList<String> uniqueWords = new ArrayList<>();
    String prevWord = "";
    for (String word : words) {
      if (!word.equals(prevWord)) {
        uniqueWords.add(word);
        prevWord = word;
      }
    }

    // 결과 출력
    for (String word : uniqueWords) {
      System.out.println(word);
    }
  }
}