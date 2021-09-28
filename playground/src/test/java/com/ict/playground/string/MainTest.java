package com.ict.playground.string;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 编写测试用例，测试对称字符串是否通过
 * 提示：可以使用java.util.Random生成随机数字字符串进行测试
 */
public class MainTest {
    @Test
    public void test() {
        // todo
        // 创建随机数字字符串
        String random = RandomStringUtils.random(10,true,true);
        String reverse = StringUtils.reverse(random);

        String str1 = random + reverse;
        System.out.println(str1);
        String str2 = random + random;
        System.out.println(str2);

        Assertions.assertTrue(Main.isSymmetric(str1));
        Assertions.assertFalse(Main.isSymmetric(str2));



    }
}