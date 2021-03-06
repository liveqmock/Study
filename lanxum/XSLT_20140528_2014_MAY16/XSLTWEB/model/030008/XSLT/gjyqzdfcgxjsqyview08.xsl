<?xml version="1.0" encoding="GB2312"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<input name="xsltVersion" type="hidden" id="xsltVersion">
			<xsl:attribute name="value"><xsl:value-of select="taxdoc/xsltVersion"/></xsl:attribute>
		</input>
		<input name="schemaVersion" type="hidden" id="schemaVersion">
			<xsl:attribute name="value"><xsl:value-of select="taxdoc/schemaVersion"/></xsl:attribute>
		</input>
		<input name="ywlx" type="hidden" id="ywlx">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/ywlx" />
			</xsl:attribute>
		</input>
		<input name="ywczlx" type="hidden" id="ywczlx">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/ywczlx" />
			</xsl:attribute>
		</input>
				<input name="swjgzzjgdm" type="hidden" id="swjgzzjgdm">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/nsrxx/swjgzzjgdm" />
			</xsl:attribute>
		</input>
		<input name="jsjdm" type="hidden" id="jsjdm">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/nsrxx/jsjdm" />
			</xsl:attribute>
		</input>
		<input name="nsrmc" type="hidden" id="nsrmc">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/nsrxx/nsrmc" />
			</xsl:attribute>
		</input>
		<input name="basqbh" type="hidden" id="basqbh">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/basqbh" />
			</xsl:attribute>
		</input>
		<input name="basqwsh" type="hidden" id="basqwsh">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/basqwsh" />
			</xsl:attribute>
		</input>
		<input name="jmbasxdm" type="hidden" id="jmbasxdm">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/jmbasxdm" />
			</xsl:attribute>
		</input>
		<input name="jmbasxmc" type="hidden" id="jmbasxmc">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/jmbasxmc" />
			</xsl:attribute>
		</input>
		
		<input name="fhwjmc" type="hidden" id="fhwjmc">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/fhwjmc" />
			</xsl:attribute>
		</input>
				<input name="qsrq" type="hidden" id="qsrq">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/qsrq" />
			</xsl:attribute>
		</input>
		<input name="ztdm" type="hidden" id="ztdm">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/ztdm" />
			</xsl:attribute>
		</input>
		<input name="ztmc" type="hidden" id="ztmc">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/ztmc" />
			</xsl:attribute>
		</input>
		<input name="jzrq" type="hidden" id="jzrq">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/jzrq" />
			</xsl:attribute>
		</input>
		<input name="szdm" type="hidden" id="szdm">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/szdm" />
			</xsl:attribute>
		</input>
		<input name="szmc" type="hidden" id="szmc">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/szmc" />
			</xsl:attribute>
		</input>
		<input name="bsfsdm" type="hidden" id="bsfsdm">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/bsfsdm" />
			</xsl:attribute>
		</input>
		<input name="bsfsmc" type="hidden" id="bsfsmc">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/bsfsmc" />
			</xsl:attribute>
		</input>
	<input name="xh" type="hidden" id="xh">
		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/xh" />
			</xsl:attribute>
		</input>
		<input name="band" type="hidden" id="band">
			<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/band" />
			</xsl:attribute>
		</input>
		<br/>
		<table class="table-99" cellspacing="0">
		<tr>
                      <td width="50%" class="2-td2-t-left" colspan="2">
                        <div align="left">
                          备案申请文书号
                          &#160;
                        </div>
                      </td>
                      <td width="50%" class="2-td2-t-center" height="21">
                        <div align="left">
                          <input type="text" name="basqbh1" maxlength="11" size="30" tabindex="-1"
                           disabled="true">
                             		<xsl:attribute name="value">
				<xsl:value-of select="taxdoc/jmsbajl/basqbh" />
			</xsl:attribute></input>
                        </div>
                      </td>
                    </tr>
		<tr>
				<td class="2-td2-t-left" colspan="2"  >
					<div align="left">高新技术领域<font color="#FF0000">*</font></div>
				</td>
				<td colspan="1" class="2-td2-t-center">
					<div id="gxjslydmdiv" align="left">
					</div>
				</td>
			</tr>
			<tr>
                      <td width="15%" class="2-td2-t-left" rowspan="3">
                        <div align="left" >
                          高新技术企业证书
                        </div>
                      </td>
                      <td  class="2-td2-t-left" width="35%">
                        <div align="left">
                          证书编号<font color="#FF0000">*</font>
                        </div>
                      </td>
                      <td class="2-td2-t-center"  width="50%">
                        <div id="mx_zsfsdm_epx_visible_1" align="left">
                           <input type="text" name="zsbh" size="20" tabindex="-1" class="noborder-txtcenter" readonly="true">
                           <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/zsbh"/>
                             </xsl:attribute>
                          </input>
                        </div>
                      </td>
                    </tr>
					<tr>
					<td  class="2-td2-t-left" >
                        <div align="left">
                          证书有效期起<font color="#FF0000">*</font>
                        </div>
                      </td>
                      <td class="2-td2-t-center" >
                        <div id="mx_zsfsdm_epx_visible_1" align="left">
                          <input type="text" name="zsyxqsrq" size="20" tabindex="-1" class="noborder-txtcenter" readonly="true">
                           <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/zsyxqsrq"/>
                        </xsl:attribute>
                          </input>
                             
                        </div>
                      </td>
					</tr>
					<tr><td  class="2-td2-t-left" >
                        <div align="left">
                          证书有效期止<font color="#FF0000">*</font>
                        </div>
                      </td>
                      <td class="2-td2-t-center">
                        <div id="mx_zsfsdm_epx_visible_1" align="left">
                          <input type="text" name="zsyxzzrq" size="20" tabindex="-1"  class="noborder-txtcenter" readonly="true">
                           <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/zsyxzzrq"/>
                        </xsl:attribute>
                          </input>
                             
                        </div>
                      </td>
                      </tr>
                      
                
           <tr>
            <td colspan="2" class="2-td2-t-left">
              <div align="left">
                企业具有大学专科以上学历的科技人员占企业当年职工总数的比例<font color="#FF0000">*</font>
                </div>
            </td>
            <td colspan="1" class="2-td2-t-center" width="15%">
              <div id="mx_zsfsdm_epx_visible_1" align="left">
                 <input type="text" name="zkysbl" size="20" tabindex="-1"  class="noborder-txtcenter" readonly="true">
                  <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/zkysbl"/>
                        </xsl:attribute>
                          </input>
              </div>
            </td>
			</tr>
			<tr>
            <td colspan="2" class="2-td2-t-center" >
              <div align="left">
                研发人员占企业当年职工总数的比例<font color="#FF0000">*</font>
              </div>
            </td>
            <td colspan="1" class="2-td2-t-center">
              <div id="mx_zsfsdm_epx_visible_1" align="left">
                <input type="text" name="yfrybl" size="20" tabindex="-1" class="noborder-txtcenter" readonly="true">
                 <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/yfrybl"/>
                        </xsl:attribute>
                          </input>%
              </div>
            </td>
          </tr>
          
           <tr>
            <td colspan="2" class="2-td2-t-left">
              <div align="left">
                企业近三个会计年度的研究开发费用总额占销售收入总额的比例<font color="#FF0000">*</font>
              </div>
            </td>
            <td colspan="1" class="2-td2-t-center">
              <div id="mx_zsfsdm_epx_visible_1" align="left">
                <input type="text" name="yffybl" size="20" tabindex="-1"  class="noborder-txtcenter" readonly="true" >
                 <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/yffybl"/>
                        </xsl:attribute>
                          </input>%
                          </div>
            </td>
          </tr>
          <tr>
            <td colspan="2" class="2-td2-t-left">
              <div align="left">
                企业当年高新技术产品（服务）收入占企业总收入的比例<font color="#FF0000">*</font>
              </div>
            </td>
            <td colspan="1" class="2-td2-t-center">
              <div id="mx_zsfsdm_epx_visible_1" align="left">
               <input type="text" name="gxcpsrbl" size="20" tabindex="-1"  class="noborder-txtcenter" readonly="true">
                <xsl:attribute name="value">
                        <xsl:value-of select="taxdoc/jmsbajl/qysdsjmba/gxcpsrbl"/>
                        </xsl:attribute>
                          </input>%
               </div>
            </td>
          </tr>
            </table>
		
		<table class="table-99" cellspacing="0" id="FhtjjzzrsdTable">
	
                   <tr>
                    <xsl:variable name="rq" select="taxdoc/jmsbajl/lrrq"/>
			       <xsl:variable name="nd" select="taxdoc/jmsbajl/band"/>
			       <xsl:variable name="rr" select="taxdoc/nsrxx/nsrmc"/>
                      <td width="10%" class="2-td2-t-left">
                        <div align="right">
                          录入日期
                        </div>
                      </td>
                      <td width="30%" class="2-td2-t-left">
                        <div align="left">
                        <input type="text" name="lrrq" size="20" tabindex="-1"  class="noborder-txtcenter" readonly="true" value='{$rq}'>
                       
                          </input>
                          
                        </div>
                      </td>
                      <td width="10%" class="2-td2-t-left">
                        <div align="right">
                          备案年度
                        </div>
                      </td>
                      <td width="30%" class="2-td2-t-left">
                        <div align="left">
                        <input type="text" name="band" size="20" tabindex="-1" class="noborder-txtcenter" readonly="true" value='{$nd}'>
                       
                          </input>
                        
                        </div>
                      </td>
                      <td width="10%" class="2-td2-t-left">
                        <div align="right">
                          录入人
                        </div>
                      </td>
                      <td width="30%" class="2-td2-t-center">
                        <div align="left">
                         <input type="text" name="lrr" size="20" tabindex="-1" class="noborder-txtcenter" readonly="true" value='{$rr}'>
                       
                          </input>
                          
                        </div>
                      </td>
                    </tr>
                
            </table>
		
	</xsl:template>
</xsl:stylesheet>
