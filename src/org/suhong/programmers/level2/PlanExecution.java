package org.suhong.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PlanExecution {

    public static void main(String[] args) {
        PlanExecution s = new PlanExecution();

        String[][] input1 = new String[][] {
                {"korean", "11:40", "30"},
                {"english", "12:10", "20"},
                {"math", "12:30", "40"}
        };

        System.out.println(Arrays.toString(s.solution(input1)));
    }
    public String[] solution(String[][] input) {
        int length = input.length;
        Plan[] plans = new Plan[input.length];
        for (int i = 0; i < input.length; ++i) {
            plans[i] = new Plan(input[i]);
        }
        Arrays.sort(plans);

        WorkStack stack = new WorkStack();
        for (Plan plan: plans) {
            stack.newPlan(plan);
        }
        stack.finishAll();

        return stack.getFinishOrder();
    }
}

class Plan implements Comparable<Plan>{
    String name;
    int start;
    int playtime;

    public Plan(String[] plan) {
        this.name = plan[0];
        String[] start = plan[1].split(":");
        this.start =
                Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        this.playtime = Integer.parseInt(plan[2]);
    }

    @Override
    public int compareTo(Plan plan){
        return this.start - plan.start;
    }

    @Override
    public String toString() {
        return String.format("{name:%s, start:%d:%d, playtime:%d}",name,start/60,start%60,playtime);
    }
}

class WorkStack {
    private Stack<Plan> stack;
    private int time;
    private List<String> finish;

    public WorkStack() {
        stack = new Stack<>();
        time = 0;
        finish = new ArrayList<>();
    }

    public void newPlan(Plan plan) {
        if (stack.isEmpty()) {
            time = plan.start;
            stack.push(plan);
        } else {
            int spareTime = plan.start - time;
            useSpareTime(spareTime);
            stack.add(plan);
            time = plan.start;
        }
    }

    private void useSpareTime(int spareTime) {
        while (!stack.isEmpty() && spareTime > 0) {
            Plan plan = stack.peek();
            if (plan.playtime > spareTime) {
                plan.playtime = plan.playtime - spareTime;
                break;
            } else {
                spareTime -= plan.playtime;
                finish.add(plan.name);
                stack.pop();
            }
        }
    }

    public void finishAll() {
        while (!stack.isEmpty()) {
            finish.add(stack.pop().name);
        }
    }

    public String[] getFinishOrder() {
        String[] result = new String[finish.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = finish.get(i);
        }
        return result;
    }
}