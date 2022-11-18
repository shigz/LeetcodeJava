package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/8
 */
public class NumberToWords {

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String[] firstArr = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] tenArr = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] secondArr = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] threeArr = new String[]{"Billion", "Million", "Thousand"};
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
                    sb.append(firstArr[hundred - 1]).append(" ").append("Hundred");
                }
                if (ten != 0) {
                    if (0 < sb.length()) {
                        sb.append(" ");
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
