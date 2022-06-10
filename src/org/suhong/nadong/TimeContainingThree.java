package org.suhong.nadong;

public class TimeContainingThree {

    // 00시 00분 ~ N시 59분 중 3을 포함하는 시간이 몇개 있는지 출력!
    public int getTimesContainingThree(int N) {
//        int count = 0;
//        for (int hour = 0; hour <= N; hour++) {
//            if (containsThree(hour)) {
//                count += 3600; // 60분 * 60초
//                continue;
//            }
//            for (int min = 0; min < 60; min++) {
//                if (containsThree(min)) {
//                    count += 60; // 60초
//                    continue;
//                }
//                count += 15; // 0초 ~ 59초 중 3 포함 갯수
//            }
//        }
//        return count;

        int m = N + 1;
        if (N >= 23) m -= 3;
        else if (N >= 13) m -= 2;
        else if (N >= 3) m -= 1;

        return (N + 1) * 60 * 60 - m * 45 * 45;
    }

    private boolean containsThree(int num) {
        if (30 <= num && num < 40) return true;
        return num % 10 == 3;
    }

    public static void main(String[] args) {
        TimeContainingThree s = new TimeContainingThree();

        System.out.println(s.getTimesContainingThree(5)); // 11475
    }
}
