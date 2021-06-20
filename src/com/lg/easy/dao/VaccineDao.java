package com.lg.easy.dao;

import com.lg.easy.entity.Feed;
import com.lg.easy.entity.Vaccine;
import com.lg.easy.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VaccineDao {
    public int publish(Vaccine vaccine){
        DataSource dataSource = JDBCUtils.getDataSource();

        QueryRunner runner = new QueryRunner(dataSource);
        String sql="insert into vaccine(vaccine,staff_name,stock_number,time) values(?,?,?,?)";
        //获取当前时间
        Date ss= new Date();
        SimpleDateFormat format0=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format0.format(ss.getTime());

        String name = System.getProperty("Name");
        try {
            int row =runner.update(sql,vaccine.getVaccine(),name,vaccine.getStock_number(),time);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public int change(Vaccine vaccine){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner = new QueryRunner(dataSource);
        String sql ="update livestock set vaccine = ? where number = ?";

        try {
            int row =runner.update(sql,vaccine.getVaccine(),vaccine.getStock_number());
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }
}
