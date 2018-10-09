package com.aaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.biz.TbGoodsTypeBiz;
import com.aaa.entity.TbGoodsType;

@Controller
@RequestMapping("/GoodsType")
public class GoodsTypeController {
	@Autowired
	TbGoodsTypeBiz biz;
  @RequestMapping("/getAll")
  public @ResponseBody List<TbGoodsType> getAll(){
	  return biz.getAll();
  }
}
