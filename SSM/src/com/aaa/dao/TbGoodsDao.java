package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.TbGoods;

public interface TbGoodsDao {
   //商品录入	
   public void save(TbGoods goods);
   //查询所有
   public List<TbGoods> getAll();
   //条件查询
   public List<TbGoods> queryByCriteria(Map map);
   //修改
   public void update(TbGoods goods);
   //删除
   public void del(TbGoods goods);
   
}
