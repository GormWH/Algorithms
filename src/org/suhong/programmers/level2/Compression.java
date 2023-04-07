package org.suhong.programmers.level2;

import java.util.*;

public class Compression {
    public static void main(String[] args) {
        Compression s = new Compression();
        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        System.out.println(Arrays.toString(s.solution(msg1))); // [11, 1, 27, 15]
        System.out.println(Arrays.toString(s.solution(msg2))); // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        System.out.println(Arrays.toString(s.solution(msg3))); // [1, 2, 27, 29, 28, 31, 30]
    }
    public int[] solution(String msg) {
        Compressor compressor = new Compressor();
        return compressor.compress(msg);
    }

}

class Compressor {
    private Map<String,Integer> map = new HashMap<>();
    private int index = 1;
    public Compressor() {
        for (char alphabet = 'A'; alphabet <= 'Z'; ++alphabet) {
            map.put(String.valueOf(alphabet),index++);
        }
    }

    public int[] compress(String msg) {
        List<Integer> list = new ArrayList<>();
        char[] arr = msg.toCharArray();
        for (int i = 0; i < arr.length;) {
            StringBuilder builder = new StringBuilder();
            int j = i;
            for (; j < arr.length; ++j) {
                builder.append(arr[j]);
                if (map.containsKey(builder.toString())) continue;
                map.put(builder.toString(),index++);
                builder.deleteCharAt(builder.length()-1);
                j--;
                break;
            }
            list.add(map.get(builder.toString()));
            System.out.println(list.get(list.size()-1));
            i = j+1;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; ++i) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}