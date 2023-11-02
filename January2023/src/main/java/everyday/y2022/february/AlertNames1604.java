package everyday.y2022.february;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * 力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
 * <p>
 * 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
 * <p>
 * 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
 * <p>
 * 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
 * <p>
 * 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
 * 输出：["daniel"]
 * 解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
 * 示例 2：
 * <p>
 * 输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
 * 输出：["bob"]
 * 解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
 * 示例 3：
 * <p>
 * 输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"], keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
 * 输出：["clare","leslie"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= keyName.length, keyTime.length <= 105
 * keyName.length == keyTime.length
 * keyTime 格式为 "HH:MM" 。
 * 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
 * 1 <= keyName[i].length <= 10
 * keyName[i] 只包含小写英文字母。
 * 通过次数17,252提交次数34,856
 */
public class AlertNames1604 {
    public static void main(String[] args) {
//["daniel","daniel","daniel","luis","luis","luis","luis"]
//["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]

//        ["alice","alice","alice","bob","bob","bob","bob"]
//["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]


        AlertNames1604 main = new AlertNames1604();
        String[] strings1 = {"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"};
        String[] strings2 = {"23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38", "00:19"};
        List<String> list = main.alertNames(strings1, strings2);
        System.out.println(list);


    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<String>> diction = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < keyName.length; i++) {
            if (!diction.containsKey(keyName[i])) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(keyTime[i]);
                diction.put(keyName[i], arrayList);
            } else if (diction.get(keyName[i]).size() >= 3) {
                continue;
            } else {
                List<String> list = diction.get(keyName[i]);
                if (list.size() == 2) {
                    if (isExceedOneHour(list.get(1), keyTime[i])) {
                        list.clear();
                        list.add(keyTime[i]);
                    } else {
                        if (isExceedOneHour(list.get(0), keyTime[i])) {
                            list.remove(0);
                            list.add(keyTime[i]);
                        } else {
                            list.add(keyTime[i]);
                            result.add(keyName[i]);
                        }
                    }
                } else if (list.size() == 1) {
                    if (isExceedOneHour(list.get(0), keyTime[i])) {
                        list.remove(0);
                        list.add(keyTime[i]);
                    } else {
                        list.add(keyTime[i]);
                    }
                }
            }
        }

        return result.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    private boolean isExceedOneHour(String firstTime, String secondTime) {
        String[] split1 = firstTime.split(":");
        String[] split2 = secondTime.split(":");
        if (Integer.parseInt(split1[0]) > Integer.parseInt(split2[0])) return true;
        if (Integer.parseInt(split2[1]) - Integer.parseInt(split1[1]) > 0) {
            return Integer.parseInt(split2[0]) - Integer.parseInt(split1[0]) >= 1;
        } else {
            return Integer.parseInt(split2[0]) - Integer.parseInt(split1[0]) >= 2;
        }
    }
}
