package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/27
 */
public class PasswordLevel {

    public static void main(String[] args) {
        System.out.println(getLevel(getGrade("Jl)M:+")));
    }

    private static String getLevel(int grade) {
        if (grade >= 90) {
            return "VERY_SECURE";
        } else if (grade >= 80) {
            return "SECURE";
        } else if (grade >= 70) {
            return "VERY_STRONG";
        } else if (grade >= 60) {
            return "STRONG";
        } else if (grade >= 50) {
            return "AVERAGE";
        } else if (grade >= 25) {
            return "WEAK";
        } else {
            return "VERY_WEAK";
        }
    }

    private static int getGrade(String password) {
        char[] charArr = password.toCharArray();
        //密码长度小于 5 5 分
        //密码长度大于等于 5 且小于 8 10 分
        //密码长度大于等于 8 25 分
        int result = charArr.length < 5 ? 5 : (charArr.length < 8 ? 10 : 25);
        int lowerCharCount = 0;
        int upperCharCount = 0;
        int numCount = 0;
        int otherCharCount = 0;
        for (char c : charArr) {
            if (c >= 'a' && c <= 'z') {
                lowerCharCount++;
            } else if (c >= 'A' && c <= 'Z') {
                upperCharCount++;
            } else if (c >= '0' && c <= '9') {
                numCount++;
            } else {
                otherCharCount++;
            }
        }

        if (lowerCharCount > 0) {
            if (upperCharCount > 0) {
                //大小写字母都有 +20 分
                result += 20;
            } else {
                //只有小写字母 +10 分
                result += 10;
            }
        } else {
            //只有大写字母 +10 分
            if (upperCharCount > 0) result += 10;
        }
        if (numCount == 1) {
            //只有 1 个数字 +10 分
            result += 10;
        } else if (numCount > 1) {
            //大于 1 个数字 +10 分
            result += 20;
        }
        if (otherCharCount == 1) {
            //只有 1 个其他字符 +10 分
            result += 10;
        } else if (otherCharCount > 1) {
            //大于 1 个其他字符 +10 分
            result += 25;
        }
        if (otherCharCount == 0) {
            //有字母和数字 额外 + 2 分
            if (numCount > 0 && (upperCharCount > 0 || lowerCharCount > 0)) result += 2;
        } else {
            if (numCount > 0) {
                //有其他字符且大小写字母和数字 + 5 分
                //有其他字符和数字和一种字母 + 3 分
                if (lowerCharCount > 0) {
                    result += upperCharCount > 0 ? 5 : 3;
                } else {
                    if (upperCharCount > 0) result += 3;
                }
            }
        }
        return result;
    }

}
