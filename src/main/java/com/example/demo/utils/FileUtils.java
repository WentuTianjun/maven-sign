package com.example.demo.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author liuchen25
 * @description
 * @time 2018/11/2 16:36
 */
public class FileUtils {

    private static final String Root = "/test/store/download";

    public static String uploadFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        InputStream is = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        try {
            is = file.getInputStream();
            // 创建文件夹
            File filePath = new File(Root);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            String saveFileName = Root + "/" + System.currentTimeMillis() + "_" + fileName;


            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(saveFileName);
            byte[] buffer = new byte[1024];
            while (bis.read(buffer) != -1) {
                fos.write(buffer);
            }
            return saveFileName;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(fos);
        }

        return null;
    }

    public static void downloadFile(String fileId, HttpServletResponse response) {
        String fileName = Root + "/" + fileId;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileId, "UTF-8"));


            is = new FileInputStream(fileName);
            bis = new BufferedInputStream(is);
            OutputStream outputStream = response.getOutputStream();

            byte[] buffer = new byte[1024];
            while (bis.read(buffer) != -1) {
                outputStream.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(bis);
        }
    }
}
