<%@page contentType="text/html; charset=GBK"%>
<%@ include file="/include/include.jsp"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@page import="com.creationstar.bjtax.qsgl.util.Constants"%>
<%@page import="com.creationstar.bjtax.qsgl.VisionLogic.form.BzqsForm"%>
<HTML><HEAD><TITLE>不征契税非个人信息显示表</TITLE>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>


<SCRIPT language=JavaScript>
function checkSubmit(operationType)
{

	document.forms[0].operationType.value=operationType;
	if(operationType=="Print" )
	{

			sbbh = document.forms[0].sbbh.value;
			window.open("/qsgl/qssb/printSbxx.do?sbbh="+sbbh,"print","toolbar=no,location=yes,status=no,menubar=yes,scrollbars=yes,resizable=yes,width=640,height=480");
  }
  if(operationType=="Return")
  {
  	document.forms[0].operationType.value="ReturnPri"
  	document.forms[0].submit();
  }

}

function doPrintHdtzs()
{
    window.open("/qsgl/qssb/printHdtzs.do?sbbh="+document.forms[0].sbbh.value,"print","toolbar=no,location=yes,status=no,menubar=yes,scrollbars=yes,resizable=yes,width=640,height=480");
}


</SCRIPT>
<!----本页面的头文件和本页帮助的路径----->
<SCRIPT language=javascript src="<%=static_file%>js/Header.js"></SCRIPT>

<SCRIPT language=JavaScript src="<%=static_file%>js/swapImage.js" type=text/JavaScript></SCRIPT>
<LINK href="<%=static_file%>css/text.css" rel=stylesheet type=text/css>
<META content="MSHTML 5.00.2919.6307" name=GENERATOR></HEAD>
<BODY bgColor=#ffffff leftMargin=0 style="MARGIN: 0px" topMargin=0 marginheight="0" marginwidth="0">
<jsp:include page="/include/Header.jsp" flush="true">
 <jsp:param name="subtitle" value="不征契税录入>不征契税非个人信息显示表"/>
 <jsp:param name="helpURL" value=""/>
</jsp:include>

 <TABLE align=center border=0 cellPadding=0 cellSpacing=0 height="100%" width=770>
  <TBODY>
  <TR>
    <TD vAlign=top>

         <TABLE align=center cellSpacing=0 class=table-99>
        <TBODY>
        <TR>
          <TD class=1-td1>北京市地方税务局不征契税信息采集表-非个人</TD></TR>
        <TR>
          <TD class=1-td2 vAlign=top>
          <html:form action="/bzqslr/addBzqsFgr.do">
              <html:hidden property="operationType" value=""/>
              <html:hidden property="ztbs" />
              <html:hidden property="yhbs" />
            	<html:hidden property="sbbh"/>


           <TABLE border=0 cellSpacing=0 class=tabled-99 width="99%">
              <TBODY>
			  <BR>
			  <TR>
			  	<TD class=2-td2-t-left width="20%">不征契税信息采集表号</TD>
			  	<TD class=2-td2-t-left width="80%" colspan=5><DIV align=left>&nbsp;<bean:write name="bzqsForm" property="sbbh" /> </DIV></TD>

			  </TR>
			  <TR>

				<TD class=2-td2-left>房屋土地管理部门受理号</TD>
				<TD class=2-td2-left>
				<DIV align=left>&nbsp;<bean:write name="bzqsForm" property="fwtdbmslh" /> </DIV></TD>
			<!--20081125 modify by fujx ,增加建委业务编号字段开始-->
                <TD class=2-td2-left>建委业务编号</TD>
                <TD class=2-td2-left>
                    <DIV align=left>&nbsp;
                        <bean:write name="bzqsForm" property="jwywbh" />
                     </DIV></TD>
                                            <!--20081125 modify by fujx ,增加建委业务编号字段结束-->
                                            <!--20081125 modify by fujx ,增加合同编号字段开始-->
                <TD class=2-td2-left>合同编号</TD>
                <TD class=2-td2-center>
                    <DIV align=left>&nbsp;
                        <bean:write name="bzqsForm" property="htbh" />
                     </DIV></TD>
                                            <!--20081125 modify by fujx ,增加合同编号字段结束-->
            </TR>
			  </TBODY>
			  </TABLE>


            <TABLE border=0 cellSpacing=0 class=tabled-99 width="99%">
              <TBODY>

              <TR>
                <TD class=2-td2-t-left width="8%" rowspan = "5">
                  <DIV align=right>非个人填</DIV>
                   <DIV align=right>写部分</DIV></TD>




              </tr>

              <tr>

                 <TD class=2-td2-t-left width="18%">
                   <DIV align=right>纳税计算机代码&nbsp; </DIV>
                </TD>

                <DIV align=right>&nbsp; </DIV>
                  <TD class=2-td2-t-left width="18%">
                    <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="jsjdm" />
                     </DIV></TD>



                <TD class=2-td2-t-left width="19%">
                  <DIV align=right>申请人类型&nbsp; </DIV></TD>
                <TD colspan="2"  class=2-td2-t-center width="33%">
                   <DIV align=left>

