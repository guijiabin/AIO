package com.mpri.aio.schoolmate.model;
import com.mpri.aio.base.model.DataEntity; 

 /**   
 *  
 * @Description:  校友标签管理
 * @Author:       LZQ
 * @project       AIO   
 * @CreateDate:   Fri Aug 24 11:08:55 CST 2018
 * @Version:      v_1.0
 *    
 */
public class SmMarkSchoolmate extends DataEntity<SmMarkSchoolmate> {

	private static final long serialVersionUID = 1535080135961L;
	
	private String markId;
	private String sysUserId;

	
	public String getMarkId() {
		return this.markId;
	}
	public void setMarkId(String markId) {
		this.markId = markId;
	}	
	public String getSysUserId() {
		return this.sysUserId;
	}
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}	

}
