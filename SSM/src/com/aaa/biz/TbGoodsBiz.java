package com.aaa.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aaa.entity.TbGoods;
import com.github.pagehelper.PageInfo;
public interface TbGoodsBiz {
  //商品录入
  public String save(TbGoods goods,MultipartFile file);
  //查询所有
  public PageInfo<TbGoods> getAll(Integer pageNum);
  //条件查询
  public List<TbGoods> queryByCriteria(Map map);
  //修改
  public void update(TbGoods goods);
  //删除
  public void del(TbGoods goods);
}
