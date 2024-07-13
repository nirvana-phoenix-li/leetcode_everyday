package contest.week368;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class T1 {
    public static void main(String[] args) {
        T1 main = new T1();
        String[] strings = {"hey", "aeo", "mu", "ooo", "artro"};


    }


    public int minimumSum(int[] nums) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i], list);
            }
        }
        List<Integer> sortedSet = hashMap.keySet().stream().sorted((a, b) -> a - b).collect(Collectors.toList());

        for (int i = 0; i < hashMap.size() - 2; i++) {
            List<Integer> min = hashMap.get(sortedSet.get(i));
            List<Integer> medium = hashMap.get(sortedSet.get(i + 1));
            List<Integer> max = hashMap.get(sortedSet.get(i + 2));

            boolean flag = false;
            for (int j = 0; j < max.size(); j++) {
                Integer maxIndex = max.get(j);
                boolean innerFlag1 = false;
                boolean innerFlag2 = false;
                for (int k = 0; k < min.size(); k++) {
                    if (maxIndex > min.get(k)) {
                        innerFlag1 = true;
                        break;
                    }
                }

                for (int k = 0; k < medium.size(); k++) {
                    if (maxIndex < medium.get(k)) {
                        innerFlag1 = true;
                        break;
                    }
                }

            }
        }


        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] < nums[i + 1] && nums[i + 1] > nums[i + 2]) {
                int i1 = nums[i] + nums[i + 1] + nums[i + 2];
                answer = Math.min(i1, answer);
            }
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }
}
