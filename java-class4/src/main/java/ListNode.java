/**
 * 功能描述：
 * 链表节点结构
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月08日 14:25
 */

/**
 * 功能描述：
 * 泛型链表节点结构
 * @author jiangzhenyue
 * @date 2021年09月08日 14:25
 */
public class ListNode<T> {
    T val;
    ListNode next;
    ListNode() {}
    ListNode(T val) {
        this.val = val;
    }
    ListNode(T val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
