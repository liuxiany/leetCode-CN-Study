package cn.liuxiany.leetcodeStudy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuxiany
 * @date 2021/07/10
 */
public class Test3 {

    /**
     * 滑动窗口
     * 1. start不动，end向后移动
     * 2. 当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
     * 3. 怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        // 3. 怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        // 1 start不动，end向后移动
        for (int start = 0, end = 0; end < s.length(); end++) {
            Character character = s.charAt(end);

            // 2 当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
            if (map.containsKey(character)) {
                start = Math.max(start, map.get(character) + 1);
            }

            map.put(character, end);

            // 当前不重复字符串长度
            int currentLength = end - start + 1;

            // 更新最长的不重复字符串长度
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcacbb";

        int maxLength = lengthOfLongestSubstring(s);

        System.out.println(maxLength);
    }
}
