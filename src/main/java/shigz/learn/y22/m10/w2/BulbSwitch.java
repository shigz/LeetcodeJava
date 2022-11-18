package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/11
 */
public class BulbSwitch {

    //第 n 个灯泡在它的每个因数时改变状态
    //因数是成对出现的,除非 n 为完全平方数
    //而 n 个灯泡前有多少个完全平方数,则有多少个灯泡亮着
    //恰好为 n 开根号后取整的个数
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

}
