package com.example.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UploadFileUtils {
    /**
     * @Description: 获取文件后缀
     */
    public static String getSuffixName(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (!StringUtils.hasText(fileName)) {
            throw new RuntimeException("获取文件后缀失败");
        }
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * @Description: 生成文件名称通用方法
     */
    public static String getNewFileName(String suffixName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        int random = new Random().nextInt(100);
        StringBuilder tempName = new StringBuilder();
        tempName.append(sdf.format(new Date())).append(random).append(suffixName);
        //当前日期时间+两位随机数+文件后缀
        return tempName.toString();
    }
    /**
     * @Description: 获取服务器主机名
     */
    public static URI getHost(URI uri) {
        URI effectiveURI = null;
        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }
}
