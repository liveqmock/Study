/**
 * Copyright (c) Beans factory Pte Ltd. All Rights Reserved.
 * Generated: 10-����-2003 16:35:42
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
public class Czzsnbqy implements ORObject {

	String jsjdm;
	BigDecimal bqljs;
	String xmmc;
	String nd;
	String hc;
    String swjgzzjgdm;
    String qxdm;
    Timestamp cjrq;
    Timestamp lrrq;
	public Czzsnbqy () {}
	public String getJsjdm() {
		return jsjdm;
	}
	public BigDecimal getBqljs() {
		return bqljs;
	}
	public String getXmmc() {
		return xmmc;
	}
	public String getNd() {
		return nd;
	}
	public String getHc() {
		return hc;
	}

        public String getSwjgzzjgdm()
        {
            return swjgzzjgdm;
        }

	public void setJsjdm( String _jsjdm ) {
		jsjdm = _jsjdm;
	}
	public void setBqljs( BigDecimal _bqljs ) {
		bqljs = _bqljs;
	}
	public void setXmmc( String _xmmc ) {
		xmmc = _xmmc;
	}
	public void setNd( String _nd ) {
		nd = _nd;
	}
	public void setHc( String _hc ) {
		hc = _hc;
	}

        public void setSwjgzzjgdm(String _swjgzzjgdm)
        {
            swjgzzjgdm = _swjgzzjgdm;
        }
    public Timestamp getCjrq()
    {
        return cjrq;
    }
    public void setCjrq(Timestamp cjrq)
    {
        this.cjrq = cjrq;
    }
    public Timestamp getLrrq()
    {
        return lrrq;
    }
    public void setLrrq(Timestamp lrrq)
    {
        this.lrrq = lrrq;
    }
    public String getQxdm()
    {
        return qxdm;
    }
    public void setQxdm(String qxdm)
    {
        this.qxdm = qxdm;
    }

}
