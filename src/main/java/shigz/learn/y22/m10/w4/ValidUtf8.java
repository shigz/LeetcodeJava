package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/11/1
 */
public class ValidUtf8 {

    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index < data.length) {
            int oneCount = countOne(data[index]);
            if (oneCount == 0) {
                //若左起没有 1,当前为单字节数据
                index++;
            } else if (oneCount == 1 || oneCount > 4){
                return false;
            } else {
                //共 oneCount 个字节,判断除当前字节外的 oneCount - 1 个字节是否左起只有 1 个 1
                for (int i = index + 1;i < index + oneCount;i++) {
                    if (i >= data.length || countOne(data[i]) != 1) return false;
                }
                index += oneCount;
            }
        }
        return true;
    }

    //统计首位 1 的个数
    private int countOne(int num) {
        int result = 0;
        int count = 8;
        while (count > 0 && num != 0) {
            if (num % 2 == 1) {
                result++;
            } else {
                result = 0;
            }
            num >>= 1;
            count--;
        }
        //若左移次数不足 8 ,则左起不为 1
        return count == 0 ? result : 0;
    }

}
