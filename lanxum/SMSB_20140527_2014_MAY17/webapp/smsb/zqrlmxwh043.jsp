<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/ttsoft-html.tld" prefix="ttsoft" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<%
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Expires", "0");
%>

<head>  
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<title>����������ϸ��Ϣά��</title>

<script language=JavaScript src="../js/treatImage.js"></script>
<script language=JavaScript src="../js/compute.js"></script>
<script language=JavaScript src="../js/smsb_common.js"></script>
<script language=JavaScript src="../js/function.js"></script>
<script language="JavaScript" type="text/JavaScript" src="../js/list.js"></script>
<link href="../css/text.css" rel="stylesheet" type="text/css">

</head>
<body>
<%@ include file="./include/header.jsp"%>

<html:form action="/webapp/smsb/zqrlmxwhAction.do" method="POST">
<html:hidden property="actionType" />
<html:hidden property="nd" />
<html:hidden property="djzclxdm" />
<html:hidden property="szsmdm" />
<html:hidden property="zqlxdm" />
<html:hidden property="zqqsrq" />

<html:hidden property="queryNd" />
<html:hidden property="queryDjzclx" />
<html:hidden property="querySz" />
<html:hidden property="queryZqlx" />
<html:hidden property="queryZqqsrq" />
<html:hidden property="queryMonth" />

<table width="100%" height="61%" border="0" cellpadding="0" cellspacing="0"  class='black9'>
  <tr>
    <td valign="top"> <br>
      <table  align="center" cellspacing="0" class="table-99" border="0">
        <tr class="black9">
          <td class="1-td1">����������ϸ��Ϣά��</td>
        </tr>
        <tr>
          <td valign="top" class="1-td2">
            <br>
            <div align="center">
             <table class="table-99" border="0" cellpadding="0" cellspacing="0">
              <tr>
               <td nowrap class="2-td1-left" width="20%">���</td>
               <td nowrap class="2-td2-t-left" width="30%"><bean:write name="zqrlmxwhForm" property="nd" /></td>
               <td nowrap class="2-td1-left" width="20%">��������</td>
               <td nowrap class="2-td2-t-center" width="30%"><bean:write name="zqrlmxwhForm" property="zqlxmc" /></td>
              </tr>
              <tr>
               <td nowrap class="2-td1-left" width="20%">˰��</td>
               <td nowrap class="2-td2-left" width="30%"><bean:write name="zqrlmxwhForm" property="szsmmc" /></td>
               <td nowrap class="2-td1-left" width="20%">�Ǽ�ע������</td>
               <td nowrap class="2-td2-center" width="30%"><bean:write name="zqrlmxwhForm" property="djzclxmc" /></td>
              </tr>
              <tr>
               <td nowrap class="2-td1-left" width="20%">˰��������ʼ����</td>
               <td nowrap class="2-td2-left" width="30%"><bean:write name="zqrlmxwhForm" property="zqssrqq" /></td>
               <td nowrap class="2-td1-left" width="20%">˰��������������</td>
               <td nowrap class="2-td2-center" width="30%"><bean:write name="zqrlmxwhForm" property="zqssrqz" /></td>
              </tr>
              <tr>
               <td nowrap class="2-td1-left" width="20%">���ڿ�ʼ����</td>
               <td nowrap class="2-td2-left" width="30%"><bean:write name="zqrlmxwhForm" property="zqqsrq" /></td>
               <td nowrap class="2-td1-left" width="20%">���ڽ�������</td>
               <td nowrap class="2-td2-center" width="30%"><html:text property="zqzzrq" size="15" /></td>
              </tr>
             </table>
             
            </div>
            <br>
            <div align="center">
              &nbsp;&nbsp;<input type="image" accesskey="s" tabIndex="-1" onclick="befSave('Save');return false;" style="cursor:hand"  onMouseOver="MM_swapImage('bc1','','<%=static_contextpath%>images/bc-s2.jpg',1)" onMouseOut="MM_swapImgRestore()" alt="����" id="bc1" src="<%=static_contextpath%>images/bc-s1.jpg" width="79" height="22" border="0">
              &nbsp;&nbsp;<input type="image" accesskey="f" tabIndex="-1" onclick="doSubmitForm('Back');return false;" style="cursor:hand"  onMouseOver="MM_swapImage('fh1','','<%=static_contextpath%>images/fh-f2.jpg',1)" onMouseOut="MM_swapImgRestore()" alt="����" id="fh1" src="<%=static_contextpath%>images/fh-f1.jpg" width="79" height="22" border="0">
              &nbsp;&nbsp;<input type="image" accesskey="c" tabIndex="-1" onClick="doSubmitForm('Return');return false;" style="cursor:hand" onMouseOver="MM_swapImage('tc1','','<%=static_contextpath%>images/tc-c2.jpg',1)" onMouseOut="MM_swapImgRestore()" alt="�˳�" id="tc1" src="<%=static_contextpath%>images/tc-c1.jpg" width="79" height="22" border="0">
              </div>
            <br> <br>
             </td>
        </tr>
      </table>
      <br></td>
    </tr>
