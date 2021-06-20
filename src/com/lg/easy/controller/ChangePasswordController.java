package com.lg.easy.controller;

import com.lg.easy.dao.FeedDao;
import com.lg.easy.dao.UserDao;
import com.lg.easy.entity.Feed;
import com.lg.easy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changePassword")
public class ChangePasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        String pPassword =req.getParameter("pPassword");

        User obj =new User();
        //Feed obj =new Feed();
        obj.setPassword(pPassword );




        //FeedDao feedDao =new FeedDao();
        UserDao userDao=new UserDao();
        int row =userDao.changePassword(obj);

        if (row>0){
            resp.getWriter().println("修改密码成功");
        }
        else{
            resp.getWriter().println("修改密码失败");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
