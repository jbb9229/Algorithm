package inflearn.string.findChar;

import java.util.Scanner;

//public class Main {
//    public int solution(String str, char t) {
//        int answer = 0;
//        str = str.toUpperCase();
//        t = Character.toUpperCase(t);
//        for (char x : str.toCharArray()) {
//            if (x == t) {
//                answer++;
//            }
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Main T = new Main();
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        char c = sc.next().charAt(0);
//        System.out.println(T.solution(str, c));
//    }
//
//}

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String target = in.nextLine().toLowerCase();
        String find = in.nextLine().toLowerCase();
        int result = 0;

        for (int i = 0; i < target.length(); i++) {
            if (find.toCharArray()[0] == target.charAt(i))
                result++;
        }

        System.out.println(result);

        return ;
    }
}