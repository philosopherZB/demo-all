package com.philosopherzb.commonutil.redis.serialno.constant;


/**
 * 批次号枚举类型
 *
 * author: philosopherZB
 * date: 2020/1/8
 *
 * 注：随机号位于流水号之后,流水号使用redis计数，每天都是一个新的key,长度不足时则自动补0
 *
 * 生成规则 =固定前缀+当天日期串+流水号(redis自增，不足长度则补0)+随机数
 */
public enum OrderNoTypeEnum {

    /**
     * 批次流水号：
     * 时间格式：yyyyMMdd
     * 流水号长度：7(当单日单据较多时可根据业务适当增加流水号长度)
     * 随机数长度：3
     * 总长度：24
     */
    DEFAULT_ORDER(ConstantUtil.SERIAL_YYYY_MM_DD_PREFIX, 7, 3, 24);


    /**
     * 时间格式表达式
     * 例如：yyyyMMdd
     */
    private String datePattern;

    /**
     * 批次流水号长度
     */
    private Integer serialLength;
    /**
     * 随机数长度
     */
    private Integer randomLength;

    /**
     * 总长度
     */
    private Integer totalLength;


    OrderNoTypeEnum(String datePattern, Integer serialLength, Integer randomLength, Integer totalLength) {
        this.datePattern = datePattern;
        this.serialLength = serialLength;
        this.randomLength = randomLength;
        this.totalLength = totalLength;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public Integer getSerialLength() {
        return serialLength;
    }

    public Integer getRandomLength() {
        return randomLength;
    }

    public Integer getTotalLength() {
        return totalLength;
    }
}
