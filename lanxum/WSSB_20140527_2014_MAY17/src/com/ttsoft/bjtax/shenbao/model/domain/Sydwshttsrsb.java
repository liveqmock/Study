/**
 * Copyright (c) Beans factory Pte Ltd. All Rights Reserved.
 * Generated: 01-����-2003 13:42:16
 * 
 * <p>
 * This SOURCE CODE FILE, which has been generated by Designer for use 
 * ONLY by licensed users of the product, includes CONFIDENTIAL and 
 * PROPRIETARY information of Beans Factory.  
 *
 */
package com.ttsoft.bjtax.shenbao.model.domain;
import java.sql.*;
import java.util.*;
import java.math.BigDecimal;
import com.ekernel.db.or.ORObject;

/**
* This is the entity / business object
* We will use this business object to demonstrate OR Mapping in Kernl can
* be used for composition.
**/
public class Sydwshttsrsb implements ORObject {

	String HC;
	String XMMC;
	double BQLJS;
	String LRR;
	Timestamp SKSSKSRQ;
	Timestamp CJSJ;
	Timestamp SKSSJSRQ;
	String SWJGZZJGDM;
	String ND;
	Timestamp LRRQ;
	String JSJDM;
	public Sydwshttsrsb () {}
	public String getHC() {
		return HC;
	}
	public String getXMMC() {
		return XMMC;
	}
	public double getBQLJS() {
		return BQLJS;
	}
	public String getLRR() {
		return LRR;
	}
	public Timestamp getSKSSKSRQ() {
		return SKSSKSRQ;
	}
	public Timestamp getCJSJ() {
		return CJSJ;
	}
	public Timestamp getSKSSJSRQ() {
		return SKSSJSRQ;
	}
	public String getSWJGZZJGDM() {
		return SWJGZZJGDM;
	}
	public String getND() {
		return ND;
	}
	public Timestamp getLRRQ() {
		return LRRQ;
	}
	public String getJSJDM() {
		return JSJDM;
	}
	public void setHC( String _HC ) {
		HC = _HC;
	}
	public void setXMMC( String _XMMC ) {
		XMMC = _XMMC;
	}
	public void setBQLJS( double _BQLJS ) {
		BQLJS = _BQLJS;
	}
	public void setBQLJS( BigDecimal _BQLJS ) {
		BQLJS = _BQLJS.doubleValue();
	}
	public void setLRR( String _LRR ) {
		LRR = _LRR;
	}
	public void setSKSSKSRQ( Timestamp _SKSSKSRQ ) {
		SKSSKSRQ = _SKSSKSRQ;
	}
	public void setCJSJ( Timestamp _CJSJ ) {
		CJSJ = _CJSJ;
	}
	public void setSKSSJSRQ( Timestamp _SKSSJSRQ ) {
		SKSSJSRQ = _SKSSJSRQ;
	}
	public void setSWJGZZJGDM( String _SWJGZZJGDM ) {
		SWJGZZJGDM = _SWJGZZJGDM;
	}
	public void setND( String _ND ) {
		ND = _ND;
	}
	public void setLRRQ( Timestamp _LRRQ ) {
		LRRQ = _LRRQ;
	}
	public void setJSJDM( String _JSJDM ) {
		JSJDM = _JSJDM;
	}

}