package shigz.learn.y22.m9.w3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/9/22
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long a = numerator;
        long b = denominator;
        StringBuilder sb1 = new StringBuilder();
        boolean flag = (a >= 0 && b >= 0) || (a < 0 && b < 0);
        if (!flag) sb1.append("-");
        sb1.append(Math.abs(a / b));
        long firstRemain = Math.abs(a % b);
        if (0 < firstRemain) {
            sb1.append('.');
            long absDenominator = Math.abs(b);
            Map<Long, Integer> remainMap = new HashMap<>();
            StringBuilder sb2 = new StringBuilder();
            long currentRemain = firstRemain;
            int index = 1;
            while (true) {
                long ten = currentRemain * 10;
                long temp = ten % absDenominator;
                if (temp == 0) {
                    sb1.append(sb2).append(ten / absDenominator);
                    return sb1.toString();
                } else {
                    if (remainMap.containsKey(ten)) {
                        for (int i = 0; i < remainMap.get(ten) - 1; i++) {
                            sb1.append(sb2.charAt(i));
                        }
                        sb1.append('(');
                        for (int i = remainMap.get(ten) - 1; i < sb2.length(); i++) {
                            sb1.append(sb2.charAt(i));
                        }
                        sb1.append(')');
                        return sb1.toString();
                    } else {
                        sb2.append(ten / absDenominator);
                        remainMap.put(ten, index);
                    }
                }
                currentRemain = temp;
                index++;
            }
        } else return sb1.toString();
    }

}
