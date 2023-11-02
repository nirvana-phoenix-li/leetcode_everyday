package everyday.y2022.may;

import java.util.*;

public class FrogPosition1377 {
    public static void main(String[] args) {

    }

    public double frogPosition(int n, int[][] edges, int t, int target) {

        HashMap<Integer, List<Integer>> startHashMap = new HashMap<>();
//        HashMap<Integer, List<int[]>> endHashMap = new HashMap<>();
        for (int[] edge : edges) {
            if (startHashMap.containsKey(edge[0])) {
                startHashMap.get(edge[0]).add(edge[1]);
            } else {
                ArrayList<Integer> ints = new ArrayList<>();
                ints.add(edge[1]);
                startHashMap.put(edge[0], ints);
            }

//            if (endHashMap.containsKey(edge[1])) {
//                endHashMap.get(edge[1]).add(edge);
//            } else {
//                ArrayList<int[]> ints = new ArrayList<>();
//                ints.add(edge);
//                endHashMap.put(edge[1], ints);
//            }
        }

        ArrayList<Map<Integer, Set<Integer>>> outList = new ArrayList<>();
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashMap.put(1, hashSet);
        outList.add(hashMap);
        for (int i = 1; i <= t; i++) {
            Map<Integer, Set<Integer>> integerSetMap = outList.get(i - 1);
            HashMap<Integer, Set<Integer>> tempHashMap = new HashMap<>();
            for (Integer integer : integerSetMap.keySet()) {
                Set<Integer> passerby = integerSetMap.get(integer);
                List<Integer> destination = startHashMap.get(integer);
                for (Integer des : destination) {
                    if (!passerby.contains(des)){

                    }
                    
                }

            }

        }

        return 0;
    }
}
