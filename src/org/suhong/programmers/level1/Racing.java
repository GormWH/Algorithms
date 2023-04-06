package org.suhong.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Racing {

    public static void main(String[] args) {
        Racing s = new Racing();
        String[] players1 = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] callings1 = new String[]{"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(s.solution(players1,callings1))); // ["mumu", "kai", "mine", "soe", "poe"]
    }
    public String[] solution(String[] players, String[] callings) {
        RaceStatus raceStatus = new RaceStatus(players);
        for (String name: callings) {
            raceStatus.callPlayer(name);
        }
        return raceStatus.getStatus();
    }
}

class RaceStatus {

    private Map<String,Integer> nameRankMap = new HashMap<>();
    private Map<Integer,String> rankNameMap = new HashMap<>();
    private int length;

    public RaceStatus(String[] players) {
        length = players.length;
        for (int i = 0; i < players.length; ++i) {
            nameRankMap.put(players[i], i);
            rankNameMap.put(i,players[i]);
        }
    }

    public void callPlayer(String name) {
        int rank = nameRankMap.get(name);
        String otherName = rankNameMap.get(rank-1);

        nameRankMap.put(name,rank-1);
        nameRankMap.put(otherName,rank);
        rankNameMap.put(rank-1,name);
        rankNameMap.put(rank,otherName);
    }

    public String[] getStatus() {
        String[] result = new String[length];
        for (int i = 0; i < length; ++i) {
            result[i] = rankNameMap.get(i);
        }
        return result;
    }
}