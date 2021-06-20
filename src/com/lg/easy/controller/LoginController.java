package com.lg.easy.controller;

import com.alibaba.fastjson.JSONObject;
import com.lg.easy.dao.UserDao;
import com.lg.easy.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")

public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");




        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userdao = new UserDao();
        User user = userdao.login(username, password);

        user.setPassword(null);
        if (user != null) {
            String jsonString = JSONObject.toJSONString(user);
            resp.getWriter().println(jsonString);
        } else
            {
            resp.getWriter().println("400");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

