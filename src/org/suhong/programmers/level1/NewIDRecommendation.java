package org.suhong.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class NewIDRecommendation {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();

        // step1: toLowerCase
        answer = answer.toLowerCase();
//        System.out.println(answer);

        // step2: only alphabet, number, '-', '_', '.' allowed
        StringBuilder builder = new StringBuilder();
        for (char chr : answer.toCharArray()) {
            if (Character.isDigit(chr)
                    || Character.isLetter(chr)
                    || chr == '.' || chr == '_' || chr == '-')
            {
                builder.append(chr);
            }
        }
        answer = builder.toString();
        builder.delete(0, builder.length());
//        System.out.println(answer);

        // step3: remove consecutive '.'s to single '.'
        int count = 0;
        for (char chr : answer.toCharArray()) {
            if (chr == '.') {
                count++;
                continue;
            } else if (count != 0) {
                builder.append('.');
                count = 0;
            }
            builder.append(chr);
        }
        answer = builder.toString();
//        System.out.println(answer);

        // step4: remove leading or trailing '.'
        if (answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if (answer.length() > 0 && answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0, answer.length()-1);
        }
//        System.out.println(answer);

        // step5: if answer is empty, fill with "aaa"
        if (answer.length() == 0) {
            answer = "aaa";
        }
//        System.out.println(answer);

        // step6: if answer is longer than 15, remove characters exceeding 15.
        if (answer.length() > 15) {
            answer = answer.substring(0,15);
            // step4: remove leading or trailing '.'
            if (answer.charAt(0) == '.') {
                answer = answer.substring(1);
            }
            if (answer.charAt(answer.length()-1) == '.') {
                answer = answer.substring(0, answer.length()-1);
            }
        }
//        System.out.println(answer);

        // step7: if answer is shorter than 3, duplicate the last character of answer until answer's length is 3.
        if (answer.length() < 3) {
            char lastChar = answer.charAt(answer.length() - 1);
            while (answer.length() != 3) {
                answer = answer + lastChar;
            }
        }
//        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "...!@BaT#*..y.abcdefghijklm",
                "z-+.^.",
                "=.=",
                "123_.def",
                "abcdefghijklmn.p"
        };
        String[] answers = {
                "bat.y.abcdefghi",
                "z--",
                "aaa",
                "123_.def",
                "abcdefghijklmn"
        };

        NewIDRecommendation s = new NewIDRecommendation();

        for (int i = 0; i < inputs.length; i++) {
            System.out.printf("Test%d: %s -> Expects: %s ==> Result: %s\n", i, inputs[i], answers[i], s.solution(inputs[i]));
        }

    }
}
