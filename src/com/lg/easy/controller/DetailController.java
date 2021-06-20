package com.lg.easy.controller;

import com.alibaba.fastjson.JSONObject;
import com.lg.easy.dao.LivestockDao;
import com.lg.easy.dao.UserDao;
import com.lg.easy.entity.User;
import com.lg.easy.entity.livestock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;utf-8");

        String n =req.getParameter("n");
        LivestockDao livestockDao =new LivestockDao();
        List<livestock> toN = livestockDao.ShowDetail(Integer.parseInt(n));

        String Result = JSONObject.toJSONString(toN);
        resp.getWriter().println(Result);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
