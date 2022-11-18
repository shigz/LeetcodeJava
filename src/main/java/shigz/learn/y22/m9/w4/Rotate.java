package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/26
 */
public class Rotate {

    public void rotate(int[] nums, int k) {
        int realK = k % nums.length;
        int[] dealArr = new int[realK];
        for (int i = 0; i < realK; i++) {
            if (dealArr[i] == 0) {
                int index = i + realK;
                dealArr[i] = 1;
                int pre = nums[i];
                while (index != i) {
                    if (index < nums.length) {
                        if (index < k) dealArr[i] = 1;
                        int temp = nums[index];
                        nums[index] = pre;
                        pre = temp;
                        index += realK;
                    } else {
                        index = index % nums.length;
                    }
                }
                nums[i] = pre;
            }
        }
    }

}
