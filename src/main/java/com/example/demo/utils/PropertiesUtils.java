package com.example.demo.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * @author liuchen25
 * @description
 * @time 2018/11/2 13:47
 */
public class PropertiesUtils {

    /**
     * @param key    配置项的key
     * @param params 需要传入的参数
     * @return
     */
    public static String getConfig(String key, String... params) {
        InputStream is = null;

        try {
            is = PropertiesUtils.class.getClassLoader().getResourceAsStream("config/conf.properties");
            Properties properties = new Properties();
            properties.load(is);

            String result = properties.getProperty(key);
            String msg = MessageFormat.format(result, params);
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

    public static void main(String[] args) {
        String key = "config_test";
        String s1 = "water";
        String s2 = "sleep";
        String config = PropertiesUtils.getConfig(key, s1, s2);
        System.out.println(config);
    }

}
