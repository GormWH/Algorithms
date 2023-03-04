package org.suhong.programmers.level1;

import java.util.Map;
import java.util.Stack;

public class Hamburger {

    public static void main(String[] args) {
        Hamburger s = new Hamburger();
        System.out.println(s.solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})); // 2
        System.out.println(s.solution(new int[]{1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1})); // 2
        System.out.println(s.solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2})); // 0
        // System.out.println(-1 % 3);
    }
    public int solution(int[] array) {
        int answer = 0;

        Stack<Integer> main = new Stack<>();
        Stack<Integer> assistant = new Stack<>();

        int ptr = 0;
        int burger = 0;
        while (ptr < array.length || !assistant.isEmpty()) {
            int current;
            if (!assistant.isEmpty()) {
                current = assistant.pop();
            } else {
                current = array[ptr++];
            }

            main.push(current);
            if (current == 1) {
                if (burger == 3) { // 햄버거 완성
                    answer++;
                    burger = 0;
                    main.pop();main.pop();main.pop();main.pop(); // 완성된 재료 빼고
                    for (int i = 0; i < 3; i++) {
                        if (main.isEmpty()) break;
                        assistant.push(main.pop());
                    }
                } else {
                    burger = 1;
                }
            } else {
                if (current == burger + 1) {
                    burger++;
                } else {
                    burger = 0;
                }
            }
        }
        return answer;
    }
}
