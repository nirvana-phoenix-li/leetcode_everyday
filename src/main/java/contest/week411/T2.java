package contest.week411;

import java.util.PriorityQueue;

/**
 * 输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
 *
 * 输出：7
 */
public class T2 {

    public static void main(String[] args) {
        T2 main = new T2();
        int[] energyDrinkA = {4, 1, 1};
        int[] energyDrinkB = {1,1,3};
        long l = main.maxEnergyBoost(energyDrinkA, energyDrinkB);
        System.out.println(l);


    }




    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;

        long dpA = energyDrinkA[0];
        long dpB = energyDrinkB[0];

        for (int i = 1; i < n; i++) {
            long newDpA = Math.max(dpA + energyDrinkA[i], dpB); // 继续选择 A 或者从 B 切换到 A
            long newDpB = Math.max(dpB + energyDrinkB[i], dpA); // 继续选择 B 或者从 A 切换到 B

            dpA = newDpA;
            dpB = newDpB;
        }

        return Math.max(dpA, dpB);
    }


}
