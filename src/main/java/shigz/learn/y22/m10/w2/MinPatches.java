package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/13
 */
public class MinPatches {

    public int minPatches(int[] nums, int n) {
        int result = 0;
        int num = 1;
        int numIndex = 0;
        if (nums[0] == 1) {
            numIndex = 1;
        } else {
            result++;
        }
        while (num > 0 && num < n) {
            if (numIndex < nums.length) {
                if (num + 1 >= nums[numIndex]) {
                    num += nums[numIndex];
                    numIndex++;
                } else {
                    result++;
                    num += num + 1;
                }
            } else {
                result++;
                num += num + 1;
            }
        }
        return result;
    }

    boolean[] realArr;

    //超出内存限制
    public int firstTry(int[] nums, int n) {
        realArr = new boolean[n];
        int max = 0;
        for (int num : nums) {
            max += num;
            realArr[num - 1] = true;
            for (int i = max - 1; i >= num; i--) {
                if (realArr[i - num]) realArr[i] = true;
            }
        }
        int result = 0;
        int minFalseIndex = minFalseIndexFrom(0);
        while (minFalseIndex != -1) {
            result++;
            for (int i = n - 1; i > minFalseIndex; i--) {
                if (realArr[i - minFalseIndex - 1]) realArr[i] = true;
            }
            realArr[minFalseIndex] = true;
            minFalseIndex = minFalseIndexFrom(minFalseIndex);
        }
        return result;
    }

    private int minFalseIndexFrom(int startIndex) {
        while (startIndex < realArr.length) {
            if (!realArr[startIndex]) return startIndex;
            startIndex++;
        }
        return -1;
    }
}
