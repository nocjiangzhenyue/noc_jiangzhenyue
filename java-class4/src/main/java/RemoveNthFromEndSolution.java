/**
 * 功能描述：
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月08日 14:22
 */

/**
 * 功能描述：
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
 * @author jiangzhenyue
 * @date 2021年09月08日 14:22
 */
public class RemoveNthFromEndSolution {
    RemoveNthFromEndSolution() {}

    /*
     * 功能描述：
     * 双指针，快指针领先慢指针n个位置，快指针到达最后一个节点时，慢指针位于倒数第（n+1）个位置
     * @author jiangzhenyue
     * @date 2021/9/8 16:18
     * @param head
     * @param n
     * @return ListNode<T>
    */
    public static<T> ListNode<T> removeNthFromEnd(ListNode<T> head, int n){
        // 删除倒数第n个节点，并返回头节点
        ListNode<T> tmpHead = new ListNode(0,head);
        ListNode<T> slow = tmpHead;
        ListNode<T> fast = tmpHead;
        // 如果n<=0，直接返回
        if (n < 1) return tmpHead.next;
        while (n > 0){
            n --;
            fast = fast.next;
        }
        // 如果n超过链表长度，直接返回
        if (fast == null) return tmpHead.next;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return tmpHead.next;
    }

    public static void main(String[] args) {
        // 1.首先构造一个长度为10的链表；
        ListNode head = new ListNode<>(1,null);
        ListNode tmp = head;
        int size = 2;
        while (size < 11){
            head.next = new ListNode<>(size,null);
            head = head.next;
            size ++;
        }
        head = tmp;
        // 显示原来链表结构
        System.out.println("原链表：");
        while(head !=null){
            System.out.println(head.val);
            head = head.next;
        }
        head = tmp;
        // 2.将头节点作为参数调用removeNthFromEnd
        head = removeNthFromEnd(head, 0);
        // 3.打印出节点中的每个值
        System.out.println("现链表：");
        while(head !=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
