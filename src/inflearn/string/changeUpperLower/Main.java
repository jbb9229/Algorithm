package inflearn.string.changeUpperLower;

import java.util.Scanner;

public class Main {
    public String changeUpperLower(String str) {
        String changedStr = "";
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                changedStr += Character.toUpperCase(ch);
            } else {
                changedStr += Character.toLowerCase(ch);
            }
        }

        return changedStr;
    }

    public static void main(String[] args){
        Main m = new Main();
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        System.out.println(m.changeUpperLower(input1));
        return ;
    }

}