&nbsp;<bean:write name="bzqsForm" property="nsrlxmc" />

                    </DIV></TD>
             </TR>



             <TR>
                <TD  class=2-td2-left >
                  <DIV align=right>申请人名称&nbsp;</DIV></TD>
                <TD colspan="4"  class=2-td2-center >
                   <DIV align=left style="word-break:break-all">
&nbsp;<bean:write name="bzqsForm" property="nsrmc" />
                   </DIV></TD>
                  </TR>

                  <TR>
                 <TD class=2-td2-left >
                   <DIV align=right>开户银行&nbsp; </DIV>
                </TD>
                <TD class=2-td2-center  colspan="4">
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="khyhmc" />
                   </DIV></TD>

                  </TR>


                  <TR>
                 <TD class=2-td2-left >
                   <DIV align=right>联系人姓名&nbsp; </DIV>
                </TD>
                 <TD class=2-td2-left >
                   <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="lxrxm" />
                   </DIV></TD>


                <TD   class=2-td2-left >
                  <DIV align=right>联系电话&nbsp;</DIV></TD>
                <TD colspan="2"  class=2-td2-center width="33%">
                   <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="lxdh" />
                  <FONT> </FONT> </DIV></TD>
                </TR>


                  <TR>
                   <TD class=2-td2-left rowspan = "6">
                  <DIV align=right>	土地房屋</DIV>
                   <DIV align=right>权属转移</DIV></TD>
                  <TD class=2-td2-left>
                   <DIV align=right style="word-break:break-all">房地产项目名称&nbsp;</DIV></TD>
                <TD colspan="4" class=2-td2-center nowrap>
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="fdcxmmc" />&nbsp;
                   </DIV></TD>
                  </TR>
                <TR>
                 <TD class=2-td2-left >
                   <DIV align=right>合约签订时间&nbsp; </DIV>
                </TD>
                 <TD class=2-td2-left >
                <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="hyqdsj" />   &nbsp;
                </DIV></TD>
                <TD class=2-td2-left >
                  <DIV align=right>分类&nbsp;</DIV></TD>
                <TD colspan="2"  class=2-td2-center >
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="flmc" /> &nbsp;

                    </DIV></TD>
                  </TR>
                 <TR>
                 <TD class=2-td2-left >
                   <DIV align=right>土地、房屋权属转移类型&nbsp; </DIV> </TD>
                 <TD class=2-td2-left >
                <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="tdfwqszylxmc" /> &nbsp;
                 </DIV></TD>
                <TD class=2-td2-left >
                  <DIV align=right>房屋类别&nbsp;</DIV></TD>
                <TD colspan="2"  class=2-td2-center >
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="fwlbmc" /> &nbsp;


                   </DIV></TD>
                  </TR>
                  <TR>
                 <TD  class=2-td2-left>
                   <DIV align=right>土地、房屋座落地址&nbsp; </DIV>
                </TD>
                <TD colspan="4"  class=2-td2-center >
                  <DIV align=left style="word-break:break-all">
&nbsp;<bean:write name="bzqsForm" property="tdfwzldz"/>   &nbsp;
									 </DIV></TD>
                  </TR>

                  <TR>
                 <TD class=2-td2-left>
                   <DIV align=right>土地、房屋权属转移面积&nbsp; </DIV>
                </TD>
                <TD  class=2-td2-left >
                   <DIV align=left>
