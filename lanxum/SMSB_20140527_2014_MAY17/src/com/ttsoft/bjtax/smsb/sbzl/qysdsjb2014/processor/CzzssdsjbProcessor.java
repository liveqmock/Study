/**
 *
 */
package com.ttsoft.bjtax.smsb.sbzl.qysdsjb2014.processor;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.syax.creports.Constants;
import com.syax.creports.bo.qysds.QysdsReportsConstants;
import com.syax.creports.bo.qysds.QysdsReportsDeclare;
import com.syax.creports.bo.qysds.QysdsReportsItemDeclare;
import com.syax.creports.bo.qysds.QysdsReportsTableDeclare;
import com.syax.creports.persistent.AppAccessFactory;
import com.syax.creports.persistent.access.IAppAccess;
import com.ttsoft.bjtax.dj.model.SWDJJBSJ;
import com.ttsoft.bjtax.jikuai.zwcl.inf.JKAdapter;
import com.ttsoft.bjtax.sfgl.common.db.util.SfDBAccess;
import com.ttsoft.bjtax.sfgl.common.db.util.SfDBResource;
import com.ttsoft.bjtax.sfgl.common.model.QysdsSet;
import com.ttsoft.bjtax.sfgl.common.model.Zsfs;
import com.ttsoft.bjtax.sfgl.common.util.Debug;
import com.ttsoft.bjtax.sfgl.common.util.SfDateUtil;
import com.ttsoft.bjtax.sfgl.common.util.SfTimeUtil;
import com.ttsoft.bjtax.sfgl.proxy.ServiceProxy;
import com.ttsoft.bjtax.shenbao.model.domain.Jm;
import com.ttsoft.bjtax.smsb.constant.CodeConstant;
import com.ttsoft.bjtax.smsb.model.client.Ysjc;
import com.ttsoft.bjtax.smsb.sbzl.qysdsjb2014.web.CzzssdsjbForm;
import com.ttsoft.bjtax.smsb.util.InterfaceDj;
import com.ttsoft.bjtax.smsb.util.JksUtil;
import com.ttsoft.bjtax.smsb.util.QysdsNewUtil;
import com.ttsoft.bjtax.smsb.util.Skssrq;
import com.ttsoft.bjtax.smsb.util.TinyTools;
import com.ttsoft.common.model.UserData;
import com.ttsoft.framework.exception.ApplicationException;
import com.ttsoft.framework.exception.BaseException;
import com.ttsoft.framework.exception.ExceptionUtil;
import com.ttsoft.framework.processor.Processor;
import com.ttsoft.framework.util.VOPackage;
import com.ttsoft.bjtax.smsb.sbzl.qysdsjb2014.QysdsUtil2014;

/**
 * <p>
 * Title: ������˰�ۺϹ���ϵͳ �걨����-����ģ��
 * </p>
 * <p>
 * Description:2014����������ҵ����˰����
 * </p>
 *
 * @author gaoyh
 * @version 1.2
 */
public class CzzssdsjbProcessor implements Processor {

	// ��ҵ����˰˰��
	private static final String QYSDS_SL = "0.25";

    private QysdsUtil2014 util = new QysdsUtil2014();

	/**
	 * ʵ��Processor�ӿ�
	 *
	 * @param vo
	 *            ҵ�����
	 * @return Object VOPackage������
	 * @throws BaseException
	 *             ҵ���쳣 1 ���������Ĳ������Ͳ���ʱ�׳� 2 �����õ�ҵ�񷽷��׳�ҵ���쳣ʱ���ϴ����׳�
	 *             �����쳣�׳���EJB��process����������
	 */
	public Object process(VOPackage vo) throws BaseException {

		Object result = null;

		if (vo == null) {
			throw new NullPointerException();
		}
		//��ʼ��FORM�ı�־λ
		CzzssdsjbForm form = (CzzssdsjbForm) vo.getData();
		form.setSAVE_FLAG("0");

		//
		switch (vo.getAction()) {
		case CodeConstant.SMSB_SHOWACTION:
			result = doShow(vo);
			break;
		case CodeConstant.SMSB_QUERYACTION:
			result = doQuery(vo);
			break;
		case CodeConstant.SMSB_SAVEACTION:
			result = doSave(vo);
			break;
		case CodeConstant.SMSB_DELETEACTION:
			result = doDelete(vo);
			break;
		// case CodeConstant.SMSB_CHECKACTION:
		// result = doCheck(vo);
		// break;
		default:
			throw new ApplicationException("�û�ִ����ϵͳ��֧�ֵķ�������.");
		}

		return result;
	}

	/**
	 * doShow��ʼ������ҳ����ϢҪ��
	 *
	 * @param vo
	 *            ҵ�����
	 * @return ���ݶ���[�������null(��Action����Ҫ����ֵ)�������Ҫ����ֵ��������ActionForm]��
	 * @throws BaseException
	 *             ��������������׳��쳣��Ϣ
	 */

	private Object doShow(VOPackage vo) throws BaseException {
		// �õ�Action���ݹ���HdzssdsjbForm����
		CzzssdsjbForm form = (CzzssdsjbForm) vo.getData();
		// �õ���ǰʱ���������
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		Timestamp curTime = new Timestamp(System.currentTimeMillis());
		Map getsbjd = this.quarterSkssrq(curTime);
		Timestamp skssksrq = (Timestamp) getsbjd.get(Skssrq.SKSSKSRQ);
		Timestamp skssjsrq = (Timestamp) getsbjd.get(Skssrq.SKSSJSRQ);
		System.out.println("===================form.getSkssjsrq()========================="+form.getSkssjsrq());		
		if(form.getSkssjsrq()==null)
		{
			System.out.println("===================��˰�������ڵ�=========================");
			// ˰��������ʼ����
			form.setSkssksrq(SfTimeUtil.getDateFromDateTime(skssksrq));
			// ˰��������������
			form.setSkssjsrq(SfTimeUtil.getDateFromDateTime(skssjsrq));
			// ˰���걨����
			form.setSbrq(SfDateUtil.getDate());
		}else{
			System.out.println("===================��˰�������ڵ�=========================");			
		}
		// ˰���걨����
		form.setSbrq(SfDateUtil.getDate());
		return form;
	}

	/**
	 * doQuery ���ڷ���ҳ����Ҫ��ѯ���꾡��Ϣ
	 *
	 * @param vo
	 *            ҵ�����
	 * @return ���ݶ���[�������null(��Action����Ҫ����ֵ)�������Ҫ����ֵ��������ActionForm]��
	 * @throws BaseException
	 *             ��������������׳��쳣��Ϣ
	 *
	 */

