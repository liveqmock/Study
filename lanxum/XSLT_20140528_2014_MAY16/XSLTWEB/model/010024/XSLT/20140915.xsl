<?xml version="1.0" encoding="gb2312"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" />
	<xsl:template match="/">

		<table id="maintable" align="center" cellspacing="0" class="table-99" width="1000">
			<tr>
				<td>
					<input name="xsltVersion" type="hidden" id="xsltVersion">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/xsltVersion" />
						</xsl:attribute>
					</input>
					<input name="schemaVersion" type="hidden" id="schemaVersion">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/schemaVersion" />
						</xsl:attribute>
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


					<input name="jmzg" type="hidden" id="jmzg">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/hdxx/jmzg" />
						</xsl:attribute>
					</input>
					<input name="ybjmsl" type="hidden" id="ybjmsl">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/hdxx/ybjmsl" />
						</xsl:attribute>
					</input>
					<input name="qyzslx" type="hidden" id="qyzslx">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/hdxx/qyzslx" />
						</xsl:attribute>
					</input>
					<input name="xzqy" type="hidden" id="xzqy">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/hdxx/xzqy" />
						</xsl:attribute>
					</input>
					<input name="cyl" type="hidden" id="cyl">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/hdxx/cyl" />
						</xsl:attribute>
					</input>
					<input name="dezsse" type="hidden" id="dezsse">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/hdxx/dezsse" />
						</xsl:attribute>
					</input>


					<input name="nd" type="hidden" id="nd">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbxx/nd" />
						</xsl:attribute>
					</input>
					<input name="sbrq" type="hidden" id="sbrq">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbxx/sbrq" />
						</xsl:attribute>
					</input>
					<input name="skssjsrq" type="hidden" id="skssjsrq">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbxx/skssjsrq" />
						</xsl:attribute>
					</input>
					<input name="skssksrq" type="hidden" id="skssksrq">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbxx/skssksrq" />
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
					<input name="sfxkh" type="hidden" id="sfxkh">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbsj/sfxkh" />
						</xsl:attribute>
					</input>

					<input name="syndzsfsdm" type="hidden" id="syndzsfsdm">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbsj/syndzsfsdm" />
						</xsl:attribute>
					</input>

					<input name="syndzbh6" type="hidden" id="syndzbh6">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbsj/syndzbh6" />
						</xsl:attribute>
					</input>

					<input name="syndzbh25" type="hidden" id="syndzbh25">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbsj/syndzbh25" />
						</xsl:attribute>
					</input>
					<input name="syndfb5jyjg" type="hidden" id="syndfb5jyjg">
						<xsl:attribute name="value">
							<xsl:value-of select="taxdoc/sbsj/syndfb5jyjg" />
						</xsl:attribute>
					</input>
					<input name="sshydm" type="hidden" id="sshydm">
						<xsl:attribute name="value"><xsl:value-of select="//sshydm"/></xsl:attribute>
					</input>
				</td>
			</tr>
			<tr>
				<td class="1-td1">中华人民共和国<br>企业所得税年度纳税申报表(B类)</br></td>
			</tr>
			<xsl:apply-templates select="taxdoc/nsrxx" />
			<xsl:apply-templates select="taxdoc/sbsj" />
		</table>
		<br />
	</xsl:template>
	<xsl:template match="taxdoc/nsrxx">
		<tr>
			<td class="1-td2" colspan="7">
				<div align="left">
					&#160;&#160;&#160;&#160;申报日期:
					<xsl:value-of select="//sbrqshow" />
					&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;金额单位：元（列至角分）
				</div>
			</td>
		</tr>
		<tr>
			<td class="1-td2" colspan="7">
				<div align="left">
					&#160;&#160;&#160;&#160;计算机代码:
					<xsl:value-of select="jsjdm" />
					&#160;&#160;&#160;&#160;纳税人识别号:
					<xsl:value-of select="nsrsbh"/>
					&#160;&#160;&#160;&#160;纳税人名称：
					<xsl:value-of select="nsrmc" />
					&#160;&#160;&#160;&#160;&#160;&#160;&#160;税款所属日期：
					<xsl:value-of select="//skssksrq" />
					&#160;至&#160;
					<xsl:value-of select="//skssjsrq" />
				</div>
			</td>
		</tr>
		<tr>
			<td class="1-td2"  colspan="7">
				<div align="left">&#160;&#160;&#160; 注册资本(万元)：					
					<input type='text' name='zczb' id='zczb' size='13' tabindex='1' onblur ='return formatData10(this,1);' onchange="checkNumInput(this)">
						<xsl:attribute name="value">
							<xsl:value-of select="//zczb" />
						</xsl:attribute>
					</input>
					&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;资产总额(万元)：
					<input type='text' name='zcze' id='zcze' size='13' tabindex='1' onblur ='return formatData10(this,0);' onchange="checkNumInput(this)"> 
			    		<xsl:attribute name="value">
			    			<xsl:value-of select="//zcze"/>
			    		</xsl:attribute>
			    	</input>
				</div>
			</td>
		</tr>
		<tr>
			<td class="1-td2"  colspan="7">
				<div align="left">
					&#160;&#160;&#160;&#160;从业人数：
					<input type='text' name='zgrs' id='zgrs' size='13' tabindex='1' onblur ='return formatData10(this,2);' onchange="checkNumInputZhengShu(this)"> 
			    		<xsl:attribute name="value">
			    			<xsl:value-of select="//zgrs"/>
			    		</xsl:attribute>
			    	</input>
			    	&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;所属行业:
					<xsl:value-of select="//sshy" />
					<input name="sshy" type="hidden" id="sshy">
						<xsl:attribute name="value"><xsl:value-of select="//sshy"/></xsl:attribute>
					</input>
					</div>
			</td>
		</tr>
	</xsl:template>


	<xsl:template match="taxdoc/sbsj">
		<tr>
			<td class="1-td2" colspan="7">
		<table class="table-99" align="center">
		  <tr>
					
            <td> 
              <div id="Layer2" style="position:static;">
					
                <table id="wrklistTable" border="1" cellspacing="0"
						class="table-99" align="center">
                  <tr> 
                    <td colspan="3" nowrap="nowrap" class="2-td1-left"><div align="center">项目</div></td>
                    <td width="52" nowrap="nowrap" class="2-td1-left"><div align="center">行次</div></td>
                    <td width="180" nowrap="nowrap" class="2-td1-center">累计金额</td>
                  </tr>
                  <tr> 
                    <td width="144" rowspan="9" nowrap="nowrap" class="2-td2-left">应纳税所得额的计算</td>
                    <td width="208" rowspan="6" nowrap="nowrap" class="2-td2-left">按收入总额核定应纳税所得额</td>
                    <!-- 屏蔽，gaoyh，2012-03-27
                    <td width="384" nowrap="nowrap" class="2-td2-left">收入总额</td> 
                    <td nowrap="nowrap" class="2-td2-left">收入总额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">1</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='1' type='text' name='syze'
								id='1_1' style='text-align:right' value='0.00' size='13'
								onblur="checkNumInput(this)" onchange="compute_Row_1('1_1')" >
								<xsl:attribute name="value">
									<xsl:value-of select="syze" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">减：不征税收入</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">2</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='2' type='text' name='bzssr'
								id='2_1' style='text-align:right' value='0.00' size='13'
								onblur="checkNumInput(this)" onchange="compute_Row_1('2_1')">
							    <xsl:attribute name="value">
									<xsl:value-of select="bzssr" />
								</xsl:attribute>
								</input>	
										
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">免税收入</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">3</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='3' type='text' name='mssr'
								id='3_1' style='text-align:right' value='0.00' size='13'
								onblur="checkNumInput(this)" onchange="compute_Row_1('3_1')">
							    <xsl:attribute name="value">
									<xsl:value-of select="mssr" />
								</xsl:attribute>
								</input>	
										
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应税收入额（1-2-3）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">4</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='4' type='text' name='yssre'
								id='4_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class='text-gray'>
							    <xsl:attribute name="value">
									<xsl:value-of select="yssre" />
								</xsl:attribute>
								</input>	
										
					</td>
					-->
					<td nowrap="nowrap" class="2-td2-left">收入总额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">1</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='1' type='text' name='syze'
								id='1_1' style='text-align:right' value='0.00' size='13'
								onblur="checkNumInput(this)" onchange="compute_Row_1()" >
								<xsl:attribute name="value">
									<xsl:value-of select="syze" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">减：不征税收入</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">2</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='2' type='text' name='bzssr'
								id='2_1' style='text-align:right' value='0.00' size='13'
								onblur="checkNumInput(this)" onchange="compute_Row_2()">
							    <xsl:attribute name="value">
									<xsl:value-of select="bzssr" />
								</xsl:attribute>
								</input>	
										
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">免税收入</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">3</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='3' type='text' name='mssr'
								id='3_1' style='text-align:right' value='0.00' size='13'
								onblur="checkNumInput(this)" onchange="compute_Row_3()">
							    <xsl:attribute name="value">
									<xsl:value-of select="mssr" />
								</xsl:attribute>
								</input>	
										
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应税收入额（1-2-3）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">4</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='4' type='text' name='yssre'
								id='4_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class='text-gray'>
							    <xsl:attribute name="value">
									<xsl:value-of select="yssre" />
								</xsl:attribute>
								</input>	
										
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">税务机关核定的应税所得率（ %）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">5</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input type='hidden' name='yssdl' id='5_1'/><input tabindex='5' type='text' name='yssdlView'
								id='5_1_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class='text-gray'>
							    <xsl:attribute name="value">
									<xsl:value-of select="yssdl" />
								</xsl:attribute>
								</input>	
										
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应纳税所得额（4行×5行）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">6</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='6' type='text' name='ynssde'
								id='6_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class="text-gray">
								<xsl:attribute name="value">
									<xsl:value-of select="ynssde" />
								</xsl:attribute>
								</input>	
					</td>
                  </tr>
                  <tr> 
                    <td rowspan="3" nowrap="nowrap" class="2-td2-left">按成本费用核定应纳税所得额</td>
                    <td class="2-td2-left" nowrap="nowrap">成本费用总额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">7</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='7_1'  value='*'  size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">税务机关核定的应税所得率（ %）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">8</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='8_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应纳税所得额[7行÷（1－8行）×8行]</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">9</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='9_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                  <!--屏蔽，guoxh，2012-2-24
		  <tr> 
                    <td rowspan="4" nowrap="nowrap" class="2-td2-left">按经费支出换算应纳税所得额</td>
                    <td class="2-td2-left" nowrap="nowrap">经费支出总额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">7</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='7_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">税务机关核定的应税所得率（ %）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">8</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='8_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">换算的收入额[7行÷（1－8行）]</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">9</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='9_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应纳税所得额（8行×9行）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">10</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='10_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>-->
                  <tr> 
                    <td colspan="2" rowspan="2" nowrap="nowrap" class="2-td2-left">应纳所得税额的计算</td>
                    <td class="2-td2-left" nowrap="nowrap">税率（25%）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">10</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input type='hidden' name='sl' id='10_1'/><input tabindex='10' type='text' name='slView'
								id='10_1_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class='text-gray'>
							   <xsl:attribute name="value">
									<xsl:value-of select="sl" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应纳所得税额（6行×10行）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">11</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='11' type='text' name='ynsdse'
								id='11_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class='text-gray'
								onblur='checkNumInput(this)' onchange='compute_Row_11()'>
								<xsl:attribute name="value">
									<xsl:value-of select="ynsdse" />
								</xsl:attribute>
								</input>	
					</td>
                  </tr>
		  <!--屏蔽，guoxh，2012-2-24
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">减免所得税额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">13</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='13' type='text' name='jmsdse'
								id='13_1' style='text-align:right' value='0.00' size='13'
								onblur='checkNumInput(this)' onchange='compute_Row_13()'>
								<xsl:attribute name="value">
									<xsl:value-of select="jmsdse" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>-->
                  <tr> 
                    <td colspan="2" rowspan="3" nowrap="nowrap" class="2-td2-left">应补（退）所得税额的计算</td>
                    <td class="2-td2-left" nowrap="nowrap">减：符合条件的小型微利企业减免所得税额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">12</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='12' type='text' name='xwqyjmsdse'
								id='12_1' style='text-align:right' value='0.00' size='13'
								onblur='checkNumInput(this)' onchange='compute_Row_12()'>
								<xsl:attribute name="value">
									<xsl:value-of select="xwqyjmsdse" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">已预缴所得税额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">13</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='13' type='text' name='yyjsdse'
								id='13_1' style='text-align:right' value='0.00' size='13'
								onblur='checkNumInput(this)' onchange='compute_Row_13()'>
								<xsl:attribute name="value">
									<xsl:value-of select="yyjsdse" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>
                  <tr> 
                    <td class="2-td2-left" nowrap="nowrap">应补（退）所得税额（11行－12行-13行）</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">14</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='14' type='text' name='ybsdse'
								id='14_1' style='text-align:right' value='0.00' size='13'
								readonly='true' class="text-gray">
								<xsl:attribute name="value">
									<xsl:value-of select="ybsdse" />
								</xsl:attribute>
								</input>
					</td>
                  </tr>
				   <tr> 
                    <td colspan="5" nowrap="nowrap" class="2-td2-center"><div align="left"><B>二、以下由税务机关核定应纳所得税额的企业填报</B></div></td>
                  </tr>
				  <tr> 
                    <td colspan="3" class="2-td2-left" nowrap="nowrap">税务机关核定应纳所得税额</td>
                    <td class="2-td2-left" nowrap="nowrap"><div align="center">15</div></td>
                    <td class="2-td2-center" nowrap="nowrap"><input tabindex='-1' type='text' name='ljje'
								id='9_1' value='*' size='1' readonly='true'
								class='text-noborder' style='text-align:center'/>
					</td>
                  </tr>
                </table>
                </div></td></tr></table>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
