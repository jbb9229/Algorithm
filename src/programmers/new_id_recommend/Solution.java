package programmers.new_id_recommend;

/*
    https://programmers.co.kr/learn/courses/30/lessons/72410
 */

class Solution {
    public String solution(String new_id) {
        String answer = "";

        answer = step1(new_id);

        System.out.println(answer);

        answer = step2_3(answer);

        System.out.println(answer);

        answer = step4(answer);

        System.out.println(answer);

        answer = step5(answer);

        System.out.println(answer);

        answer = step6(answer);

        System.out.println(answer);

        answer = step7(answer);

        System.out.println(answer);

        return answer;
    }

    private String step1(String new_id) {
        return new_id.toLowerCase();
    }

    private String step2_3(String new_id) {
        int length = new_id.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            char target = new_id.charAt(i);
            if ((target >= 'a' && target <= 'z') || target == '-' || target == '_' || target == '.' || (target >= '0' && target <= '9')) {
                if (target == '.') {
                    if (result.length() > 0) {
                        if (result.charAt(result.length() - 1) == '.') {
                            continue;
                        }
                    }
                }
                result += target;
            }
        }

        return result;
    }

    private String step4(String new_id) {
        if (new_id.charAt(0) == '.') {
            if (new_id.length() == 1) {
                new_id = "";
            } else {
                new_id = new_id.substring(1);
            }
        }
        if (new_id.length() > 1) {
            if (new_id.charAt(new_id.length() - 1) == '.') {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        return new_id;
    }

    private String step5 (String new_id) {
        if (new_id.length() == 0) {
            new_id = "a";
        }
        return new_id;
    }

    private String step6 (String new_id) {
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }
        new_id = step4(new_id);
        return new_id;
    }

    private String step7 (String new_id) {
        if (new_id.length() < 3) {
            String lastWord = new_id.charAt(new_id.length() - 1) + "";
            int loopSize = 3 - new_id.length();
            for (int i = 0; i < loopSize; i++) {
                new_id += lastWord;
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String new_id = "=.=";
        solution.solution(new_id);
    }
}