package org.suhong.programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Parking {
    public static void main(String[] args) {
        Parking s = new Parking();
        int[] fees1 = new int[]{180, 5000, 10, 600};
        String[] records1 = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(s.solution(fees1,records1))); // 14600, 34400, 5000

    }
    public int[] solution(int[] fees, String[] records) {
        ParkingMachine machine = new ParkingMachine(fees);
        for (String record: records) {
            machine.inputRecord(record);
        }
        return machine.getAnswer();
    }
}

class ParkingMachine {

    private final Map<String,Integer> enter;
    private final Map<String,Integer> stay;


    private final int minTime;
    private final int minPrice;
    private final int unitTime;
    private final int unitPrice;

    public ParkingMachine(int[] fees) {
        enter = new HashMap<>();
        stay = new TreeMap<>();
        minTime = fees[0];
        minPrice = fees[1];
        unitTime = fees[2];
        unitPrice = fees[3];
    }

    public void inputRecord(String record) {
        String[] separated = record.split(" ");
        int time = strTimeToInt(separated[0]);
        String car = separated[1];
        if (separated[2].equals("IN")) { // 입차
            enter.put(car, time);
        } else { // 출차: separated[2].equals("OUT")
            stay.put(car,stay.getOrDefault(car,0) + time - enter.get(car));
            enter.remove(car);
        }
    }

    private int strTimeToInt(String time) {
        String[] separated = time.split(":");
        return Integer.parseInt(separated[0]) * 60 + Integer.parseInt(separated[1]);
    }

    private int calculateFee(int stay) {
        if (stay <= minTime) {
            // System.out.println("min: enter = " + enter + ", leave = " + leave + ", fee = " + minPrice);
            return minPrice;
        }
        else {
            int exceed = stay - minTime;
            // System.out.println("not min: enter = " + enter + ", leave = " + leave + ", fee = " + (minPrice + (exceed / unitTime + (exceed % unitTime == 0 ? 0 : 1)) * unitPrice));
            return minPrice + (exceed / unitTime + (exceed % unitTime == 0 ? 0 : 1)) * unitPrice;
        }
    }

    public int[] getAnswer() {
        if (!enter.isEmpty()) { // 출차 체크되지 않는 차량이 있을 경우
            for (String car: enter.keySet()) {
                stay.put(car,stay.getOrDefault(car,0) + 1439 - enter.get(car));; // 23:59에 출차한 것으로 처리
            }
        }
        enter.clear();

        int length = stay.size();
        int[] answer = new int[length];
        int i = 0;
        for (int stay: stay.values()) {
            answer[i++] = calculateFee(stay);
        }
        return answer;
    }
}
