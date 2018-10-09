package com.aaa.biz;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aaa.dao.TbGoodsDao;
import com.aaa.entity.TbGoods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbGoodsBizImpl implements TbGoodsBiz{
     @Autowired
     private TbGoodsDao dao;
	@Override
	//����ʵ������ļ�,���ļ������ϴ�
	@Transactional
	public String save(TbGoods goods,MultipartFile file) {
		//�ж��Ƿ�Ҫ�ϴ�ͼƬ
		if(file!=null){
			//��ȡΨһ�ļ���
			String uuid=UUID.randomUUID().toString();
			String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String fileName=uuid+suffix;
			goods.setGoodsImageName(uuid+suffix);
			//���г־û�
			dao.save(goods);
			return uuid+suffix;
		}else{
			dao.save(goods);
			return null;
		}
	}
	@Override
	public PageInfo<TbGoods> getAll(Integer pageNum) {
		PageHelper.startPage(pageNum, 5);
		PageInfo<TbGoods> info=new PageInfo<TbGoods>(dao.getAll());
		return info;
	}
	@Override
	public List<TbGoods> queryByCriteria(Map map) {
		return dao.queryByCriteria(map);
	}
	@Override
	public void update(TbGoods goods) {
		dao.update(goods);
	}
	@Override
	public void del(TbGoods goods) {
		dao.del(goods);
	}
}
