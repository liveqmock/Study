package com.ttsoft.bjtax.smsb.wszm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ttsoft.bjtax.sfgl.common.action.SmsbAction;
import com.ttsoft.bjtax.smsb.constant.CodeConstant;
import com.ttsoft.bjtax.smsb.proxy.ZhsbProxy;
import com.ttsoft.common.model.UserData;
import com.ttsoft.framework.exception.BaseException;
import com.ttsoft.framework.exception.ExceptionUtil;
import com.ttsoft.framework.util.VOPackage;

/**
*作废完税证明的Action，所有与完税证明有关的数据传递操作，都在此Action中进行
* <p>Title: </p>
*
* <p>Description: </p>
*
* <p>Copyright: Copyright (c) 2013</p>
*
* <p>Company: </p>
*
* @author tujb
* @version 1.0
*/
public class WszmCxAction extends SmsbAction
{
	/**
     * 公共的前置处理方法，每次进入页面都会被调用<BR>
     * 设置页面显示时使用的导航信息和标题
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     */
    protected void initialRequest (ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response)

    {
        super.initialRequest(mapping, form, request, response);
        request.setAttribute(CodeConstant.SMSB_HEADER_POSITION,
                             "<font color=\"#A4B9C6\">综合服务管理信息系统</font>&gt;" +
                             "<font color=\"#7C9AAB\">申报征收</font>&gt;" +
                             "<font color=\"#7C9AAB\">税收完税证明</font>");
        request.setAttribute(CodeConstant.SMSB_HEADER_TITLE, "维护完税证明");
        request.setAttribute(CodeConstant.SMSB_HEADER_HELP,"help/smsb/lszs/wszcx-000.htm");
    }
    
    /**
     * 页面初始化
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return the element previously at the specified position.
     * @exception BaseException
     */
    public ActionForward doShow (ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws
        BaseException
    {
    	WszmCxForm pf = (WszmCxForm) form;
        try
        {
            //获得当前的userData对象
            UserData ud = this.getUserData(request);
            pf.setHeadLrr(ud.getYhid()); //获得单前登陆的用户id，作为录入人id
            pf.setHeadZhdm(ud.getXtsbm1());
        }
        catch (Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        return mapping.findForward("Show");
    }
    
    
    /**
     * 查询
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return the element previously at the specified position.
     * @exception BaseException
     */
    public ActionForward doQuery (ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest request,
                                  HttpServletResponse response)
        throws
        BaseException
    {
        //获得当前的userData对象
        UserData ud = this.getUserData(request);

        try
        {
            //把预装载的信息获得并填写
        	WszmCxForm pf = (WszmCxForm) form;

            VOPackage vo = new VOPackage();
            vo.setAction(CodeConstant.SMSB_QUERYACTION);
            vo.setData(pf);
            vo.setUserData(ud);
            vo.setProcessor(CodeConstant.WSZMCX_PROCESSOR);

            //调用processor
            pf = (WszmCxForm) ZhsbProxy.getInstance().process(vo);
            //保存返回值--------Shi Yanfeng 20031029-------
            request.setAttribute(mapping.getAttribute(), pf);
        }
        catch (Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        return mapping.findForward("Query");
    }

    /**
     * 删除
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return the element previously at the specified position.
     * @exception BaseException
     */
    public ActionForward doDelete (ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response)
        throws
        BaseException
    {
        //获得当前的userData对象
        UserData ud = this.getUserData(request);
        //防止refresh
        ActionForward forward = doHandleToken(mapping, request);
        if (forward != null)
        {
            return forward;
        }

        WszmCxForm pf = (WszmCxForm) form;
        //把预装载的信息获得并填写
        try
        {
            VOPackage vo = new VOPackage();
            vo.setAction(CodeConstant.SMSB_DELETEACTION);
            vo.setData(pf);
            vo.setUserData(ud);
            vo.setProcessor(CodeConstant.WSZMCX_PROCESSOR);

            //调用processor
            pf = (WszmCxForm) ZhsbProxy.getInstance().process(vo);
            //保存返回值--------Shi Yanfeng 20031029-------
            request.setAttribute(mapping.getAttribute(), pf);
            pf.reset(mapping, request);
            request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "作废成功！");
        }
        catch (Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        return mapping.findForward("Delete");
    }

    /**
     * 设置打印标记
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return the element previously at the specified position.
     * @exception BaseException
     */
    public ActionForward doUpdate (ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest request,
                                   HttpServletResponse response)
        throws
        BaseException
    {
        //获得当前的userData对象
        UserData ud = this.getUserData(request);
        //防止refresh
        ActionForward forward = doHandleToken(mapping, request);
        if (forward != null)
        {
            return forward;
        }

        WszmCxForm pf = (WszmCxForm) form;
        //把预装载的信息获得并填写
        try
        {
            VOPackage vo = new VOPackage();
            vo.setAction(CodeConstant.SMSB_UPDATEACTION);
            vo.setData(pf);
            vo.setUserData(ud);
            vo.setProcessor(CodeConstant.WSZMCX_PROCESSOR);

            //调用processor
            pf = (WszmCxForm) ZhsbProxy.getInstance().process(vo);
            request.setAttribute(mapping.getAttribute(), pf);
            pf.reset(mapping, request);
            request.setAttribute(CodeConstant.SMSB_SAVE_SUCCESS, "设置打印标记成功！");
        }
        catch (Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        return mapping.findForward("Update");
    }

    /**
     * 返回完税证录入页面
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     * @return the element previously at the specified position.
     * @exception BaseException
     */
    public ActionForward doBack (ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response)
        throws
        BaseException
    {
        try
        {
            //把预装载的信息传递给下一个页面
        	WszmForm pf = new WszmForm();
            pf.setActionType("Show");
            request.setAttribute("WszmForm", pf);
        }
        catch (Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        return mapping.findForward("Back");
    }

}
