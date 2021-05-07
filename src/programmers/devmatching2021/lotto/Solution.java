package programmers.devmatching2021.lotto;

/*
    https://programmers.co.kr/learn/courses/30/lessons/77484
 */

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int joker = 0;
        int correct = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                joker++;
                continue;
            } else {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]) {
                        correct++;
                        break;
                    }
                }
            }
        }

        answer[0] = joker + correct;
        answer[1] = correct;

        for (int i = 0; i < answer.length; i++) {
            switch (answer[i]) {
                case 6 :
                    answer[i] = 1;
                    break;
                case 5 :
                    answer[i] = 2;
                    break;
                case 4 :
                    answer[i] = 3;
                    break;
                case 3 :
                    answer[i] = 4;
                    break;
                case 2 :
                    answer[i] = 5;
                    break;
                default :
                    answer[i] = 6;
                    break;
            }
        }

        return answer;
    }
}