	private Object doQuery(VOPackage vo) throws BaseException {

		// �õ�Action���ݹ���CzzssdsjbForm����
		CzzssdsjbForm CzzssdsjbForm = (CzzssdsjbForm) vo.getData();
		Connection conn = null;

		try {
			// �������ݿ�����
			conn = SfDBResource.getConnection();
			// ��ȡ˰����������
			// Map getsbnd = this.quarterSkssrq(SfDateUtil.getDate(CzzssdsjbForm
			// .getSbrq()));
			// ��ȡ˰����������
			String jd = QysdsNewUtil.preQuarter(SfDateUtil.getDate(CzzssdsjbForm.getSkssjsrq()));

			System.out.println(CzzssdsjbForm.getJsjdm()+ "CzzssdsjbForm.getSbrq()��" + CzzssdsjbForm.getSbrq());
			System.out.println(CzzssdsjbForm.getJsjdm()
					+ "CzzssdsjbForm.getSkssjsrq()��"
					+ CzzssdsjbForm.getSkssjsrq());
			System.out.println(CzzssdsjbForm.getJsjdm() + "��jd��" + jd);

			// ��ȡ˰���������
			// String sknd = this.getNd(jd, getsbnd, CzzssdsjbForm.getSbrq());
			// String nd = (String)getsbnd.get(Skssrq.SKSSRQ_ND);
			// ��ҳ����ȡ��˰�������ں����
			String nd = CzzssdsjbForm.getSkssksrq().substring(0, 4);
			// ���ü���
			CzzssdsjbForm.setQh(jd);
			// �������
			CzzssdsjbForm.setSknd(nd);
			
			// ����form��������������
			CzzssdsjbForm = (CzzssdsjbForm) QysdsNewUtil.queryDjxxByInterfaceDJ(conn, CzzssdsjbForm, vo.getUserData());
			
			QysdsUtil2014 qysdsUtil2014=new QysdsUtil2014();
			SWDJJBSJ djsj = null;
			try {
				// �����ҵ�Ǽǻ�����Ϣ
				djsj = InterfaceDj.getJBSJ_New(CzzssdsjbForm.getJsjdm(), vo.getUserData());
			} catch (Exception ex1) {
				throw new ApplicationException("û�и���˰�˵ĵǼ���Ϣ����û��Ȩ�޲鿴����˰����Ϣ��");
			}
			//��ȡ�Ƿ����¿���  �ǣ�Y ��N 
			CzzssdsjbForm.setSfxkh(qysdsUtil2014.getSfxkh(nd,djsj,jd));						
			//��ȡ˰�����������������һ������շ�ʽ
			CzzssdsjbForm.setSyndZsfsdm(qysdsUtil2014.getSyndZsfsDm(CzzssdsjbForm.getJsjdm(), nd,jd));
			//��ȡ˰�����������������һ��ȵĻ�������걨��Ϣ ������9��25 ������45��46��47
			Map map=qysdsUtil2014.getSyndHsqjSbxx(CzzssdsjbForm.getSyndZsfsdm(),CzzssdsjbForm.getJsjdm(), nd,jd);
			CzzssdsjbForm.setSyndZbh6(map.get("syndZbh6").toString());
			CzzssdsjbForm.setSyndZbh25(map.get("syndZbh25").toString());
			CzzssdsjbForm.setSyndFb5jyjg(map.get("syndFb5jyjg").toString());

			System.out.println("��ҵ��������1_" + CzzssdsjbForm.getQyzslx());
			// ˰�Ѻ˶���Ϣ
			this.getHdxx(CzzssdsjbForm);
			System.out.println("��ҵ��������2_" + CzzssdsjbForm.getQyzslx());
			/* ���շ�ʽ */
			String zsfs = CzzssdsjbForm.getZsfs();

			System.out.println(CzzssdsjbForm.getJsjdm() + "�����շ�ʽ���룺" + zsfs);

			if (zsfs == null || (zsfs != null && zsfs.equals(""))) {
				throw new ApplicationException("û�в�ѯ������ҵ�����շ�ʽ�϶���Ϣ�����϶����ٽ����걨¼�룡");
			}
			if (!(CodeConstant.ZSFSDM_CZZS.equals(zsfs))) {
				throw new ApplicationException("����ҵ���϶�Ϊ�˶����ջ��������ڴ�¼�룬��¼����Ӧ�����걨����");
			}

			// ����QysdsReportsDeclare����
			QysdsReportsDeclare report = new QysdsReportsDeclare();
			// ��form�еĻ�����Ϣת��QysdsReportsDeclare report ��
			QysdsNewUtil.setQysdsReport(report, CzzssdsjbForm);
			report.setVersion(CodeConstant.SBZL_QYSDSJB_VERSION_2014);
			
			// ����QysdsReportsTableDeclare�Ļ�����Ϣ
			QysdsReportsTableDeclare table = new QysdsReportsTableDeclare();
			table.setTableId(CodeConstant.TABLE_ID_CZQYSDSJB_2008);
			table.setTableName(CodeConstant.TABLE_NAME_CZQYSDSJB_2008);
			table.setTbblx(Constants.CREPORTS_IBBQLX_TYPE_QUARTOR);
			// ��QysdsReportsTableDeclare�Ļ�����Ϣ����QysdsReportsDeclare
			report.getTableContentList().put(table.getTableId(), table);
			// ��ȡ���ݿ�Ӧ�ýӿ�
			IAppAccess iApp = AppAccessFactory.getAInstance(conn,
					AppAccessFactory.ACCESS_MODEL_APP_QYSDS);
			// ���ò�ѯ�������в�ѯ
			iApp.querySingleTable(report);
			// ��ȡ��ѯ���ľ�������
			table = (QysdsReportsTableDeclare) report.getTableContentList().get(CodeConstant.TABLE_ID_CZQYSDSJB_2008);

			if (table.getCellContentList().size() > 0) {
				CzzssdsjbForm.setSbrq(TinyTools.Date2String(report.getSbrq(),"yyyyMMdd"));
				CzzssdsjbForm.setSkssksrq(TinyTools.Date2String(report.getSkssksrq(), "yyyyMMdd"));
				CzzssdsjbForm.setSkssjsrq(TinyTools.Date2String(report.getSkssjsrq(), "yyyyMMdd"));
			}

			// �����ݿ��е����ݷ����ҳ���������ݸ�ʽ
			int[] arrs = { 1, 35 };
			CzzssdsjbForm.setQysdsjbList(this.translate2Page(putSpace(table,arrs), zsfs));
			// �����ݿ��дӱ������ݷ����ҳ���������ݸ�ʽ
			this.cb_translate2Page(putSpace(table,arrs), zsfs,CzzssdsjbForm);


			// �����ã���ɺ�Ҫɾ��
			System.out.println("���������-" + CzzssdsjbForm.getJsjdm());
			System.out.println("�걨����-" + CzzssdsjbForm.getSbrq());
			System.out.println("��˰������-" + CzzssdsjbForm.getNsrmc());
			System.out.println("˰�����-" + CzzssdsjbForm.getSknd());
			System.out.println("�ں�-" + CzzssdsjbForm.getQh());
			System.out.println("����������-" + CzzssdsjbForm.getBbqlx());
			System.out.println("˰��������ʼ����-" + CzzssdsjbForm.getSkssksrq());
			System.out.println("˰��������������-" + CzzssdsjbForm.getSkssjsrq());
			System.out.println("˰�������֯��������-" + CzzssdsjbForm.getSwjgzzjgdm());
			System.out.println("���ش���-" + CzzssdsjbForm.getQxdm());
			System.out.println("¼����-" + CzzssdsjbForm.getLrr());
			System.out.println("˰�������������-" + CzzssdsjbForm.getSwjsjdm());
			System.out.println("��ҵ��������_" + CzzssdsjbForm.getQyzslx());
			System.out.println("�걨��������_"+ CzzssdsjbForm.getQysdsjbList().size());

		} catch (Exception e) {
			// �׳��쳣
			e.printStackTrace();
			throw ExceptionUtil.getBaseException(e);
		} finally {
			// �ͷ����ݿ�����
			SfDBResource.freeConnection(conn);
		}
		// ��ѯ�ɹ�����CzzssdsjbForm
		return CzzssdsjbForm;
	}

