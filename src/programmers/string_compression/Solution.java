package programmers.string_compression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2020 KAKAO BLIND RECRUITMENT
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057
 */

class Solution {
    public int solution(String s) {
        List<String[]> cutList = new ArrayList<>();
        ArrayList<Integer> cutSizes = new ArrayList<>();
        cutSizes.add(s.length());

        for (int i = 1; i <= s.length()/2; i++) {
            String forSplit = "";
            for (int j = 0; j < s.length(); j++) {
                if((j % i) == 0 && j != 0){
                    forSplit += "/";
                }
                forSplit += s.charAt(j);
            }
            //System.out.println(forSplit);
            cutList.add(forSplit.split("/"));
        }

        for (int i = 0; i < cutList.size(); i++) {
            int cutCount = 1;
            int cutSize = 0;
            String compression = "";
            String prevCut = "";
            String[] sar = cutList.get(i);
            for (int j = 0; j < sar.length; j++) {
                if (prevCut.equals(sar[j])){
                    cutCount++;
                }else{
                    if (cutCount < 2)
                        compression += prevCut;
                    else
                        compression += cutCount + prevCut;
                    prevCut = sar[j];
                    cutCount = 1;
                }
                if(j == sar.length - 1){
                    if (cutCount < 2)
                        compression += prevCut;
                    else
                        compression += cutCount + prevCut;
                }
            }
            cutSize = compression.length();
            cutSizes.add(cutSize);
        }

        Collections.sort(cutSizes);
        // for(int size : cutSizes){
        //     System.out.println(size);
        // }

        return cutSizes.get(0);
    }
}