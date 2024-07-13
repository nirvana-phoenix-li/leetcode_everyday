package contest.week342;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T3 {

    public static void main(String[] args) {
        T3 main = new T3();

//        [-30,-17,23,35]
//        3
//        1
        int[] ints = {-30,-17,23,35};
        int k = 3;
        int x = 1;
        int[] subarrayBeauty = main.getSubarrayBeauty(ints, k, x);
        System.out.println(Arrays.toString(subarrayBeauty));

    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] resInt = new int[nums.length - k + 1];
        List<Integer> helpList = new ArrayList<>();
        //
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i == 0) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = i; j < k; j++) {
                    if (nums[j] < 0) {
                        arrayList.add(nums[j]);
                    }
                }
                helpList = arrayList.stream().sorted().collect(Collectors.toList());
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < Integer.min(x, helpList.size()); j++) {
                    list.add(helpList.get(j));
                }
                helpList=list;
                if (x <= helpList.size()) {
                    resInt[i] = helpList.get(x - 1);
                }
            } else {
                int remove = nums[i - 1];
                int input = nums[i + k - 1];
                Integer i1 = insertAndReturn(helpList, remove, input, x);
                if (i1 != null) {
                    resInt[i] = i1;
                }
            }
        }
        return resInt;
    }

    private Integer insertAndReturn(List<Integer> arrayList, Integer remove, Integer input, Integer index) {
        if (remove < 0) {
            arrayList.remove(remove);
        }
        if (input < 0) {
            if (arrayList.size()==index&&input>=arrayList.get(index-1)){

            }else {
                boolean flag = true;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) <= input) {
                        continue;
                    } else {
                        flag = false;
                        arrayList.add(i, input);
                        break;
                    }
                }
                if (flag) {
                    arrayList.add(arrayList.size(), input);
                }
            }

        }
        if (index <= arrayList.size()) {
            return arrayList.get(index - 1);
        } else {
            return null;
        }
    }
}
