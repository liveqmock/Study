<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page
	import="com.ttsoft.bjtax.smsb.sbzl.qysdsjb2014.web.HdzssdsjbForm"%>
<%@ page import="java.util.HashMap"%>

<html:html>
<head>
<!-- <link href="../../css/text.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript"
	src="../../js/treatImage.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../js/list.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../js/Stack.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../js/Bolan.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../js/MathString.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../js/smsb_common.js"></script>
<script language=JavaScript type="text/JavaScript"
	src="../../js/function.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../js/qysdsnew.js"></script> -->
<%--modify   20140828 --%>
<html:base/>
<link href="../../../css/text.css" rel="stylesheet" type="text/css">
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/treatImage.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/list.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/Stack.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/Bolan.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/MathString.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/smsb_common.js"></script>
<script language=JavaScript type="text/JavaScript"
	src="../../../js/function.js"></script>
<script language="JavaScript" type="text/JavaScript"
	src="../../../js/qysdsnew.js"></script>
<%--end   20140828--%>
<style>
input {
    font-size: 9pt;
    text-align: right;
}
.inputalignright{
    font-size: 9pt;
    text-align: right;
}
.inbright {
    font-size: 9pt;
    background :#F3F5F8;
	text-align: right;
    background-color: #F3F5F8;
    border: 0px;
}
</style>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0"
	marginheight="0" onLoad="doInit()">
