package com.ict.playground.importfrom3rdparty;

import org.apache.commons.lang3.StringUtils;

/**
 * Commons Lang是Java里非常重要的基础库. 请在pom.xml中添加适当的包声明， 使得程序不再报错。
 * 提示：访问maven中央仓库 https://mvnrepository.com/， 搜索「common lang3」
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Empty string is empty: " + StringUtils.isEmpty(""));
    }
}