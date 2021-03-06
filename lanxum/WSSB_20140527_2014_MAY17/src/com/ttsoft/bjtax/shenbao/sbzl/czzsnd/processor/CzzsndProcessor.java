//Source file: F:\\Generated Code\\com\\ttsoft\\bjtax\\shenbao\\sbzl\\czzsnd\\processor\\CzzsndProcessor.java

package com.ttsoft.bjtax.shenbao.sbzl.czzsnd.processor;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.math.BigDecimal;

import com.ekernel.db.or.*;
import com.syax.bjtax.ca.util.DzyjHelper;
import com.syax.bjtax.ca.vo.DzyjsjVO;
import com.syax.common.util.CAcodeConstants;
import com.ttsoft.bjtax.dj.model.*;
import com.ttsoft.bjtax.dj.proxy.*;
import com.ttsoft.bjtax.sfgl.model.orobj.Tzf;
import com.ttsoft.bjtax.shenbao.model.domain.*;
import com.ttsoft.bjtax.shenbao.sbzl.czzsnd.*;
import com.ttsoft.bjtax.shenbao.util.*;
import com.ttsoft.bjtax.shenbao.zhsb.ZhsbMapConstant;
import com.ttsoft.common.model.*;
import com.ttsoft.framework.exception.*;
import com.ttsoft.framework.processor.*;
import com.ttsoft.framework.util.*;
import com.ttsoft.bjtax.shenbao.model.domain.Czzsnbtzzmxsj;
import com.ttsoft.bjtax.shenbao.sbzl.czzsjd.CzzsjdMapConstant;
import com.ttsoft.bjtax.shenbao.constant.*;

/**
 * 模块设计思想--doQuery方法：
 * 	前台传入必需的资料（详细的参照查询方法的传入参数），
 * 	后台进行查询，如果存在本期申报数据，返回取得的数据。
 * 	如果不存在本期申报数据，生成本期申报数据，缺省填充后返回。
 * 	在本设计思想中前台面对后台的接口在无论是否存在本期申报数据时都是一致的。
 * 模块设计思想--doSave方法：
 * 	前台传入本期申报数据，
 * 	后台先进行数据库本期申报数据的删除操作，再做保存操作。
 * 	（所有出现在页面上的数据都是保存的数据，所见即所得。）
 * 模块设计思想--doDelete方法：
 * 	前台传入本期申报数据，
 * 	后台进行数据库本期申报数据的删除操作。
 *
 * @author Haifeng Su
 * @version 1.0
 *
 * 查账征收个人独资和合伙企业年度申报
 */
public class CzzsndProcessor implements Processor
{
    /**
     *orManage的常量
     */
    private static final long SESSIONID = 0;

    /**
     * 总控数据
     */
    private UserData userData;

    /**
     * 实现Processor接口
     * @param voPackage 业务参数
     * @return Object VOPackage型数据
     * @throws BaseException 业务异常
     * 		1 当传过来的操作类型不对时抛出
     * 		2 当调用的业务方法抛出业务异常时向上传递抛出
     * 	其他异常抛出由EJB的process方法处理。
     */
    public Object process(VOPackage voPackage) throws BaseException
    {
        this.userData = voPackage.getUserData();
        // 根据业务操作类型值来做业务操作
        try
        {
            switch(voPackage.getAction())
            {
                case CzzsndActionConstant.INT_ACTION_QUERY:
                    voPackage.setData(doQuery((Map)voPackage.getData()));
                    break;
                case CzzsndActionConstant.INT_ACTION_SAVE:
                    voPackage.setData(doSave((Map)voPackage.getData()));
                    break;
                case CzzsndActionConstant.INT_ACTION_DELETE:
                    voPackage.setData(doDelete((Map)voPackage.getData()));
                    break;
                default:
                    throw new SystemException("no such method");
            }
        }
        catch(Exception e)
        {
            throw ExceptionUtil.getBaseException(e);
        }
        return voPackage;
    }

