package everyday.y2025.august;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numRows <= 30
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 695,638/894.4K
 * 通过率
 * 77.8%
 */
public class Generate118 {
    public static void main(String[] args) {
        Generate118 main = new Generate118();
        List<List<Integer>> generate = main.generate(5);
        System.out.println(generate);

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outList = new ArrayList<>();
        if (numRows >= 1) {
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            outList.add(innerList);
        }
        if (numRows >= 2) {
            ArrayList<Integer> innerList = new ArrayList<>();
            innerList.add(1);
            innerList.add(1);
            outList.add(innerList);
        }
        int currentStep = 1;
        while (currentStep < numRows-1) {
            ArrayList<Integer> innerList = new ArrayList<>();
            outList.add(innerList);
            innerList.add(1);

            List<Integer> fatherArr = outList.get(currentStep);
            for (int i = 0; i < fatherArr.size()-1; i++) {
                innerList.add(fatherArr.get(i) + fatherArr.get(i + 1));
            }
            innerList.add(1);
            currentStep++;
        }
        return outList;
    }
}
