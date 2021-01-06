package com.example.tyb.generator;

import lombok.Data;

/**
 * <p>
 * 数据库配置
 * </p>
 *
 * @author whh
 */
@Data
public class DBSetting {
    private String driverName;
    private String userName;
    private String password;
    private String url;
}
