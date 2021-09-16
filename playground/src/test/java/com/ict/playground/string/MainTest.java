package com.ict.playground.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * 编写测试用例，测试对称字符串是否通过
 * 提示：可以使用java.util.Random生成随机数字字符串进行测试
 */
public class MainTest {
    @Test
    public void test() {
        // todo
        // 创建随机数字字符串
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<10;i++){
            int num = random.nextInt(9);
            sb.append(num);
        }
        String str = String.valueOf(sb);
        // 断言
        Main main = new Main();
        boolean res = Main.isSymmetric(str);
        Assertions.assertEquals(res, str.equals(sb.reverse().toString()));


    }
}