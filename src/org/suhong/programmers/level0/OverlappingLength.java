package org.suhong.programmers.level0;

import java.util.Arrays;

public class OverlappingLength {

    public static void main(String[] args) {
        OverlappingLength s = new OverlappingLength();
        System.out.println(s.solution(new int[][]{{0, 1}, {2, 5}, {3, 9}}));

        int[][] board = new int[5][5];
        System.out.println(Arrays.toString(board[0]));
    }
    public int solution(int[][] lines) {
        // 세 선분을 선분이 아닌 점6개로 보기
        // 각각의 점들은 (위치, 선분 번호, 시작0or끝1)으로 표현함
        // ex1) 첫번째 선분 [1,5]의 끝 점은 (5,0,1)
        // ex2) 두번째 선분 [0,9]의 시작 점은 (0,1,0)
        int[][] points = new int[6][];
        for (int i = 0; i < 3; i ++) {
            points[i*2] = new int[]{lines[i][0], i, 0};
            points[i*2 + 1] = new int[]{lines[i][1], i, 1};
        }
        // 점 위치 순으로 정렬(오름차순)
        Arrays.sort(points, (int[] p1, int[] p2) -> p1[0] - p2[0]);

        // 현재 겹쳐있는 선분을 파악하기 위한 표식(?). 두개 이상 true면 겹쳐 있는 구간
        boolean[] lineFlags = new boolean[]{false, false, false};

        // 첫번째 점부터 차례로 훓으며 겹치는 영역의 길이를 계산
        int overlapStart = -1;
        boolean recording = false;
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            int[] p = points[i];
            System.out.println("Current point = (" + Arrays.toString(p) + ")");

            if (p[2] == 0) {
                lineFlags[p[1]] = true;
            } else {
                lineFlags[p[1]] = false;
            }

            int count = 0;
            for (boolean flag : lineFlags) {
                if (flag) count++;
            }
            if (count > 1 && !recording) { // 겹치는 구간 시작
                recording = true;
                overlapStart = p[0];
            } else if (count < 2 && recording) { // 겹치는 구간 종료
                recording = false;
                sum += p[0] - overlapStart;
            }
        }
        return sum;
    }
}
