package everyday.y2022.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1335. 工作计划的最低难度
 * 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
 * <p>
 * 你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
 * <p>
 * 给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
 * <p>
 * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：jobDifficulty = [6,5,4,3,2,1], d = 2
 * 输出：7
 * 解释：第一天，您可以完成前 5 项工作，总难度 = 6.
 * 第二天，您可以完成最后一项工作，总难度 = 1.
 * 计划表的难度 = 6 + 1 = 7
 * 示例 2：
 * <p>
 * 输入：jobDifficulty = [9,9,9], d = 4
 * 输出：-1
 * 解释：就算你每天完成一项工作，仍然有一天是空闲的，你无法制定一份能够满足既定工作时间的计划表。
 * 示例 3：
 * <p>
 * 输入：jobDifficulty = [1,1,1], d = 3
 * 输出：3
 * 解释：工作计划为每天一项工作，总难度为 3 。
 * 示例 4：
 * <p>
 * 输入：jobDifficulty = [7,1,7,1,7,1], d = 3
 * 输出：15
 * 示例 5：
 * <p>
 * 输入：jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * 输出：843
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * 通过次数11,966提交次数18,216
 */
public class MinDifficulty1335 {
    public static void main(String[] args) {
        MinDifficulty1335 main = new MinDifficulty1335();
//        int[] ints = {186, 398, 479, 206, 885, 423, 805, 112, 925, 656, 16, 932, 740, 292, 671, 360};
        int[] ints = {11,111,22,222,33,333,44,444};

//        [186,398,479,206,885,423,805,112,925,656,16,932,740,292,671,360]
//        4
        int i = main.minDifficulty(ints, 6);
        System.out.println(i);

    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) return -1;

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < jobDifficulty.length; i++) {
            if (hashMap.containsKey(jobDifficulty[i])) {
                hashMap.get(jobDifficulty[i]).add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                hashMap.put(jobDifficulty[i], arrayList);
            }
        }

        List<Integer> collect = hashMap.keySet().stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        int helpCount = jobDifficulty.length - d;

        while (true) {
            for (Integer integer : collect) {
                List<Integer> list = hashMap.get(integer);
                for (Integer inner : list) {
                    boolean find = false;
                    for (int i = inner + 1; i < jobDifficulty.length; i++) {
                        if (jobDifficulty[i] != -1) {
                            if (jobDifficulty[i] >= integer) {
                                jobDifficulty[inner] = -1;
                                helpCount--;
                                if (helpCount == 0) return countAll(jobDifficulty);
                                find = true;
                            }
                            break;
                        }
                    }
                    if (!find){
                        for (int i = inner - 1; i >= 0; i--) {
                            if (jobDifficulty[i] != -1) {
                                if (jobDifficulty[i] >= integer) {
                                    jobDifficulty[inner] = -1;
                                    helpCount--;
                                    if (helpCount == 0) return countAll(jobDifficulty);
                                    find = true;
                                }
                                break;
                            }
                        }
                    }
                    if (find) {
                        list.remove(inner);
                        break;
                    }
                }
                if (list.size() == 0) {
                    hashMap.remove(integer);
                }
                
            }
        }
    }

    private Integer countAll(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i != -1) {
                count +=i;
            }
        }
        return count;
    }
}
