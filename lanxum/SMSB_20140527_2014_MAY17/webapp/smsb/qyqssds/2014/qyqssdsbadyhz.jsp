<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/ttsoft-html.tld" prefix="ttsoft"%>
<%@ page import="com.ttsoft.bjtax.smsb.sbzl.qyqssds2014.qyqssdsba.web.QyqssdsBaForm" %>
<%@ page import="com.ttsoft.bjtax.sfgl.common.db.util.SfResourceLocator"%>
<HTML>
<HEAD>
<TITLE>企业清算所得税事项备案回执</TITLE>

<style>
@media Print {
	.Noprn {
		DISPLAY: none
	}
}
</style>


<style type="text/css">

</style>
<object ID='wb' WIDTH=0 HEIGHT=0
	CLASSID='CLSID:8856F961-340A-11D0-A96B-00C04FD705A2'></object>
<object id='factory' style="display:none"   classid="clsid:1663ed61-23eb-11d2-b92f-008048fdd814" viewastext codebase="ScriptX.cab#Version=5,0,4,185">
     </object>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>

</HEAD>
	<%
		String static_contextpath = SfResourceLocator.getContextPath(request);
		com.ttsoft.bjtax.smsb.sbzl.qyqssds2014.qyqssdsba.web.QyqssdsBaForm form = (com.ttsoft.bjtax.smsb.sbzl.qyqssds2014.qyqssdsba.web.QyqssdsBaForm) request
				.getAttribute("qyqssdsBaForm2014");
		String nsrmc =form.getNsrmc();
	%>
<BODY bgColor=#ffffff leftMargin=0 style="MARGIN: 0px" topMargin=0
	marginheight="0" marginwidth="0">
	<!--startprint-->
	<table width="80%" border="0" align="center" cellspacing="0"
		class="table-99">
		
		<tr>
			<td colspan="15">
				<div align="center">
				<br><br>
				<h2>
					企业清算所得税事项备案回执
				</h2>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div align="left">
				<br><br>
				<font size="4">
					<U>
					<%=nsrmc%>:
					</U>
				</font>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div align="left">
				<font size="4">
				&nbsp;&nbsp;&nbsp;&nbsp;你单位《企业清算所得税事项备案表》及附送资料收悉。请你单位以整个清算期间作为一个纳税年度，依法计算清算所得及其应纳所得税，并自清算结束之日起15日内，向主管税务机关报送
				《中华人民共和国企业清算所得税纳税申报表》及其附表和附报资料，结清税款。
				</font>
				</div>
			</td>
		</tr>

		<tr>
			<td>
			<div align="right">
			<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
			<font size="4">
				税务机关（签章）<br><br>
				年 &nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;日&nbsp;<br><br><br>
			</font>	
			</div>
			</td>		
		</tr>
		<tr>
			<td>
			<div align="center">
				<font size="3">
				（本回执一式两份，一份返还纳税人，一份由主管税务机关留存。）
				</font>
			</div>
			</td>
		</tr>
	</table>
<!--endprint-->
	<div class="Noprn">
		<br>
	</div>
	<div id="dayin" align="center" class="Noprn"><br><br>
		<img alt="执行打印操作" style="cursor: hand" onclick="printHz()"
			src="<%=static_contextpath%>images/dayin1.jpg" width="79" height="22"
			id="dayin1" />&nbsp;&nbsp; <img alt="退出打印页面" style="cursor: hand"
			onclick="window.close()" src="<%=static_contextpath%>images/guanbi1.jpg"
			width="79" height="22" id="guanbi" />&nbsp;&nbsp;
	</div>
</BODY>
<script type="text/javascript">
	var HKEY_Root, HKEY_Path, HKEY_Key;
	HKEY_Root = "HKEY_CURRENT_USER";
	HKEY_Path = "\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
	//设置网页打印的页眉页脚为空    
	function PageSetup_Null() {
		try {
			var Wsh = new ActiveXObject("WScript.Shell");
			HKEY_Key = "header";
			Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");
			HKEY_Key = "footer";
			Wsh.RegWrite(HKEY_Root + HKEY_Path + HKEY_Key, "");
		} catch (e) {
		}
	}
	function printTab() {
		//document.all.dayin.style.display = "none";
 		//factory.printing.header = "" ;  
  
  		//factory.printing.footer = "";  
  
 		//factory.printing.portrait = false;  
  
  		//factory.printing.leftMargin =10.00;  
 
  		//factory.printing.topMargin =10.00;  
 
	  	//factory.printing.rightMargin =10.00;  
 		//factory.printing.bottomMargin =10.00; 
		
		//window.print();
	 PageSetup_Null();
     window.print();
		//document.all.dayin.style.display = "";
	}
	function printHz(){
		printTab();
//		if(confirm("您确定要打印第二份回执吗？")){
//			printTab();
//		}
	}

</script>
</HTML>
