package com.aaa.entity;

import java.util.Date;
import java.util.List;

public class TbOrder {
   private Integer orderId;
   private String customerName;
   private Double totalMoney;
   private Date orderDate;
   private Integer orderState;
public Integer getOrderId() {
	return orderId;
}
public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public Double getTotalMoney() {
	return totalMoney;
}
public void setTotalMoney(Double totalMoney) {
	this.totalMoney = totalMoney;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}
public Integer getOrderState() {
	return orderState;
}
public void setOrderState(Integer orderState) {
	this.orderState = orderState;
}
@Override
public String toString() {
	return "TbOrder [orderId=" + orderId + ", customerName=" + customerName + ", totalMoney=" + totalMoney
			+ ", orderDate=" + orderDate + ", orderState=" + orderState + "]";
}

}
