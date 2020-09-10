package com.aaa.springboothomestay.util;/*
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfigOne {
    //public static String app_id = "2016101200669322";
    // 商户私钥，您的PKCS8格式RSA2私钥
    //public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCfMO+MVK+InioezbMcb3CIWf10qMze+PtxmJRgB4hhdiy/gN5f/Nsp+OKsghkq4PUocBR3SypKjHCUBpbvGj4gORSARL41JFZcPJVEcBFjf9Oi/DfvMzetBpfPNdN5VYZpLCeDRxV1mGFNK5R9cqGqxjkI9yAYuVEO49u3SApeDuKaZXyRsXWc+ZO1v+WLhumcEkJQHeUm0Zq8LHbF8hiXBazmShh6ZHEDPXeP2mVRIUsgcqjnWRp5Y9mHvBpOstj+l174OQFYZ23mGJXCip1BKglGen0ek1z50SbhJa4SGSR05zgBYHxh+4GyQlUjED2MJyP6REUel0+FOFCg62DZAgMBAAECggEAf5yC60OX0zS3HypWQp0y4JsDCtmmIbgGGPHvP2vKcBaDmKB9owTXy7WwQAmqkyzyWhA+18JxjIE4XfFKXTH0S3B2dryknYUblaUbI1mTFugJh8YYMLAmGZYHbBwCAmoE7ZpvslTxZutYVLxytH2IC5YLcpxoJmmoCP+vyiT96pdMGge9kFMXom6qvXy3G14db7zkp+4eA7J3IA+PARP5U69iZ0jkXSHOVuX3muHIRYC+jD6fToxWDxgwrBBEQf+HAYzwmyxeRsvu0+AsBP+1DEUmGbqrWLM0bVnNqE/av07LOl3PIEPB5gfqBMLDaCuSDL9rOemckrt66okCmAvoAQKBgQDt3I+NMw/+/FUEtMX9kj/o6lXFFuuZlfKBGT6P3nH/plyZTIuWoJ9vchAD6f7UdMY5ZzAY9JZL0FGoQncgGDE1jowMBfKe9fpGFWidPJAJBdjpANK3sok1SWKtjA919O9cnBp/mf/FbrRkcAUqq05CcO4O7c6Fqsktq0pbVabsOQKBgQCrVJo3IvvdW/ahlA+Y4JNnsoEsx0Z1lJyK8nXq4J/5P6zUBq9dN2pGuBmx3DtexXfHoc5gUznCoxOE3jHB3yqfuqNYrSJbbhxHHop4SKQG+khr3X1VSoWCthe4+yBq85mcJDnxXfgJChLqhPREaoIxuD0O//Y+Fhcelh6Lc1lZoQKBgQCzk571FSXwdgShxvDrXazOZYxXfdRlYaVx/eMTrvcV8T1bp0SDdcSo2M5qhhCTyY2V7OeND6sglafwhi11l44fRv1IXn0rsb0/iA4xF3YOudFnJ+3uLeYUytCrAWDyxvanTltbFqLZJZkfcssTyb0NwECaGMOgeq3jwrwidGnPUQKBgQCNioE018P3pcfkyKryA2YDnya0VZTSAoopCBF+jz/Z7E7dgwBRJDy6W9FubKDntH81/2i9j0QCljLD68Rzg+h0uP3FfpMJsbfO0V5X7LsFwLMf2YV3du9Bgymp+l1XvhPDOPJdguIspZPnBxu9gbg5VxmqUK+fryQ+coqdbhf8wQKBgQDAnkedw7NGtZ0O6g8EdSpoKwArIMz6GodPJ5a2A0XuJ4p1gl0WJjQSJdnCny0XEGUwRjSy88+R/UAJ1wnXk6UVEWLZ0BHDnQ6STIMJ8U9nVSNVIl/J0mKkfLI5TaU5pI0t0CAm+CqFOBLpsxdu8rXI5KKa9FgjKnxZmSWkfxHfkg==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    //public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk6q00fXHYHOyV34dP9tn5HQvS3BIWIznmVgRQptJIJIFZKi92bvKrSlOjLamt6wO5nlJDDcObPusR/i1k9nmbdhAjLX1N/oID2uFL/hUYNADh+b6qKHlg/UIcE24kf/svCBfuV7AdOrZ/d2IN5rivs6YFYDEofX3jvwevi4u97pv1RwCNdv5McpdAOtKwiKnxs0YptoLdMFoKWDIDmqrXNBnxfX0aJNJw/VAvk5Pj9qZ49vozralNkfagSn3Xc0Co7nrwfoxDhoD8C36ZW6d9ebl03rEgqtzABDO8aWNzfud4ue/6vDW1GfrSC67mvrQwG5A/zUzaSxWofz5TpIAJQIDAQAB";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101200669322";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCRV0W6UzRY/NwpVinbf6iZ+n2ExDY+5bA4otrQ/pUYHPLa5IbBxtacjvkGEROmiHUoALJMU5zXR/K+bHIk8iltjz1KPRdVR0QMbWDUDChy2SouNrDoQhnIBWsGpEYkoI9rbtBRKNTFfXcpdXlRSj4IqMtuehU/yK6o+hMCLVinWtHhT8JmR3p7Lpyl8tPzVYjC/E7F++ooQrbOZ7wEXOEFhm5HUpsf5UX3rkhdTTVO90zo3D0uYxF3AY7gJfvX1G5lWSPJ/w4AhTzL9jZqj1YgM6GWUz2ovnsPHPnGQ49zlxOJZ0IHauywmY4VWGy1wVjvJsOQPqK/w8uIUz8ZqcazAgMBAAECggEAUYf/mZJrXzAZ4SZwvK1US2x1VTEsrQP0YxEYZv0pbilvItPntHRyl8iscXbK6zTJY/NgEeklpq65wZDcR1WBX/BmlWrH2BLuXXpOQyW+2w5v1xTfEKtkAwznCQbGQm2/hqjXO3AIS/EiE6POtodLXVgzJnpdyTYupKQEXchKXzZ4ppjMru3qdUI7alLSKc4RoLvGQ45xmoxUMJGSjUPcor1aUTBDYHwkpN11ksttIdMw9rYu6P1+K1dzsVi+LfnXc3fTLcHxxHoWTtHmy7MDEyiI2tixGxFQUe3LK4GCrfddVw63E1wKriU878tEPMK5aX3dSb+fHkA0axv1DW5coQKBgQD1ZqT4wY+gYkngDduGjI3/wgAOl+OAQ5scGgl5gum6NCrTSho+pmgcL5bbADCdqKrlv1AU0r28wO+EozMLL7saSOq+fiyNdVp6sWrKK+LvvfnaY1StiyJilU5Z+sh9xMGhnPpolTKqwsBQUFer762/ylENkK5wDSFbmT6QBMJd9wKBgQCXnkgNd9swK3eE4jF0B5pca0OP7cbvP3+zA6eFKrKdu8H1hcuBp0+dejLt57PyqmQA0N5QTjCael6Wcjq4riu6zBRT0jTwaeIgC/KxFk0matXI2MtljrSOGxAu7JDVzUqEdP1dkWTPBNQC4WJSsnmcH2iP7OxNkC9F4VGR9xreJQKBgQCwqfBh1JbdU2Tzk4ZSWqVvVe5MkzQIhqMHnAbuHzy7/ApIibRTHeEdSXVEu+JD3cUKGKxCEWTemdbUmdiJWRdNWOkFsjfIro8wfMDwQp/hD9brTU8MkHl0lyAMzum/AQKUojnzSFVtcT6Zkv1KngVraO7o4RtzN0CofK35aDO1CQKBgDT/QrhSeO9xgimU1yxzq+U6KTeaKbtfOsfcMyY9MoooIzgrOGNtlEq7eCnon+Hm5WXTnKH9csfMlluIOjZryyVUSJa0F4UhvcTt6Ds2TGltVqUKAq7RHxO9Kf78+fOB+tYp/pZCSDaEvYb0OWYmtJN59xa3/jFugNewVs7qzR1xAoGAdk0lsRe8D86Fd+RNJ0FW1/86B8pASBgeGnJveGkKGCs0ZF4CVNTuwxzWvt9MjumFmNvy8HRI4hoTrArMmuanYwZVSh0IjNcEvKll8XAgg8EWBqstSAC6sHShUUpsSEeVClT7Itklx9wX/OgyRihjIokBbZNBA/D/OjWnUlrM7hw=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkVdFulM0WPzcKVYp23+omfp9hMQ2PuWwOKLa0P6VGBzy2uSGwcbWnI75BhETpoh1KACyTFOc10fyvmxyJPIpbY89Sj0XVUdEDG1g1AwoctkqLjaw6EIZyAVrBqRGJKCPa27QUSjUxX13KXV5UUo+CKjLbnoVP8iuqPoTAi1Yp1rR4U/CZkd6ey6cpfLT81WIwvxOxfvqKEK2zme8BFzhBYZuR1KbH+VF965IXU01TvdM6Nw9LmMRdwGO4CX719RuZVkjyf8OAIU8y/Y2ao9WIDOhllM9qL57Dxz5xkOPc5cTiWdCB2rssJmOFVhstcFY7ybDkD6iv8PLiFM/GanGswIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/muniao/test/notify_url.view";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/muniao/test/return_url.view";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
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
