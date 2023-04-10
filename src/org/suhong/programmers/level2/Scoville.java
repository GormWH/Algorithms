package org.suhong.programmers.level2;

import java.util.*;

public class Scoville {
    public static void main(String[] args) {
        Scoville s = new Scoville();

        int[] scoville1 = new int[]{1, 2, 3, 9, 10, 12};
        int k1 = 7;

        int[] scoville2 = new int[]{8,8};
        int k2 = 50;

        System.out.println(s.solution(scoville1,k1)); // 2
        System.out.println(s.solution(scoville2,k2)); // -1

    }

    public int solution(int[] scoville, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        boolean pass = false;
        for (int food: scoville) {
            if (food < k) {
                queue.add(food);
            } else {
                pass = true;
            }
        }

        int count = 0;
        System.out.println(queue);
        while (queue.size() > 1) {
            ++count;
            int first = queue.poll();
            int second = queue.poll();
            int mixture = first + second * 2;
            if (mixture < k) {
                queue.add(mixture);
            } else {
                pass = true;
            }
            System.out.println(queue);
        }

        if (!pass) return -1;
        return queue.size() == 0 ? count : count + 1;
    }

}
