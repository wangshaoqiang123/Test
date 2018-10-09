package com.aaa.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aaa.entity.TbGoods;
import com.github.pagehelper.PageInfo;
public interface TbGoodsBiz {
  //��Ʒ¼��
  public String save(TbGoods goods,MultipartFile file);
  //��ѯ����
  public PageInfo<TbGoods> getAll(Integer pageNum);
  //������ѯ
  public List<TbGoods> queryByCriteria(Map map);
  //�޸�
  public void update(TbGoods goods);
  //ɾ��
  public void del(TbGoods goods);
}
