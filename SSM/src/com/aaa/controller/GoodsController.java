package com.aaa.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.aaa.biz.TbGoodsBiz;
import com.aaa.entity.TbGoods;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/Goods")
public class GoodsController {
	@Autowired
	private TbGoodsBiz biz;
	//��Ʒ¼��
   @RequestMapping("/save")
   public @ResponseBody String save(TbGoods goods,@RequestParam(value="file")MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
	   System.out.println(file); 
	   System.out.println(goods);
	   String uuid=biz.save(goods,file);
	   if(uuid!=null){
		   //ִ���ļ��ϴ�
		   String path=session.getServletContext().getRealPath("upload");
		   file.transferTo(new File(path+"/"+uuid));
	   }
	   return "success";
   }
   //��Ʒ��ѯ
   @RequestMapping("/getAll")
   public @ResponseBody PageInfo<TbGoods> getAll(Integer pageNum){
	   return biz.getAll(pageNum);
   }
   
   //��Ʒɾ��
   @RequestMapping("/del")
   public @ResponseBody String del(Integer id){
	   TbGoods goods=new TbGoods();
	   goods.setGoodsId(id);
	   biz.del(goods);
	   return "true";
   }
   //��Ʒ��Ϣ��ѯ
   @RequestMapping("/updateBegin/{id}")
   public String updateBegin(@PathVariable("id")Integer id,Model model){
	   Map map=new HashMap();
	   map.put("goodsId", id);
	   System.out.println(map.entrySet());
	   model.addAttribute("list", biz.queryByCriteria(map));
	 return "/update";
   }
   //��Ʒ��Ϣ�޸�
   @RequestMapping("/endupdate")
   public String endupdaten(TbGoods goods){
      biz.update(goods);
	  return "/SaveGoods";
   }
}
