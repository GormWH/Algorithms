package org.suhong.programmers.level2;

import java.util.*;

public class IslandTravel {
    public static void main(String[] args) {
        String[] maps1 = new String[]{"X591X","X1X5X","X231X", "1XXX1"};
        String[] maps2 = new String[]{"XXX","XXX","XXX"};

        IslandTravel s = new IslandTravel();
        System.out.println(Arrays.toString(s.solution(maps1)));
        System.out.println(Arrays.toString(s.solution(maps2)));
    }
    public int[] solution(String[] maps) {
        IslandMap map = new IslandMap(maps);
        map.configureIslands();
        return map.getAnswer();
    }
}

class IslandMap {
    private Queue<Integer> stayQueue;
    private int[][] map;
    private int height;
    private int width;
    private boolean[][] visited;
    public IslandMap(String[] maps) {
        stayQueue = new PriorityQueue<>();
        height = maps.length;
        width = maps[0].length();
        map = new int[height][width];
        visited = new boolean[height][width];
        for (int i = 0; i < height; ++i) {
            String row = maps[i];
            for (int j = 0; j < width; ++j) {
                if (row.charAt(j) == 'X') continue;
                map[i][j] = row.charAt(j) - 48; // char -> int 변환
            }
        }
    }

    public void configureIslands() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (visited[i][j] || map[i][j] == 0) continue;
                stayQueue.add(getIslandStay(i,j));
            }
        }
    }

    private int getIslandStay(int i, int j) {
        int sum = map[i][j];
        visited[i][j] = true;
        List<Integer[]> search = generateFourDirections(new Integer[]{i,j});
        while (search.size() > 0) {
            List<Integer[]> nextSearch = new ArrayList<>();
            for (Integer[] point: search) {
                if (!visited[point[0]][point[1]] && map[point[0]][point[1]] != 0) {
                    nextSearch.addAll(generateFourDirections(point));
                    sum += map[point[0]][point[1]];
                    visited[point[0]][point[1]] = true;
                }
            }
            search = nextSearch;
        }
        return sum;
    }

    private List<Integer[]> generateFourDirections(Integer[] location) {
        List<Integer[]> result = new ArrayList<>();
        if (location[1] - 1 >= 0) result.add(new Integer[]{location[0],location[1]-1}); // left
        if (location[1] + 1 < width) result.add(new Integer[]{location[0],location[1]+1}); // right
        if (location[0] - 1 >= 0) result.add(new Integer[]{location[0]-1,location[1]}); // up
        if (location[0] + 1< height) result.add(new Integer[]{location[0]+1,location[1]}); // down
        return result;
    }


    public int[] getAnswer() {
        int[] answer = new int[stayQueue.size()];
        for (int i = 0; i < answer.length; ++i) {
            answer[i] = stayQueue.poll();
        }

        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
