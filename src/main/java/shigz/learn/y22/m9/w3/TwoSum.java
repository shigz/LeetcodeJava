package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/23
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] resultArr = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                resultArr[0] = left + 1;
                resultArr[1] = right + 1;
                return resultArr;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return resultArr;
    }

}
