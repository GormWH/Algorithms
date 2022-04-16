package org.suhong.programmers.level1;

import java.util.*;

public class ReportBadUsers {
    public int[] solution(String[] user_ids, String[] reports, int k) {
        Map<String, User> userMap = new HashMap<>();
        for (int i = 0; i < user_ids.length; i++) {
            String user_id = user_ids[i];
            userMap.put(user_id, new User(i, user_id));
        }

        for (String report : reports) {
            String[] currentReport = report.split(" ");
            User reporter = userMap.get(currentReport[0]);
            User badUser = userMap.get(currentReport[1]);
            reporter.addReportedUsers(badUser);
        }

        int[] result = new int[user_ids.length];
        for (User user : userMap.values()) {
            for (User badUser : user.reportedUsers) {
                if (badUser.count >= k) result[user.index]++;
            }
        }
        return result;
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
    Set<User> reportedUsers;
    int count;

    public User(int index, String name) {
        this.index = index;
        this.name = name;
        this.reportedUsers = new HashSet<>();
        this.count = 0;
    }

    public void addReportedUsers(User badUser) {
        if (reportedUsers.contains(badUser)) return;
        reportedUsers.add(badUser);
        badUser.count++;
    }
}
