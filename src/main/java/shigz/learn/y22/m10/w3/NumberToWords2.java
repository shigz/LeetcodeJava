package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/21
 */
public class NumberToWords2 {

    public String numberToWords(int num) {
        if (num == 0) return "zero";
        String[] firstArr = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tenArr = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] secondArr = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] threeArr = new String[]{"billion", "million", "thousand"};
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int division = 1000000000;
        while (num != 0) {
            int remain = num / division;
            if (remain > 0) {
                int hundred = remain / 100;
                int secondRemain = remain % 100;
                int ten = secondRemain / 10;
                int one = secondRemain % 10;
                if (hundred != 0) {
                    if (0 < sb.length()) {
                        sb.append(" ");
                    }
                    sb.append(firstArr[hundred - 1]).append(" ").append("hundred");
                }
                if (ten != 0) {
                    if (0 < sb.length()) {
                        sb.append(" ");
                        if (hundred != 0) sb.append("and ");
                    }
                    if (ten == 1) {
                        sb.append(tenArr[one]);
                    } else {
                        sb.append(secondArr[ten - 2]);
                        if (one != 0) {
                            sb.append(" ").append(firstArr[one - 1]);
                        }
                    }
                } else {
                    if (one != 0) {
                        if (0 < sb.length()) {
                            sb.append(" ");
                            if (hundred != 0) sb.append("and ");
                        }
                        sb.append(firstArr[one - 1]);
                    }
                }
                num = num % division;
                if (count < 3) {
                    sb.append(" ");
                    sb.append(threeArr[count]);
                }
            }
            division /= 1000;
            count++;
        }
        return sb.toString();
    }

}