<%@include file="../../include/header.jsp"%>
<html:form method="POST" action="/webapp/smsb/qysds/hdzssdsjb2014Action.do">
	<html:hidden property="actionType" />
	<html:hidden property="nsrsbh" />
	<html:hidden property="zgswjgzzjgmc" />
	<html:hidden property="swjgzzjgdm" />
	<html:hidden property="nsrmc" />
	<html:hidden property="lxdh" />
	<html:hidden property="jydz" />
	<html:hidden property="sknd" />
	<html:hidden property="qh" />
	<html:hidden property="bbqlx" />
	<html:hidden property="qxdm" />
	<html:hidden property="swjsjdm" />
	<html:hidden property="qyzslx" />
	<html:hidden property="cyl" />
	<html:hidden property="dezsse" />
	<html:hidden property="jmzg" />
	<html:hidden property="ybjmsl" />
	<html:hidden property="sysl" />
	<html:hidden property="zsfs"/>
	<html:hidden property="sfxkh"/>
	<html:hidden property="syndZsfsdm"/>
	<html:hidden property="syndZbh6"/>
	<html:hidden property="syndZbh25"/>
	<html:hidden property="syndFb5jyjg"/>
	<table width="96%" align="center" cellspacing="0" class="table-99"
		onkeydown="jsjdmQuery()">
		<tr>
			<td class="1-td1" colspan="7"> 
				�л����� ���͹�<br>��ҵ����˰��(��)��Ԥ����˰�걨��(B��)(2014��) 
			</td>
		</tr>

		<tr>
			<td class="1-td2" colspan="7"><br>
			<table cellspacing="0" class="table-99">

				<tr class="black9">
					<td align="center" nowrap>
					<div align="left">�걨���� <html:text property="sbrq" size="11"
						maxlength="8" readonly='true' style='text-align:right'
						onchange="checkZQ(this,document.forms[0].skssksrq,document.forms[0].skssjsrq,3)" /></div>
					</td>
					<td wigth="90%" align="center" nowrap>˰���������ڣ� <html:text property="skssksrq"
						size="15" maxlength="8"
						onchange="isDate(this,false);compareDate(this)"  style="text-align:left" /> �� <html:text
						property="skssjsrq" size="15" maxlength="8"
						onchange="isDate(this,false);compareDate(this)" style="text-align:left" /></td>
					<td align="right" nowrap>
					<div align="right">��λ�������Ԫ�������Ƿ֣�</div>
					</td>
				</tr>
			</table>
			<table class="table-99" border="0" cellpadding="0" cellspacing="0" width="80%">
				<tr>
					<td width="16%" nowrap class="2-td2-t-left"><div align="center">��˰�˵�˰���������&nbsp;</div></td>
					<td colspan="3" nowrap class="2-td2-t-center" align=left><div align="left">&nbsp;&nbsp;<html:text tabindex="1" property="jsjdm" maxlength="8" size="15" onChange="doQuery()" style="text-align:left"/></div></td>
				</tr>
				<TR>
					<td width="16%" nowrap class="2-td2-left"><div align="center">��˰��ʶ���&nbsp;</div></td>
					<td width="30%" nowrap class="2-td2-left" align=left>&nbsp;<bean:write name="hdzssdsjb2014Form"
						property="nsrsbh" scope="request" filter="true" /></td>
					<td width="16%" nowrap class="2-td2-left"><div align="center">��˰������&nbsp;</div></td>
					<td width="30%" nowrap class="2-td2-center" align=left>&nbsp; <bean:write
						name="hdzssdsjb2014Form" property="nsrmc" scope="request"
						filter="true" /> </td>
				</tr>
				
				<tr>
					<td width="16%" nowrap class="2-td2-left"><div align="center">ע���ʱ�����Ԫ��&nbsp;<input type="hidden" name="hc"
								value="16" id="hc_16"></div></td>
					<td width="30%" nowrap class="2-td2-left" align=left>
						<input tabindex='12' type='text' name='lje' id='16_1'  value='0.00' size='13' onblur="formate(this)" onchange="checkZczbje(this)">
					</td>
					<td width="16%" nowrap class="2-td2-left"><div align="center">�ʲ��ܶ��Ԫ��&nbsp;<input type="hidden" name="hc"
								value="17" id="hc_17"></div></td>
					<td width="30%" nowrap class="2-td2-center" align=left>
						<input tabindex='13' type='text' name='lje' id='17_1'  value='0.00' size='13' onblur="formate(this)" onchange="checkZcze(this)">
					</td>
				</tr>
				<tr>
					<td width="16%" nowrap class="2-td2-left"><div align="center">��ҵ����&nbsp;<input type="hidden" name="hc"
								value="18" id="hc_18"></div></td>
					<td width="30%" nowrap class="2-td2-left" align=left>
						<input tabindex='14' type='text' name='lje' id='18_1'  value='0' size='13' onblur="checkZgrs()">
					</td>
					<td width="16%" nowrap class="2-td2-left"><div align="center">������ҵ&nbsp;<input type="hidden" name="hc"
								value="19" id="hc_19"></div></td>
					<td width="30%" nowrap class="2-td2-center" align=left>
						<input  type="hidden" name='lje' id='19_1'  value='' size='13' >
								  <div style="font-size: 9pt; line-height: 26px; color: #3E6071; background-color: #F3F5F8; text-align: left;">
									<html:text property="sshy" size="6" tabindex='15' onchange="setSshy(this)"/>
					                
					                <bean:define id="dta" name="hdzssdsjb2014Form" property="gjbzhy"/>
			                  		<html:select property="gjbzhydm" style='width:190px' onchange="setSshy(this)">
			                  			<option>��ѡ��</option>
			                    		<html:options collection="dta" labelProperty="gjbzhymc" property="gjbzhydm"/>
			                  		</html:select>
					              </div>
					</td>
				</tr>
			</table>
			<br>

			<TABLE class="table-99" align="center">
				<TR>
					
            <TD> 
              <div id="Layer2" style="position:static;">
					
                <table id="wrklistTable" border="1" cellspacing="0"
						class="table-99" align="center">
                  <tr> 
                    <td colspan="3" nowrap class="2-td1-left"><div align="center">��Ŀ</div></td>
                    <td width="52" nowrap class="2-td1-left"><div align="center">�д�</div></td>
                    <td width="180" nowrap class="2-td1-center">�ۼƽ��</td>
                  </tr>
                  <tr>
                  <td colspan="5" nowrap class="2-td2-center"><div align="left"><B>һ�������ɰ�Ӧ˰�����ʼ���Ӧ������˰�����ҵ�</B></div></td>
                  </tr>
                  <tr> 
                    <td width="144" rowspan="9" nowrap class="2-td2-left">Ӧ��˰���ö�ļ���</td>
                    <td width="208" rowspan="6" nowrap class="2-td2-left">�������ܶ�˶�Ӧ��˰���ö�</td>
                    <td width="384" nowrap class="2-td2-left">�����ܶ�</td>
                    <td class="2-td2-left" nowrap><div align="center">1<input type="hidden" name="hc"
								value="1" id="hc_1"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='2' type='text' name='lje'
								id='1_1' style='text-align:right' value='0.00' size='13'
								onblur="formate(this)" onchange="compute_Row_1()"></td>
                  </tr>
                  
                  <tr> 
                    <td class="2-td2-left" nowrap>��������˰����</td>
                    <td class="2-td2-left" nowrap><div align="center">2<input type="hidden" name="hc"
								value="2" id="hc_2"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='3' type='text' name='lje'
								id='2_1' style='text-align:right' value='0.00' size='13'
								onblur="formate(this)" onchange="compute_Row_2()"></td>
                  </tr>                  
                  <tr> 
                    <td class="2-td2-left" nowrap>��˰����</td>
                    <td class="2-td2-left" nowrap><div align="center">3<input type="hidden" name="hc"
								value="3" id="hc_3"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='4' type='text' name='lje' 
								id='3_1' style='text-align:right' value='0.00' size='13'
								onblur="formate(this)" onchange="compute_Row_3()"></td>								
                  </tr>  
                  <tr> 
                    <td class="2-td2-left" nowrap>Ӧ˰����1��-2��-3�У�</td>
                    <td class="2-td2-left" nowrap><div align="center">4<input type="hidden" name="hc"
								value="4" id="hc_4"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='5' type='text' name='lje'
								class="text-gray" id='4_1' style='text-align:right'  readonly='true' value='0.00' size='13'></td>
                  </tr>

                    
                  <tr> 
                    <td class="2-td2-left" nowrap>˰����غ˶���Ӧ˰�����ʣ� %��</td>
                    <td class="2-td2-left" nowrap><div align="center">5<input type="hidden" name="hc"
								value="5" id="hc_5"></div></td>
                    <td class="2-td2-center" nowrap><input type='hidden' name='lje' value='0.00' id='5_1'><input tabindex='6' type='text' name='ljeView'
								id='5_1_1' style='text-align:right' readonly='true' class="text-gray" value='0.00' size='13'></td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap>Ӧ��˰���ö4�С�5�У�</td>
                    <td class="2-td2-left" nowrap><div align="center">6<input type="hidden" name="hc"
								value="6" id="hc_6"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='7' type='text' name='lje'
								class="text-gray" id='6_1' style='text-align:right'  readonly='true' value='0.00' size='13'></td>
                  </tr>
                  <tr> 
                    <td rowspan="3" nowrap class="2-td2-left">���ɱ����ú˶�Ӧ��˰���ö�</td>
                    <td class="2-td2-left" nowrap>�ɱ������ܶ�</td>
                    <td class="2-td2-left" nowrap><div align="center">7<input type="hidden" name="hc"
								value="7" id="hc_7"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='-1' type='text' name='lje'
								id='7_1'  value='*'  size='1' readonly='true'
								class='text-noborder' style="text-align:center"></td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap>˰����غ˶���Ӧ˰�����ʣ� %��</td>
                    <td class="2-td2-left" nowrap><div align="center">8<input type="hidden" name="hc"
								value="8" id="hc_8"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='-1' type='text' name='lje'
								id='8_1' value='*' size='1' readonly='true'
								class='text-noborder' style="text-align:center"></td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap>Ӧ��˰���ö�[7�С£�1��8�У���8��]</td>
                    <td class="2-td2-left" nowrap><div align="center">9<input type="hidden" name="hc"
								value="9" id="hc_9"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='-1' type='text' name='lje'
								id='9_1' value='*' size='1' readonly='true'
								class='text-noborder' style="text-align:center"></td>
                  </tr>
                  <tr> 
                    <td colspan="2" rowspan="2" nowrap class="2-td2-left">Ӧ������˰��ļ���</td>
                    <td class="2-td2-left" nowrap>˰�ʣ�25%��</td>
                    <td class="2-td2-left" nowrap><div align="center">10<input type="hidden" name="hc"
								value="10" id="hc_10"></div></td>
                    <td class="2-td2-center" nowrap><input type='hidden' name='lje' id='10_1' value='0.00'><input tabindex='8' type='text' name='ljeView'
								id='10_1_1' style='text-align:right' readonly='true' value='0.00' size='13'
								readonly='true' class="text-gray"></td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap>Ӧ������˰�6�С�10�У���9�С�10�У�</td>
                    <td class="2-td2-left" nowrap><div align="center">11<input type="hidden" name="hc"
								value="11" id="hc_11"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='9' type='text' name='lje'
								id='11_1' class="text-gray" style='text-align:right' readonly='true' value='0.00' size='13'
								onblur="formate(this)" onchange="compute_Row_11()"></td>
                  </tr>
                  <tr> 
                    <td colspan="2" rowspan="3" nowrap class="2-td2-left">Ӧ�����ˣ�����˰��ļ���</td>
                    <td class="2-td2-left" nowrap>��������������С��΢����ҵ��������˰��</td>
                    <td class="2-td2-left" nowrap><div align="center">12<input type="hidden" name="hc"
								value="12" id="hc_12"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='10' type='text' name='lje'
								id='12_1' style='text-align:right' onchange="compute_Row_12()"  value='0.00' size='13'
								onblur="formate(this)"  ></td>
                  </tr>                  
                  <tr>                     
                    <td class="2-td2-left" nowrap>��Ԥ������˰��</td>
                    <td class="2-td2-left" nowrap><div align="center">13<input type="hidden" name="hc"
								value="13" id="hc_13"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='10' type='text' name='lje'
								id='13_1' style='text-align:right' value='0.00' size='13'
								onblur="formate(this)" onchange="compute_Row_13()"></td>
                  </tr>                  
                  <tr> 
                    <td class="2-td2-left" nowrap>Ӧ�����ˣ�����˰�11��-12��-13�У�</td>
                    <td class="2-td2-left" nowrap><div align="center">14<input type="hidden" name="hc"
								value="14" id="hc_14"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='11' type='text' name='lje'
								id='14_1' style='text-align:right' readonly='true' value='0.00' size='13'
								readonly='true' class="text-gray" 
								onblur="formate(this)"></td>
                  </tr>
                  <tr>
                  <td colspan="5" nowrap class="2-td2-center"><div align="left"><B>����������˰����غ˶�Ӧ������˰�����ҵ�</B></div></td>
                  </tr>
                   <tr> 
                    <td colspan="3" rowspan="9" nowrap class="2-td2-left">˰����غ˶�Ӧ������˰��<br></td>                    
                    <td class="2-td2-left" nowrap><div align="center">15<input type="hidden" name="hc"
								value="15" id="hc_15"></div></td>
                    <td class="2-td2-center" nowrap><input tabindex='2' type='text' name='lje'
								id='15_1' style='text-align:right' value='0.00' size='13'
								onblur="formate(this)" onchange="compute_Row_15()"></td>
                  </tr>
                </table>
					</div>
					</TD>
				</TR>
				<BR>
				<TR class="black9">
					<TD>
					<div align="center">
					<input tabindex='-1' type="image" accesskey="q"
						onClick="doQuery();return false;"
						onMouseOver="MM_swapImage('chaxun','','<%=static_contextpath%>images/cx-q2.jpg ',1)"
						onMouseOut="MM_swapImgRestore()" value="��ѯ"
						src="<%=static_contextpath%>images/cx-q1.jpg " width="79"
						height="22" id="chaxun" style="cursor:hand">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input tabindex='-1'type="image" accesskey="u"
						style="cursor:hand" onClick="doReset();return false;"
						onMouseOver="MM_swapImage('qingchu','','<%=static_contextpath%>images/qc-u2.jpg',1)"
						onMouseOut="MM_swapImgRestore()"
						src="<%=static_contextpath%>images/qc-u1.jpg" name="Image13"
						width="79" height="22" border="0" id='qingchu'>
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input tabindex='-1' type="image" accesskey="s"
						style="cursor:hand" onClick="doSave();return false;"
						onMouseOver="MM_swapImage('baocun','','<%=static_contextpath%>images/bc-s2.jpg',1)"
						onMouseOut="MM_swapImgRestore()"
						src="<%=static_contextpath%>images/bc-s1.jpg" name="Image13"
						width="79" height="22" border="0" id='baocun'>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input tabindex='-1' type="image" accesskey="x"
						style="cursor:hand" onClick="doDelete();return false;"
						onMouseOver="MM_swapImage('shanchu','','<%=static_contextpath%>images/qbsc-x2.jpg',1)"
						onMouseOut="MM_swapImgRestore()"
						src="<%=static_contextpath%>images/qbsc-x1.jpg" name="Image13"
						width="79" height="22" border="0" id='shanchu'>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input tabindex='-1' type="image" accesskey="c"
						onClick="tuichu();return false;"
						onMouseOver="MM_swapImage('tc1','','<%=static_contextpath%>images/tc-c2.jpg',1)"
						onMouseOut="MM_swapImgRestore()" value="�˳�" id="tc1"
						src="<%=static_contextpath%>images/tc-c1.jpg" width="79"
						height="22" style="cursor:hand"></div>
					<BR>
					</TD>
				</TR>
			</TABLE>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
