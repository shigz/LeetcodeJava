package shigz.learn.y22.m10.w2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 大史 on 2022/10/13
 */
public class MaxChunksToSorted {

    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        int index = 0;
        while (index < arr.length) {
            result++;
            if (index == arr[index]) {
                index++;
            } else {
                index = indexAfterJump(arr, index, arr[index]);
            }
        }
        return result;
    }

    private int indexAfterJump(int[] arr, int start, int end) {
        int result = start + 1;
        while (result <= end) {
            if (arr[result] <= result){
                result++;
            } else {
                result = indexAfterJump(arr,result,arr[result]);
            }
        }
        return result;
    }


    //借助额外内存,空间复杂度高
    public int firstTry(int[] arr) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int index = 0; index < arr.length; index++) {
            if (numSet.contains(index)) {
                numSet.remove(index);
            } else numSet.add(index);
            if (numSet.contains(arr[index])) {
                numSet.remove(arr[index]);
            } else numSet.add(arr[index]);
            if (0 == numSet.size()) result++;
        }
        return result;
    }
}
