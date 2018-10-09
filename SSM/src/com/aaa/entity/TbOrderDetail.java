package com.aaa.entity;

public class TbOrderDetail {
	private Integer goodsCount;
	private TbGoods goods;
	private TbOrder order;
	public Integer getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}
	public TbGoods getGoods() {
		return goods;
	}
	public void setGoods(TbGoods goods) {
		this.goods = goods;
	}
	public TbOrder getOrder() {
		return order;
	}
	public void setOrder(TbOrder order) {
		this.order = order;
	}
	
}
