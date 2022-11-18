package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/25
 */
public class MatchKeyWord {

    public static void main(String[] args) {
        System.out.println(deal("reset"));
        System.out.println(deal("reset board"));
        System.out.println(deal("board add"));
        System.out.println(deal("board delet"));
        System.out.println(deal("reboot backplane"));
        System.out.println(deal("backplane abort"));
    }

    private static final String UNKNOWN_COMMAND = "unknown command";

    private static final String[][] keyReturnMatrix = new String[][]{
            new String[]{"reset", "board", "board fault"},
            new String[]{"board", "add", "where to add"},
            new String[]{"board", "delete", "no board at all"},
            new String[]{"reboot", "backplane", "impossible"},
            new String[]{"backplane", "abort", "install first"},
    };

    private static String deal(String pattern) {
        int spaceIndex = pattern.indexOf(" ");
        if (spaceIndex == -1) {
            return singleMatch(pattern);
        } else {
            return doubleMatch(pattern.substring(0, spaceIndex), pattern.substring(spaceIndex + 1));
        }
    }

    private static String singleMatch(String pattern) {
        if ("reset".startsWith(pattern)) return "reset what";
        return UNKNOWN_COMMAND;

    }

    private static String doubleMatch(String first, String second) {
        String result = "";
        for (String[] keyReturn : keyReturnMatrix) {
            if (keyReturn[0].startsWith(first) && keyReturn[1].startsWith(second)) {
                if (result.equals("")) {
                    result = keyReturn[2];
                } else return UNKNOWN_COMMAND;
            }
        }
        return result.equals("") ? UNKNOWN_COMMAND : result;
    }

}
