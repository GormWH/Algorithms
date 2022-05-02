package org.suhong.programmers.level1;

import java.security.Key;

public class PressingKeyPad {

  public String solution(int[] numbers, String hand) {
    char handMark = hand.equals("right") ? 'R' : 'L';
    KeyPad left = KeyPad.STAR;
    KeyPad right = KeyPad.SHARP;


    StringBuilder stringBuilder = new StringBuilder();
    for (int num : numbers) {
      KeyPad target = getKeyPad(num);
      if (target == KeyPad.N1 || target == KeyPad.N4 || target == KeyPad.N7) {
        left = target;
        stringBuilder.append('L');
      } else if (target == KeyPad.N3 || target == KeyPad.N6 || target == KeyPad.N9) {
        right = target;
        stringBuilder.append('R');
      } else {
        int compare = KeyPad.compare(left, right, target);
        if (compare < 0) {
          left = target;
          stringBuilder.append('L');
        } else if(compare > 0) {
          right = target;
          stringBuilder.append('R');
        } else {
          switch (handMark) {
            case 'L':
              left = target;
              stringBuilder.append('L');
              break;
            case 'R':
              right = target;
              stringBuilder.append('R');
              break;
          }
        }
      }
    }

    return stringBuilder.toString();
  }

  private KeyPad getKeyPad(int num) {
    switch (num) {
      case 0:
        return KeyPad.N0;
      case 1:
        return KeyPad.N1;
      case 2:
        return KeyPad.N2;
      case 3:
        return KeyPad.N3;
      case 4:
        return KeyPad.N4;
      case 5:
        return KeyPad.N5;
      case 6:
        return KeyPad.N6;
      case 7:
        return KeyPad.N7;
      case 8:
        return KeyPad.N8;
      case 9:
        return KeyPad.N9;
      default:
        return KeyPad.STAR;
    }
  }

  public static void main(String[] args) {
    PressingKeyPad s = new PressingKeyPad();
    int[] nums1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    int[] nums2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    System.out.println(s.solution(nums1, "right"));
    System.out.println(s.solution(nums2, "left"));
    System.out.println(s.solution(nums3, "right"));
  }

}

enum KeyPad {
  N1(1, 1), N2(1, 2), N3(1,3),
  N4(2, 1), N5(2, 2), N6(2,3),
  N7(3,1), N8(3,2), N9(3, 3),
  STAR(4, 1), N0(4, 2), SHARP(4,3);

  private int row;
  private int col;

  KeyPad(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public static int compare(KeyPad left, KeyPad right, KeyPad target) {
    int leftDistance = left.getDistance(target);
    int rightDistance = right.getDistance(target);
    if (leftDistance < rightDistance) return -1;
    if (leftDistance > rightDistance) return +1;
    return 0;
  }

  private int getDistance(KeyPad target) {
    return Math.abs(target.row - row) + Math.abs(target.col - col);
  }
}
