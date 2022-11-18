package shigz.learn.y22.m10.w3;

import shigz.common.BaseObject;

/**
 * Created by 大史 on 2022/10/20
 */
public class KThGrammar extends BaseObject {

    public static int kthGrammar(int n, int k) {
        k -= 1;
        if (k == 0 || k == 3) return 0;
        if (k == 1 || k == 2) return 1;
        int max = 1;
        while (max < k) {
            max <<= 1;
        }
        max >>= 1;
        while (k > 1) {
            int halfMax = max / 2;
            if (k - halfMax - max >= 0) {
                k = k - halfMax - max;
            } else if (k > max) {
                k = k - halfMax;
            }
            max = halfMax;
        }
        return k;
    }

    public static void main(String[] args) {
        infoLog(kthGrammar(10, 434991989));
    }

}
