package org.suhong.programmers.level1;

import java.util.*;

public class ReportBadUsers {
    public int[] solution(String[] user_ids, String[] reports, int k) {
        Map<String, User> userMap = new HashMap<>();
        for (int i = 0; i < user_ids.length; i++) {
            String user_id = user_ids[i];
            userMap.put(user_id, new User(i, user_id));
        }

        for (int i = 0; i < reports.length; i++) {
            String[] report = reports[i].split(" ");

        }
    }

    public static void main(String[] args) {
        ReportBadUsers reportBadUsers = new ReportBadUsers();

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] reportList = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int limit = 2;

        int[] result = reportBadUsers.solution(idList, reportList, limit);
        System.out.println(Arrays.toString(result));
    }
}

class User {
    int index;
    String name;
    List<User> reportedUsers;
    int count;

    public User(int index, String name) {
        this.index = index;
        this.name = name;
        this.reportedUsers = new ArrayList<>();
        this.count = 0;
    }
}
