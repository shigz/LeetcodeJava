package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/26
 */
public class DateToDay {

    public static void main(String[] args) {
        System.out.println(dateToDay(1982, 3, 4));
    }

    //非闰年的月份累计天数,其中:
    // 1、3、5、7、8、10、12 月为 31 天
    // 4,6,9,11 月为 30 天
    // 2 月为 28 天
    private static final int[] DAYS_OF_MONTH = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    private static int dateToDay(int year, int month, int day) {
        if (month > 2 && isLeapYear(year)) {
            //闰年的 2 月份多一天
            return DAYS_OF_MONTH[month - 1] + day + 1;
        } else {
            return DAYS_OF_MONTH[month - 1] + day;
        }
    }

    private static Boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0;
    }

}
