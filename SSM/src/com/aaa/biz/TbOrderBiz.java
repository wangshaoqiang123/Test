package com.aaa.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aaa.entity.TbOrder;
public interface TbOrderBiz {
    public List<TbOrder> getAll();
    public void pay(int id);
	public List<TbOrder> getByCriteria(Map map);
}
