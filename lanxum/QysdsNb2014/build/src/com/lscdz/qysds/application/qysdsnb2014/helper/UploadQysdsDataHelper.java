package com.lscdz.qysds.application.qysdsnb2014.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import yangjian.frame.dao.FrameCommonAccess;
import yangjian.frame.util.FrameException;
import yangjian.frame.util.ResourceManager;

import com.lscdz.ca.CAManagerLocator;
import com.lscdz.ca.SecureManager;
import com.lscdz.hlwdsj.hxzgframe.Yh;
import com.lscdz.qysds.application.qysdsnb2014.util.QysdsNb2014Util;
import com.lscdz.qysds.application.qysdsnb2014.vo.request.UploadQysdsDataReq;
import com.lscdz.qysds.application.qysdsnb2014.vo.response.QysdsNbResponse;
import com.lscdz.qysds.common.QysdsNbConstant;
import com.lscdz.qysds.common.service.ServiceManager;
import com.lscdz.qysds.common.service.qysds.bo.CheckResult;
import com.lscdz.qysds.common.service.qysds.bo.qysds.Jbxx;
import com.lscdz.qysds.common.service.qysds.bo.qysds.QysdsReportsDeclare;
import com.lscdz.qysds.common.service.qysds.bo.qysds.QysdsReportsItemDeclare;
import com.lscdz.qysds.common.service.qysds.bo.qysds.QysdsReportsTableDeclare;
import com.lscdz.qysds.common.service.qysds.check.Checker;
import com.lscdz.qysds.common.service.qysds.check.CheckerFactory;
import com.lscdz.qysds.common.service.qysds.persistent.AppAccessFactory;
import com.lscdz.qysds.common.service.qysds.persistent.access.IAppAccess;
import com.lscdz.qysds.common.service.qysds.xml.ChangeDeclare;
import com.lscdz.qysds.common.service.qysds.xml.bs.ReadReports;
import com.lscdz.qysds.common.service.qysds.xml.vo.data.APPS;
import com.lscdz.qysds.common.util.QysdsHelperUtil;
import com.lscdz.qysds.common.util.StringUtil;
import com.lscdz.qysds.common.util.ZipUtil;

