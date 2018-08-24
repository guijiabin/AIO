package com.mpri.aio.schoolmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.mpri.aio.base.controller.BaseController;
import com.mpri.aio.common.page.PageIo;
import com.mpri.aio.schoolmate.model.SmMark;
import com.mpri.aio.schoolmate.service.SmMarkService;

 /**   
 *  
 * @Description:  校友标签管理——Controller
 * @Author:       LZQ
 * @project 	  AIO 
 * @CreateDate:   Fri Aug 24 11:05:42 CST 2018
 * @Version:      v_1.0
 *    
 */
@RestController
@RequestMapping("/sys/smMark")
public class SmMarkController extends BaseController {
	
	@Autowired
	private SmMarkService smMarkService;
		
	/**
	 * 获取校友标签管理列表
	* <p>Title: list</p>  
	* <p>Description: </p>  
	* @param pageNo
	* @param pageSize
	* @param smMark
	* @return
	 */
	@CrossOrigin
	@GetMapping(value = "/list")
	public PageInfo<SmMark> list(int pageNo,int pageSize,SmMark smMark) {
		PageIo<SmMark> pageInfo =  smMarkService.loadByPage(pageNo,pageSize,smMark);							
		return pageInfo;
	}
	
	
	/**
	 * 增加或者更新校友标签管理
	* <p>Title: add</p>  
	* <p>Description: </p>  
	* @param smMark
	* @return
	 */
	@CrossOrigin
	@PostMapping(value = "/save")
	public String save(@Validated SmMark smMark){
		smMarkService.save(smMark);							
		return SUCCESS;
	}	
	
	/**
	 * 删除校友标签管理（逻辑删除）
	* <p>Title: delete</p>  
	* <p>Description: </p>  
	* @param smMark
	* @return
	 */
	@CrossOrigin
	@PostMapping(value = "/delete")
	public String delete(SmMark smMark) {
		smMarkService.delete(smMark);
		return SUCCESS;
	}
	
	/**
	 * 获取校友标签管理
	* <p>Title: get</p>  
	* <p>Description: </p>  
	* @param smMark
	* @return
	 */
	@CrossOrigin
	@PostMapping(value = "/get")
	public SmMark get(SmMark smMark) {
		return smMarkService.get(smMark);
	}
		
}