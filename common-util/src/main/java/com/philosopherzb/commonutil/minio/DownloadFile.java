package com.philosopherzb.commonutil.minio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author philosopherZB
 * @date 2021/10/20
 */
@Slf4j
public class DownloadFile {

    private boolean downLoadBigFile() {
        boolean result = false;
        // 待下载的文件地址
        String url = "http://download/file";
        // 文件保存的本地路径
        String targetPath = "d://temp/t/test.zip";
        try {
            String decodeUrl = URLDecoder.decode(url, "utf-8");
            // 定义请求头的接收类型
            RequestCallback requestCallback = request -> request.getHeaders()
                    .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));
            // 对响应进行流式处理而不是将其全部加载到内存中
            ResponseEntity<Boolean> entity = new RestTemplate().execute(decodeUrl, HttpMethod.GET, requestCallback, response -> {
                if (response.getStatusCode() == HttpStatus.OK) {
                    try {
                        Files.createDirectories(Paths.get("d://temp/t"));
                        Files.copy(response.getBody(), Paths.get(targetPath));
                        return ResponseEntity.status(response.getStatusCode()).body(true);
                    } catch (IOException e) {
                        log.error("file copy failure, e: ", e);
                        return null;
                    }
                } else {
                    return null;
                }
            });
            if (entity != null && entity.getStatusCode() == HttpStatus.OK) {
                log.info("download success");
                result = true;
            } else {
                log.warn("download failure");
            }
        } catch (Exception e) {
            log.error("occur exception: ", e);
        }
        return result;
    }
}
