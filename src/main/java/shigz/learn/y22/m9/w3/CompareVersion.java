package shigz.learn.y22.m9.w3;

/**
 * Created by 大史 on 2022/9/22
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (index1 < version1.length() || index2 < version2.length()) {
            while (index1 < version1.length()) {
                char char1 = version1.charAt(index1);
                if (char1 == '.') {
                    index1++;
                    break;
                } else if (char1 == '0') {
                     if (0 < sb1.length()) {
                         sb1.append('0');
                     }
                } else {
                    sb1.append(char1);
                }
                index1++;
            }

            while (index2 < version2.length()) {
                char char2 = version2.charAt(index2);
                if (char2 == '.') {
                    index2++;
                    break;
                } else if (char2 == '0') {
                    if (0 < sb2.length()) {
                        sb2.append('0');
                    }
                } else {
                    sb2.append(char2);
                }
                index2++;
            }
            int v1 = 0 < sb1.length() ? Integer.parseInt(sb1.toString()) : 0;
            int v2 = 0 < sb2.length() ? Integer.parseInt(sb2.toString()) : 0;
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
            sb1.delete(0, sb1.length());
            sb2.delete(0, sb2.length());
        }
        return 0;
    }

}
