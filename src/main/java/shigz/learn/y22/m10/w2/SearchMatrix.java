package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/8
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int leftMin = 0;
        int rightMin = m - 1;
        while (leftMin < rightMin) {
            int mid = leftMin + (rightMin - leftMin) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                rightMin = mid - 1;
            } else {
                leftMin = mid + 1;
            }
        }
        int leftMax = 0;
        int rightMax = m - 1;
        while (leftMax < rightMax) {
            int mid = leftMax + (rightMax - leftMax) / 2;
            if (matrix[mid][n - 1] == target) {
                return true;
            } else if (matrix[mid][n - 1] > target) {
                rightMax = mid;
            } else {
                leftMax = mid + 1;
            }
        }
        for (int i = leftMax; i <= leftMin; i++) {
            if (searchArr(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean searchArr(int[] numArr, int target) {
        int left = 0;
        int right = numArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numArr[mid] == target) {
                return true;
            } else if (numArr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
