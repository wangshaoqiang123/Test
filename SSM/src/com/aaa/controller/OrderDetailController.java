package com.aaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.biz.TbOrderBiz;
import com.aaa.biz.TbOrderDetailBiz;
import com.aaa.entity.TbOrder;
import com.aaa.entity.TbOrderDetail;

@RequestMapping("/OrderDetail")
@Controller
public class OrderDetailController {
	@Autowired
	TbOrderDetailBiz biz;
   @RequestMapping("/getOne")
   public @ResponseBody TbOrderDetail getOne(Integer id){
	   return biz.getOne(id);
   };
}
