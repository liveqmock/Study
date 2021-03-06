<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/ttsoft-html.tld" prefix="ttsoft"%>
<%@ page import="com.ttsoft.bjtax.smsb.gdzys.jmsgl.web.GdzysJmscxForm"%>
<%@ page import="java.util.*" %>
<%
	String static_contextpath = com.ttsoft.common.util.ResourceLocator
			.getStaticFilePath(request);
%>

<html>
<head>
<title>减免税证明打印</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
</head>
<%
	String jmszmbh = ((GdzysJmscxForm) request
			.getAttribute("gdzysJmscxForm")).getJmszmbh();
	System.out.println(jmszmbh + "##########测试打印");
	String sbxlh = ((GdzysJmscxForm) request
			.getAttribute("gdzysJmscxForm")).getSbxlh();
%>

<body>
	<html:form action="/webapp/smsb/gdzys/gdzysJmszmPrintAction.do"
		method="POST">
		
		<applet name="Vprinter"
			code="com.ttsoft.bjtax.webprint.GDZYSJMSPrinter" width="1" height="1"
			archive="<%=static_contextpath%>/printer/vprinter.jar"></applet>
			  
		<html:hidden property="actionType" value="Query"/>

		<html:hidden property="sbxlh" value="<%=sbxlh%>" />
		<html:hidden property="jmszmbh" value="<%=jmszmbh%>" />
		<table width="1000" align="center">

			<logic:iterate id="jmszmlist" name="gdzysJmscxForm"
				property="jmszmList">
				<bean:define id="xxx" name="jmszmlist"/>
				<tr>
					<div align="center">
						<font size="5"><ttsoft:write name="jmszmlist"
								property="swjgmc" /></font>
					</div>
				</tr>
				<tr align="center">
					<div align="center">
						<font size="6">耕地占用税减免税证明</font>
					</div>
				</tr>
				<tr align="center">
					<div align="center">
						<font size="5"><ttsoft:write name="jmszmlist"
								property="jmszmbh" />号</font>
					</div>
					<br>
				</tr>
				<tr align="center">
					<div align="left">
						<ttsoft:write name="jmszmlist" property="nsrmc" />
						（税务计算机代码：
						<ttsoft:write name="jmszmlist" property="jsjdm" />
						）
					</div>
					<br> &nbsp;&nbsp;&nbsp;&nbsp;
					<%
						List list=(ArrayList)(((HashMap)xxx).get("jmyjlist"));
					StringBuffer sb= new StringBuffer("");
					for(int i=0;i<list.size();i++){
						String text=(String)list.get(i);
						sb.append(text);
						if((i+1)<list.size()){
							sb.append(",");
						}
					}
						%>
						根据<%=sb.toString() %>的规定，经审核，同意免征你单位耕地占用税
					<ttsoft:write name="jmszmlist" property="jmse" />
					元， 免税面积为
					<ttsoft:write name="jmszmlist" property="jmmj" />
					平方米。（计征税额为
					<ttsoft:write name="jmszmlist" property="jzse" />
					元，计征面积为
					<ttsoft:write name="jmszmlist" property="jsmj" />
					平方米。
					<ttsoft:write name="jmszmlist" property="pzjdwh" />
					）
				</tr>
				<br>
				<br>
				<br>
				<tr align="right">
					<div align="right">
						税务机关（签章）<br>
						<ttsoft:write name="jmszmlist" property="year" />
						年
						<ttsoft:write name="jmszmlist" property="month" />
						月
						<ttsoft:write name="jmszmlist" property="day" />
						日
					</div>
				</tr>
				<br>
				<br>
				<br>
		</table>
		</div>
		</tr>
		</logic:iterate>
		</table>
		<br>
		<div id="dayin" align="center">
			<img style="cursor: hand" onclick="printTab()"
				src="<%=static_contextpath%>/images/dayin1.jpg" width="79"
				height="22" id="dayin1" />&nbsp;&nbsp;<img style="cursor: hand"
				onclick="window.close()"
				src="<%=static_contextpath%>/images/guanbi1.jpg" width="79"
				height="22" id="guanbi" />
		</div>

	</html:form>
</body>
<SCRIPT LANGUAGE="JavaScript">
	function printTab() {
		if (!window.confirm("即将进行打印减免税证明，是否确认？")) {
			window.close();
			return false;
		} else {
			if(document.Vprinter.readyState==4){
				document.Vprinter.startPrint();
				document.forms[0].submit();
			}else{
				alert("打印控件未成功加载，无法进行打印！");
				return false;
			}
			return false;
		}
	}
	
<logic:iterate id="jmszmlist" name="gdzysJmscxForm" property="jmszmList">
 	<bean:define id="ccc" name="jmszmlist" />
 
	document.Vprinter
			.setDq('<ttsoft:write name="jmszmlist" property="swjgmc"/>');
	document.Vprinter
			.setJmszmbh('<ttsoft:write name="jmszmlist" property="jmszmbh"/>号');
	document.Vprinter
			.setNsrmc('<ttsoft:write name="jmszmlist" property="nsrmc"/>');
	document.Vprinter
			.setJsjdm('<ttsoft:write name="jmszmlist" property="jsjdm"/>');
	<%
	List mlist=(ArrayList)(((HashMap)ccc).get("jmyjlist"));
     StringBuffer msb= new StringBuffer("");
       for(int i=0;i<mlist.size();i++){
			String text=(String)mlist.get(i);
			msb.append(text);
			if((i+1)<mlist.size()){
			msb.append(",");
		}
	}
	%>
	
	document.Vprinter
			.setYj('<%=msb.toString() %>');
	document.Vprinter
			.setGdzys('<ttsoft:write name="jmszmlist" property="jmse"/>');
	document.Vprinter
			.setMzmj('<ttsoft:write name="jmszmlist" property="jmmj"/>');
	document.Vprinter
			.setJsje('<ttsoft:write name="jmszmlist" property="jzse"/>');
	document.Vprinter
			.setJsmj('<ttsoft:write name="jmszmlist" property="jsmj"/>');
	document.Vprinter
			.setPzzdwh('<ttsoft:write name="jmszmlist" property="pzjdwh" />');
	document.Vprinter
			.setYear('<ttsoft:write name="jmszmlist" property="year"/>');
	document.Vprinter
			.setMonth('<ttsoft:write name="jmszmlist" property="month"/>');
	document.Vprinter.setDay('<ttsoft:write name="jmszmlist" property="day"/>');
	//document.Vprinter.setCopies(3);

	</logic:iterate>

	//标题
</script>

</html>
