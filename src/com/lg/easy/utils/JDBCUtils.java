package com.lg.easy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

//链接数据库的工具
public class JDBCUtils {

    private static DataSource ds;
    //创建数据源（连接池，链接对象）
    public static DataSource getDataSource(){
        if (ds ==null) {
            //面向对象编程（以对象为中心）
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/ry2020");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            //返回连接池
            ds = dataSource;
        }
        return ds;

}
}
