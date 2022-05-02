package org.suhong.baekjoon;

import java.util.Scanner;

public class AlarmClock {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int hour = scanner.nextInt();
    int minute = scanner.nextInt();

    Clock clock = new Clock(hour, minute);
    clock.rewindMinutes();

    System.out.println(clock);
  }
}

class Clock {

  private int hour;
  private int minute;

  public Clock(int hour, int minute) {
    this.hour = hour;
    this.minute = minute;
  }

  // 0 ~ 60 만 대응 가능
  public void rewindMinutes() {
    minute -= 45;
    if (minute < 0) {
      minute += 60;
      hour--;
      if (hour < 0) {
        hour = 23;
      }
    }
  }

  public String toString() {
    return String.format("%d %d", hour, minute);
  }
}
