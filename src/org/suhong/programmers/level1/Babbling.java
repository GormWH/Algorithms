package org.suhong.programmers.level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Babbling {
    public final static Map<Character, String> babbleMap;
    static {
        babbleMap = new HashMap<>();
        babbleMap.put('a', "aya");
        babbleMap.put('y', "ye");
        babbleMap.put('w', "woo");
        babbleMap.put('m', "ma");
    }

    public static void main(String[] args) {
        Babbling s = new Babbling();
        System.out.println(s.solution(new String[]{"aya", "yee", "u", "maa"}));
        //System.out.println(s.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
    public int solution(String[] babbling) {
        int answer = 0;
        for (String babble: babbling) {
            if (canSay(babble)) {
                answer++;
                //System.out.println(babble);
            }
        }
        return answer;
    }

    private boolean canSay(String babble) {
        Stack<String> lastWord = new Stack<>();
        for (int i = 0; i < babble.length(); i++) {
            char c = babble.charAt(i); // 시작 문자 확인
            String target = babbleMap.get(c); // c = 'a','y',w','m' 일 경우에만 null이 아님
            System.out.println(target);
            if (target == null ||
                    i + target.length() > babble.length() ||
                    !babble.startsWith(target, i) ||
                    !(lastWord.isEmpty() || !lastWord.peek().equals(target))
            ) {
                if (target == null) System.out.println("target null");
                if (i + target.length() > babble.length()) System.out.println("out of bound");
                if (!babble.substring(i,i+target.length()).equals(target)) {
                    System.out.println("no match. target = " + target + ", substring = " + babble.substring(i,i+target.length()));
                }
                if (!(lastWord.isEmpty() || !lastWord.peek().equals(target))) System.out.println("same word");
                return false;
            } else {
                lastWord.push(target);
                i = i + target.length() - 1;
            }
        }

        return true;
    }
}
