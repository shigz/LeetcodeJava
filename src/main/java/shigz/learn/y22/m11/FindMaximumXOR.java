package shigz.learn.y22.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 大史 on 2022/11/9
 */
public class FindMaximumXOR {

    //根据第一个 1 所在的位将数据进行分组,最高位的数字与非最高位数字分别异或求得最大值
    public int findMaximumXOR(int[] nums) {
        List<Integer> lowList = new ArrayList<>();
        List<Integer> highList = new ArrayList<>();

        int maxDigit = 1;
        for (int num:nums) {
            int digit = getDigit(num);
            if (digit < maxDigit) {
                lowList.add(num);
            } else if (digit == maxDigit) {
                highList.add(num);
            } else {
                maxDigit = digit;
                lowList.addAll(highList);
                highList.clear();
                highList.add(num);
            }
        }

        int result = 0;
        if (lowList.isEmpty()) {
            for (int i = 0;i < highList.size() - 1;i++) {
                for (int j = i + 1;j < highList.size();j++) {
                    result = Math.max(result,highList.get(i) ^ highList.get(j));
                }
            }
        } else {
            for (Integer high : highList) {
                for (Integer low : lowList) {
                    result = Math.max(result, high ^ low);
                }
            }
        }
        return result;
    }

    private int getDigit(int num) {
        int result = 0;
        while (num != 0) {
            result++;
            num >>= 1;
        }
        return result;
    }

    //超时了
    public int firstTry(int[] nums) {
        int result = 0;
        int currentMax = nums.length;
        //每一轮都是第一个元素与后续的所有元素进行异或
        //执行完成后第二个元素作为第一个元素
        while (currentMax > 0) {
            //取出当前的第一个元素
            int first = nums[0];
            //从第二个元素开始,逐个与第一个元素进行异或后存在前一个元素中
            for (int i = 1; i < currentMax; i++) {
                nums[i - 1] = first ^ nums[i];
                result = Math.max(nums[i - 1], result);
            }
            currentMax--;
        }
        return result;
    }

}
