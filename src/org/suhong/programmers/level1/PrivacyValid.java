package org.suhong.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrivacyValid {

    public static void main(String[] args) {
        PrivacyValid s = new PrivacyValid();
        System.out.println(Arrays.toString(s.solution("2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 약관 종류 Map 으로 정리
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term: terms) {
            String[] splitted = term.split(" ");
            termsMap.put(splitted[0], Integer.parseInt(splitted[1]));
        }

        // 개인정보를 하나하나 읽으며 유효기간이 지났을 경우 answer에 그 번호를 담는다
        int[] answer = new int[privacies.length];
        int size = 0;
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String validDate = addMonth(privacy[0], termsMap.get(privacy[1]));
            if (today.compareTo(validDate) > 0) {
                answer[size++] = i + 1;
            }
        }
        return Arrays.copyOfRange(answer, 0, size);
    }

    private String addMonth(String date, int month) {
        int[] dates = Arrays.stream(date.split("\\.")).
                mapToInt(Integer::parseInt).toArray(); // dates: [year, month, day]
        dates[1] += month;
        if (dates[1] > 12) {
            dates[1] -= 12;
            dates[0] += 1;
        }
        dates[2]--;
        if (dates[2] == 0) {
            dates[2] = 28;
            dates[1]--;
            if (dates[1] == 0) {
                dates[1] = 12;
                dates[0]--;
            }
        }
        return String.format("%4d.%02d.%02d", dates[0],dates[1],dates[2]);
    }
}
