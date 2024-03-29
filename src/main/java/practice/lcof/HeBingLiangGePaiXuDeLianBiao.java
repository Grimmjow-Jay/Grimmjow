package practice.lcof;

import practice.util.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * <pre>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 * </pre>
 *
 * @author Grimm
 * @date 2021/1/11
 */
public class HeBingLiangGePaiXuDeLianBiao {

    public static void main(String[] args) {
        ListNode l1 = ListNode.newInstance(1, 2, 4);
        ListNode l2 = ListNode.newInstance(1, 3, 4);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
