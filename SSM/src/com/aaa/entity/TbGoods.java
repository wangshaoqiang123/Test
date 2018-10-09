package com.aaa.entity;

import java.util.Date;

//商品表
public class TbGoods {
    private Integer goodsId;
    private String goodsName;
    private TbGoodsType type;
    private String goodsDesc;
    private Double goodsUnitPrice;
    private String goodsImageName;//图片名
    private Integer sellCount; 
    private Date goodsDate;
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public TbGoodsType getType() {
		return type;
	}
	public void setType(TbGoodsType type) {
		this.type = type;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Double getGoodsUnitPrice() {
		return goodsUnitPrice;
	}
	public void setGoodsUnitPrice(Double goodsUnitPrice) {
		this.goodsUnitPrice = goodsUnitPrice;
	}
	public String getGoodsImageName() {
		return goodsImageName;
	}
	public void setGoodsImageName(String goodsImageName) {
		this.goodsImageName = goodsImageName;
	}
	public Integer getSellCount() {
		return sellCount;
	}
	public void setSellCount(Integer sellCount) {
		this.sellCount = sellCount;
	}
	public Date getGoodsDate() {
		return goodsDate;
	}
	public void setGoodsDate(Date goodsDate) {
		this.goodsDate = goodsDate;
	}
	@Override
	public String toString() {
		return "TbGoods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", type=" + type + ", goodsDesc="
				+ goodsDesc + ", goodsUnitPrice=" + goodsUnitPrice + ", goodsImageName=" + goodsImageName
				+ ", sellCount=" + sellCount + ", goodsDate=" + goodsDate + "]";
	}
    
}
