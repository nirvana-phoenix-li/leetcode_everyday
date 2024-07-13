package contest.week336;

import java.util.PriorityQueue;

public class T2 {

    public static void main(String[] args) {
        T2 main = new T2();
//        [-32495,-144584,-270506,-394309,-298138,922535]
//        [-494490,-8984,-868661,147531,973998,-946445,-996960,-902835,135589,834698,-65960,-10607,-69236,30873,-905917,-269506,-745174]
//        [-687767,-860350,950296,52109,510127,545329,-291223,-966728,852403,828596,456730,-483632,-529386,356766,147293,572374,243605,931468,641668,494446]
        int[] ints = {-687767, -860350, 950296, 52109, 510127, 545329, -291223, -966728, 852403, 828596, 456730, -483632, -529386, 356766, 147293, 572374, 243605, 931468, 641668, 494446};
        int[] ints22 = {-494490, -8984, -868661, 147531, 973998, -946445, -996960, -902835, 135589, 834698, -65960, -10607, -69236, 30873, -905917, -269506, -745174};


        int i = main.maxScore(ints22);
        System.out.println(i);
    }

    public int maxScore(int[] nums) {
        PriorityQueue<Integer> helpList = new PriorityQueue<>();

        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num > 0) {
                count += num;
                res++;
            } else if (num < 0) {
                helpList.add(num);
            }
        }
        while (helpList.size() > 0 && count + helpList.peek() > 0) {
            count += helpList.poll();
            res++;
        }

        return res;
    }
}
