package org.suhong.programmers.level2;

import java.util.Arrays;

public class Mining {
    public static void main(String[] args) {
        Mining s = new Mining();

        int[] picks1 = new int[]{1, 3, 2};
        String[] minerals1 = new String[]{
                "diamond", "diamond", "diamond", "iron", "iron",
                "diamond", "iron", "stone"};
        int[] picks2 = new int[]{0, 1, 1};
        String[] minerals2 = new String[]{
                "diamond", "diamond", "diamond", "diamond", "diamond",
                "iron", "iron", "iron", "iron", "iron",
                "diamond"};

        System.out.println(s.solution(picks1,minerals1)); // 12
        System.out.println(s.solution(picks2,minerals2)); // 50
    }
    public int solution(int[] picks, String[] minerals) {
        Miner miner = new Miner(picks);
        Works[] workList = new Works[(minerals.length-1) / 5 + 1];
        for (int i = 0; i < workList.length; ++i) {
            workList[i] = new Works(minerals, i*5);
        }
        Arrays.sort(workList);
        int sum = 0;
        for (Works works: workList) {
            // System.out.println(Arrays.toString(works.minerals));
            sum += miner.mine(works);
        }
        return sum;
    }
}

class Miner {
    private int diamond;
    private int iron;
    private int stone;

    public Miner(int[] picks) {
        this.diamond = picks[0];
        this.iron = picks[1];
        this.stone = picks[2];
    }

    public int mine(Works works) {
        int pick = getPick();
        if (pick == 0) return 0; // 쓸 수 있는 곡굉이가 없어 ㅠㅠ

        int sum = 0;
        for (int i = 0; i < 5; ++i) {
            int mineral = works.minerals[i];
            if (mineral == 0) continue;
            if (mineral <= pick) sum += 1;
            else sum += mineral / pick;
        }
        return sum;
    }

    private int getPick() {
        if (diamond != 0)
        {
            --diamond;
            return 25;
        }
        else if (iron != 0)
        {
            --iron;
            return 5;
        }
        else if (stone != 0)
        {
            --stone;
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

class Works implements Comparable<Works> {
    int[] minerals;
    private int total = 0;
    private int max = 1;

    public Works(String[] minerals, int start) {
        this.minerals = new int[5];
        for (int i = start; i < start + 5 && i < minerals.length; ++i) {
            char mineral = minerals[i].charAt(0);
            if (mineral == 'd')
            {
                this.minerals[i%5] = 25;
                this.total += 25;
                if (max < 25) max = 25;
            }
            else if (mineral == 'i')
            {
                this.minerals[i%5] = 5;
                this.total += 5;
                if (max < 5) max = 5;
            }
            else // mineral == 's'
            {
                this.minerals[i%5] = 1;
                this.total += 1;
            }
        }
    }

    @Override
    public int compareTo(Works o) {
        return o.total - this.total;
    }
}