    /**
     * @param data Map类型参数
     * @return Map
     * @throws com.ttsoft.framework.exception.BaseException
     */
    private Map doSave(Map data) throws BaseException
    {
        // 返回数据Map
        Map retMap = new HashMap(1);

        // 数据库连接对象
        Connection conn = null;
        // OR实例
        ORManager orManager = null;
        
        try
        {
            // 要保存的查账征收年报主表
            Czzsnbzb czzsnbzb = (Czzsnbzb)data.get(CzzsndMapConstant.CZZSNBZB);
            // 要保存的查账征收年报企业数据
            List czzsnbqyList = (List)data.get(CzzsndMapConstant.LIST_QYSBSJ);
            // 要保存的查账征收年报投资中数据
            List czzsnbtzzList = (List)data.get(CzzsndMapConstant.LIST_TZZSBSJ);
            // 要保存的分配比率数据
            List czzsnbfpblList = (List)data.get(CzzsndMapConstant.LIST_FPBLSJ);
            // 查账征收年报投资者明细数据
            List czzsnbtzzsjmxList = (List)data.get(CzzsndMapConstant.LIST_TZZMX);
            List dzyjList=(List)data.get(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ);
            List bacDzyjList=new ArrayList();
            UserData ud=userData;
            try
	        {
            	for(int i=0;i<dzyjList.size();i++)
            	{
            		DzyjsjVO dzyj=(DzyjsjVO)dzyjList.get(i);
            		dzyj = CAUtils.saveDzyjsj(ud,dzyj, czzsnbzb.getNd(), "0", "0", "0");
            		bacDzyjList.add(dzyj);
            	}
	       }catch (Exception ex)
	        {
	            ex.printStackTrace();
	            throw ExceptionUtil.getBaseException(ex);
	        }
	       retMap.remove(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ);
	       retMap.put(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ, bacDzyjList);

            // 先删除
            doDelForSave(data);

            // 获得数据库连接
            conn = DBResource.getConnection();
            // 获得ORManager
            orManager = DBResource.getORManager();

            // 保存查账征收年报主表数据
            orManager.makePersistent(SESSIONID, conn, czzsnbzb);

            // 保存查账征收年报企业数据
            for(int i = 0; i < czzsnbqyList.size(); i++)
            {
                orManager.makePersistent(SESSIONID, conn, czzsnbqyList.get(i));
            }

            // 保存查账征收年报投资者数据
            for(int i = 0; i < czzsnbtzzList.size(); i++)
            {
                orManager.makePersistent(SESSIONID, conn, czzsnbtzzList.get(i));
            }

            // 保存查账征收年报投资者明细数据
            for(int i = 0; i < czzsnbtzzsjmxList.size(); i++)
            {
                List tzzsjmxList = (List)czzsnbtzzsjmxList.get(i);
                for(int j = 0, size = tzzsjmxList.size(); j < size; j++)
                {
                    orManager.makePersistent(SESSIONID, conn, tzzsjmxList.get(j));
                }
            }

            // 保存查账征收年报分配比率数据
            for(int i = 0; i < czzsnbfpblList.size(); i++)
            {
                orManager.makePersistent(SESSIONID, conn, czzsnbfpblList.get(i));
            }
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        finally
        {
            DBResource.destroyConnection(conn);
        }
        retMap.put(CzzsndMapConstant.RESULT, Boolean.TRUE);
        return retMap;
    }

    /**
     * @param data Map类型参数
     * @return Map
     * @throws com.ttsoft.framework.exception.BaseException
     */
    private Map doQuery(Map data) throws BaseException
    {
        Connection conn = null;
        ORManager orManager = null;

        // 返回数据Map
        Map retMap = new HashMap(7);

        Czzsnbzb czzsnbzb = null;  // 查账征收年报主表VO
        List czzsnbqyList = null;  // 查账征收企业数据List
        List czzsnbtzzsjList = null;  // 查账征收年报投资者数据List
        List czzsnbfpblList = null;  // 查账征收年报分配比率数据
        List czzsnbtzzsjmxList = null;  // 查账征收年报投资者明细数据
        SWDJJBSJ swdjjbsj = null;  // 登记基本数据

        try
        {
            // 取得计算机代码
            String jsjdm = (String)data.get(CzzsndMapConstant.JSJDM);
            // 取得登记投资方数据List
            List tzfList = (List)data.get(CzzsndMapConstant.LIST_TZF);

            //调用登记接口查询登记信息
            ServiceProxy sProxy = new ServiceProxy();
            Map djsjMap = sProxy.getDjInfo(jsjdm);

            // 取得登记基本数据
            swdjjbsj = (SWDJJBSJ)djsjMap.get(CzzsndMapConstant.JBSJ);
            String swjgzzjgdm = swdjjbsj.getSwjgzzjgdm();

            // 查账征收年报主表List
            List czzsnbzbList = null;

            conn = DBResource.getConnection();
            orManager = DBResource.getORManager();

            // 取得当前日期年度
            Date today = new Date();
            Map sksjrqMap = Skssrq.yearSkssrq(today);
            String nd = (String)sksjrqMap.get(Skssrq.SKSSRQ_ND);

            retMap.put(CzzsndMapConstant.CZZSNBEXISTED, "0");  // 数据是否存在
            // 查询数据库，取得查账征收主表数据
            czzsnbzbList = this.queryCzzsndzb(conn, orManager, jsjdm, nd, swjgzzjgdm);
            if(czzsnbzbList == null || czzsnbzbList.size() == 0)
            {
                // 生成查账征收年报主表数据
                czzsnbzb = this.newInstanceCzzsnbzb(djsjMap, jsjdm, nd);

                // 生成查账征收年报投资者数据
                czzsnbtzzsjList = this.newInstanceCzzsnbtzzsbList(djsjMap, tzfList, jsjdm, nd);

                // 生成查账征收年报企业数据
                czzsnbqyList = this.newInstanceCzzsnbqysbList(djsjMap, jsjdm, nd);

                // 生成查账征收年报分配比率数据
                czzsnbfpblList = this.newInstanceCzzsnbfpblList(djsjMap, tzfList, jsjdm, nd);

                // 生成查账征收年报投资者明细数据
                czzsnbtzzsjmxList = this.newInstanceCzzsnbtzzsbmxList(djsjMap, tzfList, jsjdm, nd);
            }
            else
            {
                retMap.put(CzzsndMapConstant.CZZSNBEXISTED, "1");  // 数据是否存在
                czzsnbzb = (Czzsnbzb)czzsnbzbList.get(0);
                // 查询企业数据
                czzsnbqyList = this.queryCzzsqysj(conn, orManager, jsjdm, nd, swjgzzjgdm);
                System.out.println(czzsnbqyList.size());
                if(czzsnbqyList.size() != 40)
                {
                    throw new ApplicationException("数据不完整！");
                }
                // 查询分配比率数据
                czzsnbfpblList = this.queryCzzsnbfpblsj(conn, orManager, jsjdm, nd, swjgzzjgdm);
                if(czzsnbfpblList.size() != 4)
                {
                    throw new ApplicationException("数据不完整！");
                }
                // 查询投资者数据
                czzsnbtzzsjList = this.queryCzzsnbtzzsj(conn, orManager, jsjdm, nd, swjgzzjgdm);
                if(czzsnbtzzsjList.size() != tzfList.size())
                {
                    throw new ApplicationException("数据不完整！");
                }
                // 生成查账征收年报投资者明细数据
                List totalTzzmxList = this.queryCzzsnbtzzmxsj(conn, orManager, jsjdm, nd, swjgzzjgdm);
                if(totalTzzmxList.size() != tzfList.size() * 10)
                {
                    throw new ApplicationException("数据不完整！");
                }
                int tzzSize = czzsnbtzzsjList.size();
                czzsnbtzzsjmxList = new ArrayList(tzzSize);
                int subSize = totalTzzmxList.size() / tzzSize;

                for(int i = 0, size = tzzSize; i < size; i++)
                {
                    List subList = new ArrayList(subSize);
                    for(int j = 0; j < subSize; j++)
                    {
                        subList.add(totalTzzmxList.get(subSize * i + j));
                    }
                    czzsnbtzzsjmxList.add(subList);
                }
            }
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        }
        finally
        {
            // 关闭数据库连接
            DBResource.destroyConnection(conn);
        }

        retMap.put(CzzsndMapConstant.CZZSNBZB, czzsnbzb);  // 查账征收年报主表数据
        retMap.put(CzzsndMapConstant.LIST_QYSBSJ, czzsnbqyList);  // 查账征收年报企业数据
        retMap.put(CzzsndMapConstant.LIST_TZZSBSJ, czzsnbtzzsjList);  // 查账征收年报投资者数据
        retMap.put(CzzsndMapConstant.LIST_FPBLSJ, czzsnbfpblList);  // 查账征收年报分配比率数据
        retMap.put(CzzsndMapConstant.LIST_TZZMX, czzsnbtzzsjmxList);  // 查账征收年报投资者明细数据
        retMap.put(CzzsndMapConstant.JBSJ, swdjjbsj);  // 登记基本数据

        return retMap;
    }

    /**
     * @param data Map类型参数
     * @return Map
     * @throws com.ttsoft.framework.exception.BaseException
     */
    private Map doDelete(Map data) throws BaseException
    {
        // 返回数据Map
        Map retMap = new HashMap(1);

        // 数据库连接对象
        Connection conn = null;
        // OR实例
        ORManager orManager = null;
        try
        {
            // 要删除的查账征收年报主表
            Czzsnbzb czzsnbzb = (Czzsnbzb)data.get(CzzsndMapConstant.CZZSNBZB);
            // 要删除的查账征收年报企业数据
            List czzsnbqyList = (List)data.get(CzzsndMapConstant.LIST_QYSBSJ);
            // 要删除的查账征收年报投资中数据
            List czzsnbtzzList = (List)data.get(CzzsndMapConstant.LIST_TZZSBSJ);
            // 要删除的查账征收年报分配比率数据
            List czzsnbfpblList = (List)data.get(CzzsndMapConstant.LIST_FPBLSJ);
            // 查账征收年报投资者明细数据
            List czzsnbtzzsjmxList = (List)data.get(CzzsndMapConstant.LIST_TZZMX);
            DzyjsjVO dzyj=(DzyjsjVO)data.get(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ);
            UserData ud=userData;
            
            try
	        {
            	dzyj = CAUtils.saveDzyjsj(ud,dzyj, czzsnbzb.getNd(), "0", "0", "0");
	       	
	       }catch (Exception ex)
	        {
	            ex.printStackTrace();
	            throw ExceptionUtil.getBaseException(ex);
	        }
	       retMap.put(CAcodeConstants.CA_MAPKEY_VO_DZYJSJ, dzyj);

            // 获得数据库连接
            conn = DBResource.getConnection();
            // 获得ORManager
            orManager = DBResource.getORManager();

            // 先后删除查账征收年报分配比率数据
            this.deleteCzzsnbfpblsj(conn, orManager, czzsnbfpblList);
            // 后删除查账征收年报投资者明细数据
            this.deleteCzzsnbtzzmxsj(conn, orManager, czzsnbtzzsjmxList);
            // 再删除查账征收年报投资者数据
            this.deleteCzzsnbtzzsj(conn, orManager, czzsnbtzzList);
            // 然后删除查账征收年报企业数据
            this.deleteCzzsnbqysj(conn, orManager, czzsnbqyList);
            // 最后删除查账征收年报主表数据
            this.deleteCzzsnbzbsj(conn, orManager, czzsnbzb);
        } catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        } finally
        {
            DBResource.destroyConnection(conn);
        }
        //构造返回数据
        retMap.put(CzzsndMapConstant.RESULT, Boolean.TRUE);
        return retMap;
    }

