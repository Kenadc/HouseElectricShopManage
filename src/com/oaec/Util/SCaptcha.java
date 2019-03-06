package com.oaec.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * ��֤��������
 * 
 */
public class SCaptcha {
    // ͼƬ�Ŀ�ȡ�
    private int width = 120;
    // ͼƬ�ĸ߶ȡ�
    private int height = 40;
    // ��֤���ַ�����
    private int codeCount = 4;
    // ��֤���������
    private int lineCount = 50;
    // ��֤��
    private String code = null;
    // ��֤��ͼƬBuffer
    private BufferedImage buffImg = null;
    //ͳһ��֤��
    public static String scaptcha = "";

    private char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
    // ���������
    private Random random = new Random();

    public SCaptcha() {
        this.createCode();
    }

    /**
     * 
     * @param width ͼƬ��
     * @param height ͼƬ��
     */
    public SCaptcha(int width, int height) {
        this.width = width;
        this.height = height;
        this.createCode();
    }

    /**
     * 
     * @param width ͼƬ��
     * @param height ͼƬ��
     * @param codeCount �ַ�����
     * @param lineCount ����������
     */
    public SCaptcha(int width, int height, int codeCount, int lineCount) {
        this.width = width;
        this.height = height;
        this.codeCount = codeCount;
        this.lineCount = lineCount;
        this.createCode();
    }

    public void createCode() {
        int codeX = 0;
        int fontHeight = 0;
        fontHeight = height - 5;// ����ĸ߶�
        codeX = width / (codeCount + 3);// ÿ���ַ��Ŀ��

        // ͼ��buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // ��ͼ�����Ϊ��ɫ
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // ��������
        ImgFontByte imgFont = new ImgFontByte();
        Font font = imgFont.getFont(fontHeight);
        g.setFont(font);

        StringBuffer randomCode = new StringBuffer();
        // ���������֤���ַ�
        for (int i = 0; i < codeCount; i++) {
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // ����������ɫ
            g.setColor(getRandomColor());
            // ��������λ��
            g.drawString(strRand, (i + 1) * codeX, getRandomNumber(height / 2) + 25);
            randomCode.append(strRand);
        }
        code = randomCode.toString();
    }

    /** ��ȡ�����ɫ */
    private Color getRandomColor() {
        int r = getRandomNumber(255);
        int g = getRandomNumber(255);
        int b = getRandomNumber(255);
        return new Color(r, g, b);
    }

    /** ��ȡ����� */
    private int getRandomNumber(int number) {
        return random.nextInt(number);
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }

    public String getCode() {
        return code;
    }

    /** ������ʽ�� */
    class ImgFontByte {
        public Font getFont(int fontHeight) {
            try {
                Font baseFont = Font.createFont(Font.HANGING_BASELINE, new ByteArrayInputStream(
                        hex2byte(getFontByteStr())));
                return baseFont.deriveFont(Font.PLAIN, fontHeight);
            } catch (Exception e) {
                return new Font("Arial", Font.PLAIN, fontHeight);
            }
        }

        private byte[] hex2byte(String str) {
            if (str == null)
                return null;
            str = str.trim();
            int len = str.length();
            if (len == 0 || len % 2 == 1)
                return null;

            byte[] b = new byte[len / 2];
            try {
                for (int i = 0; i < str.length(); i += 2) {
                    b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
                }
                return b;
            } catch (Exception e) {
                return null;
            }
        }

        // �����ļ���ʮ�������ַ���
        private String getFontByteStr() {
            //��ֹ���ַ������ȹ������󣬸�Ϊ�������ļ���ȡ
            return ReadFontByteProperties.getFontByteStr();
        }
    }
}