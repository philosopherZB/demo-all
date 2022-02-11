package com.philosopherzb.secret.service.dal.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.philosopherzb.secret.service.common.util.DateUtils;
import com.philosopherzb.secret.service.web.vo.AppConfigAesVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Data
@TableName(value = "tb_app_config_aes")
public class AppConfigAes implements Serializable {
    private static final long serialVersionUID = 4001145094825172625L;
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
     * aes秘钥,固定长度
     */
    private String aesKey;
    /**
     * 版本号，用于升级aesKey
     */
    private Long secretVersion;
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
    public AppConfigAesVO toVO() {
        AppConfigAesVO vo = new AppConfigAesVO();
        BeanUtils.copyProperties(this, vo);
        vo.setCreateTime(DateUtils.dateToStringByDefaultDateFormat(this.createTime));
        vo.setModifyTime(DateUtils.dateToStringByDefaultDateFormat(this.modifyTime));
        return vo;
    }
}
