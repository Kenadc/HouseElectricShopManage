package com.oaec.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�޸����ڣ�2017-04-05
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {
	
//�����������������������������������Ļ�����Ϣ������������������������������

	// Ӧ��ID,����APPID���տ��˺ż�������APPID��Ӧ֧�����˺�
    public static String app_id = "2016091900549394";
    // �̻�˽Կ������PKCS8��ʽRSA2˽Կ
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC0jrGtS7Gl1T4cnWBupbxLSPSzzTBLC/zEPZdSCAhrGNHdcrHeZa2GEb9JwhHsz5ZmQonocFTZasoQ50/tvmfH0hFUkzfbzRi+a2jmLflMXsQAupIJY1c1FVaFOYCiH/1wOfU/BdUm52prFSEt1B3777oxvH8qPZyAF3Chpj/1gmKkQyh3MAICbqEdvF0NS2aQJZjQhs7QNvCyKu2Ki3l3Ec13zR7xJO976HpdK9hClLEtkLbAQEPqjfWwPdMvHH2hoCJfQ/QQaMDyeW5MXZmc+k4rzl9Gf9v9i2N19+dmAIo5YzZQUjuYg6oLi8K6YQt0bFG6WJp3InWz0l2yFxS1AgMBAAECggEAf07RhpAFfRkDB2gLs1iWkDqrlw9JStDz82Y+CK/zR5gjeVHCij4FALAIwTfeLawcrpOh60sw+G+sdAi0ubv0Ltc2MvzueMN++9x+BTZLPgbfimgCSi5KMfqOm7b0tNt7diLXgg1ZwmmPBlvKniae0aGxFhqDS0RP0Z01ZDT1ieOq/Ko2WqCNWAiangLgiv234rBBcKuLwvX4fwl6A96vWwbSlGyeSxFsJward18SkIn78rbYL9Vp8SXSbS7z+WPHAWw009z2+FCni+fHe1e/HlHay0DprzPPG53yCMez5xN0Sd5Sg3UYJwPSlxAnQ3c/Mrm4K85m8LIkwB0UMwWsAQKBgQDXYh+c+R6oxscTI0hZzJBgZkDLH6MXCk3tuv131oPoJTkjVOJVsfpm74wOn9F350/9cmhkcMwuHC3ZLpbD/mXrti8XmK+NWU6+tvP8KJyzP0NrzNy91eGaNCMkxG2jMx/A76Zuz2XHU6wHTGGYQlnagvcIsIQQ2RH/CIliYa/3AQKBgQDWm09xsX8dGR4/Ge3Rkgjq9bNAqfnCYo/he0CfXMrH8Mzk6M0LDZtBZ/Pr+ZICiE5PtQxIrZHp/gsVx+MePDL1XjJpFWHpASblSFx933Acw29x2hhd8eR22jzRgwWUGThbE/7etN/1PwJAgAxi5uGv2s+WsLiPzhzX1DivyqZxtQKBgQCqNToEY/6tpEDIR/ayOG3UMJp9qyfIWnVRLJeIL7cYKupnmHow/LCEzkOhfv0bQ2o8QUBsN5Oz0MMOwbmVc6J5zwSSIjCBhJUtNAnGORX0tUcDlubPAooBwbgQI0b9VLaAUyL0qOOmzOHC9sKdf7nga+TrMgt8AP8uy0E+xTI5AQKBgEyW3xJnU0MyPK4udcZuRMp953wzbVRnUowZLaXyOtiCYs1rHApOz9LW46GazvYiaThfF8Q0VbfZl2EtliurNlCFTp5cKDY82AHKAmBVxrAtO2+5cyrL8kpMdpobFXmWSpuOlk4q5SakVwxn5oPBfFgDUkSoSyXfXEHWlmh+fUplAoGAOa8RYDDpHxmo/reYXcbCsaZstG1tBJk9C3ffQs/mHQAJhUb3UGERkbE386jLmccEQCyl6TQuJy8Dg/ekXPrQHdDSlKkd4smFPhI34ZVhU2WGFwGk0OOvd1yLrco903rzUj+mG5yELIYPV4zRpBfwURclAXai0HYql0nLMbqDZRs=";


    // ֧������Կ,�鿴��ַ��https://openhome.alipay.com/platform/keyManage.htm ��ӦAPPID�µ�֧������Կ��
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvVNtDjs+6uoYpemctn7qw0qJRPBm6MFNoWkG92GllCsNrmfs7ZXDn6BAUZGKsH80bOnqljdInC1t4Jq7x+4WToSRgSivx9QchJg/NrVLtdTAs202pVJgPJH5oP/X3nc++XcZEd65yJhiwmiGSP053VVmrod1UbkPBmeGgmQCBJlWSwYLYb2aS8vE6e951+LmTahC44MJBLUlc0l9UCctI5Bv4Zc7SzOSw4DEsQGn3u3henD8XpJPc24J1qxUEVfrP/EcVjiM8TC/Uv6wI+wRfQT8xz8SRpgDl3aYxWouKHjxOQzjsyfv3SQoBRM+lZThesAtz7ZMeDhTKWuTYWa7yQIDAQAB";

    // �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
    public static String notify_url = "http://localhost:8080/HouseElectricShop/notify_url.jsp";

    // ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
//    public static String return_url = "http://localhost:8080/HouseElectricShop/order/insert.action";
    public static String return_url = "http://localhost:8080/HouseElectricShop/return_url.jsp";

    // ǩ����ʽ
    public static String sign_type = "RSA2";

    // �ַ������ʽ
    public static String charset = "utf-8";

    // ֧��������
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // ֧��������
    public static String log_path = "E:\\";


    /**
     * д��־��������ԣ�����վ����Ҳ���ԸĳɰѼ�¼�������ݿ⣩
     * @param sWord Ҫд����־����ı�����
     */
    public static void logResult(String sWord ) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

