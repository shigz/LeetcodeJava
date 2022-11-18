package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class StringAdd {

    public static void main(String[] args) {
        System.out.println(add("9876543210".toCharArray(),"1234567890".toCharArray()));
    }

    private static String add(char[] charArr1, char[] charArr2) {
        StringBuilder sb = new StringBuilder();
        int remain = 0;
        int index1 = charArr1.length - 1;
        int index2 = charArr2.length - 1;
        while (index1 >= 0 || index2 >= 0) {
            remain = remain + (index1 >= 0 ? charArr1[index1] - '0' : 0) + (index2 >= 0 ? charArr2[index2] - '0' : 0);
            sb.append(remain % 10);
            remain = remain / 10;
            index1--;
            index2--;
        }
        if (remain != 0) sb.append(remain);
        return sb.reverse().toString();
    }

}
