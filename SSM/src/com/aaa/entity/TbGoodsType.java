package com.aaa.entity;
//商品类型表
public class TbGoodsType {
	   private Integer typeId;
	   private String typeName;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "TbGoods [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
}
