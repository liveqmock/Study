package com.ttsoft.bjtax.smsb.gdzys.sbzs.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import com.ttsoft.framework.form.BaseForm;
/**
 * <p>
 * Title: 北京地税核心征管系统--耕地占用税征收管理
 * </p>
 * <p>
 * Description: 出具滞纳金缴款书Form
 * </p>
 * 
 * @author wangxq
 * @version 1.0
 */
public class GdzysCjznjjksForm extends BaseForm{
	//纳税人名称
	private String nsrmc="";
	//计算机代码
	private String jsjdm="";
	//批准占地文号
	private String pzjdwh="";
	//申报表序列号
	private String sbbxlh="";
	
	//申报表序列号(查询用)
	private String cxSbbxlh="";
	
	//查询结果提示标识(1:显示提示信息；0：不显示提示信息)
	private String cxJgTsFlag="0";
	
	//缴款书数据标识（flag 1:申报数据无减免缴款书数据；2：申报数据有减免需出减免证明缴款书数据；3：申报数据有减免无需出减免证明缴款书数据）
	private String flag="";
	
	//查询结果集合
	private List dataList = new ArrayList();
	public ActionErrors validate(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest) {
		return null;
	}

	public void reset(ActionMapping actionMapping,
			HttpServletRequest httpServletRequest) {
	}

	public String getNsrmc() {
		return nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getJsjdm() {
		return jsjdm;
	}

	public void setJsjdm(String jsjdm) {
		this.jsjdm = jsjdm;
	}

	public String getPzjdwh() {
		return pzjdwh;
	}

	public void setPzjdwh(String pzjdwh) {
		this.pzjdwh = pzjdwh;
	}

	public String getSbbxlh() {
		return sbbxlh;
	}

	public void setSbbxlh(String sbbxlh) {
		this.sbbxlh = sbbxlh;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public String getCxSbbxlh() {
		return cxSbbxlh;
	}

	public void setCxSbbxlh(String cxSbbxlh) {
		this.cxSbbxlh = cxSbbxlh;
	}

	public String getCxJgTsFlag() {
		return cxJgTsFlag;
	}

	public void setCxJgTsFlag(String cxJgTsFlag) {
		this.cxJgTsFlag = cxJgTsFlag;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
