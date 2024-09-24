package everyday.y2024.september;

/**
 * 2207. 字符串中最多数目的子序列
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
 * <p>
 * 你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
 * <p>
 * 请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
 * <p>
 * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "abdcdbc", pattern = "ac"
 * 输出：4
 * 解释：
 * 如果我们在 text[1] 和 text[2] 之间添加 pattern[0] = 'a' ，那么我们得到 "abadcdbc" 。那么 "ac" 作为子序列出现 4 次。
 * 其他得到 4 个 "ac" 子序列的方案还有 "aabdcdbc" 和 "abdacdbc" 。
 * 但是，"abdcadbc" ，"abdccdbc" 和 "abdcdbcc" 这些字符串虽然是可行的插入方案，但是只出现了 3 次 "ac" 子序列，所以不是最优解。
 * 可以证明插入一个字符后，无法得到超过 4 个 "ac" 子序列。
 * 示例 2：
 * <p>
 * 输入：text = "aabb", pattern = "ab"
 * 输出：6
 * 解释：
 * 可以得到 6 个 "ab" 子序列的部分方案为 "aaabb" ，"aaabb" 和 "aabbb" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 105
 * pattern.length == 2
 * text 和 pattern 都只包含小写英文字母。
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 10.2K
 * 提交次数
 * 28.6K
 * 通过率
 * 35.6%
 */
public class MaximumSubsequenceCount2207 {
    public static void main(String[] args) {
        MaximumSubsequenceCount2207 main = new MaximumSubsequenceCount2207();
        long l = main.maximumSubsequenceCount("vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign", "rr");
        System.out.println(l);
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        if (pattern.charAt(0) == pattern.charAt(1)) {
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == pattern.charAt(0)) {
                    count++;
                }
            }
            return ((long) count *(count+1))/2;
        }


        boolean virgin = true;
        long answer = 0;
        int count = 0;

        int before = 0;
        int after = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(0)) {
                before++;
                if (virgin) {
                    virgin = false;
                    for (int j = i + 1; j < text.length(); j++) {
                        if (text.charAt(j) == pattern.charAt(1)) {
                            count++;
                        }
                    }
                    answer += count;
                } else {
                    answer += count;
                }
            } else if (text.charAt(i) == pattern.charAt(1)) {
                after++;
                if (!virgin) {
                    count--;
                }
            }
        }
        return answer + Math.max(before, after);

    }
}
