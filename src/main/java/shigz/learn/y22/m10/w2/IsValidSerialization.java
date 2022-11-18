package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/13
 */
public class IsValidSerialization {

    public boolean isValidSerialization(String preorder) {
        String[] nodeArr = preorder.split(",");
        return getEndIndexFrom(nodeArr, 0) == nodeArr.length - 1;
    }

    private int getEndIndexFrom(String[] nodeArr, int startIndex) {
        if (startIndex < nodeArr.length) {
            if (nodeArr[startIndex].equals("#")) {
                return startIndex;
            } else {
                int left = getEndIndexFrom(nodeArr, startIndex + 1);
                if (left != -1) {
                    return getEndIndexFrom(nodeArr, left + 1);
                }
            }
        }
        return -1;
    }

}
