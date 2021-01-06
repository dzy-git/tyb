package com.example.tyb.config;

import lombok.Getter;

/**
 *
 * @author ChenDong
 * @date 2019/6/17
 */
public enum DBTypeEnum {
    DEFAULTDB("defalut", "主库默认库"),
    DATACENTERDB("datacenter","从数据库"),
    TYBREPORTDB("tybreport", "统计库");
    @Getter
    private String type;
    @Getter
    private String name;

    DBTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }
}
