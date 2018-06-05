package com.example.demo.model;

import java.util.Date;

public class AreaDistributStatistics {
    private Long id;

    private Date createTime;

    private Date statisticsTime;

    private Integer type;

    private String area;

    private Long orderNum;

    private String orderNumRate;

    private String orderNumProp;

    private Long stockOutAmount;

    private String stockOutRate;

    private String stockOutAmountProp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderNumRate() {
        return orderNumRate;
    }

    public void setOrderNumRate(String orderNumRate) {
        this.orderNumRate = orderNumRate == null ? null : orderNumRate.trim();
    }

    public String getOrderNumProp() {
        return orderNumProp;
    }

    public void setOrderNumProp(String orderNumProp) {
        this.orderNumProp = orderNumProp == null ? null : orderNumProp.trim();
    }

    public Long getStockOutAmount() {
        return stockOutAmount;
    }

    public void setStockOutAmount(Long stockOutAmount) {
        this.stockOutAmount = stockOutAmount;
    }

    public String getStockOutRate() {
        return stockOutRate;
    }

    public void setStockOutRate(String stockOutRate) {
        this.stockOutRate = stockOutRate == null ? null : stockOutRate.trim();
    }

    public String getStockOutAmountProp() {
        return stockOutAmountProp;
    }

    public void setStockOutAmountProp(String stockOutAmountProp) {
        this.stockOutAmountProp = stockOutAmountProp == null ? null : stockOutAmountProp.trim();
    }
}