package practice.lcof;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * <pre>
 *     用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 *     分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *     输入：
 *     ["CQueue","appendTail","deleteHead","deleteHead"]
 *     [[],[3],[],[]]
 *     输出：[null,null,3,-1]
 *
 * 示例 2：
 *     输入：
 *     ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 *     [[],[],[5],[2],[],[]]
 *     输出：[null,-1,null,null,5,2]
 *
 * 提示：
 *     1 <= values <= 10000
 *     最多会对 appendTail、deleteHead 进行 10000 次调用
 * </pre>
 *
 * @author Grimm
 * @date 2020/12/31
 */
public class YongLiangGeZhanShiXianDuiLie {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {

        private Deque<Integer> stack1;
        private Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.poll());
                }
            }
            Integer head = stack2.poll();
            return head == null ? -1 : head;
        }

    }
}

