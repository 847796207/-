package com.lg.easy.dao;

import com.lg.easy.entity.User;
import com.lg.easy.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import sun.util.resources.cldr.rof.CalendarData_rof_TZ;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDao {
    public User login(String staff_number, String pwd){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner= new QueryRunner(dataSource);
        String sql ="select * from staff where staff_number=? and password=?";

        try {
            User user = runner.query(sql,new BeanHandler<>(User.class),staff_number,pwd);
            System.setProperty("Name",user.getName());
            System.setProperty("StaffId",user.getStaff_number());
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;

    }

    public int regist(String staff_number, String pwd){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner =new QueryRunner(dataSource);
        String sql="insert into staff(staff_number,password) values(?,?)";

        try {
            int row =runner.update(sql,staff_number,pwd);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public User findByUsername(String name){
        DataSource dataSource = JDBCUtils.getDataSource();
        QueryRunner runner =new QueryRunner(dataSource);
        String sql= "select * from staff where staff_number=?";
        try {
            User user =runner.query(sql,new BeanHandler<>(User.class),name);

            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int changePassword(User user){
        DataSource dataSource = JDBCUtils.getDataSource();

        QueryRunner runner = new QueryRunner(dataSource);
        String sql ="UPDATE staff SET password= ?  WHERE staff_number=?";
        try {
            String Staff_number = System.getProperty("StaffId");
            int row =runner.update(sql,user.getPassword(),Staff_number);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }
}
