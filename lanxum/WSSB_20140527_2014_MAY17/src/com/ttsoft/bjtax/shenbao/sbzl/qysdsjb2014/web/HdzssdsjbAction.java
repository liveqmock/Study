package com.ttsoft.bjtax.shenbao.sbzl.qysdsjb2014.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syax.bjtax.ca.util.DzyjHelper;
import com.syax.bjtax.ca.vo.DzyjsjVO;
import com.syax.bjtax.ca.xml.util.XMLParseHelper;
import com.syax.common.util.CAcodeConstants;
import com.syax.common.web.action.DcBaseAction;
import com.syax.frame.exception.ApplicationException;
import com.syax.frame.exception.BaseException;
import com.syax.frame.exception.ExceptionUtil;
import com.ttsoft.bjtax.dj.model.SWDJJBSJ;
import com.ttsoft.bjtax.shenbao.constant.CAConstants;
import com.ttsoft.bjtax.shenbao.constant.ProcessorNames;
import com.ttsoft.bjtax.shenbao.constant.SuccessConstant;
import com.ttsoft.bjtax.shenbao.proxy.ShenbaoProxy;
import com.ttsoft.bjtax.shenbao.sbzl.qysdsjdks.QysdsksActionConstant;
import com.ttsoft.bjtax.shenbao.sbzl.qysdsjdks.QysdsksMapConstant;
import com.ttsoft.bjtax.shenbao.sbzl.qysdsjb2014.Constant;
import com.ttsoft.bjtax.shenbao.sbzl.qysdsjb2014.QysdsUtil2014;
import com.ttsoft.bjtax.shenbao.sbzl.qysdsjb2014.bo.HdzssdsBO;
import com.ttsoft.bjtax.shenbao.sbzl.qysdsjb2014.xmlvo.HdzssdsjbVO;
import com.ttsoft.bjtax.shenbao.util.CAUtils;
import com.ttsoft.bjtax.shenbao.util.FriendHelper;
import com.ttsoft.bjtax.shenbao.util.LogUtil;
import com.ttsoft.bjtax.shenbao.util.SbzlAccess;
import com.ttsoft.bjtax.shenbao.util.qysdsCheck.CheckBean;
import com.ttsoft.bjtax.shenbao.util.qysdsCheck.QysdsCheckUtil;
import com.ttsoft.common.model.UserData;
import com.ttsoft.framework.util.VOPackage;

/**
 * 
 * 项目名称：wssb_20140528   
 * 类名称：HdzssdsjbAction   
 * 类描述：   
 * 创建人：wangcy 
 * 创建时间：2014-6-7 下午4:30:02   
 * 修改人：wangcy   
 * 修改时间：2014-6-7 下午4:30:02   
 * 修改备注：   
 * @version  1.0
 */
public class HdzssdsjbAction extends DcBaseAction {

	private String errorMessage = "";

	public HdzssdsjbAction() {
		
	}

	protected boolean validate(HdzssdsjbVO qynb) {
		if (!qynb.getYwlx().equals(Constant.CA_YWLXDM_HDZSSDSJB_2014)) {
			errorMessage = "业务类型错误，不能执行业务操作。";
			return false;
		}
		if (!(qynb.getYwczlx().equals(CAcodeConstants.YWCZLX_NEW) || qynb
				.getYwczlx().equals(CAcodeConstants.YWCZLX_MODIFY))) {
			System.out.println("业务操作类型错误" + qynb.getYwczlx());
			errorMessage = "业务操作类型错误，不能执行业务操作。";
			return false;
		}

		Timestamp now = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (!qynb.getSbxx().getSbrq().startsWith(df.format(now))) {
			errorMessage = "申报日期错误。";
			return false;
		}
		return true;
	}

	protected int getActionID() {
		return com.ttsoft.bjtax.shenbao.util.SbzlAccess.HDZSQYJB2008;
	}

