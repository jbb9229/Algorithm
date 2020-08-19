package programmers.braket_conversion;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */

class Solution {
    public String solution(String p) {
        String answer = "";
        if (checkBrackets(p))
            answer = p;
        else{
            answer = makePerfectBrackets(p);
        }

        return answer;
    }

    boolean checkBrackets(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                sum++;
            else if(s.charAt(i) == ')'){
                if(sum <= 0){
                    return false;
                }else{
                    sum--;
                }
            }
        }

        if(sum == 0)
            return true;
        else
            return false;
    }

    String makePerfectBrackets(String s){
        String u = detachBrackets(s)[0];
        String v = detachBrackets(s)[1];
        String answer = "";

        if(checkBrackets(u)){
            if(v.equals("")){
                answer = u;
            }else {
                answer += u + makePerfectBrackets(v);
            }
        }else{
            if(v.equals("")){
                answer = "(" + ")" + changeBrackets(u);
            }else
                answer = "(" + makePerfectBrackets(v) + ")" + changeBrackets(u);
        }

        return answer;
    }

    String changeBrackets(String s){
        String original = "";
        String answer = "";

        original = s.substring(1, s.length()-1);

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == '(')
                answer += ')';
            else if (original.charAt(i) == ')')
                answer += '(';
        }

        return answer;
    }

    String[] detachBrackets(String s){
        String[] bracket = new String[2];

        int leftBracket = 0;
        int rightBracket = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                leftBracket++;
            if(s.charAt(i) == ')')
                rightBracket++;
            if(leftBracket == rightBracket){
                bracket[0] = s.substring(0, i+1);
                bracket[1] = s.substring(i+1, s.length());
                break;
            }
        }

        return bracket;
    }
}