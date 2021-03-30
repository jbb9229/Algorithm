package baekjoon.p11057;

/*
    https://www.acmicpc.net/problem/11057

    문제
    오르막 수는 수의 자리가 오름차순을 이루는 수를 말한다. 이때, 인접한 수가 같아도 오름차순으로 친다.

    예를 들어, 2234와 3678, 11119는 오르막 수이지만, 2232, 3676, 91111은 오르막 수가 아니다.

    수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.

    입력
    첫째 줄에 N (1 ≤ N ≤ 1,000)이 주어진다.

    출력
    첫째 줄에 길이가 N인 오르막 수의 개수를 10,007로 나눈 나머지를 출력한다.
 */

public class Solution {

    public int solution(int n) {
        int result = 0;

        if (n > 1) {
            result = loopCalc(n, 10);
        } else {
            result = 10;
        }

        System.out.println(result);

        return result;
    }

    private int loopCalc(int n, int i) {
        int result = 0;
        n--;
        if (n <= 1) {
            for (int j = i; j > 0; j--) {
                result += j;
            }
        } else {
            for (int j = i; j > 0; j--) {
                result += loopCalc(n, j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] dp = new int[10];
        int result = 0;
        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < N; i++) {
            result = 0;
            for (int j = 1; j < 10; j++) {
                dp[j] = (dp[j] + dp[j - 1]) % 10007;
                result = (result + dp[j]) % 10007;
            }
        }
        if(result==0)
            System.out.println(10);
        else
            System.out.println((result + 1) % 10007);
    }

}
