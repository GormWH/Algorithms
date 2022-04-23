package org.suhong.programmers.level1;

import java.util.*;

public class PickTwoAndAdd {
  public int[] solution(int[] numbers) {
    Set<Integer> answerSet = new HashSet<>();

    for (int i = 0; i < numbers.length; i++) {
      for(int j= i + 1; j< numbers.length; j++){
        answerSet.add(numbers[i] + numbers[j]);
      }
    }

    List<Integer> answerList = new ArrayList<>(answerSet);
    answerList.sort((a,b) -> a - b);
    int[] answer = new int[answerSet.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerList.get(i);
    }
    return answer;
  }

  public static void main(String[] args) {
    PickTwoAndAdd s = new PickTwoAndAdd();

    int[] nums1 = {2,1,3,4,1};
    int[] nums2 = {5,0,2,7};

    System.out.println(Arrays.toString(s.solution(nums1)));
    System.out.println(Arrays.toString(s.solution(nums2)));

  }
}
