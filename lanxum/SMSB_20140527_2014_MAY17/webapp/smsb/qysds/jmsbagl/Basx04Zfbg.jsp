<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/ttsoft-html.tld" prefix="ttsoft" %>
<%@ page import="com.ttsoft.bjtax.smsb.constant.CodeConstant" %>
<%@ page import="com.ttsoft.bjtax.smsb.qysdsjmsbagl.basx04.web.Basx04Form" %>
<html>  
  <head>
    <title>减免税备案记录</title>
    <link href="../../../css/text.css" rel="stylesheet" type="text/css">
	
	<script language="JavaScript" type="text/javascript"
		src="../../../js/My97DatePicker/WdatePicker.js"></script>
    <script language=JavaScript src="../../../js/treatImage.js">
    </script>
    <script language=JavaScript src="../../../js/compute.js">
    </script>
    <script language=JavaScript src="../../../js/function.js">
    </script>
    <script language=JavaScript src="../../../js/smsb_common.js">
    </script>
    <script language=JavaScript src="../../../js/Bolan.js">
    </script>
    <script language=JavaScript src="../../../js/MathString.js">
    </script>
    <script language=JavaScript src="../../../js/Stack.js">
    </script>
    <script language=JavaScript src="../../../js/reader.js">
    </script>
    <script language=JavaScript src="../../../js/gmit_selectcontrol.js">
    </script>
    <script language="JavaScript" src="../../../js/qysdsnew.js">
    </script>
    <script language="JavaScript" src="../../../js/calculate.js">
    </script>
  </head>
    <script language="JavaScript">
	function onKeyDown() { // 禁止刷新，回退
	 if ((event.keyCode == 8 && event.srcElement.type ==undefined) || (event.keyCode == 116)) {
	    event.keyCode = 0;
	    event.returnValue = false;
	   }
	}
	document.onkeydown = onKeyDown;
  </script>
  <script type="text/javascript" language="JavaScript">
  
  <%
  		Basx04Form basx = (Basx04Form)request.getAttribute("basx04Form");
		String zfyy = basx.getZfyy();
  	// 构造减免税备案事项代码
	    if(session.getAttribute(CodeConstant.PAGE_SELECT_ITEMS_SESSION_KEY_JMSBAZFYY) != null)
	    {
	        out.print("var arySelect_zfyy = new Array(");
	        out.print("[\"\",\"\"]");
	        String[][] zfyydm = (String[][])session.getAttribute(CodeConstant.PAGE_SELECT_ITEMS_SESSION_KEY_JMSBAZFYY);
	        for(int i = 0 ; i < zfyydm.length ; i++) 
	        {	        	
	         	out.print(",[\"" + zfyydm[i][0] + "\",\"" +zfyydm[i][1] +"\"]");
	        }
	        out.println(");");
	    }
   
   		String alertString=(request.getAttribute("ALERT_STR")==null)?"":(String)request.getAttribute("ALERT_STR");
	%>   
	<%/*初始化*/%> 
	function doInit(){
	    //初始化资料
		var zl = document.forms[0].zl.value.split(";");
		for(row_index=0;row_index<zl.length;row_index++){
			var new_row=Table1.insertRow(Table1.rows.length);
			zlnr = zl[row_index].substring(0,zl[row_index].indexOf("|"));
			zlsfkysc = zl[row_index].substring(zl[row_index].length-1,zl[row_index].length);
		    addzlmc(row_index,zlnr,new_row);
		    if(zlsfkysc == "1"){
		    	addzlan("1",row_index,new_row);
		    }else{
		    	addzlan("2",row_index,new_row);
		    }
		    
		}
		_addOptionsToSelect(document.forms[0].zfyy, arySelect_zfyy);
		<%
		if(null != zfyy && !"".equals(zfyy))
		{
		%>
				_selectOptionByValue(document.forms[0].zfyy, "<%=zfyy%>");
		<%
		}
	    %>
	   	var zfyyValue=document.forms[0].zfyy.value;
	   	if(zfyyValue!=null && zfyyValue== '4'){
	   		document.getElementById("qtzfyyDiv").style.display ="block";
	   		
	   	}
		var alertStr ='<%=alertString%>';
		if(alertStr!=null && alertStr.length>0){
			alert(alertStr);
			back();
		} 
	}
	<%/*添加资料名称*/%>
	function addzlmc(row_index,zlmc,new_row){
	    new_row.setAttribute("id", "row"+row_index);   
	    var new_col=new_row.insertCell(0);
	    if(row_index == 0){
	    	new_col.className="2-td2-t-left-textleft";
	    }else{
	    	new_col.className="2-td2-left-textleft";
	    }
	    new_col.setAttribute("id",row_index);
	    new_col.innerHTML=zlmc;
	}
	<%/*初始资料添加按钮*/%>
	function addzlan(lx,row_index,new_row){
	    var new_col=new_row.insertCell(1);
	    if(row_index == 0){
	    	new_col.className="2-td2-t-center";
	    }else{
	    	new_col.className="2-td2-center";
	    }
	    if(lx == "1"){
	    	new_col.innerHTML="&nbsp\;&nbsp\;有&nbsp\;&nbsp\;";  
	    }else{
	    	new_col.innerHTML="&nbsp\;&nbsp\;无&nbsp\;&nbsp\;";  
	    }
	    
	}
	
	
	
	<%/*返回*/%>
	function back()
	{
		doSubmitForm('BackZfbg');
	}
	
	function qtzfyyControl(){
		var zfyyValue=document.forms[0].zfyy.value;
		var qtzfyy=document.forms[0].qtzfyy;
		if(zfyyValue=='4'){
			document.getElementById("qtzfyyDiv").style.display ="block";
		}else{
			document.getElementById("qtzfyyDiv").style.display ="none";
		}
	}
	
	function destory()
	{
		var zfyyValue=document.forms[0].zfyy.value;
		var zfyyContent;
		if(zfyyValue=='4'){
			zfyyContent=document.forms[0].qtzfyy.value;
		}else{
			zfyyContent=document.forms[0].zfyy.options[document.forms[0].zfyy.selectedIndex].innerText;
		}
		if(zfyyContent.length<=0){
			alert("请选择或填写作废原因！");
			return;
		}else{
			if(window.confirm("是否将此减免税备案信息作废？")){
			document.forms[0].zfsm.value=zfyyContent;
			document.forms[0].zfbglx.value="0";
			doSubmitForm('Operate');
			}
		}
		
	}
	
	function modify()
	{
	if(window.confirm("是否执行变更操作？")){
		document.forms[0].zfbglx.value="1";
		doSubmitForm('Operate');
		}
	}
  </script>
  
  
  <body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"  onload="doInit()">
    <%@ include file="../../include/header.jsp" %> 
     
	  
      <html:form action="/webapp/smsb/qysds/jmsbagl/Basx04Action.do" method="post">
        <html:hidden property="actionType" />
        <html:hidden property="basqwsh" />
        <html:hidden property="zl" />
        <html:hidden property="czlx" />
        <html:hidden property="zfsm" />
        <html:hidden property="zfbglx" />
        <table width="75%" align="center" cellspacing="0" height="480">
          <tr>
            <td class="1-td1" colspan="7" height="30">
              作废及变更从事国家重点扶持的公共基础设施项目投资经营的所得减免备案事项 
            </td>
          </tr>
          <br>
          <tr>
            <td class="1-td2" colspan="7" valign="top">
            <br>
            	<table cellspacing=0 border=0 class="table-99" style="TABLE-LAYOUT:fixed">
                    <tr>
                      <td  class="2-td2-t-left">
                          <strong>备案申请编号</strong>
                      </td>
                      <td  width="22%"class="2-td2-t-left">
                      	&nbsp;<bean:write name="basx04Form" property="basqbh"/>
                      </td>
                      <td  class="2-td2-t-left">
                          <strong>计算机代码</strong>               
                      </td>
                      <td  class="2-td2-t-left">
                      	&nbsp;<bean:write name="basx04Form" property="jsjdm"/>
                      </td>                  
                      <td  class="2-td2-t-left">                       
                          <strong>纳税人名称</strong>
                      </td>
                      <td width="22%"  class="2-td2-t-center">
                      &nbsp;<bean:write name="basx04Form" property="nsrmc"/>
                      </td>
                    </tr>
                    <tr>
                      <td  class="2-td2-left">                        
                          <strong>主管税务所</strong>    
                      </td>
                      <td  width="22%"class="2-td2-left">
                      	&nbsp;<bean:write name="basx04Form" property="zgsws"/>
                      </td>
                      <td  class="2-td2-left">
                          <strong>经济类型</strong>               
                      </td>
                      <td  class="2-td2-left">
                      	&nbsp;<bean:write name="basx04Form" property="jjlx"/>
                      </td>                  
                      <td  class="2-td2-left">                       
                          <strong>所属行业</strong>
                      </td>
                      <td width="22%"  class="2-td2-center">
                      	&nbsp;<bean:write name="basx04Form" property="sshy"/>
                      </td>
                    </tr>
                   <tr>
                      <td  class="2-td2-left">
                         <strong>联系人</strong>
                      </td>
                      <td  class="2-td2-left">
                      	&nbsp;<bean:write name="basx04Form" property="lxr"/>
                      </td>                  
                      <td  class="2-td2-left">                       
                          <strong>联系电话</strong>
                      </td>
                      <td width="22%"  class="2-td2-center" colspan="3">
                       &nbsp;<bean:write name="basx04Form" property="lxdh"/>
                      </td>
                    </tr>
                  </table>
                  
                  
                  </br>
                  <table cellspacing=0 border=0 class="table-99" style="TABLE-LAYOUT:fixed">            
              <tr>
                <td class="2-td2-t-left" width="10%">
                  起始时间
                </td>
                <td class="2-td2-t-left" width="15%"> 
                	&nbsp;<bean:write name="basx04Form" property="qsrq"/>
                </td>
                <td class="2-td2-t-left" width="10%">
                  截止时间
                </td>
                <td class="2-td2-t-left" width="15%">
                	&nbsp;<bean:write name="basx04Form" property="jzrq"/>
                </td>                
            
                <td class="2-td2-t-left" width="10%">
                  减免税额
                </td>
                <td class="2-td2-t-left" width="15%">
                	&nbsp;<bean:write name="basx04Form" property="bajmse"/>&nbsp;元
                </td>
                <td class="2-td2-t-left" width="10%">
                  减免比例
                </td>
                <td class="2-td2-t-center" width="15%">
                	&nbsp;<bean:write name="basx04Form" property="bajmbl"/>&nbsp;%
                </td>
              </tr>
              <tr>
                <td class="2-td2-left">
                  减免税政策
                  <br/>
                  执行情况：
                </td>
                <td class="2-td2-center" colspan="7">
                	<div align="left">
                		&nbsp;&nbsp;&nbsp;
                		<bean:write name="basx04Form" property="jmszczxqk"/>
                	</div>
                  <td>
              </tr>
              <tr>
                <td class="2-td2-center" colspan="8">
                	<br/>
                  <div align="left">
                    &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
                    减免税备案资料清单：
                  </div>
                  
                  <table width="95%" cellspacing=0 border=0 id="Table1">                   
                  </table>
                  </br>
                  <td>
              </tr>
            </table>
                  
            	  </br>
			<table class="table-99" cellspacing="0">
				<tr>
					<td width="20%" class="2-td2-t-left" colspan="2">
					<div align="left">公共基础设施项目类型<font color="red">
					* </font></div>
					</td>
					<td class="2-td2-t-center" width="10%">
					<div id="mx_zsfsdm_epx_visible_1" align="left"><bean:write
						name="basx04Form" property="ggjcssxmlxmc" /></div>
					</td>
				</tr>
				<tr>
					<td rowspan="2" width="15%" class="2-td2-left">
					<div align="left">国务院行业主管部门或政府投资主管部门的核准文件<font color="red">
					* </font></div>
					</td>
					<td class="2-td2-left">文件名称<font color="red">
					* </font></td>
					<td class="2-td2-center">
					<div align="left"><bean:write name="basx04Form"
						property="wjmc" /></div>
					</td>
				</tr>
				<tr>
					<td class="2-td2-left">文号<font color="red">
					* </font></td>
					<td class="2-td2-center">
					<div align="left"><bean:write name="basx04Form"
						property="wh" /></div>
					</td>
				</tr>

				<tr>
					<td width="20%" class="2-td2-left" colspan="2">
					<div align="left">取得第一笔收入的相关证明资料名称<font color="red">
					* </font></div>
					</td>
					<td class="2-td2-center">
					<div id="mx_zsfsdm_epx_visible_1" align="left"><bean:write
						name="basx04Form" property="dybzlmc" /></div>
					</td>
				</tr>
				<tr>
					<td width="20%" class="2-td2-left" colspan="2">
					<div align="left">取得第一笔生产经营收入的时间<font color="red">
					* </font></div>
					</td>
					<td class="2-td2-center">
					<div id="mx_zsfsdm_epx_visible_1" align="left"><bean:write
						name="basx04Form" property="dybrq" />&nbsp;年</div>
					</td>
				</tr>
				<tr>
					<td width="20%" class="2-td2-left" colspan="2">
					<div align="left">免征年度<font color="red">
					* </font></div>
					</td>
					<td class="2-td2-center">
					<div id="mx_zsfsdm_epx_visible_1" align="left">从（ <bean:write
						name="basx04Form" property="mzqsnd" /> ）年至（ <bean:write
						name="basx04Form" property="mzzznd" /> ）年止</div>
					</td>
				</tr>
				<tr>
					<td width="20%" class="2-td2-left" colspan="2">
					<div align="left">减征年度<font color="red">
					* </font></div>
					</td>
					<td class="2-td2-center">
					<div id="mx_zsfsdm_epx_visible_1" align="left">从（ <bean:write
						name="basx04Form" property="jzqsnd" /> ）年至（ <bean:write
						name="basx04Form" property="jzzznd" /> ）年止</div>
					</td>
				</tr>
			</table>
                 <br/>
                 <table class="table-99" cellspacing="0">
                    <tr>
                      <td width="13%" class="2-td2-t-left">
                        <div align="right">
                          录入日期
                        </div>
                      </td>
                      <td width="27%" class="2-td2-t-left">
                        <div align="left">
                        	<html:text property="mr_lrrq" readonly="readonly" style="background-color:#efefef"></html:text>
                        </div>
                      </td>
                      <td width="10%" class="2-td2-t-left">
                        <div align="right">
                          	备案年度
                        </div>
                      </td>
                      <td width="30%" class="2-td2-t-left">
                        <div align="left">
                        	<html:text property="mr_band" readonly="readonly" style="background-color:#efefef"></html:text>
                        </div>
                      </td>
                      <td width="10%" class="2-td2-t-left">
                        <div align="right">
                          录入人
                        </div>
                      </td>
                      <td width="30%" class="2-td2-t-center">
                        <div align="left">
                        	<html:text property="mr_lrr" readonly="readonly" style="background-color:#efefef"></html:text>
                        </div>
                      </td>
                    </tr>
                  </table>
                  <br/>
                  <table class="table-99" cellspacing="0">
                  	<tr>
                  		<td class="2-td2-t-left" width="100">
                  			作废原因
                  			<font color="#FF0000">
                            *
                          </font>
                  		</td>
                  		<td class="2-td2-t-center">
                  			<div align="left">
                  			<html:select name="basx04Form" styleId="zfyySelect"  onchange="qtzfyyControl()" property="zfyy"/>
                  		</div>
                  		</td>
                  	</tr>
                  </table>
                <div id="qtzfyyDiv" style="display: none">                 
                   <table class="table-99" cellspacing="0">
                  	<tr>
                  		<td class="2-td2-left" width="100">
                  			其他作废原因
                  			<font color="#FF0000">
                            *
                          </font>
                  		</td>
                  		<td class="2-td2-center">
                  			<div align="left">                  			
                  			<html:textarea property="qtzfyy" rows="5" cols="70"></html:textarea>
                  		</div>
                  		</td>
                  	</tr>
                  </table>
 				</div>
                  <br/>
                  <table width="100%" border="0" align="center">
                    <tr align="center">      
	                    <td>
	      				  	<a style="cursor:hand" onClick="destory()" onMouseOut="MM_swapImgRestore()"
	                        onMouseOver="MM_swapImage('zf','','<%=static_contextpath%>images//b-zf2.jpg',1)">
	                        <img src="<%=static_contextpath%>images//b-zf1.jpg" name="zf" width="79" height="22" border="0" id="zf">
	                        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                        <a style="cursor:hand" onClick="modify()" onMouseOut="MM_swapImgRestore()"
	                        onMouseOver="MM_swapImage('bg','','<%=static_contextpath%>images//b-bg2.jpg',1)">
	                        <img src="<%=static_contextpath%>images//b-bg1.jpg" name="bg" width="95" height="22" border="0" id="bg">
	                        </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                        <a style="cursor:hand" onClick="back()" onMouseOut="MM_swapImgRestore()"
	                        onMouseOver="MM_swapImage('fanhui','','<%=static_contextpath%>images//fanhui2.jpg',1)">
	                        <img src="<%=static_contextpath%>images//fanhui1.jpg" name="fanhui" width="79" height="22" border="0" id="fanhui">
	                        </a>
	                    </td>
                    </tr>
                  </table> 
                  <br>
                  <br>
            </td>
          </tr>
        </table>
        <br>
        <%@ include file="../../include/footer.jsp" %>
      </html:form>
  </body>

</html>