package org.suhong.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class ClawMachine {

  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    return answer;
  }

  public static void main(String[] args) {

    ClawMachine s = new ClawMachine();

    int[][] board = {
            {0,0,0,0,0},
            {0,0,1,0,3},
            {0,2,5,0,1},
            {4,2,4,4,2},
            {3,5,1,3,1}
    };
    int[] moves = {1,5,3,5,1,2,1,4};

    int pointer = 0;
    List<Integer> stack = new ArrayList<>();

    System.out.println(s.solution(board, moves));

  }

}
