package org.suhong.programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReportBadUsers {
    public int[] solution(String[] users, String[] reports, int k) {


        return answer;
    }

    public

    public static void main(String[] args) {
        ReportBadUsers reportBadUsers = new ReportBadUsers();

        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] reportList = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int limit = 2;

        int[] result = reportBadUsers.solution(idList, reportList, limit);
        System.out.println(Arrays.toString(result));
    }
}
