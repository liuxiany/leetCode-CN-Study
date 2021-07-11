package cn.liuxiany.leetcodeStudy;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuxiany
 * @date 2021/07/11
 */
public class Test2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode x = l1, y = l2, current = result;
        int add = 0;

        while (x != null || y != null || add > 0) {
            int xValue = x != null ? x.val : 0;
            int yValue = y != null ? y.val : 0;
            int temp = xValue + yValue + add;

            add = temp / 10;

            int value = temp % 10;

            current.next = new ListNode(value);

            // 移动到下一个元素
            current = current.next;
            if (x != null) {
                x = x.next;
            }
            if (y != null) {
                y = y.next;
            }
        }

        return result.next;
    }

    /**
     * 输入
     * [2,4,3]
     * [5,6,4]
     * 输出
     * [7,0,8]
     * 预期结果
     * [7,0,8]
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2), l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);

        ListNode current = result;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
    
}
