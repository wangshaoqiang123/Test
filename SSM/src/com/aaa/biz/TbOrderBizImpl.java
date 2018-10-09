package com.aaa.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.TbOrderDao;
import com.aaa.entity.TbOrder;
@Service
public class TbOrderBizImpl implements TbOrderBiz {
  @Autowired
  private TbOrderDao dao;
	@Override
	public List<TbOrder> getAll() {
		return dao.getAll();
	}
	@Override
	public void pay(int id) {
		dao.pay(id);
	}
	@Override
	public List<TbOrder> getByCriteria(Map map) {
		return dao.ByCriteria(map);
	}

}
