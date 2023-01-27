package inflearn.string.deleteOverlap;

import java.util.Scanner;

public class Main {

//    public String solution(String str) {
//        String answer = "";
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            answer += ch;
//            str = str.replaceAll(String.valueOf(ch), " ");
//        }
//
//        return answer.replaceAll(" ", "");
//    }

    public String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}
