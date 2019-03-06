package com.oaec.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * ʱ��ת������jsp���洫������ʱ�����ת����
 * ��Ϊjsp��������ʱ����String����Ҫת��
 * @author ���˽�
 *
 */
public class DateFormatConverter implements Converter<String, Date>{

	/**
	 * ��ʽ��ʱ��  ��ȷ��������
	 * @param arg0
	 * @return
	 */
	@Override
	public Date convert(String arg0) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date = sdf.parse(arg0);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * ��ʽ��ʱ��  ��ȷ��ʱ����
	 * @param arg0
	 * @return
	 */
	/*public static Date convertHMS(String arg0) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(arg0);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}*/

}
