package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.TbGoodsTypeDao;
import com.aaa.entity.TbGoodsType;

@Service
public class TbGoodsTypeBizImpl implements TbGoodsTypeBiz{
	 @Autowired
	 private TbGoodsTypeDao dao;

	@Override
	public List<TbGoodsType> getAll() {
		return dao.getAll();
	}

}
