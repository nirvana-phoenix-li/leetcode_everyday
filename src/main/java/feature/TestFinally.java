package feature;

public class TestFinally {
    public static void main(String[] args) throws Exception {
        test();

    }

    public static void test() throws Exception {
        try {
            int[] ints = new int[3];
            System.out.println(ints[-1]);
            System.out.println("hhhhh");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }finally {
            int aaa=1;
            int bbb=0;
            System.out.println(aaa/bbb);
            System.out.println("qqqqq");
        }
    }
}
