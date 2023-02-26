package org.suhong.programmers.level0;

import java.util.HashMap;
import java.util.Map;

public class Babbling {
    private final Map<Character,String> pronounceable = new HashMap<>();

    public Babbling() {
        pronounceable.put('a', "aya");
        pronounceable.put('y', "ye");
        pronounceable.put('w', "woo");
        pronounceable.put('m', "ma");
    }

    public int solution(String[] babbling) {
        int answer = 0;
        for (String str : babbling) {
            if (isPronounceable(str)) {
                answer++;
                System.out.println(str + " success!");
            }
        }
        return answer;
    }

    private boolean isPronounceable(String str) {
//        System.out.println("current str = " + str);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String target = pronounceable.get(c);
//            if (target == null) {
//                System.out.println("target is null");
//            } else if (i + target.length() > str.length()) {
//                System.out.println("substring out of bound");
//            } else if (!str.startsWith(target, i)) {
//                System.out.println("substring no match");
//            }
            if (target == null ||
                    i + target.length() > str.length() ||
                    !str.startsWith(target, i))
            {
                return false;
            }
            i += target.length() - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Babbling babbling = new Babbling();
        System.out.println(babbling.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));
    }
}