	/**
	 * doSave ���ڴ洢ҳ���ύ���꾡������Ϣ
	 *
	 * @param vo
	 *            ҵ�����
	 * @return ���ݶ���[�������null(��Action����Ҫ����ֵ)�������Ҫ����ֵ��������ActionForm]
	 * @throws BaseException
	 *             ��������������׳��쳣��Ϣ
	 */

	private Object doSave(VOPackage vo) throws BaseException {
		// �õ�Action���ݹ���CzzssdsjbForm����

		CzzssdsjbForm czzssdsjbForm = (CzzssdsjbForm) vo.getData();
		Connection conn = null;

		// Map getsbnd = this.quarterSkssrq(SfDateUtil.getDate(CzzssdsjbForm
		// .getSbrq()));
		// ��ȡ˰����������
		String jd = QysdsNewUtil.preQuarter(SfDateUtil.getDate(czzssdsjbForm.getSkssjsrq()));
		// ��ȡ˰���������
		// String sknd = this.getNd(jd, getsbnd, CzzssdsjbForm.getSbrq());
		// String nd = (String)getsbnd.get(Skssrq.SKSSRQ_ND);
		// ��ҳ����ȡ��˰�������ں����
		String nd = czzssdsjbForm.getSkssksrq().substring(0, 4);
		// ���ü���
		czzssdsjbForm.setQh(jd);
		// �������
		czzssdsjbForm.setSknd(nd);

		try {

			// /* ���շ�ʽ */
			// String zsfs = QysdsNewUtil.getZsfsdm(CzzssdsjbForm);
			//
			// System.out.println(CzzssdsjbForm.getJsjdm()+"�����շ�ʽ���룺"+zsfs);
			//
			//
			// if(zsfs==null ||(zsfs!=null && zsfs.equals(""))){
			// throw new ApplicationException(
			// "û�в�ѯ������ҵ�����շ�ʽ�϶���Ϣ�����϶����ٽ����걨¼�룡");
			// }
			// if (CodeConstant.ZSFSDM_CZZS.equals(zsfs)) {
			// throw new ApplicationException(
			// "����ҵ���϶�Ϊ�������ջ��������ڴ�¼�룬��¼��������ռ����걨����");
			// }
			// /* ���շ�ʽ */
			String zsfs = czzssdsjbForm.getZsfs();
			// �������ݿ�����
			conn = SfDBResource.getConnection();
			// ��CzzssdsjbForm�е����ݽṹת�����������ݿ�ӿڲ���Ҫ������ݽṹ
			QysdsReportsDeclare report = this.translate2Interface(czzssdsjbForm, zsfs);
			// ��ȡ���ݿ�Ӧ�ýӿ�
			IAppAccess iApp = AppAccessFactory.getAInstance(conn,
					AppAccessFactory.ACCESS_MODEL_APP_QYSDS);
			// ����saveSingleTable�����������ݱ���
			iApp.saveSingleTable(report);

			/**
			 * �������˰
			 */
			List list = czzssdsjbForm.getQysdsjbList();

			for (int i = 0; i < list.size(); i++) {

				if (i == 12) {
					// ��12�еļ���˰��
					HashMap map = (HashMap) list.get(i);
					System.out.println(czzssdsjbForm.getJsjdm() + "�ļ����д�:"
							+ (String) map.get("hc"));
					System.out.println(czzssdsjbForm.getJsjdm() + "�ļ����д�:"
							+ (String) map.get("lje"));

					// ʹ��OrMap�������ݿ�ķ�װ��
					SfDBAccess da = new SfDBAccess(conn);
					SWDJJBSJ djxx = null;
					UserData ud = (UserData) vo.getUserData();
					try {
						/* start added by huxiaofeng 2005.8.16 */
						// djxx = InterfaceDj.getJBSJ(form.getJsjdm(), ud);
						djxx = InterfaceDj.getJBSJ_New(
								czzssdsjbForm.getJsjdm(), ud);
						/* end added by huxiaofeng 2005.8.16 */

					} catch (Exception ex1) {
						throw ExceptionUtil.getBaseException(ex1);
					}

					Timestamp skssksrq = QysdsNewUtil
							.getTimestamp(czzssdsjbForm.getSkssksrq());
					Timestamp skssjsrq = QysdsNewUtil
							.getTimestamp(czzssdsjbForm.getSkssjsrq());
					Timestamp sbrq = QysdsNewUtil.getTimestamp(czzssdsjbForm
							.getSbrq());

					Timestamp now = new Timestamp(System.currentTimeMillis());

					// ��һ������������걨����
					this.insertJmJb(((String) map.get("lje")),czzssdsjbForm, da, ud, djxx, now, now, sbrq, skssjsrq,skssksrq, nd);

				}
			}

			// ��ȡһ�����п�ֵ��QysdsReportsTableDeclare����
			QysdsReportsTableDeclare table = (QysdsReportsTableDeclare) report
					.getTableContentList().get(
							CodeConstant.TABLE_ID_CZQYSDSJB_2008);
			// table.setCellContentList(new HashMap());

			// �����ݿ��е����ݷ����ҳ���������ݸ�ʽ
			int[] arrs = { 1, 30 };

			czzssdsjbForm.setQysdsjbList(this.translate2Page(putSpace(table,
					arrs), zsfs));

			czzssdsjbForm.setSAVE_FLAG("1");//�޸ı�־λ

			czzssdsjbForm = (CzzssdsjbForm) this.doShow(vo);

		} catch (Exception ex) {
			// �׳��쳣
			ex.printStackTrace();
			throw ExceptionUtil.getBaseException(ex);
		} finally {
			// �ͷ����ݿ�����
			SfDBResource.freeConnection(conn);
		}
		// ����ɹ�����CzzssdsjbForm
		return czzssdsjbForm;
	}

	/**
	 * ���㼾�����͵�˰����������
	 *
	 * @param curDate
	 *            ����
	 * @return Map ʹ��Key �� Skssrq.SKSSKSRQ �õ� ˰��������ʼ����Timestamp ʹ��Key ��
	 *         Skssrq.SKSSJSRQ �õ� ˰��������������Timestamp ʹ��Key �� Skssrq.SKSSRQ_ND �õ�
	 *         ˰�������������ڵ���� String
	 */
	public Map quarterSkssrq(Date curDate) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(curDate);
		int month = calendar.get(calendar.MONTH);
		int year = calendar.get(calendar.YEAR);

