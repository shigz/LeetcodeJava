package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/20
 */
public class Candy {

    public int candy(int[] ratings) {
        return minCandyFrom(ratings, 0)[1];
    }

    private int[] minCandyFrom(int[] ratings, int index) {
        int[] result = new int[]{1, 1};
        int preCount = 1;
        int currentIndex = index + 1;
        while (currentIndex < ratings.length) {
            if (ratings[currentIndex] > ratings[currentIndex - 1]) {
                preCount = preCount + 1;
                result[1] += preCount;
            } else if (ratings[currentIndex] == ratings[currentIndex - 1]) {
                int[] rightMinCandy = minCandyFrom(ratings, currentIndex);
                result[1] += rightMinCandy[1];
                return result;
            } else {
                if (preCount == 1) {
                    result[1] += currentIndex - index + 1;
                    result[0] += 1;
                } else {
                    int[] rightMinCandy = minCandyFrom(ratings, currentIndex);
                    if (preCount > rightMinCandy[0]) {
                        result[1] += rightMinCandy[1];
                    } else {
                        result[1] += rightMinCandy[1] + (rightMinCandy[0] - preCount + 1);
                    }
                    return result;
                }
            }
            currentIndex++;
        }
        return result;
    }

}
