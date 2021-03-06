package com.lscdz.qysds.application.jmsba2014.main.vo.request;

import com.lscdz.util.PageInfo;


/**
 * 
 * 项目名称：QysdsNb2014   
 * 类名称：JmsbaNbQueryMainReq   
 * 类描述：   减免税备案查询
 * 创建人：wangcy 
 * 创建时间：2015-1-7 上午9:15:03   
 * 修改人：wangcy   
 * 修改时间：2015-1-7 上午9:15:03   
 * 修改备注：   
 * @version  1.0
 */
public class JmsbaNbQueryMainReq extends PageInfo{
	//查询条件：备案申请编号
	private String filter_basqbh;	
	//查询条件：计算机代码
	private String filter_jsjdm;
	//查询条件：纳税人名称
	private String filter_nsrmc;
	//查询条件：备案年度
	private String filter_band;
	//查询条件：申请类型
	private String filter_sqlx;
	//查询条件：申请状态
	private String filter_sqzt;
	//查询条件：所属主管税务机关
	private String filter_zgswjg;	
	//查询条件：减免税备案事项
	private String filter_jmsbasx;
	public String getFilter_basqbh() {
		return filter_basqbh;
	}
	public void setFilter_basqbh(String filter_basqbh) {
		this.filter_basqbh = filter_basqbh;
	}
	public String getFilter_jsjdm() {
		return filter_jsjdm;
	}
	public void setFilter_jsjdm(String filter_jsjdm) {
		this.filter_jsjdm = filter_jsjdm;
	}
	public String getFilter_nsrmc() {
		return filter_nsrmc;
	}
	public void setFilter_nsrmc(String filter_nsrmc) {
		this.filter_nsrmc = filter_nsrmc;
	}
	public String getFilter_band() {
		return filter_band;
	}
	public void setFilter_band(String filter_band) {
		this.filter_band = filter_band;
	}
	public String getFilter_sqlx() {
		return filter_sqlx;
	}
	public void setFilter_sqlx(String filter_sqlx) {
		this.filter_sqlx = filter_sqlx;
	}
	public String getFilter_sqzt() {
		return filter_sqzt;
	}
	public void setFilter_sqzt(String filter_sqzt) {
		this.filter_sqzt = filter_sqzt;
	}
	public String getFilter_zgswjg() {
		return filter_zgswjg;
	}
	public void setFilter_zgswjg(String filter_zgswjg) {
		this.filter_zgswjg = filter_zgswjg;
	}
	public String getFilter_jmsbasx() {
		return filter_jmsbasx;
	}
	public void setFilter_jmsbasx(String filter_jmsbasx) {
		this.filter_jmsbasx = filter_jmsbasx;
	}
	
}
