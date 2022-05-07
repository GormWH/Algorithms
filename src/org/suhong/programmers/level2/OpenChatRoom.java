package org.suhong.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenChatRoom {
    public String[] solution(String[] record) {
        // key : value 가 uid : name 인 해쉬맵 선언
        Map<String, String> userMap = new HashMap<>();
        int answerLength = 0;
        // 기록을 한번 읽으며 최종적인 닉네임 확인
        // answer의 배열 길이를 결정(Enter, Leave 횟수 만큼만 할당)
        for (String aRecord : record) {
            String[] actionIdName = aRecord.split("\\s+");
            switch (actionIdName[0]) {
                case "Enter":
                    userMap.put(actionIdName[1], actionIdName[2]); // 이미 존재하는 uid는 변경, 없는 uid는 새로운 유저를 생성하게 된다
                    answerLength++;
                    break;
                case "Leave":
                    answerLength++;
                    break;
                case "Change":
                    userMap.put(actionIdName[1], actionIdName[2]);
                    break;
            }
        }
        String[] answer = new String[answerLength];

        int answerWriter = 0;
        // 기록을 다시 한번 읽으며 최종 닉네임을 사용해 한글로 출력
        for (int i = 0; i < record.length; i++) {
            String[] actionIdName = record[i].split("\\s+");
            String action = actionIdName[0];
            String uid = actionIdName[1];
            switch (action) {
                case "Enter":
                    answer[answerWriter++] = String.format("%s님이 들어왔습니다.", userMap.get(uid));
                    break;
                case "Leave":
                    answer[answerWriter++] = String.format("%s님이 나갔습니다.", userMap.get(uid));
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        OpenChatRoom s = new OpenChatRoom();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(s.solution(record)));
    }
}