<%@ include file="../../include/footer.jsp"%>
<!--  
<table width="100%" height="33" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td background="<%=static_contextpath%>images/q-bottom-bg-01.jpg" height="9px" colspan="2" nowrap></td>
  </tr>
  <tr>
    <td nowrap><font size="2">&nbsp;&nbsp;&nbsp;* ����ʹ�� IE 5.5 ���ϣ��ֱ��� 800*600 �������վ</font></td>
    <td height="24" align="right"><img src="<%=static_contextpath%>images/q-bottom-tu-01.jpg" alt="�а쵥λ���廪ͬ�������ɷ����޹�˾2007_OCT24" width="184" height="24"></td>
  </tr>
</table>
-->
</html:form>
<script language="JavaScript">
	<%/*��ʼ��*/%>	
	function doInit()	
	{
	<%
	HdzssdsjbForm jbForm=(HdzssdsjbForm)request.getAttribute("hdzssdsjb2014Form");
	if (jbForm!=null && jbForm.getQysdsjbList()!=null && jbForm.getQysdsjbList().size()>0){
		for(int i=0;i<jbForm.getQysdsjbList().size();i++){
			HashMap map=(HashMap)jbForm.getQysdsjbList().get(i);
			int hc=Integer.parseInt((String)map.get("hc"));
			String lje=(String)map.get("lje");
			if(lje==null && lje.equals("")){
				lje="0.00";
			}
			%>
			
			obj = eval("document.getElementById('<%=hc%>_1')");

			obj.value = '<%=lje%>';
			<% 
		}
	}
	%>
		document.forms[0].jsjdm.focus();
		<%/*��ҵ��������*/%>
		var qyzslx=document.forms[0].qyzslx.value;
		if(qyzslx==3 || qyzslx == 2 || qyzslx == 5 ||qyzslx == 1){
			document.getElementById('1_1').focus();
			
			<%/*Ӧ˰������(�༴�������ʡ�)*/%>
			<%/*���õ�5��*/%>
			var cylValue = document.forms[0].cyl.value;
			

			
			var cylValue51 = document.getElementById('5_1').value;
			
			if(cylValue51=="null"||cylValue51==null||parseFloat(cylValue51)==0 || cylValue51==""){
				document.getElementById('5_1').value = Math.round(cylValue*100)/100;
				//formate(document.getElementById('5_1'));
			}
			
			var obj = document.getElementById('5_1_1');
			obj.readOnly=true;
			obj.className='text-gray';
			obj.value=Math.round(cylValue*10000)/100+"%";
			<%/*���õ�6��*/%>
			var obj = document.getElementById('6_1');
			obj.readOnly=true;
			obj.className='text-gray';
			<%/*���õ�10��*/%>
			document.getElementById('10_1').value="0.25";
			document.getElementById('10_1_1').value=parseFloat(document.getElementById('10_1').value)*100+"%";
			var obj = document.getElementById('10_1_1');
			obj.readOnly=true;
			obj.className='text-gray';
			
			
			
		}
		if(qyzslx ==4){
			document.getElementById('1_1').tabIndex="-1";
			document.getElementById('2_1').tabIndex="-1";
			document.getElementById('3_1').tabIndex="-1";
			document.getElementById('4_1').tabIndex="-1";
			document.getElementById('5_1_1').tabIndex="-1";	
			document.getElementById('6_1').tabIndex="-1";					
			document.getElementById('10_1_1').tabIndex="-1";
			document.getElementById('11_1').tabIndex="2";			
			document.getElementById('13_1').tabIndex="3";
			document.getElementById('14_1').tabIndex="4";
			<%/*��������*/%>
			var obj = document.getElementById('1_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.value='*';
			obj.style.cssText='text-align:center';
			var obj = document.getElementById('2_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.value='*';
			obj.style.cssText='text-align:center';			
			obj.onblur="";
			var obj = document.getElementById('3_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.value='*';
			obj.style.cssText='text-align:center';
			var obj = document.getElementById('4_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.value='*';
			obj.style.cssText='text-align:center';						
			var obj = document.getElementById('5_1_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.value='*';
			obj.style.cssText='text-align:center';
			var obj = document.getElementById('6_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.value='*';
			obj.style.cssText='text-align:center';
			var obj = document.getElementById('10_1_1');
			obj.readOnly=true;
			obj.className='text-noborder';
			obj.style.cssText='text-align:center';
			obj.value='*';
			var obj= document.getElementById('11_1');
			obj.readOnly=false;
			obj.className='text-border';
			obj.focus();
		}
		
		var obj = document.getElementById('15_1');
		obj.readOnly=true;
		obj.className='text-noborder';
		obj.style.cssText='text-align:center';
		obj.value='*';


		//��������ҵ��ֵ
		var gjbzhydm=document.getElementById('19_1').value;
		var sshy=document.all.sshy.value;
		if(gjbzhydm!=null && gjbzhydm!=""&& gjbzhydm!="null"&& gjbzhydm!="0.00"&& gjbzhydm!="0.0"&& gjbzhydm!="0"){
			document.all.gjbzhydm.value=gjbzhydm;
			document.all.sshy.value=gjbzhydm;
		}else{
			document.all.gjbzhydm.value=sshy;
			document.getElementById('19_1').value=sshy;
		}	
		
		//ְ����������ΪС��
		if(document.getElementById("18_1").value=="0.00"){
			document.getElementById("18_1").value="0";	
		}
	}
		<%/*��Ӧ���������Ļس���ѯ*/%>
	function jsjdmQuery(){
		if(event.keyCode==13) event.keyCode = 9;
	}
	
	//modified by huohb,2014-07-31
	//�Թ���jsisNumJbCheck���а�װ����2014�꼾����Ҫ����������ֽ���У�飬��ֻ���롰-����������Զ���������NaN,������Ҫ�ȶԴ��������ֵ����У�飬Ȼ��ת�����ܽ��м���
	function isNumJbCheck(obj,minValue,maxValue,empty,totalLength, decimalLength){
		formate(obj);
		return isNum(obj,minValue,maxValue,empty,totalLength, decimalLength);
		
	}
	//����������������ʱ�Ľ���仯
	function setFoucs(num){
		if(document.forms[0].nsrmc.value==""){
			document.forms[0].jsjdm.focus();
		}else{
			document.getElementById(num+'_1').focus();
		}	
	}
		<%/*��ѯ*/%>
	function doQuery(){
		if(!checkBb()){
			return false;
		}
		var jsjdm;
		jsjdm = document.forms[0].jsjdm.value;
		if(jsjdm==""){
		    alert("��������벻�����ǿգ�");
		    return false;
	  	}else{
		    doSubmitForm("Query");
	    	return false;
	  	}
	}
	
	//���汾
	function checkBb(){
		if(parseInt(document.forms[0].skssjsrq.value)<=20140331){
			alert("������ʹ�õ���ҵ����˰�걨���汾�뵱ǰ��˰�������ڼ䲻������ѡ����ȷ����ҵ����˰�걨���汾��");
			return false;	
		}
		return true;
	}
	<%/*����*/%>
	function doSave()
	{
		if(document.forms[0].nsrmc.value==""){
			alert("������Ϣ����ȷ,����ʧ��,����������!");
			document.forms[0].jsjdm.focus();
			return false;
		}
		if(!checkBb()){
			return false;
		}
		<%/*��ҵ��˰����*/%>
		var qyzslx=document.forms[0].qyzslx.value;
		if(qyzslx==3 || qyzslx == 2 || qyzslx == 5 ||qyzslx == 1){
			if(!saveCheck(1,null))return false;
			if(!saveCheck(2,null))return false;
			if(!saveCheck(3,null))return false;
			if(!saveCheck(12,null))return false;
			
			if(parseFloat(document.getElementById('2_'+1).value)<0){
				alert("�ֵ�2������С���㣬��˶ԣ�");
				window.event.returnValue=false;
				document.getElementById('2_1').focus();
				document.getElementById('2_1').select();
				return false;
			}
			if(parseFloat(document.getElementById('3_'+1).value)<0){
				alert("�ֵ�3������С���㣬��˶ԣ�");
				window.event.returnValue=false;
				document.getElementById('3_1').focus();
				document.getElementById('3_1').select();
				return false;
			}
			
		}
		if(qyzslx==4){
			if(!saveCheck(11,null))return false;
			if(!saveCheck(12,null))return false;
			if(parseFloat(document.getElementById('11_'+1).value)<0){
				alert("�ֵ�11������С���㣬��˶ԣ�");
				window.event.returnValue=false;
				document.getElementById('11_1').focus();
				document.getElementById('11_1').select();
				return false;
			}
		}
		
		if(!checkedXwqysdse()){
			document.getElementById('12_1').focus();
			document.getElementById('12_1').select();
			return false;
		}
	
		if(!compareDate2Save(document.forms[0].skssjsrq))return false;
		
			if(parseFloat(document.getElementById('13_'+1).value)<0){
				alert("�ֵ�13������С���㣬��˶ԣ�");
				window.event.returnValue=false;
				document.getElementById('13_1').focus();
				document.getElementById('13_1').select();
				return false;
			}
		
		doSubmitForm('Save');
	
	}
	function checkedXwqysdse(){
		//����С΢��ҵ����˰��
		compute_xwqysdse();
		var value_12=document.getElementById('12_1').value;
		
//		if(value_12*1==0){
//			if(xwblts=="15"){
//				//alert("�����걨����ҵ��������С��΢����ҵ����������ҵ����˰�Ż����ߣ����ü���50������Ӧ��˰���ö��20%��˰�ʽ�����ҵ����˰��");
//				if(confirm("�����걨����ҵ��������С��΢����ҵ����������ҵ����˰�Ż����ߣ����ü���50������Ӧ��˰���ö��20%��˰�ʽ�����ҵ����˰���Ƿ����ܴ��Ż����ߣ����������걨���ݣ�")){
//					return true;
//				}else{
//					return false;
//				}
//			}else if(xwblts=="5"){
//				//alert("�����걨����ҵ��������С��΢����ҵ����˰�Ż����ߣ���20%��˰�ʽ�����ҵ����˰��");
//				if(confirm("�����걨����ҵ��������С��΢����ҵ����˰�Ż����ߣ���20%��˰�ʽ�����ҵ����˰���Ƿ����ܴ��Ż����ߣ����������걨���ݣ�")){
//					return true;
//				}else{
//					return false;
//				}
//			}
//		}
		if(inputValueTemp!=value_12){
			if(inputValueTemp=="0.00"){
				alert("����ҵ������С��΢����ҵ��������12�С���������������С��΢����ҵ��������˰�Ӧ��д0��");
				return false;
			}else{
				alert("����ҵ����С��΢����ҵ��������12�С���������������С��΢����ҵ��������˰�Ӧ���յ�6�С�Ӧ��˰���ö��"+xwblts+"%("+inputValueTemp+")������д��");
				return false;
			}
		}
		return true;
	}
	
		<%/*����ʱ�Ե�1��12�е����ݽ���У��*/%>
	function saveCheck(row,zero){
		
		if(!isNumJbCheck(document.getElementById(row+'_1'), zero, null, null, null, 2)){
			return false;			
		}
		return true;	
	}
			//�жϱȽ�˰����������
	function compareDate(obj){
		
		var strDate1 = document.forms[0].skssksrq.value;		
		var strYear1 = strDate1.substr(0,4);		
		var strMonth1 = strDate1.substr(4,2);
 	 	var strDay1 = strDate1.substr(6,2);
 	 	
 	 	var strDate2 = document.forms[0].skssjsrq.value;
 	 	var strYear2 = strDate2.substr(0,4);		
		var strMonth2 = strDate2.substr(4,2);
 	 	var strDay2 = strDate2.substr(6,2);
 	 	
 	 	var sksbrq = document.forms[0].sbrq.value;
 	 	var strYear3 = sksbrq.substr(0,4);		
		var strMonth3 = sksbrq.substr(4,2);
 	 	var strDay3 = sksbrq.substr(6,2); 
 	 	
  	var objDate1 = new Date(strMonth1+'-'+strDay1+'-'+strYear1);
  	var objDate2 = new Date(strMonth2+'-'+strDay2+'-'+strYear2);
  	var objDate3 = new Date(strMonth3+'-'+strDay3+'-'+strYear3);
  	
  	if(objDate2>objDate3){
  		alert("˰�����ʱ�䲻�ܴ����걨����");
  		window.event.returnValue=false;
			document.forms[0].skssjsrq.focus();
			document.forms[0].skssjsrq.select();
			return false;
  	}
  	  	
  		if(objDate1>=objDate2){
			if(obj == document.forms[0].skssjsrq){
				alert("˰�����ʱ�䲻��С�ڻ����˰�ʼʱ��");
			}else{
				alert("˰�ʼʱ�䲻�ܴ��ڻ����˰�����ʱ��");	
			}
			window.event.returnValue=false;
			obj.focus();
			obj.select();
			return false;
		}
		
		if(strYear1!=strYear2){
			alert("˰�ʼʱ����˰�����ʱ�����ݲ�ͬ��˰��ܿ��꣡");
			return false;				
		}
		
		if(strYear1<'2012'||strYear2<'2012'){
			alert("��˰���������걨�������������汾�걨��¼��");
			return false;				
		}		
		
	}
	
		<%/*�жϱȽ�˰����������*/%>
	function compareDate2Save(obj){
	
		var strDate1 = document.forms[0].skssksrq.value;		
		var strYear1 = strDate1.substr(0,4);		
		var strMonth1 = strDate1.substr(4,2);
 	 	var strDay1 = strDate1.substr(6,2);
 	 	
 	 	var strDate2 = document.forms[0].skssjsrq.value;
 	 	var strYear2 = strDate2.substr(0,4);		
		var strMonth2 = strDate2.substr(4,2);
 	 	var strDay2 = strDate2.substr(6,2);
 	 	
 	 	var sksbrq = document.forms[0].sbrq.value;
 	 	var strYear3 = sksbrq.substr(0,4);		
		var strMonth3 = sksbrq.substr(4,2);
 	 	var strDay3 = sksbrq.substr(6,2); 
 	 	
  	var objDate1 = new Date(strMonth1+'-'+strDay1+'-'+strYear1);
  	var objDate2 = new Date(strMonth2+'-'+strDay2+'-'+strYear2);
  	var objDate3 = new Date(strMonth3+'-'+strDay3+'-'+strYear3);
  	
  	if(objDate2>objDate3){
  		alert("˰�����ʱ�䲻�ܴ��ڵ�ǰ����");
  		window.event.returnValue=false;
			document.forms[0].skssjsrq.focus();
			document.forms[0].skssjsrq.select();
			return false;
  	}
  		if(objDate1>=objDate2){
			if(obj == document.forms[0].skssjsrq){
				alert("˰�����ʱ�䲻��С�ڻ����˰�ʼʱ��");
			}else{
				alert("˰�ʼʱ�䲻�ܴ��ڻ����˰�����ʱ��");	
			}
			window.event.returnValue=false;
			obj.focus();
			obj.select();
			return false;
		}
		
		if(strYear1!=strYear2){
			alert("˰�ʼʱ����˰�����ʱ�����ݲ�ͬ��˰��ܿ��꣡");
			window.event.returnValue=false;
			obj.focus();
			obj.select();
			return false;				
		}
		
		return true;
			
	}
	<%/*�����4,6,11,13������*/%>
	function compute_Row_1(){
		var ynssds;
		var yssre;
		var ybsds;
		
		
		 if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
		 				 document.getElementById('1_1').value ='0.00';                        
          }
		if(parseFloat(document.getElementById('1_'+1).value)<0){
			alert("�ֵ�1������С���㣬��˶ԣ�");
			window.event.returnValue=false;
			document.getElementById('1_1').focus();
			document.getElementById('1_1').select();
		}
		
		if(document.getElementById('1_'+1).value == null||document.getElementById('1_'+1).value == ""){
			document.getElementById('1_1').value ='0.00';
		}

		//����2������Ϊ�������Ҵ��ڵ�1������ʱ
		if((document.getElementById('2_'+1).value>0)&&(document.getElementById('2_'+1).value-document.getElementById('1_'+1).value)>0)
		{
			alert("�ֵ�2�����ݴ��ڵ�1�����ݣ���˶ԣ�");
		}
		
		//��3�С���˰���롱����Ϊ�������Ҵ��ڵ�1�м���2������ʱ
		if((document.getElementById('3_'+1).value>0)&&(document.getElementById('3_'+1).value-(document.getElementById('1_'+1).value-document.getElementById('2_'+1).value))>0)
		{
			alert("�ֵ�3�����ݴ��ڵ�1�м���2�����ݣ���˶ԣ�");
		}						

		yssre = Math.round((parseFloat(document.getElementById('1_'+1).value)-parseFloat(document.getElementById('2_'+1).value)-parseFloat(document.getElementById('3_'+1).value))*100)/100;
	
		document.getElementById('4_1').value = parseFloat(yssre);
		formate(document.getElementById('4_1'));


		if(document.getElementById('4_1').value>=0)
		{
		ynssds = Math.round((parseFloat(document.getElementById('4_'+1).value) * parseFloat(document.getElementById('5_'+1).value))*100)/100;

		document.getElementById('6_1').value = parseFloat(ynssds);
		formate(document.getElementById('6_1'));
		var ynsdse =Math.round((parseFloat(document.getElementById('6_'+1).value) * parseFloat(document.getElementById('10_'+1).value))*100)/100;
			
		document.getElementById('11_'+1).value = parseFloat(ynsdse);
		formate(document.getElementById('11_'+1));
		}
		else
		{
		document.getElementById('6_1').value = '0.00';
		formate(document.getElementById('6_1'));
			
		document.getElementById('11_'+1).value = '0.00';
		formate(document.getElementById('11_'+1));		
		}
		ybsds=Math.round((parseFloat(document.getElementById('11_'+1).value)-parseFloat(document.getElementById('12_'+1).value)-parseFloat(document.getElementById('13_'+1).value))*100)/100;
			if(ybsds>0){
				document.getElementById('14_'+1).value=parseFloat(ybsds);
				
			}
			else{
				document.getElementById('14_'+1).value='0.00';
			}
			formate(document.getElementById('14_1'));
			
			//compute_Row_12();
	}
	
	<%/*�����4,6,11,13������*/%>
	function compute_Row_2(){
		var ynssds;
		var yssre;
		var ybsds;
		 if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
		         document.getElementById('2_1').value ='0.00';              
          }
		if(parseFloat(document.getElementById('2_'+1).value)<0){
			alert("�ֵ�2������С���㣬��˶ԣ�");
			window.event.returnValue=false;
			document.getElementById('2_1').focus();
			document.getElementById('2_1').select();
		}
		
		if(document.getElementById('2_'+1).value == null||document.getElementById('2_'+1).value == ""){
			document.getElementById('2_1').value ='0.00';
		}
		
		//����2������Ϊ�������Ҵ��ڵ�1������ʱ
		if((document.getElementById('2_'+1).value>0)&&(document.getElementById('2_'+1).value-document.getElementById('1_'+1).value)>0)
		{
			alert("�ֵ�2�����ݴ��ڵ�1�����ݣ���˶ԣ�");
		}
		
		//��3�С���˰���롱����Ϊ�������Ҵ��ڵ�1�м���2������ʱ
		if((document.getElementById('3_'+1).value>0)&&(document.getElementById('3_'+1).value-(document.getElementById('1_'+1).value-document.getElementById('2_'+1).value))>0)
		{
			alert("�ֵ�3�����ݴ��ڵ�1�м���2�����ݣ���˶ԣ�");
		}				
		
		if(document.getElementById('2_1').value==""){
			yssre=0;	
		}
		else{
			yssre = Math.round((parseFloat(document.getElementById('1_'+1).value)-parseFloat(document.getElementById('2_'+1).value)-parseFloat(document.getElementById('3_'+1).value))*100)/100;
		}		
		document.getElementById('4_1').value = parseFloat(yssre);
		formate(document.getElementById('4_1'));


		if(document.getElementById('4_1').value>=0)
		{
		ynssds = Math.round((parseFloat(document.getElementById('4_'+1).value) * parseFloat(document.getElementById('5_'+1).value))*100)/100;

		document.getElementById('6_1').value = parseFloat(ynssds);
		formate(document.getElementById('6_1'));
		var ynsdse =Math.round((parseFloat(document.getElementById('6_'+1).value) * parseFloat(document.getElementById('10_'+1).value))*100)/100;
			
		document.getElementById('11_'+1).value = parseFloat(ynsdse);
		formate(document.getElementById('11_'+1));
		}
		else
		{
		document.getElementById('6_1').value = '0.00';
		formate(document.getElementById('6_1'));
			
		document.getElementById('11_'+1).value = '0.00';
		formate(document.getElementById('11_'+1));		
		}		
		ybsds=Math.round((parseFloat(document.getElementById('11_'+1).value)-parseFloat(document.getElementById('12_'+1).value)-parseFloat(document.getElementById('13_'+1).value))*100)/100;
			if(ybsds>0){
				document.getElementById('14_'+1).value=parseFloat(ybsds);
				
			}
			else{
				document.getElementById('14_'+1).value='0.00';
			}
			formate(document.getElementById('14_1'));
			
			//compute_Row_12();
	}	

	<%/*�����4,6,11,13������*/%>
	function compute_Row_3(){
		var ynssds;
		var yssre;
		var ybsds;
		 if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
		 				 document.getElementById('3_1').value ='0.00';
             return false;                         
          }
		if(parseFloat(document.getElementById('3_'+1).value)<0){
			alert("�ֵ�3������С���㣬��˶ԣ�");
			window.event.returnValue=false;
			document.getElementById('3_1').focus();
			document.getElementById('3_1').select();
		}

		if(document.getElementById('3_'+1).value == null||document.getElementById('3_'+1).value == ""){
			document.getElementById('3_1').value ='0.00';
		}

		//��3�С���˰���롱����Ϊ�������Ҵ��ڵ�1�м���2������ʱ
		if((document.getElementById('3_'+1).value>0)&&(document.getElementById('3_'+1).value-(document.getElementById('1_'+1).value-document.getElementById('2_'+1).value))>0)
		{
			alert("�ֵ�3�����ݴ��ڵ�1�м���2�����ݣ���˶ԣ�");
		}	
		
		if(document.getElementById('3_1').value==""){
			yssre=0;	
		}
		else{
			yssre = Math.round((parseFloat(document.getElementById('1_'+1).value)-parseFloat(document.getElementById('2_'+1).value)-parseFloat(document.getElementById('3_'+1).value))*100)/100;
		}		
		document.getElementById('4_1').value = parseFloat(yssre);
		formate(document.getElementById('4_1'));


		if(document.getElementById('4_1').value>=0)
		{				

		ynssds = Math.round((parseFloat(document.getElementById('4_'+1).value) * parseFloat(document.getElementById('5_'+1).value))*100)/100;

		document.getElementById('6_1').value = parseFloat(ynssds);
		formate(document.getElementById('6_1'));
		var ynsdse =Math.round((parseFloat(document.getElementById('6_'+1).value) * parseFloat(document.getElementById('10_'+1).value))*100)/100;
			
		document.getElementById('11_'+1).value = parseFloat(ynsdse);
		formate(document.getElementById('11_'+1));
		}
		else
		{
		document.getElementById('6_1').value = '0.00';
		formate(document.getElementById('6_1'));
			
		document.getElementById('11_'+1).value = '0.00';
		formate(document.getElementById('11_'+1));		
		}		
		ybsds=Math.round((parseFloat(document.getElementById('11_'+1).value)-parseFloat(document.getElementById('12_'+1).value)-parseFloat(document.getElementById('13_'+1).value))*100)/100;
			if(ybsds>0){
				document.getElementById('14_'+1).value=parseFloat(ybsds);
				
			}
			else{
				document.getElementById('14_'+1).value='0.00';
			}
			formate(document.getElementById('14_1'));
			
			//compute_Row_12();
	}
	

		<%/*��11�������ж�*/%>
	function compute_Row_11(){
		var ybsds;
		if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
						document.getElementById('11_1').value ='0.00';
             return false;                         
          }

		if(parseFloat(document.getElementById('11_'+1).value)<0){
			alert("�ֵ�11������С���㣬��˶ԣ�");
			window.event.returnValue=false;
			document.getElementById('11_1').focus();
			document.getElementById('11_1').select();
		}

		if(document.getElementById('11_'+1).value == null||document.getElementById('11_'+1).value == ""){
			document.getElementById('11_1').value ='0.00';
		}		
		
		
		ybsds=Math.round((parseFloat(document.getElementById('11_'+1).value)-parseFloat(document.getElementById('12_'+1).value)-parseFloat(document.getElementById('13_'+1).value))*100)/100;
			if(ybsds>0){
				document.getElementById('14_'+1).value=parseFloat(ybsds);
				
			}
			else{
				document.getElementById('14_'+1).value='0.00';
			}
			formate(document.getElementById('14_1'));
	}
	
	var inputValueTemp="0.00";
	var xwblts="0";
	<%/*��12�������ж�*/%>
	function compute_Row_12(){
		if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
			 document.getElementById('12_1').value ='0.00';                       
          }
        if(document.getElementById('12_'+1).value == null||document.getElementById('12_'+1).value == ""){
			document.getElementById('12_1').value ='0.00';
		}
        var obj_input=document.getElementById('12_1');
		
		var sfxkh=document.forms[0].sfxkh.value;
		var syndZsfsdm=document.forms[0].syndZsfsdm.value;
		var syndFb5jyjg=document.forms[0].syndFb5jyjg.value;
		//6��¼������
		var ynsdseStr=document.getElementById('6_1').value;;
		var syndZbh6Str=document.forms[0].syndZbh6.value;
		var syndZbh25Str=document.forms[0].syndZbh25.value;
		var ynsdse=0.00;
		var syndZbh6=0.00;
		var syndZbh25=0.00;
		if(ynsdseStr!=null && ynsdseStr!=""){
			ynsdse=1*ynsdseStr;
		}
		if(syndZbh6Str!=null && syndZbh6Str!=""){
			syndZbh6=1*syndZbh6Str;
		}
		if(syndZbh25Str!=null && syndZbh25Str!=""){
			syndZbh25=1*syndZbh25Str;
		}
		
		//alert("sfxkh: "+sfxkh);
		//alert("syndZsfsdm: "+syndZsfsdm);
		//alert("syndFb5jyjg: "+syndFb5jyjg);
		//alert("ynsdse: "+ynsdse);
		//alert("syndZbh6: "+syndZbh6);
		//alert("syndZbh25: "+syndZbh25);
		
		//modified by zhangj 2015.3.2
		var million=10*10000;
		var sknd=document.forms[0].sknd.value;
		var qh=document.forms[0].qh.value;
		if((sknd*1>2015)||(sknd*1==2015&&qh*1>=1)){			
			million=20*10000;//�����걨������Ϊ2015��1�����Ժ�ļ�����˰�걨����˰�ˣ�����1��6���ж���ϵ��ԭ�С�10����ж���׼�޸�Ϊ��20��Ԫ��
		}
		//modified by zhangj end 
		
		xwblts="0";
		if(ynsdse>30*10000 || ynsdse<=0){
			//obj_input.value="0.00";
			inputValueTemp="0.00";
		}else{
			if(sfxkh=="Y"){
				if(ynsdse<=million){
					//obj_input.value=(ynsdse*0.15).toFixed(2);
					inputValueTemp=(ynsdse*0.15).toFixed(2);
					//gyts("15");
					xwblts="15";
				}
				
				if(million<ynsdse&&ynsdse<=30*10000){
					//obj_input.value=(ynsdse*0.05).toFixed(2);
					inputValueTemp=(ynsdse*0.05).toFixed(2);
					//gyts("5");
					xwblts="5";
				}
				
				if(ynsdse>30*10000){
					//obj_input.value="0.00";
					inputValueTemp="0.00";
				}
			}else{
				 if(syndZsfsdm==<%=CodeConstant.ZSFSDM_CZZS%>){//��������
					if(1*syndZbh25>30*10000){
						//obj_input.value="0.00";
						inputValueTemp="0.00";
					}else{
						if(syndFb5jyjg=="Y"){
							if(ynsdse<=million && syndZbh25<=million){
								//obj_input.value=(ynsdse*0.15).toFixed(2);
								inputValueTemp=(ynsdse*0.15).toFixed(2);
								//gyts("15");
								xwblts="15";
							}else{
								//obj_input.value=(ynsdse*0.05).toFixed(2);
								inputValueTemp=(ynsdse*0.05).toFixed(2);
								//gyts("5");
								xwblts="5";
							}
						}else{
							//obj_input.value="0.00";
							inputValueTemp="0.00";
						}
					}
				}else{
					if(1*syndZbh6>30*10000){
						//obj_input.value="0.00";
						inputValueTemp="0.00";
					}else{
						if(ynsdse<=million && syndZbh6<=million){
							//obj_input.value=(ynsdse*0.15).toFixed(2);
							inputValueTemp=(ynsdse*0.15).toFixed(2);
							//gyts("15");
							xwblts="15";
						}else{
							//obj_input.value=(ynsdse*0.05).toFixed(2);
							inputValueTemp=(ynsdse*0.05).toFixed(2);
							//gyts("5");
							xwblts="5";
						}
					}
				}
			}
		}
		
		var ybsds=Math.round((parseFloat(document.getElementById('11_'+1).value)-parseFloat(document.getElementById('12_'+1).value)-parseFloat(document.getElementById('13_'+1).value))*100)/100;
			if(ybsds>0){
				document.getElementById('14_'+1).value=parseFloat(ybsds);
				
			}
			else{
				document.getElementById('14_'+1).value='0.00';
			}
			formate(document.getElementById('14_1'));
	}
	
	//����С΢��ҵ����˰˰��
	function compute_xwqysdse(){
		var sfxkh=document.forms[0].sfxkh.value;
		var syndZsfsdm=document.forms[0].syndZsfsdm.value;
		var syndFb5jyjg=document.forms[0].syndFb5jyjg.value;
		//6��¼������
		var ynsdseStr=document.getElementById('6_1').value;;
		var syndZbh6Str=document.forms[0].syndZbh6.value;
		var syndZbh25Str=document.forms[0].syndZbh25.value;
		var ynsdse=0.00;
		var syndZbh6=0.00;
		var syndZbh25=0.00;
		if(ynsdseStr!=null && ynsdseStr!=""){
			ynsdse=1*ynsdseStr;
		}
		if(syndZbh6Str!=null && syndZbh6Str!=""){
			syndZbh6=1*syndZbh6Str;
		}
		if(syndZbh25Str!=null && syndZbh25Str!=""){
			syndZbh25=1*syndZbh25Str;
		}
		
		//alert("sfxkh: "+sfxkh);
		//alert("syndZsfsdm: "+syndZsfsdm);
		//alert("syndFb5jyjg: "+syndFb5jyjg);
		//alert("ynsdse: "+ynsdse);
		//alert("syndZbh6: "+syndZbh6);
		//alert("syndZbh25: "+syndZbh25);
		
		//modified by zhangj 2015.3.2
		var million=10*10000;
		var sknd=document.forms[0].sknd.value;
		var qh=document.forms[0].qh.value;
		if((sknd*1>2015)||(sknd*1==2015&&qh*1>=1)){			
			million=20*10000;//�����걨������Ϊ2015��1�����Ժ�ļ�����˰�걨����˰�ˣ�����1��6���ж���ϵ��ԭ�С�10����ж���׼�޸�Ϊ��20��Ԫ��
		}
		//modified by zhangj end 
		
		xwblts="0";
		if(ynsdse>30*10000 || ynsdse<=0){
			//obj_input.value="0.00";
			inputValueTemp="0.00";
		}else{
			if(sfxkh=="Y"){
				if(ynsdse<=million){
					//obj_input.value=(ynsdse*0.15).toFixed(2);
					inputValueTemp=(ynsdse*0.15).toFixed(2);
					gyts("15");
					xwblts="15";
				}
				
				if(million<ynsdse&&ynsdse<=30*10000){
					//obj_input.value=(ynsdse*0.05).toFixed(2);
					inputValueTemp=(ynsdse*0.05).toFixed(2);
					gyts("5");
					xwblts="5";
				}
				
				if(ynsdse>30*10000){
					//obj_input.value="0.00";
					inputValueTemp="0.00";
				}
			}else{
				 if(syndZsfsdm==<%=CodeConstant.ZSFSDM_CZZS%>){//��������
					if(1*syndZbh25>30*10000){
						//obj_input.value="0.00";
						inputValueTemp="0.00";
					}else{
						if(syndFb5jyjg=="Y"){
							if(ynsdse<=million && syndZbh25<=million){
								//obj_input.value=(ynsdse*0.15).toFixed(2);
								inputValueTemp=(ynsdse*0.15).toFixed(2);
								gyts("15");
								xwblts="15";
							}else{
								//obj_input.value=(ynsdse*0.05).toFixed(2);
								inputValueTemp=(ynsdse*0.05).toFixed(2);
								gyts("5");
								xwblts="5";
							}
						}else{
							//obj_input.value="0.00";
							inputValueTemp="0.00";
						}
					}
				}else{
					if(1*syndZbh6>30*10000){
						//obj_input.value="0.00";
						inputValueTemp="0.00";
					}else{
						if(ynsdse<=million && syndZbh6<=million){
							//obj_input.value=(ynsdse*0.15).toFixed(2);
							inputValueTemp=(ynsdse*0.15).toFixed(2);
							gyts("15");
							xwblts="15";
						}else{
							//obj_input.value=(ynsdse*0.05).toFixed(2);
							inputValueTemp=(ynsdse*0.05).toFixed(2);
							gyts("5");
							xwblts="5";
						}
					}
				}
			}
		}
	}
	
	 function gyts(strBs){
		if(strBs=="15"){
			//alert("�����걨����ҵ��������С��΢����ҵ����������ҵ����˰�Ż����ߣ����ü���50������Ӧ��˰���ö��20%��˰�ʽ�����ҵ����˰��");
			xwblts="15";
		}
		
		if(strBs=="5"){
			//alert("�����걨����ҵ��������С��΢����ҵ����˰�Ż����ߣ���20%��˰�ʽ�����ҵ����˰��");
			xwblts="5";
		}
	}
	
			<%/*��13�������ж�*/%>
	function compute_Row_13(){
		var ybsds;
		if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
				document.getElementById('13_1').value ='0.00';
             return false;                         
          }

		if(parseFloat(document.getElementById('13_'+1).value)<0){
			alert("�ֵ�13������С���㣬��˶ԣ�");
			window.event.returnValue=false;
			document.getElementById('13_1').focus();
			document.getElementById('13_1').select();
		}

		if(document.getElementById('13_'+1).value == null||document.getElementById('13_'+1).value == ""){
			document.getElementById('13_1').value ='0.00';
		}				
		

		ybsds=Math.round((parseFloat(document.getElementById('11_'+1).value)-parseFloat(document.getElementById('12_'+1).value)-parseFloat(document.getElementById('13_'+1).value))*100)/100;
			if(ybsds>0){
				document.getElementById('14_'+1).value=parseFloat(ybsds);			
			}
			else{
				document.getElementById('14_'+1).value='0.00';
			}
			formate(document.getElementById('14_1'));
	}
	<%/*��15�������ж�*/%>
	function compute_Row_15(){
	if(!isNumJbCheck(getCellObject(), null, null, null, null, 2)){
				document.getElementById('15_1').value ='0.00';
             return false;                         
          }
    if(document.getElementById('15_'+1).value == null||document.getElementById('15_'+1).value == ""){
			document.getElementById('15_1').value ='0.00';
		}
	}
		<%/*���*/%>
	function doReset()
	{
		
		if(confirm("ȷ���Ƿ������ǰ���ݣ�"))
		{
	   		//��ҵ��˰����
			var qyzslx=document.forms[0].qyzslx.value;
			
	   		if(qyzslx==3 || qyzslx == 2 || qyzslx == 5 ||qyzslx == 1){
	   			for(var i=1; i < 15; i++){
					obj = eval("document.getElementById('" + i+ "_1')");
					if (obj.value!="*"&&i!=5&&i!=10)
						obj.value = "0.00";
	   			}
	   		}
	   		else if(qyzslx == 4){
	   			for(var i=11; i < 15; i++){
					obj = eval("document.getElementById('" + i+ "_1')");
					obj.value = "0.00";
	   			}
	   		}
	   		else{
	   			for(var i=1;i<6;i++){
	   				obj = eval("document.getElementById('" + i+ "_1')");
					if (obj.value!="*")
						obj.value = "0.00";
	   			}
	   		}
	   		document.forms[0].jsjdm.focus();
			document.forms[0].jsjdm.select();
			
			//xiezk0228��� ע���ʱ����ʽ��ܶְ��������
	   		document.getElementById("16_1").value="0.00";
	   		document.getElementById("17_1").value="0.00";
	   		document.getElementById("18_1").value="0";
		}
	}
		<%/*ɾ��*/%>
	function doDelete()
	{
		if(document.forms[0].jsjdm.value==""){
			alert("������Ϣ����ȷ,ɾ��ʧ��,����������!");
			return false;
		}
		doSubmitForm('Delete');
	}
	
		//����걨�·ݲ�������ҵ����˰��������4��7��10����ʾ������Ա
	function checkZQ(sbrq,ksrq,jzrq,lx){
		if(!isDate(sbrq,"v")) return;
		getStartEndDate1(sbrq,ksrq,jzrq,lx);
		var inputDate = sbrq.value;
		mon = inputDate.substring(4,6);
		if(mon!='01' && mon!='04' && mon!='07' && mon!='10'){
			alert('ע�⣺'+inputDate+'���������ڡ�');
		}
	}
	
	/**
 * ��ʽ����������ΪС�������λ
 * 
 * @param �ı���
 */
