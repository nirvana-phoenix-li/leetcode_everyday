package test;

public class T787857 {
    public static void main(String[] args) {
        int[] ints = {5, 4, 1, 3, 6};
        testArr(ints);
        System.out.println(ints);
    }

    private static void testArr(int[] arr) {
        arr[0] = -1;
    }
}
