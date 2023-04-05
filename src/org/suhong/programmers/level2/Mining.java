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
        int pickNum = picks[0] + picks[1] + picks[2];

        MineralHeap[] heaps = new MineralHeap[pickNum];
        for (int i = 0; i < pickNum; ++i) {
            heaps[i] = new MineralHeap(minerals,i*5);
        }
        Arrays.sort(heaps);

        int answer = 0;
        for (MineralHeap heap: heaps) {
            answer += miner.mineMineralHeap(heap);
        }
        return answer;
    }
}

class Miner {
    int diamond;
    int iron;
    int stone;

    public Miner(int[] picks) {
        diamond = picks[0];
        iron = picks[1];
        stone = picks[2];
    }

    public int mineMineralHeap(MineralHeap heap) {
        char pick = getPick();
        if (pick == 0) return 0;
        int result = 0;
        switch (pick) {
            case 's':
                result = heap.stone + heap.iron * 5 + heap.diamond * 25;
                break;
            case 'i':
                result += heap.stone + heap.iron + heap.diamond * 5;
                break;
            case 'd':
                result += heap.stone + heap.iron + heap.diamond;
        }
        return result;
    }

    private char getPick() {
        if (diamond != 0) {
            --diamond;
            return 'd';
        } else if (iron != 0) {
            --iron;
            return 'i';
        } else if (stone != 0) {
            --stone;
            return 's';
        } else {
            return 0;
        }
    }
}

class MineralHeap implements Comparable<MineralHeap>{
    int diamond;
    int iron;
    int stone;

    public MineralHeap(String[] minerals, int start) {
        diamond = 0;
        iron = 0;
        stone = 0;
        for (int i = start; i < start + 5 && i < minerals.length; ++i) {
            switch (minerals[i].charAt(0)) {
                case 'd':
                    ++diamond;
                    break;
                case 'i':
                    ++iron;
                    break;
                default:
                    ++stone;
                    break;
            }
        }
    }

    @Override
    public int compareTo(MineralHeap o) {
        if (this.diamond != o.diamond) return o.diamond - this.diamond;
        if (this.iron != o.iron) return o.iron - this.iron;
        return o.stone - this.stone;
    }
}