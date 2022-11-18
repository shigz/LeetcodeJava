package shigz.learn.y22.m10.w3;

import java.util.Scanner;

/**
 * Created by 大史 on 2022/10/19
 */
public class IpCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        long[][] ipRangeArr = new long[8][2];
        ipRangeArr[0][0] = ipToLong("1.0.0.0");
        ipRangeArr[0][1] = ipToLong("126.255.255.255");
        ipRangeArr[1][0] = ipToLong("128.0.0.0");
        ipRangeArr[1][1] = ipToLong("191.255.255.255");
        ipRangeArr[2][0] = ipToLong("192.0.0.0");
        ipRangeArr[2][1] = ipToLong("223.255.255.255");
        ipRangeArr[3][0] = ipToLong("224.0.0.0");
        ipRangeArr[3][1] = ipToLong("239.255.255.255");
        ipRangeArr[4][0] = ipToLong("240.0.0.0");
        ipRangeArr[4][1] = ipToLong("255.255.255.255");
        ipRangeArr[5][0] = ipToLong("10.0.0.0");
        ipRangeArr[5][1] = ipToLong("10.255.255.255");
        ipRangeArr[6][0] = ipToLong("172.16.0.0");
        ipRangeArr[6][1] = ipToLong("172.31.255.255");
        ipRangeArr[7][0] = ipToLong("192.168.0.0");
        ipRangeArr[7][1] = ipToLong("192.168.255.255");
        int[] resultArr = new int[7];
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            if (0 == s.length()) break;
            String[] ipStr = s.split("~");
            if (ipStr.length == 2) {
                long longIp = ipToLong(ipStr[0]);
                boolean maskIsValid = isValidMask(ipStr[1]);
                if (longIp != 0) {
                    if (longIp == -1 || !maskIsValid) {
                        resultArr[5] += 1;
                    } else {
                        for (int i = 0;i < 5;i++) {
                            if (longIp >= ipRangeArr[i][0] && longIp <= ipRangeArr[i][1]) {
                                resultArr[i] += 1;
                            }
                        }
                        for (int i = 5;i < 8;i++) {
                            if (longIp >= ipRangeArr[i][0] && longIp <= ipRangeArr[i][1]) {
                                resultArr[6] += 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(resultArr[0]);
        for (int i = 1;i < resultArr.length;i++) {
            System.out.print(" ");
            System.out.print(resultArr[i]);
        }

    }

    private static boolean isValidMask(String maskIp) {
        long longMask = ipToLong(maskIp);
        if (longMask <= 0)  return false;
        if (longMask % 2 == 1) return false;
        while (longMask % 2 == 0) {
            longMask = longMask / 2;
        }
        while (longMask % 2 == 1) {
            longMask = longMask / 2;
        }
        return longMask == 0;
    }

    private static long ipToLong(String ip) {
        long result = 0;
        String[] segArr = ip.split("\\.");
        if (segArr.length != 4) return -1;
        if (segArr[0].equals("0") || segArr[0].equals("127")) return 0;
        for (String seg : segArr) {
            try {
                result = ((result << 8) + Long.parseLong(seg));
            } catch (Exception ex) {
                return -1;
            }
        }
        return result;
    }

}