function formate(obj){
	//if(!isNumber(obj.value)){
	//	alert("��ʹ�����ָ�ʽ���룡");
	//	obj.focus();
	//	return false;
	//}
	if(obj.value==""||obj.value==null){
		return false;	
	}else{
		var temp = trim(obj.value+"");
		if(temp.indexOf(".")!=-1){
			var len=temp.indexOf(".")+1;
			if(temp.length-len==1)
			temp = temp+"0";
			var zs=trim(temp.substring(0,temp.indexOf(".")));
			if(zs==""){
				temp="0"+temp;
			}
		}else{
			temp=temp+".00";
		}
		if(temp=="-.00"){
			temp="-0.00";
		}
		obj.value=temp;	
		formateNum(obj);
		}
}
/**
 * ��ʽ������������0��ͷ
 *
 * @param �ı���
 */
 function formateNum(obj){
 	var tempNum=obj.value;
 	var num=trim(tempNum.substring(0,tempNum.indexOf(".")));
 	if(num.length>1){
 		num=num.substring(0,num.length-1);
 		var i;
 		for(i=0;i<num.length;i++){
 			var itemp=num.substring(i,i+1);
 			if(itemp!="0"){
 				break;
 			}
 		}
 		tempNum=tempNum.substring(i,tempNum.length);
 		obj.value=tempNum;
 	}
 
 }	
	//��������ҵ��ֵ
	function setSshy(obj){
		var sshydm=obj.value;
		if(sshydm!=null){
			document.all.gjbzhydm.value=sshydm;
			document.all.sshy.value=sshydm;
			document.getElementById('19_1').value=sshydm;
		}		
	}	
	function numCheck(obj){
		if(!isNum(getCellObject(), null, null, null, null, 2)){
		 	obj.value ='0.00';                        
        }
	}
	
	 //xiezkְ������������У��
	function checkZgrs(){
	var zgrs=document.getElementById('18_1');
		if(!checkNumber(zgrs.value,15,0,true)){
			alert("ְ����������Ϊ���֣�\nС�����ĳ���Ϊ0λ��\n������ֵ����ڵ����㣡");
			zgrs.focus();
			zgrs.select();
			return false;
		}
		//���ֺϷ�ʱ��ȥ����ͷ��0
		var tmpValue = trim(zgrs.value);
		while(tmpValue.length>0 && tmpValue.charAt(0)=='0')
		{
			tmpValue = tmpValue.substring(1);
		}
		if(tmpValue.length <= 0)
		{
		   tmpValue=0;
		}
		zgrs.value=tmpValue;
		
		
		if(zgrs.value*1>10000){
			alert("ְ����������1���ˣ����ʵ��");
		}
		return true;
	}
	 
	function checkNumber(DigitString, totalLength, decimalLength,isPositive)
	{
	    var re = "";

		if(isPositive == "true" || isPositive == true)
		{//����ǷǸ���
		  if(isNaN(DigitString*1) || DigitString*1<0)
				return false;
		}
		if(isPositive == "false" || isPositive == false)
		{//����Ǹ���
			if(isNaN(DigitString*1) || DigitString*1>=0)
				return false;
		}

	    if (isNaN(DigitString))
	    {
	      return false;
	    }
	    if (decimalLength!=null && decimalLength != 0)
	    {   //С����Ϊ��
	        re = re+"\\.[\\d]{1,"+ decimalLength +"}"
	    }

	    if (totalLength == null)
	    {   //δ�趨�ܳ���
	        re= "\\d*"+re;
	    }
	    else
	    {   //�趨�ܳ���
	        //��С������Ϊ�յ�����£������ж����ֵĳ���
	        var intergerLength = totalLength;
	        if (decimalLength!=null)
	        {   //��С�����ֲ�Ϊ���жϣ�������λ����С����λ���Ƿ���ȷ
	            intergerLength = totalLength-decimalLength;
	        }
	        re="([\\d]{0,"+ intergerLength +"}"+re+"|[\\d]{0,"+intergerLength+"})";
	    }
	    re = new RegExp("^[-|+]?"+re+"$","g");

	    //���ַ���Ϊ�ա�λ�����ԡ�����ƥ�������ʱ
	    if(re.exec(DigitString) == null)
	    {
	        return false;
	    }
	    return true;
	}
	
	function checkZczbje(obj){
		numCheck(obj);
		var zczbje=document.getElementById('16_1');
		if(zczbje.value*1>10*10000){//10��
			alert("ע���ʱ��ܶ���ڵ���10��Ԫ�����ʵ��");
		}
	}
	function checkZcze(obj){
		numCheck(obj);
		var zcze=document.getElementById('17_1');
		if(zcze.value*1>10*10000){//10��
			alert("�ʲ��ܶ���ڵ���10��Ԫ�����ʵ��");
		}
	}	
</script>
</body>
</html:html>