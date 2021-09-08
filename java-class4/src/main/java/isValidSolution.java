/**
 * 功能描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足： 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 示例： 输入：s = "()[]{}" 输出：true
 * 输入：s = "([)]" 输出：false
 * 提示：使用LinkedList
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月08日 14:23
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 功能描述：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 有效字符串需满足： 1. 左括号必须用相同类型的右括号闭合。 2. 左括号必须以正确的顺序闭合。 示例： 输入：s = "()[]{}" 输出：true 输入：s = "([)]" 输出：false 提示：使用LinkedList 
 * @author jiangzhenyue
 * @date 2021年09月08日 14:23
 */
public class isValidSolution {
    isValidSolution() {}

    public static boolean isValid(String s){
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        int n = s.length();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("{([])}");
        System.out.println(valid);
    }
}
