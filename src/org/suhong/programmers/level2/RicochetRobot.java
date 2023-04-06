package org.suhong.programmers.level2;

public class RicochetRobot {
    /* 알고리즘 컨셉:'G' 에서부터 역추적하면 -1 인 경우를 더 빨리 찾을 수 있을 거 같아서 역추적하기로 함
     * 1. 로봇이 "G"에서부터 출발해서 "R"로 이동한다고 생각.
     * 2. 단, 주변에 장애물 혹은 벽이 있을 때 장애물 혹은 병이 있는 방향의 반대 방향으로만 움직인다.(로봇이 그 곳에 도착하는 방법이 그것 뿐임)
     * (3). 주변에 벽 혹은 장애물이 아예 없으면 도달하는 것이 불가능.
     */
    public int solution(String[] board) {
        int xLength = board[0].length();
        int yLength = board.length;

        Position goal = null;
        Position start = null;

        for (int i = 0; i < yLength; ++i) {
            String row = board[i];
            for (int j = 0; j < xLength; ++j) {
                switch (row.charAt(j)) {
                    case 'G':
                        goal = new Position(i,j);
                        break;
                    case 'R':
                        start = new Position(i,j);
                        break;
                }
            }
        }
        boolean[] visited;

        return -1;
    }

}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


