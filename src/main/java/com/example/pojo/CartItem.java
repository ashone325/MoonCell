/*
// CartItem类
package com.example.pojo;

import lombok.Data;

import java.math.BigDecimal;

*/
/**
 * 购物车中的商品项
 *//*

@Data
public class CartItem {
    // 编号
    private Integer id;
    // 名称
    private String name;
    // 数量
    private Integer count;
    // 单价
    private BigDecimal price;
    // 总价
    private BigDecimal totalprice;

    public CartItem(Integer id, String name, Integer count, BigDecimal price, BigDecimal totalprice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalprice = totalprice;
    }

    public BigDecimal getTotalprice() {
        return price.multiply(new BigDecimal(count));
    }
}*/
