/*
// Cart类
package com.example.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

*/
/**
 * 购物车
 *//*

@Data
public class Cart {
    // 商品列表
    private Map<Integer, CartItem> items = new LinkedHashMap<>();
    // 总数量
    private Integer totalCount;
    // 总金额
    private BigDecimal totalPrice;

    public Cart() {
        this.totalCount = 0;
        this.totalPrice = new BigDecimal(0);
    }

    // 添加商品到购物车
    public void addProduct(Game game) {
        // 判断商品列表中是否已经有该游戏的商品项
        CartItem cartItem = items.get(game.getId());
        if (cartItem == null) {
            // 如果没有，就创建一个新的商品项，并放入商品列表中
            cartItem = new CartItem(game.getId(), game.getDname(), 1, game.getPrice(), game.getPrice());
            items.put(game.getId(), cartItem);
        } else {
            // 如果有，就更新商品项的数量和总价
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setTotalprice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
        // 更新购物车的总数量和总金额
        updateTotalCountAndPrice();
    }

    // 删除购物车中的商品
    public void deleteProduct(int gameId) {
        // 判断商品列表中是否已经有该游戏的商品项
        CartItem cartItem = items.get(gameId);
        if (cartItem != null) {
            // 如果有，就从商品列表中移除该商品项
            items.remove(gameId);
            // 更新购物车的总数量和总金额
            updateTotalCountAndPrice();
        }
    }

    // 清空购物车
    public void clear() {
        // 清空商品列表
        items.clear();
        // 更新购物车的总数量和总金额
        updateTotalCountAndPrice();
    }

    // 计算购物车的总数量和总金额
    public void updateTotalCountAndPrice() {
        // 初始化总数量和总金额为0
        this.totalCount = 0;
        this.totalPrice = new BigDecimal(0);
        // 遍历商品列表，累加每个商品项的数量和总价
        for (CartItem cartItem : items.values()) {
            this.totalCount += cartItem.getCount();
            this.totalPrice = this.totalPrice.add(cartItem.getTotalprice());
        }
    }
}*/