&nbsp;土地：<bean:write name="bzqsForm" property="tdfwqszymj"/>   &nbsp;
                    ㎡ </DIV></TD>
                <TD class=2-td2-left >
                  <DIV align=right>房屋建筑面积&nbsp;</DIV></TD>
                <TD colspan="2"  class=2-td2-center>
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="fwjzmj"/> &nbsp;
                  ㎡</DIV></TD>
               </TR>

 <%
	BzqsForm bForm = (BzqsForm)session.getAttribute("bzqsForm");
	String rjl = bForm.getRjl();
    String tdjc = bForm.getTdjc();
 %>

                  <TR>
                 <TD class=2-td2-left>
                   <DIV align=right>容积率&nbsp; </DIV>
                </TD>
                <TD  class=2-td2-left >
                   <DIV align=left>
	 <%if(rjl.equals("00"))
	{
	%>
	1.0以下
	<%
	}
	if(rjl.equals("01"))
	{
	%>
	1.0以上含1.0
	<%
	}
	%>&nbsp;
                   </DIV></TD>
                <TD class=2-td2-left >
                    <!--修改土地级次为所属区域-->
                  <DIV align=right>所属区域&nbsp;</DIV></TD>
                <TD colspan="2"  class=2-td2-center>
                  <DIV align=left>
     <%if(tdjc.equals("00"))
	{
	%>
	&nbsp;
	<%
	}
    if(tdjc.equals("01"))
	{
	%>
	三环以内&nbsp;
	<%
	}
	if(tdjc.equals("02"))
	{
	%>
	三环至四环之间&nbsp;
	<%
	}
	%>
	<%if(tdjc.equals("03"))
	{
	%>
	四环至五环之间&nbsp;
	<%
	}
	if(tdjc.equals("04"))
	{
	%>
	五环以外&nbsp;
	<%
	}
	if(tdjc.equals("11"))
	{	
	%>
   	四环内北部地区&nbsp;
    <% 
	}
    if(tdjc.equals("12"))
	{	
	%>
   	四环内南部地区&nbsp;
    <% 
	}
    if(tdjc.equals("13"))
	{	
	%>
   	四环至五环北部地区&nbsp;
    <% 
	}
     if(tdjc.equals("14"))
	{	
	%>
   	四环至五环南部地区&nbsp;
    <% 
	}
    if(tdjc.equals("15"))
	{	
	%>
   	五环至六环北部地区&nbsp;
    <% 
	}
    if(tdjc.equals("16"))
	{	
	%>
   	五环至六环南部地区&nbsp;
    <% 
	}
    if(tdjc.equals("17"))
	{	
	%>
   	六环外地区&nbsp;
    <% 
	}
	//由于2014年10月北京普通住房标准调整，故作此需改为新标准：每平米价格上限、每套房屋价格、所在区域三方面调整 ，
	//此处只修改所在区域显示。modified by gaoyh to 20141020
	if(tdjc.equals("21"))
	{	
	%>
	  	5环内&nbsp;
	   <% 
	}
	   if(tdjc.equals("22"))
	{	
	%>
	  	5-6环&nbsp;
	   <% 
	}
	   if(tdjc.equals("23"))
	{	
	%>
	  	6环外&nbsp;
	   <% 
	}
	   %>
     
																&nbsp;
            </DIV></TD>
               </TR>

<%-- %>
                <TR>
                <TD class=2-td2-left  rowspan = "2">
                  <DIV align=right>成交</DIV>
                   <DIV align=right>价格</DIV>
                  <TD  class=2-td2-left >
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="cjjgyrmb"/>   &nbsp; <br>&nbsp;元(人民币) </DIV></TD>
                  <TD class=2-td2-left >
                  <DIV align=right>评估价格&nbsp; </DIV></TD>
                <TD  colspan="2"  class=2-td2-center >
                   <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="pgjg" />    &nbsp;   <br>&nbsp;元(人民币) </DIV></TD>
              </TR>

               <TR>
                 <TD class=2-td2-left  >
                   <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="cjjgywb" />      &nbsp; <br>&nbsp;元(外币) </DIV></TD>
                <TD class=2-td2-center  >
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="bzmc" />  &nbsp;<br>

                    <DIV align=left>&nbsp;汇率:
&nbsp;<bean:write name="bzqsForm" property="hn" />&nbsp;</DIV></TD>

                 <TD class=2-td2-center colspan="3" >
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="zhyrmb" />     &nbsp; <br>&nbsp;折合元(人民币) </DIV></TD>

				</tr>

<% --%>

                 <TR>
                 <TD class=2-td2-left >
                   <DIV align=right>备注&nbsp; </DIV>
                </TD>
                <TD colspan="5" class=2-td2-center >
                  <DIV align=left>
&nbsp;<bean:write name="bzqsForm" property="beizhu" />   &nbsp;

                  </DIV></TD>
                </TR>

                  </TBODY></TABLE><BR>

            <DIV align=center>

            <IMG alt=打印 height=22 id=baocun name=Submit63
            onclick="checkSubmit('Print')" onmouseout=MM_swapImgRestore()
            onmouseover="MM_swapImage('dayin','','<%=static_file%>images/dayin2.jpg',1)"
            src="<%=static_file%>images/dayin1.jpg" style="CURSOR: hand" width=79>


            <IMG alt=退出 height=22 id=tuichu name=tuichu
            onclick="checkSubmit('Return');" onmouseout=MM_swapImgRestore()
            onmouseover="MM_swapImage('tuichu','','<%=static_file%>images/tuichu2.jpg',1)"
            src="<%=static_file%>images/tuichu1.jpg" style="CURSOR: hand" width=79>
            </DIV><BR>

                                 </html:form>
<%@ include file="../include/Bottom.jsp" %>
</BODY></HTML>