		int jd = month / 3;
		if (jd == 0) {
			year--;
			jd = 4;
		}
		String nd = new Integer(year).toString();
		Timestamp skssksrqDate = new Timestamp(
				new GregorianCalendar(year, 0, 1).getTime().getTime());
		Timestamp skssjsrqDate = new Timestamp(new GregorianCalendar(year,
				(jd - 1) * 3 + 2, new GregorianCalendar(year, (jd - 1) * 3 + 2,
						1).getActualMaximum(calendar.DAY_OF_MONTH)).getTime()
				.getTime());
		Map retMap = new HashMap();
		retMap.put(Skssrq.SKSSKSRQ, skssksrqDate);
		retMap.put(Skssrq.SKSSJSRQ, skssjsrqDate);
		retMap.put(Skssrq.SKSSRQ_ND, nd);
		return retMap;
	}

	/**
	 * ��ActionForm�е����ݽṹת���������ݿ�ӿڲ���Ҫ������ݽṹ ҳ�����ݽṹ-->�ӿ����ݽṹ
	 *
	 * @param form
	 * @return ��ҵ����˰������������
	 */
	private QysdsReportsDeclare translate2Interface(CzzssdsjbForm form,
			String zsfs) throws ApplicationException {

		// ����QysdsReportsDeclare����
		QysdsReportsDeclare report = new QysdsReportsDeclare();
		// ��form�еĻ�����Ϣת��QysdsReportsDeclare������
		QysdsNewUtil.setQysdsReport(report, form);
		report.setVersion(CodeConstant.SBZL_QYSDSJB_VERSION_2014);

		// ������ҵ����˰�����ڵ����������󣬲����������Ϣ
		QysdsReportsTableDeclare table = new QysdsReportsTableDeclare();
		table.setTableId(CodeConstant.TABLE_ID_CZQYSDSJB_2008);
		table.setTableName(CodeConstant.TABLE_NAME_CZQYSDSJB_2008);
		table.setTbblx(Constants.CREPORTS_IBBQLX_TYPE_QUARTOR);

		// ��ҳ�����ݷ�������ݿ�ӿ���������ݸ�ʽ
		List list = form.getQysdsjbList();

		for (int i = 0; i < list.size(); i++) {
			HashMap map = (HashMap) list.get(i);
			
			String hc = (String) map.get("hc");

			System.out.println("hc=" + hc + "|" + "lje=" + map.get("lje"));
			System.out.println("list.size()===" + list.size());
			if (i < 35) {
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(hc);
				item_1.setItemValue((String) map.get("lje"));
					// System.out.println("����lje3" + (String) map.get("lje"));
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			} else {
					throw new ApplicationException("������д�����!!!");
			}
			
		}
		//���ӱ��е��������ӵ�table��
		cb_translate2Interface(form,table);
		
		System.out.println("table.getTableId()==="+table.getTableId());
		System.out.println("table.getTableName()==="+table.getTableName());
		System.out.println("table.getTbblx()==="+table.getTbblx());
		
		report.getTableContentList().put(table.getTableId(), table);
		return report;
	}
	private void cb_translate2Interface(CzzssdsjbForm form,QysdsReportsTableDeclare table){
		//����Ҫ���浽�ӱ������ݴ���table��
		List cblist = form.getCbsb_qysdsjbList();
		for(int i=0;i<cblist.size();i++){
			HashMap map = (HashMap) cblist.get(i);
			String cbJmxmYzhc =(String) map.get(form.getCbsb_columns()[0]);
			if(null!=cbJmxmYzhc&&!"".equals(cbJmxmYzhc)){
				String cbJmxmYz=(String) map.get(form.getCbsb_columns()[1]);
				if(null==cbJmxmYz||"".equals(cbJmxmYz)){
					cbJmxmYz="0.00";
				}
				System.out.println("................."+map.get("cbJmxmYzhc")+":"+map.get("cbJmxmYz"));
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(cbJmxmYzhc);
				item_1.setItemValue(cbJmxmYz);
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			}
			String cbJmxmDmhc =(String) map.get(form.getCbsb_columns()[2]);
			if(null!=cbJmxmDmhc&&!"".equals(cbJmxmDmhc)){
				System.out.println("................."+map.get("cbJmxmDmhc")+":"+map.get("cbJmxmDm"));
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(cbJmxmDmhc);
				item_1.setItemValue((String) map.get(form.getCbsb_columns()[3]));
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			}
		}
		//����Ҫ���浽�ӱ���˰������Ŀ�����ݴ���table��
		List cbMssrxmList = form.getCbsbMssrxmList();
		for(int i=0;i<cbMssrxmList.size();i++){
			HashMap map = (HashMap) cbMssrxmList.get(i);
			String cbMssrxmYzhc =(String) map.get(form.getCbsbMssrxmCol()[0]);
			if(null!=cbMssrxmYzhc&&!"".equals(cbMssrxmYzhc)){
				String cbMssrxmYz=(String) map.get(form.getCbsbMssrxmCol()[1]);
				if(null==cbMssrxmYz||"".equals(cbMssrxmYz)){
					cbMssrxmYz="0.00";
				}
				
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(cbMssrxmYzhc);
				item_1.setItemValue(cbMssrxmYz);
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			}
			String cbMssrxmDmhc =(String) map.get(form.getCbsbMssrxmCol()[2]);
			if(null!=cbMssrxmDmhc&&!"".equals(cbMssrxmDmhc)){
				
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(cbMssrxmDmhc);
				item_1.setItemValue((String) map.get(form.getCbsbMssrxmCol()[3]));
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			}
		}	
		
		//����Ҫ���浽�ӱ�������������Ŀ�����ݴ���table��
		List cbJzmzxmList = form.getCbsbJzmzxmList();
		for(int i=0;i<cbJzmzxmList.size();i++){
			HashMap map = (HashMap) cbJzmzxmList.get(i);
			String cbJzmzxmYzhc =(String) map.get(form.getCbsbJzmzxmCol()[0]);
			if(null!=cbJzmzxmYzhc&&!"".equals(cbJzmzxmYzhc)){
				String cbJzmzxmYz=(String) map.get(form.getCbsbJzmzxmCol()[1]);
				if(null==cbJzmzxmYz||"".equals(cbJzmzxmYz)){
					cbJzmzxmYz="0.00";
				}
				
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(cbJzmzxmYzhc);
				item_1.setItemValue(cbJzmzxmYz);
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			}
			String cbJzmzxmDmhc =(String) map.get(form.getCbsbJzmzxmCol()[2]);
			if(null!=cbJzmzxmDmhc&&!"".equals(cbJzmzxmDmhc)){
				
				QysdsReportsItemDeclare item_1 = new QysdsReportsItemDeclare();
				item_1.setItemID(cbJzmzxmDmhc);
				item_1.setItemValue((String) map.get(form.getCbsbJzmzxmCol()[3]));
				item_1.setItemType("11");
				table.getCellContentList().put(item_1.getItemID(), item_1);
			}
		}
	}
	/**
	 * ���ӿ����ݽṹ�е�����ת��������ҳ��Ҫ������ݽṹ �ӿ����ݽṹ-->ҳ�����ݽṹ
	 *
	 * @param QysdsReportsTableDeclare
	 * @return ҳ��������ݵ�List����
	 */
	private List translate2Page(QysdsReportsTableDeclare table, String zsfs) {

		System.out.println("table.getCellContentList().keySet()==="+table.getCellContentList().keySet());

		// ����ÿ��������Ӧ��map
		HashMap map1 = new HashMap();
		HashMap map2 = new HashMap();
		HashMap map3 = new HashMap();
		HashMap map4 = new HashMap();
		HashMap map5 = new HashMap();
		HashMap map6 = new HashMap();
		HashMap map7 = new HashMap();
		HashMap map8 = new HashMap();
		HashMap map9 = new HashMap();
		HashMap map10 = new HashMap();
		HashMap map11 = new HashMap();
		HashMap map12 = new HashMap();
		HashMap map13 = new HashMap();
		HashMap map14 = new HashMap();
		HashMap map15 = new HashMap();
		HashMap map16 = new HashMap();
		HashMap map17 = new HashMap();
		HashMap map18 = new HashMap();
		HashMap map19 = new HashMap();
		HashMap map20 = new HashMap();
		
		HashMap map30 = new HashMap();
		HashMap map31 = new HashMap();
		HashMap map32 = new HashMap();
		HashMap map33 = new HashMap();
		HashMap map34 = new HashMap();
		HashMap map35 = new HashMap();
		
		
		// ����List�����������ҳ���������
		ArrayList pagelist = new ArrayList();
		// ת��������е�����

		// ת������
		map1.put("hc", "1");
		map1.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("1")).getItemValue());
		pagelist.add(map1);
		// ת������
		map2.put("hc", "2");
		map2.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("2")).getItemValue());
		pagelist.add(map2);

		map3.put("hc", "3");
		map3.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("3")).getItemValue());
		pagelist.add(map3);

		map4.put("hc", "4");
		map4.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("4")).getItemValue());
		pagelist.add(map4);

		map5.put("hc", "5");
		map5.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("5")).getItemValue());
		pagelist.add(map5);

		map6.put("hc", "6");
		map6.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("6")).getItemValue());
		pagelist.add(map6);

		map7.put("hc", "7");
		map7.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("7")).getItemValue());
		pagelist.add(map7);

		map8.put("hc", "8");
		map8.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("8")).getItemValue());
		pagelist.add(map8);

		map9.put("hc", "9");
		map9.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("9")).getItemValue());
		pagelist.add(map9);

		map10.put("hc", "10");
		map10.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("10")).getItemValue());
		pagelist.add(map10);
		
		// ת������
		map11.put("hc", "11");
		map11.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("11")).getItemValue());
		pagelist.add(map11);
		// ת������
		map12.put("hc", "12");
		map12.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("12")).getItemValue());
		pagelist.add(map12);

		map13.put("hc", "13");
		map13.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("13")).getItemValue());
		pagelist.add(map13);

		map14.put("hc", "14");
		map14.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("14")).getItemValue());
		pagelist.add(map14);

		map15.put("hc", "15");
		map15.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("15")).getItemValue());
		pagelist.add(map15);

		map16.put("hc", "16");
		map16.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("16")).getItemValue());
		pagelist.add(map16);

		map17.put("hc", "17");
		map17.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("17")).getItemValue());
		pagelist.add(map17);
		map18.put("hc", "18");
		map18.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("18")).getItemValue());
		pagelist.add(map18);

		map19.put("hc", "19");
		map19.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("19")).getItemValue());
		pagelist.add(map19);
		map20.put("hc", "20");
		map20.put("lje", ((QysdsReportsItemDeclare) table.getCellContentList().get("20")).getItemValue());
		pagelist.add(map20);
		
		// ��ʱռλ����

		if (table.getCellContentList().get("30") != null) {
			map30.put("hc", "30");
			map30.put("lje", ((QysdsReportsItemDeclare) table
					.getCellContentList().get("30")).getItemValue());
			pagelist.add(map30);
		}
		if (table.getCellContentList().get("31") != null) {
			map31.put("hc", "31");
			map31.put("lje", ((QysdsReportsItemDeclare) table
					.getCellContentList().get("31")).getItemValue());
			pagelist.add(map31);
		}
		if (table.getCellContentList().get("32") != null) {
			map32.put("hc", "32");
			map32.put("lje", ((QysdsReportsItemDeclare) table
					.getCellContentList().get("32")).getItemValue());
			pagelist.add(map32);
		}
		if (table.getCellContentList().get("33") != null) {
			map33.put("hc", "33");
			map33.put("lje", ((QysdsReportsItemDeclare) table
					.getCellContentList().get("33")).getItemValue());
			pagelist.add(map33);
		}
		if (table.getCellContentList().get("34") != null) {
			map34.put("hc", "34");
			map34.put("lje", ((QysdsReportsItemDeclare) table
					.getCellContentList().get("34")).getItemValue());
			pagelist.add(map34);
		}
		if (table.getCellContentList().get("35") != null) {
			map35.put("hc", "35");
			map35.put("lje", ((QysdsReportsItemDeclare) table
					.getCellContentList().get("35")).getItemValue());
			pagelist.add(map35);
		}
		
		// ����List����
		return pagelist;
	}

	/**
	 * ȡ��һ�ʺ���ҵ��˰����,����ҳ��У��
	 *
	 * @param form
	 * @throws BaseException
	 */
	private void getHdxx(CzzssdsjbForm form) throws BaseException {
		String qyzssllx = "3"; // ȱʡΪ�����걨

		// ��ҵ��˰��˰�� �������ҵ��˰��˰������
		String qyzssl = QYSDS_SL;

		// Ӧ������˰��
		String ynsdse = "0.00";
		// ��������˰��
		String dezsse = "0.00";

		// ��ǰʱ��
		// Timestamp sbrq = new Timestamp(System.currentTimeMillis());
		// ���걨ҳ��ȡ���걨���ں�˰����������
		Timestamp sbrq = QysdsNewUtil.getNxetTimestamp(form.getSkssjsrq());

		// Map getsbjd = this.quarterSkssrq(sbrq);
		Timestamp skssksrq = QysdsNewUtil.getTimestamp(form.getSkssksrq());
		Timestamp skssjsrq = QysdsNewUtil.getTimestamp(form.getSkssjsrq());

		System.out.println(form.getJsjdm() + "sbrq��" + sbrq);
		System.out.println(form.getJsjdm() + "skssksrq��" + skssksrq);
		System.out.println(form.getJsjdm() + "skssjsrq��" + skssjsrq);
        System.out.println(form.getJsjdm() + "qh��" + form.getQh());

		ServiceProxy proxy = new ServiceProxy();

		String bblx = form.getBbqlx();
		String jsjdm = form.getJsjdm();

		// ��ѯ˰�ѽӿ�
		QysdsSet qysdsSet = null;

		// ���ݿ����Ӷ���
	//	Connection conn = null;
	//	Statement st = null;
	//	ResultSet rs = null;
		// �����ʸ��ʶ
		boolean jm_type = false;

		try {
			if (bblx.equals(Constants.CREPORTS_IBBQLX_TYPE_YEAR)) {
				qysdsSet = proxy.getQysdsInfo(jsjdm, sbrq, skssksrq, skssjsrq,
						CodeConstant.SFGL_QYSDS_BBFS_NB);
			} else if (bblx.equals(Constants.CREPORTS_IBBQLX_TYPE_QUARTOR)) {
				/* ���Ϊ���ļ��ȣ���ȡ��ҵ����˰�϶���Ϣʱ���걨����ȡ */
				if (form.getQh() == null
						|| (form.getQh() != null && form.getQh().trim().equals(
								""))) {
					/* �ںŲ���Ϊ�գ����Ϊ���׳��쳣 */
					throw new ApplicationException("ϵͳ�����쳣���ں�Ϊ�գ�����ϵͳ����Ա��ϵ��");
				}
				if ("4".equals(form.getQh())) {
					qysdsSet = proxy.getQysdsInfo(jsjdm, sbrq, skssksrq,
							skssjsrq, CodeConstant.SFGL_QYSDS_BBFS_NB);
				} else {
					qysdsSet = proxy.getQysdsInfo(jsjdm, sbrq, skssksrq,
							skssjsrq, CodeConstant.SFGL_QYSDS_BBFS_JB);
                    //����Zsfs
                    Zsfs zsfs = util.getZsfsInfo(jsjdm, skssjsrq);
                    qysdsSet.setZsfs(zsfs);
				}
			}

		} catch (com.ttsoft.framework.exception.BaseException e) {
			e.printStackTrace();
			throw ExceptionUtil.getBaseException(e);
		}

		// 1����ѯ��ҵ���շ�ʽ
		Zsfs zsfs = qysdsSet.getZsfs();
		if (zsfs != null) {
			form.setZsfs(zsfs.getZsfsdm() == null ? CodeConstant.ZSFSDM_CZZS
					: zsfs.getZsfsdm());
		} else {
			form.setZsfs(CodeConstant.ZSFSDM_CZZS);
		}

		/* ���¼�����ҵ�϶����� */
		Date gxqyrdrq = qysdsSet.getGxjsqy();

		// ��ֵ
		form.setCyl("0");
		form.setXzqy("0");
		form.setDezsse("0.00");
		form.setYbjmsl("0.00");

		if (zsfs != null) {
			String zsfsdm = zsfs.getZsfsdm();
			if (zsfsdm.equals(CodeConstant.ZSFSDM_CYLZS)) {
				if (gxqyrdrq == null) {
					// ����������
					qyzssllx = "2";
				} else {
					// ���¼����ʹ�������ҵ
					qyzssllx = "5";
					qyzssl = "0.15";
					form.setJmzg("1"); // �м����ʸ�
				}
				form.setCyl(zsfs.getCyl());
			} else if (zsfsdm.equals(CodeConstant.ZSFSDM_DEZS)) {
				// ��������
				qyzssllx = "4";
				// ��ʱ���ֶδ�����ҵ�˶�˰��
				// ynsdse = zsfs.getDe();
				dezsse = zsfs.getDe();
				form.setDezsse(dezsse);
			}
		}

		// 2����ѯ�Ƿ��Ǹ��¼�����ҵ
		if (gxqyrdrq != null) {
			if (zsfs != null
					&& zsfs.getZsfsdm().equals(CodeConstant.ZSFSDM_CYLZS)) {
				// ���¼����ʹ�������ҵ
				qyzssllx = "5";
			} else {
				// ����Ϊ���¼�����ҵ
				qyzssllx = "1";
			}
			qyzssl = "0.15";
			form.setJmzg("1"); // �м����ʸ�
		} else if (form.getSsjjlx().equals(CodeConstant.JITIQIYE_CODE)) {
			// �ж��Ƿ�������ҵ����1��Ϊ������ҵ����0��Ϊ����������ҵ
			if (qysdsSet.isXzqy()) {
				form.setXzqy("1");
				form.setJmzg("1"); // �м����ʸ�
			}
		}

		if (!(form.getXzqy() != null && form.getXzqy().equals("1"))
				&& qysdsSet.getYbjmsl() != null) {
			// ��������ҵ�ļ������
			form.setJmzg("1"); // �м����ʸ�
			DecimalFormat ft = new DecimalFormat("0.00");
			form.setYbjmsl(ft.format(qysdsSet.getYbjmsl()));
		}
		form.setQyzslx(qyzssllx);
		form.setSysl(qyzssl);

		/* �˶���Ϣ��� */
		System.out.println("-------------�˶���Ϣ--------------");
		System.out.println("��ҵ����˰������-" + qyzssllx);
		System.out.println("�����ʸ�-" + form.getJmzg());
		System.out.println("һ�����˰��-" + form.getYbjmsl());
		System.out.println("���շ�ʽ-" + form.getZsfs());
		System.out.println("������-" + form.getCyl());
		System.out.println("����-" + form.getDezsse());
		System.out.println("����˰��-" + form.getSysl());
		System.out.println("-------------�˶���Ϣ--------------");
	}

	/**
	 * �Ѵ������ʱ���˵��Ŀո�ԭ
	 *
	 * @param table
	 * @param a
	 * @return
	 */
	public static QysdsReportsTableDeclare putSpace(
			QysdsReportsTableDeclare table, int arrs[]) {

		String flag = null;

		if (table.getCellContentList().size() == 0) {
			flag = "0.00";
		} else {
			flag = "";
		}

		System.out.println("**��ʾqysdsNewUtil�е�putSpace()**");

		for (int j = 1; j <= arrs.length; j = j + 2) {
			System.out.println("j___  " + j + "***" + arrs.length);
			for (int i = arrs[j - 1]; i <= arrs[j]; i++) {
				QysdsReportsItemDeclare item = (QysdsReportsItemDeclare) table
						.getCellContentList().get(String.valueOf(i));
				if (item == null) {
					QysdsReportsItemDeclare item1 = new QysdsReportsItemDeclare();
					item1.setItemID(String.valueOf(i));
					item1.setItemValue(flag);
					item1.setItemType("11");
					table.getCellContentList().put(String.valueOf(i), item1);
				} else if (item != null && item.getItemValue() != null
						&& "".equals(item.getItemValue().trim())) {
					QysdsReportsItemDeclare item1 = new QysdsReportsItemDeclare();
					item1.setItemID(String.valueOf(i));
					item1.setItemValue(flag);
					item1.setItemType("11");
					table.getCellContentList().put(String.valueOf(i), item1);
				}
			}
		}
		return table;
	}

	/**
	 * �������
	 *
	 * @param jmje
	 *            ������
	 * @param form
	 *            �걨��Ϣ
	 * @param dbAgent
	 *            ���ݿ�����
	 * @param ud
	 *            ����Ա��Ϣ
	 * @param djsj
	 *            �Ǽ���Ϣ
	 * @param ts_cjrq
	 *            ��������
	 * @param ts_lrrq
	 *            ¼������
	 * @param ts_sbrq
	 *            �걨����
	 * @param ts_Skssjsrq
	 *            ˰��������������
	 * @param ts_Skssksrq
	 *            ˰��������ʼ����
	 * @param nd
	 *            ���
	 */
	private void insertJmJb(String jmje, CzzssdsjbForm form,
			SfDBAccess dbAgent, UserData ud, SWDJJBSJ djsj, Timestamp ts_cjrq,
			Timestamp ts_lrrq, Timestamp ts_sbrq, Timestamp ts_Skssjsrq,
			Timestamp ts_Skssksrq, String nd) throws ApplicationException {
		Connection con = null;
		CallableStatement st = null;
		String sql = "";

		Timestamp t1, t2;

		t1 = new Timestamp(System.currentTimeMillis());

		try {
			// ����ҵ����˰�������걨�ļ����ֶ���ֵ����˰���м����ʸ��ʱ��Ҫ�������걨���������ݣ�
			// �����޸ģ�
			// ����������Ѿ�����������ˣ������ݼ��˱�ʶΪδ���ˣ���Ҫ�޸ļ����걨���ļ������ֶΣ�
			// ����������Ѿ�����������ˣ������ݼ��˱�ʶΪ�Ѽ��ˣ������ٲ������ݣ�
			// ���������û�в�������ݣ������һ�����ݣ�
			//
			// �����ϼ���˰�걨��ʱ����Ʋ���¼����ҵ����˰�ļ������ݣ������걨��˰��˰Ŀ�¹��˵���ҵ����˰��˰��˰Ŀ��
			// ��ҳ�����ݵļ������Ϊ�ջ�0���Ҿ߱�һ������ʸ�Ľ���
			// if (!"0".equals(jmje) && !"".equals(jmje) && form.getYbjmsl() !=
			// null &&
			// !form.getYbjmsl().equals(""))
			// {
			if ((jmje == null) || ("0.00".equals(jmje)) || ("".equals(jmje))) {
				jmje = "0";
			}
			Jm jm = new Jm();
			// ����ֵ�������
			jm.setCjrq(ts_cjrq);
			jm.setJsjdm(form.getJsjdm());
			jm.setJmlx(CodeConstant.JMLX_SP);
			jm.setSzsmdm(CodeConstant.SZSM_QYSDSCODE);
			jm.setSbrq(ts_sbrq);
			jm.setLrrq(ts_lrrq);
			jm.setFsdm(CodeConstant.FSDM_SMSB);
			jm.setJzbz(CodeConstant.SMSB_JZBZ);
			jm.setJmse(new BigDecimal(jmje));
			jm.setJsje(new BigDecimal(jmje));
			jm.setLrr(ud.getYhid());
			jm.setSkssjsrq(ts_Skssjsrq);
			jm.setSkssksrq(ts_Skssksrq);
			jm.setSwjgzzjgdm(djsj.getSwjgzzjgdm());
			// jm.setQxdm(InterfaceDj.getQxdm(ud));
			jm.setQxdm(djsj.getSwjgzzjgdm().substring(0, 2));
			jm.setDjzclxdm(djsj.getDjzclxdm());
			jm.setGjbzhydm(djsj.getGjbzhydm());
			jm.setNd(nd);

			Date date = TinyTools.stringToDate(form.getSbrq(), "yyyyMMdd");
			// ����������
			ServiceProxy proxy = new ServiceProxy();
			String jmxmdm = proxy.getJmsbs(form.getJsjdm(),
					CodeConstant.SZSM_QYSDS, ts_Skssksrq, ts_Skssjsrq);
			Debug.out("���������� =" + jmxmdm);
			System.out.println("���������� =" + jmxmdm);
			// ������Ŀ����Ϊ�գ��ӱ�����ȡ����ҵ�����������жϼ��ⷽʽ
			if (jmxmdm == null) {

				System.out
						.println("**************   ȡ�õļ�����Ŀ����Ϊ�գ������걨�ļ�������putJm�е���ҵ��������form.getQyzslx()Ϊ:"
								+ form.getQyzslx());

				jmxmdm = CodeConstant.JMLXOTHER;
				jm.setJmlx(CodeConstant.JMLX_FD);// �����Լ�������

			}

			if (jmxmdm != null && !("".equals(jmxmdm))) {

				jm.setJmxmdm(jmxmdm);
				// ȡ��Ԥ�㼶�δ���
				Ysjc ysjc = null;
				try {
					ysjc = JksUtil.getYsjc(form.getJsjdm(),
							CodeConstant.SZSM_QYSDS, SfDateUtil.getDate(form
									.getSbrq()));
				} catch (Exception e) {
					throw new ApplicationException("�ü���������Ԥ�㼶�δ���û�м�¼��");
				}
				if (ysjc != null) {
					Debug.out("���� =" + ysjc.getYsjcdm());
				} else {
					throw new ApplicationException("�ü���������Ԥ�㼶�δ���û�м�¼��");
				}
				// ȡ��Ԥ���Ŀ����
				com.ttsoft.bjtax.jikuai.zwcl.vo.page.Yskm yskm = null;
				try {
					yskm = JKAdapter.getInstance().getYskm(
							CodeConstant.SZSM_QYSDSCODE, djsj.getDjzclxdm(),
							djsj.getGjbzhydm(), ysjc.getYsjcdm());
				} catch (Exception e) {
					throw new ApplicationException("�ü���������Ԥ���Ŀ����û�м�¼��");
				}
				if (yskm != null) {
					Debug.out("Ԥ���Ŀ =" + yskm.getYskmdm());
				} else {
					throw new ApplicationException("�ü���������Ԥ���Ŀ����û�м�¼��");
				}

				jm.setYsjcdm(ysjc.getYsjcdm());
				jm.setYskmdm(yskm.getYskmdm());

				try {

					String jsjdm = jm.getJsjdm();
					String jmlx = jm.getJmlx();
					String szsmdm = jm.getSzsmdm();
					// String sbrq = df.format(now);
					Timestamp sbrq = jm.getSbrq();
					String fsdm = jm.getFsdm();
					String jzbz = jm.getJzbz();
					String lrr = jm.getLrr();
					// String skssjsrq = df.format(declare.getSkssjsrq());
					// String skssksrq = df.format(declare.getSkssksrq());
					Timestamp skssjsrq = jm.getSkssjsrq();
					Timestamp skssksrq = jm.getSkssksrq();
					String swjgzzjgdm = jm.getSwjgzzjgdm();
					String qxdm = jm.getQxdm();
					String djzclxdm = jm.getDjzclxdm();
					String gjbzhydm = jm.getGjbzhydm();
					// String nd = jm.getNd();
					String ysjcdm = jm.getYsjcdm();
					String yskmdm = jm.getYskmdm();
					// String jmxmdm = jm.getJmxmdm();
					BigDecimal jmse = jm.getJmse();

					// �������ݿ�����
					con = SfDBResource.getConnection();
					sql = "BEGIN sbdb.sb_pkg_sbjmtools.insertjm_jb(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); END;";

					st = con.prepareCall(sql);

					System.out
							.println("-------------���ò�������걨�洢���̲���----------------");
					System.out.println("1-jsjdm--" + jsjdm);
					System.out.println("2-jmlx--" + jmlx);
					System.out.println("3-szsmdm--" + szsmdm);
					System.out.println("4-sbrq--" + sbrq);
					System.out.println("5-fsdm--" + fsdm);
					System.out.println("6-jzbz--" + jzbz);
					System.out.println("7-lrr--" + lrr);
					System.out.println("8-skssjsrq--" + skssjsrq);
					System.out.println("9-skssksrq--" + skssksrq);
					System.out.println("10-swjgzzjgdm--" + swjgzzjgdm);
					System.out.println("11-qxdm--" + qxdm);
					System.out.println("12-djzclxdm--" + djzclxdm);
					System.out.println("13-gjbzhydm--" + gjbzhydm);
					System.out.println("14-nd--" + nd);
					System.out.println("15-ysjcdm--" + ysjcdm);
					System.out.println("16-yskmdm--" + yskmdm);
					System.out.println("17-jmxmdm--" + jmxmdm);
					System.out.println("18-jmse--" + jmse);

					st.setString(1, jsjdm);
					st.setString(2, jmlx);
					st.setString(3, szsmdm);
					st.setTimestamp(4, sbrq);
					st.setString(5, fsdm);

					st.setString(6, jzbz);
					st.setString(7, lrr);
					st.setTimestamp(8, skssjsrq);
					st.setTimestamp(9, skssksrq);
					st.setString(10, swjgzzjgdm);

					st.setString(11, qxdm);
					st.setString(12, djzclxdm);
					st.setString(13, gjbzhydm);
					st.setString(14, nd);
					st.setString(15, ysjcdm);

					st.setString(16, yskmdm);
					st.setString(17, jmxmdm);
					st.setBigDecimal(18, jmse);

					st.execute();

				} catch (Exception ex4) {
					throw new ApplicationException(
							"��������걨��ʧ�ܣ����ݿ����ʧ�ܣ������ҹ���Ա��ϵ��");
				}

			}

		} catch (Exception ex) {
			// �׳��쳣
			ex.printStackTrace();
			//throw new ApplicationException(ex.getMessage());
		} finally {
			// �ͷ����ݿ�����
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			SfDBResource.freeConnection(con);
		}

		t2 = new Timestamp(System.currentTimeMillis());

		System.out.println("��������걨�����ݺ�ʱ��" + (t2.getTime() - t1.getTime()));

	}

	/**
	 * doDelete ����ɾ��ҳ���ύ���꾡������Ϣ
	 *
	 * @param vo
	 *            ҵ�����
	 * @return ���ݶ���[�������null(��Action����Ҫ����ֵ)�������Ҫ����ֵ��������ActionForm]
	 * @throws BaseException
	 *             ��������������׳��쳣��Ϣ
	 */

	private Object doDelete(VOPackage vo) throws BaseException {

		// �õ�Action���ݹ���HdzssdsjbForm����
		CzzssdsjbForm czzssdsjbForm = (CzzssdsjbForm) vo.getData();

		Connection conn = null;

		try {
			// �������ݿ�����
			conn = SfDBResource.getConnection();
			/* ���շ�ʽ */
			String zsfs = czzssdsjbForm.getZsfs();
			// ��ActionForm�еĻ�����Ϣת��QysdsReportsDeclare������
			QysdsReportsDeclare report = this.translate2Interface(
					czzssdsjbForm, zsfs);

			// ��ȡ���ݿ�Ӧ�ýӿ�
			IAppAccess iApp = AppAccessFactory.getAInstance(conn,
					AppAccessFactory.ACCESS_MODEL_APP_QYSDS);
			// ����deleteSingleTable������������ɾ��
			iApp.deleteSingleTable(report);

			/**
			 * �������˰
			 */
			// ��ҳ����ȡ��˰�������ں����
			String nd = czzssdsjbForm.getSkssksrq().substring(0, 4);

			// ʹ��OrMap�������ݿ�ķ�װ��
			SfDBAccess da = new SfDBAccess(conn);
			SWDJJBSJ djxx = null;
			UserData ud = (UserData) vo.getUserData();
			try {

				djxx = InterfaceDj.getJBSJ_New(czzssdsjbForm.getJsjdm(), ud);

			} catch (Exception ex1) {
				throw ExceptionUtil.getBaseException(ex1);
			}

			Timestamp skssksrq = QysdsNewUtil.getTimestamp(czzssdsjbForm
					.getSkssksrq());
			Timestamp skssjsrq = QysdsNewUtil.getTimestamp(czzssdsjbForm
					.getSkssjsrq());
			Timestamp sbrq = QysdsNewUtil.getTimestamp(czzssdsjbForm.getSbrq());

			Timestamp now = new Timestamp(System.currentTimeMillis());

			String jmje = "0";// ���ü�����Ϊ0
			this.insertJmJb(jmje, czzssdsjbForm, da, ud, djxx, now, now, sbrq,skssjsrq, skssksrq, nd);

			// ��ȡһ�����п�ֵ��QysdsReportsTableDeclare����
			QysdsReportsTableDeclare table = (QysdsReportsTableDeclare) report
					.getTableContentList().get(
							CodeConstant.TABLE_ID_CZQYSDSJB_2008);
			table.getCellContentList().clear();

			// �����ݿ��е����ݷ����ҳ���������ݸ�ʽ
			int[] arrs = { 1, 30 };
			czzssdsjbForm.setQysdsjbList(null);

		} catch (Exception ex) {
			// �׳��쳣
			ex.printStackTrace();
			throw ExceptionUtil.getBaseException(ex);
		} finally {
			// �ͷ����ݿ�����
			SfDBResource.freeConnection(conn);
		}
		// ɾ���ɹ�����czzssdsjbForm
		return czzssdsjbForm;
	}
	
	/**
	 * ���ӱ��е����ݴ���list��
	 * @param table
	 * @param zsfs
	 * @return
	 */
	private void cb_translate2Page(QysdsReportsTableDeclare table, String zsfs,CzzssdsjbForm czzssdsjbForm) {
		
		// ����List�����������ҳ���������
        Iterator it = table.getCellContentList().keySet().iterator();
        ArrayList cbMssrxmList=new ArrayList();
        ArrayList cbJzmzxmList=new ArrayList();
        ArrayList cbJmxmList=new ArrayList();
        HashMap cbMssrxmMap=new HashMap();
        HashMap cbJzmzxmMap=new HashMap();  
        HashMap cbJmxmMap=new HashMap();  
        while(it.hasNext()){
        	String key=(String) it.next();
        	if(key.indexOf(".") > 0){        		
        		QysdsReportsItemDeclare item = (QysdsReportsItemDeclare) table.getCellContentList().get(key);  
        		if("777".equals(key.substring(0,3))){
        			cbMssrxmMap.put(item.getItemID(), item.getItemValue());  
        		}else if("888".equals(key.substring(0,3))){
        			cbJzmzxmMap.put(item.getItemID(), item.getItemValue());  
        		}else if("999".equals(key.substring(0,3))){
        			cbJmxmMap.put(item.getItemID(), item.getItemValue());  
        		}       		    		
        	}
        }
        cbMssrxmList.add(cbMssrxmMap);
        czzssdsjbForm.setCbsbMssrxmList(cbMssrxmList);
        cbJzmzxmList.add(cbJzmzxmMap);
        czzssdsjbForm.setCbsbJzmzxmList(cbJzmzxmList);
        cbJmxmList.add(cbJmxmMap);
        czzssdsjbForm.setCbsb_qysdsjbList(cbJmxmList);
        
	}

}