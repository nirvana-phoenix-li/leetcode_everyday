package everyday.y2022.may;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 841. 钥匙和房间
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * <p>
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * <p>
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rooms = [[1],[2],[3],[]]
 * 输出：true
 * 解释：
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * <p>
 * 输入：rooms = [[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == rooms.length
 * 2 <= n <= 1000
 * 0 <= rooms[i].length <= 1000
 * 1 <= sum(rooms[i].length) <= 3000
 * 0 <= rooms[i][j] < n
 * 所有 rooms[i] 的值 互不相同
 */
public class CanVisitAllRooms841 {
    public static void main(String[] args) {

        CanVisitAllRooms841 main = new CanVisitAllRooms841();
        int[][] ints = {{1},{2},{3},{}};
        ArrayList<List<Integer>> outList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            ArrayList<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < ints[i].length; j++) {
                innerList.add(ints[i][j]);
            }
            outList.add(innerList);
        }
        boolean b = main.canVisitAllRooms(outList);
        System.out.println(b);


    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> keys = new HashSet<>();
        boolean[] flag = new boolean[rooms.size()];
        flag[0] = true;
        List<Integer> remove = rooms.get(0);
        for (Integer integer : remove) {
            flag[integer] = true;
        }
        keys.addAll(remove);
        HashSet<Integer> keysClone = (HashSet<Integer>) keys.clone();

        while (keys.size() != 0) {
            HashSet<Integer> newKeys = new HashSet<>();
            for (Integer key : keys) {
                List<Integer> list = rooms.get(key);
                for (Integer integer : list) {
                    if (keysClone.contains(integer)) {

                    } else {
                        keysClone.add(integer);
                        newKeys.add(integer);
                        flag[integer] = true;
                    }
                }
            }
            keys = newKeys;
        }

        for (boolean b : flag) {
            if (!b) return false;
        }
        return true;

    }
}
