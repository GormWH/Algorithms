package org.suhong.leetcode.studyplan.binarysearch;

public class GuessNumber {
  public int guessNumber(int n) {
    return binarySearch(1, n);
  }

  private int binarySearch(int start, int end) {
    if (end - start < 1) return start;
    int mid = start + (end - start) / 2;
    if (guess(mid) < 0) {
      return binarySearch(start, mid - 1);
    }
    if (guess(mid) > 0) {
      return binarySearch(mid + 1, end);
    }
    return mid;
  }


  private int guess(int num) {
    int pick = 37;
    return Integer.compare(pick, num);
  }

  public static void main(String[] args) {
    GuessNumber s = new GuessNumber();
    System.out.println(s.guessNumber(100));

  }
}
