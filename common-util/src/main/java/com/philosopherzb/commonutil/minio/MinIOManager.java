package com.philosopherzb.commonutil.minio;

import com.alibaba.fastjson.JSONObject;
import io.minio.BucketExistsArgs;
import io.minio.DownloadObjectArgs;
import io.minio.GetObjectArgs;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.ListObjectsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.RemoveBucketArgs;
import io.minio.RemoveObjectsArgs;
import io.minio.Result;
import io.minio.UploadObjectArgs;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author philosopherZB
 * @date 2021/4/5
 */
@Slf4j
@Component
public class MinIOManager {

    @Resource
    private MinIOUtils minIOUtils;

    public static void main(String[] args) throws Exception {
        MinioClient minioClient = MinioClient.builder()
                .endpoint("http://localhost:9001")
                .credentials("admin", "admin")
                .build();
        MinIOManager minIOManager = new MinIOManager();
//        minIOManager.removeBucket("20210407001", minioClient);

//        minIOManager.makeBucket("testName", minioClient);
//        minIOManager.uploadFile("testName", "20210915597931155856715776.zip", "d://temp/test.zip", minioClient);

//        System.out.println(minIOManager.getDownloadUrl("testName","t003V2.3.6.tar",minioClient));

//        List<String> list = minIOManager.getObjectNamesByBucketName("testName", minioClient);
//        System.out.println(JSONObject.toJSONString(list));
//        for (String objectName : list) {
//            try (InputStream inputStream = minIOManager.downloadFile("20210407002", objectName, minioClient)) {
//                log.info("====>:{}", inputStream);
//            }
//        }

//        minIOManager.downLoadToFile("20210407001","test20210407001.log","LOG_HOME_IS_UNDEFINED/my-object-file.log",minioClient);
        System.out.println(JSONObject.toJSONString(minIOManager.getBucketNames(minioClient)));
    }

    /**
     * 获取指定前缀的所有桶名
     *
     * @return 桶名列表
     */
    public List<String> getBucketNames(MinioClient minioClient) {
        List<String> list;
        try {
            list = minioClient.listBuckets().stream()
//                    .filter(bucket -> bucket.name().startsWith("agent-troubleshoot-logs"))
                    .map(Bucket::name)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("MinIOManager.getBucketNames, minIoClient.listBuckets occur exception, e:{}", e);
            return null;
        }
        return list;
    }

    /**
     * 获取对象流
     *
     * @param bucketName 桶名
     * @param objectName 对象名
     * @return 输入流
     */
    public InputStream downloadFile(String bucketName, String objectName, MinioClient minioClient) {
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build())) {
            // Read content from stream
            File targetFile = new File("log/zip/targetFileTmp.zip");
            FileUtils.copyInputStreamToFile(stream, targetFile);
            return stream;
        } catch (Exception e) {
            log.error("MinIOManager.downloadFile, minIoClient.getObject occur exception, e:{}", e);
            return null;
        }
    }

    /**
     * 获取指定桶名下所有对象名
     *
     * @param bucketName 桶名
     * @return 指定桶中所有对象的名称
     */
    public List<String> getObjectNamesByBucketName(String bucketName, MinioClient minioClient) {
        List<String> list = new ArrayList<>();
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder()
                            .bucket(bucketName)
                            .build());
            for (Result<Item> result : results) {
                log.info("name:{}", result.get().objectName());
                list.add(result.get().objectName());
            }
        } catch (Exception e) {
            log.error("MinIOManager.getObjectNamesByBucketName, minIoClient.listObjects occur exception, e:{}", e);
        }
        return list;
    }

    /**
     * 上传文件至minIO服务器
     *
     * @param bucketName 桶名
     * @param objectName 对象名，包含后缀名，例如：test-2021.zip
     * @param fileName   文件名，相对路径，包含后缀名，例如：/home/user/Photos/test.zip
     */
    void uploadFile(String bucketName, String objectName, String fileName, MinioClient minioClient) {
        try {
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(fileName)
                            .build());
            log.info("uploadObject success");
        } catch (Exception e) {
            log.error("MinIOManager.uploadFile, minIoClient.uploadObject occur exception, e:{}", e);
        }
    }


    /**
     * 先判断桶是否存在，不存在则创建桶
     *
     * @param bucketName 桶名
     */
    void makeBucket(String bucketName, MinioClient minioClient) {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                // Make a new bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                log.info("bucket make success");
            } else {
                log.info("bucket exist");
            }
        } catch (Exception e) {
            log.error("MinIOManager.makeBucket, minIoClient.bucketExists or makeBucket occur exception, e:{}", e);
        }
    }

    /**
     * 先判断桶是否存在，存在则移除指定桶
     *
     * @param bucketName 桶名
     */
    void removeBucket(String bucketName, MinioClient minioClient) {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (found) {
                List<String> objectNames = getObjectNamesByBucketName(bucketName, minioClient);
                if (CollectionUtils.isNotEmpty(objectNames)) {
                    if (!removeObjects(bucketName, objectNames, minioClient)) {
                        log.info("objects remove fail");
                        return;
                    }
                }
                minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
                log.info("bucket remove success");
            } else {
                log.info("bucket not exist");
            }
        } catch (Exception e) {
            log.error("MinIOManager.removeBucket, minIoClient.removeBucket occur exception, e:{}", e);
        }
    }

    void downLoadToFile(String bucketName, String objectName, String fileName, MinioClient minioClient) throws Exception {
        minioClient.downloadObject(
                DownloadObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .filename(fileName)
                        .build());
    }

    private boolean removeObjects(String bucketName, List<String> objectNames, MinioClient minioClient) {
        List<DeleteObject> objects = new LinkedList<>();
        for (String objectName : objectNames) {
            objects.add(new DeleteObject(objectName));
        }
        Iterable<Result<DeleteError>> results =
                minioClient.removeObjects(
                        RemoveObjectsArgs.builder()
                                .bucket(bucketName)
                                .objects(objects)
                                .build());
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Result<DeleteError> result1 : results) {
                DeleteError error = result1.get();
                stringBuilder.append("[")
                        .append(error.objectName())
                        .append("]:")
                        .append(error.message())
                        .append(";");
            }
            if (StringUtils.isNotEmpty(stringBuilder.toString())) {
                log.info("Error in deleting, errorMsg:{} ", stringBuilder.toString());
                return false;
            }
            log.info("objects remove success");
        } catch (Exception e) {
            log.error("e:", e);
            return false;
        }
        return true;
    }

    public String getDownloadUrl(String bucketName, String objectName, MinioClient minioClient) {
        String url = "";
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (!found) {
                // Make a new bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                log.info("bucket make success");
                return url;
            }
            url = minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucketName)
                            .object(objectName)
                            .expiry(2, TimeUnit.HOURS)
                            .build());
        } catch (Exception e) {
            log.error("e:", e);
        }
        return url;
    }
}
