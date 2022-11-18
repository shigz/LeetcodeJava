package shigz.learn.y22.m10.w2;

/**
 * Created by 大史 on 2022/10/9
 */
public class GetHint {

    public String getHint(String secret, String guess) {
        int bullCount = 0;
        int cowCount = 0;
        int index = 0;
        int[] secretCountArr = new int[10];
        int[] guessCountArr = new int[10];
        while (index < secret.length()) {
            if (secret.charAt(index) != guess.charAt(index)) {
                secretCountArr[secret.charAt(index) - 48]++;
                guessCountArr[guess.charAt(index) - 48]++;
            } else bullCount++;
            index++;
        }
        for (int i = 0; i < 10; i++) {
            cowCount += Math.min(secretCountArr[i], guessCountArr[i]);
        }
        return bullCount + "A" + cowCount + "B";
    }

}
