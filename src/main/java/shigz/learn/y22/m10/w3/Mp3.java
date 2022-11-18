package shigz.learn.y22.m10.w3;

/**
 * Created by 大史 on 2022/10/24
 */
public class Mp3 {

    public static void main(String[] args) {
        deal("UDUUDDDUDUUUDDUDUDUUDUDUUDDDUUDUDDDU", 8);
    }

    private static void deal(String step, int count) {
        int n = Math.min(4, count);
        int currentIndex = 0;
        int currentSong = 1;
        for (char c : step.toCharArray()) {
            if (c == 'U') {
                if (currentIndex == 0) {
                    if (currentSong == 1) {
                        currentIndex = n - 1;
                        currentSong = count;
                    } else {
                        currentSong--;
                    }
                } else {
                    currentIndex--;
                    if (currentSong == 1) {
                        currentSong = count;
                    } else currentSong--;
                }
            } else {
                if (currentIndex == n - 1) {
                    if (currentSong == count) {
                        currentSong = 1;
                        currentIndex = 0;
                    } else {
                        currentSong++;
                    }
                } else {
                    if (currentSong == count) {
                        currentSong = 1;
                    } else currentSong++;
                    currentIndex++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentIndex; i++) {
            if (0 < sb.length()) {
                sb.append(" ");
            }
            sb.append(((currentSong - 1 - currentIndex + i) % count + count) % count + 1);
        }
        if (0 < sb.length()) {
            sb.append(" ");
        }
        sb.append(currentSong);
        for (int i = currentIndex + 1; i < n; i++) {
            if (0 < sb.length()) {
                sb.append(" ");
            }
            sb.append((currentSong - 1 + i - currentIndex) % count + 1);
        }
        sb.append("\n").append(currentSong);
        System.out.println(sb);
    }

}
