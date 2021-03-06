package com.ttsoft.bjtax.smsb.sbzl.qysdsnb2008.gqtzsdmxb.web;

import com.ttsoft.bjtax.sfgl.common.action.SmsbAction;
import com.ttsoft.bjtax.smsb.constant.CodeConstant;
import com.ttsoft.framework.util.VOPackage;
import org.apache.struts.action.ActionForward;
import com.ttsoft.framework.exception.ExceptionUtil;
import com.ttsoft.bjtax.smsb.sbzl.qysdsnb2008.util.QysdsUtil2008;
import com.ttsoft.bjtax.sfgl.common.util.SfRequestUtil;
import com.ttsoft.bjtax.smsb.proxy.SbzlProxy;
import com.ttsoft.bjtax.smsb.sbzl.qysdsnbnew.base.QysdsNewForm;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import com.syax.creports.Constants;
import javax.servlet.http.HttpServletRequest;
import com.ttsoft.framework.exception.BaseException;
import org.apache.struts.action.ActionMapping;
import com.ttsoft.common.model.UserData;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class GqtzsdmxbAction extends SmsbAction {
    /**
     * 操作员数据
     */

    private UserData userData = null;

    /**
     * 公共的前置处理方法，每次进入页面都会被调用<BR>
     * 设置页面显示时使用的导航信息和标题
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
                                  HttpServletRequest httpServletRequest,
                                  HttpServletResponse response)

    {
        super.initialRequest(mapping, actionForm, httpServletRequest, response);
        httpServletRequest
                .setAttribute(
                        CodeConstant.SMSB_HEADER_POSITION,
                        "<font color=\"#A4B9C6\">综合服务管理信息系统</font>&gt;<font color=\"#7C9AAB\">申报资料录入</font>&gt;企业所得税年度纳税申报表</td>");
        httpServletRequest.setAttribute(CodeConstant.SMSB_HEADER_TITLE,
                                        "企业所得税年度纳税申报表");
        httpServletRequest.setAttribute(CodeConstant.SMSB_HEADER_HELP,
                                        "help/smsb/sbzl/qysdsnb/qysdsnb-000.htm");

    }

    /**
     * 初始化页面数据
     *
     * @param mapping
     *            struts.action.ActionMapping
     * @param form
     *            QysdsnbForm
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return actionMapping.findForward的跳转目标
     * @throws BaseException
     *             系统捕捉异常，根据异常类型抛出
     */
    public ActionForward doShow(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) throws
            BaseException {

        GqtzsdmxbForm gform = (GqtzsdmxbForm) form;

        this.getBaseForm(request, gform);

        VOPackage vo = new VOPackage();
        vo.setAction(CodeConstant.SMSB_SHOWACTION);
        vo.setData(gform);
        vo.setProcessor(CodeConstant.SBZL_QYSDSNB2008_GQTZSDMXB_PROCESSOR2008);
        vo.setUserData(userData);
        try {

            // 调用processor
            gform = (GqtzsdmxbForm) SbzlProxy.getInstance().process(vo);

        } catch (Exception ex) {
            // 系统捕捉异常，根据异常类型抛出
            throw ExceptionUtil.getBaseException(ex);
        }
        request.setAttribute(mapping.getAttribute(), gform);
        return mapping.findForward("Show");
    }

    /**
     * 查询已申报数据
     *
     * @param mapping
     *            struts.action.ActionMapping
     * @param form
     *            JwsdmxbForm
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return actionMapping.findForward的跳转目标
     * @throws BaseException
     *             系统捕捉异常，根据异常类型抛出
     */

    public ActionForward doQuery(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws
            BaseException {

        return null;
    }

    /**
     * 保存申报数据
     *
     * @param mapping
     *            struts.action.ActionMapping
     * @param form
     *            JwsdmxbForm
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return actionMapping.findForward的跳转目标
     * @throws BaseException
     *             系统捕捉异常，根据异常类型抛出
     */

    public ActionForward doSave(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) throws
            BaseException {
        // -------------对数据库操作的Method进行修改，防止刷新或重复提交----------------------------------------
        ActionForward forward = doHandleToken(mapping, request);
        if (forward != null) {
            return forward;
        }

        GqtzsdmxbForm gForm = (GqtzsdmxbForm) form;

        gForm.setDataList(SfRequestUtil.getValuesToList(request,
                gForm.getSb_columns()));
        gForm.setSbbczlList(SfRequestUtil.getValuesToList(request,
                gForm.getSbbczl_columns()));
        gForm.setHjList(SfRequestUtil.getValuesToList(request,
                gForm.getHj_columns()));

        this.getBaseForm(request, gForm);

        VOPackage vo = new VOPackage();
        vo.setAction(CodeConstant.SMSB_SAVEACTION);
        vo.setData(gForm);
        vo.setProcessor(CodeConstant.SBZL_QYSDSNB2008_GQTZSDMXB_PROCESSOR2008);
        request.setAttribute(mapping.getAttribute(), gForm);
        try {
            gForm = (GqtzsdmxbForm) SbzlProxy.getInstance().process(vo);
            request.setAttribute(mapping.getAttribute(), gForm);

        } catch (Exception ex) {
            // 系统捕捉异常，根据异常类型抛出
            throw ExceptionUtil.getBaseException(ex);
        }
        request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "保存成功！");
        return mapping.findForward("Show");
    }

    /**
     * 退出页面
     *
     * @param mapping
     *            struts.action.ActionMapping
     * @param form
     *            QysdsnbForm
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return actionMapping.findForward的跳转目标
     * @throws BaseException
     *             系统捕捉异常，根据异常类型抛出
     */
    public ActionForward doExit(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response) throws
            BaseException {

        return mapping.findForward("Return");
    }

    /**
     * 审核页面数据
     * @param mapping struts.action.ActionMapping
     * @param form QysdsnbForm
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return actionMapping.findForward的跳转目标
     * @throws BaseException 系统捕捉异常，根据异常类型抛出
     */
    public ActionForward doCheck(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws
            BaseException {

        //-------对数据库操作的Method进行修改，防止刷新或重复提交----------
        ActionForward forward = doHandleToken(mapping, request);
        if (forward != null) {
            return forward;
        }

        GqtzsdmxbForm gForm = (GqtzsdmxbForm) form;
        gForm.setDataList(SfRequestUtil.getValuesToList(request,
                gForm.getSb_columns()));
        gForm.setSbbczlList(SfRequestUtil.getValuesToList(request,
                gForm.getSbbczl_columns()));
        gForm.setHjList(SfRequestUtil.getValuesToList(request,
                gForm.getHj_columns()));
        this.getBaseForm(request, gForm); //加入纳税人基本信息
        userData = this.getUserData(request);
        request.setAttribute(mapping.getAttribute(), gForm);

        VOPackage vo = new VOPackage();
        vo.setAction(CodeConstant.SMSB_CHECKACTION); //设置操作类型
        vo.setData(gForm); //设置操作数据
        vo.setUserData(userData);
        vo.setProcessor(CodeConstant.SBZL_QYSDSNB2008_GQTZSDMXB_PROCESSOR2008);
        try {
            //调用processor
            gForm = (GqtzsdmxbForm) SbzlProxy.getInstance().process(vo);
            request.setAttribute(mapping.getAttribute(), gForm);

            if (gForm.getCheckList() == null) {
                request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "审核通过！");
            } else if (gForm.getCheckList().size() == 0) {
                request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "审核通过！");
            } else if (gForm.getCheckList().size() > 0) {
                request.setAttribute(CodeConstant.CHECK_RESULT_HTML,
                                     QysdsUtil2008.getCheckResults(gForm.
                        getCheckList()));
            }
            return mapping.findForward("Show");
        } catch (Exception ex) {
            //系统捕捉异常，根据异常类型抛出
            throw ExceptionUtil.getBaseException(ex);
        }

    }

    /**
     * 删除申报数据
     *
     * @param mapping
     *            struts.action.ActionMapping
     * @param form
     *            JwsdmxbForm
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @return actionMapping.findForward的跳转目标
     * @throws BaseException
     *             系统捕捉异常，根据异常类型抛出
     */

    public ActionForward doDelete(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws
            BaseException {

//		 -------------对数据库操作的Method进行修改，防止刷新或重复提交----------------------------------------
        ActionForward forward = doHandleToken(mapping, request);
        if (forward != null) {
            return forward;
        }

        GqtzsdmxbForm gForm = (GqtzsdmxbForm) form;

        VOPackage vo = new VOPackage();
        vo.setAction(CodeConstant.SMSB_DELETEACTION);
        vo.setData(gForm);
        vo.setProcessor(CodeConstant.SBZL_QYSDSNB2008_GQTZSDMXB_PROCESSOR2008);
        this.getBaseForm(request, gForm);
        try {
            // 调用processor
            gForm = (GqtzsdmxbForm) SbzlProxy.getInstance().process(vo);

        } catch (Exception ex) {
            // 系统捕捉异常，根据异常类型抛出
            throw ExceptionUtil.getBaseException(ex);
        }
        request.setAttribute(mapping.getAttribute(), gForm);
        request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "删除成功！");
        return mapping.findForward("Show");
    }

    /**
     * 从session中获取基本信息
     *
     * @param request
     * @return
     */
    private void getBaseForm(HttpServletRequest request, GqtzsdmxbForm form) {

        userData = this.getUserData(request);

        QysdsNewForm baseForm = (QysdsNewForm) request.getSession(false)
                                .getAttribute(CodeConstant.
                                              SESSIONKEY_QYSDSNEWFORM);

        String ksrq = request.getParameter("skksrq");
        String jsrq = request.getParameter("skjsrq");

        if ((ksrq != null && !"".equals(ksrq)) &&
            (jsrq != null && !"".equals(jsrq))) {
            baseForm.setSkssksrq(request.getParameter("skksrq"));
            baseForm.setSkssjsrq(request.getParameter("skjsrq"));
            request.getSession(false).setAttribute(CodeConstant.
                    SESSIONKEY_QYSDSNEWFORM, baseForm);
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
            form.setNextTableURL(QysdsUtil2008.getTableURL(baseForm,
                    "N_" + CodeConstant.TABLE_ID_2008_11));
            form.setPreviousTableURL(QysdsUtil2008.getTableURL(baseForm,
                    "P_" + CodeConstant.TABLE_ID_2008_11));
        }
    }
}
