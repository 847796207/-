package com.lg.easy.dao;

import com.lg.easy.entity.Feed;
import com.lg.easy.entity.livestock;
import com.lg.easy.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LivestockDao {
    public List<livestock> findToN(int n) {
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from livestock limit ?";
        try {
            List<livestock> list = runner.query(sql, new BeanListHandler<>(livestock.class), n);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<livestock> findByPage(String page, String keywords) {
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from livestock where  concat(regin,category,number)  like concat('%',?,'%') limit ?,2";
        String sql1 = "select * from livestock limit ?,5";


        if (keywords == null || "".equals(keywords)) {
            List<livestock> livestock =null;
            try {
                livestock = runner.query(sql1, new BeanListHandler<>(livestock.class), (Integer.parseInt(page) - 1) * 2);
                return livestock;


            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;


        } else {
            List<livestock> livestock =null;
            try {
                livestock = runner.query(sql, new BeanListHandler<>(livestock.class), keywords, (Integer.parseInt(page) - 1) * 2);
                return livestock;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    public List<livestock> ShowDetail(int n){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from livestock where id = ?";
        try {
            List<livestock> list = runner.query(sql, new BeanListHandler<>(livestock.class), n);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int addNewAnimal(livestock livestock){
        DataSource dataSource = JDBCUtils.getDataSource();

        QueryRunner runner = new QueryRunner(dataSource);
        String sql="insert into livestock(weight,regin,category,number,origin,avater,feed) values(?,?,?,?,?,?,?)";



        try {
            int row =runner.update(sql,livestock.getWeight(),livestock.getRegin(),livestock.getCategory(),livestock.getNumber(),livestock.getOrigin(),livestock.getAvater(),livestock.getFeed());
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public List<livestock> PCShowLivestock(){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql = "select * from livestock";
        try {
            List<livestock> list = runner.query(sql, new BeanListHandler<>(livestock.class));
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}