    private Map doDelForSave(Map data) throws BaseException
    {
        // 返回数据Map
        Map retMap = new HashMap(1);

        // 数据库连接对象
        Connection conn = null;
        // OR实例
        ORManager orManager = null;
        try
        {
            // 要删除的查账征收年报主表
            Czzsnbzb czzsnbzb = (Czzsnbzb)data.get(CzzsndMapConstant.CZZSNBZB);
            // 要删除的查账征收年报企业数据
            List czzsnbqyList = (List)data.get(CzzsndMapConstant.LIST_QYSBSJ);
            // 要删除的查账征收年报投资中数据
            List czzsnbtzzList = (List)data.get(CzzsndMapConstant.LIST_TZZSBSJ);
            // 要删除的查账征收年报分配比率数据
            List czzsnbfpblList = (List)data.get(CzzsndMapConstant.LIST_FPBLSJ);
            // 查账征收年报投资者明细数据
            List czzsnbtzzsjmxList = (List)data.get(CzzsndMapConstant.LIST_TZZMX);

            // 获得数据库连接
            conn = DBResource.getConnection();
            // 获得ORManager
            orManager = DBResource.getORManager();

            // 先后删除查账征收年报分配比率数据
            this.deleteCzzsnbfpblsj(conn, orManager, czzsnbfpblList);
            // 后删除查账征收年报投资者明细数据
            this.deleteCzzsnbtzzmxsj(conn, orManager, czzsnbtzzsjmxList);
            // 再删除查账征收年报投资者数据
            this.deleteCzzsnbtzzsj(conn, orManager, czzsnbtzzList);
            // 然后删除查账征收年报企业数据
            this.deleteCzzsnbqysj(conn, orManager, czzsnbqyList);
            // 最后删除查账征收年报主表数据
            this.deleteCzzsnbzbsj(conn, orManager, czzsnbzb);
        } catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex);
        } finally
        {
            DBResource.destroyConnection(conn);
        }
        //构造返回数据
        return retMap;
    }

    /**
     * 返回已填充数值的查帐征收年报主数据
     * @param djMap 登记数据
     * @param jsjdm 计算机代码
     * @param year 年份
     *
     * @return 查帐征收年报主数据
     */
    private Czzsnbzb newInstanceCzzsnbzb(Map djMap, String jsjdm, String year)
    {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        SWDJJBSJ dj = (SWDJJBSJ)djMap.get(CzzsndMapConstant.JBSJ);
        Czzsnbzb czzsnbzb = new Czzsnbzb();
        czzsnbzb.setJsjdm(jsjdm);
        czzsnbzb.setCjrq(now);
        czzsnbzb.setLrrq(now);
        czzsnbzb.setLrr(userData.yhid);
        czzsnbzb.setLrr(jsjdm);
        czzsnbzb.setSwjgzzjgdm(dj.getSwjgzzjgdm());
        czzsnbzb.setNd(year);
        Map skssrqMap = Skssrq.yearSkssrq(new Date());
        czzsnbzb.setSkssjsrq((Timestamp)skssrqMap.get(Skssrq.SKSSJSRQ));
        czzsnbzb.setSkssksrq((Timestamp)skssrqMap.get(Skssrq.SKSSKSRQ));
        czzsnbzb.setSbrq(TinyTools.second2Day(now));
        czzsnbzb.setQxdm(dj.getSwjgzzjgdm().substring(0, 2));

        return czzsnbzb;
    }

    /**
     * 返回已填充数值的企业数据
     * @param djMap 登记数据
     * @param jsjdm 计算机代码
     * @param year 年份
     * @return 企业申报数据
     */
    private List newInstanceCzzsnbqysbList(Map djMap, String jsjdm,
                                           String year)
    {
        List czzsnbqyList = new ArrayList(40);
        SWDJJBSJ dj = (SWDJJBSJ)djMap.get(CzzsndMapConstant.JBSJ);
        for(int i = 0; i < 40; i++)
        {
            Czzsnbqy czzsqy = new Czzsnbqy();
            if(i < 38){
                czzsqy.setHc(String.valueOf(i + 1));
            }else{
                czzsqy.setHc(String.valueOf(i + 11));
            }
            czzsqy.setJsjdm(jsjdm);
            czzsqy.setNd(year);
            czzsqy.setSwjgzzjgdm(dj.getSwjgzzjgdm());
            czzsqy.setBqljs(new BigDecimal(0.00));
            czzsnbqyList.add(czzsqy);
        }
        return czzsnbqyList;
    }

    /**
     * 返回已填充数值的投资者明细数据
     * @param djMap 登记数据
     * @param tzzList 投资者数据
     * @param jsjdm 计算机代码
     * @param year 年份
     * @return 投资者申报数据
     */
    private List newInstanceCzzsnbtzzsbmxList(Map djMap, List tzzList,
                                              String jsjdm, String year)
    {
        int size = tzzList.size();
        List czzsnbtzzmxList = new ArrayList(size);
        SWDJJBSJ dj = (SWDJJBSJ)djMap.get(CzzsndMapConstant.JBSJ);
        for(int i = 0; i < size; i++)
        {
            Tzf tzf = (Tzf)tzzList.get(i);
            List tzzsjmxList = new ArrayList();
            for(int j = 0; j < 10; j++){
                Czzsnbtzzmxsj czzsnbtzzsjmx = new Czzsnbtzzmxsj();
                if (j == 0) {
                    czzsnbtzzsjmx.setBqljs(tzf.getFpbl());
                }
                else {
                    czzsnbtzzsjmx.setBqljs(new BigDecimal(0.00));
                }
                czzsnbtzzsjmx.setHc(
                    String.valueOf(CzzsndMapConstant.INDEX_HC_TZZSJ + j));
                czzsnbtzzsjmx.setJsjdm(jsjdm);
                czzsnbtzzsjmx.setNd(year);
                czzsnbtzzsjmx.setZjhm(tzf.getZjhm());
                czzsnbtzzsjmx.setZjlxdm(tzf.getZjlxdm());
                czzsnbtzzsjmx.setSwjgzzjgdm(dj.getSwjgzzjgdm());
                tzzsjmxList.add(czzsnbtzzsjmx);
            }
            czzsnbtzzmxList.add(tzzsjmxList);
        }
        return czzsnbtzzmxList;
    }

    /**
     * 返回已填充数值的投资者数据
     * @param djMap 登记数据
     * @param tzzList 投资者数据
     * @param jsjdm 计算机代码
     * @param year 年份
     * @return 投资者申报数据
     */
    private List newInstanceCzzsnbtzzsbList(Map djMap, List tzzList,
                                            String jsjdm, String year)
    {
        int size = tzzList.size();
        List czzsnbtzzList = new ArrayList(size);
        SWDJJBSJ dj = (SWDJJBSJ)djMap.get(CzzsndMapConstant.JBSJ);
        for(int i = 0; i < size; i++)
        {
            Tzf tzf = (Tzf)tzzList.get(i);
            Czzsnbtzzsj czzsnbtzzsj = new Czzsnbtzzsj();
            czzsnbtzzsj.setJsjdm(jsjdm);
            czzsnbtzzsj.setNd(year);
            czzsnbtzzsj.setTzzxm(tzf.getTzfmc());
            czzsnbtzzsj.setZjhm(tzf.getZjhm());
            czzsnbtzzsj.setZjlxdm(tzf.getZjlxdm());
            czzsnbtzzsj.setSwjgzzjgdm(dj.getSwjgzzjgdm());
            czzsnbtzzList.add(czzsnbtzzsj);
        }
        return czzsnbtzzList;
    }

    /**
     * 返回已填充数值的分配比例数据
     * @param djMap 登记数据
     * @param tzzList 投资者数据
     * @param jsjdm 计算机代码
     * @param year 年份
     * @return 分配比例数据
     */
    private List newInstanceCzzsnbfpblList(Map djMap, List tzzList,
                                           String jsjdm, String year)
    {
        List czzsnbfpblList = new ArrayList(4);
        SWDJJBSJ dj = (SWDJJBSJ)djMap.get(CzzsndMapConstant.JBSJ);
        for(int i = 0; i < 4; i++)
        {
            Czzsnbfpbl czzsnbfpbl = new Czzsnbfpbl();
            czzsnbfpbl.setHc(String.valueOf(CzzsndMapConstant.INDEX_HC_FPBL + i));
            czzsnbfpbl.setJsjdm(jsjdm);
            czzsnbfpbl.setNd(year);
            czzsnbfpbl.setSwjgzzjgdm(dj.getSwjgzzjgdm());
            czzsnbfpbl.setBl(new BigDecimal(0.00));
            czzsnbfpbl.setBqljs(new BigDecimal(0.00));
            czzsnbfpbl.setQxdm(dj.getSwjgzzjgdm().substring(0, 2));
            czzsnbfpblList.add(czzsnbfpbl);
        }
        return czzsnbfpblList;
    }

    /**
     * 查询查账征收年度主表数据
     * @param conn         数据库连接对象
     * @param orManager    OR实例
     * @param jsjdm        计算机代码
     * @param nd           年度
     * @param swjgzzjgdm   税务机关组织机构代码
     * @return             List
     * @throws BaseException
     */
    private List queryCzzsndzb(Connection conn,
                               ORManager orManager,
                               String jsjdm,
                               String nd,
                               String swjgzzjgdm)
        throws BaseException
    {
        List result = null;
        try
        {
            Vector v = new Vector();

            v.add("jsjdm = '" + jsjdm + "'");
            v.add("nd= '" + nd + "'");
            v.add("fsdm= '" + CodeConstant.FSDM_WSSB + "'");
            v.add("qxdm = '" + swjgzzjgdm.substring(0, 2) + "'");

            ORContext czzsndzbContext = new ORContext(Czzsnbzb.class.getName(), v);
            result = orManager.query(SESSIONID, conn, czzsndzbContext);
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "查询查账征收年度主表数据失败");
        }
        return result;
    }

    /**
     * 查询查账征收年报企业数据
     * @param conn         数据库连接对象
     * @param orManager    OR实例
     * @param jsjdm        计算机代码
     * @param nd           年度
     * @return             List
     * @throws BaseException
     */
    private List queryCzzsqysj(Connection conn,
                               ORManager orManager,
                               String jsjdm,
                               String nd,
                               String swjgzzjgdm)
        throws BaseException
    {
        List result = null;
        try
        {
            Vector v = new Vector();

            v.add("jsjdm = '" + jsjdm + "'");
            v.add("qxdm = '" + swjgzzjgdm.substring(0, 2) + "'");
            v.add("nd= '" + nd + "' ORDER BY to_number(HC)");

            ORContext czzsnbqyContext = new ORContext(Czzsnbqy.class.getName(), v);
            result = orManager.query(SESSIONID, conn, czzsnbqyContext);
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "查询查账征收年度企业数据错误");
        }
        return result;
    }

    /**
     * 查询查账征收年报投资者数据
     * @param conn         数据库连接对象
     * @param orManager    OR实例
     * @param jsjdm        计算机代码
     * @param nd           年度
     * @return             List
     * @throws BaseException
     */
    private List queryCzzsnbtzzsj(Connection conn, ORManager orManager,
                                  String jsjdm, String nd, String swjgzzjgdm)
        throws BaseException
    {
        List result = null;
        try
        {
            Vector v = new Vector();

            v.add("jsjdm = '" + jsjdm + "'");
            v.add("qxdm = '" + swjgzzjgdm.substring(0, 2) + "'");
            v.add("nd= '" + nd + "' ORDER BY ZJHM, ZJLXDM");

            ORContext czzsnbtzzsjContext = new ORContext(Czzsnbtzzsj.class.
                getName(), v);
            result = orManager.query(SESSIONID, conn, czzsnbtzzsjContext);
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "查询查账征收年度投资者数据错误");
        }
        return result;
    }

    /**
     * 查询查账征收年报投资者明细数据
     * @param conn         数据库连接对象
     * @param orManager    OR实例
     * @param jsjdm        计算机代码
     * @param nd           年度
     * @return             List
     * @throws BaseException
     */
    private List queryCzzsnbtzzmxsj(Connection conn,
                                    ORManager orManager,
                                    String jsjdm,
                                    String nd,
                                    String swjgzzjgdm)
        throws BaseException
    {
        List result = null;
        try
        {
            Vector v = new Vector();

            v.add("jsjdm = '" + jsjdm + "'");
            v.add("qxdm = '" + swjgzzjgdm.substring(0, 2) + "'");
            v.add("nd= '" + nd + "' ORDER BY ZJHM, ZJLXDM, TO_NUMBER(HC)");

            ORContext czzsnbtzzmxsjContext = new ORContext(Czzsnbtzzmxsj.class.getName(), v);
            result = orManager.query(SESSIONID, conn, czzsnbtzzmxsjContext);
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "查询查账征收年度投资者明细数据错误");
        }
        return result;
    }

    /**
     * 查询查账征收年报分配比例数据
     * @param conn         数据库连接对象
     * @param orManager    OR实例
     * @param jsjdm        计算机代码
     * @param nd           年度
     * @return             List
     * @throws BaseException
     */
    private List queryCzzsnbfpblsj(Connection conn,
                                   ORManager orManager,
                                   String jsjdm,
                                   String nd,
                                   String swjgzzjgdm)
        throws BaseException
    {
        List result = null;
        try
        {
            Vector v = new Vector();

            v.add("jsjdm = '" + jsjdm + "'");
            v.add("qxdm = '" + swjgzzjgdm.substring(0, 2) + "'");
            v.add("nd= '" + nd + "' ORDER BY to_number(HC)");

            ORContext czzsnbfpblContext = new ORContext(Czzsnbfpbl.class.getName(), v);
            result = orManager.query(SESSIONID, conn, czzsnbfpblContext);
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "查询查账征收年度分配比率数据错误");
        }
        return result;
    }

    /**
     * 删除查账征收年报主表数据
     * @param conn 数据库连接
     * @param orManager ORManager的实例
     * @param czzsnbzb 年报主表
     * @throws BaseException 异常
     */
    private void deleteCzzsnbzbsj(Connection conn, ORManager orManager, Czzsnbzb czzsnbzb)
        throws BaseException
    {
        try
        {
            orManager.deleteObject(SESSIONID, conn, czzsnbzb);
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "删除查账征收年报主表数据错误");
        }
    }

    /**
     * 删除查账征收年报企业数据
     * @param conn 数据库连接
     * @param orManager ORManager的实例
     * @param czzsnbqyList 企业数据
     * @throws BaseException 异常
     */
    private void deleteCzzsnbqysj(Connection conn,
                                  ORManager orManager,
                                  List czzsnbqyList)
        throws BaseException
    {
        try
        {
            for(int i = 0; i < czzsnbqyList.size(); i++)
            {
                orManager.deleteObject(SESSIONID, conn, czzsnbqyList.get(i));
            }
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "删除查账征收年报企业数据错误");
        }
    }

    /**
     * 删除查账征收年报投资者数据
     * @param conn 数据库连接
     * @param orManager ORManager的实例
     * @param czzsnbtzzmxList 投资者数据
     * @throws BaseException 异常
     */
    private void deleteCzzsnbtzzmxsj(Connection conn,
                                     ORManager orManager,
                                     List czzsnbtzzmxList)
        throws BaseException
    {
        try
        {
            for(int i = 0, size = czzsnbtzzmxList.size(); i < size; i++)
            {
                List innerList = (List)czzsnbtzzmxList.get(i);
                for(int j = 0, jSize = innerList.size(); j < jSize; j++)
                {
                    orManager.deleteObject(SESSIONID, conn, innerList.get(j));
                }
            }
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "删除查账征收年报投资者明细数据错误");
        }
    }

    /**
     * 删除查账征收年报投资者数据
     * @param conn 数据库连接
     * @param orManager ORManager的实例
     * @param czzsnbtzzList 投资者数据
     * @throws BaseException 异常
     */
    private void deleteCzzsnbtzzsj(Connection conn, ORManager orManager,
                                   List czzsnbtzzList) throws BaseException
    {
        try
        {
            for(int i = 0; i < czzsnbtzzList.size(); i++)
            {
                orManager.deleteObject(SESSIONID, conn, czzsnbtzzList.get(i));
            }
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "删除查账征收年报投资者数据错误");
        }
    }

    /**
     * 删除查账征收年报分配比率数据
     * @param conn 数据库连接
     * @param orManager ORManager的实例
     * @param czzsnbfpblList 分配比例数据
     * @throws BaseException 异常
     */
    private void deleteCzzsnbfpblsj(Connection conn, ORManager orManager, List czzsnbfpblList)
        throws BaseException
    {
        try
        {
            for(int i = 0, size = czzsnbfpblList.size(); i < size; i++)
            {
                orManager.deleteObject(SESSIONID, conn,
                                       (Czzsnbfpbl)czzsnbfpblList.get(i));
            }
        }
        catch(Exception ex)
        {
            throw ExceptionUtil.getBaseException(ex, "删除查账征收年报投资者数据错误");
        }
    }
}