/**
 * <p>Title: ������˰�ۺϹ���ϵͳ  �걨����-����ģ��</p>
 * <p>Copyright: (C) 2003-2004 �����еط�˰��֣���һ���ſƼ����޹�˾����Ȩ����. </p>
 * <p>Company: ��һ���ſƼ����޹�˾</p>
 */

package com.ttsoft.bjtax.smsb.sbzl.qysdsnbnew.mssdmxb.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.syax.creports.Constants;
import com.ttsoft.bjtax.sfgl.common.action.SmsbAction;
import com.ttsoft.bjtax.sfgl.common.util.SfRequestUtil;
import com.ttsoft.bjtax.smsb.constant.CodeConstant;
import com.ttsoft.bjtax.smsb.proxy.SbzlProxy;
import com.ttsoft.bjtax.smsb.sbzl.qysdsnbnew.base.QysdsNewForm;
import com.ttsoft.bjtax.smsb.util.QysdsNewUtil;
import com.ttsoft.common.model.UserData;
import com.ttsoft.framework.exception.BaseException;
import com.ttsoft.framework.exception.ExceptionUtil;
import com.ttsoft.framework.util.VOPackage;

/**
 * <p>
 * Title: ������˰�ۺϹ���ϵͳ �걨����-����ģ��
 * </p>
 * <p>
 * Description:��ҵ����˰�걨
 * </p>
 * 
 * @author cao gang
 * @version 1.1
 */

public class MssdmxbAction extends SmsbAction {
	/**
	 * ����Ա����
	 */

	private UserData userData = null;

	/**
	 * ������ǰ�ô���������ÿ�ν���ҳ�涼�ᱻ����<BR>
	 * ����ҳ����ʾʱʹ�õĵ�����Ϣ�ͱ���
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param actionForm
	 *            QysdsnbForm
	 * @param httpServletRequest
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 */
	protected void initialRequest(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse response)

	{
		super.initialRequest(mapping, actionForm, httpServletRequest, response);
		httpServletRequest
				.setAttribute(
						CodeConstant.SMSB_HEADER_POSITION,
						"<font color=\"#A4B9C6\">�ۺϷ��������Ϣϵͳ</font>&gt;<font color=\"#7C9AAB\">�걨����¼��</font>&gt;��ҵ����˰�����˰�걨��</td>");
		httpServletRequest.setAttribute(CodeConstant.SMSB_HEADER_TITLE,
				"��ҵ����˰�����˰�걨��");
		httpServletRequest.setAttribute(CodeConstant.SMSB_HEADER_HELP,
				"help/smsb/sbzl/qysdsnb/qysdsnb-000.htm");

	}

