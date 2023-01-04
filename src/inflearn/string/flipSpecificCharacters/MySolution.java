package inflearn.string.flipSpecificCharacters;

import java.util.Scanner;
import java.util.Stack;

public class MySolution {

//    public String flipSpecificCharacters(String str) {
//        String answer = "";
//
//        List<Integer> specificsIndex = new ArrayList<>();
//        List<Character> alpabets = new ArrayList<>();
//
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
//                alpabets.add(ch);
//            } else {
//                specificsIndex.add(i);
//            }
//        }
//
//        int index = alpabets.size() - 1;
//        for (int i = 0; i < str.length(); i++) {
//            if (specificsIndex.contains(i)) {
//                answer += str.charAt(i);
//            } else {
//                answer += alpabets.get(index);
//                index--;
//            }
//        }
//
//        return answer;
//    }

    public String flipSpecificCharacters(String str) {
        String answer = "";

        Stack<Character> characterStack = new Stack<>();
        char[] replaceSpecific = str.replaceAll("[^a-zA-Z]", "").toCharArray();
        for (char alphabet : replaceSpecific) {
            characterStack.push(alphabet);
        }


        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                answer += characterStack.pop();
            } else {
                answer += str.charAt(i);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        MySolution m = new MySolution();
        System.out.println(m.flipSpecificCharacters(input));
        return ;
    }
}
