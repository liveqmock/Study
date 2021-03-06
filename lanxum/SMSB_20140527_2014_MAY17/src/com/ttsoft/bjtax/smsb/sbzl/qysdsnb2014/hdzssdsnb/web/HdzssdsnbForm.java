/**
 * <p>Title: 北京地税综合管理系统  申报征收-上门模块</p>
 * <p>Copyright: (C) 2003-2004 北京市地方税务局，四一安信科技有限公司，版权所有. </p>
 * <p>Company: 四一安信科技有限公司</p>
 */

package com.ttsoft.bjtax.smsb.sbzl.qysdsnb2014.hdzssdsnb.web;

import java.util.ArrayList;
import java.util.List;

import com.ttsoft.bjtax.smsb.sbzl.qysdsnbnew.base.QysdsNewForm;


/**
 * 2014核定征收企业所得税年报
 * 项目名称：企业所得税
 * 类名称：HdzssdsnbForm   
 * 类描述：   
 * 创建人：wangcy 
 * 创建时间：2014-4-10 下午3:36:10   
 * 修改人：wangcy   
 * 修改时间：2014-4-10 下午3:36:10   
 * 修改备注：   
 * @version  1.0
 */
public class HdzssdsnbForm extends QysdsNewForm {
	public HdzssdsnbForm() {

	}

	/**
	 * 所得税年报列表标题项目代码 行次、本期数、累计数 String[]
	 */
	private String[] hdnb_columns = { "hc", "lje" };

	/**
	 * 用于存储明细中具体数值 List
	 */
	private List qysdsnbList = new ArrayList();

	// 乡镇企业
	private String xzqy;

	// 一般减免税率
	private String ybjmsl;

	// 减免资格
	private String jmzg;

	//税款所属年度等于开业登记日期Y 否N
	private String sfxkh;
	//获取税款所属期所在年度上一年度征收方式
	private String syndZsfsdm;
	//获取上一年度核定征收年报行6数据
	private String syndZbh6;
	//获取上一年度汇算清缴主表行25数据
	private String syndZbh25;
	//获取上一年度汇算清缴附表5行45、46、47的校验结果
	private String syndFb5jyjg;
    private ArrayList gjbzhy;//所属行业代码表
    private String gjbzhydm;//所属行业代码	
	public String getJmzg() {
		return jmzg;
	}

	public void setJmzg(String jmzg) {
		this.jmzg = jmzg;
	}

	public String getXzqy() {
		return xzqy;
	}

	public void setXzqy(String xzqy) {
		this.xzqy = xzqy;
	}

	public String getYbjmsl() {
		return ybjmsl;
	}

	public void setYbjmsl(String ybjmsl) {
		this.xzqy = ybjmsl;
	}

	public String[] getColumns() {
		return hdnb_columns;
	}

	public void setColumns(String[] hdnb_columns) {
		this.hdnb_columns = hdnb_columns;
	}

	public List getQysdsnbList() {
		return qysdsnbList;
	}

	public void setQysdsnbList(List qysdsnbList) {
		this.qysdsnbList = qysdsnbList;
	}

	public String getSfxkh() {
		return sfxkh;
	}

	public void setSfxkh(String sfxkh) {
		this.sfxkh = sfxkh;
	}

	public String getSyndZsfsdm() {
		return syndZsfsdm;
	}

	public void setSyndZsfsdm(String syndZsfsdm) {
		this.syndZsfsdm = syndZsfsdm;
	}

	public String getSyndZbh6() {
		return syndZbh6;
	}

	public void setSyndZbh6(String syndZbh6) {
		this.syndZbh6 = syndZbh6;
	}

	public String getSyndZbh25() {
		return syndZbh25;
	}

	public void setSyndZbh25(String syndZbh25) {
		this.syndZbh25 = syndZbh25;
	}

	public String getSyndFb5jyjg() {
		return syndFb5jyjg;
	}

	public void setSyndFb5jyjg(String syndFb5jyjg) {
		this.syndFb5jyjg = syndFb5jyjg;
	}

	public ArrayList getGjbzhy() {
		return gjbzhy;
	}

	public void setGjbzhy(ArrayList gjbzhy) {
		this.gjbzhy = gjbzhy;
	}

	public String getGjbzhydm() {
		return gjbzhydm;
	}

	public void setGjbzhydm(String gjbzhydm) {
		this.gjbzhydm = gjbzhydm;
	}

}
