package com.aaa.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.TbOrderDetailDao;
import com.aaa.entity.TbOrderDetail;
@Service
public class TbOrderDetailBizImpl implements TbOrderDetailBiz {
	@Autowired
	private TbOrderDetailDao dao;
	@Override
	public TbOrderDetail getOne(Integer id) {
		return dao.getOne(id);
	}

}
