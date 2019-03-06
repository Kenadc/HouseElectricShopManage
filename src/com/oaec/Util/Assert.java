package com.oaec.Util;

import java.util.Collection;

/***
 * ������
 */
public class Assert {
	/***
	 * @param arg
	 *            Ҫ����String
	 * @return ��� arg != null ���� !"".equals(arg) ������
	 */
	public static boolean hasText(String arg) {
		if (null != arg && !"".equals(arg)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Ϊ������֤���Ե�ʱ���ڶ���Ϊ�ջ���Ϊ "" ��ʱ����Ϸǵķ��Ŷ���װ�ĸ÷���
	 * @param arg
	 * @return
	 */
	public static boolean hasTextNull(String arg) {
		
		if(arg == null || "".equals(arg)) {
			return true;
		} else {
			return false;
		}
	}
	
	/***
	 * �жϲ�ΪNULL
	 * 
	 * @param object
	 * @return
	 */
	public static boolean notNull(Object object) {
		
		if(null != object && object.toString() != null && !"null".equals(object.toString())) {
			return true;
		}
		
		return false;
	}

	/***
	 * �жϼ��ϲ�ΪNULL��>=0
	 * 
	 * @param object
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean notEmpty(Collection list) {
		if (null != list && list.size() > 0) {
			return true;
		}
		return false;
	}
	
	/***
	 * �жϼ���Ϊ�ջ��߳���Ϊ0�����
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean nullEmpty(Collection list) {
		
		if (list == null || list.size() == 0) {
			return true;
		} else {
			
			return false;
		}
	}

	/***
	 * �ж϶������鲻ΪNULL��>=0
	 * 
	 * @param object
	 * @return
	 */
	public static boolean notEmpty(Object[] obj) {
		if (null != obj && obj.length > 0) {
			return true;
		}
		return false;
	}
}
