package com.oaec.MyTest;

import org.junit.Test;

public class TimeTest {
	public static int time = 60 * 60 * 60;

	public static void main(String[] args) {
		/*
		 * while (time > 0) { time--; try { Thread.sleep(1000); int hh = time / 60 / 60
		 * % 60; int mm = time / 60 % 60; int ss = time % 60; System.out.println("��ʣ" +
		 * hh + "Сʱ" + mm + "����" + ss + "��"); } catch (InterruptedException e) {
		 * e.printStackTrace(); } }
		 */
		int num = 10;
		while (num > 0) {
			num--;
			try {
				Thread.sleep(1000);
				System.out.println("��ʣ" + num + "��");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
