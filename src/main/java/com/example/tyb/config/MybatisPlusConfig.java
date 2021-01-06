package com.example.tyb.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class MybatisPlusConfig {
    /**
     * 分页
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 乐观锁
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean(name = "defaultDBDataSource")
    @ConfigurationProperties(prefix = "datasource.default")
    public DataSource defaultDB() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "datacenterDBDataSource")
    @ConfigurationProperties(prefix = "datasource.datacenter")
    public DataSource datacenterDB() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 动态数据源配置
     *
     * @return
     */
    @Bean
    @Primary
    public DataSource multipleDataSource(@Qualifier("defaultDBDataSource") DataSource defaultDBDataSource,
                                         @Qualifier("datacenterDBDataSource") DataSource datacenterDBDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(4);
        targetDataSources.put(DBTypeEnum.DEFAULTDB.getType(), defaultDBDataSource);
        targetDataSources.put(DBTypeEnum.DATACENTERDB.getType(), datacenterDBDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(defaultDBDataSource);
        return dynamicDataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(multipleDataSource(defaultDB(),datacenterDB()));

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);

        sqlSessionFactory.setConfiguration(configuration);

        List<Resource> resourceList = new ArrayList<>();
        resourceList.addAll(Arrays.asList(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml")));
        resourceList.addAll(Arrays.asList(new PathMatchingResourcePatternResolver().getResources("classpath:/cmapper/*.xml")));
//        resourceList.addAll(Arrays.asList(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*.xml")));
        Resource[] resources = resourceList.toArray(new Resource[0]);
        sqlSessionFactory.setMapperLocations(resources);
        sqlSessionFactory.setTypeAliasesPackage("com.example.tyb.mapper.*,com.example.tyb.cmapper.*");

        //PerformanceInterceptor(),OptimisticLockerInterceptor()
        //添加分页功能
        sqlSessionFactory.setPlugins(new Interceptor[]{
                paginationInterceptor()
        });
//        sqlSessionFactory.setGlobalConfig(globalConfiguration());
        return sqlSessionFactory.getObject();
    }

}