public class UploadQysdsDataHelper {
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static QysdsNbResponse upload(UploadQysdsDataReq request,Yh userData) {

		QysdsHelperUtil qysdsHelperUtil = new QysdsHelperUtil();

		// ȡ��֤�顢��½��ʽ��ǩ��ֵ
		String reportType = request.getReportType(); // ��������
//		String userCert = request.getCertificate(); // ֤��
		String idiographData = request.getIdiographData(); // ǩ��ֵ
//		int loginType = request.getLoginType(); // ��¼����
		String reportData = request.getReportData(); // ��������
		String aid = request.getAID(); // AID
		String nd = request.getNd(); // ���
		// String jsjdm = request.getJsjdm(); // ���������
		String jmlx = request.getJmlx() == null ? "" : request.getJmlx(); // ��������
		String ckzd = request.getCkzd() == null ? "" : request.getJmlx(); // �ƻ��ƶ�
		String gzglxs = request.getGzglxs() == null ? "" : request.getGzglxs(); // ���ʹ�����ʽ

		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		Statement st = null;
		ResultSet rs = null;

		String dzyjQmhz = new String(); // ����ԭ��ǩ����ִ��ϢString

		Jbxx jbxx = new Jbxx();

		// ��¼�ϴ���������ҵ����˰�걨����
		int num_sdsReports = 0;

		// �ӻ�����Ϣ���л��
		String swjgzzjgdm = "";
		String qxdm = "";

		// ���巵�ر���
		QysdsNbResponse qysdsResponse = new QysdsNbResponse();
		qysdsResponse.setJsjdm(request.getJsjdm());
		// ���ݴ���
		try {

			int nowYear = Integer.parseInt((new SimpleDateFormat("yyyy")).format(new java.util.Date()));

			// ֻ���ϴ������ڵ����ݣ���ǰ��ȵ�ǰһ�꣩
			if (Integer.parseInt(nd) != (nowYear - 1)) {
				qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
				qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ���ֻ���ϴ������ڵ��걨���ݣ�");
				return qysdsResponse;
			}

			// ���ϴ��ı������ݽ��н�ѹ�����ٴ���

			String decompressReportData = ZipUtil.decompress(ZipUtil.base64Tocompress(reportData));

			// ��ȡ���ݿ�����
			conn = ResourceManager.getConnection();

			/**
			 * �жϵ�ǰ�Ƿ�������
			 */
			try {
				sql.delete(0, sql.length());
				sql.append("SELECT PROPERTYVALUE from sbdb.sb_jl_properties where propertyname = 'WSSB_CZZSQYNB_ZQRL_MONTH_01'");
				st = conn.createStatement();
				rs = st.executeQuery(sql.toString());
				String zq = "";
				while (rs.next()) {
					zq = rs.getString("PROPERTYVALUE");
				}
//				if (!StringUtil.withinZq(zq, new java.util.Date())) {
//					qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
//					qysdsResponse.setErrorXX("Ŀǰ�������ڣ������ϴ�����");
//					return qysdsResponse;
//				}
				rs.close();
				st.close();
			} catch (Exception ex) {
				ex.printStackTrace();
				qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
				qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ�������æ����ȡ������Ϣ���������Ժ����ϴ��걨�����ݣ�");
				return qysdsResponse;
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					rs = null;
				}
				if (st != null) {
					try {
						st.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					st = null;
				}
			}

			/**
			 * ��û�����Ϣ���ж��ϴ��û��������͡��ƻ��ƶȡ����ʹ�����ʽ���������Ϣ�Ƿ�һ��
			 */
			try {
				// �ȶԴ��󷵻���Ϣ
				StringBuffer returnMeg = new StringBuffer("�����ص�");
				// ȡ����˰�˻�����Ϣ
				sql.delete(0, sql.length());
				sql.append("SELECT * FROM SBDB.SB_JL_QYSDS_NSRJBXXB_2014 WHERE JSJDM = '");
				sql.append(qysdsResponse.getJsjdm());
				sql.append("' AND ND = '");
				sql.append(nd);
				sql.append("'");
				// System.out.println("��ȡ��˰�˺˶���Ϣsql = " + sql.toString());
				st = conn.createStatement();
				rs = st.executeQuery(sql.toString());

				if (rs.next()) {

					// �籨��id,���硰1;3;4;5��
					jbxx.setBbmsf((rs.getString("BBMSF") == null ? "" : rs.getString("BBMSF")));
					// �ƻ��ƶ�
					jbxx.setCkzd(QysdsNb2014Util.getCkzd(rs.getString("SYKJZZHKJZZ"), rs.getString("QTSYKJZZHKJZZ")));
					// ���ʹ�����ʽ
//					jbxx.setGzglxs((rs.getString("GZGLXS") == null ? "" : rs.getString("GZGLXS")));
//					// ��������
//					jbxx.setJmlx((rs.getString("JMLX") == null ? "" : rs.getString("JMLX")));
//					// ��Ӫ��ַ
//					jbxx.setJydz((rs.getString("JYDZ") == null ? "" : rs.getString("JYDZ")));
					// ��˰�˼��������
					jbxx.setJsjdm((rs.getString("JSJDM") == null ? "" : rs.getString("JSJDM")));
					// ��˰������
					jbxx.setNsrmc((rs.getString("NSRMC") == null ? "" : rs.getString("NSRMC")));
					// ������ҵ
					jbxx.setSshy((rs.getString("SSHY") == null ? "" : rs.getString("SSHY")));
					// ������������-�Ǽ�ע������
//					jbxx.setSsjjlx((rs.getString("SSJJLX") == null ? "" : rs.getString("SSJJLX")));
					// ϵͳ����
//					jbxx.setXtjb((rs.getString("XTJB") == null ? "" : rs.getString("XTJB")));
					// ��ҵ����˰���շ�ʽ
//					jbxx.setZsfs((rs.getString("ZSFS") == null ? "" : rs.getString("ZSFS")));
					// ��ϵ�绰
//					jbxx.setLxdh((rs.getString("LXDH") == null ? "" : rs.getString("LXDH")));

					swjgzzjgdm = (rs.getString("SWJGZZJGDM"));
					qxdm = (rs.getString("SWJGZZJGDM").substring(0, 2));

					// // �ƻ��ƶ�
					// String dbckzd = rs.getString("CKZD") == null ? "" :
					// rs.getString("CKZD");
					// // ���ʹ�����ʽ
					// String dbgzglxs = rs.getString("GZGLXS") == null ? ""
					// : rs.getString("GZGLXS");
					// // ��������
					// String dbjmlx = rs.getString("JMLX") == null ? "" :
					// rs.getString("JMLX");

					// System.out.println("��ȡ��˰�˻����˶���Ϣjmlx:"+jmlx+";"+jbxx.getJmlx());
					// System.out.println("��ȡ��˰�˻����˶���Ϣgzglxs:"+gzglxs+";"+jbxx.getGzglxs());
					// System.out.println("��ȡ��˰�˻����˶���Ϣckzd:"+ckzd+";"+jbxx.getCkzd());

//					if (!jmlx.equals(jbxx.getJmlx())) {
//						// �жϼ�������
//						returnMeg.append("��������,");
//					}
//					if (!gzglxs.equals(jbxx.getGzglxs())) {
//						// ���ʹ�����ʽ
//						returnMeg.append("���ʹ�����ʽ,");
//					}
//					if (!ckzd.equals(jbxx.getCkzd())) {
//						// �ƻ��ƶ�
//						returnMeg.append("�ƻ��ƶ�,");
//					}
					// ������Ϣ�԰�Ƕ���Ϊ��β���ʾ������Ϣ���������Ϣ�в�ƥ��֮��,���ش�����Ϣ
//					if (returnMeg.toString().endsWith(",")) {
//						qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_CHECKERROR);
//						qysdsResponse.setErrorXX(returnMeg.substring(0,returnMeg.length() - 1)+ "�����������Ϣ��һ�£������˶�������д�˶���Ϣ����������Ϣ��ʼ��Ϊ���µ���д�˶���Ϣ!");
//						return qysdsResponse;
//					}
				}
//				else{
//					qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
//					qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ���ȡ������˰�˻����˶���Ϣ��");
//					return qysdsResponse;
//				}

			} catch (Exception ex) {
				// System.out.println("��ȡ��˰�˻����˶���Ϣ����!");
				ex.printStackTrace();
				qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
				qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ�������æ����ȡ��˰�˻����˶���Ϣ���������Ժ����ϴ��걨�����ݣ�");
				return qysdsResponse;
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					rs = null;
				}
				if (st != null) {
					try {
						st.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					st = null;
				}
			}

			/**
			 * �����֤���½����֤����,ǩ������
			 */
			// if (loginType == QysdsNbConstant.LOGIN_TYPE_CA) {
			//
			// try {
			// try {
			// // ��֤ǩ��
			// SecurityWareService se = SecurityWareService
			// .getInstance();
			// // System.out.println("reportData:"
			// // + decompressReportData);
			// // System.out
			// // .println("idiographData:" + idiographData);
			// // System.out.println("userCert:" + userCert);
			// if (!se.SignedData_Verify(decompressReportData,
			// idiographData, userCert)) {
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_LOGINERROR);
			// qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ���Ч��֤�飬�밲װ��ȷ��֤��");
			// return qysdsResponse;
			// }
			//
			// } catch (SecurityEngineException ex) {
			// ex.printStackTrace();
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			// qysdsResponse
			// .setErrorXX("�ϴ�ʧ�ܣ�������æ���ײ�������������Ժ����ϴ��걨�����ݣ�");
			// return qysdsResponse;
			// } catch (VerifyException ex) {
			// ex.printStackTrace();
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			// qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ���֤ǩ����������ȷ������֤��ĺϷ��ԣ�");
			// return qysdsResponse;
			// }
			// /**
			// * ����ǩ����Ϣ
			// */
			// // ��д����ԭ����Ϣ
			// String swjgzzggdm = qysdsResponse.getSwjgzzjgdm();
			// SecureManager sm = null;
			// sm = CAManagerLocator.getBJCASecureManager(1);
			// DzyjsjVO dzyj = new DzyjsjVO();
			// dzyj.setDzyj(decompressReportData);
			// dzyj.setDzyjqm(idiographData);
			// dzyj.setFwqzsxlh(sm.getServerCert().getZsxlh());
			// dzyj.setJsjdm(qysdsResponse.getJsjdm());
			// dzyj.setQxdm(swjgzzggdm.substring(0, 2));
			// dzyj.setSwjgzzjgdm(swjgzzggdm);
			// dzyj.setZsxlh(request.getZsxlh());
			// dzyj.setJssj(new Timestamp(System.currentTimeMillis()));
			// String hz = null;
			// String jssj = null;
			//
			// // ǩ����ִ
			// try {
			// jssj = DateTimeUtil.timestampToString(dzyj.getJssj(),
			// "yyyyMMddHHmmss");
			// } catch (Exception e1) {
			// // TODO Auto-generated catch block
			// e1.printStackTrace();
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			// qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ�����ԭ������ʱ���޷�ʶ��");
			// return qysdsResponse;
			// }
			//
			// try {
			// hz = sm.signData(decompressReportData + jssj
			// + idiographData);
			// } catch (Exception e) {
			// e.printStackTrace();
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			// qysdsResponse
			// .setErrorXX("�ϴ�ʧ�ܣ�������æ��������ǩ����ִ���������Ժ����ϴ��걨�����ݣ�");
			// return qysdsResponse;
			// }
			// //
			//
			// dzyj.setHzqm(hz);
			// // dzyj.setYwczlx(QysdsNbConstant.CA_SCHEMADM_CZZSSDSNBB);
			// // ҵ�������������ǩ��ԭ������Ĳ������ͣ�����
			// dzyj.setYwczlx(CAcodeConstants.YWCZLX_NEW);
			// dzyj.setYwdm(QysdsNbConstant.CA_YWLXDM_CZZSSDSNB);
			// try {
			// DzyjHelper dh = new DzyjHelper();
			// java.util.Date date = new java.util.Date();
			// String str = null;
			// SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
			// str = df.format(date);
			// // ����ywid
			// String ywid = qysdsResponse.getJsjdm() + "+" + str;
			// // ����ǩ����Ϣ
			// dzyj = dh.saveDzyjsj(dzyj, ywid,
			// CAcodeConstants.DADM_SB_WS_QYSDS_NB);
			//
			// dzyjQmhz = qysdsHelper.toHz(dzyj);
			//
			// // �Է��ص�ǩ����ִ����ѹ�����ٴ���
			//
			// // qysdsResponse.setDzyjQmhz(dzyjQmhz);
			//
			// String compressDzyjQmhz = ZipUtil
			// .compressTobase64(ZipUtil.compress(dzyjQmhz));
			//
			// qysdsResponse.setDzyjQmhz(compressDzyjQmhz);
			//
			// } catch (Exception ex) {
			// ex.printStackTrace();
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			// qysdsResponse
			// .setErrorXX("�ϴ�ʧ�ܣ�������æ������ǩ����Ϣ���������Ժ����ϴ��걨�����ݣ�");
			// return qysdsResponse;
			// }
			//
			// } catch (Exception ex) {
			// ex.printStackTrace();
			// qysdsResponse
			// .setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			// qysdsResponse
			// .setErrorXX("�ϴ�ʧ�ܣ�������æ����֤���ݼ�ǩ��������Ϣ���������Ժ����ϴ��걨�����ݣ�");
			// return qysdsResponse;
			// }
			// }

			String deploy_environment=ResourceManager.getTokenByName("DEPLOY_ENVIRONMENT");
			//���Ϊ��������Ϊ֤���û�����ǩ����֤
			if("EXTERIOR".equals(deploy_environment) && userData.getCaflag()){
				SecureManager sm = null;
				if (sm == null)
				{
					sm = CAManagerLocator.getBJCASecureManager();
					if (sm == null)
					{
						throw new FrameException("֤���ʼ������BCU-01-0103");
					}
				}
				if(!sm.verifySignature(userData.GetCertVo().getCert(),request.getReportDataCA(),request.getIdiographDataCA())){
					 qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_LOGINERROR);
					 qysdsResponse.setErrorXX("�ϴ�ʧ�ܣ���Ч��֤�飬�밲װ��ȷ��֤��");
					 return qysdsResponse;
				}else{
					decompressReportData = ZipUtil.decompress(ZipUtil.base64Tocompress(request.getReportDataCA()));
				}
		    }
			
			
			/**
			 * ���汨������
			 */
			try {
				// conn = SfDBResource.getConnection();
				IAppAccess access = null;
				List declareList = null;
				/**
				 * ������ҵ����˰�걨��������
				 */
				if (aid.equals(QysdsNbConstant.APP_AID_QYSDSNB)) {
					// ������ҵ����˰�걨��������
					access = AppAccessFactory.getAInstance(conn,AppAccessFactory.ACCESS_MODEL_APP_QYSDS);
					ReadReports rp = new ReadReports();
					// ���ϴ��ı�������ת����QysdsReportsDeclare��list
					declareList = ChangeDeclare.getReportDeclare((APPS) rp.readReport(reportType, decompressReportData));
					// �����е��ϴ���listѭ��
					for (int i = 0; i < declareList.size(); i++) {
						QysdsReportsDeclare declare = (QysdsReportsDeclare) declareList.get(i);
						// ȡ�����ڵ��걨����
						if (aid.equals(declare.getAppid())&& nd.equals(declare.getSknd())&& qysdsResponse.getJsjdm().equals(declare.getNsrjsjdm())) {
							// ��¼�ϴ����걨������
							num_sdsReports++;

							declare.setJbxx(jbxx);

							declare.setSwjgzzjgdm(swjgzzjgdm);
							declare.setQxdm(qxdm);
							// ¼����
							declare.setLrr(userData.getYhid());
							// �걨����
							declare.setSbrq(FrameCommonAccess.getDBDate());

							// ������
							declare.setCjr(userData.getYhid());

							// ¼������
							declare.setLrrq(FrameCommonAccess.getDBDate());

							// ��������
							declare.setCjrq(FrameCommonAccess.getDBDate());

							// ���˷���table�����еĿո�
							declare = qysdsHelperUtil.cleanSpace(declare);

							// ������˽ӿ���֤������ȷ

							Checker checker = CheckerFactory.getAInstance(conn,CheckerFactory.ACCESS_MODEL_APP_QYSDS);

							// ͬ���ŷ�ʽһ�������ݿ���ȡ����˹�ʽ����ˣ�����ȫ��У��

							List listSingle = null;

							// ***********-----ȫ�����-----------ֱ�Ӷ����ݿ�ķ�ʽ���д�����ʼ--------------------------//
							listSingle = checker.checkMain(declare,QysdsNbConstant.CREPORTS_SYSTEM_FS_SHANGMENG);

							// ***********------ȫ�����-----------ֱ�Ӷ����ݿ�ķ�ʽ���д�����ʼ--------------------------//

							// 2009���ⱸ������
							// ����5�������
							// 17Ϊ����5��������,10Ϊ��������5����
							// ��������5
							List listSingleJm = new ArrayList();
							if (declare.getVersion().equals(QysdsNbConstant.REPORT_VERSION_2009)) {

								List readList = qysdsHelperUtil.getReadOnlyHc(declare.getNsrjsjdm(),declare.getSknd());

								QysdsReportsTableDeclare fb5 = (QysdsReportsTableDeclare) declare.getTableContentList().get(QysdsNbConstant.DMFB5 + "");
								for (int j = 0; j < readList.size(); j++) {
									String fb5hc = (String) readList.get(j);
									System.out.println("fb5 hc=" + fb5hc);

									QysdsReportsItemDeclare fb5item = (QysdsReportsItemDeclare) fb5.getCellContentList().get(fb5hc);
									if (fb5item != null&& fb5item.getItemValue() != null&& !fb5item.getItemValue().equals("")) {
										// //error
										CheckResult cr = new CheckResult();
										cr.setResult(false);
										String hcms = "��" + fb5hc + "��";
										if (Integer.valueOf(fb5hc).intValue() > 47) {
											hcms = "�������ϵ�"
													+ (Integer.valueOf(fb5hc).intValue() - 47)
													+ "��";
										}
										cr.setResultDescription("�����дΣ������� ��˰���Ż���ϸ����"
												+ hcms
												+ "="
												+ fb5item.getItemValue()
												+ "��Ŀǰϵͳ��δ��⵽��Ӧ�ı�����Ϣ�����ʵ��");
										cr.setCheckBy("JMBA");
										listSingleJm.add(cr);
									}

								}
							}

							// ȫ�����ͨ��
							if ((listSingle == null || listSingle.size() == 0)&& (listSingleJm == null || listSingleJm.size() == 0)) {
								// ���汨������
								access.save(declare);
								try {
									Timestamp t1, t2;
									t1 = FrameCommonAccess.getDBDate();

									// ��������
									// this.insertJm(declare);
									// qysdsHelper.insertJmProce(declare);
//									ServiceManager.getInstance().getSfglService().insertJmProce(declare);
									t2 = FrameCommonAccess.getDBDate();
									// System.out
									// .println("��������걨�����ݺ�ʱ��"
									// + (t2.getTime() - t1
									// .getTime()));

								} catch (Exception e) {
									e.printStackTrace();
									qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
									qysdsResponse.setErrorXX("������æ���ϴ��ı������ݱ��桢��������걨��ʧ�ܣ������Ժ����ϴ��걨�����ݣ���");
									return qysdsResponse;
								}

							} else {// ������ʾ����
								String resultDescriptionRe = "";

								// ��˹�ʽ����
								if ((listSingle != null && listSingle.size() > 0)) {

									CheckResult cr;

									String resultDescription = "";
									String[] resultDescriptionSp;
									// String resultDescriptionRe = "";

									// �����˽���Ĵ�����Ϣ��һ��

									cr = (CheckResult) listSingle.get(0);

									resultDescription = cr.getResultDescription();
									// ������ʾ
									resultDescriptionSp = StringUtil.splitBySeparator(resultDescription, "��");

									if (resultDescriptionSp != null&& resultDescriptionSp.length > 0) {

										for (int b = 0; b < resultDescriptionSp.length; b++) {
											resultDescriptionRe = resultDescriptionRe
													+ resultDescriptionSp[b]
													+ "\n";
										}
									}

									// �����ʸ���
									if ((listSingleJm != null && listSingleJm.size() > 0)) {
										resultDescriptionRe = resultDescriptionRe+ "\n�����д����Ŀ����ǰ�뵽����˰����������ر���������\n";

										// �����˽���Ĵ�����Ϣ��һ��

										for (int k = 0; k < listSingleJm.size(); k++) {

											cr = (CheckResult) listSingleJm.get(k);

											resultDescription = cr.getResultDescription();
											resultDescriptionRe = resultDescriptionRe+ resultDescription + "\n";
										}

									}

								}
								qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
								qysdsResponse.setErrorXX("�ϴ��ı��������ڷ����������δͨ����������ϸ��˱������ݣ�\n\nע�⣺����������������ͨ����������ʾ����������˲�ͨ�����������˹�ϵ���ڱ������ͨ�������ϴ����ݡ�\n"+ resultDescriptionRe);
								return qysdsResponse;
							}
						}
					}
					// û�б��ڵ��걨����
					if (num_sdsReports < 1) {
						qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
						qysdsResponse.setErrorXX("�ϴ���������û�а��������ڵ��걨���ݣ�������ϸ��˱������ݣ�");
						return qysdsResponse;
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
				qysdsResponse.setErrorXX("������æ���ϴ��ı������ݱ���ʧ�ܣ������Ժ����ϴ��걨�����ݣ���");
				return qysdsResponse;
			}

			// System.out
			// .println("++++++++++++++++++�ϴ��ı������ݽ���++++++++++++++++++++++++++");

		} catch (Exception ex) {
			// System.out.println("��ȡ��ȡ��������ʧ��!");
			ex.printStackTrace();
			qysdsResponse.setErrorNo(QysdsNbConstant.ERROR_TYPE_SYSTEMERROR);
			qysdsResponse.setErrorXX("������æ���ϴ��ı������ݱ���ʧ�ܣ������Ժ����ϴ��걨�����ݣ�");
			return qysdsResponse;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				st = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return qysdsResponse;
	}

}