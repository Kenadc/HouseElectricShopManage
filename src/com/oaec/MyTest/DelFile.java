package com.oaec.MyTest;

import java.io.File;

import org.junit.Test;

public class DelFile {

	/*
	 * @Test public void delFile() { file = new File(sPath); // �ж�Ŀ¼���ļ��Ƿ���� if
	 * (!file.exists()) { // �����ڷ��� false return flag; } else { // �ж��Ƿ�Ϊ�ļ� if
	 * (file.isFile()) { // Ϊ�ļ�ʱ����ɾ���ļ����� return deleteFile(sPath); } else { //
	 * ΪĿ¼ʱ����ɾ��Ŀ¼���� return deleteDirectory(sPath); } } }
	 */
	boolean flag = false;
    File file;
	
	public static void main(String[] args) {
		DelFile td = new DelFile();
		String filePath = "E:/upload/586d41e3-36df-4196-8eed-f4dd197b5859T1Jq0gXidvXXXXXXXX.png";
		 System.out.println("1.ɾ�������ļ���");
	        boolean result = td.deleteFile(filePath);
	        if (result) {
	            System.out.println(filePath + "�ļ�ɾ���ɹ���" + result);
	        }
	}
	
	public boolean deleteFile(String filePath) {// ɾ�������ļ�
        flag = false;
        file = new File(filePath);
        if (file.exists() && file.isFile()) {
            file.delete();// �ļ�ɾ��
            flag = true;
        }
        return true;
    }
}