</table>
</html:form>
<%@ include file="./include/footer.jsp"%>
</body>
<script language="javascript">


//����
function updateFunc(nd,sz,zqlx,dj,qsrq){
	if (dm!="" && rq!=""){
		document.forms[0].tempNd.value=nd;
		document.forms[0].tempSz.value=sz;
		document.forms[0].tempDjzclx.value=dj;
		document.forms[0].tempZqlx.value=zqlx;
		document.forms[0].tempZqqsrq.value=qsrq;
		
		//if (confirm("�ò�����ҳ����һ�е�����,�Ҳ����Զ��ָ�,��ȷ��")){
			document.forms[0].target="";
			document.forms[0].actionType.value="Update";
			document.forms[0].submit();
		//}
	}
}

function befSave(actType){
	if(!isFullDate(document.forms[0].zqzzrq.value,0,"1","")) {
		alert("���ڲ��Ϸ���");	
		document.forms[0].zqzzrq.select();
		return false;
	}
	else {
		doSubmitForm(actType);
		return false;
	}
}

function fnOnLoad(){
   document.forms[0].zqzzrq.focus();
}

fnOnLoad();

function isFullDate1(strDate,dateKind,empty,isThrow){
	var year,mon,days;
	var err = "";
	if(dateKind==0){//����8λ������
		err = "";

		if(strDate.length==0){
			  if(empty!=null){
					err="���ڱ��벻Ϊ��!\n";
				}
		}else{
			if(strDate.length!=8){
				err="���ڸ�ʽ����ȷ��������8λ����!\n";
			}else{
				var strYear = strDate.substr(0,4);
				var strMonth = strDate.substr(4,2);
				var strDay = strDate.substr(6,2);
				var objDate = new Date(strMonth+'-'+strDay+'-'+strYear);
				if (isNaN(objDate)){
					err="���ڸ�ʽ����ȷ!\n"
				}
				if(strYear*1<1900) {
					err="���ڸ�ʽ����ȷ!\n"
				}
				if ((strYear*1 != objDate.getYear()*1)&&(strYear*1 != objDate.getYear()*1+1900)) {
					err="���ڸ�ʽ����ȷ!\n"
				}
				if (strMonth*1 != objDate.getMonth()*1+1){
					err="���ڸ�ʽ����ȷ!\n"
				}
				if (strDay*1 != objDate.getDate()*1) {
					err="���ڸ�ʽ����ȷ!\n"
				} //don't call getDay function.
			}
		}
		/*if(err!=""){
			if(isThrow){
				alert(alertStr);
			}
			return false;
		}
		return true;*/
	}else if(dateKind==1){//4λ��
		err = "";
		if((strDate.charAt(0)=="0") || strDate.length!=4 || (!isDigit(strDate))){
			err = "���ǺϷ�����ݣ�";
		}
		//alert(err);
	}

	if(err!=""){
		if(isThrow){
			alert(err);
		}
		return false;
	}
	return true;
}
</script>

</html:html>