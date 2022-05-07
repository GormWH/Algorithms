package org.suhong.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class ClawMachine {

  public int solution(int[][] board, int[] moves) {
    int answer = 0;

    int n = board.length;
    int[] basket = new int[moves.length];
    int size = 0;

    for (int move : moves) {
      for (int i = 0; i < n; i++) {
        int currentItem = board[i][move - 1];
        if (currentItem != 0) {
          if (size == 0) {
            basket[size++] = currentItem;
          } else {
            int lastItem = basket[size - 1];
            if (lastItem != currentItem) {
              basket[size++] = currentItem;
            } else {
              basket[--size] = 0;
              answer += 2;
            }
          }
          board[i][move - 1] = 0;
          break;
        }
      }
    }

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

    System.out.println(s.solution(board, moves));

  }

}
