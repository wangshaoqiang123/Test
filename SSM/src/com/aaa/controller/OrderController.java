package com.aaa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaa.biz.TbOrderBiz;
import com.aaa.entity.TbOrder;

@RequestMapping("/Order")
@Controller
public class OrderController {
	@Autowired
	TbOrderBiz biz;
   @RequestMapping("/getAll")
   public @ResponseBody List<TbOrder> getAll(){
	   return biz.getAll();
   };
   @RequestMapping("/update")
   public @ResponseBody String update(Integer id){
	   biz.pay(id);
	   return "success";
   };
   @RequestMapping("/criteria")
   public @ResponseBody List<TbOrder> criteria(@RequestParam(value="old",required=false)Date old,@RequestParam(value="ne",required=false)Date ne){
	  System.out.println(old);
	  System.out.println(ne);
	   Map map=new HashMap();
	    map.put("old",old);
	    map.put("ne", ne);
	    System.out.println(biz.getByCriteria(null));
	   return biz.getByCriteria(null);
   };
}
