package everyday.y2024.june;

import java.util.ArrayList;

public class NextGreaterElements503 {

    public int[] nextGreaterElements(int[] nums) {


        if (nums.length <= 1) {

        }

        ArrayList<Integer> arrayList = new ArrayList<>();


        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                continue;
            } else {
                arrayList.add(i);
            }
        }

        if (arrayList.size() == 0) {
            arrayList.add(nums[nums.length - 1]);
        } else {

        }


        int[] answer = new int[nums.length];

        int temp = Integer.MIN_VALUE;
        int index=-1;

        for (int i = 0; i < arrayList.size(); i++) {

            int num = nums[arrayList.get(i)];
            if (temp == Integer.MIN_VALUE) {
                temp = num;
                index=i;
            }else {
                if (temp<=num){

                }else {

                }
            }


            for (int j = 0; j < arrayList.get(i); j++) {
                answer[j] = answer[j + 1];
            }


        }


        return null;
    }
}
