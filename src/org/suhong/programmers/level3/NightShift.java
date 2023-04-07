package org.suhong.programmers.level3;

import java.util.Map;
import java.util.TreeMap;

public class NightShift {

    public static void main(String[] args) {
        NightShift s = new NightShift();

        int n1 = 4;
        int[] works1 = new int[]{4, 3, 3};
        int n2 = 1;
        int[] works2 = new int[]{2, 1, 2};
        int n3 = 3;
        int[] works3 = new int[]{1, 1};

        System.out.println(s.solution(n1,works1)); // 12
        System.out.println(s.solution(n2,works2)); // 6
        System.out.println(s.solution(n3,works3)); // 0
    }
    public long solution(int n, int[] works) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int work: works) {
            map.put(work,map.getOrDefault(work,0)+1);
        }

//        System.out.println(map.keySet());
//        System.out.println(map.values());
        while (n > 0) {
            Map.Entry<Integer,Integer> entry = map.lastEntry();
//            System.out.println(entry.toString());
            if (entry.getKey() == 0) return 0L;
            if (entry.getValue() == 1) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), entry.getValue()-1);
            }
            map.put(entry.getKey()-1,map.getOrDefault(entry.getKey()-1,0)+1);
            --n;
        }

        long answer = 0;
        for (int key: map.keySet()) {
            answer += (long)key * key * map.get(key);
        }
        return answer;
    }
}