	/**
	 * ��ʼ��ҳ������
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param form
	 *            MssdmxbForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return actionMapping.findForward����תĿ��
	 * @throws BaseException
	 *             ϵͳ��׽�쳣�������쳣�����׳�
	 */
	public ActionForward doShow(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {
		
		MssdmxbForm mssdmxbForm = (MssdmxbForm) form;
		
		this.getBaseForm(request, mssdmxbForm);
		
		VOPackage vo = new VOPackage();
		vo.setAction(CodeConstant.SMSB_SHOWACTION);
		vo.setData(mssdmxbForm);
		vo.setProcessor(CodeConstant.SBZL_QYSDSNBNEW_MSSDMXB_PROCESSOR);
		try {
			mssdmxbForm = (MssdmxbForm) SbzlProxy.getInstance().process(vo);

		} catch (Exception ex) {
			// ϵͳ��׽�쳣�������쳣�����׳�
			throw ExceptionUtil.getBaseException(ex);
		}
		request.setAttribute(mapping.getAttribute(), mssdmxbForm);
		return mapping.findForward("Show");
	}

	/**
	 * ��ѯ���걨����
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param form
	 *            MssdmxbForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return actionMapping.findForward����תĿ��
	 * @throws BaseException
	 *             ϵͳ��׽�쳣�������쳣�����׳�
	 */
	public ActionForward doQuery(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		return null;
	}

	/**
	 * �����걨����
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param form
	 *            MssdmxbForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return actionMapping.findForward����תĿ��
	 * @throws BaseException
	 *             ϵͳ��׽�쳣�������쳣�����׳�
	 */

	public ActionForward doSave(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		// -------------�����ݿ������Method�����޸ģ���ֹˢ�»��ظ��ύ----------------------------------------
		ActionForward forward = doHandleToken(mapping, request);
		if (forward != null) {
			return forward;
		}
		MssdmxbForm mssdmxbForm = (MssdmxbForm) form;

		userData = this.getUserData(request);
		// ��ȡ�걨������
		mssdmxbForm.setDataList(SfRequestUtil.getValuesToList(request,
				mssdmxbForm.getMssd_columns()));
		this.getBaseForm(request, mssdmxbForm);

		VOPackage vo = new VOPackage();
		vo.setAction(CodeConstant.SMSB_SAVEACTION);
		vo.setData(mssdmxbForm);
		vo.setProcessor(CodeConstant.SBZL_QYSDSNBNEW_MSSDMXB_PROCESSOR);

		try {
			//����process
			mssdmxbForm = (MssdmxbForm) SbzlProxy.getInstance().process(vo);
			//ҳ�����ݻ���
			request.setAttribute(mapping.getAttribute(), mssdmxbForm);
		} catch (Exception ex) {
			// ϵͳ��׽�쳣�������쳣�����׳�
			throw ExceptionUtil.getBaseException(ex);
		}
		request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "����ɹ���");
		return mapping.findForward("Save");
	}

