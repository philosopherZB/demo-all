package com.philosopherzb.secret.service.dal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.philosopherzb.secret.service.common.util.DateUtils;
import com.philosopherzb.secret.service.web.vo.AppConfigRsaVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Data
@TableName(value = "tb_app_config_rsa")
public class AppConfigRsa implements Serializable {

    private static final long serialVersionUID = -8867210240990137878L;
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 应用id，用于唯一标识应用；生成规则：云服务前缀+雪花算法生成
     */
    private String appId;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * 租户名称
     */
    private String tenantName;
    /**
     * 应用公钥，用于验签接口，同时加密AES秘钥
     */
    private String appPubKey;
    /**
     * 云服务公钥，用于接入方验签
     */
    private String dasPubKey;
    /**
     * 云服务私钥，云服务使用此私钥进行加签
     */
    private String dasPriKey;
    /**
     * 滑动窗口大小
     */
    private Integer encryptSlideSize;
    /**
     * 密文滑窗压缩长度
     */
    private Integer encryptIndexCompressLen;
    /**
     * 伪随机码，生成规则：日期+雪花算法生成
     */
    private String randomNum;
    /**
     * 过期时间，单位：天，默认90天
     */
    private Integer invalidTime;
    /**
     * 最大有效期，单位：天，默认120天；必须大于invalidTime
     */
    private Integer maxInvalidTime;
    /**
     * 删除标识，0-未删除，1-已删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * covert vo
     *
     * @return vo
     */
    public AppConfigRsaVO toVO() {
        AppConfigRsaVO vo = new AppConfigRsaVO();
        BeanUtils.copyProperties(this, vo);
        vo.setCreateTime(DateUtils.dateToStringByDefaultDateFormat(this.createTime));
        vo.setModifyTime(DateUtils.dateToStringByDefaultDateFormat(this.modifyTime));
        return vo;
    }
}
