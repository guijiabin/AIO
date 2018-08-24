package com.mpri.aio.schoolmate.service;

import org.springframework.stereotype.Service;
import com.mpri.aio.base.service.CrudService;
import com.mpri.aio.schoolmate.model.SmMark;
import com.mpri.aio.schoolmate.mapper.SmMarkMapper;

 /**   
 *  
 * @Description:  校友标签管理——Service
 * @Author:       LZQ
 * @project 	  AIO 
 * @CreateDate:   Fri Aug 24 11:05:42 CST 2018
 * @Version:      v_1.0
 *    
 */
@Service
public class SmMarkService extends CrudService<SmMarkMapper, SmMark>  {


}