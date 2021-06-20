package com.lg.easy.dao;

import com.lg.easy.entity.Feed;
import com.lg.easy.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedDao {

    public int publish(Feed feed){
        DataSource dataSource = JDBCUtils.getDataSource();

        QueryRunner runner = new QueryRunner(dataSource);
        String sql="insert into daily_feed(feed_number,name,feed_time,food,new_weight) values(?,?,?,?,?)";
        //获取当前时间
        Date ss= new Date();
        SimpleDateFormat format0=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format0.format(ss.getTime());

        String name = System.getProperty("Name");
        try {
            int row =runner.update(sql,feed.getFeed_number(),name,time,feed.getFood(),feed.getNew_weight());
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }
    public int change(Feed feed){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql ="update livestock set feed = 'yes' ,weight = ? where number = ?";

        try {
            int row =runner.update(sql,feed.getNew_weight(),feed.getFeed_number());
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

}
