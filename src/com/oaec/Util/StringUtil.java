package com.oaec.Util;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

public class StringUtil {
	private final static String[] seed = new String[] { "A", "B", "C", "D",
			"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
			"r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3",
			"4", "5", "6", "7", "8", "9" };
	
	private final static String[] seedNum = new String[] {"0", "1", "2", "3","4", "5", "6", "7", "8", "9" };

	public static String getRandom(int length) {
		int index;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			index = (int) (new Random().nextFloat() * seed.length);
			result.append(seed[index]);
		}
		return result.toString();
	}
	
	public static String getRandomNum(int length) {
		int index;
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			index = (int) (new Random().nextFloat() * seedNum.length);
			result.append(seedNum[index]);
		}
		return result.toString();
	}
	
	
	/*************************************************************
	 * add laizhengyu 2014-07-04
	 * ��Сд���ת��Ϊ��д���Ľ��
	 * @param amount
	 * @return
	 */
	public static String convertToCapitalMoney(BigDecimal _amount){ 
		
		String str = ""; 
		String number[] = new String[]{"�� ","Ҽ ","�� ","�� ","�� ","�� ","½ ","�� ","�� ","�� "}; 
		String units[] = new String[]{"Բ","ʰ","��","Ǫ","��","ʰ","��","Ǫ","��","ʰ","��","Ǫ"}; 
		
		double temp = _amount.doubleValue();
		double amount = _amount.doubleValue();
		if(temp<0) {
			temp = temp * -1;
		}
		if(amount < 0) {
			amount = amount * -1;
		}
		int i = 0; 
		
		//�������� 
		while(temp >= 10){ 
			int n = (int)(temp % 10); 
			temp = temp / 10L; 
			str = str.trim()+units[i++].trim()+number[n].trim(); 
		}
		
		str = str.trim()+units[i++].trim()+number[(int)temp].trim(); 
		StringBuffer sb = new StringBuffer(str.trim()); 
		sb.reverse();
		str = sb.toString(); 
		
		//С������ 
		int dolt1 = (int)((amount+0.005)*100%10);//�� 
		int dolt2 = ((int)((amount+0.005)*100%100))/10;//�� 
		
		if(dolt1 == 0 && dolt2 == 0) {
			str = str +"��";
		} else if(dolt1 != 0) { 
			if(dolt2 != 0) {
				str = str + number[dolt2].trim()+"��"+number[dolt1].trim()+"��"; 
			} else str = str + "��"+number[dolt1].trim()+"��"; 
		} else if(dolt2 != 0){ 
			str = str + number[dolt2].trim()+"��";
		} 
		
		//ȥ������ĺ��ֲ��ں��ʵ�λ�ü����� 
	    while(str.indexOf("����")!= -1 ||str.indexOf("����")!= -1 ||str.indexOf("��Ǫ")!= -1 
		    ||str.indexOf("���")!= -1 ||str.indexOf("��ʰ")!= -1 
		    ||str.indexOf("��Բ")!= -1 ) { 
	    	
			    str = str.replaceAll("����", "��"); 
			    str = str.replaceAll("����", "��"); 
			    str = str.replaceAll("��Ǫ", "��"); 
			    str = str.replaceAll("���", "��"); 
			    str = str.replaceAll("��ʰ", "��"); 
			    
			    str = str.replaceAll("������", "��");
			    str = str.replaceAll("����", "��");
			   
			    if(str.startsWith("��Բ")) 
			    	str = str.replaceAll("��Բ", ""); 
			    else str = str.replaceAll("��Բ", "Ԫ"); 
	    }
	    
	    if(str.indexOf("����") != -1){ 
	    	str = str.replaceAll("����", "��"); 
	    } 
	    
	    if(str.indexOf("��Ǫ") != -1){ 
	    	str = str.replaceAll("��Ǫ", "��"); 
	    } 
	    
	    if(str.indexOf("����") != -1){ 
	    	str = str.replaceAll("����", "��"); 
	    }
	    
	    if(_amount.floatValue() < 0) {
	    	str = "��" + str;
	    }
		
	    return str; 
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
//	public static void main(String[] args) {
//		System.out.println(StringUtil.getRandomNum(4));
//	}
}
