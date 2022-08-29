package com.philosopherzb.commonutil.mapstruct.constant;

import lombok.Getter;

/**
 * @author philosopherZB
 * @date 2022/8/29
 */
@Getter
public enum Gender {
    MALE("male", "男"),
    FEMALE("female", "女"),
    UNKNOWN("unknown", "未知"),
    ;

    private final String code;

    private final String description;

    Gender(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