	public String doSave(HttpServletRequest request,
			HttpServletResponse response) throws BaseException {

		if (!isTokenValid(request)) {
			return CAConstants.INVALIDTOKEN;
		}
		String xmldata = request.getParameter(CAConstants.REQ_KEY_XML_PARANAME);
		UserData ud = (UserData) this.getUserData(request);
		DzyjHelper dh = new DzyjHelper();
		DzyjsjVO dzyj = new DzyjsjVO();
		Map retmap = null;

		HdzssdsjbVO qynbvo = new HdzssdsjbVO();
		QysdsUtil2014 qysdsUtil = new QysdsUtil2014();

		try {
			if (ud.getCaflag()) {
				try {
					dzyj = dh.verifyAndSign(request, ud.getCert(), ud.getSsdwdm());
				} catch (ApplicationException e1) {
					throw ExceptionUtil.getBaseException(e1);
				}
			}
			System.out.println("save xml:" + xmldata);
			try {
				// XMLParseHelper.parseXMLString(qyjb,xmldata,XMLParseHelper.XERCES_PARSER,true,true);
				// qyjb = new QysdsjbVO();
				XMLParseHelper.parseXMLString(qynbvo, xmldata,XMLParseHelper.VTDXML_PARSER, false, true);
			} catch (ApplicationException e) {
				throw ExceptionUtil.getBaseException(e);
			}

			HdzssdsBO qysdsndbo = qysdsUtil.Hdzsconvert2VO(qynbvo);
			dzyj.setYwdm(qynbvo.getYwlx());
			dzyj.setYwczlx(qynbvo.getYwczlx());
			// 取得Form
			// 取得登记基本数据
			SWDJJBSJ djJbsj = (SWDJJBSJ) FriendHelper.getSWDJJBSJ(request);

			Map pData = new HashMap();
			pData.put(QysdsksMapConstant.VO_KEY_KSSBSJ, qysdsndbo);
			pData.put(QysdsksMapConstant.STRING_KEY_BBLX, Constant.TABLE_ID_HDZSSDS_2014);
			pData.put(QysdsksMapConstant.STRING_KEY_JDLX, qysdsUtil.getJbDM());
			pData.put(QysdsksMapConstant.OBJECT_KEY_DJSJ, djJbsj);
			pData.put(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ, dzyj);
			pData.put(CAcodeConstants.CA_MAPKEY_VO_XMLVO, qynbvo);

			// 构造VoPackage
			VOPackage vo = new VOPackage();
			vo.setData(pData);
			vo.setProcessor(ProcessorNames.HDZSQYSDSJB_PROCESSOR_2014);
			vo.setAction(QysdsksActionConstant.INT_ACTION_SAVE);
			vo.setUserData(ud);
			// 调用后台Procxy

			// 设置回执下载页面的后续操作。
			retmap = (Map) ShenbaoProxy.getInstance().process(vo);
			if (ud.getCaflag()) {
				dzyj = (DzyjsjVO) retmap.get(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ);
				ArrayList hzlist = new ArrayList();
				hzlist.add(Long.toString(dzyj.getLsh()));
				// request.setAttribute(CAConstants.REQ_SHENBAO_HUIZHI_KEY,Long.toString(dzyj.getLsh()));
				request.setAttribute(CAConstants.REQ_SHENBAO_HUIZHI_KEY,hzlist);
			} else {
				request.setAttribute(CAConstants.REQ_SHENBAO_HUIZHI_KEY, "");
			}
			request.setAttribute(SuccessConstant.SUCCESS_MESSAGE,"企业所得税季度纳税申报表" + CAUtils.getTsxx(qynbvo.getYwczlx()));
			request.setAttribute(CAConstants.REQ_KEY_SUCCESS_MSG,"企业所得税季度纳税申报表" + CAUtils.getTsxx(qynbvo.getYwczlx()));
			request.setAttribute(CAConstants.REQ_KEY_RETURN_ADDRESS,Constant.REQ_KEY_RETURN_HDZSSDS_QYJB2014);
			LogUtil.getInstance().log(FriendHelper.getUserData(request),"企业所得税季度纳税申报表申报", qynbvo.getSbxx().getSbrq(), "成功!");
//			return CAConstants.SUCCESSSB;
			 return CAUtils.jumpTo(ud.getCaflag(),CAConstants.SAVE,CAConstants.SUCCESSSB);
		} catch (Exception ex) {
			// /3.9.设置空xml，转向失败页面
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_DATA, qynbvo.toXML());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_XSLT_VERSION,qynbvo.getXsltVersion());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_SCHEMA_VERSION,qynbvo.getSchemaVersion());
			ex.printStackTrace();
			LogUtil.getInstance().log(FriendHelper.getUserData(request),"企业所得税季度纳税申报表申报", qynbvo.getSbxx().getSbrq(), "失败!");
			throw ExceptionUtil.getBaseException(ex);
		}
	}

	/**
	 * 删除亏损申报数据 1.取得QysdsksForm 2.调用form的toVo方法转换数据 3.构造VoPackage
	 * 4.调用ShenBaoProxy的processor方法，传入VoPackage 5.利用ActionMapping转向
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            QysdsksForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws BaseException
	 */
	public String doDelete(HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		// 检查token
		if (!isTokenValid(request)) {
			return CAConstants.INVALIDTOKEN;
		}

		// 得到xml
		String xmldata = request.getParameter(CAConstants.REQ_KEY_XML_PARANAME);

		UserData ud = (UserData) this.getUserData(request);
		DzyjHelper dh = new DzyjHelper();
		DzyjsjVO dzyj = new DzyjsjVO();
		HdzssdsjbVO qyjb = new HdzssdsjbVO();
		Timestamp sbrq = new Timestamp(System.currentTimeMillis());
		QysdsUtil2014 qysdsUtil = new QysdsUtil2014();
		try {
			if (ud.getCaflag()) {
				try {
					dzyj = dh.verifyAndSign(request, ud.getCert(), ud.getSsdwdm());
				} catch (ApplicationException e1) {
					throw ExceptionUtil.getBaseException(e1);
				}
			}
			System.out.println("delete xml:" + xmldata);
			
			try {
				// XMLParseHelper.parseXMLString(qyjb,xmldata,XMLParseHelper.XERCES_PARSER,true,true);
				// qyjb = new QysdsjbVO();
				XMLParseHelper.parseXMLString(qyjb, xmldata,XMLParseHelper.VTDXML_PARSER, false, true);
			} catch (ApplicationException e) {
				throw ExceptionUtil.getBaseException(e);
			}
			dzyj.setYwczlx(qyjb.getYwczlx());
			dzyj.setYwdm(qyjb.getYwlx());

			// 取得登记基本数据
			SWDJJBSJ djJbsj = (SWDJJBSJ) FriendHelper.getSWDJJBSJ(request);
			// 更新form中的数据
			HdzssdsBO qysdsjd = qysdsUtil.Hdzsconvert2VO(qyjb);
			Map pData = new HashMap();
			pData.put(QysdsksMapConstant.VO_KEY_KSSBSJ, qysdsjd);
			pData.put(QysdsksMapConstant.STRING_KEY_JBSJ, djJbsj);
			pData.put(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ, dzyj);
			pData.put(CAcodeConstants.CA_MAPKEY_VO_XMLVO, qyjb);
			pData.put(QysdsksMapConstant.STRING_KEY_BBLX, Constant.TABLE_ID_HDZSSDS_2014);
			pData.put(QysdsksMapConstant.STRING_KEY_JDLX, qysdsUtil.getJbDM());
			// 构造VOPackage
			VOPackage vo = new VOPackage();
			vo.setData(pData);
			vo.setProcessor(ProcessorNames.HDZSQYSDSJB_PROCESSOR_2014);
			vo.setAction(QysdsksActionConstant.INT_ACTION_DELETE);
			vo.setUserData(ud);
			// 调用后台Proxy
			ShenbaoProxy.getInstance().process(vo);

			request.setAttribute(CAConstants.REQ_SHENBAO_HUIZHI_KEY, "");
			request.setAttribute(CAConstants.REQ_KEY_SUCCESS_MSG,"企业所得税季度纳税申报表" + CAUtils.getTsxx(qyjb.getYwczlx()));
			request.setAttribute(CAConstants.REQ_KEY_RETURN_ADDRESS,CAConstants.REQ_KEY_RETURN_HDZSSDS_QYJB);
			LogUtil.getInstance().log(FriendHelper.getUserData(request),"企业所得税季度纳税申报表删除", qyjb.getSbxx().getSbrq(), "成功!");
			request.setAttribute(SuccessConstant.SUCCESS_MESSAGE,"企业所得税季度纳税申报表" + CAUtils.getTsxx(qyjb.getYwczlx()));
			 return CAUtils.jumpTo(ud.getCaflag(),CAConstants.DELETE,CAConstants.SUCCESSSB);
		} catch (Exception ex) {
			// /3.9.设置空xml，转向失败页面
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_DATA, qyjb.toXML());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_XSLT_VERSION, qyjb.getXsltVersion());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_SCHEMA_VERSION,qyjb.getSchemaVersion());
			LogUtil.getInstance().log(FriendHelper.getUserData(request),"删除企业所得税季度纳税申报表",
					(new SimpleDateFormat("yyyyMMdd")).format(sbrq), "失败!");
			throw ExceptionUtil.getBaseException(ex);
		}
	}

	public String doShow(HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		// 登记基本数据
		SWDJJBSJ djJbsj = null;
		// 构造VOPackage
		VOPackage vo = new VOPackage();
		Map pDataMap = new HashMap();
		UserData ud = (UserData) request.getSession(false).getAttribute("UserData");
		if (ud == null) {
			System.out.println("session is null");
		}

		String jsjdm = ud.yhid;

		Timestamp curDate = new Timestamp(System.currentTimeMillis());

		HdzssdsBO qysdsjbbo = null;
		HdzssdsjbVO qysdsjbvo = new HdzssdsjbVO();
		QysdsUtil2014 qysdsUtil = new QysdsUtil2014();
		try {
			
//			//调用校验
			CheckBean checkBean = new CheckBean();	
			checkBean.setJsjdm(jsjdm);
			checkBean.createZgrqByCurrenttimeM();
			QysdsCheckUtil.getInstance().check(QysdsCheckUtil.getInstance().subject1, checkBean);
//			
			// 取得登记基本数据
			djJbsj = (SWDJJBSJ) FriendHelper.getSWDJJBSJ(request);

			pDataMap.put(QysdsksMapConstant.STRING_KEY_JSJDM, jsjdm);
			pDataMap.put(QysdsksMapConstant.STRING_KEY_DATE, curDate);
			pDataMap.put(QysdsksMapConstant.OBJECT_KEY_DJSJ, djJbsj);
			pDataMap.put(QysdsksMapConstant.STRING_KEY_BBLX, Constant.TABLE_ID_HDZSSDS_2014);
			pDataMap.put(QysdsksMapConstant.STRING_KEY_JDLX, qysdsUtil.getJbDM());
			vo.setAction(QysdsksActionConstant.INT_ACTION_QUERY);
			vo.setProcessor(ProcessorNames.HDZSQYSDSJB_PROCESSOR_2014);
			vo.setData(pDataMap);
			vo.setUserData(ud);
			// 调用后台查询数据
			qysdsjbbo = (HdzssdsBO) ShenbaoProxy.getInstance().process(vo);
			qysdsjbvo = qysdsUtil.Hdzsconvert2XMLVO(qysdsjbbo, djJbsj, Constant.TABLE_ID_HDZSSDS_2014);
			//设置鉴定结果--modified by huohb 2014-06-30
			qysdsjbvo.getSbxx().setZgfwjdlx(checkBean.getJdlx());
			/*----*/
			String tmpxml = qysdsjbvo.toXML();
			System.out.println("show xml:" + tmpxml);

			request.setAttribute(CAConstants.REQ_KEY_CA_XML_DATA, tmpxml);
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_XSLT_VERSION,qysdsjbvo.getXsltVersion());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_SCHEMA_VERSION,qysdsjbvo.getSchemaVersion());

			// if (true) throw new Exception("test");

			// 转向企业所得税亏损申报页面
			return CAConstants.SHOW;
		} catch (Exception ex) {
			// /3.9.设置空xml，转向失败页面
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_DATA, qysdsjbvo.toXML());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_XSLT_VERSION,qysdsjbvo.getXsltVersion());
			request.setAttribute(CAConstants.REQ_KEY_CA_XML_SCHEMA_VERSION,qysdsjbvo.getSchemaVersion());
			ex.printStackTrace();
			throw ExceptionUtil.getBaseException(ex);
		}
	}

	protected String beforePerform(HttpServletRequest request,
			HttpServletResponse response) {
		// 检查权限
		if (!SbzlAccess.getAuthority(SbzlAccess.HDZSQYJB2008, request)) {
			return CAConstants.NOPERMISSION;
		}

		return null;
	}

	public String doReturn(HttpServletRequest request,
			HttpServletResponse response) throws BaseException {
		return "Return";
	}

}