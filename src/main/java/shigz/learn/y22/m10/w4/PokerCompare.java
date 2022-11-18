package shigz.learn.y22.m10.w4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 大史 on 2022/10/27
 */
public class PokerCompare {

    public static void main(String[] args) {
        System.out.println(pokerCompare("4 4 4 4-joker JOKER"));
    }

    private static String pokerCompare(String str) {
        String[] pokerArr = str.split("-");
        Poker poker1 = getPoker(pokerArr[0]);
        Poker poker2 = getPoker(pokerArr[1]);
        if (poker1 == null || poker2 == null) return "ERROR";
        return poker1.compare(poker2);
    }

    private static Poker getPoker(String str) {
        String[] pokerArr = str.split(" ");
        if (pokerArr.length == 5) {
            return new StraightPoker(str, pokerArr[0]);
        } else if (pokerArr.length == 4) {
            return new Bomb(str, pokerArr[0]);
        } else if (pokerArr.length == 3) {
            return new TriplePoker(str, pokerArr[0]);
        } else if (pokerArr.length == 2) {
            if (pokerArr[0].equals("joker")) {
                if (pokerArr[1].equals("JOKER")) {
                    return new KingBomb(str, null);
                } else return null;
            } else if (pokerArr[0].equals("JOKER")) {
                if (pokerArr[1].equals("joker")) {
                    return new KingBomb(str, null);
                } else return null;
            } else {
                return new DoublePoker(str, pokerArr[0]);
            }
        } else if (pokerArr.length == 1) {
            return new SinglePoker(str, pokerArr[0]);
        } else return null;

    }

    static abstract class Poker {
        String str;
        String poker;
        Map<String, Integer> pokerPriorityMap = mapPokerPriority();

        public Poker(String str, String poker) {
            this.str = str;
            this.poker = poker;
        }

        abstract String compare(Poker oPoker);

        Boolean isBigThan(String poker1, String poker2) {
            return pokerPriorityMap.get(poker1) >= pokerPriorityMap.get(poker2);
        }

        private Map<String, Integer> mapPokerPriority() {
            Map<String, Integer> resultMap = new HashMap<>();
            resultMap.put("3", 0);
            resultMap.put("4", 1);
            resultMap.put("5", 2);
            resultMap.put("6", 3);
            resultMap.put("7", 4);
            resultMap.put("8", 5);
            resultMap.put("9", 6);
            resultMap.put("10", 7);
            resultMap.put("J", 8);
            resultMap.put("Q", 9);
            resultMap.put("K", 10);
            resultMap.put("A", 11);
            resultMap.put("2", 12);
            resultMap.put("joker", 13);
            resultMap.put("JOKER", 14);
            return resultMap;
        }

    }

    static class KingBomb extends Poker {

        public KingBomb(String str, String poker) {
            super(str, poker);
        }

        @Override
        String compare(Poker oPoker) {
            return str;
        }

    }

    static class Bomb extends Poker {

        public Bomb(String str, String poker) {
            super(str, poker);
        }

        @Override
        String compare(Poker oPoker) {
            if (oPoker instanceof KingBomb) return oPoker.str;
            if (oPoker instanceof Bomb && !isBigThan(poker, oPoker.poker))
                return oPoker.str;
            return str;
        }

    }

    static class StraightPoker extends Poker {

        public StraightPoker(String str, String poker) {
            super(str, poker);
        }

        @Override
        String compare(Poker oPoker) {
            if (oPoker instanceof KingBomb || oPoker instanceof Bomb) return oPoker.str;
            if (oPoker instanceof StraightPoker)
                return isBigThan(poker, oPoker.poker) ? str : oPoker.str;
            return "ERROR";
        }

    }

    static class TriplePoker extends Poker {

        public TriplePoker(String str, String poker) {
            super(str, poker);
        }

        @Override
        String compare(Poker oPoker) {
            if (oPoker instanceof KingBomb || oPoker instanceof Bomb) return oPoker.str;
            if (oPoker instanceof TriplePoker)
                return isBigThan(poker, oPoker.poker) ? str : oPoker.str;
            return "ERROR";
        }

    }

    static class DoublePoker extends Poker {

        public DoublePoker(String str, String poker) {
            super(str, poker);
        }

        @Override
        String compare(Poker oPoker) {
            if (oPoker instanceof KingBomb || oPoker instanceof Bomb) return oPoker.str;
            if (oPoker instanceof DoublePoker)
                return isBigThan(poker, oPoker.poker) ? str : oPoker.str;
            return "ERROR";
        }

    }

    static class SinglePoker extends Poker {

        public SinglePoker(String str, String poker) {
            super(str, poker);
        }

        @Override
        String compare(Poker oPoker) {
            if (oPoker instanceof KingBomb || oPoker instanceof Bomb) return oPoker.str;
            if (oPoker instanceof SinglePoker)
                return isBigThan(poker, oPoker.poker) ? str : oPoker.str;
            return "ERROR";
        }

    }

}
