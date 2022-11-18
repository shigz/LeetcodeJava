package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/20
 */
public class IpTransfer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        System.out.println(ipToLong(in.nextLine()));
        System.out.println(longToIp(in.nextLong()));
    }

    private static long ipToLong(String ip) {
        String[] ipSegArr = ip.split("\\.");
        long result = 0L;
        for (String ipSeg:ipSegArr) {
            result = (result << 8) | Long.parseLong(ipSeg);
        }
        return result;
    }

    private static String longToIp(long longIp) {
        long[] ipSegArr = new long[4];
        for (int i = 0;i < 4;i++) {
            ipSegArr[i] = longIp & 0xff;
            longIp  >>= 8;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ipSegArr[3]);
        for (int i = 2;i >= 0;i--) {
            sb.append('.').append(ipSegArr[i]);
        }
        return sb.toString();
    }

}
