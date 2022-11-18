package shigz.learn.y22.m10.w4;

/**
 * Created by 大史 on 2022/10/31
 */
public class CanMeasureWater {

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) return false;
        if (jug1Capacity == 0 || jug2Capacity == 0) return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    public int gcd(int jug1Capacity, int jug2Capacity) {
        int remainder = jug1Capacity % jug2Capacity;
        while (remainder != 0) {
            jug1Capacity = jug2Capacity;
            jug2Capacity = remainder;
            remainder = jug1Capacity % jug2Capacity;
        }
        return jug2Capacity;
    }

}
