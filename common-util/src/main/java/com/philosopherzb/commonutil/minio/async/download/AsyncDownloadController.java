package com.philosopherzb.commonutil.minio.async.download;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author philosopherZB
 * @date 2022/6/21
 */
@Slf4j
@RestController
@RequestMapping("/api/test")
public class AsyncDownloadController {

    @GetMapping("/download")
    public StreamingResponseBody handle(HttpServletResponse response) throws IOException {
        return outputStream -> {
            long start = System.currentTimeMillis();
            response.setContentType("application/zip");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".zip");
            try (InputStream inputStream = FileUtils.openInputStream(new File("d://temp/test.zip"))) {
                IOUtils.copy(inputStream, outputStream);
                long end = System.currentTimeMillis();
                log.info("outputStream:{}", outputStream);
                log.info("time:{}", end - start);
            }
        };
    }

}
