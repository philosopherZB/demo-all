# health-check-sdk 使用手册

### 1、查看自带的健康监测
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
如果项目中有引入spring-cloud-stream-binder-xxx之类的jar，那么其中可能已经编写了对应的服务健康监测，可以先引入上述jar查看  
在配置文件中加入如下内容:  
  _此配置需在项目中的启动yaml中的配置_  
  _禁用所有的监控点_  
  `management.endpoints.enabled-by-default=false`  
  _启用health监控点_  
  `management.endpoint.health.enabled=true`  
  _显示详细内容_  
  `management.endpoint.health.show-details=always`  
随后访问：http://ip:prot//actuator/health 观察是否已经存在对应的中间件健康监测

### 2、定制化的健康监测操作如下所示：
#### 2.1、引入pom
        <dependency>
            <groupId>com.dbappsecurity.cloudpl.mss</groupId>
            <artifactId>health</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        
##### 2.1.1 如果要监测kafka，需额外引入如下pom
        <!-- kafka -->
        <dependency>
            <groupId>org.apache.kafka</groupId>
            <artifactId>kafka-clients</artifactId>
            <version>2.7.0</version>
        </dependency>

##### 2.1.2 如果要监测minio，则需要额外引入如下pom
        <!-- minio -->
        <dependency>
            <groupId>io.minio</groupId>
            <artifactId>minio</artifactId>
            <version>8.0.3</version>
        </dependency>

##### 2.1.3 如果要监测rocketmq，则需要额外引入如下pom
        <!-- rocketmq -->
        <dependency>
            <groupId>org.apache.rocketmq</groupId>
            <artifactId>rocketmq-client</artifactId>
            <version>4.9.1</version>
        </dependency>

##### 2.1.4 如果要监测xxl-job，则需要额外引入如下pom
        <!-- xxl-job -->
        <dependency>
            <groupId>com.xuxueli</groupId>
            <artifactId>xxl-job-core</artifactId>
            <version>2.3.1</version>
        </dependency>

#### 2.2、在配置文件中添加如下内容
##### 2.2.1、在启动应用程序的配置文件中加入如下内容:  
  _此配置需在项目中的启动yaml中的配置_  
  _禁用所有的监控点_  
  `management.endpoints.enabled-by-default=false`  
  _启用health监控点_  
  `management.endpoint.health.enabled=true`  
  _显示详细内容_  
  `management.endpoint.health.show-details=always`  

##### 2.2.2、以下配置可以放在nacos或其他配置中心里
###### 2.2.2.1、kafka 配置
_启动kafka监测_  
`health.check.kafka.enabled=true`  
_kafka地址,此参数必填，格式：master:9092,slave1:9092,slave2:9092_  
`health.check.kafka.server-address=10.50.79.250:9091`  
_kafka监测主题,根据自己项目进行命名。必须存在，否则将无法发送消息至主题或从主题消费消息。_  
_格式：{project-name}-health-check-topic_  
`health.check.kafka.topic=service-plan-health-check-topic`

###### 2.2.2.2、minio 配置
_启动minio监测_  
`health.check.minio.enabled=true`  
_minio 服务地址_  
`health.check.minio.end-point=http://10.50.79.250:9000`  
_access key_  
`health.check.minio.access-key=wfawggehhhwehw`  
_secret key_  
`health.check.minio.secret-key=1231231231`  
_文件名_  
_格式：{project-name}-health-check_  
`health.check.minio.file-name=service-plan-health-check`  

###### 2.2.2.3、rocketmq 配置
_启动rocketmq监测_  
`health.check.rocketmq.enabled=true`  
_rocketmq 服务地址, 格式：master:9876;slave1:9876;slave2:9876_  
`health.check.rocketmq.server-address=10.50.79.236:9876`  
_rocketmq 监测tag, 根据自己项目进行命名_  
_格式：{project-name}-health-check-tag_  
`health.check.rocketmq.tag=service-plan-health-check-tag`  

###### 2.2.2.4、xxl-job 配置
_启动xxl-job监测，注意：xxl-job还需要在xxl-web界面配置一个bean名为healthCheckJobHandler的执行任务，并启动该任务，_  
_其中调度类型可以选择固定速度，值选30（此值应与health.check.xxljob.execute-interval的配置值保持一致）。_  
`health.check.xxljob.enabled=true`  

_注意如果项目中已配置XxlJobSpringExecutor 的bean 则不需要再额外添加以下内容_  
_此配置与正常的xxl-job配置一致_  
`health.check.xxljob.admin-addresses=`  
`health.check.xxljob.access-token=`  
`health.check.xxljob.appname=`  
`health.check.xxljob.address=`  
`health.check.xxljob.ip=`  
`health.check.xxljob.port=`  
`health.check.xxljob.log-path=`  
`health.check.xxljob.log-retention-days=`  


3、源码在health-check-sdk模块中，如果有额外的自定义监测，可以模仿编写

4、该模块引入的spring-boot-starter-actuator已提供常用的健康监测，如db，redis，es等

5、启动时，可以通过接口访问健康状态：http://ip:prot//actuator/health
   注意：此接口需要左安全保证，防止应用数据泄露。
正常内容如下：
```{
    "status": "UP",
    "components": {
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 381826846720,
                "free": 310320566272,
                "threshold": 10485760,
                "exists": true
            }
        },
        "kafka": {
            "status": "UP"
        },
        "minio": {
            "status": "UP"
        },
        "ping": {
            "status": "UP"
        },
        "rocketMQ": {
            "status": "UP"
        },
        "xxljob": {
            "status": "UP"
        }
    }
}```
异常内容如下：
```{
    "status": "DOWN",
    "components": {
        "diskSpace": {
            "status": "UP",
            "details": {
                "total": 381826846720,
                "free": 310320607232,
                "threshold": 10485760,
                "exists": true
            }
        },
        "kafka": {
            "status": "DOWN",
            "details": {
                "topic": "client-health-check-topic",
                "serviceAddress": "123.0.0.1:9092",
                "errorMsg": "received msg not equals expected msg"
            }
        },
        "minio": {
            "status": "DOWN",
            "details": {
                "error": "com.philosopherzb.health.check.exception.HealthCheckException: java.nio.file.FileAlreadyExistsException: \\temp\\temp.txt",
                "endpoint": "https://play.min.io",
                "message": "download file failure"
            }
        },
        "ping": {
            "status": "UP"
        },
        "rocketMQ": {
            "status": "DOWN",
            "details": {
                "topic": "rocketmq-default-health-check-topic",
                "tag": "client-health-check-tag",
                "serviceAddress": "127.0.0.1:9876",
                "errorMsg": "received msg not equals expected msg"
            }
        },
        "xxljob": {
            "status": "DOWN",
            "details": {
                "errorMsg": "time offset too big, standard value:  103"
            }
        }
    }
}```