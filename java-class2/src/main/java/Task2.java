/**
 * 功能描述：
 * 2021/9/1第二次java作业
 *
 * @author jiangzhenyue
 * @version 0.1.0
 * @date 2021年09月01日 15:42
 */
public class Task2 {
/**
 * 功能描述：
 * 2021/9/1第二次java作业
 * @author jiangzhenyue
 * @date 2021年09月01日 15:42
 */
    Task2(){}

    public static void main(String[] args) {
        /*
         * 功能描述：
         * 函数入口，测试四个函数是否正确
         * @author jiangzhenyue
         * @date 2021/9/1 15:43
         * @param args
        */
        {
            int[][] accounts = {{1,2},{3,4},{5,6},{12,3}};
            int maxNum = maxTotalAccount(accounts);
            System.out.println("资产总量最高为："+maxNum);
        }
        {swap(1,22);}
        {swapNoTmp(1,23);}
        {
            String str = " 123aa321 ";
            System.out.println("是否回文字符串："+ palindromeStringVerify(str));
        }
    }

    public static int maxTotalAccount(int[][] accounts){
        /*
         * 功能描述：
         * 返回最富有客户所拥有的资产总量
         * @author jiangzhenyue
         * @date 2021/9/1 15:40
         * @param accounts
         * @return int
         */
        int maxNum = 0;
        for(int[] userAccount:accounts){
            int userNum = 0;
            for(int singleAccount:userAccount){
                userNum += singleAccount;
            }
            maxNum = Math.max(userNum, maxNum);
        }
        return maxNum;
    }

    public static void swap(int num1, int num2){
        /*
         * 功能描述：
         * 通过临时变量交换两个数字，直接输出前后结果
         * @author jiangzhenyue
         * @date 2021/9/1 15:41
         * @param num1
         * @param num2
         */
        System.out.printf("输入的两个数字：%d,%d%n",num1, num2);
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
        System.out.printf("输出的两个数字：%d,%d%n",num1, num2);
    }

    public static void swapNoTmp(int num1, int num2){
        /*
         * 功能描述：
         * 通过异或操作交换两个数字，直接输出前后结果
         * @author jiangzhenyue
         * @date 2021/9/1 15:41
         * @param num1
         * @param num2
         */
        System.out.printf("输入的两个数字：%d,%d%n",num1, num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.printf("输出的两个数字：%d,%d%n",num1, num2);
    }

    public static boolean palindromeStringVerify(String str){
        /*
         * 功能描述：
         * 判断字符串是否是回文字符串
         * @author jiangzhenyue
         * @date 2021/9/1 15:41
         * @param str
         * @return boolean
         */
        String str2 = new StringBuffer(str).reverse().toString();
        return str2.equals(str);
    }
}
