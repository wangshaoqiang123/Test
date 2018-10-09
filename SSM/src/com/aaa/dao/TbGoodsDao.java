package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.TbGoods;

public interface TbGoodsDao {
   //��Ʒ¼��	
   public void save(TbGoods goods);
   //��ѯ����
   public List<TbGoods> getAll();
   //������ѯ
   public List<TbGoods> queryByCriteria(Map map);
   //�޸�
   public void update(TbGoods goods);
   //ɾ��
   public void del(TbGoods goods);
   
}
