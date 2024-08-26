package everyday.y2024.august;

import entity.Employee;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 690. 员工的重要性
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。
 * <p>
 * 给定一个员工数组 employees，其中：
 * <p>
 * employees[i].id 是第 i 个员工的 ID。
 * employees[i].importance 是第 i 个员工的重要度。
 * employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。
 * 给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 * 输出：11
 * 解释：
 * 员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：employees = [[1,2,[5]],[5,-3,[]]], id = 5
 * 输出：-3
 * 解释：员工 5 的重要度为 -3 并且没有直接下属。
 * 因此，员工 5 的总重要度为 -3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= employees.length <= 2000
 * 1 <= employees[i].id <= 2000
 * 所有的 employees[i].id 互不相同。
 * -100 <= employees[i].importance <= 100
 * 一名员工最多有一名直接领导，并可能有多名下属。
 * employees[i].subordinates 中的 ID 都有效。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 72.1K
 * 提交次数
 * 107.9K
 * 通过率
 * 66.8%
 */
public class GetImportance690 {
    public static void main(String[] args) {

    }

    public int getImportance(List<Employee> employees, int id) {
        class HelpValue {
            public List<Integer> subordinates;
            private int importance;
        }
        HashMap<Integer, HelpValue> diction = new HashMap<>();
        HashSet<Integer> containIds = new HashSet<>();
        for (Employee employee : employees) {
            HelpValue helpValue = new HelpValue();
            helpValue.importance = employee.importance;
            helpValue.subordinates = employee.subordinates;
            if (employee.subordinates.size() != 0) {
                containIds.add(employee.id);
            }
            diction.put(employee.id, helpValue);
        }

        while (!containIds.isEmpty()) {
            HashSet<Integer> tempHashSet = new HashSet<>();
            for (Integer containId : containIds) {
                HelpValue helpValue = diction.get(containId);
                HashSet<Integer> tempMemo = new HashSet<>();
                for (Integer subordinate : helpValue.subordinates) {
                    if (!containIds.contains(subordinate)) {
                        helpValue.importance += diction.get(subordinate).importance;
                        tempMemo.add(subordinate);
                    }
                }
                helpValue.subordinates.removeAll(tempMemo);
                if (helpValue.subordinates.size() != 0) {
                    tempHashSet.add(containId);
                }
            }
            containIds = tempHashSet;
        }
        return diction.get(id).importance;
    }
}
