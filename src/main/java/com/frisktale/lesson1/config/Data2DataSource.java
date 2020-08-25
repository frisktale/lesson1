package com.frisktale.lesson1.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = Data2DataSource.PACKAGE, sqlSessionFactoryRef = "Data2SqlSessionFactory")
public class Data2DataSource {
    /**
     * 配置多数据源 关键就在这里 这里配置了不同的数据源扫描不同mapper
     */
    static final String PACKAGE = "com.frisktale.lesson1.dao2";

    /**
     * 连接数据库信息 这个其实更好的是用配置中心完成
     */
    @Value("${data2.datasource.url}")
    private String url;

    @Value("${data2.datasource.username}")
    private String username;

    @Value("${data2.datasource.password}")
    private String password;

    @Value("${data2.datasource.driver-class-name}")
    private String driverClassName;

    @Bean("Data2DataSource")
    public DataSource mfwDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "Data2TransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(mfwDataSource());
    }

    @Bean(name = "Data2SqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("Data2DataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);

        return sessionFactory.getObject();
    }
}
