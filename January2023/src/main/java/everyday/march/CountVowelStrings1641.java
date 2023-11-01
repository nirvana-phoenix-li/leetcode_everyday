package everyday.march;

import java.util.ArrayList;

public class CountVowelStrings1641 {
    public static void main(String[] args) {
        CountVowelStrings1641 main = new CountVowelStrings1641();
        int i = main.countVowelStrings(33);
        System.out.println(i);
    }

    public int countVowelStrings(int n) {
        if (n == 1) {
            return 5;
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        arrayList.add(new int[]{5, 4, 3, 2, 1});
        while (n > arrayList.size() + 1) {
            int[] ints = arrayList.get(arrayList.size() - 1);
            int[] add = new int[5];
            for (int i = 0; i < 5; i++) {
                int countHelp = 0;
                for (int j = i; j < 5; j++) {
                    countHelp += ints[j];
                }
                add[i] = countHelp;
            }
            arrayList.add(add);
        }
        int result = 0;
        int[] ints = arrayList.get(arrayList.size() - 1);
        for (int anInt : ints) {
            result += anInt;
        }
        return result;
    }
}
