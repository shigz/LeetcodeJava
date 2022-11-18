package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/17
 */
public class TotalFruit {

    public int totalFruit(int[] fruits) {
        int startIndex = -1;
        int secondIndex = -1;
        int num1 = -1;
        int num2 = -1;
        int index = 0;
        int result = 0;
        while (index < fruits.length) {
            if (num1 == -1) {
                num1 = fruits[index];
                startIndex = index;
                result = 1;
            } else {
                if (fruits[index] == num1) {
                    if (num2 != - 1) {
                        num1 ^= num2;
                        num2 ^= num1;
                        num1 ^= num2;
                        secondIndex = index;
                    }
                } else {
                    if (num2 == -1) {
                        num2 = fruits[index];
                        secondIndex = index;
                    } else {
                        if (num2 != fruits[index]) {
                            result = Math.max(result,index - startIndex);
                            startIndex = secondIndex;
                            secondIndex = index;
                            num1 = num2;
                            num2 = fruits[index];
                        }
                    }
                }
            }
            index++;
        }
        return Math.max(result,fruits.length - startIndex);
    }

}