	/**
	 * ������ݣ����ͨ������б���
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param form
	 *            MssdmxbForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return actionMapping.findForward����תĿ��
	 * @throws BaseException
	 *             ϵͳ��׽�쳣�������쳣�����׳�
	 */
	public ActionForward doCheck(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		// -------------�����ݿ������Method�����޸ģ���ֹˢ�»��ظ��ύ----------------------------------------
		ActionForward forward = doHandleToken(mapping, request);
		if (forward != null) {
			return forward;
		}
		//��ȡ�걨����
		MssdmxbForm mssdmxbForm = (MssdmxbForm) form;
		userData = this.getUserData(request);
		
		mssdmxbForm.setDataList(SfRequestUtil.getValuesToList(request,
				mssdmxbForm.getMssd_columns()));
		
		this.getBaseForm(request, mssdmxbForm);
		
		VOPackage vo = new VOPackage();
		vo.setAction(CodeConstant.SMSB_CHECKACTION);
		vo.setData(mssdmxbForm);
		vo.setProcessor(CodeConstant.SBZL_QYSDSNBNEW_MSSDMXB_PROCESSOR);
		
		System.out.println(mssdmxbForm.toString());
		
		try {
			// ����processor
			mssdmxbForm=(MssdmxbForm)SbzlProxy.getInstance().process(vo);
			
			if(mssdmxbForm.getCheckList()==null){
				request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "���ͨ����");
			}else if(mssdmxbForm.getCheckList().size()==0){
				request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "���ͨ����");
			}else if(mssdmxbForm.getCheckList().size()>0){
				request.setAttribute(CodeConstant.CHECK_RESULT_HTML, QysdsNewUtil.getCheckResults(mssdmxbForm.getCheckList()));
			}
			
		} catch (Exception ex) {
			// ϵͳ��׽�쳣�������쳣�����׳�
			throw ExceptionUtil.getBaseException(ex);
		}
		return mapping.findForward("Show");
	}

	/**
	 * �˳�ҳ��
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param form
	 *            MssdmxbForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return actionMapping.findForward����תĿ��
	 * @throws BaseException
	 *             ϵͳ��׽�쳣�������쳣�����׳�
	 */
	public ActionForward doExit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		return mapping.findForward("Return");
	}

	/**
	 * ɾ���걨����
	 * 
	 * @param mapping
	 *            struts.action.ActionMapping
	 * @param form
	 *            MssdmxbForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return actionMapping.findForward����תĿ��
	 * @throws BaseException
	 *             ϵͳ��׽�쳣�������쳣�����׳�
	 */
	public ActionForward doDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws BaseException {

		// -------------�����ݿ������Method�����޸ģ���ֹˢ�»��ظ��ύ----------------------------------------
		ActionForward forward = doHandleToken(mapping, request);
		if (forward != null) {
			return forward;
		}
		//��ȡ�걨����
		MssdmxbForm mssdmxbForm = (MssdmxbForm) form;
		this.getBaseForm(request, mssdmxbForm);

		VOPackage vo = new VOPackage();
		vo.setAction(CodeConstant.SMSB_DELETEACTION);
		vo.setData(mssdmxbForm);
		vo.setProcessor(CodeConstant.SBZL_QYSDSNBNEW_MSSDMXB_PROCESSOR);
		try {
			// ����processor
			SbzlProxy.getInstance().process(vo);

		} catch (Exception ex) {
			// ϵͳ��׽�쳣�������쳣�����׳�
			throw ExceptionUtil.getBaseException(ex);
		}
		request.setAttribute(mapping.getAttribute(), mssdmxbForm);
		request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "ɾ���ɹ���");
		return mapping.findForward("Show");
	}

	/**
	 * ��session�л�ȡ������Ϣ
	 * 
	 * @param request
	 * @return
	 */
	private void getBaseForm(HttpServletRequest request, MssdmxbForm form) {

		userData = this.getUserData(request);

		QysdsNewForm baseForm = (QysdsNewForm) request.getSession(false)
				.getAttribute(CodeConstant.SESSIONKEY_QYSDSNEWFORM);
		
		String ksrq=request.getParameter("skksrq");
		String jsrq=request.getParameter("skjsrq");
		
		if((ksrq!=null && !"".equals(ksrq))   && (jsrq!=null && !"".equals(jsrq)) ){
			baseForm.setSkssksrq(request.getParameter("skksrq"));
			baseForm.setSkssjsrq(request.getParameter("skjsrq"));
			request.getSession(false).setAttribute(CodeConstant.SESSIONKEY_QYSDSNEWFORM,baseForm);
		}
		
		if (baseForm != null) {
			form.setJsjdm(baseForm.getJsjdm());
			form.setSbrq(baseForm.getSbrq());
			form.setNsrmc(baseForm.getNsrmc());
			form.setQh("1");
			form.setSknd(baseForm.getSknd());
			form.setBbqlx(Constants.CREPORTS_IBBQLX_TYPE_YEAR);
			form.setSkssksrq(baseForm.getSkssksrq());
			form.setSkssjsrq(baseForm.getSkssjsrq());
			form.setSwjsjdm(baseForm.getSwjsjdm());
			form.setSwjgzzjgdm(baseForm.getSwjgzzjgdm());
			form.setQxdm(baseForm.getQxdm());
			form.setLrr(userData.getYhid());
			form.setCkzd(baseForm.getCkzd());
			form.setZsfs(baseForm.getZsfs());
			form.setSsjjlx(baseForm.getSsjjlx());
			form.setSshy(baseForm.getSshy());
			form.setGzglxs(baseForm.getGzglxs());
			form.setJmlx(baseForm.getJmlx());
			form.setNextTableURL(QysdsNewUtil.getTableURL(baseForm,"N_"+CodeConstant.TABLE_ID_MSSDMXB));
			form.setPreviousTableURL(QysdsNewUtil.getTableURL(baseForm,"P_"+CodeConstant.TABLE_ID_MSSDMXB));
		}
	}

}