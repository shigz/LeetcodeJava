package shigz.learn.y22.m9.w4;

/**
 * Created by 大史 on 2022/9/29
 */
public class ComputeArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aArea = (ax2 - ax1) * (ay2 - ay1);
        int bArea = (bx2 - bx1) * (by2 - by1);
        int width = ax1 >= bx1 ? (ax1 < bx2 ? Math.min(ax2, bx2) - ax1 : 0) : (bx1 < ax2 ? Math.min(ax2, bx2) - bx1 : 0);
        int height = ay1 >= by1 ? (ay1 < by2 ? Math.min(ay2, by2) - ay1 : 0) : (by1 < ay2 ? Math.min(ay2, by2) - by1 : 0);
        return aArea + bArea - width * height;
    }

}
