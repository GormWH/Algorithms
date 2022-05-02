package org.suhong.programmers.level1;

import java.util.Arrays;

// 로또의 최고 순위와 최저 순위
// https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
public class LottoGuessRank {

  public int[] solution(int[] lottos, int[] win_nums) {
    int countZero = 0;
    int countCorrect = 0;
    for (int selected : lottos) {
      if (selected == 0) {
        countZero++;
      } else if (numExist(selected, win_nums)) {
        countCorrect++;
      }
    }

    int maxRank = Math.min(7 - countCorrect - countZero, 6);
    int minRank = Math.min(7 - countCorrect, 6);
    return new int[]{maxRank, minRank};
  }

  private boolean numExist(int target, int[] nums) {
    for (int num : nums) {
      if (target == num) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    LottoGuessRank s = new LottoGuessRank();
    int[] lottos1 = {44, 1, 0, 0, 31, 25};
    int[] lottos2 = {0, 0, 0, 0, 0, 0};
    int[] lottos3 = {45, 4, 35, 20, 3, 9};

    int[] win_nums1 = {31, 10, 45, 1, 6, 19};
    int[] win_nums2 = {38, 19, 20, 40, 15, 25};
    int[] win_nums3 = {20, 9, 3, 45, 4, 35};

    System.out.println(Arrays.toString(s.solution(lottos1, win_nums1)));
    System.out.println(Arrays.toString(s.solution(lottos2, win_nums2)));
    System.out.println(Arrays.toString(s.solution(lottos3, win_nums3)));



  }
}
