package inflearn.string.longestWord;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

//    Inflearn Solution
//    public String solution(String str) {
//        String answer = "";
//        int m = Integer.MIN_VALUE, pos;
//        while((pos = str.indexOf(' ')) != -1) {
//            String tmp = str.substring(0, pos);
//            int len = tmp.length();
//            if (len > m) {
//                m = len;
//                answer = tmp;
//            }
//            str = str.substring(pos + 1);
//        }
//        if (str.length() > m) {
//            answer = str;
//        }
//        return answer;
//    }

    public String findLongestWord(String str) {
        String answer = "";

        List<String> words = Arrays.asList(str.split(" "));

        words.sort((word1, word2) -> word2.length() - word1.length());

        answer = words.get(0);

        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        Main m = new Main();
        System.out.println(m.findLongestWord(input));
        return ;
    }
}