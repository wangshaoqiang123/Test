package com.aaa.dao;

import java.util.List;
import java.util.Map;

import com.aaa.entity.TbOrder;

public interface TbOrderDao {
    public List<TbOrder> getAll();

	public void pay(int id);

	public List<TbOrder> ByCriteria(Map map);
}
