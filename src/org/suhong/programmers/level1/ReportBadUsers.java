package org.suhong.programmers.level1;

import java.util.Arrays;

public class ReportBadUsers {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] numberOfReports = new int[id_list.length];
        for (int i = 0; i < report.length; i++) {
            String reportedUser = report[i].split(" ")[1];
            for (int j = 0; j < id_list.length; j++) {
                numberOfReports[j]++;
            }
        }
        return answer;
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
