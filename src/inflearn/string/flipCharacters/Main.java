package inflearn.string.flipCharacters;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int wordCount = in.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < wordCount; i++) {
            words.add(in.next());
        }
        Main m = new Main();
        words.forEach(word -> System.out.println(m.reverseWord(word)));
        return ;
    }

    private String reverseWord(String input) {
        String answer = "";

        for (int i=input.length()-1; i>=0; i--) {
            answer += input.charAt(i);
        }

        return answer;
    }

}
