package org.suhong.programmers.level1;

public class OriginalNumber {
  public int solution(String s) {

    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      switch (currentChar) {
        case 'z': // zero
          stringBuilder.append(0);
          i += 3;
          break;
        case 'o': // one
          stringBuilder.append(1);
          i += 2;
          break;
        case 't': // two, three
          if (s.charAt(i+1) == 'w') {
            stringBuilder.append(2);
            i += 2;
          } else {
            stringBuilder.append(3);
            i += 4;
          }
          break;
        case 'f': // four, five
          if (s.charAt(i+1) == 'o') {
            stringBuilder.append(4);
          } else {
            stringBuilder.append(5);
          }
          i += 3;
          break;
        case 's': // six, seven
          if (s.charAt(i+1) == 'i') {
            stringBuilder.append(6);
            i += 2;
          } else {
            stringBuilder.append(7);
            i += 4;
          }
          break;
        case 'e': // eight
          stringBuilder.append(8);
          i += 4;
          break;
        case 'n': // nine
          stringBuilder.append(9);
          i += 3;
        default: // digit
          stringBuilder.append(currentChar);
          break;
      }
    }

    return Integer.parseInt(stringBuilder.toString());
  }

  public static void main(String[] args) {
    OriginalNumber s = new OriginalNumber();

    String str1 = "one4seveneight";
    String str2 = "23four5six7";
    String str3 = "2three45sixseven";
    String str4 = "123";


    System.out.println(s.solution(str1));
    System.out.println(s.solution(str2));
    System.out.println(s.solution(str3));
    System.out.println(s.solution(str4));
  }
}
