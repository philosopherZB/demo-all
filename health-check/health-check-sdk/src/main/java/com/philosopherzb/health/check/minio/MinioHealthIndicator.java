package com.philosopherzb.health.check.minio;

import com.philosopherzb.health.check.exception.HealthCheckException;
import io.micrometer.core.instrument.util.StringUtils;
import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Slf4j
public class MinioHealthIndicator extends AbstractHealthIndicator {

    /**
     * 默认文件路径
     */
    private static final String DEFAULT_FILE_PATH = "/temp/";
    /**
     * minio bucket name
     */
    private static final String BUCKET_NAME = "minio-health-check";

    private String filePath;

    private final MinioHealthProperties minioHealthProperties;

    private MinioClient minioClient;

    public MinioHealthIndicator(MinioHealthProperties minioHealthProperties) {
        super("Minio health check failed");
        this.minioHealthProperties = minioHealthProperties;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        this.handle(builder);
    }

    @PostConstruct
    public void init() {
        this.checkAndSet();
        this.minioClient = MinioClient.builder()
                .endpoint(minioHealthProperties.getEndPoint())
                .credentials(minioHealthProperties.getAccessKey(), minioHealthProperties.getSecretKey())
                .build();
    }

    private void handle(Health.Builder builder) {
        try {
            this.createFile();
        } catch (IOException e) {
            log.debug("create file failure, e: ", e);
            builder.unknown().withDetail("endpoint", minioHealthProperties.getEndPoint())
                    .withDetail("message", "create local file failure");
            return;
        }

        try {
            this.makeBucket();
            this.uploadFile();
            Thread.sleep(100);
        } catch (HealthCheckException | InterruptedException e) {
            builder.down(e).withDetail("endpoint", minioHealthProperties.getEndPoint())
                    .withDetail("message", "upload file failure");
            return;
        }

        try {
            this.downloadFile();
        } catch (HealthCheckException e) {
            builder.down(e).withDetail("endpoint", minioHealthProperties.getEndPoint())
                    .withDetail("message", "download file failure");
            return;
        }
        builder.up();
    }


    private void createFile() throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    /**
     * 先判断桶是否存在，不存在则创建桶
     *
     * @throws HealthCheckException HealthCheckException
     */
    private void makeBucket() throws HealthCheckException {
        try {
            boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
            if (!found) {
                // Make a new bucket
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
            }
        } catch (Exception e) {
            log.debug("minIoClient.bucketExists or makeBucket occur exception, e: ", e);
            throw new HealthCheckException(e);
        }
    }

    /**
     * 上传文件
     *
     * @throws HealthCheckException HealthCheckException
     */
    private void uploadFile() throws HealthCheckException {
        try {
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(BUCKET_NAME)
                            .object(minioHealthProperties.getFineName())
                            .filename(filePath)
                            .build());
        } catch (Exception e) {
            log.debug("minIoClient.uploadObject occur exception, e: ", e);
            throw new HealthCheckException(e);
        }
    }

    /**
     * 下载文件
     *
     * @throws HealthCheckException HealthCheckException
     */
    private void downloadFile() throws HealthCheckException {
        try (InputStream stream = minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(BUCKET_NAME)
                        .object(minioHealthProperties.getFineName())
                        .build())) {
            // Read content from stream
            Files.copy(stream, Paths.get(this.filePath), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.debug("minIoClient.getObject occur exception, e: ", e);
            throw new HealthCheckException(e);
        }
    }

    private void checkAndSet() {
        if (StringUtils.isBlank(minioHealthProperties.getEndPoint())) {
            throw new IllegalArgumentException("health.check.minio.endpoint value is empty");
        }
        if (StringUtils.isBlank(minioHealthProperties.getAccessKey())) {
            throw new IllegalArgumentException("health.check.minio.accessKey value is empty");
        }
        if (StringUtils.isBlank(minioHealthProperties.getSecretKey())) {
            throw new IllegalArgumentException("health.check.minio.secretKey value is empty");
        }
        this.filePath = DEFAULT_FILE_PATH + minioHealthProperties.getFineName() + ".txt";
    }
}
