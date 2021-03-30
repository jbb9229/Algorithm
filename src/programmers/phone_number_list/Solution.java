package programmers.phone_number_list;

/*
    https://programmers.co.kr/learn/courses/30/lessons/42577?language=java

    문제 설명
    전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
    전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

    구조대 : 119
    박준영 : 97 674 223
    지영석 : 11 9552 4421
    전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

    제한 사항
    phone_book의 길이는 1 이상 1,000,000 이하입니다.
    각 전화번호의 길이는 1 이상 20 이하입니다.
    같은 전화번호가 중복해서 들어있지 않습니다.
    입출력 예제
    phone_book	return
    ["119", "97674223", "1195524421"]	false
    ["123","456","789"]	true
    ["12","123","1235","567","88"]	false
    입출력 예 설명
    입출력 예 #1
    앞에서 설명한 예와 같습니다.

    입출력 예 #2
    한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.

    입출력 예 #3
    첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
 */

import java.util.*;

class Solution {
//    효율성 4번 실패
//    public boolean solution(String[] phone_book) {
//        boolean answer = true;
//        List<String> phoneNumbers = Arrays.asList(phone_book.clone());
//        int length = phoneNumbers.size();
//
//        Comparator<String> c = new Comparator<String>() {
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        };
//
//        Collections.sort(phoneNumbers, c);
//
//        for (int i = 0; i < length - 1; i++) {
//            Map<String, Integer> numberCheck = new HashMap<>();
//            numberCheck.put(phoneNumbers.get(i), 1);
//            int splitPoint = phoneNumbers.get(i).length();
//            for (int j = length - 1; j > i; j--) {
//                if (phoneNumbers.get(j).length() <= splitPoint) {
//                    break;
//                } else {
//                    String target = phoneNumbers.get(j).substring(0, splitPoint);
//                    numberCheck.put(target, numberCheck.getOrDefault(target, 0) + 1);
//                    if (numberCheck.getOrDefault(phoneNumbers.get(i), 1) > 1) {
//                        answer = false;
//                        break;
//                    }
//                }
//            }
//            if (answer == false) {
//                break;
//            }
//        }
//
//        return answer;
//    }




//    효율성 3번 실패
//    public boolean solution(String[] phone_book) {
//        boolean answer = true;
//        List<String> phoneNumbers = Arrays.asList(phone_book.clone());
//        int length = phoneNumbers.size();
//
//        Comparator<String> c = new Comparator<String>() {
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        };
//
//        Collections.sort(phoneNumbers, c);
//
//        for (int i = 0; i < length - 1; i++) {
//            System.out.println(i);
//            Map<String, Integer> numberCheck = new HashMap<>();
//            int splitPoint = phoneNumbers.get(i).length();
//            for (int j = i; j < length; j++) {
//                String target = phoneNumbers.get(j).substring(0, splitPoint);
//                numberCheck.put(target, numberCheck.getOrDefault(target, 0) + 1);
//            }
//            for (int j = i; j < length; j++) {
//                if (phoneNumbers.get(j).length() > splitPoint) {
//                    i = j + 1;
//                    break;
//                } else {
//                    if (numberCheck.get(phoneNumbers.get(j)) > 1) {
//                        answer = false;
//                        break;
//                    }
//                }
//            }
//            if (answer == false) {
//                break;
//            }
//        }
//
//        return answer;
//    }

    //Success
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> phoneNumbers = Arrays.asList(phone_book.clone());
        int length = phoneNumbers.size();

        Map<String, Integer> numberCheck = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String target = phoneNumbers.get(i);
            for (int j = 1; j <= target.length(); j++) {
                numberCheck.put(target.substring(0, j), numberCheck.getOrDefault(target.substring(0, j), 0) + 1);
            }
        }

        System.out.println(numberCheck);
        for (String number : phoneNumbers) {
            if (numberCheck.getOrDefault(number, 0) > 1) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    //Test
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123", "456", "789"};
        String[] phone_book3 = {"12", "123", "1235", "567", "88"};
        solution.solution(phone_book1);
    }
}