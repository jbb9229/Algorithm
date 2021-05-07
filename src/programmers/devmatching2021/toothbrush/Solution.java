package programmers.devmatching2021.toothbrush;

/*
    https://programmers.co.kr/learn/courses/30/lessons/77486
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String, Integer> sellMoney = new HashMap<>();
        for (int i = 0; i < seller.length; i++) {
            splitSellMouney(sellMoney, enroll, referral, seller[i], amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = sellMoney.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    private void splitSellMouney(Map<String, Integer> sellMoney, String[] enroll, String[] referral, String seller, int amount) {
        if (seller.equals("-")) {

        } else {
            sellMoney.put(seller, sellMoney.getOrDefault(seller, 0) + (amount - amount/10));
            int referralIndex = 0;
            for (int i = 0; i < enroll.length; i++) {
                if (seller.equals(enroll[i])) {
                    referralIndex = i;
                    break;
                }
            }
            splitSellMouney(sellMoney, enroll, referral, referral[referralIndex], amount / 10);
        }
    }
}