package com.ict.playground.sort;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

public class Order {
    // 订单编号，全局唯一
    private Integer id;
    // 下单时间
    private Instant orderTime;
    // 是否开启，true为开启，false为关闭
    private boolean open;
    // 订单金额
    private BigDecimal amount;

    public Order(Integer id, Instant orderTime, boolean open, BigDecimal amount) {
        this.id = id;
        this.orderTime = orderTime;
        this.open = open;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Instant getOrderTime() {
        return orderTime;
    }

    public boolean isOpen() {
        return open;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{"
                + "id="
                + id
                + ", orderTime="
                + orderTime
                + ", open="
                + open
                + ", amount="
                + amount
                + '}';
    }

    /**
     * 做此题前，请先了解HashSet、TreeSet这两种数据结构及其特性
     *
     * 请尝试编写一个方法，输入一个订单列表，输出一个TreeSet，TreeSet中订单的排序规则是：
     * 1.首先按照是否关闭排序，未关闭的订单靠前；
     * 2.然后按照订单金额排序，订单金额大的靠前；
     * 3.然后按照下单时间排序，下单时间早的靠前
     * @param orders
     * @return
     */
    public static TreeSet<Order> toTreeSet(List<Order> orders) {
        // todo
        TreeSet<Order> tree = new TreeSet<>(new Comparator<Order>(){
            @Override
            public int compare(Order o1, Order o2){
                // 排序规则描述如下
                // 1.首先按照是否关闭排序，未关闭的订单靠前；
                // 2.然后按照订单金额排序，订单金额大的靠前；
                // 3.然后按照下单时间排序，下单时间早的靠前
                int orderByIsOpen = o1.isOpen()^o2.isOpen()? (o1.isOpen() ? -1:1) :  0;
                int orderByAmount=orderByIsOpen==0? o2.getAmount().compareTo(o1.getAmount()):orderByIsOpen;
                int orderByOrderTime=orderByAmount==0? o1.getOrderTime().isBefore(o2.getOrderTime())?-1:1:orderByAmount;
                return orderByOrderTime;
            }
        });
        tree.addAll(orders);
        return tree;
    }


    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(
                toTreeSet(
                        Arrays.asList(
                                new Order(1, now, false, new BigDecimal("1")),
                                new Order(2, now.minusSeconds(1), true, new BigDecimal("2")),
                                new Order(3, now.minusSeconds(-1), true, new BigDecimal("3")),
                                new Order(4, now.minusSeconds(2), false, new BigDecimal("4")))));
    }
}

