/**
 * Copyright (c) Beans factory Pte Ltd. All Rights Reserved.
 * Generated: 19-ʮһ��-2003 20:46:23
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
public class Skfdqk implements ORObject {

	String lrr;
	Timestamp zhgxsj;
	String skfdqkdm;
	String zxbs;
	Timestamp lrrq;
	String skfdqkmc;
	public Skfdqk () {}
	public String getLrr() {
		return lrr;
	}
	public Timestamp getZhgxsj() {
		return zhgxsj;
	}
	public String getSkfdqkdm() {
		return skfdqkdm;
	}
	public String getZxbs() {
		return zxbs;
	}
	public Timestamp getLrrq() {
		return lrrq;
	}
	public String getSkfdqkmc() {
		return skfdqkmc;
	}
	public void setLrr( String _lrr ) {
		lrr = _lrr;
	}
	public void setZhgxsj( Timestamp _zhgxsj ) {
		zhgxsj = _zhgxsj;
	}
	public void setSkfdqkdm( String _skfdqkdm ) {
		skfdqkdm = _skfdqkdm;
	}
	public void setZxbs( String _zxbs ) {
		zxbs = _zxbs;
	}
	public void setLrrq( Timestamp _lrrq ) {
		lrrq = _lrrq;
	}
	public void setSkfdqkmc( String _skfdqkmc ) {
		skfdqkmc = _skfdqkmc;
	}

}
