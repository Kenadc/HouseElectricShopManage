package com.oaec.Util;

import java.io.InputStream;
import java.util.Properties;
public class ReadFontByteProperties {
    static private String fontByteStr = null;
    static {
        loads();
    }
    synchronized static public void loads() {
        if (fontByteStr == null) {
            InputStream is = ReadFontByteProperties.class.getResourceAsStream("/fontByte.properties");
            Properties dbproperties = new Properties();
            try {
                dbproperties.load(is);
                fontByteStr = dbproperties.getProperty("fontByteStr").toString();
            } catch (Exception e) {
                //System.err.println("���ܶ�ȡ�����ļ�. " + "��ȷ��fontByte.properties��CLASSPATHָ����·����");
            }
        }
    }
    public static String getFontByteStr() {
        if (fontByteStr == null)
            loads();
        return fontByteStr;
    }
}