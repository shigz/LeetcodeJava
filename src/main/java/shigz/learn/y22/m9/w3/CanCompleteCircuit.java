package shigz.learn.y22.m9.w3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/9/20
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        int index = 0;
        while (index < gas.length) {
            spare += gas[index] - cost[index];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = index;
            }
            index++;
        }
        return spare < 0 ? -1 : (minIndex + 1) % gas.length;
    }

    public int secondTry(int[] gas, int[] cost) {
        if (gas.length == 1) return gas[0] >= cost[0] ? 0 : -1;
        List<Integer> sumList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();
        boolean isMore = gas[0] > cost[0];
        boolean firstIsMore = isMore;
        int firstSum = 0;
        boolean isChangedFlag = false;
        int sum = gas[0] - cost[0];
        int startIndex = 0;
        int index = 1;
        while (index < gas.length) {
            if (gas[index] > cost[index] ^ isMore) {
                if (isChangedFlag) {
                    sumList.add(sum);
                    indexList.add(startIndex);
                } else {
                    firstSum = sum;
                    isChangedFlag = true;
                }
                startIndex = index;
                sum = gas[index] - cost[index];
                isMore = !isMore;
            } else {
                sum += gas[index] - cost[index];
            }
            index += 1;
        }
        if (isMore == firstIsMore) {
            sumList.add(sum + firstSum);
            indexList.add(startIndex);
        } else {
            sumList.add(sum);
            indexList.add(startIndex);
            sumList.add(firstSum);
            indexList.add(0);
        }

        for (int i = 0; i < sumList.size(); i++) {
            if (canCompleteCircuitFrom(sumList, i)) return indexList.get(i);
        }

        return -1;
    }

    private Boolean canCompleteCircuitFrom(List<Integer> sumList, int index) {
        int currentMinus = sumList.get(index);
        if (currentMinus < 0) return false;
        int currentIndex = (index + 1) % sumList.size();
        while (currentIndex != index) {
            if (currentMinus + sumList.get(currentIndex) < 0) return false;
            currentMinus += sumList.get(currentIndex);
            currentIndex = (currentIndex + 1) % sumList.size();
        }
        return true;
    }

    public int firstTry(int[] gas, int[] cost) {
        if (gas.length == 1) return gas[0] >= cost[0] ? 0 : -1;
        int index = 0;
        while (index < gas.length) {
            if (canCompleteCircuitFrom(gas, cost, index)) return index;
            index++;
        }
        return -1;
    }

    private Boolean canCompleteCircuitFrom(int[] gas, int[] cost, int index) {
        if (gas[index] < cost[index]) return false;
        int currentOil = gas[index] - cost[index];
        int currentIndex = (index + 1) % gas.length;
        while (currentIndex != index) {
            if (currentOil + gas[currentIndex] < cost[currentIndex]) return false;
            currentOil = currentOil + gas[currentIndex] - cost[currentIndex];
            currentIndex = (currentIndex + 1) % gas.length;
        }
        return true;
    }

}
