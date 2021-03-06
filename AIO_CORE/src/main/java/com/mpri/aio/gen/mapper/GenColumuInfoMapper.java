package com.mpri.aio.gen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mpri.aio.gen.model.GenColumuInfo;
import com.mpri.aio.gen.model.GenTableInfo;

/**
 * 
* <p>Title: GenColumuInfoMapper</p>  
* <p>Description: </p>  
* @author syp  
* @date 2018年8月7日
 */
@Mapper
public interface GenColumuInfoMapper {
	/**
	 * 
	* <p>Title: findTableColumnList</p>  
	* <p>Description: </p>  
	* @return
	 */
	List<GenColumuInfo> findTableColumnList(GenTableInfo genTableInfo);
}
