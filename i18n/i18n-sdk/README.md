# i18n-sdk 使用手册

### 1.引入依赖
        <dependency>
            <groupId>com.philosopherzb</groupId>
            <artifactId>i18n-sdk</artifactId>
             <version>1.0.0-SNAPSHOT</version>
        </dependency>

### 2.使用-->(可参考i18n-client工程)
#### 2.1 配置文件在本地
* 在resource目录下创建 messages_en_US.properties, messages_zb_CN.properties
* 在配置文件中输入中英文配置信息
* 项目的application.properties配置文件中需要加入:  
    `spring.main.allow-bean-definition-overriding=true`  
    _其中i18n为resources下的文件目录，messages是第一步中的properties前缀_  
    `spring.messages.basename=classpath:i18n/messages`  
* 代码中使用: MessageUtil.get("key"); MessageUtil.get("key", "params"); 
* 测试使用，通过在请求头信息中添加如下信息:  
    `[{"key":"Accept-Language","value":"en_US","description":"英文","type":"text","enabled":true}]`  
    `[{"key":"Accept-Language","value":"zh_CN","description":"中文","type":"text","enabled":true}]`

#### 2.2 配置文件在nacos
        <dependency>
            <groupId>com.alibaba.nacos</groupId>
            <artifactId>nacos-client</artifactId>
        </dependency>
* 如上引入nacos依赖
* 项目的application.properties配置文件中需要加入:  
    `spring.main.allow-bean-definition-overriding=true`  
    _mode 表示i18n模式，local为本地，nacos为nacos配置中心，默认为local_  
    `spring.messages.mode=nacos`  
    _存储i18n的文件目录，默认为 i18n/_  
    `spring.messages.baseFolder=i18n/`  
    _此值与nacos中的配置信息需保持一致，且为必填。若为空则会抛出spring.messages.basename value is empty的异常信息。_  
    `spring.messages.basename=user-message`  
    _nacos的地址，为必填。若为空则会抛出spring.messages.serverAddress value is empty的异常信息。_  
    `spring.messages.serverAddress=127.0.0.1:8848`  
    _nacos的namespace值，为必填。若为空则会抛出spring.messages.namespace value is empty的异常信息。_  
    `spring.messages.namespace=e52f0660-c859-4762-b0f4-4f6f17727d59`  
* 代码中使用: MessageUtil.get("key"); MessageUtil.get("key", "params"); 
* 测试使用，通过在请求头信息中添加如下信息:  
    `[{"key":"Accept-Language","value":"en_US","description":"英文","type":"text","enabled":true}]`  
    `[{"key":"Accept-Language","value":"zh_CN","description":"中文","type":"text","enabled":true}]`  

### 3.自动捕获javax.validation.constraints中的message作为国际化输出-->(可参考i18n-client工程)
#### 3.1 全局异常捕获
* 可查看 i18n-client 工程中的 com.philosopherzb.i18n.client.advice.handler.GlobalExceptionHandler  

#### 3.2 通用型validation配置
* 可查看 i18n-client 工程中的 com.philosopherzb.i18n.client.advice.config.CommonValidationConfig 类  
* 此配置器对于 javax.validation.constraints 中的message的格式要求为el形式
* eg:  @NotBlank(message = "{PARAM_INVALID}")
* eg:  @NotBlank(message = "prefix-{PARAM_INVALID}-suffix")
* 其中 PARAM_INVALID 为国际化配置文件中的key; 在花括号的左右两边可以输入额外的参数  

#### 3.3 定制化validation配置
* 可查看 i18n-client 工程中的 com.philosopherzb.i18n.client.advice.config.CustomValidationConfig 类 
* 此配置器对于 javax.validation.constraints 中的message的格式要求为el形式，或者定制化分隔符
* eg:  @NotBlank(message = "{PARAM_INVALID}")
* eg:  @NotBlank(message = "prefix-{PARAM_INVALID}-suffix")
* 其中 PARAM_INVALID 为国际化配置文件中的key; 在花括号的左右两边可以输入额外的参数  

* eg:  @NotBlank(message = I18nConstant.PARAM_IS_NULL_BY_SEPARATE + "orderSource")
* 其中 18nConstant.PARAM_IS_NULL_BY_SEPARATE 是一个组合字符串，由 PARAM_IS_NULL_BY + SEPARATE构成
* PARAM_IS_NULL_BY为配置文件中的key，而orderSource则为对应的字段名