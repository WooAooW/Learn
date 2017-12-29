package com.common.bean;

import java.math.BigDecimal;

/**
 * 菜品模拟类
 * Created by liyu on 28/12/2017.
 */
public class DishItem {

    private String name;

    private BigDecimal price;

    private boolean canDisc;

    private int dishClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isCanDisc() {
        return canDisc;
    }

    public void setCanDisc(boolean canDisc) {
        this.canDisc = canDisc;
    }

    public int getDishClass() {
        return dishClass;
    }

    public void setDishClass(int dishClass) {
        this.dishClass = dishClass;
    }
}
