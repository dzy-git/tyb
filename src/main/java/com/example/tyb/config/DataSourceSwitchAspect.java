package com.example.tyb.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author ChenDong
 * @date 2019/6/17
 */
@Component
@Order(value = -100)
@Slf4j
@Aspect
public class DataSourceSwitchAspect {
    @Pointcut("execution(* com.example.tyb.mapper..*.*(..))")
    private void defaultDBAspect() {
    }
    @Pointcut("execution(* com.example.tyb.cmapper..*.*(..))")
    private void datacenterDBAspect() {
    }

    @Before("defaultDBAspect()")
    public void db1() {
        log.info("切换到defaultDB 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.DEFAULTDB);
    }
    @Before("datacenterDBAspect()")
    public void db2() {
        log.info("切换到datacenterDB 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.DEFAULTDB);
    }


}
