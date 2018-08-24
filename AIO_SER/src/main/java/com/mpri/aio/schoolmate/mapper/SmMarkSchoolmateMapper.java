package com.mpri.aio.schoolmate.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.mpri.aio.base.mapper.CrudMapper;
import com.mpri.aio.schoolmate.model.SmMarkSchoolmate;


 /**   
 *  
 * @Description:  校友标签管理——DAO
 * @Author:       LZQ
 * @project 	  AIO 
 * @CreateDate:   Fri Aug 24 11:08:55 CST 2018
 * @Version:      v_1.0
 *    
 */
@Mapper
public interface SmMarkSchoolmateMapper extends CrudMapper<SmMarkSchoolmate>{

	
}