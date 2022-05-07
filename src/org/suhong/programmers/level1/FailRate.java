package org.suhong.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays; // 코드 제출할 땐 불필요
import java.util.List;

public class FailRate {
  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];

    List<Stage> stageObjs = new ArrayList<>();
    for (int i = 0; i < N;  i++) {
      stageObjs.add(new Stage(i + 1));
    }

    int[] challengers = new int[N+1];

    for (int stage : stages) {
      challengers[stage - 1]++;
    }

    int clearedNum = challengers[N]; // num of perfect players
    for (int i = N - 1; i >= 0; i--) {
      int challenging = challengers[i];
      stageObjs.get(i).failRate = (double) challenging / (clearedNum + challenging);
      clearedNum += challenging;
    }

    stageObjs.sort((a, b) -> {
      if(a.failRate < b.failRate) return +1;
      if(a.failRate > b.failRate) return -1;
      return a.stageNum - b.stageNum;
    });

    for (int i = 0; i < N; i++) {
      answer[i] = stageObjs.get(i).stageNum;
    }

    return answer;
  }

  public static void main(String[] args) {
    int N1 = 5;
    int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
    int N2 = 4;
    int[] stages2 = {4,4,4,4,4};

    FailRate s = new FailRate();
    System.out.println(Arrays.toString(s.solution(N1, stages1)));
    System.out.println(Arrays.toString(s.solution(N2, stages2)));
  }
}

class Stage {
  double failRate;
  int stageNum;

  public Stage(int stageNum) {
    this.stageNum = stageNum;
  }

}